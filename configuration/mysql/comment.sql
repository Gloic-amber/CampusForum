/*
 Navicat Premium Data Transfer

 Source Server         : ubuntu-docker-cf-mysql
 Source Server Type    : MySQL
 Source Server Version : 80100
 Source Host           : 192.168.111.128:3306
 Source Schema         : comment

 Target Server Type    : MySQL
 Target Server Version : 80100
 File Encoding         : 65001

 Date: 22/12/2023 10:31:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int UNSIGNED NOT NULL COMMENT '用户id',
  `blog_id` int UNSIGNED NOT NULL COMMENT '博客id',
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NOT NULL COMMENT '评论内容',
  `parent_id` int UNSIGNED NULL DEFAULT NULL COMMENT '父评论id',
  `parent_user_id` int UNSIGNED NULL DEFAULT NULL COMMENT '父评论用户id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '是否已经删除，0未删除，1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_comment_user_id`(`user_id` ASC) USING BTREE,
  INDEX `index_comment_blog_id`(`blog_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (12, 1, 13, '写得很好！', NULL, NULL, '2023-12-18 10:54:29', 0);
INSERT INTO `comment` VALUES (13, 1, 16, '电饭锅大范甘迪', NULL, NULL, '2023-12-20 09:48:29', 1);
INSERT INTO `comment` VALUES (14, 1, 16, '订个蛋糕电饭锅', NULL, NULL, '2023-12-20 09:48:52', 1);
INSERT INTO `comment` VALUES (15, 1, 16, '电饭锅电饭锅', 14, 1, '2023-12-20 09:48:55', 1);
INSERT INTO `comment` VALUES (16, 11, 18, '写得很好', NULL, NULL, '2023-12-20 12:14:10', 1);
INSERT INTO `comment` VALUES (17, 11, 18, '胜多负少的方式', NULL, NULL, '2023-12-20 12:14:16', 0);
INSERT INTO `comment` VALUES (18, 11, 18, '电饭锅电饭锅', 17, 11, '2023-12-20 12:14:21', 0);
INSERT INTO `comment` VALUES (19, 13, 18, '啊干啥', NULL, NULL, '2023-12-20 12:24:03', 0);
INSERT INTO `comment` VALUES (20, 13, 18, '刚发给', 17, 11, '2023-12-20 12:24:09', 0);

SET FOREIGN_KEY_CHECKS = 1;
