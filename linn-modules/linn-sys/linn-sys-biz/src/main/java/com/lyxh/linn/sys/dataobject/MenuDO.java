package com.lyxh.linn.sys.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lyxh.linn.common.mybatis.pojo.BaseDO;
import com.lyxh.linn.sys.api.constant.StatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_menu")
public class MenuDO extends BaseDO {

    private String name;

    private Long pid;

    private Integer sort;

    private String path;

    private String urls;

    private String component;

    private String type;

    private Boolean visible;

    private StatusEnum status;

    private String perms;

    private String icon;

    private String remark;

}
