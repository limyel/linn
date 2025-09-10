package com.haoyuan.linn.sys.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.haoyuan.linn.common.mybatis.pojo.BaseDO;
import com.haoyuan.linn.sys.api.constant.StatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_login_log")
public class LoginLogDO extends BaseDO {

    private String username;

    private String ip;

    private StatusEnum status;

}
