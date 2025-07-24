package com.limyel.linn.common.core.autoconfig;

import com.limyel.linn.common.core.enhancer.exception.BasicErrorAttributes;
import com.limyel.linn.common.core.enhancer.exception.GlobalExceptionHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class ExceptionHandlerAutoConfig {

    @Bean
    public BasicErrorAttributes basicErrorAttributes() {
        return new BasicErrorAttributes();
    }

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

}
