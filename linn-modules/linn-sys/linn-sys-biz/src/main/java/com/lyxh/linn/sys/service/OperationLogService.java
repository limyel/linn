package com.haoyuan.linn.sys.service;

import com.haoyuan.linn.common.core.utils.bean.LinnBeanUtils;
import com.haoyuan.linn.sys.dataobject.OperationLogDO;
import com.haoyuan.linn.sys.dto.operationlog.OperationLogDTO;
import com.haoyuan.linn.sys.mapper.OperationLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationLogService {

    @Autowired
    private OperationLogMapper operationLogMapper;

    public Integer add(OperationLogDTO dto) {
        OperationLogDO operationLogDO = LinnBeanUtils.copyBean(dto, OperationLogDO.class);
        return operationLogMapper.insert(operationLogDO);
    }



}
