package com.haoyuan.linn.sys.api;

import com.haoyuan.linn.common.core.utils.bean.LinnBeanUtils;
import com.haoyuan.linn.sys.api.dto.LoginUser;
import com.haoyuan.linn.sys.dataobject.SysUserDO;
import com.haoyuan.linn.sys.service.RoleService;
import com.haoyuan.linn.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SysUserApiImpl implements SysUserApi {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @Override
    public LoginUser getLoginUser(String token) {
        SysUserDO sysUserDO = sysUserService.getByToken(token);

        LoginUser loginUser = LinnBeanUtils.copyBean(sysUserDO, LoginUser.class);

        Set<String> roles = roleService.getNamesBySysUserId(sysUserDO.getId());
        loginUser.setRoles(roles);


        return loginUser;
    }
}
