SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE `cr_issue_task` (
  `id` bigint(20) NOT NULL,
  `org_id` bigint(20) DEFAULT NULL,
  `org_tag` varchar(100) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `ticket` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `originator` varchar(50) DEFAULT NULL,
  `originator_user_id` bigint(20) DEFAULT NULL,
  `module_name` varchar(50) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `type` smallint(6) DEFAULT NULL,
  `reference_url` varchar(512) DEFAULT NULL,
  `priority` smallint(6) DEFAULT NULL,
  `follower_user_id` bigint(20) DEFAULT NULL,
  `follower` varchar(100) DEFAULT NULL,
  `remark` varchar(512) DEFAULT NULL,
  `is_deleted` smallint(6) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;