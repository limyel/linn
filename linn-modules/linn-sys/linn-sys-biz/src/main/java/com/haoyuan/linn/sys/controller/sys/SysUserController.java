package com.haoyuan.linn.sys.controller.sys;

import com.haoyuan.linn.common.core.pojo.R;
import com.haoyuan.linn.security.annotation.LoginRequired;
import com.haoyuan.linn.sys.dto.sysuser.LoginDTO;
import com.haoyuan.linn.sys.dto.sysuser.SysUserDTO;
import com.haoyuan.linn.sys.service.SysUserService;
import com.haoyuan.linn.sys.vo.sysuser.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @LoginRequired
    @PostMapping("add")
    public R<?> add(@RequestBody SysUserDTO dto) {
        return R.ok();
    }

    @PostMapping("login")
    public R<LoginVO> login(@RequestBody LoginDTO dto) {
        LoginVO r = sysUserService.login(dto);
        return R.ok(r);
    }

}
