/*
 Navicat Premium Dump SQL

 Source Server         : MySQL 8.4.3 LTS
 Source Server Type    : MySQL
 Source Server Version : 80403 (8.4.3)
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80403 (8.4.3)
 File Encoding         : 65001

 Date: 03/02/2025 15:10:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for announcements
-- ----------------------------
DROP TABLE IF EXISTS `announcements`;
CREATE TABLE `announcements`  (
  `announcement_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `publish_time` datetime NULL DEFAULT NULL,
  `employee_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`announcement_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of announcements
-- ----------------------------
INSERT INTO `announcements` VALUES (1, '关于期末考试的通知', '期末考试将在第十六周进行...', '2025-01-16 22:36:19', 1001);
INSERT INTO `announcements` VALUES (2, '国庆节放假安排', '国庆节放假时间为10月1日至7日...', '2025-01-16 22:36:19', 1002);

-- ----------------------------
-- Table structure for dormitory_admins
-- ----------------------------
DROP TABLE IF EXISTS `dormitory_admins`;
CREATE TABLE `dormitory_admins`  (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dormitory_building` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `floors` int NULL DEFAULT NULL,
  `contact_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dormitory_admins
-- ----------------------------
INSERT INTO `dormitory_admins` VALUES (1001, '王老师', '东区一号楼', 4, '123-456-7890');
INSERT INTO `dormitory_admins` VALUES (1002, '赵老师', '西区二号楼', 5, '098-765-4321');

-- ----------------------------
-- Table structure for equipment_maintenance
-- ----------------------------
DROP TABLE IF EXISTS `equipment_maintenance`;
CREATE TABLE `equipment_maintenance`  (
  `maintenance_id` int NOT NULL AUTO_INCREMENT,
  `dormitory_building` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `contact_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`maintenance_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of equipment_maintenance
-- ----------------------------
INSERT INTO `equipment_maintenance` VALUES (1, '东区一号楼', '张老师', '123-456-789');
INSERT INTO `equipment_maintenance` VALUES (2, '西区二号楼', '王老师', '987-654-321');

-- ----------------------------
-- Table structure for sanitation_scores
-- ----------------------------
DROP TABLE IF EXISTS `sanitation_scores`;
CREATE TABLE `sanitation_scores`  (
  `sanitation_scores_id` int NOT NULL AUTO_INCREMENT,
  `employee_id` int NULL DEFAULT NULL,
  `dormitory_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `publish_time` datetime NULL DEFAULT NULL,
  `score` int NULL DEFAULT NULL,
  PRIMARY KEY (`sanitation_scores_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sanitation_scores
-- ----------------------------
INSERT INTO `sanitation_scores` VALUES (1, 1001, 'A302', '2025-01-16 22:36:19', 90);
INSERT INTO `sanitation_scores` VALUES (2, 1002, 'B405', '2025-01-16 22:36:19', 85);

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`  (
  `studentID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dormitory` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dormitory_building` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `enrollment_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`studentID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES (1, '张三', '计算机科学', 'A302', '东区一号楼', '男', '2019-09-01 00:00:00');
INSERT INTO `students` VALUES (2, '李四', '软件工程', 'B405', '西区二号楼', '女', '2020-09-01 00:00:00');

-- ----------------------------
-- Table structure for system_admin
-- ----------------------------
DROP TABLE IF EXISTS `system_admin`;
CREATE TABLE `system_admin`  (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `employee_id` int NULL DEFAULT NULL,
  `contact_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_admin
-- ----------------------------
INSERT INTO `system_admin` VALUES (1, '孙管理员', 1001, 'admin1@example.com');
INSERT INTO `system_admin` VALUES (2, '周管理员', 1002, 'admin2@example.com');

-- ----------------------------
-- Table structure for violation_records
-- ----------------------------
DROP TABLE IF EXISTS `violation_records`;
CREATE TABLE `violation_records`  (
  `violation_record_id` int NOT NULL AUTO_INCREMENT,
  `employee_id` int NULL DEFAULT NULL,
  `dormitory_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `violation_time` datetime NULL DEFAULT NULL,
  `violation_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`violation_record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of violation_records
-- ----------------------------
INSERT INTO `violation_records` VALUES (1, 1001, 'A302', '2025-01-16 22:36:19', '未按时熄灯');
INSERT INTO `violation_records` VALUES (2, 1002, 'B405', '2025-01-16 22:36:19', '乱丢垃圾');

SET FOREIGN_KEY_CHECKS = 1;
