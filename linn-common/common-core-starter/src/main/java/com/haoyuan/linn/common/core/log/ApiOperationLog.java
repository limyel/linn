package com.haoyuan.linn.common.core.log;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ApiOperationLog {

    String module();

    String title();

    String type();

}
