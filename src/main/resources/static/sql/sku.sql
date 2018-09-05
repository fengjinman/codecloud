/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : test2

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-09-05 17:54:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sku
-- ----------------------------
DROP TABLE IF EXISTS `sku`;
CREATE TABLE `sku` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `classid` int(11) DEFAULT NULL,
  `brandid` int(11) DEFAULT NULL,
  `spuid` int(11) NOT NULL,
  `attrid` int(11) NOT NULL,
  `price` float DEFAULT '0',
  `unit` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `describtion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `stock_count` int(11) DEFAULT '0',
  `stock_address` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
