package com.lyxh.linn.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyxh.linn.sys.dataobject.MenuDO;
import com.lyxh.linn.sys.dataobject.RoleDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<RoleDO> {
}
