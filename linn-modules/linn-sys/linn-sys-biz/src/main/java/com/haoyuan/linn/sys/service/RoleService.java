package com.haoyuan.linn.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.haoyuan.linn.sys.api.constant.StatusEnum;
import com.haoyuan.linn.sys.dataobject.RoleDO;
import com.haoyuan.linn.sys.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    public List<RoleDO> getBySysUserId(Long sysUserId) {
        List<Long> roleIds = sysUserRoleService.getRoleIdsBySysUserId(sysUserId);

        LambdaQueryWrapper<RoleDO> queryWrapper = new LambdaQueryWrapper<RoleDO>()
                .in(RoleDO::getId, roleIds)
                .eq(RoleDO::getStatus, StatusEnum.NORMAL)
                .orderByDesc(RoleDO::getCreateTime);

        return roleMapper.selectList(queryWrapper);
    }

    public Set<String> getNamesBySysUserId(Long sysUserId) {
        List<RoleDO> roles = getBySysUserId(sysUserId);

        return roles.stream()
                .map(RoleDO::getName).collect(Collectors.toSet());
    }




}
