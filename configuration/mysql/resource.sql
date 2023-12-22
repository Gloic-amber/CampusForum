/*
 Navicat Premium Data Transfer

 Source Server         : ubuntu-docker-cf-mysql
 Source Server Type    : MySQL
 Source Server Version : 80100
 Source Host           : 192.168.111.128:3306
 Source Schema         : resource

 Target Server Type    : MySQL
 Target Server Version : 80100
 File Encoding         : 65001

 Date: 22/12/2023 10:33:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '城市id',
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NOT NULL COMMENT '名称',
  `province_id` int UNSIGNED NOT NULL COMMENT '所属省份id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `province_id`(`province_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES (1, '北京市', 1);

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `url` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NOT NULL COMMENT '资料路径',
  `visit` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '访问量',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `img`(`url` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES (1, 'ea0cd1d8102a6d99d78ddef35b312887', 0, '2023-12-14 16:04:56', '2023-12-14 16:04:55');
INSERT INTO `image` VALUES (2, '3881fd5e664335f98ffc7481669cb76a', 0, '2023-12-14 17:13:53', '2023-12-14 17:13:52');
INSERT INTO `image` VALUES (3, '0b627e31f7948365bf585d04fd37a591', 0, '2023-12-15 15:09:05', '2023-12-15 15:09:04');
INSERT INTO `image` VALUES (4, '3c2ebaeeabfc77571bf33a26a69a03eb', 0, '2023-12-15 16:23:24', '2023-12-15 16:23:22');
INSERT INTO `image` VALUES (5, '65588404ec83e34626e084fd1d467942', 17, '2023-12-16 16:11:17', '2023-12-18 10:46:00');
INSERT INTO `image` VALUES (6, '6999dfd768dc1bb59ae217ebe69253b3', 156, '2023-12-16 21:18:03', '2023-12-20 21:16:42');
INSERT INTO `image` VALUES (7, '9d155acc2ef03c348dbac9008661aa44', 144, '2023-12-18 10:41:53', '2023-12-20 21:16:42');
INSERT INTO `image` VALUES (8, '7449aaeb7c8d7592097d038a3d83cd81', 0, '2023-12-18 14:33:43', '2023-12-18 14:33:41');
INSERT INTO `image` VALUES (9, '5ea7dd07219604abeaf91baaec4f7e9f', 183, '2023-12-18 14:45:43', '2023-12-20 21:19:10');
INSERT INTO `image` VALUES (10, '95c000f442567fb8ec0409a68b442b44', 137, '2023-12-18 14:51:35', '2023-12-20 21:16:42');
INSERT INTO `image` VALUES (11, '0ac0dc277839940fca4ff9044b9b9a98', 141, '2023-12-18 14:53:06', '2023-12-20 21:16:42');
INSERT INTO `image` VALUES (12, 'd015029160590c5d2af60c8394bad5e6', 195, '2023-12-18 14:54:27', '2023-12-20 21:19:10');
INSERT INTO `image` VALUES (13, '41c5de2dd1a36231836e70cc83cf3049', 129, '2023-12-19 10:06:43', '2023-12-20 21:19:10');
INSERT INTO `image` VALUES (16, 'd58039334c49bfacdeed3e55ec35bf5c', 0, '2023-12-19 19:40:20', '2023-12-19 19:40:18');
INSERT INTO `image` VALUES (17, '0e0f414036222ef61e0fa86fb1ae51b0', 0, '2023-12-20 12:15:51', '2023-12-20 12:15:50');
INSERT INTO `image` VALUES (18, '04ebe2929112e502da70d3d435c04a07', 1, '2023-12-20 12:25:43', '2023-12-20 12:25:42');
INSERT INTO `image` VALUES (19, '49131c809253e4af133fe458c3decb35', 0, '2023-12-20 12:25:57', '2023-12-20 12:25:56');
INSERT INTO `image` VALUES (20, '0a05df5fc9271900393aedd98fd3b84c', 33, '2023-12-20 15:11:00', '2023-12-20 21:19:10');

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NOT NULL COMMENT '省份名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES (1, '北京市');

-- ----------------------------
-- Table structure for university
-- ----------------------------
DROP TABLE IF EXISTS `university`;
CREATE TABLE `university`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NOT NULL COMMENT '学校名称',
  `identifier` int UNSIGNED NOT NULL COMMENT '学校标识码',
  `code` int UNSIGNED NOT NULL COMMENT '院校代码',
  `city_id` int UNSIGNED NOT NULL COMMENT '所属城市',
  `rank` smallint UNSIGNED NOT NULL COMMENT '办学层次（1本科，2专科）',
  `remark` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `code`(`code` ASC) USING BTREE,
  UNIQUE INDEX `identifier`(`identifier` ASC) USING BTREE,
  INDEX `name`(`name` ASC) USING BTREE,
  INDEX `city_id`(`city_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of university
-- ----------------------------
INSERT INTO `university` VALUES (1, '北京大学', 4111010001, 10001, 1, 1, NULL);
INSERT INTO `university` VALUES (2, '中国人民大学', 4111010002, 10002, 1, 1, NULL);
INSERT INTO `university` VALUES (3, '清华大学', 4111010003, 10003, 1, 1, NULL);
INSERT INTO `university` VALUES (4, '北京交通大学', 4111010004, 10004, 1, 1, NULL);
INSERT INTO `university` VALUES (5, '北京工业大学', 4111010005, 10005, 1, 1, NULL);
INSERT INTO `university` VALUES (6, '北京航空航天大学', 4111010006, 10006, 1, 1, NULL);
INSERT INTO `university` VALUES (7, '北京理工大学', 4111010007, 10007, 1, 1, NULL);

-- ----------------------------
-- Table structure for visit_log
-- ----------------------------
DROP TABLE IF EXISTS `visit_log`;
CREATE TABLE `visit_log`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ip` int UNSIGNED NOT NULL COMMENT 'ip地址',
  `method` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NOT NULL COMMENT '请求方法',
  `uri` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NOT NULL COMMENT '请求资源路径',
  `query_param` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NULL DEFAULT NULL COMMENT '请求url参数',
  `status` int UNSIGNED NOT NULL DEFAULT 200 COMMENT '请求状态码',
  `user_id` int UNSIGNED NULL DEFAULT NULL COMMENT '用户id',
  `creat_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '请求发起时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6271 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of visit_log
-- ----------------------------

-- ----------------------------
-- View structure for university_view
-- ----------------------------
DROP VIEW IF EXISTS `university_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `university_view` AS select `university`.`id` AS `id`,`university`.`name` AS `name`,`university`.`identifier` AS `identifier`,`university`.`code` AS `code`,`province`.`name` AS `province`,`city`.`name` AS `city`,`university`.`rank` AS `rank`,`university`.`remark` AS `remark` from ((`city` join `province`) join `university`) where ((`province`.`id` = `city`.`province_id`) and (`city`.`id` = `university`.`city_id`));

-- ----------------------------
-- View structure for visit_log_view
-- ----------------------------
DROP VIEW IF EXISTS `visit_log_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `visit_log_view` AS select `visit_log`.`id` AS `id`,inet_ntoa(`visit_log`.`ip`) AS `ip`,`visit_log`.`method` AS `method`,`visit_log`.`uri` AS `uri`,`visit_log`.`query_param` AS `query_param`,`visit_log`.`status` AS `status`,`visit_log`.`user_id` AS `user_id`,`visit_log`.`creat_time` AS `creat_time` from `visit_log`;

SET FOREIGN_KEY_CHECKS = 1;
