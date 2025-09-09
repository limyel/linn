package com.lyxh.linn.sys.api.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OperationModuleEnum {
    SYS("linn-sys", "linn 管理模块"),
    BLOG("linn-blog", "linn 博客模块")
    ;

    private final String value;
    private final String desc;

}
