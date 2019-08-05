package com.demo.grpc.interceptor;


import com.demo.grpc.server.Constants;
import com.topsec.util.ObjectUtil;
import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcGlobalInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 统一未知异常处理
 *
 * @auther jasonx
 * @create 5/22/18 11:57 AM
 **/
@Configuration
@Slf4j
public class UnknownStatusDescriptionInterceptor{

    private static final ServerCall.Listener NOOP_LISTENER = new ServerCall.Listener() {
    };
    @Bean
    @GRpcGlobalInterceptor
    public ServerInterceptor globalInterceptor() {
        return new ServerInterceptor() {
            @Override
            public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
                //验证手机唯一标示是否合法
//        String mobiid = headers.get(Constants.MOBIID_META_KEY);
//        if(mobiid!=null && mobiid.length()>0){
//            Context context = Context.current().withValue(Constants.MOBIID_CTX_KEY, mobiid);
//
//        }
//        if(mobiid==null || mobiid.length()<=0){
//            //手机唯一标示不能为空
//            if(log.isDebugEnabled()){
//                log.warn("mobile auth error. _mobileId:{}",mobiid);
//            }
//            call.close(Status.INVALID_ARGUMENT
//                            .withDescription("400100#缺少有效认证凭证")
//                    , headers
//            );
//            return NOOP_LISTENER;
//        }else if(mobiid.length()>100){
//            //手机唯一标示长度最大100
//            if(log.isDebugEnabled()){
//                log.warn("mobile data too long. _mobileId:{}",mobiid);
//            }
//            call.close(Status.INVALID_ARGUMENT
//                            .withDescription("400101#缺少有效认证凭证")
//                    , headers
//            );
//            return NOOP_LISTENER;
//        }
                //验证手机软件版本
                String mobiSoftVer = headers.get(Constants.MOBI_SOFT_VER);
                //必须是数字类型的字符串
                if (ObjectUtil.isNumber(mobiSoftVer) && ObjectUtil.parseInteger(mobiSoftVer) >= 1) {
                    Integer softVer = ObjectUtil.parseInteger(mobiSoftVer);
//            int diffver = Constants.SOFTVER - softVer;
                    if (!softVer.equals(1)) {
                        if (log.isDebugEnabled()) {
                            log.debug("mobile auth error,version too old. version:{}", softVer);
                        }
                        call.close(Status.INVALID_ARGUMENT
                                        .withDescription("400200#请升级软件")
                                , headers
                        );
                        return NOOP_LISTENER;
                    }
                } else {
                    if (log.isDebugEnabled()) {
                        log.debug("mobile auth error. version:{}", mobiSoftVer);
                    }
                    call.close(Status.INVALID_ARGUMENT
                                    .withDescription("400201#认证错误")
                            , headers
                    );
                    return NOOP_LISTENER;
                }

                ServerCall<ReqT, RespT> wrappedCall = new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(call) {
                    @Override
                    public void close(Status status, Metadata trailers) {
                        if (status.getCode() == Status.Code.UNKNOWN && status.getDescription() != null) {
                            Throwable e = status.getCause();
                            String description = "500000# [" + status.getDescription() + "] 服务器内部错误! ";
                            status = Status.UNKNOWN
                                    .augmentDescription(description);
                            log.error(description, e);
                        }
                        super.close(status, trailers);
                    }

                };
                return next.startCall(call, headers);
//        return Contexts.interceptCall(context, wrappedCall, headers, next);
            }
        };
    }
}
