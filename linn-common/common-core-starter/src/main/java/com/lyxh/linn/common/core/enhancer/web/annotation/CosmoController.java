package com.lyxh.linn.common.core.enhancer.web.annotation;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@RestController
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface CosmoController {
}
