package com.demo.grpc.interceptor;

import com.demo.grpc.server.Constants;
import com.topsec.ptoken.core.TokenUtils;
import com.topsec.ptoken.core.ValidResult;
import com.topsec.ptoken.ext.mobile.TokenDataMobile;
import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

@Component
@Scope("prototype")
@Slf4j
public class PtokenServerInterceptor extends BaseServerInterceptor {
    @Resource
    private TokenUtils tokenUtils;
    @Value("${myauthentication.ptoken.ptokenKeys}")
    private String[] ptokenKeys;

    @Override
    protected <ReqT, RespT> ServerCall.Listener<ReqT> toChildInterceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        String ptoken = headers.get(Constants.PTOKEN_META_KEY);
        boolean isAuth=false;
        ValidResult validResult = null;
        if(ptokenKeys!=null && ptokenKeys.length>0){
            for (String key : ptokenKeys) {
                validResult = tokenUtils.authToken(ptoken, key);
                if(validResult.isValid()){
                    isAuth=validResult.isValid();
                    break;
                }
            }
        }

        if (isAuth){
            if(log.isDebugEnabled()){
                log.debug("mobile auth success");
            }
            String _mobiid = headers.get(Constants.SUBDIG_META_KEY);
            TokenDataMobile tokenDataMobile = validResult.parseData(TokenDataMobile.class);
            String tokenSnSha1Base64=null;
            try {
                MessageDigest sha1 = MessageDigest.getInstance("SHA1");
                String sn = tokenDataMobile.getSn();
                byte[] digest = sha1.digest(sn.getBytes());
                tokenSnSha1Base64 = Base64.getUrlEncoder().withoutPadding().encodeToString(digest);

            } catch (NoSuchAlgorithmException e) {
                String uuid=UUID.randomUUID().toString();
                log.error("["+uuid+"] "+e.getMessage(),e);
                call.close(Status.UNKNOWN.withDescription(uuid),headers);
                return NOOP_LISTENER;
            }
            if(_mobiid == null||_mobiid.length()<=0){
                if(log.isDebugEnabled()){
                    log.debug("header subdig is null _mobileId:{},tokenSnSha1Base64:{}",_mobiid,tokenSnSha1Base64);
                }
                call.close(Status.UNAUTHENTICATED.withDescription("400100#缺少有效认证凭证"),headers);
                return NOOP_LISTENER;
            }

            if(!_mobiid.equals(tokenSnSha1Base64)){
                if(log.isDebugEnabled()){
                    log.debug("mobile device sn error _mobileId:{},tokenSnSha1Base64:{}",_mobiid,tokenSnSha1Base64);
                }
                call.close(Status.UNAUTHENTICATED.withDescription("400101#认证错误"),headers);
                return NOOP_LISTENER;
            }
            Context ctx = Context.current().withValue(Constants.PTOKEN_CTX_KEY, validResult.getToken());

            return Contexts.interceptCall(ctx, call, headers, next);

        } else{
            if(log.isDebugEnabled()){
                log.debug("mobile auth error info {}",validResult.getErrorCode());
            }
            call.close(Status.UNAUTHENTICATED
                            .withDescription("400301#认证错误")
                    , headers
            );
            return NOOP_LISTENER;
        }
    }
}
