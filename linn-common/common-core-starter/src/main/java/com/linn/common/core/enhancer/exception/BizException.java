package com.linn.common.core.enhancer.exception;

import com.linn.common.core.constant.ErrorCodeConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BizException extends RuntimeException {

    private Integer code;

    public BizException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public BizException(String msg) {
        this(ErrorCodeConstant.INTERNAL_ERROR.getCode(), msg);
    }

    public BizException(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMsg());
    }

}
