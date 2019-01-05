/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : zjscmis

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 05/01/2019 16:38:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `leader` varchar(255) NOT NULL,
  `rank` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `isImportant` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL,
  `src` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------
BEGIN;
INSERT INTO `items` VALUES (1, '宇宙教学平台', '张宇宙', 0, 2, 1, 0, 'itemSrc');
COMMIT;

-- ----------------------------
-- Table structure for notices
-- ----------------------------
DROP TABLE IF EXISTS `notices`;
CREATE TABLE `notices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `author` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notices
-- ----------------------------
BEGIN;
INSERT INTO `notices` VALUES (8, '关于参加浙江省产业工会第五期职工大病医疗互助保障的通知', '<p>各位老师：</p><p>省产业工会第五期职工大病医疗互助保障参保工作正式启动，为做好参保工作，现就有关事项通知如下：</p><p>一、参加对象</p><p>在职在岗的学校事业编制教职工和已加入工会的其他非事业编制人员，自愿申请参加职工大病医疗互助保障。</p><p>二、保障期限</p><p>第五期职工大病互助医疗保障期限为一年，自2019年的1月1日零时至2019年的12月31日24时止。</p><p>三、缴费标准</p><p>第五保障期缴费标准为每人每份100元，每人限保一份。</p><p>自愿参加职工大病医疗互助保障的工会会员，学校行政和工会补助80元/人，个人缴纳20元。</p><p>教职工参保后享受保障待遇不受工作单位变动的限制。保障期内不办理退保和新增人员的参保。</p><p>四、参加程序</p><p>各位老师应了解互助保障的意义和内容，提高自我保障意识，确保利益得到充分保障。</p><p>于12月5日前将个人保障金20元交唐步明老师支付宝tangbuming@qq.com，并备注姓名。</p><p>联系电话85070303。</p><p>&nbsp;</p><p>信息学院分工会<br/>2018年11月16日</p><p><br/></p>', '2019-01-05 14:21:49', '办公室');
INSERT INTO `notices` VALUES (9, '关于继续探索实施导师制的通知', '<p>&nbsp; 信息学院在2014级、2015级同学中实施了导师制，取得了一些成效。为进一步完善人才培养模式，充分发挥优秀专业教师在学生培养过程中的引领作用,增进师生交流，构建和谐师生关系，实施个性化培养，提高人才培养质量，学院决定继续实施导师制。据抽样调查，部分专业、学生需求强烈。现就本次师生双向选择有关事项通知如下：<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.教师自愿参与。教师参与情况，以专业、部、中心为单位汇总反馈给学工办张金英老师。导师信息公布在：师资队伍教师风采_浙江科技学院-信息与电子工程学院&nbsp;&nbsp;<a href=\"http://itee.zust.edu.cn/plus/list.php?tid=22\">http://itee.zust.edu.cn/plus/list.php?tid=22</a>&nbsp;。需要更新信息的老师，请联系院办唐步明老师。试点邀请个别校友担任导师。<br/><br/>&nbsp;&nbsp;&nbsp; &nbsp; 2.学生自愿参与。此次导师制面向2016级（含历年未按时进入毕业环节学生）、2017级和2018级信息学院在读普通本科生。学生的基本信息导入到双向选择系统，除<img alt=\"\" src=\"http://itee.zust.edu.cn/uploadfiles/allimg/181115/30-1Q115162205130.png\"/>外，2018级包括<img alt=\"\" src=\"http://itee.zust.edu.cn/uploadfiles/allimg/181115/30-1Q115162236151.png\"/>等信息，2016级、2017级包括<img alt=\"\" src=\"http://itee.zust.edu.cn/uploadfiles/allimg/181115/30-1Q11516234c36.png\"/><img alt=\"\" src=\"http://itee.zust.edu.cn/uploadfiles/allimg/181115/30-1Q1151624023U.png\"/>等信息，三位一体招生、民族预科招生、获奖情况、实习经历等其他情况学生可以自行备注。<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp; 3.每学年进行一次双向选择。学生可以在本专业教师和未限定专业教师中选择导师，3个志愿+是否服从调剂，导师可选择接受或拒绝学生，原则上每个导师每个年级指导学生上限为7人，学院、专业最后统一调剂。未随原年级进入毕业环节、退学警示、学业预警、复学、转专业、退伍返校、出国交流等情况学生提前增加一轮选择机会，即使在没有导师选择的情况下，学院平均分配给导师。双学期新出现以上情况学生单独配备导师。<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;4.希望在11月份完成本次双向选择，具体操作后续公布。张金英老师办公室C2-503，联系电话：85070301,&nbsp;17826804878，540712（校园短号）。<br/>&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;信息与电子工程学院</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2018年11月15日<br/></p><p><br/></p>', '2019-01-05 14:22:46', '学工办');
INSERT INTO `notices` VALUES (10, '关于举办教材展示活动的通知', '<p>&nbsp;时间：11月8日（星期四）11:00——16:00<br/>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;地点：C2楼5层走廊<br/></p><p>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;内容：机械工业出版社举办计算机与电子类教材展示活动，届时每位老师可通过填单获取赠送两本教材样书。<br/>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;欢迎老师们参与选用。</p><p><br/></p>', '2019-01-05 14:23:30', '办公室');
INSERT INTO `notices` VALUES (11, '关于2017-2018学年班主任考核情况以及校就业工作先进个人推荐名单的公示', '<p>&nbsp;经专业推荐、学工组评议，现将2017-2018学年班主任考核情况公示如下：<br/>&nbsp;&nbsp;&nbsp; 优秀班主任：陶红卫（通信161、162）、何成（电信171、172）、孙丽慧（物联网151、152）<br/>&nbsp;&nbsp;&nbsp; 其他班主任考核均合格。&nbsp;&nbsp;&nbsp;&nbsp;<br/>&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;经专业推荐、学工组评议，现将2017-2018学年校就业先进个人推荐情况公示如下：<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 就业先进个人：孔颖（计算机143）、唐伟（数媒141、142）、孙晓勇（软工141、142）、陈原（就业辅导员）<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 公示期为2018年11月20日-11月25日。如有异议，请及时反馈给学院学工组。</p><p>联系人： &nbsp;姜国泉 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话： 85070304</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;信息学院学工组</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2018年11月20日<br/></p><p><br/></p>', '2019-01-05 14:24:00', '学工办');
INSERT INTO `notices` VALUES (12, '关于开展2017-2018学年班主任考核的通知', '<p>各二级学院：<br/>为进一步加强我校班主任管理工作，全面客观地评价班主任的工作，进一步发挥班主任在学生思想政治教育与管理工作中的作用，根据《关于进一步加强辅导员班主任队伍建设的实施办法》(浙科院党发〔2011〕4号)文件精神，现将2017-2018学年班主任考核工作的有关事宜通知如下：<br/></p><ul style=\"list-style-type: none;\" class=\" list-paddingleft-2\"><li><p>考核对象：</p></li></ul><p>全校担任2017-2018学年的班主任<br/></p><ul style=\"list-style-type: none;\" class=\" list-paddingleft-2\"><li><p>考核组织：</p></li></ul><p>学院成立考核小组，由分管学生工作的副书记（书记）为组长，负责组织实施对本学院班主任工作的考核。<br/></p><ul style=\"list-style-type: none;\" class=\" list-paddingleft-2\"><li><p>考核办法和要求</p></li></ul><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; （一）考核办法：<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.通过个人总结、学生和学院评价等方式进行。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.班主任填写考核表，由学院根据各自实际情况自行制定《班主任工作学院评价考核办法》，考核指标要充分体现班级学生的考试及格率、外语和计算机等级考试通过率、各类学科竞赛获奖、科研、考研、自修学习、课堂纪律、寝室文明建设等情况，要重点考核班主任与学生的思想交流、班集体建设、关心学生学习等情况。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3、班主任考核分优秀、合格和不合格三个等级，优秀的比例不超过本学院班主任总数的10%。<br/>&nbsp;&nbsp;&nbsp;&nbsp; （二）考核要求：<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.班主任在工作中对学生应实行“方向性、全面性、情感性、疏导性、民主性、集体性和表率性”的工作原则。每学期（年）初，根据学院的有关文件和院领导的要求开展工作，制订工作计划，并定期对照，检查，及时向有关部门汇报。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.各学院班主任在自我总结的基础上，学院学工组和党政领导根据每个班主任所做的实际工作和班级实际效果两个方面综合考评，并召开学生座谈会广泛听取意见后确定初选名单。<br/></p><ul style=\"list-style-type: none;\" class=\" list-paddingleft-2\"><li><p>考核程序</p></li></ul><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1.个人总结：班主任根据考核要求进行工作总结，填写《班主任工作考核表》，将《考核表》和《班主任工作手册》一起上交本学院。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.学生评价：考核小组组织班级学生对班主任工作的满意度进行评议，毕业班班主任此项考评可由二级学院负责就业的辅导员给予评价。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.学院评价：考核小组根据学院评价考核办法，组织学院有关领导、辅导员、班级任课教师等有关人员对班主任工作进行评议。学院评议要以事实为依据，参考《班主任工作手册》等工作记录，也可以集体听取班主任工作汇报。毕业班的就业率应作为该班级班主任考核的重要指标。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4.等级评定：学院根据班级及其学生的奖惩情况给班主任相应的考核后，按考核给班主任工作评定考核等级，评定考核等级可以适当考虑不同年级的具体情况。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 若班级发生重大安全事件和严重违纪事件的，班主任考核不得评定为优秀。<br/></p><ul style=\"list-style-type: none;\" class=\" list-paddingleft-2\"><li><p>上交时间</p></li></ul><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 请于11月20日前把《浙江科技学院班主任考核表》纸质、《2017-2018学年班主任考核人员汇总表》（电子和纸质）和《2018-2019学年班主任信息统计汇总表》(电子和纸质)盖章交C2-501。</p><p><br/></p>', '2019-01-05 14:24:33', '学工办');
INSERT INTO `notices` VALUES (13, '关于2017-2018学年特优学风班、优良学风班推荐名单结果公示', '<p>关于2017-2018学年特优学风班、优良学风班推荐名单结果公示</p><p>&nbsp;<br/>&nbsp; &nbsp; &nbsp; &nbsp; 根据《浙江科技学院优良学风班评选条例》（浙科院学生处〔2009〕16号）的有关规定，经班级申报，学工组讨论研究，从申报的17个班级中评出5个校优良学风班和3个校特优学风班。现予以公示，公示时间为2018年10月25日至2018年10月30日。敬请广大师生监督，如有异议请在公示期内联系相关老师。提倡书面实名反馈。<br/>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br/>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 联系人：姜国泉老师 &nbsp;85070304<br/>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;陈原老师 &nbsp;85070309<br/>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;信息学院学工组<br/>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;2018.10.25<br/>&nbsp;</p><p><br/></p>', '2019-01-05 14:25:05', '学工办');
COMMIT;

-- ----------------------------
-- Table structure for other
-- ----------------------------
DROP TABLE IF EXISTS `other`;
CREATE TABLE `other` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` float NOT NULL,
  `point_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `src` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `other_points_FK` (`point_id`),
  CONSTRAINT `other_points_FK` FOREIGN KEY (`point_id`) REFERENCES `points` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of other
-- ----------------------------
BEGIN;
INSERT INTO `other` VALUES (1, 100, 11, 0, 'othersrc');
INSERT INTO `other` VALUES (2, 20, 13, 0, 'resources/others/201811/e053151c-12b4-442c-b0d1-16b32b42f161.html');
INSERT INTO `other` VALUES (3, 2, 16, 0, 'resources/others/201811/fe3c230b-e93a-4dd6-be8b-b50e605a02a1.html');
INSERT INTO `other` VALUES (4, 5, 43, 0, 'resources/others/201811/82ab3b13-26c1-4661-8fe9-40ef199ffac2.html');
INSERT INTO `other` VALUES (5, 11, 50, 1, 'resources/others/201811/94323b9e-73ca-4658-aa5d-ff3f4f838f50.html');
INSERT INTO `other` VALUES (6, 15, 11, -1, 'resources/others/20190/756d5b05-f16d-4b3a-8553-0f25c4a81beb.html');
INSERT INTO `other` VALUES (7, 15, 26, 1, 'resources/others/20190/a41830dc-1c0b-485e-a546-6d57425231e6.html');
COMMIT;

-- ----------------------------
-- Table structure for papers
-- ----------------------------
DROP TABLE IF EXISTS `papers`;
CREATE TABLE `papers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `firstType` int(11) NOT NULL,
  `member` varchar(255) NOT NULL,
  `paperType` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `src` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of papers
-- ----------------------------
BEGIN;
INSERT INTO `papers` VALUES (1, 'spring的探索之路', 0, '周志文，张铁标，冯天祥，张亦凡', 2, 1, 'papersrc');
COMMIT;

-- ----------------------------
-- Table structure for points
-- ----------------------------
DROP TABLE IF EXISTS `points`;
CREATE TABLE `points` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `now` float DEFAULT NULL,
  `goal` float DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  `nextgoal` float DEFAULT NULL,
  `nextdeadline` date DEFAULT NULL,
  `targetId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `2` (`targetId`),
  CONSTRAINT `points_targets_FK` FOREIGN KEY (`targetId`) REFERENCES `targets` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of points
-- ----------------------------
BEGIN;
INSERT INTO `points` VALUES (1, '专任教师总数（人）', 40, 50, '2019-07-31', 0, NULL, 1);
INSERT INTO `points` VALUES (2, '国家级人才（人）', 1, 6, '2019-07-31', 0, NULL, 1);
INSERT INTO `points` VALUES (3, '省级人才（人）', 8, 20, '2019-07-24', 0, NULL, 1);
INSERT INTO `points` VALUES (4, '博士学位教师占比（%）', 45, 70, '2019-07-28', 0, NULL, 2);
INSERT INTO `points` VALUES (5, '35周岁以下青年教师占比（%）', 12, 50, '2019-07-13', 0, NULL, 2);
INSERT INTO `points` VALUES (6, '省部级及以上创新团队数（个）', 7, 15, '2019-06-30', 0, NULL, 3);
INSERT INTO `points` VALUES (8, '国家教学平台（个）', 2, 15, '2019-01-03', 10, '2019-07-15', 5);
INSERT INTO `points` VALUES (9, '省级教学平台数（个）', 5, 10, '2019-01-22', 8, '2019-07-15', 5);
INSERT INTO `points` VALUES (10, '本学科以第一作者在核心期刊（浙大标准）发表论文数（篇）', 4, 20, '2019-05-31', 10, '2019-07-15', 6);
INSERT INTO `points` VALUES (11, '本科生读研率（%）', 36, 50, '2019-07-24', 3045, '2019-07-15', 6);
INSERT INTO `points` VALUES (12, '研究生以第一作者在SCI、SSCI、EI、MEDLINE、A&HCI 、CSCD、CSSCI收录期刊及在国内一级期刊（浙大标准）发表论文数（篇）', 4, 10, '2019-06-30', 5, '2019-07-15', 7);
INSERT INTO `points` VALUES (13, '研究生学位论文抽检优良率（%）', 55, 80, '2019-09-30', 70, '2019-07-15', 7);
INSERT INTO `points` VALUES (14, '国家教学成果奖（项）', 1, 5, '2019-08-31', 3, '2019-07-15', 8);
INSERT INTO `points` VALUES (15, '省级教学成果奖（项）', 3, 10, '2019-06-22', 4, '2019-07-15', 8);
INSERT INTO `points` VALUES (16, '国家精品课程、视频公开课（门）', 6, 10, '2019-08-31', 8, '2019-07-15', 8);
INSERT INTO `points` VALUES (17, '国家级规划教材（部）', 3, 5, '2019-08-31', 5, '2019-07-15', 8);
INSERT INTO `points` VALUES (18, '省部级及以上学科竞赛奖励（项）', 10, 10, '2019-09-30', 10, '2019-07-15', 8);
INSERT INTO `points` VALUES (20, '国家级科研创新平台数（个）', 1, 5, '2019-06-30', 3, '2019-09-15', 10);
INSERT INTO `points` VALUES (21, '省部级科研创新平台数（个）', 4, 10, '2019-06-30', 5, '2019-09-15', 10);
INSERT INTO `points` VALUES (22, '主持国家级科研项目数（项）', 2, 10, '2019-06-30', 5, '2019-09-15', 11);
INSERT INTO `points` VALUES (23, '国家级重点、重大科研项目数（项）', 2, 5, '2019-06-30', 2, '2019-09-15', 11);
INSERT INTO `points` VALUES (24, '主持省部级科研项目数（项）', 15, 50, '2019-06-30', 30, '2019-09-15', 11);
INSERT INTO `points` VALUES (25, '省部级重点、重大科研项目数（项）', 1, 10, '2019-06-30', 5, '2019-09-15', 11);
INSERT INTO `points` VALUES (26, '师均科研经费（万元）', 20, 30, '2019-06-30', 25, '2019-09-15', 11);
INSERT INTO `points` VALUES (27, '在SCI、SSCI、EI、MEDLINE、A&HCI、CSCD、CSSCI收录期刊及在一级期刊（浙大标准）发表论文数（篇）', 20, 30, '2019-06-30', 25, '2019-09-15', 12);
INSERT INTO `points` VALUES (28, '国内权威期刊论文数（篇）', 2, 10, '2019-06-30', 5, '2019-09-15', 12);
INSERT INTO `points` VALUES (29, 'SCI top收录期刊论文数（篇）', 1, 5, '2019-06-30', 3, '2019-09-15', 12);
INSERT INTO `points` VALUES (30, '出版著作（部）', 1, 10, '2019-06-30', 5, '2019-09-15', 12);
INSERT INTO `points` VALUES (31, '授权发明专利（件）', 5, 10, '2019-06-30', 8, '2019-09-15', 12);
INSERT INTO `points` VALUES (32, '获国家级成果奖励（项）', 1, 5, '2019-06-30', 2, '2019-09-15', 13);
INSERT INTO `points` VALUES (33, '获省部级成果奖励（项）', 6, 10, '2019-06-30', 8, '2019-09-15', 13);
INSERT INTO `points` VALUES (34, '省部级一等奖成果奖励（项）', 2, 5, '2019-06-30', 5, '2019-09-15', 13);
INSERT INTO `points` VALUES (35, '横向课题到款经费（万元）', 85, 200, '2019-07-31', 100, '2019-09-15', 14);
INSERT INTO `points` VALUES (36, '横向课题项目个数（个）', 9, 50, '2019-07-31', 20, '2019-09-15', 14);
INSERT INTO `points` VALUES (37, '产学研平台（个）', 3, 5, '2019-08-31', 5, '2019-09-15', 14);
INSERT INTO `points` VALUES (38, '科技成果转化收入（万元）', 35, 50, '2019-07-31', 45, '2019-09-15', 14);
INSERT INTO `points` VALUES (40, '国务院学位中心学科评估排名', 25, 60, '2019-06-30', 0, NULL, 16);
INSERT INTO `points` VALUES (41, 'ESI学科排名', 25, 25, '2019-06-30', 0, NULL, 16);
INSERT INTO `points` VALUES (42, '一级学科博士点或博士专业学位类别数（个）', 0, 5, '2019-06-30', 0, NULL, 17);
INSERT INTO `points` VALUES (43, '一级学科硕士点或硕士专业学位类别数（个）', 5, 50, '2019-06-30', 0, NULL, 17);
INSERT INTO `points` VALUES (44, '国家特色专业、国家专业综合改革试点（个）', 1, 5, '2019-06-30', 0, NULL, 18);
INSERT INTO `points` VALUES (45, '省优势、特色、新兴专业（个）', 9, 10, '2019-06-30', 0, NULL, 18);
INSERT INTO `points` VALUES (46, '在重要学术机构担任重要职务的人数（人）', 12, 30, '2019-06-30', 0, NULL, 19);
INSERT INTO `points` VALUES (48, '一年及以上出国（境）研修教师占比（%）', 12, 100, '2019-06-30', 0, NULL, 21);
INSERT INTO `points` VALUES (49, '聘请外国专家人数（人）', 1, 5, '2019-06-30', 0, NULL, 21);
INSERT INTO `points` VALUES (50, '赴国（境）外联合培养（三个月以上）学生占比（%）', 11, 50, '2019-06-30', 0, NULL, 22);
INSERT INTO `points` VALUES (51, '外国学历留学生数（人）', 66, 100, '2019-06-30', 0, NULL, 22);
INSERT INTO `points` VALUES (52, '国际科研合作项目数（个）', 1, 100, '2019-06-30', 0, NULL, 23);
INSERT INTO `points` VALUES (53, '主办国际学术会议（次）', 0, 5, '2019-06-30', 0, NULL, 23);
INSERT INTO `points` VALUES (54, '参加国际学术会议人次（次）', 15, 20, '2019-06-30', 0, NULL, 23);
INSERT INTO `points` VALUES (57, '出国交流人才（位）', 1, 8, '2019-03-31', 5, '2019-07-15', 9);
INSERT INTO `points` VALUES (58, '研究生出国交流人才（位）', 2, 5, '2019-05-16', 2, '2019-07-15', 9);
INSERT INTO `points` VALUES (59, '项目立项（个）', 14, 20, '2019-01-24', 15, NULL, 15);
INSERT INTO `points` VALUES (60, '竞赛获奖（项）', 15, 50, '2019-01-23', 25, NULL, 15);
INSERT INTO `points` VALUES (61, '学科影响力（%）', 20, 50, '2019-01-16', NULL, NULL, 20);
INSERT INTO `points` VALUES (62, '参加国际学术会议（个）', 40, 50, '2019-01-24', NULL, NULL, 24);
COMMIT;

-- ----------------------------
-- Table structure for records
-- ----------------------------
DROP TABLE IF EXISTS `records`;
CREATE TABLE `records` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `type` int(11) NOT NULL,
  `recordId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `records_users_FK` (`userId`),
  CONSTRAINT `records_users_FK` FOREIGN KEY (`userId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of records
-- ----------------------------
BEGIN;
INSERT INTO `records` VALUES (1, 2, '2018-12-13 00:00:00', 0, 1);
INSERT INTO `records` VALUES (2, 2, '2018-12-29 22:40:57', 1, 1);
INSERT INTO `records` VALUES (3, 2, '2018-12-13 00:00:00', 2, 1);
INSERT INTO `records` VALUES (4, 2, '2018-12-13 00:00:00', 3, 1);
INSERT INTO `records` VALUES (5, 2, '2018-12-29 22:53:19', 0, 3);
INSERT INTO `records` VALUES (6, 2, '2018-12-29 22:59:57', 0, 4);
INSERT INTO `records` VALUES (7, 2, '2018-12-29 23:04:52', 0, 5);
INSERT INTO `records` VALUES (8, 2, '2019-01-03 15:36:59', 0, 6);
INSERT INTO `records` VALUES (9, 2, '2019-01-03 15:56:09', 0, 7);
COMMIT;

-- ----------------------------
-- Table structure for targets
-- ----------------------------
DROP TABLE IF EXISTS `targets`;
CREATE TABLE `targets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first` varchar(255) NOT NULL,
  `second` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of targets
-- ----------------------------
BEGIN;
INSERT INTO `targets` VALUES (1, '师资队伍建设', '专任教师人数');
INSERT INTO `targets` VALUES (2, '师资队伍建设', '专任教师结构');
INSERT INTO `targets` VALUES (3, '师资队伍建设', '团队');
INSERT INTO `targets` VALUES (4, '师资队伍建设', '自设指标');
INSERT INTO `targets` VALUES (5, '人才培养', '教学平台');
INSERT INTO `targets` VALUES (6, '人才培养', '本科生教育');
INSERT INTO `targets` VALUES (7, '人才培养', '研究生教育');
INSERT INTO `targets` VALUES (8, '人才培养', '教学成果与奖励');
INSERT INTO `targets` VALUES (9, '人才培养', '自设指标');
INSERT INTO `targets` VALUES (10, '科学研究与社会服务水平', '科研平台');
INSERT INTO `targets` VALUES (11, '科学研究与社会服务水平', '科研项目与经费');
INSERT INTO `targets` VALUES (12, '科学研究与社会服务水平', '科研成果');
INSERT INTO `targets` VALUES (13, '科学研究与社会服务水平', '成果奖励');
INSERT INTO `targets` VALUES (14, '科学研究与社会服务水平', '社会服务');
INSERT INTO `targets` VALUES (15, '科学研究与社会服务水平', '自设指标');
INSERT INTO `targets` VALUES (16, '学科影响力', '学科排名');
INSERT INTO `targets` VALUES (17, '学科影响力', '学位点建设');
INSERT INTO `targets` VALUES (18, '学科影响力', '专业建设');
INSERT INTO `targets` VALUES (19, '学科影响力', '学术兼职');
INSERT INTO `targets` VALUES (20, '学科影响力', '自设指标');
INSERT INTO `targets` VALUES (21, '国际合作与交流', '师资国际化');
INSERT INTO `targets` VALUES (22, '国际合作与交流', '人才培养国际化');
INSERT INTO `targets` VALUES (23, '国际合作与交流', '国际交流');
INSERT INTO `targets` VALUES (24, '国际合作与交流', '自设指标');
COMMIT;

-- ----------------------------
-- Table structure for teachers
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `birthday` date DEFAULT NULL,
  `edu` int(11) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL COMMENT '人才等级（国家级 省级）',
  `isImportant` int(11) DEFAULT '0',
  `status` int(11) NOT NULL,
  `src` varchar(255) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of teachers
-- ----------------------------
BEGIN;
INSERT INTO `teachers` VALUES (1, '张宇宙', '1980-01-01', 0, '教授', 0, 1, 2, 'teacherSrc', '321');
COMMIT;

-- ----------------------------
-- Table structure for teams
-- ----------------------------
DROP TABLE IF EXISTS `teams`;
CREATE TABLE `teams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rank` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `member` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  `src` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES (1, '123', '202cb962ac59075b964b07152d234b70', '管理员', 0);
INSERT INTO `users` VALUES (2, '321', 'caf1a3dfb505ffed0d024130f58c5cfa', '张宇宙', 1);
INSERT INTO `users` VALUES (3, '456', '96e79218965eb72c92a549dd5a330112', '王太阳', 1);
INSERT INTO `users` VALUES (4, '789', '96e79218965eb72c92a549dd5a330112', '李星星', 1);
INSERT INTO `users` VALUES (5, '369', '96e79218965eb72c92a549dd5a330112', '赵银河', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
