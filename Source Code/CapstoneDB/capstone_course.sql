-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: capstone
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.19-MariaDB

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'C# & Dot Net','PRN292'),(2,'Object-Oriented Paradigm using Java - PRO192','PRO192'),(3,'Programming Fundamentals Using C','PRF192'),(4,'Front-end web development','PRO201'),(5,'Alice','PRO001'),(6,'Applied Graphic Design','GDP101'),(7,'Introduction to Computing','CSI101'),(8,'Desktop Java Applications','PRJ311'),(9,'Computer Organization and Architecture','CEA201'),(10,'Data Structure and Algorithm','CSD201'),(11,'Business Law Fundamentals','LAW101'),(12,'E-Commerce for Business','ISC302'),(13,'Basic Macroeconomics','ECO121'),(14,'Micro economics','ECO101'),(15,'Principles Of Corporate Finance','FIN202'),(16,'Advanced Corporate Finance','FIN303'),(17,'Working in Groups','SSG101'),(18,'Business Communication','SSC102'),(19,'Bank Management','BKG301'),(20,'Principles of Marketing','MKT101'),(21,'Digital Marketing','MKT308'),(22,'Ethical Hacking and Offensive Security','HOD401'),(23,'Intelligence Analysis','IAA301'),(24,'Principles of Accounting ','ACC101'),(25,'Summit 1','ENT401'),(26,'Database Warehouse','DBW301'),(27,'Capstone Project','SWP49X'),(28,'E-Commerce','ISC301'),(29,'Mobile Programming','PRM391'),(30,'XML','PRX301'),(31,'Japanese Language 1.1 - Dekiru','JPD111'),(32,'Japanese Language 1.2 - Dekiru','JPD121'),(33,'Japanese Language 1.3 - Dekiru','JPD131'),(34,'Japanese Language 1.4 - Dekiru','JPD141'),(35,'Japanese Language 1.5 - Dekiru','JPD151'),(36,'IT JAPANESE','JIT301'),(37,'Tiếng Nhật sơ cấp 1.1 (Chương trình cử nhân ngôn ngữ Nhật)','JPD112'),(38,'Japanese Language 1.2','JPS122'),(39,'Tiếng Nhật sơ cấp 1.2 (Chương trình cử nhân ngôn ngữ Nhật)','JPD122'),(40,'Chinese Elementary 1','CHN111'),(41,'Chinese Elementary 1','CHN122'),(42,'Đường lối cách mạng của Đảng cộng sản Việt Nam','VNR201'),(43,'Những nguyên lý cơ bản của Chủ nghĩa Mác-Lênin','MLN101'),(44,'Drawing - Speed drawing','DRD201'),(45,'Visual Principles /Nguyên Lý Thị Giác','VCM201'),(46,'Discrete Mathematics','MAD101'),(47,'Mathematics for Engineering','MAE101');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-05 10:58:59
