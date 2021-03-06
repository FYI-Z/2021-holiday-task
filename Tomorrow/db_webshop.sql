/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.40.130
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : 192.168.40.130:3306
 Source Schema         : db_webshop

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 06/03/2021 22:14:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `addressid` int(11) NOT NULL AUTO_INCREMENT COMMENT '收货地址id',
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人姓名',
  `phone` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人手机号',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  PRIMARY KEY (`addressid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, '00000001', '昵称1', '00000000001', '收货地址1');
INSERT INTO `address` VALUES (2, '00000001', '昵称1', '00000000001', '收货地址1');
INSERT INTO `address` VALUES (3, '00000002', '昵称2', '00000000002', '收货地址2');
INSERT INTO `address` VALUES (4, '00000003', '昵称3', '00000000003', '收货地址3');
INSERT INTO `address` VALUES (5, '00000004', '昵称4', '00000000004', '收货地址4');
INSERT INTO `address` VALUES (6, '00000005', '昵称5', '00000000005', '收货地址5');
INSERT INTO `address` VALUES (7, '00000006', '昵称6', '00000000006', '收货地址6');
INSERT INTO `address` VALUES (8, '00000007', '昵称7', '00000000007', '收货地址7');
INSERT INTO `address` VALUES (9, '00000008', '昵称8', '00000000008', '收货地址8');
INSERT INTO `address` VALUES (10, '00000009', '昵称9', '00000000009', '收货地址9');
INSERT INTO `address` VALUES (11, '00000010', '昵称10', '00000000010', '收货地址10');
INSERT INTO `address` VALUES (12, '00000011', '昵称11', '00000000011', '收货地址11');
INSERT INTO `address` VALUES (13, '00000012', '昵称12', '00000000012', '收货地址12');
INSERT INTO `address` VALUES (14, '00000013', '昵称13', '00000000013', '收货地址13');
INSERT INTO `address` VALUES (15, '00000014', '昵称14', '00000000014', '收货地址14');
INSERT INTO `address` VALUES (16, '00000015', '昵称15', '00000000015', '收货地址15');
INSERT INTO `address` VALUES (17, '00000016', '昵称16', '00000000016', '收货地址16');
INSERT INTO `address` VALUES (18, '00000017', '昵称17', '00000000017', '收货地址17');
INSERT INTO `address` VALUES (19, '00000018', '昵称18', '00000000018', '收货地址18');
INSERT INTO `address` VALUES (20, '00000019', '昵称19', '00000000019', '收货地址19');
INSERT INTO `address` VALUES (21, '00000020', '昵称20', '00000000020', '收货地址20');
INSERT INTO `address` VALUES (22, '00000001', '昵称1', '00000000001', '收货地址21');
INSERT INTO `address` VALUES (23, '00000002', '昵称2', '00000000002', '收货地址22');
INSERT INTO `address` VALUES (24, '00000003', '昵称3', '00000000003', '收货地址23');
INSERT INTO `address` VALUES (25, '00000004', '昵称4', '00000000004', '收货地址24');
INSERT INTO `address` VALUES (26, '00000005', '昵称5', '00000000005', '收货地址25');
INSERT INTO `address` VALUES (27, '00000006', '昵称6', '00000000006', '收货地址26');
INSERT INTO `address` VALUES (28, '00000007', '昵称7', '00000000007', '收货地址27');
INSERT INTO `address` VALUES (29, '00000008', '昵称8', '00000000008', '收货地址28');
INSERT INTO `address` VALUES (30, '00000009', '昵称9', '00000000009', '收货地址29');
INSERT INTO `address` VALUES (31, '00000010', '昵称10', '00000000010', '收货地址30');
INSERT INTO `address` VALUES (32, '00000011', '昵称11', '00000000011', '收货地址31');
INSERT INTO `address` VALUES (33, '00000012', '昵称12', '00000000012', '收货地址32');
INSERT INTO `address` VALUES (34, '00000013', '昵称13', '00000000013', '收货地址33');
INSERT INTO `address` VALUES (35, '00000014', '昵称14', '00000000014', '收货地址34');
INSERT INTO `address` VALUES (36, '00000015', '昵称15', '00000000015', '收货地址35');
INSERT INTO `address` VALUES (37, '00000016', '昵称16', '00000000016', '收货地址36');
INSERT INTO `address` VALUES (38, '00000017', '昵称17', '00000000017', '收货地址37');
INSERT INTO `address` VALUES (39, '00000018', '昵称18', '00000000018', '收货地址38');
INSERT INTO `address` VALUES (40, '00000019', '昵称19', '00000000019', '收货地址39');
INSERT INTO `address` VALUES (41, '00000020', '昵称20', '00000000020', '收货地址40');
INSERT INTO `address` VALUES (42, '00000001', '昵称1', '00000000001', '收货地址41');
INSERT INTO `address` VALUES (43, '00000002', '昵称2', '00000000002', '收货地址42');
INSERT INTO `address` VALUES (44, '00000003', '昵称3', '00000000003', '收货地址43');
INSERT INTO `address` VALUES (45, '00000004', '昵称4', '00000000004', '收货地址44');
INSERT INTO `address` VALUES (46, '00000005', '昵称5', '00000000005', '收货地址45');
INSERT INTO `address` VALUES (47, '00000006', '昵称6', '00000000006', '收货地址46');
INSERT INTO `address` VALUES (48, '00000007', '昵称7', '00000000007', '收货地址47');
INSERT INTO `address` VALUES (49, '00000008', '昵称8', '00000000008', '收货地址48');
INSERT INTO `address` VALUES (50, '00000009', '昵称9', '00000000009', '收货地址49');
INSERT INTO `address` VALUES (51, '00000010', '昵称10', '00000000010', '收货地址50');
INSERT INTO `address` VALUES (52, '00000011', '昵称11', '00000000011', '收货地址51');
INSERT INTO `address` VALUES (53, '00000012', '昵称12', '00000000012', '收货地址52');
INSERT INTO `address` VALUES (54, '00000013', '昵称13', '00000000013', '收货地址53');
INSERT INTO `address` VALUES (55, '00000014', '昵称14', '00000000014', '收货地址54');
INSERT INTO `address` VALUES (56, '00000015', '昵称15', '00000000015', '收货地址55');
INSERT INTO `address` VALUES (57, '00000016', '昵称16', '00000000016', '收货地址56');
INSERT INTO `address` VALUES (58, '00000017', '昵称17', '00000000017', '收货地址57');
INSERT INTO `address` VALUES (59, '00000018', '昵称18', '00000000018', '收货地址58');
INSERT INTO `address` VALUES (60, '00000019', '昵称19', '00000000019', '收货地址59');
INSERT INTO `address` VALUES (61, '00000020', '昵称20', '00000000020', '收货地址60');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `commentsid` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `goodsid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品id',
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `comments` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`commentsid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 215 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES (1, '1', '00000001', '00001商品的第一条fsfs订单test打算发顺丰', '2021-02-26 17:57:14');
INSERT INTO `comments` VALUES (2, '1', '00000002', '00001商品的第一条评论骨灰盒', '2021-02-26 17:57:14');
INSERT INTO `comments` VALUES (3, '1', '00000003', '00001商品的第一条评论发送到', '2021-02-26 17:57:14');
INSERT INTO `comments` VALUES (4, '2', '00000004', '00002商品的第一条评论44', '2021-02-26 17:57:32');
INSERT INTO `comments` VALUES (5, '2', '00000005', '00002商品的第二条评论', '2021-02-27 17:57:36');
INSERT INTO `comments` VALUES (6, '2', '00000006', '00002商品的第三条评论', '2021-02-25 17:57:41');
INSERT INTO `comments` VALUES (7, '3', '00000001', 'addTest', '2021-02-28 23:45:45');
INSERT INTO `comments` VALUES (8, '4', '00000002', 'add', '2021-02-28 23:56:26');
INSERT INTO `comments` VALUES (9, '3', '0000003', '123456', '2021-03-01 00:01:14');
INSERT INTO `comments` VALUES (11, '1', '00000003', '1213151614', '2021-03-01 00:15:28');
INSERT INTO `comments` VALUES (14, '0', '000006', 'test', '2021-03-01 16:12:15');
INSERT INTO `comments` VALUES (15, '5', '00000001', '评论1', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (16, '6', '00000002', '评论2', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (17, '7', '00000003', '评论3', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (18, '8', '00000004', '评论4', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (19, '9', '00000005', '评论5', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (20, '10', '00000006', '评论6', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (21, '11', '00000007', '评论7', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (22, '12', '00000008', '评论8', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (23, '13', '00000009', '评论9', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (24, '14', '00000010', '评论10', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (25, '15', '00000011', '评论11', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (26, '16', '00000012', '评论12', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (27, '17', '00000013', '评论13', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (28, '18', '00000014', '评论14', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (29, '19', '00000015', '评论15', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (30, '20', '00000016', '评论16', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (31, '21', '00000017', '评论17', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (32, '22', '00000018', '评论18', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (33, '23', '00000019', '评论19', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (34, '24', '00000020', '评论20', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (35, '25', '00000021', '评论21', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (36, '26', '00000022', '评论22', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (37, '27', '00000023', '评论23', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (38, '28', '00000024', '评论24', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (39, '29', '00000025', '评论25', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (40, '30', '00000001', '评论26', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (41, '31', '00000002', '评论27', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (42, '32', '00000003', '评论28', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (43, '33', '00000004', '评论29', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (44, '34', '00000005', '评论30', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (45, '35', '00000006', '评论31', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (46, '36', '00000007', '评论32', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (47, '37', '00000008', '评论33', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (48, '38', '00000009', '评论34', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (49, '39', '00000010', '评论35', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (50, '40', '00000011', '评论36', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (51, '41', '00000012', '评论37', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (52, '42', '00000013', '评论38', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (53, '43', '00000014', '评论39', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (54, '44', '00000015', '评论40', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (55, '45', '00000016', '评论41', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (56, '46', '00000017', '评论42', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (57, '47', '00000018', '评论43', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (58, '48', '00000019', '评论44', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (59, '49', '00000020', '评论45', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (60, '50', '00000021', '评论46', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (61, '51', '00000022', '评论47', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (62, '52', '00000023', '评论48', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (63, '53', '00000024', '评论49', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (64, '54', '00000025', '评论50', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (65, '55', '00000001', '评论51', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (66, '56', '00000002', '评论52', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (67, '57', '00000003', '评论53', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (68, '58', '00000004', '评论54', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (69, '59', '00000005', '评论55', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (70, '60', '00000006', '评论56', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (71, '61', '00000007', '评论57', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (72, '62', '00000008', '评论58', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (73, '63', '00000009', '评论59', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (74, '64', '00000010', '评论60', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (75, '65', '00000011', '评论61', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (76, '66', '00000012', '评论62', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (77, '67', '00000013', '评论63', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (78, '68', '00000014', '评论64', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (79, '69', '00000015', '评论65', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (80, '70', '00000016', '评论66', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (81, '71', '00000017', '评论67', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (82, '72', '00000018', '评论68', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (83, '73', '00000019', '评论69', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (84, '74', '00000020', '评论70', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (85, '75', '00000021', '评论71', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (86, '76', '00000022', '评论72', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (87, '77', '00000023', '评论73', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (88, '78', '00000024', '评论74', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (89, '79', '00000025', '评论75', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (90, '80', '00000001', '评论76', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (91, '81', '00000002', '评论77', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (92, '82', '00000003', '评论78', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (93, '83', '00000004', '评论79', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (94, '84', '00000005', '评论80', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (95, '85', '00000006', '评论81', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (96, '86', '00000007', '评论82', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (97, '87', '00000008', '评论83', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (98, '88', '00000009', '评论84', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (99, '89', '00000010', '评论85', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (100, '90', '00000011', '评论86', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (101, '91', '00000012', '评论87', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (102, '92', '00000013', '评论88', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (103, '93', '00000014', '评论89', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (104, '94', '00000015', '评论90', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (105, '95', '00000016', '评论91', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (106, '96', '00000017', '评论92', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (107, '97', '00000018', '评论93', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (108, '98', '00000019', '评论94', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (109, '99', '00000020', '评论95', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (110, '100', '00000021', '评论96', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (111, '101', '00000022', '评论97', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (112, '102', '00000023', '评论98', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (113, '103', '00000024', '评论99', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (114, '104', '00000025', '评论100', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (115, '105', '00000001', '评论101', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (116, '106', '00000002', '评论102', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (117, '107', '00000003', '评论103', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (118, '108', '00000004', '评论104', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (119, '109', '00000005', '评论105', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (120, '110', '00000006', '评论106', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (121, '111', '00000007', '评论107', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (122, '112', '00000008', '评论108', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (123, '113', '00000009', '评论109', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (124, '114', '00000010', '评论110', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (125, '115', '00000011', '评论111', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (126, '116', '00000012', '评论112', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (127, '117', '00000013', '评论113', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (128, '118', '00000014', '评论114', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (129, '119', '00000015', '评论115', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (130, '120', '00000016', '评论116', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (131, '121', '00000017', '评论117', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (132, '122', '00000018', '评论118', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (133, '123', '00000019', '评论119', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (134, '124', '00000020', '评论120', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (135, '125', '00000021', '评论121', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (136, '126', '00000022', '评论122', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (137, '127', '00000023', '评论123', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (138, '128', '00000024', '评论124', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (139, '129', '00000025', '评论125', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (140, '130', '00000001', '评论126', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (141, '131', '00000002', '评论127', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (142, '132', '00000003', '评论128', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (143, '133', '00000004', '评论129', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (144, '134', '00000005', '评论130', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (145, '135', '00000006', '评论131', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (146, '136', '00000007', '评论132', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (147, '137', '00000008', '评论133', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (148, '138', '00000009', '评论134', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (149, '139', '00000010', '评论135', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (150, '140', '00000011', '评论136', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (151, '141', '00000012', '评论137', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (152, '142', '00000013', '评论138', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (153, '143', '00000014', '评论139', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (154, '144', '00000015', '评论140', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (155, '145', '00000016', '评论141', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (156, '146', '00000017', '评论142', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (157, '147', '00000018', '评论143', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (158, '148', '00000019', '评论144', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (159, '149', '00000020', '评论145', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (160, '150', '00000021', '评论146', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (161, '151', '00000022', '评论147', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (162, '152', '00000023', '评论148', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (163, '153', '00000024', '评论149', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (164, '154', '00000025', '评论150', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (165, '155', '00000001', '评论151', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (166, '156', '00000002', '评论152', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (167, '157', '00000003', '评论153', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (168, '158', '00000004', '评论154', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (169, '159', '00000005', '评论155', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (170, '160', '00000006', '评论156', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (171, '161', '00000007', '评论157', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (172, '162', '00000008', '评论158', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (173, '163', '00000009', '评论159', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (174, '164', '00000010', '评论160', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (175, '165', '00000011', '评论161', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (176, '166', '00000012', '评论162', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (177, '167', '00000013', '评论163', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (178, '168', '00000014', '评论164', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (179, '169', '00000015', '评论165', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (180, '170', '00000016', '评论166', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (181, '171', '00000017', '评论167', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (182, '172', '00000018', '评论168', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (183, '173', '00000019', '评论169', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (184, '174', '00000020', '评论170', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (185, '175', '00000021', '评论171', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (186, '176', '00000022', '评论172', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (187, '177', '00000023', '评论173', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (188, '178', '00000024', '评论174', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (189, '179', '00000025', '评论175', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (190, '180', '00000001', '评论176', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (191, '181', '00000002', '评论177', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (192, '182', '00000003', '评论178', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (193, '183', '00000004', '评论179', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (194, '184', '00000005', '评论180', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (195, '185', '00000006', '评论181', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (196, '186', '00000007', '评论182', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (197, '187', '00000008', '评论183', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (198, '188', '00000009', '评论184', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (199, '189', '00000010', '评论185', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (200, '190', '00000011', '评论186', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (201, '191', '00000012', '评论187', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (202, '192', '00000013', '评论188', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (203, '193', '00000014', '评论189', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (204, '194', '00000015', '评论190', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (205, '195', '00000016', '评论191', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (206, '196', '00000017', '评论192', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (207, '197', '00000018', '评论193', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (208, '198', '00000019', '评论194', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (209, '199', '00000020', '评论195', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (210, '200', '00000021', '评论196', '2021-03-05 17:25:38');
INSERT INTO `comments` VALUES (211, NULL, '', NULL, NULL);
INSERT INTO `comments` VALUES (212, NULL, '', NULL, NULL);
INSERT INTO `comments` VALUES (213, NULL, '', NULL, NULL);
INSERT INTO `comments` VALUES (214, NULL, '', NULL, NULL);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goodsid` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `price` double(15, 2) NULL DEFAULT NULL COMMENT '商品单价',
  `instructions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品说明',
  `picture` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品图片',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品类型',
  `inventory` int(11) NULL DEFAULT NULL COMMENT '商品库存',
  `sales` int(11) NULL DEFAULT NULL COMMENT '商品销量',
  `brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品品牌',
  PRIMARY KEY (`goodsid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '第1个商品名称', 1.10, '第1个商品', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=680917063,679781129&fm=26&gp=0.jpg', '手机/数码', 1, 11, '品牌1');
INSERT INTO `goods` VALUES (2, '第2个商品名称', 2.20, '第2个商品', '', '手机/数码', 2, 22, '品牌2');
INSERT INTO `goods` VALUES (3, '第3个商品名称', 3.30, '第3个商品', '', '电脑/办公', 3, 33, '品牌3');
INSERT INTO `goods` VALUES (4, '第4个商品名称', 4.40, '第4个商品', '', '食品/蔬菜', 4, 44, '品牌4');
INSERT INTO `goods` VALUES (5, '第5个商品名称', 5.50, '第5个商品', '', '医疗/保健', 5, 55, '品牌5');
INSERT INTO `goods` VALUES (6, '第6个商品名称', 6.60, '第6个商品', '', '零食/美酒', 6, 66, '品牌6');
INSERT INTO `goods` VALUES (7, '第7个商品名称', 7.70, '第7个商品', '', '美妆/护肤', 7, 77, '品牌7');
INSERT INTO `goods` VALUES (8, '第8个商品名称', 8.80, '第8个商品', '', '户外/运动', 8, 88, '品牌8');
INSERT INTO `goods` VALUES (9, '第9个商品名称', 9.90, '第9个商品', '', '手机/数码', 9, 99, '品牌9');
INSERT INTO `goods` VALUES (10, '第10个商品名称', 10.10, '第10个商品', '', '手机/数码', 10, 1010, '品牌10');
INSERT INTO `goods` VALUES (11, '第11个商品名称', 11.11, '第11个商品', NULL, '手机/数码', 11, 100, '品牌11');
INSERT INTO `goods` VALUES (12, '第12个商品名称', 12.12, '第12个商品', NULL, '电脑/办公', 12, 200, '品牌12');
INSERT INTO `goods` VALUES (13, '第13个商品名称', 13.13, '第13个商品', NULL, '食品/蔬菜', 13, 300, '品牌13');
INSERT INTO `goods` VALUES (14, '第14个商品名称', 14.14, '第14个商品', NULL, '医疗/保健', 14, 400, '品牌14');
INSERT INTO `goods` VALUES (15, '第15个商品名称', 15.15, '第15个商品', NULL, '零食/美酒', 15, 500, '品牌15');
INSERT INTO `goods` VALUES (16, '第16个商品名称', 16.16, '第16个商品', NULL, '美妆/护肤', 16, 600, '品牌16');
INSERT INTO `goods` VALUES (17, '第17个商品名称', 17.17, '第17个商品', NULL, '户外/运动', 17, 700, '品牌17');
INSERT INTO `goods` VALUES (18, '第18个商品名称', 18.18, '第18个商品', NULL, '手机/数码', 18, 800, '品牌18');
INSERT INTO `goods` VALUES (19, '第19个商品名称', 19.19, '第19个商品', NULL, '电脑/办公', 19, 900, '品牌19');
INSERT INTO `goods` VALUES (20, '第20个商品名称', 20.20, '第20个商品', NULL, '食品/蔬菜', 20, 1000, '品牌20');
INSERT INTO `goods` VALUES (21, '第21个商品名称', 21.21, '第21个商品', NULL, '医疗/保健', 21, 1100, '品牌21');
INSERT INTO `goods` VALUES (22, '第22个商品名称', 22.22, '第22个商品', NULL, '零食/美酒', 22, 1200, '品牌22');
INSERT INTO `goods` VALUES (23, '第23个商品名称', 23.23, '第23个商品', NULL, '美妆/护肤', 23, 1300, '品牌23');
INSERT INTO `goods` VALUES (24, '第24个商品名称', 24.24, '第24个商品', NULL, '户外/运动', 24, 1400, '品牌24');
INSERT INTO `goods` VALUES (25, '第25个商品名称', 25.25, '第25个商品', NULL, '手机/数码', 25, 1500, '品牌25');
INSERT INTO `goods` VALUES (26, '第26个商品名称', 26.26, '第26个商品', NULL, '电脑/办公', 26, 1600, '品牌26');
INSERT INTO `goods` VALUES (27, '第27个商品名称', 27.27, '第27个商品', NULL, '食品/蔬菜', 27, 1700, '品牌27');
INSERT INTO `goods` VALUES (28, '第28个商品名称', 28.28, '第28个商品', NULL, '医疗/保健', 28, 1800, '品牌28');
INSERT INTO `goods` VALUES (29, '第29个商品名称', 29.29, '第29个商品', NULL, '零食/美酒', 29, 1900, '品牌29');
INSERT INTO `goods` VALUES (30, '第30个商品名称', 30.30, '第30个商品', NULL, '美妆/护肤', 30, 2000, '品牌30');
INSERT INTO `goods` VALUES (31, '第31个商品名称', 31.31, '第31个商品', NULL, '户外/运动', 31, 2100, '品牌31');
INSERT INTO `goods` VALUES (32, '第32个商品名称', 32.32, '第32个商品', NULL, '手机/数码', 32, 2200, '品牌32');
INSERT INTO `goods` VALUES (33, '第33个商品名称', 33.33, '第33个商品', NULL, '电脑/办公', 33, 2300, '品牌33');
INSERT INTO `goods` VALUES (34, '第34个商品名称', 34.34, '第34个商品', NULL, '食品/蔬菜', 34, 2400, '品牌34');
INSERT INTO `goods` VALUES (35, '第35个商品名称', 35.35, '第35个商品', NULL, '医疗/保健', 35, 2500, '品牌35');
INSERT INTO `goods` VALUES (36, '第36个商品名称', 36.36, '第36个商品', NULL, '零食/美酒', 36, 2600, '品牌36');
INSERT INTO `goods` VALUES (37, '第37个商品名称', 37.37, '第37个商品', NULL, '美妆/护肤', 37, 2700, '品牌37');
INSERT INTO `goods` VALUES (38, '第38个商品名称', 38.38, '第38个商品', NULL, '户外/运动', 38, 2800, '品牌38');
INSERT INTO `goods` VALUES (39, '第39个商品名称', 39.39, '第39个商品', NULL, '手机/数码', 39, 2900, '品牌39');
INSERT INTO `goods` VALUES (40, '第40个商品名称', 40.40, '第40个商品', NULL, '电脑/办公', 40, 3000, '品牌40');
INSERT INTO `goods` VALUES (41, '第41个商品名称', 41.41, '第41个商品', NULL, '食品/蔬菜', 41, 3100, '品牌41');
INSERT INTO `goods` VALUES (42, '第42个商品名称', 42.42, '第42个商品', NULL, '医疗/保健', 42, 3200, '品牌42');
INSERT INTO `goods` VALUES (43, '第43个商品名称', 43.43, '第43个商品', NULL, '零食/美酒', 43, 3300, '品牌43');
INSERT INTO `goods` VALUES (44, '第44个商品名称', 44.44, '第44个商品', NULL, '美妆/护肤', 44, 3400, '品牌44');
INSERT INTO `goods` VALUES (45, '第45个商品名称', 45.45, '第45个商品', NULL, '户外/运动', 45, 3500, '品牌45');
INSERT INTO `goods` VALUES (46, '第46个商品名称', 46.46, '第46个商品', NULL, '手机/数码', 46, 3600, '品牌46');
INSERT INTO `goods` VALUES (47, '第47个商品名称', 47.47, '第47个商品', NULL, '电脑/办公', 47, 3700, '品牌47');
INSERT INTO `goods` VALUES (48, '第48个商品名称', 48.48, '第48个商品', NULL, '食品/蔬菜', 48, 3800, '品牌48');
INSERT INTO `goods` VALUES (49, '第49个商品名称', 49.49, '第49个商品', NULL, '医疗/保健', 49, 3900, '品牌49');
INSERT INTO `goods` VALUES (50, '第50个商品名称', 50.50, '第50个商品', NULL, '零食/美酒', 50, 4000, '品牌50');
INSERT INTO `goods` VALUES (51, '第51个商品名称', 51.51, '第51个商品', NULL, '美妆/护肤', 51, 4100, '品牌51');
INSERT INTO `goods` VALUES (52, '第52个商品名称', 52.52, '第52个商品', NULL, '户外/运动', 52, 4200, '品牌52');
INSERT INTO `goods` VALUES (53, '第53个商品名称', 53.53, '第53个商品', NULL, '手机/数码', 53, 4300, '品牌53');
INSERT INTO `goods` VALUES (54, '第54个商品名称', 54.54, '第54个商品', NULL, '电脑/办公', 54, 4400, '品牌54');
INSERT INTO `goods` VALUES (55, '第55个商品名称', 55.55, '第55个商品', NULL, '食品/蔬菜', 55, 4500, '品牌55');
INSERT INTO `goods` VALUES (56, '第56个商品名称', 56.56, '第56个商品', NULL, '医疗/保健', 56, 4600, '品牌56');
INSERT INTO `goods` VALUES (57, '第57个商品名称', 57.57, '第57个商品', NULL, '零食/美酒', 57, 4700, '品牌57');
INSERT INTO `goods` VALUES (58, '第58个商品名称', 58.58, '第58个商品', NULL, '美妆/护肤', 58, 4800, '品牌58');
INSERT INTO `goods` VALUES (59, '第59个商品名称', 59.59, '第59个商品', NULL, '户外/运动', 59, 4900, '品牌59');
INSERT INTO `goods` VALUES (60, '第60个商品名称', 60.60, '第60个商品', NULL, '手机/数码', 60, 5000, '品牌60');
INSERT INTO `goods` VALUES (61, '第61个商品名称', 61.61, '第61个商品', NULL, '电脑/办公', 61, 5100, '品牌61');
INSERT INTO `goods` VALUES (62, '第62个商品名称', 62.62, '第62个商品', NULL, '食品/蔬菜', 62, 5200, '品牌62');
INSERT INTO `goods` VALUES (63, '第63个商品名称', 63.63, '第63个商品', NULL, '医疗/保健', 63, 5300, '品牌63');
INSERT INTO `goods` VALUES (64, '第64个商品名称', 64.64, '第64个商品', NULL, '零食/美酒', 64, 5400, '品牌64');
INSERT INTO `goods` VALUES (65, '第65个商品名称', 65.65, '第65个商品', NULL, '美妆/护肤', 65, 5500, '品牌65');
INSERT INTO `goods` VALUES (66, '第66个商品名称', 66.66, '第66个商品', NULL, '户外/运动', 66, 5600, '品牌66');
INSERT INTO `goods` VALUES (67, '第67个商品名称', 67.67, '第67个商品', NULL, '手机/数码', 67, 5700, '品牌67');
INSERT INTO `goods` VALUES (68, '第68个商品名称', 68.68, '第68个商品', NULL, '电脑/办公', 68, 5800, '品牌68');
INSERT INTO `goods` VALUES (69, '第69个商品名称', 69.69, '第69个商品', NULL, '食品/蔬菜', 69, 5900, '品牌69');
INSERT INTO `goods` VALUES (70, '第70个商品名称', 70.70, '第70个商品', NULL, '医疗/保健', 70, 6000, '品牌70');
INSERT INTO `goods` VALUES (71, '第71个商品名称', 71.71, '第71个商品', NULL, '零食/美酒', 71, 6100, '品牌71');
INSERT INTO `goods` VALUES (72, '第72个商品名称', 72.72, '第72个商品', NULL, '美妆/护肤', 72, 6200, '品牌72');
INSERT INTO `goods` VALUES (73, '第73个商品名称', 73.73, '第73个商品', NULL, '户外/运动', 73, 6300, '品牌73');
INSERT INTO `goods` VALUES (74, '第74个商品名称', 74.74, '第74个商品', NULL, '手机/数码', 74, 6400, '品牌74');
INSERT INTO `goods` VALUES (75, '第75个商品名称', 75.75, '第75个商品', NULL, '电脑/办公', 75, 6500, '品牌75');
INSERT INTO `goods` VALUES (76, '第76个商品名称', 76.76, '第76个商品', NULL, '食品/蔬菜', 76, 6600, '品牌76');
INSERT INTO `goods` VALUES (77, '第77个商品名称', 77.77, '第77个商品', NULL, '医疗/保健', 77, 6700, '品牌77');
INSERT INTO `goods` VALUES (78, '第78个商品名称', 78.78, '第78个商品', NULL, '零食/美酒', 78, 6800, '品牌78');
INSERT INTO `goods` VALUES (79, '第79个商品名称', 79.79, '第79个商品', NULL, '美妆/护肤', 79, 6900, '品牌79');
INSERT INTO `goods` VALUES (80, '第80个商品名称', 80.80, '第80个商品', NULL, '户外/运动', 80, 7000, '品牌80');
INSERT INTO `goods` VALUES (81, '第81个商品名称', 81.81, '第81个商品', NULL, '手机/数码', 81, 7100, '品牌81');
INSERT INTO `goods` VALUES (82, '第82个商品名称', 82.82, '第82个商品', NULL, '电脑/办公', 82, 7200, '品牌82');
INSERT INTO `goods` VALUES (83, '第83个商品名称', 83.83, '第83个商品', NULL, '食品/蔬菜', 83, 7300, '品牌83');
INSERT INTO `goods` VALUES (84, '第84个商品名称', 84.84, '第84个商品', NULL, '医疗/保健', 84, 7400, '品牌84');
INSERT INTO `goods` VALUES (85, '第85个商品名称', 85.85, '第85个商品', NULL, '零食/美酒', 85, 7500, '品牌85');
INSERT INTO `goods` VALUES (86, '第86个商品名称', 86.86, '第86个商品', NULL, '美妆/护肤', 86, 7600, '品牌86');
INSERT INTO `goods` VALUES (87, '第87个商品名称', 87.87, '第87个商品', NULL, '户外/运动', 87, 7700, '品牌87');
INSERT INTO `goods` VALUES (88, '第88个商品名称', 88.88, '第88个商品', NULL, '手机/数码', 88, 7800, '品牌88');
INSERT INTO `goods` VALUES (89, '第89个商品名称', 89.89, '第89个商品', NULL, '电脑/办公', 89, 7900, '品牌89');
INSERT INTO `goods` VALUES (90, '第90个商品名称', 90.90, '第90个商品', NULL, '食品/蔬菜', 90, 8000, '品牌90');
INSERT INTO `goods` VALUES (91, '第91个商品名称', 91.91, '第91个商品', NULL, '医疗/保健', 91, 8100, '品牌91');
INSERT INTO `goods` VALUES (92, '第92个商品名称', 92.92, '第92个商品', NULL, '零食/美酒', 92, 8200, '品牌92');
INSERT INTO `goods` VALUES (93, '第93个商品名称', 93.93, '第93个商品', NULL, '美妆/护肤', 93, 8300, '品牌93');
INSERT INTO `goods` VALUES (94, '第94个商品名称', 94.94, '第94个商品', NULL, '户外/运动', 94, 8400, '品牌94');
INSERT INTO `goods` VALUES (95, '第95个商品名称', 95.95, '第95个商品', NULL, '手机/数码', 95, 8500, '品牌95');
INSERT INTO `goods` VALUES (96, '第96个商品名称', 96.96, '第96个商品', NULL, '电脑/办公', 96, 8600, '品牌96');
INSERT INTO `goods` VALUES (97, '第97个商品名称', 97.97, '第97个商品', NULL, '食品/蔬菜', 97, 8700, '品牌97');
INSERT INTO `goods` VALUES (98, '第98个商品名称', 98.98, '第98个商品', NULL, '医疗/保健', 98, 8800, '品牌98');
INSERT INTO `goods` VALUES (99, '第99个商品名称', 99.99, '第99个商品', NULL, '零食/美酒', 99, 8900, '品牌99');
INSERT INTO `goods` VALUES (100, '第100个商品名称', 100.10, '第100个商品', NULL, '美妆/护肤', 100, 9000, '品牌100');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `orderid` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `goodsid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品id',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `total_price` double(15, 2) NULL DEFAULT NULL COMMENT '总价格',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '下单时间',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  `number` int(11) NULL DEFAULT NULL COMMENT '数量',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 92 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (51, '1', '昵称1', '第1个商品名称', 1.10, '2021-03-05 17:45:21', '收货地址1', 1, '已发货');
INSERT INTO `orders` VALUES (52, '2', '昵称2', '第2个商品名称', 4.40, '2021-03-05 17:45:21', '收货地址2', 2, NULL);
INSERT INTO `orders` VALUES (53, '3', '昵称3', '第3个商品名称', 9.90, '2021-03-05 17:45:21', '收货地址3', 3, '已发货');
INSERT INTO `orders` VALUES (54, '4', '昵称4', '第4个商品名称', 4.40, '2021-03-05 17:45:21', '收货地址4', 1, NULL);
INSERT INTO `orders` VALUES (55, '5', '昵称5', '第5个商品名称', 10.10, '2021-03-05 17:45:21', '收货地址5', 2, NULL);
INSERT INTO `orders` VALUES (56, '6', '昵称6', '第6个商品名称', 18.18, '2021-03-05 17:45:21', '收货地址6', 3, '已发货');
INSERT INTO `orders` VALUES (57, '7', '昵称7', '第7个商品名称', 7.70, '2021-03-05 17:45:21', '收货地址7', 1, NULL);
INSERT INTO `orders` VALUES (58, '8', '昵称8', '第8个商品名称', 16.16, '2021-03-05 17:45:21', '收货地址8', 2, '已发货');
INSERT INTO `orders` VALUES (59, '9', '昵称9', '第9个商品名称', 27.27, '2021-03-05 17:45:21', '收货地址9', 3, NULL);
INSERT INTO `orders` VALUES (60, '10', '昵称10', '第10个商品名称', 10.10, '2021-03-05 17:45:21', '收货地址10', 1, NULL);
INSERT INTO `orders` VALUES (61, '11', '昵称11', '第1个商品名称', 2.20, '2021-03-05 17:45:21', '收货地址11', 2, NULL);
INSERT INTO `orders` VALUES (62, '12', '昵称12', '第2个商品名称', 6.60, '2021-03-05 17:45:21', '收货地址12', 3, NULL);
INSERT INTO `orders` VALUES (63, '13', '昵称13', '第3个商品名称', 3.30, '2021-03-05 17:45:21', '收货地址13', 1, NULL);
INSERT INTO `orders` VALUES (64, '14', '昵称14', '第4个商品名称', NULL, '2021-03-05 17:45:21', '收货地址14', 2, NULL);
INSERT INTO `orders` VALUES (65, '15', '昵称15', '第5个商品名称', NULL, '2021-03-05 17:45:21', '收货地址15', 3, NULL);
INSERT INTO `orders` VALUES (66, '16', '昵称16', '第6个商品名称', NULL, '2021-03-05 17:45:21', '收货地址16', 1, NULL);
INSERT INTO `orders` VALUES (67, '17', '昵称17', '第7个商品名称', NULL, '2021-03-05 17:45:21', '收货地址17', 2, NULL);
INSERT INTO `orders` VALUES (68, '18', '昵称18', '第8个商品名称', NULL, '2021-03-05 17:45:21', '收货地址1', 3, '未发货');
INSERT INTO `orders` VALUES (69, '19', '昵称19', '第9个商品名称', NULL, '2021-03-05 17:45:21', '收货地址2', 1, NULL);
INSERT INTO `orders` VALUES (70, '20', '昵称20', '第10个商品名称', NULL, '2021-03-05 17:45:21', '收货地址3', 2, NULL);
INSERT INTO `orders` VALUES (71, '21', '昵称1', '第1个商品名称', NULL, '2021-03-05 17:45:21', '收货地址4', 3, NULL);
INSERT INTO `orders` VALUES (72, '22', '昵称2', '第2个商品名称', NULL, '2021-03-05 17:45:21', '收货地址5', 1, NULL);
INSERT INTO `orders` VALUES (73, '23', '昵称3', '第3个商品名称', NULL, '2021-03-05 17:45:21', '收货地址6', 2, NULL);
INSERT INTO `orders` VALUES (74, '24', '昵称4', '第4个商品名称', NULL, '2021-03-05 17:45:21', '收货地址7', 3, NULL);
INSERT INTO `orders` VALUES (75, '25', '昵称5', '第5个商品名称', NULL, '2021-03-05 17:45:21', '收货地址8', 1, NULL);
INSERT INTO `orders` VALUES (76, '1', '昵称6', '第6个商品名称', NULL, '2021-03-05 17:45:21', '收货地址9', 2, NULL);
INSERT INTO `orders` VALUES (77, '2', '昵称7', '第7个商品名称', NULL, '2021-03-05 17:45:21', '收货地址10', 3, NULL);
INSERT INTO `orders` VALUES (78, '3', '昵称8', '第8个商品名称', NULL, '2021-03-05 17:45:21', '收货地址11', 1, NULL);
INSERT INTO `orders` VALUES (79, '4', '昵称9', '第9个商品名称', NULL, '2021-03-05 17:45:21', '收货地址12', 2, NULL);
INSERT INTO `orders` VALUES (80, '5', '昵称10', '第10个商品名称', NULL, '2021-03-05 17:45:21', '收货地址13', 3, NULL);
INSERT INTO `orders` VALUES (81, '6', '昵称11', '第1个商品名称', NULL, '2021-03-05 17:45:21', '收货地址14', 1, NULL);
INSERT INTO `orders` VALUES (82, '7', '昵称12', '第2个商品名称', NULL, '2021-03-05 17:45:21', '收货地址15', 2, NULL);
INSERT INTO `orders` VALUES (83, '8', '昵称13', '第3个商品名称', NULL, '2021-03-05 17:45:21', '收货地址16', 3, NULL);
INSERT INTO `orders` VALUES (84, '9', '昵称14', '第4个商品名称', NULL, '2021-03-05 17:45:21', '收货地址17', 1, NULL);
INSERT INTO `orders` VALUES (85, '10', '昵称15', '第5个商品名称', NULL, '2021-03-05 17:45:21', '收货地址1', 2, NULL);
INSERT INTO `orders` VALUES (86, '11', '昵称16', '第6个商品名称', NULL, '2021-03-05 17:45:21', '收货地址2', 3, NULL);
INSERT INTO `orders` VALUES (87, '12', '昵称17', '第7个商品名称', NULL, '2021-03-05 17:45:21', '收货地址3', 1, NULL);
INSERT INTO `orders` VALUES (88, '13', '昵称18', '第8个商品名称', NULL, '2021-03-05 17:45:21', '收货地址4', 2, NULL);
INSERT INTO `orders` VALUES (89, '14', '昵称19', '第9个商品名称', NULL, '2021-03-05 17:45:21', '收货地址5', 3, NULL);
INSERT INTO `orders` VALUES (90, '15', '昵称20', '第10个商品名称', NULL, '2021-03-05 17:45:21', '收货地址6', 1, NULL);

-- ----------------------------
-- Table structure for paylog
-- ----------------------------
DROP TABLE IF EXISTS `paylog`;
CREATE TABLE `paylog`  (
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `sn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建编号',
  `pay_sn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付宝编号',
  `totalAmount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '总价格',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单详细',
  `status` int(1) NOT NULL COMMENT '状态',
  `refundAmount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退款金额',
  `refundInfo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退款信息',
  `refundSn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退款编号',
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `payTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`sn`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paylog
-- ----------------------------
INSERT INTO `paylog` VALUES ('00201', 'cywl044CA5C0E17F496B8D3D7677E938F9DD', 'null', '1.1', '第一个商品名称', 'null', 3, 'null', 'null', 'null', '2021-03-05 11:32:47', 'null');

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart`  (
  `sn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '购物车id',
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `goodsid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品id',
  `number` int(11) NOT NULL COMMENT '数量',
  `total_price` double NOT NULL COMMENT '总价格',
  PRIMARY KEY (`sn`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '过期时间',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`token`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES ('10412e23-bb42-4b9f-901d-b800e2568cfc', 'admin', '管理员', '1615030451505', '正常');
INSERT INTO `token` VALUES ('1181b7ff-50ba-4aa1-bc28-792f416d58d8', 'admin', '管理员', '1615034320931', '正常');
INSERT INTO `token` VALUES ('158aff97-7b31-469e-8a9d-ecd50ed51a49', 'admin', '管理员', '1615032026098', '正常');
INSERT INTO `token` VALUES ('198047f7-ce22-441d-91ea-e66aa7f80696', 'admin', '管理员', '1615031570317', '正常');
INSERT INTO `token` VALUES ('19b2b652-c117-4ca2-9f1b-0719a3fe9c64', 'admin', '管理员', '1615029557397', '正常');
INSERT INTO `token` VALUES ('201648f0-c192-408d-b728-cbe00611a02b', 'admin', '管理员', '1615029755266', '正常');
INSERT INTO `token` VALUES ('26de7eaf-cd61-4c93-b03f-d3e7f21bd002', 'admin', '管理员', '1615030373653', '正常');
INSERT INTO `token` VALUES ('317404a7-bdab-4624-8d9d-74a28705c64e', 'admin', '管理员', '1615029521607', '正常');
INSERT INTO `token` VALUES ('35b8bc53-10b1-438d-8ef8-bf3589413573', '00000058', '普通用户', '1615032507535', '正常');
INSERT INTO `token` VALUES ('368961d5-ada2-49d3-bfc0-b0323ab94fcb', 'admin', '管理员', '1615029637544', '正常');
INSERT INTO `token` VALUES ('382d1563-8ff6-4881-931d-65cbe6fc3111', 'admin', '管理员', '1615031686501', '正常');
INSERT INTO `token` VALUES ('3a73fb56-76c5-4b0e-addf-501a6d10ba57', 'admin', '管理员', '1615032138948', '正常');
INSERT INTO `token` VALUES ('3fa9e306-3144-471c-9e32-6f97e41deb25', '00000058', '普通用户', '1615032207490', '正常');
INSERT INTO `token` VALUES ('42159dc6-9b0b-4c17-b895-78b9da4e4e2e', 'admin', '管理员', '1615029915923', '正常');
INSERT INTO `token` VALUES ('47653083-7d72-4bd7-87ad-2e721846ae02', 'admin', '管理员', '1615029667011', '正常');
INSERT INTO `token` VALUES ('48f69327-3712-4316-86e1-904a7fa34912', 'admin', '管理员', '1615029979290', '正常');
INSERT INTO `token` VALUES ('4a628717-1981-498e-ac27-24d1b822268e', '00000058', '普通用户', '1615032505189', '正常');
INSERT INTO `token` VALUES ('62315344-f9d5-4d30-b90e-7ba89397db20', '00000058', '普通用户', '1615032507858', '正常');
INSERT INTO `token` VALUES ('6b221928-4c96-4515-be43-26b346118279', '00000058', '普通用户', '1615032506957', '正常');
INSERT INTO `token` VALUES ('7c715215-cccc-45bb-9327-b43f17ca4f01', 'admin', '管理员', '1615030757422', '正常');
INSERT INTO `token` VALUES ('857899c2-52f9-4220-8cc4-586553e32c8d', 'admin', '管理员', '1615031581582', '正常');
INSERT INTO `token` VALUES ('85f3c010-d2d0-4523-822d-b6a1874d637a', 'admin', '管理员', '1615030372629', '正常');
INSERT INTO `token` VALUES ('87e1bc94-2680-4efc-bb36-81d0a9156fba', 'admin', '管理员', '1615030825975', '正常');
INSERT INTO `token` VALUES ('a1d51139-660e-4591-b3ae-68215fd500eb', 'admin', '管理员', '1615031029905', '正常');
INSERT INTO `token` VALUES ('b47a8794-7677-472b-9d0b-41d8d7c847b1', '00000058', '普通用户', '1615032384061', '正常');
INSERT INTO `token` VALUES ('c4caf241-37d1-4643-9b90-867290141dbf', 'admin', '管理员', '1615030100362', '正常');
INSERT INTO `token` VALUES ('c6736cf4-4ac9-4097-b1e5-c51c63b3f4a7', 'admin', '管理员', '1615032292529', '正常');
INSERT INTO `token` VALUES ('c8cb5a59-b908-4d96-9ef1-a69a6c60a490', 'admin', '管理员', '1615032375623', '正常');
INSERT INTO `token` VALUES ('c9aeeee6-c780-4325-a22d-2ce0f7b88602', 'admin', '管理员', '1615031513847', '正常');
INSERT INTO `token` VALUES ('ccf65d15-854c-434b-a54e-b54ca14e02b6', '00000058', '普通用户', '1615032210385', '正常');
INSERT INTO `token` VALUES ('d9151dfd-5d33-4b73-a5c9-8a5f651a5bd8', '00000058', '普通用户', '1615028719737', '正常');
INSERT INTO `token` VALUES ('e0d69175-df91-46d5-a3bb-9cc6cb07c8e9', 'admin', '管理员', '1615029804498', '正常');
INSERT INTO `token` VALUES ('ef99b330-1d25-4782-aba3-630b5e6b01d8', '00000058', '普通用户', '1615032507694', '正常');
INSERT INTO `token` VALUES ('f335e672-bbe4-41d7-b8d7-1ea7cc8fdd86', 'admin', '管理员', '1615031805471', '正常');
INSERT INTO `token` VALUES ('f96553ab-f133-40e8-adf5-665e0e3b3f2b', 'admin', '管理员', '1615031068643', '正常');
INSERT INTO `token` VALUES ('fd5281eb-debd-4e18-9551-ceb82c177333', 'admin', '管理员', '1615030594648', '正常');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `phone` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `permission` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('00000001', '000001', '昵称1', '男', 1, '00000000001', '普通用户', '邮箱01');
INSERT INTO `user` VALUES ('00000002', '000002', '昵称2', '女', 2, '00000000002', '普通用户', '邮箱02');
INSERT INTO `user` VALUES ('00000003', '000003', '昵称3', '男', 3, '00000000003', '普通用户', '邮箱03');
INSERT INTO `user` VALUES ('00000004', '000004', '昵称4', '女', 4, '00000000004', '普通用户', '邮箱04');
INSERT INTO `user` VALUES ('00000005', '000005', '昵称5', '男', 5, '00000000005', '普通用户', '邮箱05');
INSERT INTO `user` VALUES ('00000006', '000006', '昵称6', '女', 6, '00000000006', '普通用户', '邮箱06');
INSERT INTO `user` VALUES ('00000007', '000007', '昵称7', '男', 7, '00000000007', '普通用户', '邮箱07');
INSERT INTO `user` VALUES ('00000008', '000008', '昵称8', '女', 8, '00000000008', '普通用户', '邮箱08');
INSERT INTO `user` VALUES ('00000009', '000009', '昵称9', '男', 9, '00000000009', '普通用户', '邮箱09');
INSERT INTO `user` VALUES ('00000010', '000010', '昵称10', '女', 10, '00000000010', '普通用户', '邮箱10');
INSERT INTO `user` VALUES ('00000011', '000011', '昵称11', '男', 11, '00000000011', '普通用户', '邮箱11');
INSERT INTO `user` VALUES ('00000012', '000012', '昵称12', '女', 12, '00000000012', '普通用户', '邮箱12');
INSERT INTO `user` VALUES ('00000013', '000013', '昵称13', '男', 13, '00000000013', '普通用户', '邮箱13');
INSERT INTO `user` VALUES ('00000014', '000014', '昵称14', '女', 14, '00000000014', '普通用户', '邮箱14');
INSERT INTO `user` VALUES ('00000015', '000015', '昵称15', '男', 15, '00000000015', '普通用户', '邮箱15');
INSERT INTO `user` VALUES ('00000016', '000016', '昵称16', '男', 16, '00000000016', '普通用户', '邮箱16');
INSERT INTO `user` VALUES ('00000017', '000017', '昵称17', '男', 17, '00000000017', '普通用户', '邮箱17');
INSERT INTO `user` VALUES ('00000018', '000018', '昵称18', '男', 18, '00000000018', '普通用户', '邮箱18');
INSERT INTO `user` VALUES ('00000019', '000019', '昵称19', '男', 19, '00000000019', '普通用户', '邮箱19');
INSERT INTO `user` VALUES ('00000020', '000020', '昵称20', '男', 20, '00000000020', '普通用户', '邮箱20');
INSERT INTO `user` VALUES ('00000021', '000021', '昵称21', '男', 21, '00000000021', '普通用户', '邮箱21');
INSERT INTO `user` VALUES ('00000022', '000022', '昵称22', '男', 22, '00000000022', '普通用户', '邮箱22');
INSERT INTO `user` VALUES ('00000023', '000023', '昵称23', '男', 23, '00000000023', '普通用户', '邮箱23');
INSERT INTO `user` VALUES ('00000024', '000024', '昵称24', '男', 24, '00000000024', '普通用户', '邮箱24');
INSERT INTO `user` VALUES ('00000025', '000025', '昵称25', '男', 25, '00000000025', '普通用户', '邮箱25');
INSERT INTO `user` VALUES ('00000026', '000026', '昵称26', '男', 26, '00000000026', '普通用户', '邮箱26');
INSERT INTO `user` VALUES ('00000027', '000027', '昵称27', '男', 27, '00000000027', '普通用户', '邮箱27');
INSERT INTO `user` VALUES ('00000028', '000028', '昵称28', '男', 28, '00000000028', '普通用户', '邮箱28');
INSERT INTO `user` VALUES ('00000029', '000029', '昵称29', '男', 29, '00000000029', '普通用户', '邮箱29');
INSERT INTO `user` VALUES ('00000030', '000030', '昵称30', '男', 30, '00000000030', '普通用户', '邮箱30');
INSERT INTO `user` VALUES ('00000031', '000031', '昵称31', '男', 31, '00000000031', '普通用户', '邮箱31');
INSERT INTO `user` VALUES ('00000032', '000032', '昵称32', '男', 32, '00000000032', '普通用户', '邮箱32');
INSERT INTO `user` VALUES ('00000033', '000033', '昵称33', '男', 33, '00000000033', '普通用户', '邮箱33');
INSERT INTO `user` VALUES ('00000034', '000034', '昵称34', '男', 34, '00000000034', '普通用户', '邮箱34');
INSERT INTO `user` VALUES ('00000035', '000035', '昵称35', '男', 35, '00000000035', '普通用户', '邮箱35');
INSERT INTO `user` VALUES ('00000036', '000036', '昵称36', '男', 36, '00000000036', '普通用户', '邮箱36');
INSERT INTO `user` VALUES ('00000037', '000037', '昵称37', '男', 37, '00000000037', '普通用户', '邮箱37');
INSERT INTO `user` VALUES ('00000038', '000038', '昵称38', '男', 38, '00000000038', '普通用户', '邮箱38');
INSERT INTO `user` VALUES ('00000039', '000039', '昵称39', '男', 39, '00000000039', '普通用户', '邮箱39');
INSERT INTO `user` VALUES ('00000040', '000040', '昵称40', '男', 40, '00000000040', '普通用户', '邮箱40');
INSERT INTO `user` VALUES ('00000041', '000041', '昵称41', '男', 41, '00000000041', '普通用户', '邮箱41');
INSERT INTO `user` VALUES ('00000042', '000042', '昵称42', '男', 42, '00000000042', '普通用户', '邮箱42');
INSERT INTO `user` VALUES ('00000043', '000043', '昵称43', '男', 43, '00000000043', '普通用户', '邮箱43');
INSERT INTO `user` VALUES ('00000044', '000044', '昵称44', '男', 44, '00000000044', '普通用户', '邮箱44');
INSERT INTO `user` VALUES ('00000045', '000045', '昵称45', '男', 45, '00000000045', '普通用户', '邮箱45');
INSERT INTO `user` VALUES ('00000046', '000046', '昵称46', '女', 46, '00000000046', '普通用户', '邮箱46');
INSERT INTO `user` VALUES ('00000047', '000047', '昵称47', '女', 47, '00000000047', '普通用户', '邮箱47');
INSERT INTO `user` VALUES ('00000048', '000048', '昵称48', '女', 48, '00000000048', '普通用户', '邮箱48');
INSERT INTO `user` VALUES ('00000049', '000049', '昵称49', '女', 49, '00000000049', '普通用户', '邮箱49');
INSERT INTO `user` VALUES ('00000050', '000050', '昵称50', '女', 50, '00000000050', '普通用户', '邮箱50');
INSERT INTO `user` VALUES ('00000051', '000051', '昵称51', '女', 51, '00000000051', '普通用户', '邮箱51');
INSERT INTO `user` VALUES ('00000052', '000052', '昵称52', '女', 52, '00000000052', '普通用户', '邮箱52');
INSERT INTO `user` VALUES ('00000053', '000053', '昵称53', '女', 53, '00000000053', '普通用户', '邮箱53');
INSERT INTO `user` VALUES ('00000054', '000054', '昵称54', '女', 54, '00000000054', '普通用户', '邮箱54');
INSERT INTO `user` VALUES ('00000055', '000055', '昵称55', '女', 55, '00000000055', '普通用户', '邮箱55');
INSERT INTO `user` VALUES ('00000056', '000056', '昵称56', '女', 56, '00000000056', '普通用户', '邮箱56');
INSERT INTO `user` VALUES ('00000057', '000057', '昵称57', '女', 57, '00000000057', '普通用户', '邮箱57');
INSERT INTO `user` VALUES ('00000058', '000058', '昵称58', '女', 58, '00000000058', '普通用户', '邮箱58');
INSERT INTO `user` VALUES ('00000059', '000059', '昵称59', '女', 59, '00000000059', '普通用户', '邮箱59');
INSERT INTO `user` VALUES ('00000060', '000060', '昵称60', '女', 60, '00000000060', '普通用户', '邮箱60');
INSERT INTO `user` VALUES ('00000061', '000061', '昵称61', '女', 61, '00000000061', '普通用户', '邮箱61');
INSERT INTO `user` VALUES ('00000062', '000062', '昵称62', '女', 62, '00000000062', '普通用户', '邮箱62');
INSERT INTO `user` VALUES ('00000063', '000063', '昵称63', '女', 63, '00000000063', '普通用户', '邮箱63');
INSERT INTO `user` VALUES ('00000064', '000064', '昵称64', '女', 64, '00000000064', '普通用户', '邮箱64');
INSERT INTO `user` VALUES ('00000065', '000065', '昵称65', '女', 65, '00000000065', '普通用户', '邮箱65');
INSERT INTO `user` VALUES ('00000066', '000066', '昵称66', '女', 66, '00000000066', '普通用户', '邮箱66');
INSERT INTO `user` VALUES ('00000067', '000067', '昵称67', '女', 67, '00000000067', '普通用户', '邮箱67');
INSERT INTO `user` VALUES ('00000068', '000068', '昵称68', '女', 68, '00000000068', '普通用户', '邮箱68');
INSERT INTO `user` VALUES ('00000069', '000069', '昵称69', '女', 69, '00000000069', '普通用户', '邮箱69');
INSERT INTO `user` VALUES ('00000070', '000070', '昵称70', '女', 70, '00000000070', '普通用户', '邮箱70');
INSERT INTO `user` VALUES ('00000071', '000071', '昵称71', '女', 71, '00000000071', '普通用户', '邮箱71');
INSERT INTO `user` VALUES ('00000072', '000072', '昵称72', '女', 72, '00000000072', '普通用户', '邮箱72');
INSERT INTO `user` VALUES ('00000073', '000073', '昵称73', '女', 73, '00000000073', '普通用户', '邮箱73');
INSERT INTO `user` VALUES ('00000074', '000074', '昵称74', '女', 74, '00000000074', '普通用户', '邮箱74');
INSERT INTO `user` VALUES ('00000075', '000075', '昵称75', '女', 75, '00000000075', '普通用户', '邮箱75');
INSERT INTO `user` VALUES ('00000076', '000076', '昵称76', '女', 76, '00000000076', '普通用户', '邮箱76');
INSERT INTO `user` VALUES ('00000077', '000077', '昵称77', '女', 77, '00000000077', '普通用户', '邮箱77');
INSERT INTO `user` VALUES ('00000078', '000078', '昵称78', '女', 78, '00000000078', '普通用户', '邮箱78');
INSERT INTO `user` VALUES ('00000079', '000079', '昵称79', '女', 79, '00000000079', '普通用户', '邮箱79');
INSERT INTO `user` VALUES ('00000080', '000080', '昵称80', '女', 80, '00000000080', '普通用户', '邮箱80');
INSERT INTO `user` VALUES ('admin', '123456', '管理', '男', 0, '00000000000', '管理员', '管理员邮箱');

SET FOREIGN_KEY_CHECKS = 1;
