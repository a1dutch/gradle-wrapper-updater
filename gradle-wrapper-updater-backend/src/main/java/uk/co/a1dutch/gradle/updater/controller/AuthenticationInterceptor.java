package uk.co.a1dutch.gradle.updater.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    private ThreadLocal<String> authorisation;

    public AuthenticationInterceptor(ThreadLocal<String> authorisation) {
        this.authorisation = authorisation;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        HttpServletRequest httpServletRequest = request;
        String token = httpServletRequest.getHeader("Authorization");
        if (StringUtils.isEmpty(token)) {
            throw new AuthenticationRequiredException();
        }
        authorisation.set(token);
        return true;
    }
}
