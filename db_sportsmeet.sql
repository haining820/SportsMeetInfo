-- MySQL dump 10.13  Distrib 5.6.48, for Win32 (AMD64)
--
-- Host: localhost    Database: db_sportsmeet
-- ------------------------------------------------------
-- Server version	5.6.48-log

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
-- Table structure for table `s_admin`
--

DROP TABLE IF EXISTS `s_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_admin` (
  `admin_id` int(5) NOT NULL,
  `admin_name` varchar(32) DEFAULT NULL,
  `admin_password` varchar(32) DEFAULT NULL,
  `admin_createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_admin`
--

LOCK TABLES `s_admin` WRITE;
/*!40000 ALTER TABLE `s_admin` DISABLE KEYS */;
INSERT INTO `s_admin` VALUES (1,'yhy','666','2020-06-04 23:19:54'),(2,'dsm','888','2020-06-05 01:02:56');
/*!40000 ALTER TABLE `s_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_athlete`
--

DROP TABLE IF EXISTS `s_athlete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_athlete` (
  `athlete_id` int(5) NOT NULL AUTO_INCREMENT,
  `athlete_studentnumber` varchar(32) NOT NULL,
  `athlete_name` varchar(32) NOT NULL,
  `athlete_divisionId` int(5) NOT NULL,
  `athlete_password` varchar(32) NOT NULL,
  `athlete_sex` varchar(32) NOT NULL,
  PRIMARY KEY (`athlete_id`),
  KEY `division_foreignkey` (`athlete_divisionId`),
  CONSTRAINT `division_foreignkey` FOREIGN KEY (`athlete_divisionId`) REFERENCES `s_division` (`division_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_athlete`
--

LOCK TABLES `s_athlete` WRITE;
/*!40000 ALTER TABLE `s_athlete` DISABLE KEYS */;
INSERT INTO `s_athlete` VALUES (5,'20181001235','于海洋',16,'666','男'),(6,'20181005489','王丑鬼',21,'2434','男'),(7,'20181001651','仁茂林',18,'594ff','男'),(11,'20181004549','周杰伦',6,'232434','女'),(12,'20101005546','蔡徐坤',22,'32322','女'),(13,'20154004578','王力宏',6,'23424','男'),(16,'20140089888','陈奕迅',6,'233kk','男'),(18,'20157894555','董思邈',21,'333','男');
/*!40000 ALTER TABLE `s_athlete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_division`
--

DROP TABLE IF EXISTS `s_division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_division` (
  `division_id` int(5) NOT NULL AUTO_INCREMENT,
  `division_name` varchar(255) DEFAULT NULL,
  `division_no` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`division_id`) USING BTREE,
  KEY `division_name` (`division_name`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_division`
--

LOCK TABLES `s_division` WRITE;
/*!40000 ALTER TABLE `s_division` DISABLE KEYS */;
INSERT INTO `s_division` VALUES (1,'地学院','0101-0199'),(2,'资源学院','0201-0299'),(3,'材化学院','0301-0399'),(6,'地空学院','0601-0699'),(7,'海洋学院','0701-0799'),(8,'机电学院','0801-0899'),(9,'自动化学院','0901-0999'),(10,'经管学院','1001-1099'),(12,'地信学院','1201-1299'),(13,'数理学院','1301-1399'),(14,'珠宝学院','1401-1499'),(15,'公管学院','1501-1599'),(16,'计算机学院','1601-1699'),(17,'体育学院','1701-1799'),(18,'艺媒学院','1801-1899'),(20,'李四光学院','2001-2099'),(21,'高教所','2101-2199'),(22,'国教院','2201-2299'),(23,'国重实验室','2301-2399');
/*!40000 ALTER TABLE `s_division` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_event`
--

DROP TABLE IF EXISTS `s_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_event` (
  `event_id` int(5) NOT NULL AUTO_INCREMENT,
  `event_name` varchar(32) DEFAULT NULL,
  `event_judge` varchar(32) DEFAULT NULL,
  `event_max_athlete_num` int(3) NOT NULL,
  `event_selected_num` int(3) DEFAULT '0',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_event`
--

LOCK TABLES `s_event` WRITE;
/*!40000 ALTER TABLE `s_event` DISABLE KEYS */;
INSERT INTO `s_event` VALUES (1,'男子100米','刘翔',10,4),(2,'男子200米','刘德华',12,2),(4,'男子3000米','马云',50,2),(11,'男子800米','刘翔',3,3),(12,'女子100米','马云',10,0),(13,'女子800米','彭于晏',10,0),(14,'女子跳高','张国伟',4,0),(15,'男子跳远','张国伟',10,0);
/*!40000 ALTER TABLE `s_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_selectedevent`
--

DROP TABLE IF EXISTS `s_selectedevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_selectedevent` (
  `selectedEvent_id` int(5) NOT NULL AUTO_INCREMENT,
  `selectedEvent_athleteId` int(5) NOT NULL,
  `selectedEvent_eventId` int(5) NOT NULL,
  PRIMARY KEY (`selectedEvent_id`),
  KEY `athlete_foreign` (`selectedEvent_athleteId`),
  KEY `event_foreign` (`selectedEvent_eventId`),
  CONSTRAINT `athlete_foreign` FOREIGN KEY (`selectedEvent_athleteId`) REFERENCES `s_athlete` (`athlete_id`),
  CONSTRAINT `event_foreign` FOREIGN KEY (`selectedEvent_eventId`) REFERENCES `s_event` (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_selectedevent`
--

LOCK TABLES `s_selectedevent` WRITE;
/*!40000 ALTER TABLE `s_selectedevent` DISABLE KEYS */;
INSERT INTO `s_selectedevent` VALUES (1,16,1),(3,7,1),(4,7,2),(6,12,2),(12,5,11),(13,11,11),(14,16,11),(15,18,4),(17,5,4);
/*!40000 ALTER TABLE `s_selectedevent` ENABLE KEYS */;
UNLOCK TABLES;
