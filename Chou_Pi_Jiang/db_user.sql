/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : db_user

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 09/02/2021 23:16:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for alldepartment
-- ----------------------------
DROP TABLE IF EXISTS `alldepartment`;
CREATE TABLE `alldepartment`  (
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `operator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作者'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of alldepartment
-- ----------------------------
INSERT INTO `alldepartment` VALUES ('人力资源部', '1195830101');
INSERT INTO `alldepartment` VALUES ('人事部', '1195830101');
INSERT INTO `alldepartment` VALUES ('工程部', '1195830101');
INSERT INTO `alldepartment` VALUES ('销售部', '1195830102');
INSERT INTO `alldepartment` VALUES ('财务部', '1195830101');
INSERT INTO `alldepartment` VALUES ('分部', '11958301');

-- ----------------------------
-- Table structure for emp_attendance
-- ----------------------------
DROP TABLE IF EXISTS `emp_attendance`;
CREATE TABLE `emp_attendance`  (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名（工号）',
  `leave_days` float(11, 2) NOT NULL COMMENT '请假天数',
  `late_days` int(11) NOT NULL COMMENT '迟到天数',
  `absenteeism_days` int(11) NOT NULL COMMENT '旷工天数',
  `overtime_hours` float(11, 2) NOT NULL COMMENT '加班时长',
  INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp_attendance
-- ----------------------------
INSERT INTO `emp_attendance` VALUES ('1195830101', 1.00, 0, 0, 15.00);
INSERT INTO `emp_attendance` VALUES ('1195830102', 1.50, 2, 1, 18.50);
INSERT INTO `emp_attendance` VALUES ('1195830103', 2.50, 2, 1, 18.00);
INSERT INTO `emp_attendance` VALUES ('1195830104', 3.50, 3, 2, 24.00);
INSERT INTO `emp_attendance` VALUES ('1195830105', 4.50, 4, 1, 12.00);
INSERT INTO `emp_attendance` VALUES ('1195830106', 5.50, 5, 2, 16.50);
INSERT INTO `emp_attendance` VALUES ('1195830107', 0.00, 0, 0, 10.00);
INSERT INTO `emp_attendance` VALUES ('1195830108', 0.00, 0, 0, 15.00);
INSERT INTO `emp_attendance` VALUES ('1195830109', 0.00, 0, 0, 16.00);
INSERT INTO `emp_attendance` VALUES ('1195830110', 0.00, 1, 2, 3.00);

-- ----------------------------
-- Table structure for emp_information
-- ----------------------------
DROP TABLE IF EXISTS `emp_information`;
CREATE TABLE `emp_information`  (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名（工号）',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `age` int(11) NOT NULL COMMENT '年龄',
  `department` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属部门',
  `position` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职位',
  `contact` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
  `permission` int(11) NOT NULL COMMENT '权限'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp_information
-- ----------------------------
INSERT INTO `emp_information` VALUES ('11958301', '123456', '张三', '男', 29, '总部', '管理员', '12345678910', 1);
INSERT INTO `emp_information` VALUES ('1195830102', '222222', '李四', '男', 20, '财务部', '普通职工', '22222222222', 0);
INSERT INTO `emp_information` VALUES ('1195830103', '333333', '王五', '女', 16, '人力资源部', '普通职工', '3333333333', 1);
INSERT INTO `emp_information` VALUES ('1195830104', '444444', '赵六', '女', 17, '财务部', '普通职工', '4444444444', 0);
INSERT INTO `emp_information` VALUES ('1195830105', '555555', '孙七', '男', 30, '人事部', '经理', '55555555555', 0);
INSERT INTO `emp_information` VALUES ('1195830106', '666666', '周八', '女', 26, '人事部', '普通职工', '66666666666', -1);
INSERT INTO `emp_information` VALUES ('1195830101', '111111', '六六', '男', 22, '财务部', '普通员工', '1111111111', 0);
INSERT INTO `emp_information` VALUES ('1195830107', '777777', '七七', '男', 22, '财务部', '普通员工', '77777777777', 0);
INSERT INTO `emp_information` VALUES ('1195830108', '888888', '八八', '男', 22, '人力资源', '经理', '88888888888', 1);
INSERT INTO `emp_information` VALUES ('1195830109', '999999', '九九', '男', 22, '财务部', '普通员工', '99999999999', 0);
INSERT INTO `emp_information` VALUES ('1195830110', '101010', '十十', '男', 22, '人事部', '普通员工', '99999999999', 0);

-- ----------------------------
-- Table structure for emp_salary
-- ----------------------------
DROP TABLE IF EXISTS `emp_salary`;
CREATE TABLE `emp_salary`  (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名（工号）',
  `basic` float(11, 2) NOT NULL COMMENT '基础工资',
  `overtime` float(11, 2) NOT NULL COMMENT '加班工资',
  `commission` float(11, 2) NOT NULL COMMENT '提成',
  `bonus` float(11, 2) NOT NULL COMMENT '奖金',
  `vacate` float(11, 2) NOT NULL COMMENT '请假扣薪',
  `late` float(11, 2) NOT NULL COMMENT '迟到扣薪',
  `absenteeism` float(11, 2) NOT NULL COMMENT '旷工扣薪',
  `actual` float(11, 2) NOT NULL COMMENT '实发工资',
  `confirm` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '确认信息',
  INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp_salary
-- ----------------------------
INSERT INTO `emp_salary` VALUES ('1195830101', 8000.00, 100.00, 500.00, 200.00, -50.00, -50.00, -100.00, 8600.00, '审核通过');
INSERT INTO `emp_salary` VALUES ('1195830102', 6000.00, 100.00, 500.00, 200.00, -50.00, -50.00, -100.00, 6600.00, '审核通过');
INSERT INTO `emp_salary` VALUES ('1195830103', 5000.00, 100.00, 500.00, 200.00, -50.00, -50.00, -100.00, 5600.00, '审核通过');
INSERT INTO `emp_salary` VALUES ('1195830104', 4000.00, 100.00, 500.00, 200.00, -50.00, -50.00, -100.00, 4600.00, '审核不通过');
INSERT INTO `emp_salary` VALUES ('1195830105', 3000.00, 100.00, 500.00, 200.00, -50.00, -50.00, -100.00, 3600.00, '审核通过');
INSERT INTO `emp_salary` VALUES ('1195830106', 2000.00, 100.00, 500.00, 200.00, -50.00, -50.00, -100.00, 2600.00, '未确认');
INSERT INTO `emp_salary` VALUES ('1195830107', 123456.00, 123.00, 12.00, 0.00, 0.00, 0.00, 0.00, 123591.00, '未确认');
INSERT INTO `emp_salary` VALUES ('1195830109', 12356.00, 2323.00, 2323.00, 0.00, 0.00, 0.00, 0.00, 17002.00, '未确认');
INSERT INTO `emp_salary` VALUES ('1195830108', 1321.00, 123.00, 0.00, 0.00, 0.00, 0.00, 0.00, 1444.00, '未确认');
INSERT INTO `emp_salary` VALUES ('1195830110', 21132.00, 123.00, 0.00, 0.00, 0.00, 0.00, 0.00, 21255.00, '审核不通过');

SET FOREIGN_KEY_CHECKS = 1;
