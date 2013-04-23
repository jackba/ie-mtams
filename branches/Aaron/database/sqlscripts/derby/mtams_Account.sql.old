CREATE DATABASE  IF NOT EXISTS `mtams` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mtams`;
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2

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
-- Table structure for table `Account`
--

DROP TABLE IF EXISTS `Account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Account` (
  `idAccount` int(11) NOT NULL,
  `Account` varchar(45) NOT NULL,
  `Password` varchar(512) NOT NULL,
  `Salt` varchar(45) DEFAULT NULL,
  `DateCreated` timestamp NULL DEFAULT NULL,
  `DateLogin` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`idAccount`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Account`
--
-- ORDER BY:  `idAccount`

LOCK TABLES `Account` WRITE;
/*!40000 ALTER TABLE `Account` DISABLE KEYS */;
INSERT INTO `Account` (`idAccount`, `Account`, `Password`, `Salt`, `DateCreated`, `DateLogin`) VALUES (1,'superadmin','super','1','0000-00-00 00:00:00','0000-00-00 00:00:00');
INSERT INTO `Account` (`idAccount`, `Account`, `Password`, `Salt`, `DateCreated`, `DateLogin`) VALUES (2,'admin','admin','1','0000-00-00 00:00:00','0000-00-00 00:00:00');
INSERT INTO `Account` (`idAccount`, `Account`, `Password`, `Salt`, `DateCreated`, `DateLogin`) VALUES (3,'testapplicant','test','1','0000-00-00 00:00:00','0000-00-00 00:00:00');
INSERT INTO `Account` (`idAccount`, `Account`, `Password`, `Salt`, `DateCreated`, `DateLogin`) VALUES (4,'testauthoriser','test','1','0000-00-00 00:00:00','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `Account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-04-15 22:28:43
