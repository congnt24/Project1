CREATE DATABASE  IF NOT EXISTS `salemanaging` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `salemanaging`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: salemanaging
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `hoadonxuat`
--

DROP TABLE IF EXISTS `hoadonxuat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hoadonxuat` (
  `mahoadonxuat` int(11) NOT NULL AUTO_INCREMENT,
  `ngaytra` date DEFAULT NULL,
  `sotienconlai` int(11) DEFAULT NULL,
  `sotiendatra` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `mahanghoa` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`mahoadonxuat`),
  KEY `id` (`id`),
  KEY `mahanghoa` (`mahanghoa`),
  CONSTRAINT `hoadonxuat_ibfk_1` FOREIGN KEY (`id`) REFERENCES `khachhang` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `hoadonxuat_ibfk_2` FOREIGN KEY (`mahanghoa`) REFERENCES `kho` (`mahanghoa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadonxuat`
--

LOCK TABLES `hoadonxuat` WRITE;
/*!40000 ALTER TABLE `hoadonxuat` DISABLE KEYS */;
INSERT INTO `hoadonxuat` VALUES (1,'2014-10-23',10000,1,1,5,1),(2,NULL,20000,100000,2,5,1),(3,'2014-10-23',10000,2,1,5,1),(4,'2014-10-23',10000,2,1,5,1);
/*!40000 ALTER TABLE `hoadonxuat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-23 23:14:00
