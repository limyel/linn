package com.lyxh.linn.sys.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lyxh.linn.common.mybatis.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_role_menu")
public class RoleMenuDO extends BaseDO {

    private Long roleId;

    private Long menuId;

}
