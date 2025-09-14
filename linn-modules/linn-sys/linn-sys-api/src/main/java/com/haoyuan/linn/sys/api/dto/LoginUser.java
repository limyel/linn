package com.haoyuan.linn.sys.api.dto;

import com.haoyuan.linn.common.core.pojo.User;
import lombok.Data;

import java.util.Set;

@Data
public class LoginUser implements User<Long> {

    Long id;

    private String username;

    private String password;

    private Set<String> roles;

    private Set<String> perms;

}
