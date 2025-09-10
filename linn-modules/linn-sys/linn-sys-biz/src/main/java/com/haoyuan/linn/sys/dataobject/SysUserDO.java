package com.haoyuan.linn.sys.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.haoyuan.linn.common.mybatis.pojo.BaseDO;
import com.haoyuan.linn.sys.api.constant.StatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_user")
public class SysUserDO extends BaseDO {

    private Long deptId;

    private String username;

    private String email;

    private String mobile;

    private String avatar;

    private String password;

    private StatusEnum status;

    private String loginIP;

    private LocalDateTime loginTime;

    private String remark;

}
