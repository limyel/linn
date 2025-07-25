package com.limyel.linn.common.core.pojo;

import com.limyel.linn.common.core.enhancer.exception.BizException;
import com.limyel.linn.common.core.enhancer.exception.ErrorCode;
import com.limyel.linn.common.core.enhancer.exception.GlobalErrorCode;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class R<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;
    private T data;

    public R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static R<?> of(ErrorCode errorCode) {
        return new R<>(errorCode.getCode(), errorCode.getMsg(), null);
    }

    public static R<?> of(BizException e) {
        return new R<>(e.getCode(), e.getMessage(), null);
    }

    public static <T> R<T> ok(T data) {
        return new R<>(GlobalErrorCode.SUCCESS.getCode(), GlobalErrorCode.SUCCESS.getMsg(), data);
    }

    public static R<?> ok() {
        return R.of(GlobalErrorCode.SUCCESS);
    }

    public static R<?> check(Integer result) {
        return result > 0 ? R.ok() : R.of(GlobalErrorCode.INTERNAL_ERROR);
    }

}