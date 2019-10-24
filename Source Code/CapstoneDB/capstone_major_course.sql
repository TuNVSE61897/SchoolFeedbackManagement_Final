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
-- Table structure for table `major_course`
--

DROP TABLE IF EXISTS `major_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `major_course` (
  `major_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`major_id`,`course_id`),
  KEY `fk_major_has_course_course1_idx` (`course_id`),
  KEY `fk_major_has_course_major1_idx` (`major_id`),
  CONSTRAINT `FK44j7ppxaywgojeimay9gmph0k` FOREIGN KEY (`major_id`) REFERENCES `major` (`id`),
  CONSTRAINT `FKo5iwuqbrq1wrirs4qvq0239q` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `fk_major_has_course_course1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_major_has_course_major1` FOREIGN KEY (`major_id`) REFERENCES `major` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major_course`
--

LOCK TABLES `major_course` WRITE;
/*!40000 ALTER TABLE `major_course` DISABLE KEYS */;
INSERT INTO `major_course` VALUES (9,11),(9,12),(10,13),(10,14),(11,15),(11,16),(12,17),(12,18),(13,19),(14,20),(14,21),(15,1),(15,2),(15,3),(15,4),(15,5),(15,7),(15,8),(15,9),(15,10),(16,22),(16,23),(17,24),(19,25),(20,26),(20,27),(20,28),(20,29),(20,30),(21,31),(21,32),(21,33),(21,34),(21,35),(21,36),(21,37),(21,38),(21,39),(22,40),(22,41),(23,42),(23,43),(24,44),(24,45),(25,46),(25,47);
/*!40000 ALTER TABLE `major_course` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-05 10:59:02
