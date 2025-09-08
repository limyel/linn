package com.lyxh.linn.sys.dto.operationlog;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OperationLogDTO {

    private Long id;

    private String moduleCode;

    private Integer type;

    private String title;

    private String content;

    private Long createBy;

    private LocalDateTime createTime;

}
