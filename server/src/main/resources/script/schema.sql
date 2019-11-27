/*
Source Server         : localhost_3306
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : zuul-auth
Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001
Date: 2018-12-07 17:26:38
*/

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `code` varchar(255) DEFAULT NULL COMMENT '菜单编码',
                            `p_code` varchar(255) DEFAULT NULL COMMENT '菜单父编码',
                            `p_id` varchar(255) DEFAULT NULL COMMENT '父菜单ID',
                            `name` varchar(255) DEFAULT NULL COMMENT '名称',
                            `url` varchar(255) DEFAULT NULL COMMENT '请求地址',
                            `is_menu` int(11) DEFAULT NULL COMMENT '是否是菜单(1.菜单。2.按钮)',
                            `level` int(11) DEFAULT NULL COMMENT '菜单层级',
                            `sort` int(11) DEFAULT NULL COMMENT '菜单排序',
                            `status` int(11) DEFAULT NULL,
                            `icon` varchar(255) DEFAULT NULL,
                            `create_time` datetime DEFAULT NULL,
                            `update_time` datetime DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `FK_CODE` (`code`)
);


-- ----------------------------
-- Table structure for sys_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege` (
                                 `role_id` int(11) NOT NULL,
                                 `menu_id` int(11) NOT NULL,
                                 `create_time` datetime DEFAULT NULL,
                                 PRIMARY KEY (`role_id`,`menu_id`)
);


-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `name` varchar(255) DEFAULT NULL,
                            `value` varchar(255) DEFAULT NULL,
                            `tips` varchar(255) DEFAULT NULL,
                            `create_time` datetime DEFAULT NULL,
                            `update_time` datetime DEFAULT NULL,
                            `status` int(11) NOT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `unique_role_name` (`name`),
                            UNIQUE KEY `unique_role_value` (`value`)
);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `avatar` varchar(255) DEFAULT NULL,
                            `username` varchar(45) DEFAULT NULL,
                            `password` varchar(96) DEFAULT NULL,
                            `salt` varchar(45) DEFAULT NULL,
                            `name` varchar(45) DEFAULT NULL,
                            `birthday` date DEFAULT NULL,
                            `sex` int(11) DEFAULT NULL,
                            `email` varchar(45) DEFAULT NULL,
                            `phone` varchar(45) DEFAULT NULL,
                            `status` int(11) DEFAULT NULL,
                            `create_time` datetime DEFAULT NULL,
                            `update_time` datetime DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `unique_user_username` (`username`)
);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `user_id` int(11) DEFAULT NULL,
                                 `role_id` int(11) DEFAULT NULL,
                                 `create_time` datetime DEFAULT NULL,
                                 `create_by` varchar(255) DEFAULT NULL,
                                 PRIMARY KEY (`id`)
);
