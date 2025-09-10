package com.haoyuan.linn.sys.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.haoyuan.linn.sys.service.OperationLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OperationLogService operationLogService;

    @Pointcut("@annotation(com.haoyuan.linn.common.core.log.ApiOperationLog)")
    public void pointcut() {
    }

    @AfterReturning("pointcut()")
    public void afterReturning(JoinPoint joinPoint) {

    }

    private void addOperationLog(JoinPoint joinPoint) {

    }

}
