package com.lyxh.linn.sys.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lyxh.linn.common.mybatis.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_role")
public class RoleDO extends BaseDO {

    private String name;

    private String code;

    private Integer sort;

    private String status;

    private String type;

    private String remark;

}
