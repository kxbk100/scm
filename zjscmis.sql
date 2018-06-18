/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : zjscmis

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-06-18 02:37:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goal
-- ----------------------------
DROP TABLE IF EXISTS `goal`;
CREATE TABLE `goal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first` varchar(255) NOT NULL,
  `second` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL COMMENT '具体指标',
  `now` float DEFAULT NULL,
  `goal` float DEFAULT NULL,
  `next_goal` float DEFAULT NULL,
  `type` int(11) NOT NULL COMMENT '目标类型（百分比或数目）',
  `dead_line` date DEFAULT NULL COMMENT '截止日期',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goal
-- ----------------------------
INSERT INTO `goal` VALUES ('1', '师资队伍建设', '专任教师人数', '专任教师总数（人）', '1', '20', null, '0', '2019-01-13');
INSERT INTO `goal` VALUES ('2', '师资队伍建设', '专任教师人数', '国家级人才（人）', '2', '5', null, '0', '2018-12-02');
INSERT INTO `goal` VALUES ('3', '师资队伍建设', '专任教师人数', '省级人才（人）', '10', '10', null, '0', '2018-01-01');
INSERT INTO `goal` VALUES ('4', '师资队伍建设', '专任教师结构', '博士学位教师占比（%）', '20', '75', null, '1', '2019-01-01');
INSERT INTO `goal` VALUES ('5', '师资队伍建设', '专任教师结构', '35周岁以下青年教师占比（%）', '10', '90', null, '1', '2018-12-31');
INSERT INTO `goal` VALUES ('6', '师资队伍建设', '团队', '省部级及以上创新团队数（个）', '0', '15', null, '0', '2019-01-03');
INSERT INTO `goal` VALUES ('7', '人才培养', '教学平台', '国家教学平台（个）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('8', '人才培养', '教学平台', '省级教学平台数（个）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('9', '人才培养', '本科生教育', '本学科以第一作者在核心期刊（浙大标准）发表论文数（篇）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('10', '人才培养', '本科生教育', '本科生读研率（%）', null, null, null, '1', null);
INSERT INTO `goal` VALUES ('11', '人才培养', '研究生教育', '研究生以第一作者在SCI、SSCI、EI、MEDLINE、A&HCI 、CSCD、CSSCI收录期刊及在国内一级期刊（浙大标准）发表论文数（篇）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('12', '人才培养', '研究生教育', '研究生学位论文抽检优良率（%）', null, null, null, '1', null);
INSERT INTO `goal` VALUES ('13', '人才培养', '教学成果与奖励', '国家教学成果奖（项）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('14', '人才培养', '教学成果与奖励', '省级教学成果奖（项）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('15', '人才培养', '教学成果与奖励', '国家精品课程、视频公开课（门）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('16', '人才培养', '教学成果与奖励', '国家级规划教材（部）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('17', '人才培养', '教学成果与奖励', '省部级及以上学科竞赛奖励（项）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('18', '科学研究与社会服务水平', '科研平台', '国家级科研创新平台数（个）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('19', '科学研究与社会服务水平', '科研平台', '省部级科研创新平台数（个）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('20', '科学研究与社会服务水平', '科研项目与经费', '主持国家级科研项目数（项）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('21', '科学研究与社会服务水平', '科研项目与经费', '国家级重点、重大科研项目数（项）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('22', '科学研究与社会服务水平', '科研项目与经费', '主持省部级科研项目数（项）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('23', '科学研究与社会服务水平', '科研项目与经费', '省部级重点、重大科研项目数（项）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('24', '科学研究与社会服务水平', '科研项目与经费', '师均科研经费（万元）', null, null, null, '2', null);
INSERT INTO `goal` VALUES ('25', '科学研究与社会服务水平', '科研成果', '在SCI、SSCI、EI、MEDLINE、A&HCI、CSCD、CSSCI收录期刊及在一级期刊（浙大标准）发表论文数（篇）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('26', '科学研究与社会服务水平', '科研成果', '国内权威期刊论文数（篇）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('27', '科学研究与社会服务水平', '科研成果', 'SCI top收录期刊论文数（篇）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('28', '科学研究与社会服务水平', '科研成果', '出版著作（部）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('29', '科学研究与社会服务水平', '科研成果', '授权发明专利（件）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('30', '科学研究与社会服务水平', '成果奖励', '获国家级成果奖励（项）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('31', '科学研究与社会服务水平', '成果奖励', '获省部级成果奖励（项）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('32', '科学研究与社会服务水平', '成果奖励', '省部级一等奖成果奖励（项）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('33', '科学研究与社会服务水平', '社会服务', '横向课题到款经费（万元）', null, null, null, '2', null);
INSERT INTO `goal` VALUES ('34', '科学研究与社会服务水平', '社会服务', '横向课题项目个数（个）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('35', '科学研究与社会服务水平', '社会服务', '产学研平台（个）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('36', '科学研究与社会服务水平', '社会服务', '科技成果转化收入（万元）', null, null, null, '2', null);
INSERT INTO `goal` VALUES ('37', '学科影响力', '学科排名', '国务院学位中心学科评估排名', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('38', '学科影响力', '学科排名', 'ESI学科排名', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('39', '学科影响力', '学位点建设', '一级学科博士点或博士专业学位类别数（个）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('40', '学科影响力', '学位点建设', '一级学科硕士点或硕士专业学位类别数（个）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('41', '学科影响力', '专业建设', '国家特色专业、国家专业综合改革试点（个）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('42', '学科影响力', '专业建设', '省优势、特色、新兴专业（个）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('43', '学科影响力', '学术兼职', '在重要学术机构担任重要职务的人数（人）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('44', '国际合作与交流', '师资国际化', '一年及以上出国（境）研修教师占比（%）', null, null, null, '1', null);
INSERT INTO `goal` VALUES ('45', '国际合作与交流', '师资国际化', '聘请外国专家人数（人）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('46', '国际合作与交流', '人才培养国际化', '赴国（境）外联合培养（三个月以上）学生占比（%）', null, null, null, '1', null);
INSERT INTO `goal` VALUES ('47', '国际合作与交流', '人才培养国际化', '外国学历留学生数（人）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('48', '国际合作与交流', '国际交流', '国际科研合作项目数（个）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('49', '国际合作与交流', '国际交流', '主办国际学术会议（次）', null, null, null, '0', null);
INSERT INTO `goal` VALUES ('50', '国际合作与交流', '国际交流', '参加国际学术会议人次（次）', null, null, null, '0', null);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `author` varchar(255) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '王晨韬', '王晨韬', '王晨韬', '2018-06-10 18:03:41');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goal_id` int(11) NOT NULL,
  `son` int(11) DEFAULT NULL,
  `mom` int(11) DEFAULT NULL,
  `birth_day` date DEFAULT NULL,
  `now` float NOT NULL,
  `url` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('2', '1', '1', '2', null, '0.5', 'uploadFiles/2018_6_10_653587420.rar', '1', '5', '2018-06-10 06:25:35');
INSERT INTO `record` VALUES ('3', '1', '1', '2', null, '0.5', 'uploadFiles/2018_6_10_451446432.rar', '1', '5', '2018-06-10 14:27:34');

-- ----------------------------
-- Table structure for stage
-- ----------------------------
DROP TABLE IF EXISTS `stage`;
CREATE TABLE `stage` (
  `next_dead_line` date DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stage
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5', '冯天祥', '123', '0');
