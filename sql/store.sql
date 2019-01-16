/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : store

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 16/01/2019 15:36:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `store_id` bigint(20) NOT NULL COMMENT '商铺唯一编号',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商铺名称',
  `describe` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '店铺描述',
  `merchant_id` bigint(20) NOT NULL COMMENT '商户编号',
  PRIMARY KEY (`store_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for store_goods
-- ----------------------------
DROP TABLE IF EXISTS `store_goods`;
CREATE TABLE `store_goods`  (
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `price` tinyint(4) NOT NULL COMMENT '商品价格',
  `inventory` int(11) NOT NULL COMMENT '商品库存',
  `store_id` bigint(20) DEFAULT NULL COMMENT '商铺编号',
  `freeze_inventory` int(11) DEFAULT NULL COMMENT '冻结库存',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
