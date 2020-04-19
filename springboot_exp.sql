/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : 39.106.41.184:33306
 Source Schema         : springboot_exp

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 19/04/2020 21:13:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(10) NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` enum('1','2') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'godfrey', '1', 'abc');
INSERT INTO `t_user` VALUES (2, 'duiyi', '2', 'cba');
INSERT INTO `t_user` VALUES (3, 'echo', '1', 'wzjsd');
INSERT INTO `t_user` VALUES (4, 'meimei', '2', 'xiaoxiao');
INSERT INTO `t_user` VALUES (5, 'didi', '1', 'sl');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'godfrey', 21, '123456789@163.com');
INSERT INTO `user` VALUES (2, 'duiyi', 23, '2135165151@qq.com');
INSERT INTO `user` VALUES (3, 'echo', 15, '3516516@136.com');
INSERT INTO `user` VALUES (4, 'wu', 45, '155616@31.com');
INSERT INTO `user` VALUES (5, 'guo', 16, '61611848@gmail.com');
INSERT INTO `user` VALUES (6, 'booleanbl', 12, '837@qq.com');
INSERT INTO `user` VALUES (7, 'wenda', 12, '8377@qq.com');
INSERT INTO `user` VALUES (8, 'booleanbl', 12, '83774@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
