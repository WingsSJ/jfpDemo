package com.demo.grpc.interceptor;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.protobuf.ProtoMethodDescriptorSupplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.util.Set;


@Slf4j
public abstract class BaseServerInterceptor implements ServerInterceptor {

    private Set<String> exclusiveMethods;


    protected static final ServerCall.Listener NOOP_LISTENER = new ServerCall.Listener() {
    };

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {

        if(log.isDebugEnabled()){
            log.debug("mobile token interceptCall begin");
        }
        ProtoMethodDescriptorSupplier schemaDescriptor = (ProtoMethodDescriptorSupplier) call.getMethodDescriptor().getSchemaDescriptor();
        String method = schemaDescriptor.getMethodDescriptor().getName();
        if(!ObjectUtils.isEmpty(exclusiveMethods) && exclusiveMethods.contains(method)){
            return  next.startCall(call,headers);
        }


        return toChildInterceptCall(call,headers,next);

    }

    protected abstract <ReqT, RespT> ServerCall.Listener<ReqT> toChildInterceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT,RespT> next);


    public void setExclusiveMethods(Set<String> exclusiveMethods) {
        this.exclusiveMethods = exclusiveMethods;
    }
}
