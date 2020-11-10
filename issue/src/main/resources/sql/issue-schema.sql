SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cr_issue_task
-- ----------------------------
DROP TABLE IF EXISTS `cr_issue_task`;
CREATE TABLE `cr_issue_task`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '缺陷记录ID',
  `org_id` bigint(0) DEFAULT NULL COMMENT '用于隔离的组织ID，由crud-plus维护（保留便于扩展）',
  `org_tag` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用于隔离的组织标识（保留便于扩展）',
  `pid` bigint(0) DEFAULT NULL COMMENT '关联问题ID，可以引申子问题',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题',
  `ticket` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '编号(任务或问题)',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '缺陷名称',
  `brief` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '缺陷简要',
  `originator` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '问题发起人',
  `originator_user_id` bigint(0) DEFAULT NULL COMMENT '问题发起人系统用户ID',
  `module_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '问题所属模块',
  `status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'Undefined-无状态, Open-打开,Fixed-已修得,Verifed-已验证,Closed-已关闭,Duplicated-重复问题,NFP-无计划修改,Failure-验证失败',
  `type` smallint(0) DEFAULT NULL COMMENT '0-任务类型, ..., 10-前端问题,11 -> 后端问题 ...',
  `reference_url` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '问题详情引用 (通过第三方平台进行管理具体问题详情)',
  `priority` smallint(0) DEFAULT NULL COMMENT '问题优先级 1-最高优化先  5-最低优先级',
  `follower_user_id` bigint(0) DEFAULT NULL COMMENT '跟进人员ID',
  `follower` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '跟进人名称',
  `remark` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `is_deleted` smallint(0) DEFAULT NULL COMMENT '逻辑删除 默认值0, 1为删除标记',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '缺陷信息创建时间',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '缺陷记录更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;