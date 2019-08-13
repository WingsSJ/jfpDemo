package com.demo.grpc.server;

import com.demo.grpc.annotation.GrpcInterceptor;
import com.demo.grpc.interceptor.BaseServerInterceptor;
import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.*;

/**
 * @auther jasonx
 * @create 5/21/18 5:22 PM
 **/
@Component
@Slf4j
public class GrpcServer {

    @Autowired
    private List<BindableService> services;

    @Autowired
    private ApplicationContext context;

    private Server grpcServer;

    @PostConstruct
    public void startGrpcServer() throws IOException {
        int port = 50121;

        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(port);

//        serverBuilder.intercept(new UnknownStatusDescriptionInterceptor());
        for (BindableService service : services) {

            GrpcInterceptor grpcInterceptor = AnnotationUtils.findAnnotation(service.getClass(), GrpcInterceptor.class);
            if (grpcInterceptor != null) {

                String[] methods = grpcInterceptor.exclusiveMethods();
                Set<String> methodSet=new HashSet<>(Arrays.asList(methods));

                List<ServerInterceptor> interceptors = new ArrayList<>();
                for (Class<? extends ServerInterceptor> interceptorClass : grpcInterceptor.interceptors()) {
                    BaseServerInterceptor interceptor = (BaseServerInterceptor) context.getBean(interceptorClass);
                    interceptor.setExclusiveMethods(methodSet);
                    interceptors.add(interceptor);
                }

                serverBuilder.addService(ServerInterceptors.intercept(service, interceptors));

            } else {
                serverBuilder.addService(service);
            }
        }


        grpcServer = serverBuilder.build();

        grpcServer.start();
        log.info("gRPC Server started, listening on {}", port);
        log.info("gRPC Server started, sockets {}" , grpcServer.getListenSockets());
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                stopGrpcServer();
                log.info("gRPC Server stopped.");
            }
        });
    }

    @PreDestroy
    public void stopGrpcServer() {
        if (grpcServer != null) {
            grpcServer.shutdown();
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (grpcServer != null) {
            grpcServer.awaitTermination();
        }
    }
}
