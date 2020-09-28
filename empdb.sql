/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.31 : Database - empdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`empdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `empdb`;

/*Table structure for table `tbl_emp` */

DROP TABLE IF EXISTS `tbl_emp`;

CREATE TABLE `tbl_emp` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(50) DEFAULT NULL,
  `emp_gender` varchar(50) DEFAULT NULL,
  `emp_email` varchar(64) DEFAULT NULL,
  `dept` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_emp` */

insert  into `tbl_emp`(`emp_id`,`emp_name`,`emp_gender`,`emp_email`,`dept`) values 
(1,'孙某某','男','15627915168@163.com','计算机'),
(2,'JavaEE','女','1234@163.com','阿萨'),
(3,'林老师','女','1234@163.com','会计'),
(4,'Spring','男','123@163.com','1'),
(5,'Tomcat','男','123@163.com','6'),
(6,'A某某','男','123@163.com','4'),
(7,'张某某','男','123@163.com','1'),
(8,'SpringMVC','女','1234@163.com','2'),
(9,'Mybatis','女','1234@163.com','5'),
(10,'赖老师','女','1234@163.com','6'),
(11,'郑老师','女','1234@163.com','7'),
(15,'周数人','男','000@qq.com','1'),
(16,'孙某','男','1243@163.com','1'),
(21,'呵呵呵1','无','666','呵呵学院');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
