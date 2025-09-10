package com.haoyuan.linn.sys.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.haoyuan.linn.common.mybatis.pojo.BaseDO;
import com.haoyuan.linn.sys.api.constant.TypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_params")
public class ParamsDO extends BaseDO {

    private String paramLabel;

    private String paramCode;

    private String paramValue;

    private TypeEnum type;

    private String remark;

}
