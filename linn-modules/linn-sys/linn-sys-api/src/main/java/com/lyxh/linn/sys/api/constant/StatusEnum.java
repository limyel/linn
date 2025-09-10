package com.haoyuan.linn.sys.api.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
    NORMAL("normal", "正常"),
    ABNORMAL("abnormal", "异常")
    ;

    @EnumValue
    @JsonValue
    private final String value;
    private final String desc;

}
