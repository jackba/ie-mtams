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
-- Table structure for table `Attachement`
--

DROP TABLE IF EXISTS `Attachement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Attachement` (
  `idAttachement` int(11) NOT NULL,
  `Discription` varchar(45) DEFAULT NULL,
  `DocumentLocation` varchar(45) DEFAULT NULL,
  `Conference_idConference` int(11) DEFAULT NULL,
  `Itinerary_idItinerary` int(11) DEFAULT NULL,
  `Approval_idApproval` int(11) DEFAULT NULL,
  `Application_idApplication` int(11) DEFAULT NULL,
  `Travel_idTravel` int(11) DEFAULT NULL,
  `FinalCosting_idFinalCosting` int(11) DEFAULT NULL,
  `CarQuotes_idCarQuotes` int(11) DEFAULT NULL,
  `Quotes_idQuotes` int(11) DEFAULT NULL,
  `AccomodationQuotes_idAccomodationQuotes` int(11) DEFAULT NULL,
  `FlightQuotes_idFlightQuotes` int(11) DEFAULT NULL,
  `TravelDocument_idTravelDocuments` int(11) DEFAULT NULL,
  `TravelerProfile_idTravelerProfile` int(11) DEFAULT NULL,
  `RewardsProgram_idRewardsProgram` int(11) DEFAULT NULL,
  `ForexOrder_idForexOrder` int(11) DEFAULT NULL,
  `Motivation_idMotivation` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAttachement`),
  KEY `fk_Attachement_Conference1` (`Conference_idConference`),
  KEY `fk_Attachement_Itinerary1` (`Itinerary_idItinerary`),
  KEY `fk_Attachement_Approval1` (`Approval_idApproval`),
  KEY `fk_Attachement_Application1` (`Application_idApplication`),
  KEY `fk_Attachement_Travel1` (`Travel_idTravel`),
  KEY `fk_Attachement_FinalCosting1` (`FinalCosting_idFinalCosting`),
  KEY `fk_Attachement_CarQuotes1` (`CarQuotes_idCarQuotes`),
  KEY `fk_Attachement_Quotes1` (`Quotes_idQuotes`),
  KEY `fk_Attachement_AccomodationQuotes1` (`AccomodationQuotes_idAccomodationQuotes`),
  KEY `fk_Attachement_FlightQuotes1` (`FlightQuotes_idFlightQuotes`),
  KEY `fk_Attachement_TravelDocument1` (`TravelDocument_idTravelDocuments`),
  KEY `fk_Attachement_TravelerProfile1` (`TravelerProfile_idTravelerProfile`),
  KEY `fk_Attachement_RewardsProgram1` (`RewardsProgram_idRewardsProgram`),
  KEY `fk_Attachement_ForexOrder1` (`ForexOrder_idForexOrder`),
  KEY `fk_Attachement_Motivation1` (`Motivation_idMotivation`),
  CONSTRAINT `fk_Attachement_Conference1` FOREIGN KEY (`Conference_idConference`) REFERENCES `Conference` (`idConference`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_Itinerary1` FOREIGN KEY (`Itinerary_idItinerary`) REFERENCES `Itinerary` (`idItinerary`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_Approval1` FOREIGN KEY (`Approval_idApproval`) REFERENCES `Approval` (`idApproval`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_Application1` FOREIGN KEY (`Application_idApplication`) REFERENCES `Application` (`idApplication`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_Travel1` FOREIGN KEY (`Travel_idTravel`) REFERENCES `Travel` (`idTravel`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_FinalCosting1` FOREIGN KEY (`FinalCosting_idFinalCosting`) REFERENCES `FinalCosting` (`idFinalCosting`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_CarQuotes1` FOREIGN KEY (`CarQuotes_idCarQuotes`) REFERENCES `CarQuotes` (`idCarQuotes`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_Quotes1` FOREIGN KEY (`Quotes_idQuotes`) REFERENCES `Quotes` (`idQuotes`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_AccomodationQuotes1` FOREIGN KEY (`AccomodationQuotes_idAccomodationQuotes`) REFERENCES `AccomodationQuotes` (`idAccomodationQuotes`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_FlightQuotes1` FOREIGN KEY (`FlightQuotes_idFlightQuotes`) REFERENCES `FlightQuotes` (`idFlightQuotes`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_TravelDocument1` FOREIGN KEY (`TravelDocument_idTravelDocuments`) REFERENCES `TravelDocument` (`idTravelDocuments`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_TravelerProfile1` FOREIGN KEY (`TravelerProfile_idTravelerProfile`) REFERENCES `TravelerProfile` (`idTravelerProfile`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_RewardsProgram1` FOREIGN KEY (`RewardsProgram_idRewardsProgram`) REFERENCES `RewardsProgram` (`idRewardsProgram`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_ForexOrder1` FOREIGN KEY (`ForexOrder_idForexOrder`) REFERENCES `ForexOrder` (`idForexOrder`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_Motivation1` FOREIGN KEY (`Motivation_idMotivation`) REFERENCES `Motivation` (`idMotivation`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Attachement`
--
-- ORDER BY:  `idAttachement`

LOCK TABLES `Attachement` WRITE;
/*!40000 ALTER TABLE `Attachement` DISABLE KEYS */;
/*!40000 ALTER TABLE `Attachement` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-04-26 19:33:02
