package com.haoyuan.linn.common.core.utils.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LinnBeanUtils {

    public static <T> List<T> copyList(List<?> source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }

        List<T> target = new ArrayList<>();

        for (Object tmpSrc : source) {
            T t = copyBean(tmpSrc, targetClass);
            target.add(t);
        }

        return target;
    }

    public static <T> T copyBean(Object source, Class<T> targetClass) {
        try {
            T target = targetClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> deepCopy(List<T> source) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(source);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> r = (List<T>) in.readObject();
        return r;
    }

}
