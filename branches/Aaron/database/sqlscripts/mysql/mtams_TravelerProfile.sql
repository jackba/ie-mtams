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
-- Table structure for table `TravelerProfile`
--

DROP TABLE IF EXISTS `TravelerProfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TravelerProfile` (
  `idTravelerProfile` int(11) NOT NULL AUTO_INCREMENT,
  `AccountID` int(11) NOT NULL,
  `StaffID` varchar(45) DEFAULT NULL,
  `GivenName` varchar(45) DEFAULT NULL,
  `FamilyName` varchar(45) DEFAULT NULL,
  `Title` varchar(45) DEFAULT NULL,
  `Department` varchar(45) DEFAULT NULL,
  `Position` varchar(45) DEFAULT NULL,
  `IDnumber` varchar(10) DEFAULT NULL,
  `AttachmentID` varchar(45) DEFAULT NULL,
  `DateCreated` timestamp NULL DEFAULT NULL,
  `DateModified` timestamp NULL DEFAULT NULL,
  `TravelBooker` varchar(45) DEFAULT NULL,
  `BusinessAddress` varchar(255) DEFAULT '144 Peter Road, Ruimsig, Johannesburg, South Africa',
  `BusinessPhone` varchar(12) DEFAULT NULL,
  `BusinessFax` varchar(12) DEFAULT NULL,
  `BusinessEmail` varchar(45) DEFAULT NULL,
  `HomeAddress` varchar(255) DEFAULT NULL,
  `HomePhone` varchar(12) DEFAULT NULL,
  `HomeEmail` varchar(45) DEFAULT NULL,
  `MobilePhone` varchar(12) DEFAULT NULL,
  `SpouseName` varchar(45) DEFAULT NULL,
  `SpouseContactNumber` varchar(45) DEFAULT NULL,
  `SpouseEmail` varchar(45) DEFAULT NULL,
  `DoctorsName` varchar(45) DEFAULT NULL,
  `DoctorsConctactNumber` varchar(45) DEFAULT NULL,
  `DoctorsEmail` varchar(45) DEFAULT NULL,
  `KnownMedicalConditions` varchar(512) DEFAULT NULL,
  `HotelPrefrences` varchar(200) DEFAULT NULL,
  `FrequentGuest` varchar(45) DEFAULT NULL,
  `NonSmoking` varchar(45) DEFAULT NULL,
  `CarPreferences` varchar(200) DEFAULT NULL,
  `RentalCompany` varchar(45) DEFAULT NULL,
  `ManualAutomatic` varchar(45) DEFAULT NULL,
  `Aircon` varchar(45) DEFAULT NULL,
  `AirlinePreferences` varchar(45) DEFAULT NULL,
  `Seating` varchar(45) DEFAULT NULL,
  `ClassDomestic` varchar(45) DEFAULT NULL,
  `ClassInternational` varchar(45) DEFAULT NULL,
  `MealRequirements` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTravelerProfile`),
  KEY `fk_TravlerProfile_users1_idx` (`AccountID`),
  KEY `fk_TravelerProfile_1` (`AccountID`),
  CONSTRAINT `fk_TravelerProfile_1` FOREIGN KEY (`AccountID`) REFERENCES `Account` (`idAccount`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Details of staff member / applicant';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TravelerProfile`
--
-- ORDER BY:  `idTravelerProfile`

LOCK TABLES `TravelerProfile` WRITE;
/*!40000 ALTER TABLE `TravelerProfile` DISABLE KEYS */;
/*!40000 ALTER TABLE `TravelerProfile` ENABLE KEYS */;
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
