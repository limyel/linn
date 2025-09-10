package com.haoyuan.linn.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haoyuan.linn.sys.dataobject.OperationLogDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationLogMapper extends BaseMapper<OperationLogDO> {
}
