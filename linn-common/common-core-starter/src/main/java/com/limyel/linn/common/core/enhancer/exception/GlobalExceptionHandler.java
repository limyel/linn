package com.limyel.linn.common.core.enhancer.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String resolvexException(Exception e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        Map<String, Object> map = new HashMap<>();
        map.put("exceptionMsg", "系统内部异常，请联系管理员");
        request.setAttribute("ERROR_DATA", map);
        request.setAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return "forward:/error";
    }

}
