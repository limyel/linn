package com.lyxh.linn.common.core.enhancer.web;

import com.lyxh.linn.common.core.constant.LinnConstant;
import com.lyxh.linn.common.core.pojo.R;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

public class AutoPrefixUrlMapping extends RequestMappingHandlerMapping {

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo mappingInfo = super.getMappingForMethod(method, handlerType);
        // 响应类型为 R 的方法才会更改路由
        if (mappingInfo != null && method.getReturnType().equals(R.class)) {
            String prefix = this.getPrefix(handlerType);
            return RequestMappingInfo.paths(prefix).build().combine(mappingInfo);
        }
        return mappingInfo;
    }

    private String getPrefix(Class<?> handlerType) {
        String packageName = handlerType.getPackage().getName();
        String dotPath = packageName;
        if (packageName.contains(LinnConstant.CONTROLLER_PKG)) {
            dotPath = packageName.replaceAll(".*" + LinnConstant.CONTROLLER_PKG, "");
        }
        return dotPath.replace(".", "/");
    }

}
