/*
 Navicat Premium Data Transfer

 Source Server         : Ubuntu
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 192.168.91.128:3306
 Source Schema         : asphalt

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 13/09/2022 17:26:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ealf
-- ----------------------------
DROP TABLE IF EXISTS `ealf`;
CREATE TABLE `ealf`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `control_indicator` int(11) NULL DEFAULT NULL COMMENT '控制指标[0代表沥青层永久变形和疲劳开裂，1代表无机结合料层永久变形和疲劳开裂，2代表土基顶面压应变]',
  `vehicle_type` int(10) NULL DEFAULT NULL COMMENT '满载水平[0代表非满载车，1代表满载车]',
  `type2` double NULL DEFAULT NULL,
  `type3` double NULL DEFAULT NULL,
  `type4` double NULL DEFAULT NULL,
  `type5` double NULL DEFAULT NULL,
  `type6` double NULL DEFAULT NULL,
  `type7` double NULL DEFAULT NULL,
  `type8` double NULL DEFAULT NULL,
  `type9` double NULL DEFAULT NULL,
  `type10` double NULL DEFAULT NULL,
  `type11` double NULL DEFAULT NULL,
  `pro_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ealf
-- ----------------------------
INSERT INTO `ealf` VALUES (1, 1, 1, 21, 24.3, 3.7, 0, 7.3, 7.5, 17.1, 8.5, 10.6, 0, 1);
INSERT INTO `ealf` VALUES (2, 1, 0, 20, 24.3, 2.3, 0, 7.3, 7.5, 17.1, 8.5, 10.6, 0, 1);
INSERT INTO `ealf` VALUES (3, 2, 1, 22, 24.3, 3.7, 0, 7.3, 7.5, 17.1, 8.5, 10.6, 0, 1);
INSERT INTO `ealf` VALUES (8, 1, 1, 21, 24.3, 3.7, 0, 7.3, 7.5, 17.1, 8.5, 10.6, 0, 1);
INSERT INTO `ealf` VALUES (9, 1, 0, 20, 24.3, 3.7, 0, 7.3, 7.5, 17.1, 8.5, 10.6, 0, 1);
INSERT INTO `ealf` VALUES (10, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2);
INSERT INTO `ealf` VALUES (11, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);

-- ----------------------------
-- Table structure for environment
-- ----------------------------
DROP TABLE IF EXISTS `environment`;
CREATE TABLE `environment`  (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `equivalent_temperature` double NULL DEFAULT NULL,
  `tcf_structural` double NULL DEFAULT NULL,
  `tcf_top` double NULL DEFAULT NULL,
  `freeze_index` double NULL DEFAULT NULL,
  `seasonal_freeze` double NULL DEFAULT NULL,
  `pro_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`eid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of environment
-- ----------------------------
INSERT INTO `environment` VALUES (1, 2.3, 1.3, 1.9, 50, 1, 1);
INSERT INTO `environment` VALUES (2, 24.7, 1.16, 1.34, 48, 2, 2);
INSERT INTO `environment` VALUES (3, 2.3, 2, 19, 50, 23, 1);

-- ----------------------------
-- Table structure for project_info
-- ----------------------------
DROP TABLE IF EXISTS `project_info`;
CREATE TABLE `project_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `project_filename` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目文件名称',
  `highway_level` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公路等级[一级公路、二级公路、三级公路、四级公路、高速公路]',
  `design_life` int(11) NULL DEFAULT NULL COMMENT '设计使用年限',
  `province` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在省份',
  `design_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公路路面设计类型[新建公路路面设计、改建设计]',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_info
-- ----------------------------
INSERT INTO `project_info` VALUES (1, '江苏省1号沥青路面', '沥青路面信息文件1', '二级公路', 20, '江苏省', '新建公路路面设计', '江苏省1号沥青路面的基本项目信息', '2022-08-18 15:14:12', '2022-09-13 16:39:55');
INSERT INTO `project_info` VALUES (2, '江苏省2号沥青路面', '沥青路面信息文件2', '一级公路', 15, '江苏省', '改建设计', '描述2222222', '2022-08-31 10:17:15', '2022-09-13 10:12:11');
INSERT INTO `project_info` VALUES (13, '江苏省3号沥青路面', '沥青路面信息文件3', '高速公路', 30, '江苏省', '新建公路路面设计', '描述3333333', '2022-09-02 19:45:18', '2022-09-05 09:45:44');

-- ----------------------------
-- Table structure for structural
-- ----------------------------
DROP TABLE IF EXISTS `structural`;
CREATE TABLE `structural`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `horizon` int(10) NULL DEFAULT NULL COMMENT '层位[0代表面层，1代表基层，2代表底基层，3代表路基]',
  `material_type` int(11) NULL DEFAULT NULL COMMENT '材料类型[0代表沥青结合料材料，1代表无机结合料材料,2代表粒料材料]',
  `material_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '材料名称',
  `thickness` int(11) NULL DEFAULT NULL COMMENT '厚度（mm）',
  `poisson_ratio` double NULL DEFAULT NULL COMMENT '泊松比',
  `modulus` int(11) NULL DEFAULT NULL COMMENT '模量（Mpa）',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '说明',
  `adjustment_coefficient` double NULL DEFAULT NULL COMMENT '沥青层疲劳方程调整系数c1，当材料类型为沥青结合料时才设置该参数',
  `asphalt_saturation` double NULL DEFAULT NULL COMMENT '沥青混合料沥青饱和度',
  `bending_tensile_strength` double NULL DEFAULT NULL COMMENT '无机结合料层弯拉强度',
  `pro_id` int(11) NULL DEFAULT NULL COMMENT '项目id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of structural
-- ----------------------------
INSERT INTO `structural` VALUES (1, 0, 0, 'EME', 54, 0.7, 12000, 'EME面层', NULL, NULL, NULL, 1);
INSERT INTO `structural` VALUES (11, 1, 1, 'CC', 60, 0.25, 18000, NULL, NULL, NULL, NULL, 1);
INSERT INTO `structural` VALUES (14, 2, 2, '粒料1', 60, 0.35, 12000, NULL, NULL, NULL, NULL, 1);
INSERT INTO `structural` VALUES (15, 3, 3, NULL, NULL, 0.5, NULL, NULL, NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for structural_material
-- ----------------------------
DROP TABLE IF EXISTS `structural_material`;
CREATE TABLE `structural_material`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `structural_id` int(11) NULL DEFAULT NULL COMMENT 'structural表里的id',
  `type` int(11) NULL DEFAULT NULL COMMENT '材料类型[0代表沥青结合料材料，1代表无机结合料材料,2代表粒料材料]',
  `inorganic_type` int(11) NULL DEFAULT NULL,
  `input_level` int(11) NULL DEFAULT NULL COMMENT '输入水平[0代表水平一，1代表水平二，2代表水平三]，可以分别代表沥青层输入水平和回填模量输入水平',
  `dynamic_compression_modulus` int(11) NULL DEFAULT NULL COMMENT '动态压缩模量，水平一的唯一参数',
  `dynamic_shear_modulus` int(11) NULL DEFAULT NULL COMMENT '沥青动态剪切模量，属于水平二',
  `void_ratio` double NULL DEFAULT NULL COMMENT '空隙率，属于水平二',
  `oil_stone_ratio` double NULL DEFAULT NULL COMMENT '油石比，属于水平二',
  `coarse_aggregate_porosity` double NULL DEFAULT NULL COMMENT '粗集料空隙率，属于水平二',
  `frequency` double NULL DEFAULT NULL COMMENT '频率，属于水平二',
  `dynamic_modulus` double NULL DEFAULT NULL COMMENT '沥青混合料动态模量，属于水平三',
  `test_piece_thickness` double NULL DEFAULT NULL COMMENT '车辙试验试件的厚度，属于永久变形相关参数',
  `permanent_deformation` double NULL DEFAULT NULL COMMENT '车辙试验永久变形量，属于永久变形相关参数',
  `penetration_strength` double NULL DEFAULT NULL COMMENT '沥青混合料的贯入强度，属于永久变形相关参数',
  `structural_elastic_modulus` int(11) NULL DEFAULT NULL COMMENT '结构层弹性模量，属于无机结合料材料参数',
  `granular_elastic_modulus` int(11) NULL DEFAULT NULL COMMENT '粒料材料回弹模量，属于粒料材料参数',
  `humidity_cofficient` double NULL DEFAULT NULL COMMENT '湿度调整系数，属于粒料材料参数',
  `resilient_modulus_level` double NULL DEFAULT NULL COMMENT '回填模量输入水平，属于路基参数',
  `subgrade_resilient_modulus` double NULL DEFAULT NULL COMMENT '土基回弹模量，属于路基参数',
  `cbr` double NULL DEFAULT NULL COMMENT 'CBR，属于路基参数',
  `reduction_coefficient` double NULL DEFAULT NULL COMMENT '干湿与冻融循环作用折减系数，属于路基参数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of structural_material
-- ----------------------------
INSERT INTO `structural_material` VALUES (1, 1, 0, NULL, 0, 12222, 4321, 2.4, 4.5, 66.3, 23, NULL, 54, 3, 0.12, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `structural_material` VALUES (2, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `structural_material` VALUES (10, 15, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, 50, NULL, 1);

-- ----------------------------
-- Table structure for traffic_parameters
-- ----------------------------
DROP TABLE IF EXISTS `traffic_parameters`;
CREATE TABLE `traffic_parameters`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aadtt` int(11) NULL DEFAULT NULL,
  `growth_rate` double NULL DEFAULT NULL,
  `direction_coefficient` double NULL DEFAULT NULL,
  `lane_coefficient` double NULL DEFAULT NULL,
  `pro_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of traffic_parameters
-- ----------------------------
INSERT INTO `traffic_parameters` VALUES (1, 1849, 8, 55, 70, 1);

-- ----------------------------
-- Table structure for vehicle_proportion
-- ----------------------------
DROP TABLE IF EXISTS `vehicle_proportion`;
CREATE TABLE `vehicle_proportion`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_type` int(11) NULL DEFAULT NULL COMMENT '满载水平[0代表非满载车，1代表满载车]',
  `type2` double NULL DEFAULT NULL,
  `type3` double NULL DEFAULT NULL,
  `type4` double NULL DEFAULT NULL,
  `type5` double NULL DEFAULT NULL,
  `type6` double NULL DEFAULT NULL,
  `type7` double NULL DEFAULT NULL,
  `type8` double NULL DEFAULT NULL,
  `type9` double NULL DEFAULT NULL,
  `type10` double NULL DEFAULT NULL,
  `type11` double NULL DEFAULT NULL,
  `pro_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vehicle_proportion
-- ----------------------------
INSERT INTO `vehicle_proportion` VALUES (1, 0, 9.6, 14.3, 1.4, 0, 11.9, 3.1, 16.3, 20.4, 25.2, 0, 1);
INSERT INTO `vehicle_proportion` VALUES (2, 1, 7, 7.7, 4.6, 0, 7.1, 2.7, 5.3, 4.6, 4.6, 0, 1);
INSERT INTO `vehicle_proportion` VALUES (3, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2);
INSERT INTO `vehicle_proportion` VALUES (4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2);

-- ----------------------------
-- Table structure for vehicle_type_distribution_coefficient
-- ----------------------------
DROP TABLE IF EXISTS `vehicle_type_distribution_coefficient`;
CREATE TABLE `vehicle_type_distribution_coefficient`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) NULL DEFAULT NULL COMMENT '水平[0代表水平一/二，1代表水平三]',
  `ttc` int(11) NULL DEFAULT NULL COMMENT '[1代表TTC1，2代表TTC2,3代表TTC3，4代表TTC4,5代表TTC5]',
  `type2` double NULL DEFAULT NULL,
  `type3` double NULL DEFAULT NULL,
  `type4` double NULL DEFAULT NULL,
  `type5` double NULL DEFAULT NULL,
  `type6` double NULL DEFAULT NULL,
  `type7` double NULL DEFAULT NULL,
  `type8` double NULL DEFAULT NULL,
  `type9` double NULL DEFAULT NULL,
  `type10` double NULL DEFAULT NULL,
  `type11` double NULL DEFAULT NULL,
  `pro_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vehicle_type_distribution_coefficient
-- ----------------------------
INSERT INTO `vehicle_type_distribution_coefficient` VALUES (1, 0, 0, 28.9, 43.9, 5.5, 0, 9.4, 2, 4.6, 3.4, 2.3, 0.1, 1);
INSERT INTO `vehicle_type_distribution_coefficient` VALUES (4, 1, 1, 2.4, 13.4, 1.8, 4, 10.4, 4, 15.7, 12.9, 23.7, 0, 1);
INSERT INTO `vehicle_type_distribution_coefficient` VALUES (5, 1, 2, 5.65, 16.9, 1.5, 3.2, 12.8, 3.4, 12.8, 32.6, 23.4, 0, 1);
INSERT INTO `vehicle_type_distribution_coefficient` VALUES (6, 1, 3, 7.34, 15.3, 1.6, 2.1, 3.5, 2.7, 16.3, 20.4, 23.5, 0, 1);
INSERT INTO `vehicle_type_distribution_coefficient` VALUES (7, 1, 4, 321, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2);

SET FOREIGN_KEY_CHECKS = 1;
