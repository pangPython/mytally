/*
Navicat MySQL Data Transfer

Source Server         : .
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : mytally

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-06-09 23:57:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_tally`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_tally`;
CREATE TABLE `tbl_tally` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `useruuid` varchar(255) NOT NULL,
  `direction` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `note` text,
  `tallytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_tally
-- ----------------------------
INSERT INTO `tbl_tally` VALUES ('13', 'f65bfd13-7737-461a-8874-67655b16a8c4', '1', '2', '123', '2017-06-08 23:55:11');
INSERT INTO `tbl_tally` VALUES ('14', 'f65bfd13-7737-461a-8874-67655b16a8c4', '1', '3', '123213', '2017-06-08 23:55:12');
INSERT INTO `tbl_tally` VALUES ('22', 'f65bfd13-7737-461a-8874-67655b16a8c4', '0', '12', '测试', '2017-06-09 23:51:12');
INSERT INTO `tbl_tally` VALUES ('16', 'f65bfd13-7737-461a-8874-67655b16a8c4', '1', '4', '张韦买菜', '2017-06-08 23:55:14');
INSERT INTO `tbl_tally` VALUES ('17', 'f65bfd13-7737-461a-8874-67655b16a8c4', '1', '4', '张韦买菜', '2017-06-08 23:55:44');
INSERT INTO `tbl_tally` VALUES ('18', 'f65bfd13-7737-461a-8874-67655b16a8c4', '0', '5', '买烟', '2017-06-09 21:08:27');
INSERT INTO `tbl_tally` VALUES ('19', 'f65bfd13-7737-461a-8874-67655b16a8c4', '0', '3', '买衣服', '2017-06-10 21:08:23');
INSERT INTO `tbl_tally` VALUES ('9', 'f65bfd13-7737-461a-8874-67655b16a8c4', '1', '1', '1111', '2017-06-09 14:58:28');
INSERT INTO `tbl_tally` VALUES ('21', 'f65bfd13-7737-461a-8874-67655b16a8c4', '0', '12', '宿舍', '2017-06-09 22:31:02');

-- ----------------------------
-- Table structure for `tbl_user`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `uuid` varchar(255) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('f65bfd13-7737-461a-8874-67655b16a8c4', '1', 'admin', 'admin');
