package com.limyel.linn.common.core.constant;

import com.limyel.linn.common.core.enhancer.exception.ErrorCode;

public interface ErrorCodeConstant {

    ErrorCode SUCCESS = new ErrorCode(0, "成功");

    ErrorCode INTERNAL_ERROR = new ErrorCode(500, "系统内部错误，请联系管理员");

    ErrorCode BAD_REQUEST = new ErrorCode(400, "请求参数错误");
    ErrorCode UNAUTHORIZED = new ErrorCode(401, "认证失败");
    ErrorCode FORBIDDEN = new ErrorCode(403, "鉴权失败");

}
