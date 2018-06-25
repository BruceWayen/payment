/*
Navicat MySQL Data Transfer

Source Server         : page
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : payment

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-06-25 11:43:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bs_food_info
-- ----------------------------
DROP TABLE IF EXISTS `bs_food_info`;
CREATE TABLE `bs_food_info` (
  `id` bigint(14) NOT NULL AUTO_INCREMENT COMMENT '菜品标识',
  `food_name` char(50) DEFAULT NULL COMMENT '菜品名称',
  `food_desc` char(255) DEFAULT NULL COMMENT '菜品描述',
  `busi_no` bigint(14) NOT NULL COMMENT '商家账户',
  `price` char(11) NOT NULL COMMENT '菜品价格',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜品信息，记录商家的每个菜品';

-- ----------------------------
-- Records of bs_food_info
-- ----------------------------

-- ----------------------------
-- Table structure for bs_recharge_info
-- ----------------------------
DROP TABLE IF EXISTS `bs_recharge_info`;
CREATE TABLE `bs_recharge_info` (
  `id` bigint(14) NOT NULL AUTO_INCREMENT COMMENT '主键标识',
  `contract_no` bigint(14) NOT NULL COMMENT '充值账号',
  `money` char(11) NOT NULL COMMENT '充值金额',
  `op_time` datetime NOT NULL COMMENT '充值时间',
  `login_accept` char(14) NOT NULL COMMENT '交易流水',
  `op_notes` text COMMENT '操作备注',
  `op_type` int(11) NOT NULL COMMENT '充值方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户充值记录表';

-- ----------------------------
-- Records of bs_recharge_info
-- ----------------------------

-- ----------------------------
-- Table structure for bs_shop_consume
-- ----------------------------
DROP TABLE IF EXISTS `bs_shop_consume`;
CREATE TABLE `bs_shop_consume` (
  `id` bigint(14) NOT NULL COMMENT '主键标识',
  `busi_no` bigint(14) NOT NULL COMMENT '商家账户',
  `contract_no` bigint(14) NOT NULL COMMENT '消费账户',
  `price` char(11) NOT NULL COMMENT '消费金额',
  `login_accept` char(14) NOT NULL COMMENT '交易流水',
  `op_time` datetime DEFAULT NULL COMMENT '交易时间',
  `food_id` int(11) DEFAULT NULL COMMENT '菜品标识',
  `op_note` text COMMENT '交易备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家营业记录表';

-- ----------------------------
-- Records of bs_shop_consume
-- ----------------------------

-- ----------------------------
-- Table structure for bs_use_cronsume
-- ----------------------------
DROP TABLE IF EXISTS `bs_use_cronsume`;
CREATE TABLE `bs_use_cronsume` (
  `id` bigint(14) NOT NULL COMMENT '主键标识',
  `contract_no` bigint(14) NOT NULL COMMENT '付费账号',
  `busi_no` bigint(14) NOT NULL COMMENT '收款账号',
  `consume_desc` char(255) DEFAULT NULL COMMENT '消费描述',
  `price` int(11) NOT NULL COMMENT '消费金额',
  `login_accept` char(14) NOT NULL COMMENT '交易流水',
  `op_time` datetime NOT NULL COMMENT '交易时间',
  `food_id` int(11) DEFAULT NULL COMMENT '菜品标识',
  `op_note` text COMMENT '交易备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户消费记录表';

-- ----------------------------
-- Records of bs_use_cronsume
-- ----------------------------

-- ----------------------------
-- Table structure for sys_action
-- ----------------------------
DROP TABLE IF EXISTS `sys_action`;
CREATE TABLE `sys_action` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键标识',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单标识',
  `action_name` char(50) DEFAULT NULL COMMENT '动作名称',
  `action_url` char(255) DEFAULT NULL COMMENT '动作的URL',
  `action_sort` int(11) DEFAULT NULL COMMENT '排序标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='权限表，备用';

-- ----------------------------
-- Records of sys_action
-- ----------------------------
INSERT INTO `sys_action` VALUES ('1', '1', '系统管理', '1', '0');
INSERT INTO `sys_action` VALUES ('2', '2', '消费管理', '2', '0');
INSERT INTO `sys_action` VALUES ('4', '4', '菜单管理', '4', '0');
INSERT INTO `sys_action` VALUES ('5', '5', '用户管理', 'user/user_list.do', '0');
INSERT INTO `sys_action` VALUES ('6', '6', '数据字典', '7', '0');
INSERT INTO `sys_action` VALUES ('7', '7', '系统参数', '6', '0');
INSERT INTO `sys_action` VALUES ('8', '8', '日志查询', '8', '0');
INSERT INTO `sys_action` VALUES ('9', '9', '账户管理', '9', '0');
INSERT INTO `sys_action` VALUES ('10', '10', '商家管理', '0', '0');
INSERT INTO `sys_action` VALUES ('11', '11', '商户管理', '0', '0');
INSERT INTO `sys_action` VALUES ('12', '12', '收支查询', '0', '0');
INSERT INTO `sys_action` VALUES ('13', '13', '二维码生成', '0', '0');
INSERT INTO `sys_action` VALUES ('14', '14', '充值记录', '0', '0');

-- ----------------------------
-- Table structure for sys_contract_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_contract_info`;
CREATE TABLE `sys_contract_info` (
  `id` bigint(14) NOT NULL COMMENT '账户标识',
  `user_id` bigint(14) NOT NULL COMMENT '用户标识',
  `contract_name` char(15) DEFAULT NULL COMMENT '账户描述',
  `contract_status` int(1) NOT NULL COMMENT '账户状态',
  `contract_passwd` char(255) NOT NULL COMMENT '支付密码',
  `system_fee` char(11) DEFAULT NULL COMMENT '系统充余额',
  `user_fee` char(11) DEFAULT NULL COMMENT '用户充值余额',
  `pay_time` datetime DEFAULT NULL COMMENT '最近一次充值时间',
  `pay_accept` char(14) DEFAULT NULL COMMENT '最近一次充值流水',
  `pay_type` int(1) DEFAULT NULL COMMENT '最近一次充值方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户信息表';

-- ----------------------------
-- Records of sys_contract_info
-- ----------------------------
INSERT INTO `sys_contract_info` VALUES ('10000000012', '21', 'songhw', '0', '41z3tmRJ31Zfk8YH1agdCQ==', '6.00', '5.00', null, null, null);
INSERT INTO `sys_contract_info` VALUES ('10000000013', '22', 'songhongwei', '0', 'O1Zt5IOwlgex8mE3vlPpYQ==', '0.00', '0.00', null, null, null);

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门标识',
  `dept_name` char(50) DEFAULT NULL COMMENT '部门名称',
  `dept_address` char(255) DEFAULT NULL COMMENT '部门地址',
  `dept_phone` char(16) DEFAULT NULL COMMENT '部门电话',
  `dept_super_id` int(11) DEFAULT NULL COMMENT '上级部门标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '财务部', '二楼204', '0551-686598', '0');
INSERT INTO `sys_dept` VALUES ('2', '研发部', '201-203', '0551-686598', '0');
INSERT INTO `sys_dept` VALUES ('3', '渠道部', '205-206', '0551-686598', '0');
INSERT INTO `sys_dept` VALUES ('4', '测试部', '207-208', '0551-686598', '0');

-- ----------------------------
-- Table structure for sys_fee_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_fee_info`;
CREATE TABLE `sys_fee_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键标识',
  `money` char(11) NOT NULL COMMENT '金额大小',
  `notes` text COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统费用配置表';

-- ----------------------------
-- Records of sys_fee_info
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单标识',
  `menu_super_id` int(11) DEFAULT NULL COMMENT '父及菜单标识',
  `menu_status` int(11) NOT NULL COMMENT '菜单状态',
  `menu_sort` int(11) DEFAULT NULL COMMENT '菜单排序标识',
  `menu_name` char(50) DEFAULT NULL COMMENT '菜单名称',
  `menu_icon_url` char(100) DEFAULT NULL COMMENT '菜单图片路径',
  `menu_url` char(100) NOT NULL COMMENT '菜单执行url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '0', '0', '系统管理', 'icon-chart-organisation', '1');
INSERT INTO `sys_menu` VALUES ('2', '0', '0', '0', '消费管理', 'icon-users', '2');
INSERT INTO `sys_menu` VALUES ('3', '2', '0', '0', '系统管理', 'icon-user-group', '3');
INSERT INTO `sys_menu` VALUES ('4', '1', '0', '0', '菜单管理', 'icon-chart-organisation', '4');
INSERT INTO `sys_menu` VALUES ('5', '2', '0', '0', '用户管理', 'icon-users', 'user/user_list.do');
INSERT INTO `sys_menu` VALUES ('6', '1', '0', '0', '数据字典', 'icon-book', '7');
INSERT INTO `sys_menu` VALUES ('8', '1', '0', '0', '日志查询', 'icon-application-osx-error', '8');
INSERT INTO `sys_menu` VALUES ('9', '2', '0', '0', '账户管理', 'icon-user_business_boss', '9');
INSERT INTO `sys_menu` VALUES ('10', '0', '0', '0', '商家管理', 'icon-group', '0');
INSERT INTO `sys_menu` VALUES ('11', '10', '0', '0', '商户管理', 'icon-users', '0');
INSERT INTO `sys_menu` VALUES ('12', '10', '0', '0', '收支查询', 'icon-arrow_ew', '0');
INSERT INTO `sys_menu` VALUES ('13', '10', '0', '0', '二维码生成', 'icon-heart', '0');
INSERT INTO `sys_menu` VALUES ('14', '2', '0', '0', '充值记录', 'icon-application_go', '0');
INSERT INTO `sys_menu` VALUES ('15', '2', '0', '0', '消费记录', 'icon-bullet_left', '0');

-- ----------------------------
-- Table structure for sys_operate
-- ----------------------------
DROP TABLE IF EXISTS `sys_operate`;
CREATE TABLE `sys_operate` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `oper_time` datetime NOT NULL COMMENT '操作时间',
  `oper_user` varchar(64) NOT NULL COMMENT '操作人',
  `oper_module` varchar(40) NOT NULL COMMENT '操作模块',
  `content` text NOT NULL COMMENT '记录内容',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作流水，保存所有用户操作记录，信息可以溯源';

-- ----------------------------
-- Records of sys_operate
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色表示',
  `role_name` char(50) NOT NULL COMMENT '角色名称',
  `role_desc` char(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '获取所有权限');
INSERT INTO `sys_role` VALUES ('2', '普通员工', '普通员工');
INSERT INTO `sys_role` VALUES ('3', '经理', '经理');
INSERT INTO `sys_role` VALUES ('4', '组长', '组长');
INSERT INTO `sys_role` VALUES ('5', '分管', '分管');

-- ----------------------------
-- Table structure for sys_role_action
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_action`;
CREATE TABLE `sys_role_action` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键标识',
  `action_id` int(11) DEFAULT NULL COMMENT '动作标识',
  `role_id` int(11) DEFAULT NULL COMMENT '角色标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='系统角色权限关系表';

-- ----------------------------
-- Records of sys_role_action
-- ----------------------------
INSERT INTO `sys_role_action` VALUES ('1', '1', '1');
INSERT INTO `sys_role_action` VALUES ('2', '2', '1');
INSERT INTO `sys_role_action` VALUES ('3', '3', '1');
INSERT INTO `sys_role_action` VALUES ('4', '4', '1');
INSERT INTO `sys_role_action` VALUES ('5', '5', '1');
INSERT INTO `sys_role_action` VALUES ('6', '6', '1');
INSERT INTO `sys_role_action` VALUES ('7', '7', '1');
INSERT INTO `sys_role_action` VALUES ('8', '8', '1');
INSERT INTO `sys_role_action` VALUES ('9', '9', '1');
INSERT INTO `sys_role_action` VALUES ('10', '10', '1');
INSERT INTO `sys_role_action` VALUES ('11', '11', '1');
INSERT INTO `sys_role_action` VALUES ('12', '12', '1');
INSERT INTO `sys_role_action` VALUES ('13', '13', '1');
INSERT INTO `sys_role_action` VALUES ('14', '14', '1');

-- ----------------------------
-- Table structure for sys_role_fee
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_fee`;
CREATE TABLE `sys_role_fee` (
  `id` int(11) DEFAULT NULL COMMENT '主键标识',
  `role_id` int(11) DEFAULT NULL COMMENT '角色标识',
  `fee_id` int(11) DEFAULT NULL COMMENT '费用标识'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色金额关系表';

-- ----------------------------
-- Records of sys_role_fee
-- ----------------------------

-- ----------------------------
-- Table structure for sys_sequence
-- ----------------------------
DROP TABLE IF EXISTS `sys_sequence`;
CREATE TABLE `sys_sequence` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '主键标识',
  `seq_name` char(50) CHARACTER SET utf8 NOT NULL COMMENT '序列名称',
  `current_val` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '当前序列值',
  `increment_val` int(11) NOT NULL COMMENT '自增值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='序列表';

-- ----------------------------
-- Records of sys_sequence
-- ----------------------------
INSERT INTO `sys_sequence` VALUES ('00000000001', 'LOGIN_ACCEPT', '100000000000003', '1');
INSERT INTO `sys_sequence` VALUES ('00000000004', 'CONTRACT_NO', '10000000014', '1');
INSERT INTO `sys_sequence` VALUES ('00000000005', 'LOGIN_NO', '1000014', '1');

-- ----------------------------
-- Table structure for sys_unicode_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_unicode_dict`;
CREATE TABLE `sys_unicode_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_class` char(50) NOT NULL COMMENT '代码类型',
  `code_name` char(255) NOT NULL COMMENT '配置名称',
  `code_desc` char(255) DEFAULT NULL COMMENT '配置描述',
  `code_value` int(11) NOT NULL COMMENT '配置值',
  `eff_date` datetime DEFAULT NULL COMMENT '生效时间',
  `exp_date` datetime DEFAULT NULL COMMENT '失效时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='代码配置表';

-- ----------------------------
-- Records of sys_unicode_dict
-- ----------------------------
INSERT INTO `sys_unicode_dict` VALUES ('1', 'register_type', '系统注册', '注册类型', '0', '2018-05-25 02:44:30', '2050-01-25 02:44:33', '2018-05-25 02:44:47');
INSERT INTO `sys_unicode_dict` VALUES ('2', 'user_satus', '正常', '用户状态', '0', '2018-05-25 02:44:30', '2050-01-25 02:44:33', '2018-05-25 02:44:47');
INSERT INTO `sys_unicode_dict` VALUES ('3', 'register_type', '自助注册', '注册类型', '1', '2018-05-25 02:44:30', '2050-01-25 02:44:33', '2018-05-25 02:44:47');
INSERT INTO `sys_unicode_dict` VALUES ('4', 'user_status', '离职', '用户状态', '1', '2018-05-25 02:49:20', '2018-05-25 02:49:16', '2018-05-25 02:49:22');
INSERT INTO `sys_unicode_dict` VALUES ('5', 'contract_status', '正常', '账户状态', '0', '2018-05-25 02:44:30', '2050-01-25 02:44:33', '2018-05-25 02:44:47');
INSERT INTO `sys_unicode_dict` VALUES ('6', 'contract_status', '冻结', '账户状态', '1', '2018-05-25 02:44:30', '2050-01-25 02:44:33', '2018-05-25 02:44:47');
INSERT INTO `sys_unicode_dict` VALUES ('7', 'pay_type', '系统充值', '充值方式', '0', '2018-05-25 02:44:30', '2050-01-25 02:44:33', '2018-05-25 02:44:47');
INSERT INTO `sys_unicode_dict` VALUES ('8', 'pay_type', '自助充值', '充值方式', '1', '2018-05-25 02:49:20', '2018-05-25 02:49:16', '2018-05-25 02:49:22');
INSERT INTO `sys_unicode_dict` VALUES ('9', 'op_type', '系统充值', '充值方式', '0', '2018-05-25 02:44:30', '2050-01-25 02:44:33', '2018-05-25 02:44:47');
INSERT INTO `sys_unicode_dict` VALUES ('10', 'op_type', '自助充值', '充值方式', '1', '2018-05-25 02:49:20', '2018-05-25 02:49:16', '2018-05-25 02:49:22');
INSERT INTO `sys_unicode_dict` VALUES ('11', 'menu_status', 'normal', '菜系状态正常', '0', '2018-05-25 02:44:30', '2050-01-25 02:44:33', '2018-05-25 02:44:47');
INSERT INTO `sys_unicode_dict` VALUES ('12', 'menu_status', 'abnormal', '菜系状态异常', '1', '2018-05-25 02:49:20', '2018-05-25 02:49:16', '2018-05-25 02:49:22');

-- ----------------------------
-- Table structure for sys_users
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `id` bigint(14) NOT NULL AUTO_INCREMENT COMMENT '用户标识',
  `contract_no` bigint(14) NOT NULL COMMENT '账户标识',
  `user_name` char(16) NOT NULL COMMENT '用户姓名',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `login_no` char(9) NOT NULL COMMENT '工号',
  `pass_word` char(255) NOT NULL COMMENT '密码',
  `id_iccid` char(18) DEFAULT NULL COMMENT '用户身份证号',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门编号',
  `phone_no` char(11) NOT NULL COMMENT '手机号',
  `user_satus` int(11) DEFAULT NULL COMMENT '用户状态',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `register_type` int(11) NOT NULL COMMENT '注册方式',
  `role_id` int(11) NOT NULL COMMENT '角色标识',
  `login_time` datetime DEFAULT NULL COMMENT '本次登录时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('1', '0', 'admin', '1', 'system', '4QrcOUm6Wau+VuBX8g+IPg==', '123456', '1', '18130091249', '0', '2018-06-06 17:28:45', '1', '1', '2018-06-25 11:38:51', '2018-06-25 11:38:51');
INSERT INTO `sys_users` VALUES ('5', '1', 'songhw2', '1', 'system', '4QrcOUm6Wau+VuBX8g+IPg==', '340122199212131815', '2', '18130091249', '0', '2018-06-11 21:14:53', '1', '1', null, '2018-06-11 21:14:56');
INSERT INTO `sys_users` VALUES ('7', '1', 'songhw', '1', 'system', '4QrcOUm6Wau+VuBX8g+IPg==', '340122199212131815', '3', '18130091249', '0', '2018-06-11 21:14:53', '1', '1', null, '2018-06-11 21:14:56');
INSERT INTO `sys_users` VALUES ('10', '1', 'songhw', '0', 'system', '4QrcOUm6Wau+VuBX8g+IPg==', '340122199212131815', '1', '18130091249', '0', '2018-06-11 21:14:53', '1', '1', null, '2018-06-11 21:14:56');
INSERT INTO `sys_users` VALUES ('12', '1', 'songhw', '0', 'system', '4QrcOUm6Wau+VuBX8g+IPg==', '340122199212131815', '1', '18130091249', '0', '2018-06-11 21:14:53', '1', '1', null, '2018-06-11 21:14:56');
INSERT INTO `sys_users` VALUES ('13', '10000000004', '123123', '0', 'Anull', 'Qpf0SxOVUjUkWySXOZ16kw==', '123123123123123', '1', '12312312312', '0', '2018-06-24 16:56:38', '1', '1', null, null);
INSERT INTO `sys_users` VALUES ('14', '10000000005', '123123', '0', 'Anull', 'Qpf0SxOVUjUkWySXOZ16kw==', '123123123123123', '1', '12312312312', '0', '2018-06-24 16:56:38', '1', '1', null, null);
INSERT INTO `sys_users` VALUES ('15', '10000000006', '123123', '0', 'A1000006', 'Qpf0SxOVUjUkWySXOZ16kw==', '123123123123123', '1', '12312312312', '0', '2018-06-24 16:56:38', '1', '1', null, null);
INSERT INTO `sys_users` VALUES ('16', '10000000007', '123123', '0', 'A1000007', 'Qpf0SxOVUjUkWySXOZ16kw==', '123123123123123', '1', '12312312312', '0', '2018-06-24 16:56:38', '1', '1', null, null);
INSERT INTO `sys_users` VALUES ('17', '10000000008', '吴尘', '1', 'A1000008', 'vPYLmdQLGsgD18SK7mwfPA==', '340122199415121619', '4', '15988858965', '0', '2018-06-24 17:56:28', '1', '3', null, null);
INSERT INTO `sys_users` VALUES ('18', '10000000010', '吴尘', '1', 'A1000010', '6jtDAZxLAe87AjFy0DOpRg==', '340122151951216', '4', '15988856210', '0', '2018-06-24 17:57:09', '1', '3', null, null);
INSERT INTO `sys_users` VALUES ('20', '10000000011', '宋宏伟', '0', 'A1000011', '6jtDAZxLAe87AjFy0DOpRg==', '340122151951216', '1', '18130091249', '0', '2018-06-24 18:19:15', '1', '1', null, null);
INSERT INTO `sys_users` VALUES ('21', '10000000012', 'songhw', '0', 'A1000012', '41z3tmRJ31Zfk8YH1agdCQ==', '123456789123456789', '1', '1549871654', '0', '2018-06-04 18:42:20', '1', '1', null, null);
INSERT INTO `sys_users` VALUES ('22', '10000000013', 'songhongwei', '0', 'A1000013', 'O1Zt5IOwlgex8mE3vlPpYQ==', '340122199212131815', '1', '18130091249', '0', '2018-06-25 11:39:13', '1', '1', null, null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键标识',
  `user_id` bigint(14) NOT NULL COMMENT '用户标识',
  `role_id` int(11) NOT NULL COMMENT '角色标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2', '1');
INSERT INTO `sys_user_role` VALUES ('3', '3', '1');
INSERT INTO `sys_user_role` VALUES ('4', '4', '1');
INSERT INTO `sys_user_role` VALUES ('5', '5', '1');
INSERT INTO `sys_user_role` VALUES ('6', '6', '1');
INSERT INTO `sys_user_role` VALUES ('7', '7', '1');
INSERT INTO `sys_user_role` VALUES ('8', '8', '1');
INSERT INTO `sys_user_role` VALUES ('9', '9', '1');
INSERT INTO `sys_user_role` VALUES ('10', '10', '1');
INSERT INTO `sys_user_role` VALUES ('11', '11', '1');
INSERT INTO `sys_user_role` VALUES ('12', '12', '1');
INSERT INTO `sys_user_role` VALUES ('13', '18', '3');
INSERT INTO `sys_user_role` VALUES ('14', '20', '1');
INSERT INTO `sys_user_role` VALUES ('15', '21', '1');
INSERT INTO `sys_user_role` VALUES ('16', '22', '1');

-- ----------------------------
-- Function structure for currval
-- ----------------------------
DROP FUNCTION IF EXISTS `currval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `currval`(input VARCHAR(50)) RETURNS double
BEGIN  
DECLARE _value double ;  
 select current_val into _value  from sys_sequence where seq_name = input;  
RETURN _value;  
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `nextval`(v_seq_name VARCHAR(50)) RETURNS double
begin  
    update sys_sequence set current_val = current_val + increment_val  where seq_name = v_seq_name;  
    return currval(v_seq_name);  
end
;;
DELIMITER ;
