/*
Navicat MySQL Data Transfer

Source Server         : baiduyun
Source Server Version : 50614
Source Host           : 182.61.136.218:3306
Source Database       : bbs2

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2018-10-17 09:51:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `aname` varchar(255) NOT NULL COMMENT '管理员姓名',
  `apassword` varchar(255) NOT NULL COMMENT '管理员密码',
  `atime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin', '2018-04-12 01:33:06');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `fid` int(11) NOT NULL AUTO_INCREMENT COMMENT '帖子id',
  `titles` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '帖子标题',
  `fcontent` varchar(2000) NOT NULL COMMENT '帖子内容',
  `photo` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '帖子图片',
  `bname` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '所属板块名字',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发帖时间',
  `userid` int(11) NOT NULL COMMENT '发帖人id',
  `username` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '发帖人姓名',
  `status` int(11) unsigned zerofill NOT NULL DEFAULT '00000000000' COMMENT '帖子审核状态(0为待审核，1为通过审核，2为未通过审核，默认为0)',
  PRIMARY KEY (`fid`),
  KEY `userid` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COMMENT='发帖表';

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('40', 'java集合框架', 'Map\r\n映射表（也称为关联数组）的基本思想是它维护的是键-值（对）关联，因此你可以使用键来查找值。标准的java类库中包含了Map的几种基本实现。\r\nHashMap\r\nMap基于散列表的实现（它实现了HashTable）。插入和查询“键值对”的开销是固定的。可以通过构造器设置容量和负载因子。以调整容器的性能。\r\nTreeMap\r\n基于红黑树的实现。查看“键”或者“键值对”时，它们会被排序（次序由Comparable或Comparator决定）。TreeMap的特点在于，所得到的结果是经过排序的。TreeMap是唯一的带有subMap()方法的Map，它可以返回一个子树。', 'bc90df36-9ee5-4109-84fa-88d03453796fc21a18e75b816164119a5b193b43aabf.png', 'java', '2018-04-17 21:12:25', '26', '马亮', '00000000001');
INSERT INTO `article` VALUES ('41', 'C++强大背后', '在31年前(1979年)，一名刚获得博士学位的研究员，为了开发一个软件项目发明了一门新编程语言，该研究员名为Bjarne Stroustrup，该门语言则命名为——C with classes，四年后改称为C++。C++是一门通用编程语言，支持多种编程范式，包括过程式、面向对象(object-oriented programming, OP)、泛型(generic programming, GP)，后来为泛型而设计的模版，被发现及证明是图灵完备的，因此使C++亦可支持模版元编程范式(template metaprogramming, TMP)。C++继承了C的特色，既为高级语言，又含低级语言功能，可同时作为系统和应用编程语言。', '43e07293-b21f-4acc-86a2-fe872e2b2f37TIM截图20180417211544.png', 'C++', '2018-04-17 21:16:18', '26', '马亮', '00000000001');
INSERT INTO `article` VALUES ('44', '七行JSON代码将你的网站变成移动应用', '请注意，这个视图包含：\r\n\r\n原生导航条，以及内置的切换功能\r\n\r\n一个 Web 视图，其中嵌入了一个可以生成二维码的 Web 应用\r\n\r\n在底部包含一个原生的文字输入组件\r\n\r\n上述所有这一切只需要略微调整 JSON 代码的属性即可实现。\r\n\r\n最后请注意，随着在文字输入区输入不同内容，二维码也会产生相应变化。输入的文字可触发二维码生成器 Web 应用内部的 JavaScript 函数重新生成二维码图像。\r\n\r\n目前还没有任何一个开发框架曾试图从根本上解决“Web 视图与原生应用无缝集成”的问题，因为这些框架都专注于完全原生，或完全 HTML5 的做法。\r\n\r\n无论什么时候当我们听到有人讨论移动应用的未来时，很可能会听到类似“到底是 HTML5 还是原生方法会最终胜出呢？”这样的说法。\r\n\r\n似乎没人觉得native和html可以共存，而且二者的协同和最终实现似乎也并不容易。', 'af22fd04-500d-4efb-b5bc-1c3664f5c77b162d2fb6ff55f58d.gif', '前端', '2018-06-02 21:07:04', '28', '陈意涵', '00000000001');
INSERT INTO `article` VALUES ('45', 'FACEBOOK 的系统架构', 'Web 前端是由 PHP 写的。Facebook 的 HipHop [1] 会把PHP转成 C++ 并用 g++编译，这样就可以为模板和Web逻贺业务层提供高的性能。\r\n业务逻辑以Service的形式存在，其使用Thrift [2]。这些Service根据需求的不同由PHP，C++或Java实现（也可以用到了其它的一些语言……）\r\n用Java写的Services没有用到任何一个企业级的应用服务器，但用到了Facebook自己的定制的应用服务器。看上去好像是重新发明轮子，但是这些Services只被暴露给Thrift使用（绝大所数是这样），Tomcat太重量级了，即使是Jetty也可能太过了点，其附加值对Facebook所需要的没有意义。\r\n持久化由MySQL, Memcached [3], Facebook 的 Cassandra [4], Hadoop 的 HBase [5] 完成。Memcached 使用了MySQL的内存Cache。Facebook 工程师承认他们的Cassandra 使用正在减少，因为他们更喜欢HBase，因为它的更简单的一致性模型，以到其MapReduce能力。', 'c1798a8b-cb55-4368-8b58-91635ee7706c4be57d50d7eb0ef7bac518d2e417c5b0.jpg', '架构', '2018-06-04 08:15:23', '29', '古天乐', '00000000001');
INSERT INTO `article` VALUES ('46', '不知道取什么标题好', '不知道写什么内容', '706cc9ec-e0e0-4d19-bda6-75c268dab634TIM截图20180417221545.png', 'github', '2018-09-28 17:48:58', '44', '张丽娜', '00000000002');
INSERT INTO `article` VALUES ('47', '28岁程序员现状', '我觉得吧，IT行业压力也没那么大。\r\n有一句话我很喜欢：\r\n命，弱者的说辞；运，强者的谦辞。', '91ea3865-2572-4455-afa0-da2e403f254a1537068486167.jpg', '人工智能', '2018-09-28 17:47:41', '46', 'baobei', '00000000001');
INSERT INTO `article` VALUES ('48', 'test', 'testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest', '33e075cd-c5a2-4381-b62b-c729a9dd0bc9TIM截图20180417221545.png', '运维', '2018-10-15 17:21:20', '49', 'unkonw', '00000000001');
INSERT INTO `article` VALUES ('54', 'zhuhui', 'test_zhuhui\r\n\r\n\r\n', '7d4e4bd7-822f-4087-93e4-77f29b686cfdTIM截图20180901103719.png', 'java', '2018-10-16 14:24:31', '53', 'zhuhui', '00000000001');
INSERT INTO `article` VALUES ('55', '111', '好看', '54d30e1c-95ad-4b7d-9bed-367002c65fe2timg.jpg', 'java', '2018-10-16 19:37:32', '52', '纷纷枸', '00000000001');

-- ----------------------------
-- Table structure for attention
-- ----------------------------
DROP TABLE IF EXISTS `attention`;
CREATE TABLE `attention` (
  `gid` int(11) NOT NULL AUTO_INCREMENT COMMENT '关注表id',
  `userid` int(11) NOT NULL COMMENT '主动关注者的id',
  `beuserid` int(11) NOT NULL COMMENT '被动关注者的id',
  PRIMARY KEY (`gid`),
  KEY `userid` (`userid`),
  KEY `beuserid` (`beuserid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='关注表';

-- ----------------------------
-- Records of attention
-- ----------------------------
INSERT INTO `attention` VALUES ('11', '29', '28');
INSERT INTO `attention` VALUES ('22', '43', '29');
INSERT INTO `attention` VALUES ('25', '44', '29');
INSERT INTO `attention` VALUES ('26', '28', '29');
INSERT INTO `attention` VALUES ('27', '52', '49');
INSERT INTO `attention` VALUES ('28', '52', '29');
INSERT INTO `attention` VALUES ('29', '52', '46');
INSERT INTO `attention` VALUES ('30', '54', '52');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `sid` int(11) NOT NULL AUTO_INCREMENT COMMENT '收藏表id',
  `userid` int(11) NOT NULL COMMENT '收藏者id',
  `fid` int(11) NOT NULL COMMENT '被收藏帖子id',
  PRIMARY KEY (`sid`),
  KEY `userid` (`userid`),
  KEY `fid` (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='收藏表';

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('14', '26', '45');
INSERT INTO `collect` VALUES ('22', '26', '43');
INSERT INTO `collect` VALUES ('26', '43', '44');
INSERT INTO `collect` VALUES ('29', '28', '45');
INSERT INTO `collect` VALUES ('30', '28', '43');
INSERT INTO `collect` VALUES ('31', '28', '48');
INSERT INTO `collect` VALUES ('33', '52', '48');
INSERT INTO `collect` VALUES ('34', '52', '44');
INSERT INTO `collect` VALUES ('35', '52', '54');
INSERT INTO `collect` VALUES ('36', '54', '54');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `pcontent` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '评论内容',
  `userid` int(11) NOT NULL COMMENT '评论者',
  `fid` int(11) NOT NULL COMMENT '被评论帖子id',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间',
  PRIMARY KEY (`pid`),
  KEY `userid` (`userid`),
  KEY `fid` (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COMMENT='评论表';

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('26', '大家好，我是陈意涵。', '28', '44', '2018-04-17 21:34:46');
INSERT INTO `comment` VALUES ('27', '除 True、False 和 None 外，其他关键字均为小写形式。除此之外，keyword 模块还提供了关键字的判断功能。', '28', '42', '2018-04-17 21:35:49');
INSERT INTO `comment` VALUES ('29', '哟，这个不错哦，谢谢分享。', '26', '43', '2018-04-17 21:36:49');
INSERT INTO `comment` VALUES ('30', '非常感谢！写的很好呢，收藏了！', '26', '42', '2018-04-17 21:37:13');
INSERT INTO `comment` VALUES ('31', '非常感谢！写的很好呢，收藏了！', '26', '41', '2018-04-17 21:37:25');
INSERT INTO `comment` VALUES ('32', '非常感谢！写的很好呢，收藏了！', '26', '40', '2018-04-17 21:37:31');
INSERT INTO `comment` VALUES ('36', '不错不错不错。', '29', '43', '2018-04-17 21:49:05');
INSERT INTO `comment` VALUES ('40', 'Map 映射表（也称为关联数组）的基本思想是它维护的是键-值（对）关联，因此你可以使用键来查找值。', '29', '40', '2018-06-03 23:08:44');
INSERT INTO `comment` VALUES ('41', '哈哈哈哈哈', '28', '47', '2018-09-19 22:56:56');
INSERT INTO `comment` VALUES ('43', '欢迎来到南生论坛。', '28', '48', '2018-10-12 18:57:58');
INSERT INTO `comment` VALUES ('46', 'aaaa', '53', '47', '2018-10-15 17:23:07');
INSERT INTO `comment` VALUES ('47', 'aaaaaa', '53', '54', '2018-10-15 17:24:11');
INSERT INTO `comment` VALUES ('48', 'bbbb', '53', '54', '2018-10-15 17:24:14');
INSERT INTO `comment` VALUES ('49', '现在可以评论表情了哦⊙∀⊙！???????', '28', '54', '2018-10-16 15:37:57');
INSERT INTO `comment` VALUES ('50', '仿佛', '52', '54', '2018-10-16 16:15:57');
INSERT INTO `comment` VALUES ('51', '哈哈???', '54', '55', '2018-10-16 23:55:05');

-- ----------------------------
-- Table structure for plate
-- ----------------------------
DROP TABLE IF EXISTS `plate`;
CREATE TABLE `plate` (
  `bid` int(11) NOT NULL AUTO_INCREMENT COMMENT '板块id',
  `bname` varchar(255) NOT NULL COMMENT '板块名字',
  `btime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '板块创建时间',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='板块表';

-- ----------------------------
-- Records of plate
-- ----------------------------
INSERT INTO `plate` VALUES ('1', 'java', '2018-03-30 18:08:51');
INSERT INTO `plate` VALUES ('2', 'C++', '2018-03-30 18:55:29');
INSERT INTO `plate` VALUES ('3', 'Python', '2018-04-17 20:00:42');
INSERT INTO `plate` VALUES ('19', '人工智能', '2018-04-17 20:01:55');
INSERT INTO `plate` VALUES ('20', '移动开发', '2018-04-17 20:03:56');
INSERT INTO `plate` VALUES ('21', '程序人生', '2018-04-17 20:04:25');
INSERT INTO `plate` VALUES ('22', '前端', '2018-04-17 20:05:00');
INSERT INTO `plate` VALUES ('23', '运维', '2018-04-17 20:05:05');
INSERT INTO `plate` VALUES ('24', '架构', '2018-04-17 20:05:10');
INSERT INTO `plate` VALUES ('26', 'github', '2018-06-04 10:09:34');
INSERT INTO `plate` VALUES ('27', 'C#', '2018-10-11 12:58:03');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(45) NOT NULL COMMENT '用户姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `password` varchar(45) NOT NULL COMMENT '用户密码',
  `email` varchar(45) NOT NULL COMMENT '用户email',
  `family` varchar(45) DEFAULT NULL COMMENT '用户住址',
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '个人简介',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('26', '马亮', null, null, '123', '924818949@qq.com', null, null, '2018-04-17 20:07:06');
INSERT INTO `user` VALUES ('28', '陈意涵', null, null, '123', '6755656565@qq.com', null, null, '2018-04-17 21:29:57');
INSERT INTO `user` VALUES ('29', '古天乐', '48', '男', '888999', 'maliangnansheng@gmail.com', '中国香港', '无', '2018-06-03 22:58:12');
INSERT INTO `user` VALUES ('43', '东方大国', '48', '男', '123', '924818949@qq.com', '中国香港', '的地方大幅度', '2018-06-04 10:08:14');
INSERT INTO `user` VALUES ('44', '张丽娜', null, null, '123', '225778@qq.com', null, null, '2018-08-28 23:59:32');
INSERT INTO `user` VALUES ('45', 'a', null, null, 'a', 'a@a.com', null, null, '2018-09-15 14:32:42');
INSERT INTO `user` VALUES ('46', 'baobei', null, null, '123', '77373737@qq.com', null, null, '2018-09-28 17:33:09');
INSERT INTO `user` VALUES ('47', '111', null, null, '111', 'xiang.wang@139.com', null, null, '2018-09-21 14:42:36');
INSERT INTO `user` VALUES ('49', 'unkonw', null, null, '123456', '123456@123.com', null, null, '2018-10-11 12:32:46');
INSERT INTO `user` VALUES ('52', '纷纷枸', '18', '男', '735014', '1295632566@qq.com', '柳橙汁', '美男子', '2018-10-13 17:04:13');
INSERT INTO `user` VALUES ('53', 'zhuhui', null, null, '123456', '1179820776@qq.com', null, null, '2018-10-15 17:22:13');
INSERT INTO `user` VALUES ('54', '马特思娜', null, null, '123', '968526@qq.com', null, null, '2018-10-16 23:53:49');

-- ----------------------------
-- Table structure for via
-- ----------------------------
DROP TABLE IF EXISTS `via`;
CREATE TABLE `via` (
  `userid` int(11) NOT NULL COMMENT '用户id',
  `photo` varchar(255) NOT NULL COMMENT '用户头像',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='头像表';

-- ----------------------------
-- Records of via
-- ----------------------------
INSERT INTO `via` VALUES ('26', 'cbe21bee-bd76-49c3-ac80-25329539bf24beijing3.png');
INSERT INTO `via` VALUES ('28', 'ae736c2d-b55b-4135-8c32-7fc433d2ab39156e36861bcbe7ccd83b9bada2e99322.jpg');
INSERT INTO `via` VALUES ('29', '6bf20733-8291-4d42-a29f-87c8368c968f2017_9_1_16_57_31_id7_814f253234a906a1d422f3c4fe832fa1.jpg');
INSERT INTO `via` VALUES ('54', 'a6fea7d5-4245-437e-b845-c21572787d68-3b7a0f0c9e1beb73.jpg');
