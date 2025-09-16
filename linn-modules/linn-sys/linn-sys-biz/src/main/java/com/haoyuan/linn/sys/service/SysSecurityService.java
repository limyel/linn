package com.haoyuan.linn.sys.service;

import com.haoyuan.linn.common.core.pojo.User;
import com.haoyuan.linn.common.core.utils.bean.LinnBeanUtils;
import com.haoyuan.linn.security.service.ISecurityService;
import com.haoyuan.linn.sys.api.dto.LoginUser;
import com.haoyuan.linn.sys.dataobject.SysUserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysSecurityService implements ISecurityService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @Override
    public User getUserByToken(String token) {
        SysUserDO sysUser = sysUserService.getByToken(token);

        LoginUser loginUser = LinnBeanUtils.copyBean(sysUser, LoginUser.class);
        loginUser.setRoles(roleService.getNamesBySysUserId(loginUser.getId()));
        loginUser.setPerms(menuService.getPermsBySysUserId(loginUser.getId()));

        return loginUser;
    }

}
