package com.demo.api.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
@Order(1000)
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        if (path.matches(Const.NO_INTERCEPTOR_PATH)) {
            //不需要的拦截直接过
            return true;
        }else if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;// 把handler强转为HandlerMethod
            TokenRequired tokenRequired = handlerMethod.getMethod().getAnnotation(TokenRequired.class);
            if (tokenRequired == null){
                return true;
            }else{
                DefaultRequestWrapper requestWrapper =new DefaultRequestWrapper(request);
                String source = requestWrapper.getParameter("source");
                if(source.equals("WeiXin")){
                    // 如果请求来源来自微信 拦截需要干的，比如取缓存，SESSION，权限判断等
                    try {
                        BufferedReader streamReader = new BufferedReader( new InputStreamReader(requestWrapper.getInputStream(), "UTF-8"));
                        StringBuilder responseStrBuilder = new StringBuilder();
                        String inputStr;
                        while((inputStr = streamReader.readLine()) != null) {
                            responseStrBuilder.append(inputStr);
                        }
                        JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
                        String param= jsonObject.toJSONString();
                        System.out.println(param);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        }
        return true;
    }
}
