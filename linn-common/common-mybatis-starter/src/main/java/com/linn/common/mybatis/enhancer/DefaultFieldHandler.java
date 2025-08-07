package com.linn.common.mybatis.enhancer;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.linn.common.mybatis.pojo.BaseDO;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;
import java.util.Objects;

// todo createBy、updateBy
public class DefaultFieldHandler implements MetaObjectHandler {

    public static final String UPDATE_TIME = "updateTime";

    @Override
    public void insertFill(MetaObject metaObject) {
        if (!Objects.isNull(metaObject) && metaObject.getOriginalObject() instanceof BaseDO baseDO) {
            LocalDateTime now = LocalDateTime.now();
            if (Objects.isNull(baseDO.getCreateTime())) {
                baseDO.setCreateTime(now);
            }
            if (Objects.isNull(baseDO.getUpdateTime())) {
                baseDO.setUpdateTime(now);
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (!Objects.isNull(metaObject) && metaObject.getOriginalObject() instanceof BaseDO baseDO) {
            setFieldValByName(UPDATE_TIME, LocalDateTime.now(), metaObject);
        }
    }
}
