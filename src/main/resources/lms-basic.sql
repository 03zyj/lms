CREATE TABLE `sys_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL DEFAULT '0' COMMENT '用户名',
  `password` varchar(64) NOT NULL DEFAULT '0' COMMENT '密码',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `enabled` int DEFAULT NULL COMMENT '0无效用户，1是有效用户',
  `phone` varchar(16) DEFAULT NULL COMMENT '手机号',
  `email` varchar(32) DEFAULT NULL COMMENT 'email',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表';

INSERT INTO `sys_user` (`id`, `username`, `password`, `create_time`, `enabled`, `phone`, `email`)
VALUES
  (1,'admin','$2a$10$X/uMNuiis.fyO47cxbta3OSs2sllSeLcwVfC0.ghyxeVVZRmAbzk2','2023-06-19 13:18:54',1,NULL,'admin@example.com'),
  (2,'user','$2a$10$X/uMNuiis.fyO47cxbta3OSs2sllSeLcwVfC0.ghyxeVVZRmAbzk2','2023-06-19 13:19:01',1,NULL,'user@example.com');

# ===

CREATE TABLE `sys_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) NOT NULL DEFAULT '0' COMMENT '角色名称',
  `role_desc` varchar(128) NOT NULL DEFAULT '0' COMMENT '角色描述',
  `role_code` varchar(32) NOT NULL DEFAULT '0' COMMENT '角色的英文code.如：ADMIN',
  `sort` int NOT NULL DEFAULT '0' COMMENT '角色顺序',
  `status` int DEFAULT NULL COMMENT '0表示可用',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '角色的创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统角色表';

INSERT INTO `sys_role` (`id`, `role_name`, `role_desc`, `role_code`, `sort`, `status`, `create_time`)
VALUES
  (1,'管理员','','admin',0,NULL,'2023-06-18 16:00:21'),
  (2,'普通用户','','user',0,NULL,'2023-06-18 16:00:40');

# ===

CREATE TABLE `sys_user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int NOT NULL DEFAULT '0' COMMENT '角色自增id',
  `user_id` int NOT NULL DEFAULT '0' COMMENT '用户自增id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色关系表';

INSERT INTO `sys_user_role` (`id`, `role_id`, `user_id`)
VALUES
  (1,1,1),
  (2,2,2);

# ===

CREATE TABLE `sys_menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `menu_pid` int NOT NULL COMMENT '父菜单ID',
  `menu_name` varchar(16) NOT NULL COMMENT '菜单名称',
  `url` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '跳转URL',
  `icon` varchar(45) DEFAULT NULL,
  `sort` tinyint NOT NULL DEFAULT '0' COMMENT '排序',
  `level` tinyint NOT NULL COMMENT '菜单层级',
  `status` tinyint NOT NULL COMMENT '0:启用,1:禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统菜单表';

INSERT INTO `sys_menu` (`id`, `menu_pid`, `menu_name`, `url`, `icon`, `sort`, `level`, `status`)
VALUES
  (1,0,'Dashboard','/backend/dashboard','tachometer-alt',0,0,1),
  (2,0,'Empty','/backend/empty','square',0,0,1);

# ===

CREATE TABLE `sys_role_menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int NOT NULL DEFAULT '0' COMMENT '角色id',
  `menu_id` int NOT NULL DEFAULT '0' COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色权限关系表';

INSERT INTO `sys_role_menu` (`id`, `role_id`, `menu_id`)
VALUES
  (1,1,1),
  (2,1,2);
