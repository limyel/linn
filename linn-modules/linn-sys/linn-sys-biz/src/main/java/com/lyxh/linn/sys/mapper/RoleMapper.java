package com.haoyuan.linn.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haoyuan.linn.sys.dataobject.MenuDO;
import com.haoyuan.linn.sys.dataobject.RoleDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<RoleDO> {
}
