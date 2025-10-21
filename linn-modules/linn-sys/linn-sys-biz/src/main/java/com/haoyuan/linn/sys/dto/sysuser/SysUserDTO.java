package com.haoyuan.linn.sys.dto.sysuser;

import com.haoyuan.linn.sys.api.constant.StatusEnum;
import lombok.Data;

@Data
public class SysUserDTO {

    private Long id;

    private Long deptId;

    private String username;

    private String email;

    private String mobile;

    private String avatar;

    private String password;

    private StatusEnum status;

    private String remark;

}
