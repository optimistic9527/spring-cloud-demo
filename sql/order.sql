/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : order

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 16/01/2019 15:36:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`
(
  `order_detail_id` bigint(20) NOT NULL COMMENT '订单详情编号',
  `goods_id`        bigint(20) DEFAULT NULL COMMENT '商品编号',
  `count`           int(11)    DEFAULT NULL COMMENT '商品数量',
  `order_id`        bigint(20) DEFAULT NULL COMMENT '订单编号',
  PRIMARY KEY (`order_detail_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`
(
  `order_id`     bigint(20)  NOT NULL COMMENT '订单编号',
  `user_id`      bigint(20)  NOT NULL COMMENT '用户id',
  `store_id`     bigint(20)  NOT NULL COMMENT '店铺表',
  `order_time`   datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '下单时间',
  `order_status` tinyint(4) DEFAULT 0 COMMENT '订单状态0代表未完成，1代表完成',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
