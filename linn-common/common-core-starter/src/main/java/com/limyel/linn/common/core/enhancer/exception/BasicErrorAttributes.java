package com.limyel.linn.common.core.enhancer.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public class BasicErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        // 额外的异常信息
        Map<String, Object> errorData = (Map<String, Object>) webRequest.getAttribute("ERROR_DATA", RequestAttributes.SCOPE_REQUEST);
        if (errorData != null) {
            map.putAll(errorData);
        }
        return map;
    }
}
