/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : test2

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-09-05 17:53:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bigclass
-- ----------------------------
DROP TABLE IF EXISTS `bigclass`;
CREATE TABLE `bigclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
