package com.haoyuan.linn.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haoyuan.linn.sys.dataobject.MenuDO;
import com.haoyuan.linn.sys.dataobject.OperationLogDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper extends BaseMapper<MenuDO> {
}
