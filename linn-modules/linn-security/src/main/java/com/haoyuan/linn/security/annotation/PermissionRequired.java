package com.haoyuan.linn.security.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@LoginRequired
public @interface PermissionRequired {
}
