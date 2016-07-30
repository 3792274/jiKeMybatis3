/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : mybatis3

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-07-29 21:40:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `realName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `userID` int(20) DEFAULT NULL,
  `IDCard` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('1', '一个大牛', '8', null);
INSERT INTO `author` VALUES ('2', '一个大牛', '9', null);

-- ----------------------------
-- Table structure for jikeuser
-- ----------------------------
DROP TABLE IF EXISTS `jikeuser`;
CREATE TABLE `jikeuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `passWord` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of jikeuser
-- ----------------------------
INSERT INTO `jikeuser` VALUES ('1', '我是用户名', '我是密码');
INSERT INTO `jikeuser` VALUES ('2', '我是用户名', '我是密码');
INSERT INTO `jikeuser` VALUES ('5', '我是用户名5', '我是密码5');
INSERT INTO `jikeuser` VALUES ('8', '我是用户名', '我是密码');
INSERT INTO `jikeuser` VALUES ('9', '我是用户名', '我是密码');
INSERT INTO `jikeuser` VALUES ('10', '极客01用户名', '极客01密码');
INSERT INTO `jikeuser` VALUES ('11', '极客02用户名', '极客02密码');
INSERT INTO `jikeuser` VALUES ('12', '极客03用户名', '极客03密码');
INSERT INTO `jikeuser` VALUES ('13', '极客01用户名', '极客01密码');
INSERT INTO `jikeuser` VALUES ('14', '极客02用户名', '极客02密码');
INSERT INTO `jikeuser` VALUES ('15', '极客03用户名', '极客03密码');

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
  `readerID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  PRIMARY KEY (`readerID`),
  KEY `userID` (`userID`),
  CONSTRAINT `reader_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `jikeuser` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('1', '2', '500');
INSERT INTO `reader` VALUES ('2', '1', '100');
INSERT INTO `reader` VALUES ('3', '9', '300');
INSERT INTO `reader` VALUES ('4', '8', '600');

-- ----------------------------
-- Table structure for visit
-- ----------------------------
DROP TABLE IF EXISTS `visit`;
CREATE TABLE `visit` (
  `visitID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) DEFAULT NULL,
  `visitDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `visitIP` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`visitID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of visit
-- ----------------------------
INSERT INTO `visit` VALUES ('1', '1', '2016-07-13 15:04:46', '192.16.0.4');
