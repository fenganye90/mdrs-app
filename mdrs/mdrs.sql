/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mdrs

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-05-02 22:08:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT '菜单名称',
  `pid` int(11) DEFAULT NULL COMMENT '父菜单id',
  `zindex` int(2) DEFAULT NULL COMMENT '菜单排序',
  `istype` int(1) DEFAULT NULL COMMENT '权限分类（0 菜单；1 功能）',
  `descpt` varchar(50) DEFAULT NULL COMMENT '描述',
  `code` varchar(20) DEFAULT NULL COMMENT '菜单编号',
  `icon` varchar(30) DEFAULT NULL COMMENT '菜单图标名称',
  `page` varchar(50) DEFAULT NULL COMMENT '菜单url',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加数据时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '系统管理', '0', '100', '0', '系统管理', 'system', '', '/', '2017-12-20 16:22:43', '2018-01-09 19:26:36');
INSERT INTO `permission` VALUES ('2', '用户管理', '1', '1100', '0', '用户管理', 'usermanage', '', '/user/userList', '2017-12-20 16:27:03', '2018-01-09 19:26:30');
INSERT INTO `permission` VALUES ('3', '角色管理', '1', '1200', '0', '角色管理', 'rolemanage', '', '/auth/roleManage', '2017-12-20 16:27:03', '2018-01-09 19:26:42');
INSERT INTO `permission` VALUES ('4', '权限管理', '1', '1300', '0', '权限管理', 'permmanage', null, '/auth/permList', '2017-12-30 19:17:32', '2018-01-09 19:26:48');
INSERT INTO `permission` VALUES ('5', '日志管理', '0', '200', '0', '日志管理类', 'log', null, '/', '2018-04-15 09:26:11', '2018-04-15 09:27:26');
INSERT INTO `permission` VALUES ('6', '日志管理', '5', '2100', '1', '', 'logManage', null, '/log/logList', '2018-04-15 09:27:08', '2018-04-15 09:27:33');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(50) DEFAULT NULL COMMENT '角色描述',
  `code` varchar(20) DEFAULT NULL COMMENT '角色编号',
  `insert_uid` int(11) DEFAULT NULL COMMENT '操作用户id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加数据时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理', '超级管理员', 'superman', null, '2018-01-09 19:28:53', '2018-04-17 16:41:19');
INSERT INTO `role` VALUES ('5', '测试', '1', '测试', null, '2018-04-17 16:41:35', '2018-04-17 16:41:34');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `permit_id` int(5) NOT NULL AUTO_INCREMENT,
  `role_id` int(5) NOT NULL,
  PRIMARY KEY (`permit_id`,`role_id`),
  KEY `perimitid` (`permit_id`) USING BTREE,
  KEY `roleid` (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1');
INSERT INTO `role_permission` VALUES ('2', '1');
INSERT INTO `role_permission` VALUES ('2', '5');
INSERT INTO `role_permission` VALUES ('3', '1');
INSERT INTO `role_permission` VALUES ('3', '5');
INSERT INTO `role_permission` VALUES ('4', '1');
INSERT INTO `role_permission` VALUES ('4', '5');
INSERT INTO `role_permission` VALUES ('5', '1');
INSERT INTO `role_permission` VALUES ('6', '1');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 'ceshi');
INSERT INTO `test` VALUES ('2', '1234');
INSERT INTO `test` VALUES ('3', '23451');
INSERT INTO `test` VALUES ('4', '22211');
INSERT INTO `test` VALUES ('5', '211');
INSERT INTO `test` VALUES ('6', '1212');
INSERT INTO `test` VALUES ('7', '12111');
INSERT INTO `test` VALUES ('8', '12111');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(20) DEFAULT NULL COMMENT '登录名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `default_url` int(11) NOT NULL DEFAULT '1' COMMENT '默认登录界面，1为后端，2为前端',
  `real_name` varchar(50) NOT NULL COMMENT '用户实际姓名',
  `is_forbidden` int(11) NOT NULL DEFAULT '0' COMMENT '是否禁用，默认0为可使用，1为禁用',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '用户类型，0为平台用户，1位HIS用户',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话',
  `description` varchar(128) DEFAULT NULL COMMENT '用户描述',
  `professional` varchar(128) DEFAULT NULL COMMENT '用户专业',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `idx_name` (`username`) USING BTREE,
  KEY `idx_forbid` (`is_forbidden`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '1', '系统管理员', '0', '0', '12345678901', '系统管理员', '系统管理员', '2018-04-12 16:23:10', '2018-04-17 16:39:40');
INSERT INTO `user` VALUES ('27', '1', '7fa8282ad93047a4d6fe6111c93b308a', '2', '1', '0', '1', '11', '1', '1', '2018-04-14 23:55:24', '2018-04-17 16:39:52');
INSERT INTO `user` VALUES ('28', '测试', '1bbd886460827015e5d605ed44252251', '2', '1', '0', '1', '1', '1', '1', '2018-04-17 16:40:21', '2018-04-17 16:40:21');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(5) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `userid` (`user_id`) USING BTREE,
  KEY `roleid` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('27', '1');
INSERT INTO `user_role` VALUES ('28', '1');
