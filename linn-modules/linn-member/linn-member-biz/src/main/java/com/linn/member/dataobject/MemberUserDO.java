package com.linn.member.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.linn.common.mybatis.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("member_user")
public class MemberUserDO extends BaseDO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
