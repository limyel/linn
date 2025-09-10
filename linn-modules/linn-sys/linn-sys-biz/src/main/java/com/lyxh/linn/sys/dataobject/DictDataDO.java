package com.haoyuan.linn.sys.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.haoyuan.linn.common.mybatis.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_dict_data")
public class DictDataDO extends BaseDO {

    private Long dictTypeId;

    private String dictLabel;

    private String dictValue;

    private String remark;

    private Integer sort;

}
