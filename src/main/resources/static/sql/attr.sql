/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : test2

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-09-05 17:53:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attr
-- ----------------------------
DROP TABLE IF EXISTS `attr`;
CREATE TABLE `attr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `spuid` int(11) NOT NULL,
  `color` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `size` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `size_unit` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `attr_img` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
