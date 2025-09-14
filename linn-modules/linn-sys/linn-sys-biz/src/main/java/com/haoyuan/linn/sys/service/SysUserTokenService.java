package com.haoyuan.linn.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.haoyuan.linn.common.core.constant.ErrorCodeConstant;
import com.haoyuan.linn.common.core.enhancer.exception.BizException;
import com.haoyuan.linn.sys.dataobject.SysUserTokenDO;
import com.haoyuan.linn.sys.mapper.SysUserTokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SysUserTokenService {

    @Autowired
    private SysUserTokenMapper sysUserTokenMapper;

    public SysUserTokenDO getByToken(String token) {
        LocalDateTime now = LocalDateTime.now();

        SysUserTokenDO sysUserTokenDO = sysUserTokenMapper.selectOne(new LambdaQueryWrapper<SysUserTokenDO>()
                .eq(SysUserTokenDO::getToken, token));
        if (sysUserTokenDO == null || now.isAfter(sysUserTokenDO.getExpireTime())) {
            throw new BizException(ErrorCodeConstant.UNAUTHORIZED);
        }

        return sysUserTokenDO;
    }

}
