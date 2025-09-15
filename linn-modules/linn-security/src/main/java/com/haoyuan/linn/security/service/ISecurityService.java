package com.haoyuan.linn.security.service;

import com.haoyuan.linn.common.core.pojo.User;

public interface ISecurityService {

    User getUserByToken(String token);

}
