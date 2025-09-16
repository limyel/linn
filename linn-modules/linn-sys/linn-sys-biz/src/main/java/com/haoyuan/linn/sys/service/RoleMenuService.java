package com.haoyuan.linn.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.haoyuan.linn.sys.dataobject.RoleMenuDO;
import com.haoyuan.linn.sys.mapper.RoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    public List<Long> getMenuIdsByRoleIds(List<Long> roleIds) {
        List<RoleMenuDO> list = roleMenuMapper.selectList(new LambdaQueryWrapper<RoleMenuDO>()
                .in(RoleMenuDO::getRoleId, roleIds));
        return list.stream()
                .map(RoleMenuDO::getMenuId)
                .toList();
    }

}
