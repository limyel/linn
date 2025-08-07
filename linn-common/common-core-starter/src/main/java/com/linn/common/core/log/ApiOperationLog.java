package com.linn.common.core.log;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ApiOperationLog {

    /**
     * 功能描述
     * @return
     */
    String desc() default "";

}
