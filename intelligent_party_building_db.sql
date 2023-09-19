/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : localhost:3306
 Source Schema         : intelligent_party_building_db

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 15/09/2023 12:03:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for managed_class_map
-- ----------------------------
DROP TABLE IF EXISTS `managed_class_map`;
CREATE TABLE `managed_class_map`  (
  `class_ID` int(0) UNSIGNED NOT NULL,
  `ID` int(0) UNSIGNED NOT NULL,
  PRIMARY KEY (`class_ID`) USING BTREE,
  INDEX `manager_ID`(`ID`) USING BTREE,
  CONSTRAINT `managed_class_map_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `power_user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for party_membership_application_approved
-- ----------------------------
DROP TABLE IF EXISTS `party_membership_application_approved`;
CREATE TABLE `party_membership_application_approved`  (
  `ID` int(0) UNSIGNED NOT NULL,
  `section` enum('共青团员','入党启蒙','入党积极分子','发展对象','预备党员','正式党员') CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '共青团员',
  `node` bit(4) NOT NULL DEFAULT b'0',
  `submit_date_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `approver_ID` int(0) UNSIGNED NULL DEFAULT NULL,
  `form` json NOT NULL,
  PRIMARY KEY (`ID`, `section`, `node`) USING BTREE,
  INDEX `approver_ID`(`approver_ID`) USING BTREE,
  INDEX `ID`(`ID`) USING BTREE,
  CONSTRAINT `party_membership_application_approved_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `student_user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `party_membership_application_approved_ibfk_2` FOREIGN KEY (`approver_ID`) REFERENCES `power_user` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for party_membership_application_rejected
-- ----------------------------
DROP TABLE IF EXISTS `party_membership_application_rejected`;
CREATE TABLE `party_membership_application_rejected`  (
  `submit_date_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `ID` int(0) UNSIGNED NOT NULL,
  `section` enum('共青团员','入党启蒙','入党积极分子','发展对象','预备党员','正式党员') CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '共青团员',
  `node` bit(4) NOT NULL DEFAULT b'0',
  `approver_ID` int(0) UNSIGNED NULL DEFAULT NULL,
  `form` json NOT NULL,
  PRIMARY KEY (`submit_date_time`, `ID`, `section`, `node`) USING BTREE,
  INDEX `approver_ID`(`approver_ID`) USING BTREE,
  INDEX `ID`(`ID`) USING BTREE,
  CONSTRAINT `party_membership_application_rejected_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `student_user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `party_membership_application_rejected_ibfk_2` FOREIGN KEY (`approver_ID`) REFERENCES `power_user` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for party_membership_application_submitted
-- ----------------------------
DROP TABLE IF EXISTS `party_membership_application_submitted`;
CREATE TABLE `party_membership_application_submitted`  (
  `ID` int(0) UNSIGNED NOT NULL,
  `section` enum('共青团员','入党启蒙','入党积极分子','发展对象','预备党员','正式党员') CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '共青团员',
  `node` bit(4) NOT NULL DEFAULT b'0',
  `submit_date_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `approver_ID` int(0) UNSIGNED NULL DEFAULT NULL,
  `form` json NOT NULL,
  PRIMARY KEY (`ID`, `section`, `node`) USING BTREE,
  INDEX `approver_ID`(`approver_ID`) USING BTREE,
  INDEX `ID`(`ID`) USING BTREE,
  CONSTRAINT `party_membership_application_submitted_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `student_user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `party_membership_application_submitted_ibfk_2` FOREIGN KEY (`approver_ID`) REFERENCES `power_user` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for power_user
-- ----------------------------
DROP TABLE IF EXISTS `power_user`;
CREATE TABLE `power_user`  (
  `ID` int(0) UNSIGNED NOT NULL,
  `privilege_level` enum('operator','administrator') CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL DEFAULT 'operator',
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gender` enum('无','女','男','密') CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '无',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  CONSTRAINT `power_user_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `user_account_authentication` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student_achievement
-- ----------------------------
DROP TABLE IF EXISTS `student_achievement`;
CREATE TABLE `student_achievement`  (
  `ID` int(0) UNSIGNED NOT NULL,
  `comprehensive_Evaluation_Ranking` double UNSIGNED NOT NULL DEFAULT 1,
  `CET_Score` smallint(0) UNSIGNED NOT NULL DEFAULT 0,
  `CRE_Grade` char(4) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '无',
  `personal_comprehensive_quality_assessment_schedule` json NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  CONSTRAINT `student_achievement_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `student_user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student_user
-- ----------------------------
DROP TABLE IF EXISTS `student_user`;
CREATE TABLE `student_user`  (
  `ID` int(0) UNSIGNED NOT NULL,
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `class_belongs` int(0) UNSIGNED NOT NULL,
  `gender` enum('无','女','男','密') CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '无',
  `start_year` year NOT NULL DEFAULT 2018 COMMENT '学生入学年份',
  `	
political_outlook` enum('中共党员','中共预备党员','共青团员','民革党员','民盟盟员','民建会员','民进会员','农工党党员','致公党党员','九三学社社员','台盟盟员','无党派人士','普通居民') CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '普通居民',
  `email` varchar(32) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  `birthdate` date NOT NULL DEFAULT '2001-01-01',
  `zip_code` mediumint(6) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `class_belongs`(`class_belongs`) USING BTREE,
  CONSTRAINT `student_user_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `user_account_authentication` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_user_ibfk_2` FOREIGN KEY (`class_belongs`) REFERENCES `managed_class_map` (`class_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_account_authentication
-- ----------------------------
DROP TABLE IF EXISTS `user_account_authentication`;
CREATE TABLE `user_account_authentication`  (
  `ID` int(0) UNSIGNED NOT NULL,
  `role_type` enum('student','operator','administrator') CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL DEFAULT 'student',
  `password` binary(32) NOT NULL,
  PRIMARY KEY (`ID`, `role_type`) USING BTREE,
  INDEX `login_form`(`ID`, `password`) USING BTREE,
  INDEX `ID`(`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_file
-- ----------------------------
DROP TABLE IF EXISTS `user_file`;
CREATE TABLE `user_file`  (
  `owner_ID` int(0) UNSIGNED NOT NULL,
  `upload_date_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `file_sign` varchar(16) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL DEFAULT '',
  `MIME_type` varchar(16) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL,
  `file_suffix` varchar(8) CHARACTER SET ascii COLLATE ascii_general_ci NOT NULL DEFAULT '',
  `file_content` mediumblob NOT NULL,
  PRIMARY KEY (`owner_ID`, `upload_date_time`, `file_sign`) USING BTREE,
  INDEX `MIME_type`(`MIME_type`) USING BTREE,
  CONSTRAINT `user_file_ibfk_1` FOREIGN KEY (`owner_ID`) REFERENCES `student_user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- View structure for power_user_info
-- ----------------------------
DROP VIEW IF EXISTS `power_user_info`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `power_user_info` AS select `power_user`.`ID` AS `ID`,`power_user`.`privilege_level` AS `privilege_level`,`power_user`.`name` AS `name`,`power_user`.`gender` AS `gender`,`managed_class_map`.`managed_Class` AS `managed_Class` from (`power_user` left join `managed_class_map` on((`power_user`.`ID` = `managed_class_map`.`ID`)));

-- ----------------------------
-- Function structure for getAge
-- ----------------------------
DROP FUNCTION IF EXISTS `getAge`;
delimiter ;;
CREATE FUNCTION `getAge`(birthdate datetime)
 RETURNS tinyint unsigned
BEGIN
	#Routine body goes here...

	RETURN TIMESTAMPDIFF(YEAR, birthday, CURDATE());
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table party_membership_application_approved
-- ----------------------------
DROP TRIGGER IF EXISTS `withdrawal_of_approval`;
delimiter ;;
CREATE TRIGGER `withdrawal_of_approval` AFTER DELETE ON `party_membership_application_approved` FOR EACH ROW INSERT INTO party_membership_application_rejected VALUES (NEW)
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table party_membership_application_approved
-- ----------------------------
DROP TRIGGER IF EXISTS `approve_application`;
delimiter ;;
CREATE TRIGGER `approve_application` BEFORE INSERT ON `party_membership_application_approved` FOR EACH ROW DELETE FROM party_membership_application_submitted AS Submit WHERE NEW.ID = Submit.ID AND NEW.section = Submit.section AND NEW.node = Submit.node LIMIT 1
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table party_membership_application_rejected
-- ----------------------------
DROP TRIGGER IF EXISTS `reject_application`;
delimiter ;;
CREATE TRIGGER `reject_application` BEFORE INSERT ON `party_membership_application_rejected` FOR EACH ROW DELETE FROM `party_membership_application_submitted` AS `Submit` WHERE NEW.ID = `Submit`.ID AND NEW.section = `Submit`.section AND NEW.node = `Submit`.node
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
