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
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `point` int(11) DEFAULT NULL,
  `creator_id` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `major_id` int(11) DEFAULT NULL,
  `clazz_id` int(11) DEFAULT NULL,
  `type_id` int(11) NOT NULL,
  `is_template` tinyint(4) NOT NULL,
  `reference_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `feedback_des` varchar(255) DEFAULT NULL,
  `feedback_name` varchar(255) DEFAULT NULL,
  `template_des` varchar(255) DEFAULT NULL,
  `template_name` varchar(255) DEFAULT NULL,
  `is_published` tinyint(4) DEFAULT NULL,
  `semester_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Feedback_Type1_idx` (`type_id`),
  KEY `fk_Feedback_Info1_idx` (`clazz_id`),
  KEY `fk_Feedback_Major1_idx` (`major_id`),
  KEY `fk_Feedback_Course1_idx` (`course_id`),
  KEY `fk_Feedback_Department1_idx` (`department_id`),
  KEY `fk_Feedback_UserInformation1_idx` (`creator_id`),
  KEY `fk_Feedback_Feedback1_idx` (`reference_id`),
  KEY `FK6uyfvdt6pynbadr7ojqsbjyxh` (`semester_id`),
  CONSTRAINT `FK5ifya7npo8o9by8w03t3tpjv7` FOREIGN KEY (`major_id`) REFERENCES `major` (`id`),
  CONSTRAINT `FK6uyfvdt6pynbadr7ojqsbjyxh` FOREIGN KEY (`semester_id`) REFERENCES `semester` (`id`),
  CONSTRAINT `FK7wi6mvied4ds2jygaywvfrs4v` FOREIGN KEY (`clazz_id`) REFERENCES `clazz` (`id`),
  CONSTRAINT `FKau3o7f0hohmh8aookeoqb423w` FOREIGN KEY (`reference_id`) REFERENCES `feedback` (`id`),
  CONSTRAINT `FKdpfiqfk0mpmsenpdk5nh2xd1x` FOREIGN KEY (`creator_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKg0851pc63hb0u8jm2xma73q74` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`),
  CONSTRAINT `FKko7f08v61t5y67teh5jxxwrea` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `FKstj588oojtw87ntyonmbir01v` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `fk_Feedback_Course1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Feedback_Department1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Feedback_Feedback1` FOREIGN KEY (`reference_id`) REFERENCES `feedback` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Feedback_Info1` FOREIGN KEY (`clazz_id`) REFERENCES `clazz` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Feedback_Major1` FOREIGN KEY (`major_id`) REFERENCES `major` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Feedback_Type1` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Feedback_UserInformation1` FOREIGN KEY (`creator_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
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
