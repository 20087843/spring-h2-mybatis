
-- ----------------------------
-- Records of sys_privilege
-- ----------------------------
insert into sys_privilege (role_id, menu_id, create_time) VALUES
(6, 1, '2017-06-26 12:46:09'),
(6, 2, '2017-06-26 12:46:09'),
(6, 3, '2017-06-26 12:46:09'),
(8, 1, '2017-06-26 12:46:09');

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role`(id, name, value, tips, create_time, update_time, status) VALUES
('6', '管理员', 'admin', null, '2017-06-20 15:07:13', '2017-06-26 12:46:09', '1'),
('8', '超级管理员', 'super', null, '2017-06-20 15:08:45', null, '1'),
('17', '用户', 'user', null, '2017-06-28 18:50:39', '2017-07-21 09:41:28', '1');

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` (id, avatar, username, password, salt, name, birthday, sex, email, phone, status, create_time, update_time)  VALUES
('46', null, 'super', '$2a$10$cKRbR9IJktfmKmf/wShyo.5.J8IxO/7YVn8twuWFtvPgruAF8gtKq', null, '超级管理员', '2017-06-22', '1', 'super@163.com', '13875432244', '1', '2017-06-20 15:12:16', '2017-09-12 14:39:48'),
('48', null, 'admin', '$2a$10$cKRbR9IJktfmKmf/wShyo.5.J8IxO/7YVn8twuWFtvPgruAF8gtKq', null, '管理员', '2017-06-22', '1', 'admin@qq.com', '1837565875', '1', '2017-06-26 17:31:41', null),
('50', null, 'test1', '$2a$10$cKRbR9IJktfmKmf/wShyo.5.J8IxO/7YVn8twuWFtvPgruAF8gtKq', null, 'test1', '2017-06-22', '1', 'test1@gmail.com', '17788888888', '1', '2017-09-18 16:11:15', null),
('51', null, 'test2', '$2a$10$cKRbR9IJktfmKmf/wShyo.5.J8IxO/7YVn8twuWFtvPgruAF8gtKq', null, 'test2', '2017-06-22', '1', 'test2@126.com', '16655556666', '1', '2017-09-21 17:09:51', null);

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
insert into sys_user_role(user_id, role_id, create_time, create_by) values
(46, 6, '2017-06-26 12:46:09', 'admin'),
(48, 8, '2017-06-20 15:08:45', 'admin'),
(50, 17, '2017-06-26 12:46:09', 'admin'),
(51, 17, '2017-06-26 12:46:09', 'admin');