/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : springboot_layui

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 27/03/2020 22:54:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission`  (
  `pid` int(32) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_permission
-- ----------------------------
INSERT INTO `tb_permission` VALUES (1, '用户管理', '/user/info', '进入/user/info页面');
INSERT INTO `tb_permission` VALUES (2, '添加用户', '/user/add', '添加用户按钮');
INSERT INTO `tb_permission` VALUES (3, '修改用户', '/user/edit', '修改用户按钮');
INSERT INTO `tb_permission` VALUES (4, '删除用户', '/user/delete', '删除用户按钮');
INSERT INTO `tb_permission` VALUES (5, '角色管理', '/role/info', '进入/role/info页面');
INSERT INTO `tb_permission` VALUES (6, '添加角色', '/role/add', '添加角色按钮');
INSERT INTO `tb_permission` VALUES (7, '修改角色', '/role/edit', '修改角色按钮');
INSERT INTO `tb_permission` VALUES (8, '删除角色', '/role/delete', '删除角色按钮');
INSERT INTO `tb_permission` VALUES (9, '权限管理', '/permission/info', '进入/permission/info页面');
INSERT INTO `tb_permission` VALUES (10, '添加权限', '/permission/add', '添加权限按钮');
INSERT INTO `tb_permission` VALUES (11, '修改权限', '/permission/edit', '修改权限按钮');
INSERT INTO `tb_permission` VALUES (12, '删除权限', '/permission/delete', '删除权限按钮');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `rid` int(32) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES (1, '超级管理员', '这是超级管理员');
INSERT INTO `tb_role` VALUES (2, '管理员', '这是管理员');
INSERT INTO `tb_role` VALUES (3, '用户', '这是用户');

-- ----------------------------
-- Table structure for tb_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_permission`;
CREATE TABLE `tb_role_permission`  (
  `rid` int(32) NOT NULL,
  `pid` int(32) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role_permission
-- ----------------------------
INSERT INTO `tb_role_permission` VALUES (1, 1);
INSERT INTO `tb_role_permission` VALUES (1, 2);
INSERT INTO `tb_role_permission` VALUES (1, 3);
INSERT INTO `tb_role_permission` VALUES (1, 4);
INSERT INTO `tb_role_permission` VALUES (1, 5);
INSERT INTO `tb_role_permission` VALUES (1, 6);
INSERT INTO `tb_role_permission` VALUES (1, 7);
INSERT INTO `tb_role_permission` VALUES (1, 8);
INSERT INTO `tb_role_permission` VALUES (1, 9);
INSERT INTO `tb_role_permission` VALUES (1, 10);
INSERT INTO `tb_role_permission` VALUES (1, 11);
INSERT INTO `tb_role_permission` VALUES (1, 12);
INSERT INTO `tb_role_permission` VALUES (2, 1);
INSERT INTO `tb_role_permission` VALUES (2, 2);
INSERT INTO `tb_role_permission` VALUES (2, 3);
INSERT INTO `tb_role_permission` VALUES (2, 5);
INSERT INTO `tb_role_permission` VALUES (2, 6);
INSERT INTO `tb_role_permission` VALUES (2, 7);
INSERT INTO `tb_role_permission` VALUES (2, 9);
INSERT INTO `tb_role_permission` VALUES (2, 10);
INSERT INTO `tb_role_permission` VALUES (2, 11);
INSERT INTO `tb_role_permission` VALUES (3, 1);
INSERT INTO `tb_role_permission` VALUES (3, 5);
INSERT INTO `tb_role_permission` VALUES (3, 9);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `uid` int(32) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `lastlogintime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'root', '165ee9e44b1bccf52e0240181fb33223', '正常', '2020-03-17 15:26:03', '2020-03-27 22:51:35', '1');
INSERT INTO `tb_user` VALUES (2, 'admin', 'fb2c738f116e743c4359f4bbaa9b4e07', '正常', '2020-03-17 15:26:14', '2020-03-27 17:39:36', '2');
INSERT INTO `tb_user` VALUES (3, 'user', '0031169aaeb05749f4b013dd74cd47fc', '正常', '2020-03-17 15:26:28', '2020-03-27 17:05:14', '3');
INSERT INTO `tb_user` VALUES (40, 'root1', '0ca54508ba32f7c6cf0dea734ea93bd6', '正常', '2020-03-19 06:01:05', '2020-03-25 22:08:29', '2');
INSERT INTO `tb_user` VALUES (41, 'root2', '93a7236b2bf77eb4f32e97b15a59fec7', '正常', '2020-03-19 13:33:35', '2020-03-25 22:08:16', '1');
INSERT INTO `tb_user` VALUES (43, 'root3', '5102bd141313d72259b99e34355d224d', '正常', '2020-03-23 23:19:16', '2020-03-25 22:08:01', '1');
INSERT INTO `tb_user` VALUES (44, 'root4', 'b8ccf83082ea0fb00f0f2f634923f688', '正常', '2020-03-23 23:40:06', '2020-03-24 18:59:38', '1');
INSERT INTO `tb_user` VALUES (45, 'root5', '741587f9e8c21bc02cf6d87398baa1af', '正常', '2020-03-24 19:01:08', '2020-03-24 19:01:08', '1');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role`  (
  `uid` int(32) NOT NULL,
  `rid` int(32) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES (1, 1);
INSERT INTO `tb_user_role` VALUES (2, 2);
INSERT INTO `tb_user_role` VALUES (3, 3);

SET FOREIGN_KEY_CHECKS = 1;
