package com.linn.common.core.autoconfig;

import com.linn.common.core.enhancer.exception.LinnExceptionHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration(before = ErrorMvcAutoConfiguration.class)
public class ExceptionHandlerAutoConfig {

    @Bean
    public LinnExceptionHandler globalExceptionHandler() {
        return new LinnExceptionHandler();
    }

}
