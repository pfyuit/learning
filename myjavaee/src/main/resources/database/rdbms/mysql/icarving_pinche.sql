-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: icarving_pinche
-- ------------------------------------------------------
-- Server version	5.6.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity` (
  `activity_id` int(11) NOT NULL AUTO_INCREMENT,
  `owner_id` int(11) NOT NULL,
  `start_time` datetime NOT NULL,
  `return_time` datetime NOT NULL,
  `source_address` varchar(100) NOT NULL,
  `dest_address` varchar(100) NOT NULL,
  `charge` varchar(50) DEFAULT NULL,
  `car_type` varchar(10) DEFAULT NULL,
  `capacity` int(5) NOT NULL,
  `apply_number` int(11) DEFAULT NULL,
  `approve_number` int(11) DEFAULT NULL,
  `status` varchar(15) NOT NULL,
  `note` text,
  `publish_time` datetime NOT NULL,
  `last_modify` datetime NOT NULL,
  `owner_name` varchar(45) DEFAULT NULL,
  `owner_phone` varchar(20) DEFAULT NULL,
  `owner_avatar` varchar(150) DEFAULT NULL,
  `venue` varchar(150) DEFAULT NULL,
  `activity_type` int(11) NOT NULL,
  `owner_country` varchar(45) DEFAULT NULL,
  `owner_province` varchar(45) DEFAULT NULL,
  `owner_city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` (`activity_id`, `owner_id`, `start_time`, `return_time`, `source_address`, `dest_address`, `charge`, `car_type`, `capacity`, `apply_number`, `approve_number`, `status`, `note`, `publish_time`, `last_modify`, `owner_name`, `owner_phone`, `owner_avatar`, `venue`, `activity_type`, `owner_country`, `owner_province`, `owner_city`) VALUES (7,9,'2014-12-24 14:00:00','2014-12-28 13:00:00','天通苑','南山滑雪场','AA，人均200元','大众',1,1,0,'valid','可以等1个小时左右','2014-12-30 13:55:04','2015-01-21 14:41:51','pengfei1','123','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0','天通苑',2,'中国','安徽','安庆'),(8,9,'2015-01-15 10:00:00','2015-01-18 13:00:00','望京','吉林','AA，人均200元','吉普8',5,1,0,'cancelled','可以等1个小时左右','2015-01-11 15:21:25','2015-01-18 19:14:11','pengfei1','123','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0','望京',1,'中国','安徽','安庆'),(18,9,'2015-01-22 15:00:00','2015-01-31 14:00:00','afdsa','fdsafdsa',NULL,NULL,1,0,0,'cancelled',NULL,'2015-01-18 19:33:36','2015-01-18 20:20:42','pengfei1','43214214234','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0',NULL,2,'中国','安徽','安庆'),(19,9,'2015-01-22 14:00:00','2015-01-30 19:00:00','fdsafdsa','fdasfdsa','fdas','dsafdsa',3,0,0,'cancelled',NULL,'2015-01-18 20:43:12','2015-01-18 20:58:49','pengfei1','fdsafdsa','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0','fdasf',1,'中国','安徽','安庆'),(20,9,'2015-01-22 14:00:00','2015-01-30 19:00:00','fdsafdsa','fdasfdsa','fdas','dsafdsa',3,0,0,'cancelled',NULL,'2015-01-18 20:43:12','2015-01-18 20:58:45','pengfei1','fdsafdsa','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0','fdasf',1,'中国','安徽','安庆'),(21,9,'2015-01-22 14:00:00','2015-01-30 19:00:00','fdsafdsa','fdasfdsa','fdas','dsafdsa',3,0,0,'cancelled',NULL,'2015-01-18 20:43:29','2015-01-18 20:58:42','pengfei1','fdsafdsa','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0','fdasf',1,'中国','安徽','安庆'),(22,9,'2015-01-22 14:00:00','2015-01-30 19:00:00','fdsafdsa','fdasfdsa','fdas','dsafdsa',3,0,0,'cancelled',NULL,'2015-01-18 20:43:30','2015-01-18 20:58:34','pengfei1','fdsafdsa','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0','fdasf',1,'中国','安徽','安庆'),(23,9,'2015-01-11 22:00:00','2015-01-26 23:00:00','fdsa','fdasfsad','fdsafdsaf','fdsafdsa',3,0,0,'cancelled',NULL,'2015-01-18 20:44:33','2015-01-18 20:58:29','pengfei1','432432432','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0','fdasfdsa',1,'中国','安徽','安庆'),(24,9,'2015-01-11 22:00:00','2015-01-26 23:00:00','fdsa','fdasfsad','fdsafdsaf','fdsafdsa',3,0,0,'cancelled',NULL,'2015-01-18 20:44:33','2015-01-18 20:58:21','pengfei1','432432432','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0','fdasfdsa',1,'中国','安徽','安庆'),(25,9,'2015-01-11 22:00:00','2015-01-26 23:00:00','fdsa','fdasfsad','fdsafdsaf','fdsafdsa',3,0,0,'cancelled',NULL,'2015-01-18 20:44:50','2015-01-18 20:58:25','pengfei1','432432432','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0','fdasfdsa',1,'中国','安徽','安庆'),(26,9,'2015-01-11 22:00:00','2015-01-26 23:00:00','fdsa','fdasfsad','fdsafdsaf','fdsafdsa',3,0,0,'cancelled',NULL,'2015-01-18 20:44:50','2015-01-18 20:58:17','pengfei1','432432432','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0','fdasfdsa',1,'中国','安徽','安庆'),(27,9,'2015-01-11 13:00:00','2015-01-21 18:00:00','fdsa','fdasfdsa',NULL,NULL,3,0,0,'cancelled',NULL,'2015-01-18 20:45:19','2015-01-18 20:58:12','pengfei1','2312321','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0',NULL,1,'中国','安徽','安庆'),(28,9,'2015-01-11 13:00:00','2015-01-21 18:00:00','fdsa','fdasfdsa',NULL,NULL,3,0,0,'cancelled',NULL,'2015-01-18 20:45:28','2015-01-18 20:58:08','pengfei1','2312321','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0',NULL,1,'中国','安徽','安庆'),(29,9,'2015-01-01 10:00:00','2015-01-02 15:00:00','aa','dfds',NULL,NULL,2,0,0,'cancelled',NULL,'2015-01-18 20:47:46','2015-01-18 20:57:58','pengfei1','42432432423','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0',NULL,1,'中国','安徽','安庆'),(30,9,'2015-01-01 10:00:00','2015-01-02 15:00:00','aa','dfds',NULL,NULL,2,0,0,'cancelled',NULL,'2015-01-18 20:48:07','2015-01-18 20:58:03','pengfei1','42432432423','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0',NULL,1,'中国','安徽','安庆'),(31,9,'2015-01-11 13:00:00','2015-01-28 18:00:00','fdsafdsa','fdsafdsaf',NULL,NULL,2,0,0,'cancelled',NULL,'2015-01-18 20:49:55','2015-01-18 20:57:53','pengfei1','42432432432','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0',NULL,1,'中国','安徽','安庆'),(32,9,'2015-01-11 13:00:00','2015-01-28 18:00:00','fdsafdsa','fdsafdsaf',NULL,NULL,2,0,0,'cancelled',NULL,'2015-01-18 20:49:56','2015-01-18 20:57:49','pengfei1','42432432432','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0',NULL,1,'中国','安徽','安庆'),(33,9,'2015-01-01 06:00:00','2015-01-24 11:00:00','fdsa','fdasfdsa',NULL,'fdsafdsa',3,0,0,'cancelled',NULL,'2015-01-18 20:52:02','2015-01-18 20:57:43','pengfei1','2423432','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0','fdsafdsa',1,'中国','安徽','安庆'),(34,9,'2015-01-01 06:00:00','2015-01-24 11:00:00','fdsa','fdasfdsa',NULL,'fdsafdsa',3,0,0,'cancelled',NULL,'2015-01-18 20:52:02','2015-01-18 20:57:37','pengfei1','2423432','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0','fdsafdsa',1,'中国','安徽','安庆'),(35,9,'2015-01-03 11:00:00','2015-01-24 19:00:00','aaaa','aaaa',NULL,NULL,3,0,0,'cancelled',NULL,'2015-01-18 20:54:16','2015-01-18 20:57:30','pengfei1','143232432432','http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0',NULL,1,'中国','安徽','安庆');
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apply`
--

DROP TABLE IF EXISTS `apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apply` (
  `apply_id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) NOT NULL,
  `owner_id` int(11) NOT NULL,
  `status` varchar(15) NOT NULL,
  `apply_time` datetime NOT NULL,
  `last_modify` datetime NOT NULL,
  `owner_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`apply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply`
--

LOCK TABLES `apply` WRITE;
/*!40000 ALTER TABLE `apply` DISABLE KEYS */;
INSERT INTO `apply` (`apply_id`, `activity_id`, `owner_id`, `status`, `apply_time`, `last_modify`, `owner_name`) VALUES (36,8,10,'cancelled','2015-01-16 13:29:28','2015-01-18 18:57:57','pengfei2'),(37,7,10,'cancelled','2015-01-16 15:01:01','2015-01-21 14:41:51','pengfei2');
/*!40000 ALTER TABLE `apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invitation`
--

DROP TABLE IF EXISTS `invitation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invitation` (
  `invitation_id` int(11) NOT NULL AUTO_INCREMENT,
  `creator_id` int(11) NOT NULL DEFAULT '0',
  `invitation_code` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `last_modify` datetime NOT NULL,
  `is_used` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`invitation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invitation`
--

LOCK TABLES `invitation` WRITE;
/*!40000 ALTER TABLE `invitation` DISABLE KEYS */;
INSERT INTO `invitation` (`invitation_id`, `creator_id`, `invitation_code`, `create_time`, `last_modify`, `is_used`) VALUES (1,0,123456,'2014-12-24 14:00:00','2015-01-21 14:41:23',1),(2,0,123456,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(3,0,123456,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(4,0,831800,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(5,0,962683,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(6,0,101677,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(7,0,146150,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(8,0,191467,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(9,0,920834,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(10,0,149352,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(11,0,798405,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(12,0,495550,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(13,0,985544,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(14,0,689449,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(15,0,845235,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(16,0,452049,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(17,0,983868,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(18,0,512094,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(19,0,390634,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(20,0,507583,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(21,0,454346,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(22,0,438559,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(23,0,110530,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(24,0,683983,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(25,0,594252,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(26,0,209625,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(27,0,454482,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(28,0,658276,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(29,0,467435,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(30,0,604037,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(31,0,429298,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(32,0,759533,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(33,0,501810,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(34,0,643102,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(35,0,647745,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(36,0,507624,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(37,0,259416,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(38,0,822981,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(39,0,883848,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(40,0,733811,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(41,0,298748,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(42,0,980838,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(43,0,425953,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(44,0,498816,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(45,0,120544,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(46,0,786237,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(47,0,241682,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(48,0,585297,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(49,0,662047,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(50,0,849817,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(51,0,220781,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(52,0,534532,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(53,0,259087,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(54,0,970140,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(55,0,918560,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(56,0,500608,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(57,0,846553,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(58,0,189195,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(59,0,195648,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(60,0,290141,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(61,0,421745,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(62,0,709290,'2015-01-21 01:00:00','2015-01-21 01:00:00',0),(63,0,495388,'2015-01-21 01:00:00','2015-01-21 01:00:00',0);
/*!40000 ALTER TABLE `invitation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `from_uid` int(11) NOT NULL,
  `to_uid` int(11) NOT NULL,
  `content` text,
  `status` int(1) NOT NULL,
  `create_time` datetime NOT NULL,
  `last_modify` datetime NOT NULL,
  `message_type` int(11) NOT NULL,
  `activity_id` int(11) DEFAULT NULL,
  `activity_source_address` varchar(100) DEFAULT NULL,
  `activity_dest_address` varchar(100) DEFAULT NULL,
  `apply_id` int(11) DEFAULT NULL,
  `from_name` varchar(45) DEFAULT NULL,
  `to_name` varchar(45) DEFAULT NULL,
  `is_reply` int(1) DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=436 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` (`message_id`, `from_uid`, `to_uid`, `content`, `status`, `create_time`, `last_modify`, `message_type`, `activity_id`, `activity_source_address`, `activity_dest_address`, `apply_id`, `from_name`, `to_name`, `is_reply`) VALUES (319,0,9,'您的活动有一条新的申请',1,'2015-01-16 13:29:29','2015-01-16 13:29:29',1,8,'望京','吉林',36,'','pengfei1',0),(320,0,10,'您已申请活动',1,'2015-01-16 13:29:29','2015-01-16 13:29:29',1,8,'望京','吉林',36,'','pengfei2',0),(321,0,9,'您已批准活动申请',1,'2015-01-16 13:38:38','2015-01-16 13:38:38',1,8,'望京','吉林',36,'','pengfei1',0),(322,0,10,'您的活动申请已被批准',1,'2015-01-16 13:38:38','2015-01-16 13:38:38',1,8,'望京','吉林',36,'','pengfei2',0),(323,0,10,'您已取消活动申请',1,'2015-01-16 13:39:44','2015-01-16 13:39:44',1,8,'望京','吉林',36,'','pengfei2',0),(324,0,9,'活动申请已被申请人取消',1,'2015-01-16 13:39:45','2015-01-16 13:39:45',1,8,'望京','吉林',36,'','pengfei1',0),(325,0,9,'您的活动有一条再次申请',1,'2015-01-16 13:40:02','2015-01-16 13:40:02',1,8,'望京','吉林',36,'','pengfei1',0),(326,0,10,'您已再次申请活动',1,'2015-01-16 13:40:02','2015-01-16 13:40:02',1,8,'望京','吉林',36,'','pengfei2',0),(327,0,9,'您已拒绝活动申请',1,'2015-01-16 13:40:18','2015-01-16 13:40:18',1,8,'望京','吉林',36,'','pengfei1',0),(328,0,10,'您的活动申请已被拒绝',1,'2015-01-16 13:40:18','2015-01-16 13:40:18',1,8,'望京','吉林',36,'','pengfei2',0),(329,0,9,'您的活动有一条再次申请',1,'2015-01-16 14:46:47','2015-01-16 14:46:47',1,8,'望京','吉林',36,'','pengfei1',0),(330,0,10,'您已再次申请活动',1,'2015-01-16 14:46:47','2015-01-16 14:46:47',1,8,'望京','吉林',36,'','pengfei2',0),(331,0,10,'您已取消活动申请',1,'2015-01-16 14:47:12','2015-01-16 14:47:12',1,8,'望京','吉林',36,'','pengfei2',0),(332,0,9,'活动申请已被申请人取消',1,'2015-01-16 14:47:12','2015-01-16 14:47:12',1,8,'望京','吉林',36,'','pengfei1',0),(333,0,9,'您的活动有一条再次申请',1,'2015-01-16 14:50:12','2015-01-16 14:50:12',1,8,'望京','吉林',36,'','pengfei1',0),(334,0,10,'您已再次申请活动',1,'2015-01-16 14:50:12','2015-01-16 14:50:12',1,8,'望京','吉林',36,'','pengfei2',0),(335,0,10,'您已取消活动申请',1,'2015-01-16 14:55:03','2015-01-16 14:55:03',1,8,'望京','吉林',36,'','pengfei2',0),(336,0,9,'活动申请已被申请人取消',1,'2015-01-16 14:55:03','2015-01-16 14:55:03',1,8,'望京','吉林',36,'','pengfei1',0),(337,0,9,'您的活动有一条再次申请',1,'2015-01-16 14:56:27','2015-01-16 14:56:27',1,8,'望京','吉林',36,'','pengfei1',0),(338,0,10,'您已再次申请活动',1,'2015-01-16 14:56:27','2015-01-16 14:56:27',1,8,'望京','吉林',36,'','pengfei2',0),(339,0,9,'您已批准活动申请',1,'2015-01-16 14:57:13','2015-01-16 14:57:13',1,8,'望京','吉林',36,'','pengfei1',0),(340,0,10,'您的活动申请已被批准',1,'2015-01-16 14:57:13','2015-01-16 14:57:13',1,8,'望京','吉林',36,'','pengfei2',0),(341,0,9,'您已拒绝活动申请',1,'2015-01-16 14:58:19','2015-01-16 14:58:19',1,8,'望京','吉林',36,'','pengfei1',0),(342,0,10,'您的活动申请已被拒绝',1,'2015-01-16 14:58:19','2015-01-16 14:58:19',1,8,'望京','吉林',36,'','pengfei2',0),(343,0,9,'您的活动有一条再次申请',1,'2015-01-16 14:58:47','2015-01-16 14:58:47',1,8,'望京','吉林',36,'','pengfei1',0),(344,0,10,'您已再次申请活动',1,'2015-01-16 14:58:47','2015-01-16 14:58:47',1,8,'望京','吉林',36,'','pengfei2',0),(345,0,9,'您已拒绝活动申请',0,'2015-01-16 14:59:06','2015-01-16 14:59:06',1,8,'望京','吉林',36,'','pengfei1',0),(346,0,10,'您的活动申请已被拒绝',1,'2015-01-16 14:59:06','2015-01-16 14:59:06',1,8,'望京','吉林',36,'','pengfei2',0),(347,0,9,'您已更新捡人活动',1,'2015-01-16 15:00:38','2015-01-16 15:00:38',1,7,'天通苑','南山滑雪场',0,'','pengfei1',0),(348,0,9,'您的活动有一条新的申请',1,'2015-01-16 15:01:01','2015-01-16 15:01:01',1,7,'天通苑','南山滑雪场',37,'','pengfei1',0),(349,0,10,'您已申请活动',0,'2015-01-16 15:01:01','2015-01-16 15:01:01',1,7,'天通苑','南山滑雪场',37,'','pengfei2',0),(350,0,9,'您已批准活动申请',1,'2015-01-16 15:01:59','2015-01-16 15:01:59',1,7,'天通苑','南山滑雪场',37,'','pengfei1',0),(351,0,10,'您的活动申请已被批准',1,'2015-01-16 15:02:00','2015-01-16 15:02:00',1,7,'天通苑','南山滑雪场',37,'','pengfei2',0),(352,0,9,'您已拒绝活动申请',1,'2015-01-16 15:02:33','2015-01-16 15:02:33',1,7,'天通苑','南山滑雪场',37,'','pengfei1',0),(353,0,10,'您的活动申请已被拒绝',1,'2015-01-16 15:02:33','2015-01-16 15:02:33',1,7,'天通苑','南山滑雪场',37,'','pengfei2',0),(354,0,9,'您的活动有一条再次申请',0,'2015-01-16 15:03:06','2015-01-16 15:03:06',1,7,'天通苑','南山滑雪场',37,'','pengfei1',0),(355,0,10,'您已再次申请活动',1,'2015-01-16 15:03:06','2015-01-16 15:03:06',1,7,'天通苑','南山滑雪场',37,'','pengfei2',0),(356,0,9,'您已批准活动申请',0,'2015-01-16 15:03:12','2015-01-16 15:03:12',1,7,'天通苑','南山滑雪场',37,'','pengfei1',0),(357,0,10,'您的活动申请已被批准',1,'2015-01-16 15:03:12','2015-01-16 15:03:12',1,7,'天通苑','南山滑雪场',37,'','pengfei2',0),(358,10,9,'哈哈，谢谢批准啊',1,'2015-01-16 15:04:04','2015-01-16 15:04:04',2,7,'天通苑','南山滑雪场',0,'pengfei2','',0),(359,9,10,'xinren',1,'2015-01-16 15:05:49','2015-01-16 15:05:49',2,7,'天通苑','南山滑雪场',0,'pengfei1','pengfei2',1),(360,0,10,'您已取消活动申请',1,'2015-01-16 15:06:00','2015-01-16 15:06:00',1,7,'天通苑','南山滑雪场',37,'','pengfei2',0),(361,0,9,'活动申请已被申请人取消',1,'2015-01-16 15:06:00','2015-01-16 15:06:00',1,7,'天通苑','南山滑雪场',37,'','pengfei1',0),(362,10,9,'取消',1,'2015-01-16 15:06:11','2015-01-16 15:06:11',2,7,'天通苑','南山滑雪场',0,'pengfei2','pengfei1',1),(363,0,9,'您的活动有一条再次申请',1,'2015-01-16 15:08:16','2015-01-16 15:08:16',1,7,'天通苑','南山滑雪场',37,'','pengfei1',0),(364,0,10,'您已再次申请活动',0,'2015-01-16 15:08:16','2015-01-16 15:08:16',1,7,'天通苑','南山滑雪场',37,'','pengfei2',0),(365,0,9,'您已批准活动申请',0,'2015-01-16 15:08:35','2015-01-16 15:08:35',1,7,'天通苑','南山滑雪场',37,'','pengfei1',0),(366,0,10,'您的活动申请已被批准',0,'2015-01-16 15:08:35','2015-01-16 15:08:35',1,7,'天通苑','南山滑雪场',37,'','pengfei2',0),(367,0,9,'您的活动有一条再次申请',1,'2015-01-16 15:09:01','2015-01-16 15:09:01',1,8,'望京','吉林',36,'','pengfei1',0),(368,0,10,'您已再次申请活动',0,'2015-01-16 15:09:01','2015-01-16 15:09:01',1,8,'望京','吉林',36,'','pengfei2',0),(369,0,9,'您已批准活动申请',0,'2015-01-16 15:09:30','2015-01-16 15:09:30',1,8,'望京','吉林',36,'','pengfei1',0),(370,0,10,'您的活动申请已被批准',0,'2015-01-16 15:09:30','2015-01-16 15:09:30',1,8,'望京','吉林',36,'','pengfei2',0),(371,0,9,'您已更新捡人活动',0,'2015-01-16 15:57:27','2015-01-16 15:57:27',1,7,'天通苑','南山滑雪场',0,'','pengfei1',0),(372,0,10,'捡人活动已被发起人更新',0,'2015-01-16 15:57:27','2015-01-16 15:57:27',1,7,'天通苑','南山滑雪场',37,'','pengfei1',0),(373,0,9,'您已拒绝活动申请',0,'2015-01-18 01:21:56','2015-01-18 01:21:56',1,8,'望京','吉林',36,'','pengfei1',0),(374,0,10,'您的活动申请已被拒绝',0,'2015-01-18 01:21:57','2015-01-18 01:21:57',1,8,'望京','吉林',36,'','pengfei2',0),(375,0,9,'您已拒绝活动申请',0,'2015-01-18 11:11:51','2015-01-18 11:11:51',1,7,'天通苑','南山滑雪场',37,'','pengfei1',0),(376,0,10,'您的活动申请已被拒绝',0,'2015-01-18 11:11:51','2015-01-18 11:11:51',1,7,'天通苑','南山滑雪场',37,'','pengfei2',0),(377,0,9,'您的活动有一条再次申请',1,'2015-01-18 17:13:41','2015-01-18 17:13:41',1,8,'望京','吉林',36,'','pengfei1',0),(378,0,10,'您已再次申请活动',0,'2015-01-18 17:13:41','2015-01-18 17:13:41',1,8,'望京','吉林',36,'','pengfei2',0),(379,0,9,'您已批准活动申请',0,'2015-01-18 17:13:59','2015-01-18 17:13:59',1,8,'望京','吉林',36,'','pengfei1',0),(380,0,10,'您的活动申请已被批准',1,'2015-01-18 17:13:59','2015-01-18 17:13:59',1,8,'望京','吉林',36,'','pengfei2',0),(381,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 18:55:06','2015-01-18 18:55:06',1,8,'望京','吉林',0,'','pengfei1',0),(382,0,10,'活动已被发起人取消，您的申请被自动取消',1,'2015-01-18 18:55:06','2015-01-18 18:55:06',1,8,'望京','吉林',36,'','pengfei2',0),(383,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 18:55:33','2015-01-18 18:55:33',1,7,'天通苑','南山滑雪场',0,'','pengfei1',0),(384,0,10,'活动已被发起人取消，您的申请被自动取消',1,'2015-01-18 18:55:33','2015-01-18 18:55:33',1,7,'天通苑','南山滑雪场',37,'','pengfei2',0),(385,0,9,'您的活动有一条再次申请',0,'2015-01-18 18:57:35','2015-01-18 18:57:35',1,7,'天通苑','南山滑雪场',37,'','pengfei1',0),(386,0,10,'您已再次申请活动',0,'2015-01-18 18:57:35','2015-01-18 18:57:35',1,7,'天通苑','南山滑雪场',37,'','pengfei2',0),(387,0,9,'您的活动有一条再次申请',0,'2015-01-18 18:57:47','2015-01-18 18:57:47',1,8,'望京','吉林',36,'','pengfei1',0),(388,0,10,'您已再次申请活动',0,'2015-01-18 18:57:47','2015-01-18 18:57:47',1,8,'望京','吉林',36,'','pengfei2',0),(389,0,9,'您已批准活动申请',1,'2015-01-18 18:57:57','2015-01-18 18:57:57',1,8,'望京','吉林',36,'','pengfei1',0),(390,0,10,'您的活动申请已被批准',0,'2015-01-18 18:57:57','2015-01-18 18:57:57',1,8,'望京','吉林',36,'','pengfei2',0),(391,0,9,'您已批准活动申请',0,'2015-01-18 18:58:05','2015-01-18 18:58:05',1,7,'天通苑','南山滑雪场',37,'','pengfei1',0),(392,0,10,'您的活动申请已被批准',0,'2015-01-18 18:58:05','2015-01-18 18:58:05',1,7,'天通苑','南山滑雪场',37,'','pengfei2',0),(393,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 18:58:26','2015-01-18 18:58:26',1,8,'望京','吉林',0,'','pengfei1',0),(394,0,10,'活动已被发起人取消，您的申请被自动取消',0,'2015-01-18 18:58:27','2015-01-18 18:58:27',1,8,'望京','吉林',36,'','pengfei2',0),(395,0,9,'您已拒绝活动申请',0,'2015-01-18 18:59:39','2015-01-18 18:59:39',1,7,'天通苑','南山滑雪场',37,'','pengfei1',0),(396,0,10,'您的活动申请已被拒绝',0,'2015-01-18 18:59:40','2015-01-18 18:59:40',1,7,'天通苑','南山滑雪场',37,'','pengfei2',0),(397,0,9,'您已更新活动',0,'2015-01-18 19:14:11','2015-01-18 19:14:11',1,8,'望京','吉林',0,'','pengfei1',0),(398,0,10,'活动已被发起人更新',1,'2015-01-18 19:14:11','2015-01-18 19:14:11',1,8,'望京','吉林',36,'','pengfei1',0),(399,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 19:34:26','2015-01-18 19:34:26',1,18,'afdsa','fdsafdsa',0,'','pengfei1',0),(400,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 19:37:01','2015-01-18 19:37:01',1,18,'afdsa','fdsafdsa',0,'','pengfei1',0),(401,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:12:17','2015-01-18 20:12:17',1,18,'afdsa','fdsafdsa',0,'','pengfei1',0),(402,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:13:04','2015-01-18 20:13:04',1,18,'afdsa','fdsafdsa',0,'','pengfei1',0),(403,0,9,'您已取消活动。所有申请被自动取消',1,'2015-01-18 20:20:13','2015-01-18 20:20:13',1,18,'afdsa','fdsafdsa',0,'','pengfei1',0),(404,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:20:42','2015-01-18 20:20:42',1,18,'afdsa','fdsafdsa',0,'','pengfei1',0),(405,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:57:30','2015-01-18 20:57:30',1,35,'aaaa','aaaa',0,'','pengfei1',0),(406,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:57:37','2015-01-18 20:57:37',1,34,'fdsa','fdasfdsa',0,'','pengfei1',0),(407,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:57:43','2015-01-18 20:57:43',1,33,'fdsa','fdasfdsa',0,'','pengfei1',0),(408,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:57:49','2015-01-18 20:57:49',1,32,'fdsafdsa','fdsafdsaf',0,'','pengfei1',0),(409,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:57:53','2015-01-18 20:57:53',1,31,'fdsafdsa','fdsafdsaf',0,'','pengfei1',0),(410,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:57:58','2015-01-18 20:57:58',1,29,'aa','dfds',0,'','pengfei1',0),(411,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:58:03','2015-01-18 20:58:03',1,30,'aa','dfds',0,'','pengfei1',0),(412,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:58:08','2015-01-18 20:58:08',1,28,'fdsa','fdasfdsa',0,'','pengfei1',0),(413,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:58:12','2015-01-18 20:58:12',1,27,'fdsa','fdasfdsa',0,'','pengfei1',0),(414,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:58:17','2015-01-18 20:58:17',1,26,'fdsa','fdasfsad',0,'','pengfei1',0),(415,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:58:21','2015-01-18 20:58:21',1,24,'fdsa','fdasfsad',0,'','pengfei1',0),(416,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:58:25','2015-01-18 20:58:25',1,25,'fdsa','fdasfsad',0,'','pengfei1',0),(417,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:58:29','2015-01-18 20:58:29',1,23,'fdsa','fdasfsad',0,'','pengfei1',0),(418,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:58:34','2015-01-18 20:58:34',1,22,'fdsafdsa','fdasfdsa',0,'','pengfei1',0),(419,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:58:42','2015-01-18 20:58:42',1,21,'fdsafdsa','fdasfdsa',0,'','pengfei1',0),(420,0,9,'您已取消活动。所有申请被自动取消',0,'2015-01-18 20:58:45','2015-01-18 20:58:45',1,20,'fdsafdsa','fdasfdsa',0,'','pengfei1',0),(421,0,9,'您已取消活动。所有申请被自动取消',1,'2015-01-18 20:58:49','2015-01-18 20:58:49',1,19,'fdsafdsa','fdasfdsa',0,'','pengfei1',0),(422,9,1,'abc',0,'2015-01-19 14:15:20','2015-01-19 14:15:20',3,1,'','',0,'pengfei1','小冰',0),(423,9,1,'希望能提高安全性',0,'2015-01-19 14:19:20','2015-01-19 14:19:20',3,1,'','',0,'pengfei1','小冰',0),(424,9,1,'建议增加用户诚信制度',0,'2015-01-19 14:25:49','2015-01-19 14:25:49',3,1,'','',0,'pengfei1','小冰',0),(425,9,1,'范德萨范德萨范德萨范德萨范德萨发达撒范德萨范德萨范德萨范德萨范德萨范德萨范德萨范德萨范德萨范德萨范德萨范德萨',0,'2015-01-19 14:29:34','2015-01-19 14:29:34',3,1,'','',0,'pengfei1','小冰',0),(426,9,1,'范德萨范德萨范德萨范德萨范德萨发达撒范德萨范德萨范德萨范德萨范德萨范德萨范德萨范德萨范德萨范德萨范德萨范德萨',0,'2015-01-19 14:29:57','2015-01-19 14:29:57',3,1,'','',0,'pengfei1','小冰',0),(427,9,1,'范德萨范德萨范德萨范德萨范德萨发达撒范德萨范德萨范德萨范德萨范德萨范德萨范德萨范德萨范德萨范德萨范德萨范德萨',0,'2015-01-19 14:30:04','2015-01-19 14:30:04',3,1,'','',0,'pengfei1','小冰',0),(428,9,1,NULL,0,'2015-01-21 14:09:05','2015-01-21 14:09:05',3,1,'','',0,'鹏飞','小冰',0),(429,10,9,'fdsafdsafds',0,'2015-01-21 14:37:09','2015-01-21 14:37:09',2,7,'天通苑','南山滑雪场',0,'pengfei2','',0),(430,10,9,'fdsafdsafds',0,'2015-01-21 14:37:13','2015-01-21 14:37:13',2,7,'天通苑','南山滑雪场',0,'pengfei2','pengfei1',1),(431,0,9,'您的活动有一条再次申请',0,'2015-01-21 14:37:54','2015-01-21 14:37:54',1,7,'天通苑','南山滑雪场',37,'','pengfei1',0),(432,0,10,'您已再次申请活动',1,'2015-01-21 14:37:55','2015-01-21 14:37:55',1,7,'天通苑','南山滑雪场',37,'','pengfei2',0),(433,0,10,'您已取消活动申请',0,'2015-01-21 14:41:51','2015-01-21 14:41:51',1,7,'天通苑','南山滑雪场',37,'','pengfei2',0),(434,0,9,'活动申请已被申请人取消',0,'2015-01-21 14:41:51','2015-01-21 14:41:51',1,7,'天通苑','南山滑雪场',37,'','pengfei1',0),(435,10,1,NULL,0,'2015-01-21 14:42:09','2015-01-21 14:42:09',3,1,'','',0,'pengfei2','小冰',0);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `wechat_openid` varchar(50) DEFAULT NULL,
  `wechat_unionid` varchar(50) DEFAULT NULL,
  `login` int(1) DEFAULT NULL,
  `avatar` varchar(150) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `province` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`uid`, `username`, `password`, `name`, `phone`, `wechat_openid`, `wechat_unionid`, `login`, `avatar`, `sex`, `country`, `province`, `city`) VALUES (9,'test1','test1','鹏飞','123455345435',NULL,NULL,1,'http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0','男','中国','安徽','安庆'),(10,'test2','test2','pengfei2','13455895049',NULL,NULL,1,'http://wx.qlogo.cn/mmopen/F9VJoU5pDffUmztX59JD48UAyKuuDhZc3LhbagPu44C3S5oXmiaukHAevR7f7ll45ibAsClDOjttymq2yiaGzXt8DVhhI8HzPRu/0','男','中国','安徽','安庆'),(18,'o9t8huKjCfB-Pj7aN1kxBn9s-CWI','o9t8huKjCfB-Pj7aN1kxBn9s-CWI','AAAA軒..','','okkvDuOqAJR_RvVrZkubE0xOcvvg','o9t8huKjCfB-Pj7aN1kxBn9s-CWI',1,'http://wx.qlogo.cn/mmopen/195LqnTVRKkOGoVxVPbeuUeZFiauf4VoCxqpHVagJf7noC36iaaxICvFo8mzR0U1A35HYpMOyd1oGFUzZEAHOEDw/0','1','中国','北京','朝阳');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-27 11:40:57
