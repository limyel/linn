package com.haoyuan.linn.common.core.utils.thread;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalUtils {

    private final static ThreadLocal<Map<String, Object>> THREAD_CONTEXT = ThreadLocal.withInitial(
            () -> new HashMap<>(8)
    );

    public static Object get(String key) {
        return THREAD_CONTEXT.get().get(key);
    }

    public static void put(String key, Object value) {
        THREAD_CONTEXT.get().put(key, value);
    }

    public static Object remove(String key) {
        return THREAD_CONTEXT.get().remove(key);
    }

    public static void clear() {
        THREAD_CONTEXT.get().clear();
    }

    public static void clearAll() {
        THREAD_CONTEXT.remove();
    }

}
