package com.lyxh.linn.common.core.enhancer.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误码接口
 */
@Getter
@AllArgsConstructor
public class ErrorCode {

    private Integer code;

    private String msg;

}