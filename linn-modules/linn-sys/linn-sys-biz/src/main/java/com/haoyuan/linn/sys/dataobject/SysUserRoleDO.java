package com.haoyuan.linn.sys.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.haoyuan.linn.common.mybatis.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_user_role")
public class SysUserRoleDO extends BaseDO {

    private Long sysUserId;

    private Long roleId;

}
