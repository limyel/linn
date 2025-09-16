package com.haoyuan.linn.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.haoyuan.linn.sys.api.constant.StatusEnum;
import com.haoyuan.linn.sys.dataobject.MenuDO;
import com.haoyuan.linn.sys.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    public List<MenuDO> getBySysUserId(Long sysUserId) {
        List<Long> rolsIds = sysUserRoleService.getRoleIdsBySysUserId(sysUserId);
        List<Long> menuIds = roleMenuService.getMenuIdsByRoleIds(rolsIds);

        LambdaQueryWrapper<MenuDO> queryWrapper = new LambdaQueryWrapper<MenuDO>()
                .in(MenuDO::getId, menuIds)
                .eq(MenuDO::getStatus, StatusEnum.NORMAL)
                .orderByDesc(MenuDO::getCreateTime);

        return menuMapper.selectList(queryWrapper);
    }

    public Set<String> getPermsBySysUserId(Long sysUserId) {
        List<MenuDO> list = getBySysUserId(sysUserId);

        List<String> perms = list.stream()
                .map(MenuDO::getPerms)
                .filter(Objects::nonNull)
                .toList();
        return perms.stream()
                .map(perm -> Arrays.asList(perm.split(",")))
                .flatMap(List::stream)
                .collect(Collectors.toSet());
    }

}
