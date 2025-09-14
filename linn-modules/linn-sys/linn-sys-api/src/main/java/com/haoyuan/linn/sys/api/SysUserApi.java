package com.haoyuan.linn.sys.api;

import com.haoyuan.linn.sys.api.dto.LoginUser;

public interface SysUserApi {

    LoginUser getLoginUser(String token);

}
