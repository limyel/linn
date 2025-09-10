package com.haoyuan.linn.common.core.pojo;

import com.haoyuan.linn.common.core.constant.ErrorCodeConstant;
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


    public static <T> R<T> ok(T data) {
        return new R<>(ErrorCodeConstant.SUCCESS.getCode(), ErrorCodeConstant.SUCCESS.getMsg(), data);
    }

    public static R<?> ok() {
        return new R<>(ErrorCodeConstant.SUCCESS.getCode(), ErrorCodeConstant.SUCCESS.getMsg(), null);
    }

    public static R<?> fail() {
        return new R<>(ErrorCodeConstant.INTERNAL_ERROR.getCode(), ErrorCodeConstant.INTERNAL_ERROR.getMsg(), null);
    }

    public static R<?> fail(Integer code, String msg) {
        return new R<>(code, msg, null);
    }

}