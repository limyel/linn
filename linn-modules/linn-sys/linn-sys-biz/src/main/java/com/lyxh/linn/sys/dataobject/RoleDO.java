package com.haoyuan.linn.sys.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.haoyuan.linn.common.mybatis.pojo.BaseDO;
import com.haoyuan.linn.sys.api.constant.StatusEnum;
import com.haoyuan.linn.sys.api.constant.TypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_role")
public class RoleDO extends BaseDO {

    private String name;

    private String code;

    private Integer sort;

    private StatusEnum status;

    private TypeEnum type;

    private String remark;

}
