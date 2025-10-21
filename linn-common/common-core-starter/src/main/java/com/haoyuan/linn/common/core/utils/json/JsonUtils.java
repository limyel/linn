package com.haoyuan.linn.common.core.utils.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haoyuan.linn.common.core.enhancer.exception.BizException;
import com.haoyuan.linn.common.core.utils.spring.SpringUtils;

import java.util.List;
import java.util.Map;

public class JsonUtils {

    private static ObjectMapper getObjectMapper() {
        return SpringUtils.getBean(ObjectMapper.class);
    }

    public static String toJson(Object obj) {
        try {
            return getObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new BizException("对象转JSON失败");
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return getObjectMapper().readValue(json, clazz);
        } catch (Exception e) {
            throw new BizException("JSON转对象失败");
        }
    }

    public static <T> T fromJson(String json, TypeReference<T> typeReference) {
        try {
            return getObjectMapper().readValue(json, typeReference);
        } catch (Exception e) {
            throw new RuntimeException("JSON转对象失败", e);
        }
    }

    public static <T> List<T> fromJsonToList(String json, Class<T> clazz) {
        try {
            return getObjectMapper().readValue(json, getObjectMapper().getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (Exception e) {
            throw new RuntimeException("JSON转List失败", e);
        }
    }

    public static Map<String, Object> fromJsonToMap(String json) {
        try {
            return getObjectMapper().readValue(json, new TypeReference<Map<String, Object>>() {});
        } catch (Exception e) {
            throw new RuntimeException("JSON转Map失败", e);
        }
    }

    public static <T> T mapToObject(Map<String, Object> map, Class<T> clazz) {
        try {
            return getObjectMapper().convertValue(map, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Map转对象失败", e);
        }
    }

    public static Map<String, Object> objectToMap(Object obj) {
        try {
            return getObjectMapper().convertValue(obj, new TypeReference<Map<String, Object>>() {});
        } catch (Exception e) {
            throw new RuntimeException("对象转Map失败", e);
        }
    }

    public static boolean isValidJson(String json) {
        try {
            getObjectMapper().readTree(json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String formatJson(String json) {
        try {
            Object obj = getObjectMapper().readValue(json, Object.class);
            return getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("格式化JSON失败", e);
        }
    }
}