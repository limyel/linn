package com.lyxh.linn.sys.api.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeEnum {
    SYS("sys", "系统内置"),
    CUSTOM("custom", "自定义"),
    ;

    @EnumValue
    @JsonValue
    private final String value;
    private final String desc;
}
