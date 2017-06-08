/*
Navicat MySQL Data Transfer

Source Server         : .
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : mytally

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-05-16 22:24:04
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
  `tallytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_tally
-- ----------------------------
INSERT INTO `tbl_tally` VALUES ('1', 'f65bfd13-7737-461a-8874-67655b16a8c4', '0', '233', '买菜', '2017-05-12 00:00:00');
INSERT INTO `tbl_tally` VALUES ('2', 'f65bfd13-7737-461a-8874-67655b16a8c4', '1', '200', '彩票', '2017-05-14 00:00:00');
INSERT INTO `tbl_tally` VALUES ('3', 'f65bfd13-7737-461a-8874-67655b16a8c4', '0', '12', '123', '2017-05-14 15:08:54');
INSERT INTO `tbl_tally` VALUES ('4', 'f65bfd13-7737-461a-8874-67655b16a8c4', '1', '111', '123', '2017-05-14 15:08:55');
INSERT INTO `tbl_tally` VALUES ('5', 'f65bfd13-7737-461a-8874-67655b16a8c4', '0', '1', '公交', '2017-05-14 15:08:57');
INSERT INTO `tbl_tally` VALUES ('6', 'f65bfd13-7737-461a-8874-67655b16a8c4', '0', '123', '逛街', '2017-05-14 15:08:57');
INSERT INTO `tbl_tally` VALUES ('7', 'f65bfd13-7737-461a-8874-67655b16a8c4', '1', '123', '发传单', '2017-05-14 15:08:57');
INSERT INTO `tbl_tally` VALUES ('8', 'f65bfd13-7737-461a-8874-67655b16a8c4', '1', '124', '提出', '2017-05-14 15:08:57');

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
