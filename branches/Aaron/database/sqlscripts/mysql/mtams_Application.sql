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
-- Table structure for table `Application`
--

DROP TABLE IF EXISTS `Application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Application` (
  `idApplication` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(100) DEFAULT NULL,
  `TravelerProfile_idTravelerProfile` int(11) NOT NULL,
  `Quotes_idQuotes` int(11) NOT NULL,
  `FinalCosting_idFinalCosting` int(11) NOT NULL,
  `Travel_idTravel` int(11) NOT NULL,
  `Account_idAccount` int(11) NOT NULL,
  `ForexOrder_idForexOrder` int(11) NOT NULL,
  `Motivation_idMotivation` int(11) NOT NULL,
  `DateModified` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`idApplication`),
  KEY `fk_Application_TravelerProfile1` (`TravelerProfile_idTravelerProfile`),
  KEY `fk_Application_Quotes1` (`Quotes_idQuotes`),
  KEY `fk_Application_FinalCosting1` (`FinalCosting_idFinalCosting`),
  KEY `fk_Application_Travel1` (`Travel_idTravel`),
  KEY `fk_Application_Account1` (`Account_idAccount`),
  KEY `fk_Application_ForexOrder1` (`ForexOrder_idForexOrder`),
  KEY `fk_Application_Motivation1` (`Motivation_idMotivation`),
  CONSTRAINT `fk_Application_TravelerProfile1` FOREIGN KEY (`TravelerProfile_idTravelerProfile`) REFERENCES `TravelerProfile` (`idTravelerProfile`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Application_Quotes1` FOREIGN KEY (`Quotes_idQuotes`) REFERENCES `Quotes` (`idQuotes`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Application_Account1` FOREIGN KEY (`Account_idAccount`) REFERENCES `Account` (`idAccount`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Application_ForexOrder1` FOREIGN KEY (`ForexOrder_idForexOrder`) REFERENCES `ForexOrder` (`idForexOrder`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Application_Motivation1` FOREIGN KEY (`Motivation_idMotivation`) REFERENCES `Motivation` (`idMotivation`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Application_FinalCosting1` FOREIGN KEY (`FinalCosting_idFinalCosting`) REFERENCES `FinalCosting` (`idFinalCosting`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Application_Travel1` FOREIGN KEY (`Travel_idTravel`) REFERENCES `Travel` (`idTravel`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Application`
--
-- ORDER BY:  `idApplication`

LOCK TABLES `Application` WRITE;
/*!40000 ALTER TABLE `Application` DISABLE KEYS */;
/*!40000 ALTER TABLE `Application` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-04-26 19:33:03
