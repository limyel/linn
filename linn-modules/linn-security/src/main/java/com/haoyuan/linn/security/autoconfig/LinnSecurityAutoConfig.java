package com.haoyuan.linn.security.autoconfig;

import com.haoyuan.linn.security.interceptor.LoginInterceptor;
import com.haoyuan.linn.security.service.ISecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AutoConfiguration
public class LinnSecurityAutoConfig implements WebMvcConfigurer {

    @Autowired(required = false)
    private ISecurityService securityService;

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor(securityService);
    }

}
