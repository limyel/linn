package com.linn.common.core.autoconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * 覆盖默认配置文件的后置处理器
 */
public class DefaultEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Map<String, Object> source = new HashMap<>();
        MapPropertySource propertySource = new MapPropertySource("linn-propertysource", source);
        environment.getPropertySources().addLast(propertySource);
    }
}
