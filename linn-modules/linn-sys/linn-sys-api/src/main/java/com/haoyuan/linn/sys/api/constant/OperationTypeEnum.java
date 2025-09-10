package com.haoyuan.linn.sys.api.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OperationTypeEnum {
    ADD("add", "新建"),
    DELETE("delete", "删除"),
    UPDATE("update", "更新"),

    ;

    private final String value;
    private final String desc;

}
