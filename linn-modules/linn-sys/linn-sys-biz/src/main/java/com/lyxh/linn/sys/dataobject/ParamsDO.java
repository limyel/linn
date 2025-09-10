package com.lyxh.linn.sys.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lyxh.linn.common.mybatis.pojo.BaseDO;
import com.lyxh.linn.sys.api.constant.TypeEnum;
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
