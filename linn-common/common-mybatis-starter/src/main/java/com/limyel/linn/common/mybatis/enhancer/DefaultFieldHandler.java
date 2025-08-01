package com.limyel.linn.common.mybatis.enhancer;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.limyel.linn.common.mybatis.pojo.BasePO;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;
import java.util.Objects;

// todo createBy、updateBy
public class DefaultFieldHandler implements MetaObjectHandler {

    public static final String UPDATE_TIME = "updateTime";

    @Override
    public void insertFill(MetaObject metaObject) {
        if (!Objects.isNull(metaObject) && metaObject.getOriginalObject() instanceof BasePO basePO) {
            LocalDateTime now = LocalDateTime.now();
            if (Objects.isNull(basePO.getCreateTime())) {
                basePO.setCreateTime(now);
            }
            if (Objects.isNull(basePO.getUpdateTime())) {
                basePO.setUpdateTime(now);
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (!Objects.isNull(metaObject) && metaObject.getOriginalObject() instanceof BasePO basePO) {
            setFieldValByName(UPDATE_TIME, LocalDateTime.now(), metaObject);
        }
    }
}
