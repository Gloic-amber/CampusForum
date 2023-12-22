/*
 Navicat Premium Data Transfer

 Source Server         : ubuntu-docker-cf-mysql
 Source Server Type    : MySQL
 Source Server Version : 80100
 Source Host           : 192.168.111.128:3306
 Source Schema         : user

 Target Server Type    : MySQL
 Target Server Version : 80100
 File Encoding         : 65001

 Date: 22/12/2023 10:33:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NOT NULL COMMENT '用户名',
  `school_code` int UNSIGNED NULL DEFAULT NULL COMMENT '院校代码',
  `nickname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NULL DEFAULT NULL COMMENT '昵称',
  `avatar_url` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NULL DEFAULT NULL COMMENT '头像链接',
  `register_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `deleted` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '0为未删除，已删除时该值等于id，以避免唯一索引的异常',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC, `deleted` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'gloic', 10002, 'gloic', 'http://127.0.0.1/resource/avatar/d58039334c49bfacdeed3e55ec35bf5c', '2023-11-28 22:09:32', 0);
INSERT INTO `user` VALUES (2, 'css', 10001, 'css', 'http://127.0.0.1/resource/avatar/default_avatar.jpg', '2023-11-28 22:32:42', 0);
INSERT INTO `user` VALUES (3, 'aaabbb', 10003, 'aaabbb', 'http://127.0.0.1/resource/avatar/default_avatar.jpg', '2023-12-12 15:39:33', 0);
INSERT INTO `user` VALUES (4, 'qqqqqq', 10005, 'qqqqqq', 'http://127.0.0.1/resource/avatar/7449aaeb7c8d7592097d038a3d83cd81', '2023-12-15 14:49:56', 0);
INSERT INTO `user` VALUES (5, 'test1', 10004, 'test1', 'http://127.0.0.1/resource/avatar/default_avatar.jpg', '2023-12-18 14:49:36', 0);
INSERT INTO `user` VALUES (7, 'test2', 10005, 'test2', 'http://127.0.0.1/resource/avatar/default_avatar.jpg', '2023-12-18 15:03:29', 0);
INSERT INTO `user` VALUES (9, 'bbbbbb', 10003, 'bbbbbb', 'http://127.0.0.1/resource/avatar/default_avatar.jpg', '2023-12-20 10:44:29', 0);
INSERT INTO `user` VALUES (10, 'testttt', 10003, 'testttt', 'http://127.0.0.1/resource/avatar/default_avatar.jpg', '2023-12-20 11:55:23', 0);
INSERT INTO `user` VALUES (11, 'llllll', 10002, 'asdfsf', 'http://127.0.0.1/resource/avatar/0e0f414036222ef61e0fa86fb1ae51b0', '2023-12-20 12:12:49', 0);
INSERT INTO `user` VALUES (12, 'ababab', 10002, 'ababab', 'http://127.0.0.1/resource/avatar/default_avatar.jpg', '2023-12-20 12:21:51', 0);
INSERT INTO `user` VALUES (13, 'oooooo', 10003, 'sdfsf', 'http://127.0.0.1/resource/avatar/0e0f414036222ef61e0fa86fb1ae51b0', '2023-12-20 12:23:15', 0);

-- ----------------------------
-- Table structure for user_basic
-- ----------------------------
DROP TABLE IF EXISTS `user_basic`;
CREATE TABLE `user_basic`  (
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NOT NULL COMMENT '用户名',
  `realname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `birthday` datetime NULL DEFAULT NULL COMMENT '生日',
  `intro` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NULL DEFAULT NULL COMMENT '个人简介',
  `gender` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '性别',
  `city_id` int UNSIGNED NULL DEFAULT NULL COMMENT '城市id',
  `province_id` int UNSIGNED NULL DEFAULT NULL COMMENT '省份id',
  `name_modify_time` datetime NULL DEFAULT NULL COMMENT '用户名修改时间',
  `start_work_time` datetime NULL DEFAULT NULL COMMENT '开始工作的时间',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '信息修改时间',
  `deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0为未删除，1为已删除',
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_basic
-- ----------------------------

-- ----------------------------
-- Table structure for user_education
-- ----------------------------
DROP TABLE IF EXISTS `user_education`;
CREATE TABLE `user_education`  (
  `user_id` int UNSIGNED NOT NULL COMMENT '用户名',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `school` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NULL DEFAULT NULL COMMENT '学校名称',
  `school_id` int UNSIGNED NULL DEFAULT NULL COMMENT '学校id',
  `profession` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NULL DEFAULT NULL COMMENT '专业',
  `degree` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '学位程度',
  `start_time` datetime NULL DEFAULT NULL COMMENT '入学时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '毕业时间',
  `audit_img_url` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NULL DEFAULT NULL COMMENT '图片链接',
  `safety_audit_status` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NULL DEFAULT NULL COMMENT '安全审核状态',
  `status` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NULL DEFAULT NULL COMMENT '状态码',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0为未删除，1为已删除',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_education
-- ----------------------------

-- ----------------------------
-- Table structure for user_follow
-- ----------------------------
DROP TABLE IF EXISTS `user_follow`;
CREATE TABLE `user_follow`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `fans_id` int UNSIGNED NOT NULL COMMENT '粉丝id',
  `follow_id` int UNSIGNED NOT NULL COMMENT '关注id',
  `note` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态码',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0为未删除，1为已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`fans_id` ASC) USING BTREE,
  INDEX `follow_id`(`follow_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_follow
-- ----------------------------
INSERT INTO `user_follow` VALUES (1, 1, 2, NULL, 1, '2023-11-29 12:38:10', 0);
INSERT INTO `user_follow` VALUES (2, 2, 1, NULL, 1, '2023-11-29 03:41:00', 0);
INSERT INTO `user_follow` VALUES (3, 1, 3, NULL, 1, '2023-12-12 15:42:23', 0);
INSERT INTO `user_follow` VALUES (4, 4, 1, NULL, 1, '2023-12-16 21:31:22', 0);
INSERT INTO `user_follow` VALUES (5, 1, 5, NULL, 1, '2023-12-18 15:26:55', 0);
INSERT INTO `user_follow` VALUES (6, 1, 4, NULL, 0, '2023-12-20 09:40:00', 0);
INSERT INTO `user_follow` VALUES (7, 11, 1, NULL, 1, '2023-12-20 12:14:01', 0);
INSERT INTO `user_follow` VALUES (8, 13, 1, NULL, 1, '2023-12-20 12:23:51', 0);

-- ----------------------------
-- Table structure for user_general
-- ----------------------------
DROP TABLE IF EXISTS `user_general`;
CREATE TABLE `user_general`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int UNSIGNED NOT NULL COMMENT '用户id',
  `like_num` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户获赞',
  `fans_num` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户粉丝数',
  `comment_num` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户评论数',
  `collect_num` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '收藏博客数量',
  `view_num` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '访问数',
  `blog_num` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户博客数量',
  `week_rank` int UNSIGNED NULL DEFAULT NULL COMMENT '周排行',
  `total_rank` int UNSIGNED NULL DEFAULT NULL COMMENT '总排行',
  `deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0为未删除，1为已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `index_user_general_user_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_general
-- ----------------------------
INSERT INTO `user_general` VALUES (1, 1, 3, 0, 0, 2, 35, 0, NULL, NULL, 0);
INSERT INTO `user_general` VALUES (2, 2, 2, 0, 0, 2, 11, 0, NULL, NULL, 0);
INSERT INTO `user_general` VALUES (3, 3, 0, 0, 0, 0, 0, 0, NULL, NULL, 0);
INSERT INTO `user_general` VALUES (4, 4, 0, 0, 0, 0, 30, 0, NULL, NULL, 0);
INSERT INTO `user_general` VALUES (5, 5, 1, 0, 0, 0, 10, 0, NULL, NULL, 0);
INSERT INTO `user_general` VALUES (6, 7, 0, 0, 0, 0, 0, 0, NULL, NULL, 0);
INSERT INTO `user_general` VALUES (7, 9, 0, 0, 0, 0, 0, 0, NULL, NULL, 0);
INSERT INTO `user_general` VALUES (8, 10, 0, 0, 0, 0, 0, 0, NULL, NULL, 0);
INSERT INTO `user_general` VALUES (9, 11, 0, 0, 0, 0, 0, 0, NULL, NULL, 0);
INSERT INTO `user_general` VALUES (10, 12, 0, 0, 0, 0, 0, 0, NULL, NULL, 0);
INSERT INTO `user_general` VALUES (11, 13, 0, 0, 0, 0, 0, 0, NULL, NULL, 0);

-- ----------------------------
-- Table structure for user_safety
-- ----------------------------
DROP TABLE IF EXISTS `user_safety`;
CREATE TABLE `user_safety`  (
  `user_id` int UNSIGNED NOT NULL COMMENT '用户id',
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NOT NULL COMMENT '密码',
  `mail` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NOT NULL COMMENT '邮箱',
  `mobile` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NULL DEFAULT NULL COMMENT '手机号',
  `deleted` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '0为未删除，已删除时该值等于id，以避免唯一索引的异常',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `mail`(`mail` ASC, `deleted` ASC) USING BTREE,
  UNIQUE INDEX `mobile`(`mobile` ASC, `deleted` ASC) USING BTREE,
  INDEX `index_user_safety_user_general_1`(`username` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_safety
-- ----------------------------
INSERT INTO `user_safety` VALUES (1, 'gloic', '$2a$10$6DX7LslCIrQJp/15b4Jzp.pMZXvuE4ZxwFBtz/Mg2jbrMP3GH2eES', 'test1@qq.com', '13299994453', 0);
INSERT INTO `user_safety` VALUES (2, 'css', '$2a$10$PDyiy9PeoTNn/Ad2VZmaeeVxoj1WhAlKV6AYEclcVtc4FnVSnHKEa', 'test2@qq.com', '13244567655', 0);
INSERT INTO `user_safety` VALUES (3, 'aaabbb', '$2a$10$4RCtOdb46Y1E3Gt84YApPujWvW3781KE0EJKsJZF7LfHBxP3OC2jm', 'test@qq.com', '13245677654', 0);
INSERT INTO `user_safety` VALUES (4, 'qqqqqq', '$2a$10$/YDDRqXtYQQPqKanvckzuOKDr7hCIZgRuv6/EObKNjq9ZdMKC2fgK', 'tetst@QQ.com', '15877779999', 0);
INSERT INTO `user_safety` VALUES (5, 'test1', '$2a$10$gDerEjAtPIADre8o.YItTeNOp1Ey1h7dlN8C5c9quPhgRYjPpzlpO', 'test4@qq.com', '13456778998', 0);
INSERT INTO `user_safety` VALUES (7, 'test2', '$2a$10$O.TIHonB1L1bXOKhxGx4KuDHaf49kuChPBlExeno4SRZmU0OHNoa.', 'test3@qq.com', '13455556666', 0);
INSERT INTO `user_safety` VALUES (9, 'bbbbbb', '$2a$10$H48yM7nMpCGeanI1OIEfHuccAXsZkJisuHRBdpNSiJ5QT3VS5TMlC', 'test7@qq.com', '13267689755', 0);
INSERT INTO `user_safety` VALUES (10, 'testttt', '$2a$10$FOxHg9sIjFxFMsqKIYqMW.4VzJNvDFfvQbZ8oo6ZUk2GAAAgJpoPK', 'tetstttt@qq.com', '13255678432', 0);
INSERT INTO `user_safety` VALUES (11, 'llllll', '$2a$10$KnSqf1ay6ayqaDF.GRShX.8Yyj9DAAKAYcUmK6DPcv7AA6/A9mPB6', 'test9@qq.com', '13265674646', 0);
INSERT INTO `user_safety` VALUES (12, 'ababab', '$2a$10$hSvbfBPkksI38KvfKfFsgO9U68mCXHaK2JfcYP6b3Kfs8Vs96kE32', 'testttttttttt@qq.com', '13279655438', 0);
INSERT INTO `user_safety` VALUES (13, 'oooooo', '$2a$10$NKUQ9pmr3LUAKkh7EEH9W.uWbeYdMpNG9Lp9lPTPVpUmRC5TaL5AC', '99@qq.com', '13256782345', 0);

-- ----------------------------
-- View structure for fans_view
-- ----------------------------
DROP VIEW IF EXISTS `fans_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `fans_view` AS select `user_follow`.`id` AS `id`,`user_follow`.`follow_id` AS `user_id`,`user_follow`.`fans_id` AS `fans_id`,`user_follow`.`note` AS `note`,`user_follow`.`status` AS `status`,`user_follow`.`create_time` AS `create_time`,`user_view`.`username` AS `username`,`user_view`.`nickname` AS `nickname`,`user_view`.`school_code` AS `school_code`,`user_view`.`avatar_url` AS `avatar_url`,`user_view`.`register_time` AS `register_time` from (`user_follow` left join `user_view` on((`user_follow`.`fans_id` = `user_view`.`id`))) where (`user_follow`.`deleted` = 0);

-- ----------------------------
-- View structure for follow_view
-- ----------------------------
DROP VIEW IF EXISTS `follow_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `follow_view` AS select `user_follow`.`id` AS `id`,`user_follow`.`fans_id` AS `user_id`,`user_follow`.`follow_id` AS `follow_id`,`user_follow`.`note` AS `note`,`user_follow`.`status` AS `status`,`user_follow`.`create_time` AS `create_time`,`user_view`.`username` AS `username`,`user_view`.`nickname` AS `nickname`,`user_view`.`school_code` AS `school_code`,`user_view`.`avatar_url` AS `avatar_url`,`user_view`.`register_time` AS `register_time` from (`user_follow` left join `user_view` on((`user_view`.`id` = `user_follow`.`follow_id`))) where (`user_follow`.`deleted` = 0);

-- ----------------------------
-- View structure for user_view
-- ----------------------------
DROP VIEW IF EXISTS `user_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `user_view` AS select `user`.`id` AS `id`,`user`.`username` AS `username`,`user`.`nickname` AS `nickname`,`user`.`school_code` AS `school_code`,`user`.`avatar_url` AS `avatar_url`,`user`.`register_time` AS `register_time`,`user`.`deleted` AS `deleted` from `user` where (`user`.`deleted` = 0);

SET FOREIGN_KEY_CHECKS = 1;
