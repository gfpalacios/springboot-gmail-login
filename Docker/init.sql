CREATE DATABASE IF NOT EXISTS sample;
USE sample;


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sample_user
-- ----------------------------
DROP TABLE IF EXISTS `sample_user`;
CREATE TABLE `sample_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sample_user
-- ----------------------------
INSERT INTO `sample_user` VALUES ('11', 'fabio@gmail.com');
INSERT INTO `sample_user` VALUES ('12',  'daniel@gmail.com');



-- ----------------------------
-- Table structure for sample_contact
-- ----------------------------
DROP TABLE IF EXISTS `sample_contact`;
CREATE TABLE `sample_contact` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT,
  `contact` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`contact_id`),
  KEY `FKmpxdobw6eyr6tfxudo3un66rj` (`user_id`),
  CONSTRAINT `FKmpxdobw6eyr6tfxudo3un66rj` FOREIGN KEY (`user_id`) REFERENCES `sample_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sample_contact
-- ----------------------------
INSERT INTO `sample_contact` VALUES ('15', 'jose', '11');
INSERT INTO `sample_contact` VALUES ('16', 'carlos', '11');
INSERT INTO `sample_contact` VALUES ('17', 'juan', '11');
INSERT INTO `sample_contact` VALUES ('18', 'manual', '12');
INSERT INTO `sample_contact` VALUES ('19', 'andrea', '12');
INSERT INTO `sample_contact` VALUES ('20', 'joana', '12');



SET FOREIGN_KEY_CHECKS=1;