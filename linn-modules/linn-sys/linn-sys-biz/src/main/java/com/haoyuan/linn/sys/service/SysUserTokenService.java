package com.haoyuan.linn.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.haoyuan.linn.common.core.constant.ErrorCodeConstant;
import com.haoyuan.linn.common.core.enhancer.exception.BizException;
import com.haoyuan.linn.sys.dataobject.SysUserTokenDO;
import com.haoyuan.linn.sys.mapper.SysUserTokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

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

    public String addToken(Long sysUserId) {
        SysUserTokenDO sysUserTokenDO = new SysUserTokenDO();
        sysUserTokenDO.setSysUserId(sysUserId);
        sysUserTokenDO.setToken(UUID.randomUUID().toString());
        sysUserTokenDO.setExpireTime(LocalDateTime.now().plusHours(3));
        sysUserTokenMapper.insert(sysUserTokenDO);
        return sysUserTokenDO.getToken();
    }

}
