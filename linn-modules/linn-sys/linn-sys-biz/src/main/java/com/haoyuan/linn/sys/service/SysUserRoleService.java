package com.haoyuan.linn.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.haoyuan.linn.sys.dataobject.SysUserRoleDO;
import com.haoyuan.linn.sys.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    public List<Long> getRoleIdsBySysUserId(Long sysUserId) {
        List<SysUserRoleDO> list = sysUserRoleMapper.selectList(new LambdaQueryWrapper<SysUserRoleDO>()
                .eq(SysUserRoleDO::getSysUserId, sysUserId));
        return list.stream()
                .map(SysUserRoleDO::getRoleId)
                .toList();
    }

}
