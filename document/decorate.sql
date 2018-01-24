/*
Navicat MySQL Data Transfer

Source Server         : sa
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : decorate

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-01-24 08:54:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` varchar(50) NOT NULL DEFAULT '' COMMENT '编号',
  `img` varchar(50) DEFAULT 'img/profile_small.jpg',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(200) NOT NULL COMMENT '密码',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `phone` varchar(11) NOT NULL COMMENT '手机号',
  `role` varchar(10) DEFAULT NULL COMMENT '角色',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_login_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近一次登录时间',
  `status` char(1) DEFAULT 'Y' COMMENT '是否可用，Y表示可用，N表示不可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('8c47c1ae-29bb-11e7-bea0-2c56dc7fea35', 'img/t.jpg', '10086@126.com', '123456', '先生', '15083562589', '超级管理员', '2017-04-25 20:57:23', '2017-04-25 20:57:23', 'Y');
INSERT INTO `t_admin` VALUES ('deaebd19-2632-11e7-bea0-2c56dc7fea35', 'img/k.jpg', '111@qq.com', '123456', '石海军', '15678433458', '普通管理员', '2017-04-25 23:36:00', '2017-04-25 23:36:00', 'Y');

-- ----------------------------
-- Table structure for `t_appointment`
-- ----------------------------
DROP TABLE IF EXISTS `t_appointment`;
CREATE TABLE `t_appointment` (
  `id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '编号',
  `user_id` varchar(50) DEFAULT 'uuid()' COMMENT '用户编号',
  `company_id` varchar(100) DEFAULT 'uuid()' COMMENT '公司编号',
  `name` varchar(50) NOT NULL COMMENT '称呼',
  `phone` varchar(11) NOT NULL COMMENT '手机号码',
  `plot_name` varchar(100) NOT NULL COMMENT '小区名称',
  `area` float(10,0) NOT NULL DEFAULT '0' COMMENT '建筑面积',
  `way` varchar(10) DEFAULT NULL COMMENT '装修方式',
  `budget` varchar(20) DEFAULT NULL COMMENT '装修预算:5-8万，8-10万，10-15万，15万以上',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `app_name` varchar(100) DEFAULT NULL COMMENT '被预约名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_appointment
-- ----------------------------
INSERT INTO `t_appointment` VALUES ('2900c488-2a37-11e7-bea0-2c56dc7fea35', '2567946f-2632-11e7-bea0-2c56dc7fea35', 'a2115b76-2632-11e7-bea0-2c56dc7fea35', '郑先生', '15083562589', '吖吖', '123', '阿斯蒂芬', '15-25万', '2017-04-26 11:13:42', '海棠居装饰');

-- ----------------------------
-- Table structure for `t_company`
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company` (
  `id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '编号，全球唯一标识符',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(200) NOT NULL COMMENT '密码，md5加密',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `principal` varchar(10) NOT NULL COMMENT '负责人',
  `logo` varchar(500) NOT NULL DEFAULT 'C:\\Users\\娃娃鱼\\Pictures\\logo.png' COMMENT '公司的logo图片',
  `address` varchar(100) DEFAULT '中国' COMMENT '公司地址',
  `phone` varchar(11) NOT NULL COMMENT '手机号',
  `tel` varchar(11) DEFAULT NULL COMMENT '固定电话',
  `open_date` datetime NOT NULL COMMENT '公司成立日期',
  `longitude` float DEFAULT NULL COMMENT '经度',
  `latitude` float DEFAULT NULL COMMENT '纬度',
  `des` varchar(500) DEFAULT NULL COMMENT '描述',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '公司入驻的时间',
  `checked` char(1) NOT NULL DEFAULT 'N' COMMENT '是否审核通过，Y表示是，N表示否',
  `checked_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '审核的时间',
  `last_login_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录时的时间',
  `status` char(1) NOT NULL DEFAULT 'N' COMMENT '是否可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_company
-- ----------------------------
INSERT INTO `t_company` VALUES ('1b390cb2-2690-11e7-bea0-2c56dc7fea35', '444@qq.com', '123456', '名匠装饰', '余天天', 'img/mingjiang.jpg', null, '13574536664', '234536', '2017-04-19 00:00:00', null, null, null, '2017-04-26 09:54:54', 'N', '2017-04-26 09:54:54', '2017-04-21 19:40:59', 'N');
INSERT INTO `t_company` VALUES ('4064a44e-2690-11e7-bea0-2c56dc7fea35', '555@qq.com', '123456', '美星装饰', '汤小小', 'img/meixing.jpg', null, '12423462353', '234536', '2017-04-22 00:00:00', null, null, null, '2017-04-22 08:24:09', 'N', '2017-04-22 08:24:09', '2017-04-21 19:42:02', 'Y');
INSERT INTO `t_company` VALUES ('652727fd-268f-11e7-bea0-2c56dc7fea35', '111@qq.com', '123456', '卓创装饰', '钟卓', 'img/zhuochuang.jpg', null, '13574574666', '234568', '2017-04-29 00:00:00', null, null, null, '2017-04-25 23:27:12', 'N', '2017-04-25 23:27:12', '2017-04-25 23:27:12', 'Y');
INSERT INTO `t_company` VALUES ('74951343-2690-11e7-bea0-2c56dc7fea35', '666@qq.com', '123456', '乐家装饰', '欧阳磊', 'img/lejia.jpg', null, '12423464326', '324246', '2017-04-29 00:00:00', null, null, null, '2017-04-22 08:25:15', 'N', '2017-04-22 08:25:15', '2017-04-21 19:43:29', 'Y');
INSERT INTO `t_company` VALUES ('a2115b76-2632-11e7-bea0-2c56dc7fea35', '222@qq.com', '1234', '海棠居装饰', '张大海', 'img/headphoto_1354966.jpg', 'qqqqq', '13823454389', '10068', '2017-04-23 00:00:00', '0', '0', '中国', '2017-04-26 11:15:59', 'N', '2017-04-26 11:15:59', '2017-04-26 11:15:59', 'Y');
INSERT INTO `t_company` VALUES ('c3974a23-268f-11e7-bea0-2c56dc7fea35', '321@qq.com', '123456', '润格装饰', '崔润平', 'img/ruenge.jpg', null, '13574574666', '234282', '2017-04-29 00:00:00', null, null, null, '2017-04-26 09:38:38', 'N', '2017-04-26 09:38:38', '2017-04-21 19:38:32', 'N');
INSERT INTO `t_company` VALUES ('efc96fee-268f-11e7-bea0-2c56dc7fea35', '333@qq.com', '123456', '林凤装饰', '凌学文', 'img/linfeng.jpg', null, '13574536664', '2342865', '2017-04-22 00:00:00', null, null, null, '2017-04-26 09:54:28', 'N', '2017-04-26 09:54:28', '2017-04-21 19:39:46', 'Y');

-- ----------------------------
-- Table structure for `t_company_activity`
-- ----------------------------
DROP TABLE IF EXISTS `t_company_activity`;
CREATE TABLE `t_company_activity` (
  `id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '编号',
  `company_id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '装修公司编号',
  `name` varchar(100) NOT NULL COMMENT '案例名称',
  `image` varchar(500) DEFAULT 'img/mo.jpg' COMMENT '活动图片路径',
  `des` varchar(500) DEFAULT NULL COMMENT '活动描述',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` char(1) NOT NULL DEFAULT 'Y' COMMENT '是否可用',
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `t_company_activity_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `t_company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_company_activity
-- ----------------------------
INSERT INTO `t_company_activity` VALUES ('372d0014-283f-11e7-bea0-2c56dc7fea35', 'a2115b76-2632-11e7-bea0-2c56dc7fea35', '劳动节打折啦', 'img/欧式 (2).jpg', '超级实惠', '2017-04-26 11:04:28', 'Y');
INSERT INTO `t_company_activity` VALUES ('7b990f1f-2839-11e7-bea0-2c56dc7fea35', 'a2115b76-2632-11e7-bea0-2c56dc7fea35', '优惠', 'img/欧式 (66).jpg', '。。。。。。。。。。。。。。', '2017-04-25 21:09:04', 'Y');
INSERT INTO `t_company_activity` VALUES ('9a8cba7f-289d-11e7-bea0-2c56dc7fea35', '652727fd-268f-11e7-bea0-2c56dc7fea35', 'ssss', 'img/beiou.jpg', '/////////////////////////////', '2017-04-24 10:22:16', 'Y');
INSERT INTO `t_company_activity` VALUES ('f6bba4c2-2a35-11e7-bea0-2c56dc7fea35', 'a2115b76-2632-11e7-bea0-2c56dc7fea35', '222', 'img/欧式 (2).jpg', '22222', '2017-04-26 11:05:08', 'Y');

-- ----------------------------
-- Table structure for `t_company_case`
-- ----------------------------
DROP TABLE IF EXISTS `t_company_case`;
CREATE TABLE `t_company_case` (
  `id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '编号',
  `company_id` varchar(50) NOT NULL DEFAULT 'uuid' COMMENT '装修公司编号',
  `name` varchar(100) NOT NULL COMMENT '案例名称',
  `plot_name` varchar(100) NOT NULL COMMENT '小区名称',
  `style` varchar(20) NOT NULL COMMENT '装修风格',
  `image_1` varchar(500) DEFAULT 'img/mo.jpg' COMMENT '图片路径1',
  `image_2` varchar(500) DEFAULT 'img/mo.jpg',
  `image_3` varchar(500) DEFAULT 'img/mo.jpg',
  `image_4` varchar(500) DEFAULT 'img/mo.jpg',
  `image_5` varchar(500) DEFAULT 'img/mo.jpg',
  `des` varchar(500) DEFAULT NULL COMMENT '公司的描述',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` char(1) NOT NULL DEFAULT 'Y' COMMENT '是否可用',
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`) USING BTREE,
  CONSTRAINT `company_id` FOREIGN KEY (`company_id`) REFERENCES `t_company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_company_case
-- ----------------------------
INSERT INTO `t_company_case` VALUES ('31d3acc6-2696-11e7-bea0-2c56dc7fea35', 'a2115b76-2632-11e7-bea0-2c56dc7fea35', '温馨现代装饰', '石佛', '后现代风格', null, null, null, null, null, '很漂亮', '2017-04-26 11:01:48', 'Y');
INSERT INTO `t_company_case` VALUES ('40e56f94-2634-11e7-bea0-2c56dc7fea35', 'a2115b76-2632-11e7-bea0-2c56dc7fea35', '地中海风光房', '大阪石', '地中海风格', 'img/欧式 (73).jpg', 'img/欧式 (133).jpg', 'img/欧式 (55).jpg', 'img/欧式 (50).jpg', 'img/欧式 (77).jpg', '。。。。。。。。。。。。。。。。。。。。。。。', '2017-04-25 21:10:39', 'Y');
INSERT INTO `t_company_case` VALUES ('592c60e7-2695-11e7-bea0-2c56dc7fea35', 'a2115b76-2632-11e7-bea0-2c56dc7fea35', '日式木质装饰', '熊世界', '日式风格', 'img/欧式 (53).jpg', 'img/欧式 (5).jpg', 'img/欧式 (12).jpg', 'img/欧式 (55).jpg', 'img/欧式 (53).jpg', '。。。。。。。。。。。。。。。。。', '2017-04-26 11:02:54', 'Y');
INSERT INTO `t_company_case` VALUES ('7b43fa1c-2821-11e7-bea0-2c56dc7fea35', 'a2115b76-2632-11e7-bea0-2c56dc7fea35', '典雅中国风装修', '凯迪克', '中式风格', 'img/欧式 (77).jpg', 'img/欧式 (14).jpg', 'img/欧式 (14).jpg', 'img/欧式 (18).jpg', 'img/欧式 (11).jpg', '', '2017-04-25 21:10:54', 'Y');
INSERT INTO `t_company_case` VALUES ('9bb432dd-29a2-11e7-bea0-2c56dc7fea35', 'a2115b76-2632-11e7-bea0-2c56dc7fea35', '唯美风格', '凤凰小区', '日系', 'img/欧式 (33).jpg', 'img/欧式 (14).jpg', 'img/欧式 (73).jpg', 'img/欧式 (64).jp', 'img/欧式 (95).jpg', '很漂亮', '2017-04-25 21:10:43', 'Y');
INSERT INTO `t_company_case` VALUES ('ad71986c-2820-11e7-bea0-2c56dc7fea35', 'a2115b76-2632-11e7-bea0-2c56dc7fea35', '华丽美式装修', '艾丝凡d', '美式风格', 'img/欧式 (18).jpg', 'img/欧式 (4).jpg', 'img/欧式 (14).jpg', 'img/欧式 (78).jpg', 'img/欧式 (95).jpg', '。', '2017-04-25 21:10:52', 'Y');
INSERT INTO `t_company_case` VALUES ('b7b7a6e1-2695-11e7-bea0-2c56dc7fea35', 'a2115b76-2632-11e7-bea0-2c56dc7fea35', '舒适北欧装饰', '艾丝凡', '北欧风格', 'img/欧式 (26).jpg', 'img/欧式 (26).jpg', 'img/欧式 (26).jpg', 'img/欧式 (55).jpg', 'img/欧式 (64).jpg', '。。。。。。。。。。。。。。', '2017-04-25 21:11:00', 'Y');
INSERT INTO `t_company_case` VALUES ('c0942d68-2a35-11e7-bea0-2c56dc7fea35', 'a2115b76-2632-11e7-bea0-2c56dc7fea35', '11111', '111111', '1111111', 'img/欧式 (2).jpg', 'img/欧式 (2).jpg', 'img/欧式 (2).jpg', 'img/欧式 (5).jpg', 'img/欧式 (6).jpg', '啦啦', '2017-04-26 11:03:37', 'Y');

-- ----------------------------
-- Table structure for `t_company_case_col`
-- ----------------------------
DROP TABLE IF EXISTS `t_company_case_col`;
CREATE TABLE `t_company_case_col` (
  `id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '编号',
  `customer_id` varchar(255) NOT NULL DEFAULT 'uuid()' COMMENT '用户编号',
  `case_id` varchar(255) NOT NULL DEFAULT 'uuid()' COMMENT '装修公司案例编号',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `case_id` (`case_id`),
  CONSTRAINT `t_company_case_col_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`),
  CONSTRAINT `t_company_case_col_ibfk_2` FOREIGN KEY (`case_id`) REFERENCES `t_company_case` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_company_case_col
-- ----------------------------

-- ----------------------------
-- Table structure for `t_company_col`
-- ----------------------------
DROP TABLE IF EXISTS `t_company_col`;
CREATE TABLE `t_company_col` (
  `id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '编号',
  `customer_id` varchar(255) NOT NULL DEFAULT 'uuid()' COMMENT '用户编号',
  `company_id` varchar(255) NOT NULL DEFAULT 'uuid()' COMMENT '装修公司编号',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `customer_id` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`),
  CONSTRAINT `t_company_col_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `t_company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_company_col
-- ----------------------------
INSERT INTO `t_company_col` VALUES ('e7664df8-2644-11e7-bea0-2c56dc7fea35', '2567946f-2632-11e7-bea0-2c56dc7fea35', 'a2115b76-2632-11e7-bea0-2c56dc7fea35', '2017-04-21 10:42:40');
INSERT INTO `t_company_col` VALUES ('f1b46906-2a6e-11e7-9432-2c56dc7fea35', '2567946f-2632-11e7-bea0-2c56dc7fea35', '652727fd-268f-11e7-bea0-2c56dc7fea35', '2017-04-26 18:56:04');

-- ----------------------------
-- Table structure for `t_customer`
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '编号',
  `img` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(200) NOT NULL COMMENT '密码，md5加密',
  `name` varchar(100) NOT NULL COMMENT '名字',
  `phone` varchar(11) NOT NULL COMMENT '手机号',
  `plot_name` varchar(100) DEFAULT NULL COMMENT '小区名称',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `last_login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` char(1) NOT NULL DEFAULT 'Y' COMMENT '是否可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('11ea96e6-268e-11e7-bea0-2c56dc7fea35', 'img/h.jpg', '444@qq.com', '4QrcOUm6Wau+VuBX8g+IPg==', '林鹏', '15735574457', '规划局', null, '2017-04-25 21:02:33', '2017-04-25 21:02:33', 'Y');
INSERT INTO `t_customer` VALUES ('2567946f-2632-11e7-bea0-2c56dc7fea35', 'img/q.jpg', '123@qq.com', '4QrcOUm6Wau+VuBX8g+IPg==', '张史', '15646467468', '风法师', '中国', '2017-08-25 19:23:48', '2017-08-25 19:23:48', 'Y');
INSERT INTO `t_customer` VALUES ('67d90dc3-268b-11e7-bea0-2c56dc7fea35', 'img/a1.jpg', '111@qq.com', '4QrcOUm6Wau+VuBX8g+IPg==', '关小迪', '12464225785', '塞上风', null, '2017-04-25 22:28:47', '2017-04-25 22:28:47', 'Y');
INSERT INTO `t_customer` VALUES ('7db2c940-268e-11e7-bea0-2c56dc7fea35', 'img/r.jpg', '555@qq.com', '4QrcOUm6Wau+VuBX8g+IPg==', '肖蔡', '15735747954', '松岛枫', null, '2017-04-25 20:53:27', '2017-04-25 20:53:27', 'Y');
INSERT INTO `t_customer` VALUES ('964adf0f-268b-11e7-bea0-2c56dc7fea35', 'img/w.jpg', '222@qq.com', '4QrcOUm6Wau+VuBX8g+IPg==', '谢王魁', '12464225785', '东风浩荡', null, '2017-04-25 22:17:45', '2017-04-25 22:17:45', 'Y');
INSERT INTO `t_customer` VALUES ('f3018efe-268d-11e7-bea0-2c56dc7fea35', 'img/k.jpg', '333@qq.com', '4QrcOUm6Wau+VuBX8g+IPg==', '古安详', '15735574235', '房峰辉', null, '2017-04-25 22:17:36', '2017-04-25 22:17:36', 'Y');

-- ----------------------------
-- Table structure for `t_designer`
-- ----------------------------
DROP TABLE IF EXISTS `t_designer`;
CREATE TABLE `t_designer` (
  `id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '编号，全球唯一标识符',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(200) NOT NULL COMMENT '密码，md5加密',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `headicon` varchar(500) NOT NULL DEFAULT 'C:\\Users\\娃娃鱼\\Pictures\\logo.png' COMMENT '头像',
  `address` varchar(100) DEFAULT NULL COMMENT '公司地址',
  `phone` varchar(11) NOT NULL COMMENT '手机号',
  `experience` varchar(50) DEFAULT NULL COMMENT '工作经验',
  `style` varchar(100) DEFAULT NULL COMMENT '风格',
  `des` varchar(500) DEFAULT NULL COMMENT '描述',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设计师添加的时间',
  `checked` char(1) NOT NULL DEFAULT 'N' COMMENT '是否审核通过，Y表示是，N表示否',
  `checked_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '审核的时间',
  `last_login_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录时的时间',
  `status` char(1) NOT NULL DEFAULT 'N' COMMENT '是否可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_designer
-- ----------------------------
INSERT INTO `t_designer` VALUES ('3a07b927-268d-11e7-bea0-2c56dc7fea35', '111@qq.com', '123456', '陈若琳', 'img/ca03d59de2364149a6e1dcc975d5e780.png', null, '14574268478', null, null, null, '2017-04-25 23:28:18', 'N', '2017-04-25 23:28:18', '2017-04-25 23:28:18', 'Y');
INSERT INTO `t_designer` VALUES ('596bfba0-2647-11e7-bea0-2c56dc7fea35', '333@qq.com', '123456', '张寒', 'img/a5c2be326f9ef7488843c5c796cba02f.png', '中国', '1234592211', '', '', null, '2017-04-26 11:05:52', 'N', '2017-04-26 11:05:52', '2017-04-26 11:05:52', 'Y');
INSERT INTO `t_designer` VALUES ('9f4f7154-268e-11e7-bea0-2c56dc7fea35', '222@qq.com', '123456', '黄小文', 'img/ca89c2509bb76544abf7c94d439ff3e6.png', null, '15634564358', null, null, null, '2017-04-22 08:42:17', 'N', '2017-04-22 08:42:17', '2017-04-21 19:30:22', 'Y');
INSERT INTO `t_designer` VALUES ('b60a2e68-268e-11e7-bea0-2c56dc7fea35', '124@qq.com', '123456', '小颉', 'img/d2093b7be4c65447b72f71354a522f98.png', null, '15634564658', null, null, null, '2017-04-25 20:38:05', 'N', '2017-04-25 20:38:05', '2017-04-21 19:31:00', 'Y');
INSERT INTO `t_designer` VALUES ('cfe4851b-268e-11e7-bea0-2c56dc7fea35', '444@qq.com', '123456', '张德', 'img/c27e6dc11dc0764185e3a2b8d6e5d6d8.png', null, '15676465863', null, null, null, '2017-04-22 08:42:36', 'N', '2017-04-22 08:42:36', '2017-04-21 19:31:43', 'Y');
INSERT INTO `t_designer` VALUES ('f633bda4-268e-11e7-bea0-2c56dc7fea35', '555@qq.com', '123456', '凌浩', 'img/a719388b3eda704583d61c4ef95553b2.png', null, '15676465863', null, null, null, '2017-04-22 08:42:58', 'N', '2017-04-22 08:42:58', '2017-04-21 19:32:48', 'Y');

-- ----------------------------
-- Table structure for `t_designer_case`
-- ----------------------------
DROP TABLE IF EXISTS `t_designer_case`;
CREATE TABLE `t_designer_case` (
  `id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '编号',
  `designer_id` varchar(50) NOT NULL DEFAULT 'uuid' COMMENT '装修公司编号',
  `name` varchar(100) NOT NULL COMMENT '案例名称',
  `plot_name` varchar(100) NOT NULL COMMENT '小区名称',
  `style` varchar(20) NOT NULL COMMENT '装修风格',
  `image_1` varchar(500) DEFAULT 'img/mo.jpg' COMMENT '图片路径1',
  `image_2` varchar(500) DEFAULT 'img/mo.jpg',
  `image_3` varchar(500) DEFAULT 'img/mo.jpg',
  `image_4` varchar(500) DEFAULT 'img/mo.jpg',
  `image_5` varchar(500) DEFAULT 'img/mo.jpg',
  `des` varchar(500) DEFAULT NULL COMMENT '公司的描述',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` char(1) NOT NULL DEFAULT 'Y' COMMENT '是否可用',
  PRIMARY KEY (`id`),
  KEY `designer_id` (`designer_id`),
  CONSTRAINT `designer_id` FOREIGN KEY (`designer_id`) REFERENCES `t_designer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_designer_case
-- ----------------------------
INSERT INTO `t_designer_case` VALUES ('194cf094-283c-11e7-bea0-2c56dc7fea35', '596bfba0-2647-11e7-bea0-2c56dc7fea35', '舒适北欧装饰', '等多石', '北欧风格', 'img/欧式 (2).jpg', null, null, null, null, '很厉害', '2017-04-26 11:06:20', 'Y');
INSERT INTO `t_designer_case` VALUES ('34ea2573-270e-11e7-bea0-2c56dc7fea35', '596bfba0-2647-11e7-bea0-2c56dc7fea35', '温馨后现代式', '闪光灯', '后现代风格', 'img/tianyuan.jpg', 'img/houxiandai1.jpg', 'img/欧式 (78).jpg', 'img/欧式 (53).jpg', 'img/欧式 (54).jpg', '。。。。。。。。。。。', '2017-04-25 21:13:25', 'Y');
INSERT INTO `t_designer_case` VALUES ('42837a3a-2a36-11e7-bea0-2c56dc7fea35', '596bfba0-2647-11e7-bea0-2c56dc7fea35', '2222222', '222222', '2222222', 'img/欧式 (2).jpg', 'img/欧式 (11).jpg', 'img/欧式 (14).jpg', 'img/欧式 (2).jpg', 'img/欧式 (18).jpg', '22222', '2017-04-26 11:07:15', 'Y');
INSERT INTO `t_designer_case` VALUES ('7eacc5e4-270e-11e7-bea0-2c56dc7fea35', '596bfba0-2647-11e7-bea0-2c56dc7fea35', '地中海式', '发顺丰', '地中海风格', 'img/dizhonghai.jpg', 'img/欧式 (54).jpg', 'img/欧式 (77).jpg', 'img/欧式 (141).jpg', 'img/欧式 (156).jpg', '', '2017-04-25 21:14:05', 'Y');
INSERT INTO `t_designer_case` VALUES ('d015df74-283b-11e7-bea0-2c56dc7fea35', '596bfba0-2647-11e7-bea0-2c56dc7fea35', '华丽美式装修', '邯史', '美式风格', 'img/欧式 (33).jpg', 'img/欧式 (78).jpg', 'img/欧式 (108).jpg', 'img/欧式 (138).jpg', 'img/欧式 (224).jpg', '。。。。。。。。。。。。。。', '2017-04-25 21:14:51', 'Y');
INSERT INTO `t_designer_case` VALUES ('d03bcd27-270e-11e7-bea0-2c56dc7fea35', '596bfba0-2647-11e7-bea0-2c56dc7fea35', '新现代家装', '藤黄果', '现代风格', 'img/xiandai4.jpg', 'img/xiandai1.jpg', 'img/xiandai3.jpg', 'img/xiandai3.jpg', 'img/xinzhongshi1.jpg', '', '2017-04-25 21:16:01', 'Y');
INSERT INTO `t_designer_case` VALUES ('e713fbda-2647-11e7-bea0-2c56dc7fea35', '596bfba0-2647-11e7-bea0-2c56dc7fea35', '中式古典房', '火花塞', '中式', 'img/欧式 (11).jpg', 'img/欧式 (14).jpg', 'img/欧式 (18).jpg', 'img/欧式 (6).jpg', 'img/欧式 (20).jpg', '。。。。。。。。。。。。。。。', '2017-04-25 21:16:30', 'Y');

-- ----------------------------
-- Table structure for `t_designer_case_col`
-- ----------------------------
DROP TABLE IF EXISTS `t_designer_case_col`;
CREATE TABLE `t_designer_case_col` (
  `id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '编号',
  `customer_id` varchar(255) NOT NULL DEFAULT 'uuid()' COMMENT '用户编号',
  `case_id` varchar(255) NOT NULL DEFAULT 'uuid()' COMMENT '设计师案例编号',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `case_id` (`case_id`),
  CONSTRAINT `t_designer_case_col_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`),
  CONSTRAINT `t_designer_case_col_ibfk_2` FOREIGN KEY (`case_id`) REFERENCES `t_designer_case` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_designer_case_col
-- ----------------------------

-- ----------------------------
-- Table structure for `t_designer_col`
-- ----------------------------
DROP TABLE IF EXISTS `t_designer_col`;
CREATE TABLE `t_designer_col` (
  `id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '编号',
  `customer_id` varchar(255) NOT NULL DEFAULT 'uuid()' COMMENT '用户编号',
  `designer_id` varchar(255) NOT NULL DEFAULT 'uuid()' COMMENT '设计师编号',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `designer_id` (`designer_id`),
  CONSTRAINT `t_designer_col_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`),
  CONSTRAINT `t_designer_col_ibfk_2` FOREIGN KEY (`designer_id`) REFERENCES `t_designer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_designer_col
-- ----------------------------
INSERT INTO `t_designer_col` VALUES ('e178d689-265b-11e7-bea0-2c56dc7fea35', '2567946f-2632-11e7-bea0-2c56dc7fea35', '596bfba0-2647-11e7-bea0-2c56dc7fea35', '2017-04-21 13:27:09');

-- ----------------------------
-- Table structure for `t_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '编号',
  `supply_id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '建材商编号',
  `name` varchar(100) NOT NULL COMMENT '商品名称',
  `price` float NOT NULL COMMENT '商品价格',
  `sale_price` float NOT NULL COMMENT '商品折扣后的价格',
  `image` varchar(500) DEFAULT 'img/mo.jpg',
  `des` varchar(500) DEFAULT NULL COMMENT '商品描述',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` char(1) NOT NULL DEFAULT 'Y' COMMENT '是否可用',
  PRIMARY KEY (`id`),
  KEY `supply_id` (`supply_id`),
  CONSTRAINT `t_product_ibfk_1` FOREIGN KEY (`supply_id`) REFERENCES `t_supply` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('1421de1c-2667-11e7-bea0-2c56dc7fea35', '8a81fdbd-2640-11e7-bea0-2c56dc7fea35', '东鹏瓷砖', '100', '66', 'img/欧式 (2).jpg', 'lll', '2017-04-26 11:09:21', 'N');
INSERT INTO `t_product` VALUES ('153ad412-2667-11e7-bea0-2c56dc7fea35', '8a81fdbd-2640-11e7-bea0-2c56dc7fea35', '东鹏瓷砖', '100', '66', 'img/houxiandai.jpg', '。。。。。。。。。。。。。。。。', '2017-04-21 14:47:20', 'Y');
INSERT INTO `t_product` VALUES ('15c89b1f-2667-11e7-bea0-2c56dc7fea35', '8a81fdbd-2640-11e7-bea0-2c56dc7fea35', '东鹏瓷砖', '100', '66', 'img/houxiandai.jpg', '。。。。。。。。。。。。。。。。', '2017-04-21 14:47:21', 'Y');
INSERT INTO `t_product` VALUES ('15e319e9-2667-11e7-bea0-2c56dc7fea35', '8a81fdbd-2640-11e7-bea0-2c56dc7fea35', '东鹏瓷砖', '100', '66', 'img/houxiandai.jpg', '。。。。。。。。。。。。。。。。', '2017-04-21 14:47:21', 'Y');
INSERT INTO `t_product` VALUES ('aa759b45-2a36-11e7-bea0-2c56dc7fea35', '8a81fdbd-2640-11e7-bea0-2c56dc7fea35', '111', '11', '1', 'img/欧式 (2).jpg', 'qwe', '2017-04-26 11:10:10', 'Y');

-- ----------------------------
-- Table structure for `t_product_col`
-- ----------------------------
DROP TABLE IF EXISTS `t_product_col`;
CREATE TABLE `t_product_col` (
  `id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '编号',
  `customer_id` varchar(255) NOT NULL DEFAULT 'uuid()' COMMENT '用户编号',
  `product_id` varchar(255) NOT NULL DEFAULT 'uuid()' COMMENT '建材编号',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `t_product_col_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`),
  CONSTRAINT `t_product_col_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product_col
-- ----------------------------
INSERT INTO `t_product_col` VALUES ('7163254e-29d9-11e7-bea0-2c56dc7fea35', '2567946f-2632-11e7-bea0-2c56dc7fea35', '1421de1c-2667-11e7-bea0-2c56dc7fea35', '2017-04-26 00:02:56');

-- ----------------------------
-- Table structure for `t_supply`
-- ----------------------------
DROP TABLE IF EXISTS `t_supply`;
CREATE TABLE `t_supply` (
  `id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '编号，全球唯一标识符',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(200) NOT NULL COMMENT '密码，md5加密',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `principal` varchar(10) NOT NULL COMMENT '负责人',
  `logo` varchar(500) NOT NULL DEFAULT 'img\\brand_1.jpg' COMMENT '公司的logo图片',
  `address` varchar(100) DEFAULT NULL COMMENT '公司地址',
  `phone` varchar(11) NOT NULL COMMENT '手机号',
  `tel` varchar(11) DEFAULT NULL COMMENT '固定电话',
  `open_date` datetime NOT NULL COMMENT '公司成立日期',
  `longitude` float DEFAULT NULL COMMENT '经度',
  `latitude` float DEFAULT NULL COMMENT '纬度',
  `des` varchar(500) DEFAULT NULL COMMENT '描述',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '公司添加的时间',
  `checked` char(1) NOT NULL DEFAULT 'N' COMMENT '是否审核通过，Y表示是，N表示否',
  `checked_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '审核的时间',
  `last_login_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录时的时间',
  `status` char(1) NOT NULL DEFAULT 'N' COMMENT '是否可用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_supply
-- ----------------------------
INSERT INTO `t_supply` VALUES ('112590a6-2691-11e7-bea0-2c56dc7fea35', '222@qq.com', '123456', '箭牌卫浴', '张天', 'img/brand_1.jpg', null, '12467442432', '342425', '2017-04-19 00:00:00', null, null, null, '2017-04-21 21:05:15', 'N', '2017-04-21 21:05:15', '2017-04-21 19:47:52', 'Y');
INSERT INTO `t_supply` VALUES ('34a3e9eb-2691-11e7-bea0-2c56dc7fea35', '333@qq.com', '123456', '摩恩龙头', '张天', 'img/brand_5.jpg', null, '13234566743', '342432', '2017-04-19 00:00:00', null, null, null, '2017-04-21 21:05:22', 'N', '2017-04-21 21:05:22', '2017-04-21 19:48:51', 'Y');
INSERT INTO `t_supply` VALUES ('55ba2519-2691-11e7-bea0-2c56dc7fea35', '122@qq.com', '123456', '奥普', '邱小琼', 'img/brand_6.jpg', null, '13234566746', '342758', '2017-04-22 00:00:00', null, null, null, '2017-04-25 20:38:56', 'N', '2017-04-25 20:38:56', '2017-04-21 19:49:47', 'Y');
INSERT INTO `t_supply` VALUES ('80db1a8e-2691-11e7-bea0-2c56dc7fea35', '555@qq.com', '123456', '潜水艇', '吴志强', 'img/brand_7.jpg', null, '13234566746', '342658', '2017-04-22 00:00:00', null, null, null, '2017-04-21 21:10:23', 'N', '2017-04-21 21:10:23', '2017-04-21 19:50:59', 'Y');
INSERT INTO `t_supply` VALUES ('8a81fdbd-2640-11e7-bea0-2c56dc7fea35', '444@qq.com', '123456', '东鹏瓷砖', '谢东鹏', 'img/brand_9.jpg', '中国', '1425678324', '342345', '2017-04-21 00:00:00', '0', '0', '', '2017-04-26 18:54:57', 'N', '2017-04-26 18:54:57', '2017-04-26 18:54:57', 'Y');
INSERT INTO `t_supply` VALUES ('d39b27ee-2690-11e7-bea0-2c56dc7fea35', '111@qq.com', '123456', '大自然地毯', '李航', 'img/brand_2.jpg', null, '12467442568', '124213', '2017-04-27 00:00:00', null, null, null, '2017-04-21 21:10:35', 'N', '2017-04-21 21:10:35', '2017-04-21 19:46:09', 'Y');

-- ----------------------------
-- Table structure for `t_supply_activity`
-- ----------------------------
DROP TABLE IF EXISTS `t_supply_activity`;
CREATE TABLE `t_supply_activity` (
  `id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '编号',
  `supply_id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '装修公司编号',
  `name` varchar(100) DEFAULT NULL COMMENT '案例名称',
  `image` varchar(500) DEFAULT 'img/mo.jpg' COMMENT '活动图片路径',
  `des` varchar(500) DEFAULT NULL COMMENT '活动描述',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` char(1) NOT NULL DEFAULT 'Y' COMMENT '是否可用',
  PRIMARY KEY (`id`),
  KEY `supply_id` (`supply_id`),
  CONSTRAINT `supply_id` FOREIGN KEY (`supply_id`) REFERENCES `t_supply` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_supply_activity
-- ----------------------------
INSERT INTO `t_supply_activity` VALUES ('739ae7ac-2a36-11e7-bea0-2c56dc7fea35', '8a81fdbd-2640-11e7-bea0-2c56dc7fea35', '2222', 'img/欧式 (2).jpg', '22222', '2017-04-26 11:08:38', 'Y');
INSERT INTO `t_supply_activity` VALUES ('8e0a9362-283f-11e7-bea0-2c56dc7fea35', '8a81fdbd-2640-11e7-bea0-2c56dc7fea35', '五一劳动节优惠价', 'img/pg_01.jpg', '超级实惠', '2017-04-25 22:46:37', 'Y');

-- ----------------------------
-- Table structure for `t_supply_col`
-- ----------------------------
DROP TABLE IF EXISTS `t_supply_col`;
CREATE TABLE `t_supply_col` (
  `id` varchar(50) NOT NULL DEFAULT 'uuid()' COMMENT '编号',
  `customer_id` varchar(255) NOT NULL DEFAULT 'uuid()' COMMENT '用户编号',
  `supply_id` varchar(255) NOT NULL DEFAULT 'uuid()' COMMENT '建材商编号',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `supply_id` (`supply_id`),
  CONSTRAINT `t_supply_col_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`),
  CONSTRAINT `t_supply_col_ibfk_2` FOREIGN KEY (`supply_id`) REFERENCES `t_supply` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_supply_col
-- ----------------------------
INSERT INTO `t_supply_col` VALUES ('38ae924c-2641-11e7-bea0-2c56dc7fea35', '2567946f-2632-11e7-bea0-2c56dc7fea35', '8a81fdbd-2640-11e7-bea0-2c56dc7fea35', '2017-04-21 10:16:18');
