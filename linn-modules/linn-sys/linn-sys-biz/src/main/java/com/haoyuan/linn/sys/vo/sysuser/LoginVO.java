package com.haoyuan.linn.sys.vo.sysuser;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class LoginVO {

    private String token;

    public LoginVO(String token) {
        this.token = token;
    }

}
