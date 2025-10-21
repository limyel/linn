package com.haoyuan.linn.security.interceptor;

import com.haoyuan.linn.common.core.constant.ErrorCodeConstant;
import com.haoyuan.linn.common.core.constant.LinnConstant;
import com.haoyuan.linn.common.core.enhancer.exception.BizException;
import com.haoyuan.linn.common.core.pojo.User;
import com.haoyuan.linn.common.core.utils.thread.ThreadLocalUtils;
import com.haoyuan.linn.security.annotation.LoginRequired;
import com.haoyuan.linn.security.service.ISecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    private final ISecurityService securityService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        if (isLoginFree(handler)) {
            return true;
        }

        User user = handleLogin(request, response);
        ThreadLocalUtils.put(LinnConstant.CURRENT_USER, user);

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    private User handleLogin(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader(LinnConstant.USER_TOKEN);
        if (StringUtils.hasText(token)) {
            return securityService.getUserByToken(token);
        }
        throw new BizException(ErrorCodeConstant.UNAUTHORIZED);
    }

    private boolean isLoginFree(Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            LoginRequired loginRequired = AnnotationUtils.getAnnotation(method, LoginRequired.class);
            return loginRequired == null;
        }

        return true;
    }
}
