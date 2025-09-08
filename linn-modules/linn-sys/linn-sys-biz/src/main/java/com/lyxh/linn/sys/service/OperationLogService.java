package com.lyxh.linn.sys.service;

import com.lyxh.linn.common.core.utils.bean.LinnBeanUtils;
import com.lyxh.linn.sys.dataobject.OperationLogDO;
import com.lyxh.linn.sys.dto.operationlog.OperationLogDTO;
import com.lyxh.linn.sys.mapper.OperationLogMapper;
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
