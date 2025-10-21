package com.haoyuan.linn.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.haoyuan.linn.common.core.constant.ErrorCodeConstant;
import com.haoyuan.linn.common.core.enhancer.exception.BizException;
import com.haoyuan.linn.sys.constant.SysErrorCodeConstant;
import com.haoyuan.linn.sys.dataobject.SysUserDO;
import com.haoyuan.linn.sys.dataobject.SysUserTokenDO;
import com.haoyuan.linn.sys.dto.sysuser.LoginDTO;
import com.haoyuan.linn.sys.mapper.SysUserMapper;
import com.haoyuan.linn.sys.vo.sysuser.LoginVO;
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

    public SysUserDO getByUsername(String username) {
        SysUserDO sysUserDO = sysUserMapper.selectOne(new LambdaQueryWrapper<SysUserDO>()
                .eq(SysUserDO::getUsername, username));
        if (sysUserDO == null) {
            throw new BizException(SysErrorCodeConstant.SYS_USER_NOT_FOUND);
        }
        return sysUserDO;
    }

    public LoginVO login(LoginDTO dto) {
        SysUserDO sysUserDO = getByUsername(dto.getUsername());
        if (!sysUserDO.getPassword().equals(dto.getPassword())) {
            throw new BizException(ErrorCodeConstant.UNAUTHORIZED);
        }
        String token = sysUserTokenService.addToken(sysUserDO.getId());
        return new LoginVO(token);
    }

}
