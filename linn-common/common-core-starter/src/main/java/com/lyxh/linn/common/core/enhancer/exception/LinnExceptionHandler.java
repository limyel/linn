package com.lyxh.linn.common.core.enhancer.exception;

import com.lyxh.linn.common.core.constant.ErrorCodeConstant;
import com.lyxh.linn.common.core.constant.LinnConstant;
import com.lyxh.linn.common.core.pojo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class LinnExceptionHandler {

    @ExceptionHandler(BizException.class)
    @ResponseBody
    public R<?> handleBizException(HttpServletRequest request, BizException e) {
        log.error("{} request failed, error code: {}, error msg: {}", request.getRequestURI(), e.getCode(), e.getMessage());
        return R.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public R<?> handleBindException(HttpServletRequest request, BindException e) {
        BindingResult bindingResult = e.getBindingResult();

        StringBuilder sb = new StringBuilder();

        List<FieldError> errs = bindingResult.getFieldErrors();
        if (!CollectionUtils.isEmpty(errs)) {
            errs.forEach(err ->
                    sb.append(err.getField())
                            .append(" ")
                            .append(err.getDefaultMessage())
                            .append("，当前值：'")
                            .append(err.getRejectedValue())
                            .append("';")
            );
        }

        String errMsg = sb.toString();

        log.error("{} 请求失败, error code: {}, error msg: {}", request.getRequestURI(), ErrorCodeConstant.BAD_REQUEST.getCode(), errMsg);

        return R.fail(ErrorCodeConstant.BAD_REQUEST.getCode(), errMsg);
    }

    @ExceptionHandler(Exception.class)
    public String resolvexException(Exception e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        Map<String, Object> map = new HashMap<>();
        map.put(LinnConstant.ERROR_MSG, "系统内部异常，请联系管理员");
        request.setAttribute(LinnConstant.ERROR_DATA, map);
        request.setAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return "forward:/error";
    }

}
