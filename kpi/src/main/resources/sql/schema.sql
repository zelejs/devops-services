SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE `kpi_coding_commit_record` (
  `id` bigint(20) NOT NULL COMMENT '璁板綍ID',
  `org_id` bigint(20) DEFAULT NULL COMMENT '鐢ㄤ簬闅旂鐨勭粍缁嘔D锛岀敱crud-plus缁存姢锛堜繚鐣欎究浜庢墿灞曪級',
  `org_tag` varchar(100) DEFAULT NULL COMMENT '鐢ㄤ簬闅旂鐨勭粍缁囨爣璇�',
  `module_id` bigint(20) DEFAULT NULL COMMENT '妯″潡ID',
  `module_name` varchar(100) DEFAULT NULL COMMENT '妯″潡鍚嶇О',
  `commit_id` varchar(256) DEFAULT NULL COMMENT '鎻愪氦ID',
  `commit_author` varchar(64) DEFAULT NULL COMMENT '浣滆��',
  `commit_comment` varchar(512) DEFAULT NULL COMMENT '璇勮鍐呭',
  `commit_lines` int(11) DEFAULT NULL COMMENT '鎻愪氦琛屾暟',
  `is_deleted` smallint(6) DEFAULT NULL COMMENT '閫昏緫鍒犻櫎 榛樿鍊�0, 1涓哄垹闄ゆ爣璁�',
  `create_time` datetime DEFAULT NULL COMMENT '璁板綍鍒涘缓鏃堕棿锛宑rud-plus妗嗘灦淇濈暀瀛楁**,**鑷姩蹇界暐鏇存柊',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

CREATE TABLE `kpi_coding_module` (
  `id` bigint(20) NOT NULL COMMENT '妯″潡ID',
  `org_id` bigint(20) DEFAULT NULL COMMENT '鐢ㄤ簬闅旂鐨勭粍缁嘔D锛岀敱crud-plus缁存姢',
  `org_tag` varchar(100) DEFAULT NULL COMMENT '鐢ㄤ簬闅旂鐨勭粍缁囨爣璇�',
  `name` varchar(100) DEFAULT NULL COMMENT '妯″潡鍚嶇О',
  `project_id` bigint(20) DEFAULT NULL COMMENT '浠撳簱ID',
  `project_name` varchar(100) DEFAULT NULL COMMENT '妯″潡浠ｇ爜椤圭洰鍚嶇О',
  `repo_url` varchar(100) DEFAULT NULL COMMENT '浠撳簱鍦板潃',
  `is_deleted` smallint(6) DEFAULT NULL COMMENT '閫昏緫鍒犻櫎 榛樿鍊�0, 1涓哄垹闄ゆ爣璁�',
  `create_time` datetime DEFAULT NULL COMMENT '妯″潡淇℃伅鍒涘缓鏃堕棿锛宑rud-plus妗嗘灦淇濈暀瀛楁**,**鑷姩蹇界暐鏇存柊',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `kpi_coding_project` (
  `id` bigint(20) NOT NULL COMMENT '璁板綍ID',
  `org_id` bigint(20) DEFAULT NULL COMMENT '鐢ㄤ簬闅旂鐨勭粍缁嘔D锛岀敱crud-plus缁存姢锛堜繚鐣欎究浜庢墿灞曪級',
  `org_tag` varchar(100) DEFAULT NULL COMMENT '鐢ㄤ簬闅旂鐨勭粍缁囨爣璇�',
  `name` varchar(100) DEFAULT NULL COMMENT '椤圭洰鍚嶇О',
  `client_id` bigint(20) DEFAULT NULL COMMENT '瀹㈡埛ID',
  `desc` varchar(2000) DEFAULT NULL COMMENT '椤圭洰鎻忚堪',
  `is_deleted` smallint(6) DEFAULT NULL COMMENT '閫昏緫鍒犻櫎 榛樿鍊�0, 1涓哄垹闄ゆ爣璁�',
  `create_time` datetime DEFAULT NULL COMMENT '椤圭洰淇℃伅鍒涘缓鏃堕棿锛宑rud-plus妗嗘灦淇濈暀瀛楁,鑷姩蹇界暐鏇存柊',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `kpi_coding_submitter` (
  `id` bigint(20) NOT NULL COMMENT '浜哄憳ID',
  `org_id` bigint(20) DEFAULT NULL COMMENT '鐢ㄤ簬闅旂鐨勭粍缁嘔D锛岀敱crud-plus缁存姢',
  `org_tag` varchar(100) DEFAULT NULL COMMENT '鐢ㄤ簬闅旂鐨勭粍缁囨爣璇�',
  `commit_author` varchar(100) DEFAULT NULL COMMENT '寮�鍙戣�呭悕绉�',
  `commit_email` varchar(100) DEFAULT NULL COMMENT '寮�鍙戣�呴偖绠�',
  `user_id` bigint(20) DEFAULT NULL COMMENT '绯荤粺鐢ㄦ埛ID',
  `create_time` datetime DEFAULT NULL COMMENT '寮�鍙戜汉鍛樹俊鎭垱寤烘椂闂达紝crud-plus妗嗘灦淇濈暀瀛楁,鑷姩蹇界暐鏇存柊',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;