package com.haoyuan.linn.sys.service;

import com.haoyuan.linn.common.core.enhancer.exception.BizException;
import com.haoyuan.linn.sys.constant.SysErrorCodeConstant;
import com.haoyuan.linn.sys.dataobject.SysUserDO;
import com.haoyuan.linn.sys.dataobject.SysUserTokenDO;
import com.haoyuan.linn.sys.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserTokenService sysUserTokenService;

    public SysUserDO getByToken(String token) {
        SysUserTokenDO sysUserTokenDO = sysUserTokenService.getByToken(token);
        SysUserDO sysUserDO = sysUserMapper.selectById(sysUserTokenDO.getSysUserId());
        if (sysUserDO == null) {
            throw new BizException(SysErrorCodeConstant.SYS_USER_NOT_FOUND);
        }
        return sysUserDO;
    }

}
