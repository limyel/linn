CREATE TABLE `member_user`
(
    `id`          bigint                                  NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `username`    varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
    `password`    varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
    `create_time` datetime                                NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`   bigint                                           DEFAULT NULL COMMENT '创建者',
    `update_time` datetime                                NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_by`   bigint                                           DEFAULT NULL COMMENT '更新者',
    `delete_time` datetime                                         DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='会员用户表';
