/*
Navicat MySQL Data Transfer

Source Server         : .
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : mytally

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-06-09 00:04:01
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
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_tally
-- ----------------------------
INSERT INTO `tbl_tally` VALUES ('13', 'f65bfd13-7737-461a-8874-67655b16a8c4', '1', '2', '123', '2017-06-08 23:55:11');
INSERT INTO `tbl_tally` VALUES ('14', 'f65bfd13-7737-461a-8874-67655b16a8c4', '1', '3', '123213', '2017-06-08 23:55:12');
INSERT INTO `tbl_tally` VALUES ('15', 'f65bfd13-7737-461a-8874-67655b16a8c4', '1', '6', '123123', '2017-06-08 23:55:13');
INSERT INTO `tbl_tally` VALUES ('16', 'f65bfd13-7737-461a-8874-67655b16a8c4', '1', '4', '张韦买菜', '2017-06-08 23:55:14');
INSERT INTO `tbl_tally` VALUES ('17', 'f65bfd13-7737-461a-8874-67655b16a8c4', '1', '4', '张韦买菜', '2017-06-08 23:55:44');
INSERT INTO `tbl_tally` VALUES ('18', 'f65bfd13-7737-461a-8874-67655b16a8c4', '0', '6', '买烟', '2017-06-08 23:55:47');
INSERT INTO `tbl_tally` VALUES ('19', 'f65bfd13-7737-461a-8874-67655b16a8c4', '0', '8', '买衣服', '2017-06-08 23:55:19');
INSERT INTO `tbl_tally` VALUES ('9', 'f65bfd13-7737-461a-8874-67655b16a8c4', '1', '1', '1111', '2017-06-08 14:58:28');
INSERT INTO `tbl_tally` VALUES ('12', 'f65bfd13-7737-461a-8874-67655b16a8c4', '1', '9', '1', '2017-06-08 23:55:52');
INSERT INTO `tbl_tally` VALUES ('20', 'f65bfd13-7737-461a-8874-67655b16a8c4', '0', '8', '油盐酱醋', '2017-06-08 23:56:25');

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
