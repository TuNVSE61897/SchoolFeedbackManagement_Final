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
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `major` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `reference_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Major_Major1_idx` (`reference_id`),
  CONSTRAINT `FK8vnonctyxkaieiyu1gmtcaxfg` FOREIGN KEY (`reference_id`) REFERENCES `major` (`id`),
  CONSTRAINT `fk_Major_Major1` FOREIGN KEY (`reference_id`) REFERENCES `major` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major`
--

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
INSERT INTO `major` VALUES (1,'SE','Kĩ thuật phần mềm',NULL),(2,'IA','An toàn thông tin',NULL),(3,'SB','Quản trị kinh doanh',NULL),(4,'','Tài chính - Ngân hàng',NULL),(5,'','Thiết kế đồ họa',NULL),(6,'','Ngôn ngữ Anh',NULL),(7,'','Ngôn ngữ Nhật',NULL),(8,'','Miscellaneous',NULL),(9,'','General Management',NULL),(10,'','Economics',NULL),(11,'','Finance',NULL),(12,'','Soft Skill',NULL),(13,'','Banking',NULL),(14,'','Maketing',NULL),(15,'','Computing Fundamentals',1),(16,'','Information Assurance',2),(17,'','Accounting',NULL),(18,'','Faculty Research',NULL),(19,'','English',NULL),(20,'','Software Engineering',1),(21,'','Japanese',7),(22,'','Chinese',3),(23,'','Chính Trị',NULL),(24,'','Graphic Design',NULL),(25,'','Mathematics',NULL),(26,'','Trainning',NULL),(27,'IS','Hệ thống thông tin',1),(28,'JS','Kỹ sư cầu nối Nhật Bản',1),(29,'ES','Hệ thống Nhúng',1);
/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-05 10:58:57
