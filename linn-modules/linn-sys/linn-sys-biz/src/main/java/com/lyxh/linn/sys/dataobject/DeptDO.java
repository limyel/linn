package com.lyxh.linn.sys.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lyxh.linn.common.mybatis.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_dept")
public class DeptDO extends BaseDO {

    private Long pid;

    private String name;

    private Integer sort;

    private Long leader;

    private String email;

    private String mobile;

    private StatusEnum status;

}
