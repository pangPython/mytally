/*
Navicat MySQL Data Transfer

Source Server         : .
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : mytally

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-05-12 23:18:20
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
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_tally
-- ----------------------------
INSERT INTO `tbl_tally` VALUES ('1', 'f65bfd13-7737-461a-8874-67655b16a8c4', '0', '233', '买菜', '2017-05-12 23:17:33');

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
