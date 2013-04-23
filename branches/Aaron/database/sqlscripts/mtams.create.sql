-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "Account"
--

-- DROP TABLE  "Account";
CREATE TABLE "Account" (
  "idAccount" int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "Account" varchar(45) NOT NULL,
  "Password" varchar(512) NOT NULL,
  "Salt" varchar(45) DEFAULT NULL,
  "DateCreated" timestamp  DEFAULT NULL,
  "DateLogin" timestamp  DEFAULT NULL,
  PRIMARY KEY ("idAccount")
);

--
-- Dumping data for table "Account"
--

-- LOCK TABLE "Account" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:55
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "CityLookup"
--

-- DROP TABLE  "CityLookup";
CREATE TABLE "CityLookup" (
  "idCityLookup" int NOT NULL,
  PRIMARY KEY ("idCityLookup")
);

--
-- Dumping data for table "CityLookup"
--

-- LOCK TABLE "CityLookup" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "Conference"
--

-- DROP TABLE  "Conference";
CREATE TABLE "Conference" (
  "idConference" int NOT NULL,
  "ConferenceName" varchar(45) DEFAULT NULL,
  "Webpage" varchar(45) DEFAULT NULL,
  "Country" varchar(45) DEFAULT NULL,
  "City" varchar(45) DEFAULT NULL,
  "Presenting" smallint DEFAULT NULL , --COMMENT Are you presenting\n,
  "PresentationTitle" varchar(45) DEFAULT NULL,
  "Authors" varchar(45) DEFAULT NULL,
  "OtherReasonAttendance" varchar(45) DEFAULT NULL,
  "DateMSAPresentation" varchar(45) DEFAULT NULL,
  "ConferenceDuration" varchar(45) DEFAULT NULL,
  "DateFrom" varchar(45) DEFAULT NULL,
  "DateTo" varchar(45) DEFAULT NULL,
  "Replacement" varchar(45) DEFAULT NULL , --COMMENT 'Do you need coverage for teaching comitments\n',
  "ReplacementArrangments" varchar(45) DEFAULT NULL,
  PRIMARY KEY ("idConference")
);

--
-- Dumping data for table "Conference"
--

-- LOCK TABLE "Conference" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:55
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "CountryLookup"
--

-- DROP TABLE  "CountryLookup";
CREATE TABLE "CountryLookup" (
  "idCountryLookup" int NOT NULL,
  PRIMARY KEY ("idCountryLookup")
);

--
-- Dumping data for table "CountryLookup"
--

-- LOCK TABLE "CountryLookup" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "LeaveLookup"
--

-- DROP TABLE  "LeaveLookup";
CREATE TABLE "LeaveLookup" (
  "idLeaveLookup" int NOT NULL,
  PRIMARY KEY ("idLeaveLookup")
);

--
-- Dumping data for table "LeaveLookup"
--

-- LOCK TABLE "LeaveLookup" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "Quotes"
--

-- DROP TABLE  "Quotes";
CREATE TABLE "Quotes" (
  "idQuotes" int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "New" varchar(45) DEFAULT NULL , --COMMENT 'New or amended\n',
  "CostCenter" varchar(45) DEFAULT NULL,
  "Discritption" varchar(45) DEFAULT NULL,
  PRIMARY KEY ("idQuotes")
);

--
-- Dumping data for table "Quotes"
--

-- LOCK TABLE "Quotes" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "Role"
--

-- DROP TABLE  "Role";
CREATE TABLE "Role" (
  "idroles" int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "role" varchar(45) NOT NULL,
  "discritption" varchar(512) DEFAULT NULL,
  PRIMARY KEY ("idroles")
);

--
-- Dumping data for table "Role"
--

-- LOCK TABLE "Role" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "Task"
--

-- DROP TABLE  "Task";
CREATE TABLE "Task" (
  "idtasks" int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "task" varchar(45) DEFAULT NULL,
  "description" varchar(512) DEFAULT NULL,
  PRIMARY KEY ("idtasks")
);

--
-- Dumping data for table "Task"
--

-- LOCK TABLE "Task" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:55
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "AccomodationQuotes"
--

-- DROP TABLE  "AccomodationQuotes";
CREATE TABLE "AccomodationQuotes" (
  "idAccomodationQuotes" int NOT NULL,
  "DateCheckin" timestamp  DEFAULT NULL,
  "DateCheckout" timestamp  DEFAULT NULL,
  "Country" varchar(45) DEFAULT NULL,
  "City" varchar(45) DEFAULT NULL,
  "Discritption" varchar(45) DEFAULT NULL,
  "AccomodationProvider" varchar(45) DEFAULT NULL,
  "QuoteSource" varchar(45) DEFAULT NULL,
  "QuoteCost" varchar(45) DEFAULT NULL,
  "Quotes_idQuotes" int NOT NULL,
  PRIMARY KEY ("idAccomodationQuotes"),
  CONSTRAINT "fk_AccomodationQuotes_Quotes1" FOREIGN KEY ("Quotes_idQuotes") REFERENCES "Quotes" ("idQuotes") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "AccomodationQuotes"
--

-- LOCK TABLE "AccomodationQuotes" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "CarQuotes"
--

-- DROP TABLE  "CarQuotes";
CREATE TABLE "CarQuotes" (
  "idCarQuotes" int NOT NULL,
  "DateCollect" timestamp  DEFAULT NULL,
  "DateReturn" timestamp  DEFAULT NULL,
  "Provider" varchar(45) DEFAULT NULL,
  "Discritption" varchar(45) DEFAULT NULL,
  "QuoteCost" varchar(45) DEFAULT NULL,
  "Quotes_idQuotes" int NOT NULL,
  PRIMARY KEY ("idCarQuotes"),
  CONSTRAINT "fk_CarQuotes_Quotes1" FOREIGN KEY ("Quotes_idQuotes") REFERENCES "Quotes" ("idQuotes") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "CarQuotes"
--

-- LOCK TABLE "CarQuotes" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "FinalCosting"
--

-- DROP TABLE  "FinalCosting";
CREATE TABLE "FinalCosting" (
  "idFinalCosting" int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "AirfareBudget" float DEFAULT NULL,
  "AirfareCost" float DEFAULT NULL,
  "CarRentalBudget" float DEFAULT NULL,
  "CarRentalCost" float DEFAULT NULL,
  "AccommodationBudget" float DEFAULT NULL,
  "AccommodationCost" float DEFAULT NULL,
  "Quotes_idQuotes" int NOT NULL,
  PRIMARY KEY ("idFinalCosting"),
  CONSTRAINT "fk_FinalCosting_Quotes1" FOREIGN KEY ("Quotes_idQuotes") REFERENCES "Quotes" ("idQuotes") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "FinalCosting"
--

-- LOCK TABLE "FinalCosting" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "FlightQuotes"
--

-- DROP TABLE  "FlightQuotes";
CREATE TABLE "FlightQuotes" (
  "idFlightQuotes" int NOT NULL,
  "FlightFrom" varchar(45) DEFAULT NULL,
  "FlightTo" varchar(45) DEFAULT NULL,
  "DateDeparture" varchar(45) DEFAULT NULL,
  "DateArrival" varchar(45) DEFAULT NULL,
  "QuoteSourceDiscription" varchar(45) DEFAULT NULL,
  "QuoteSource" varchar(45) DEFAULT NULL,
  "QuoteCost" varchar(45) DEFAULT NULL,
  "Quotes_idQuotes" int NOT NULL,
  PRIMARY KEY ("idFlightQuotes"),
  CONSTRAINT "fk_FlightQuotes_Quotes1" FOREIGN KEY ("Quotes_idQuotes") REFERENCES "Quotes" ("idQuotes") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "FlightQuotes"
--

-- LOCK TABLE "FlightQuotes" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "Session"
--

-- DROP TABLE  "Session";
CREATE TABLE "Session" (
  "idSessions" int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "accountid" int NOT NULL,
  "Date" timestamp  DEFAULT NULL,
  "Expires" timestamp  DEFAULT NULL,
  PRIMARY KEY ("idSessions","accountid"),
  CONSTRAINT "fk_Sessions_users1" FOREIGN KEY ("accountid") REFERENCES "Account" ("idAccount") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "Session"
--

-- LOCK TABLE "Session" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "TravelerProfile"
--

-- DROP TABLE  "TravelerProfile";
CREATE TABLE "TravelerProfile" (
  "idTravelerProfile" int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "AccountID" int NOT NULL,
  "StaffID" varchar(45) DEFAULT NULL,
  "GivenName" varchar(45) DEFAULT NULL,
  "FamilyName" varchar(45) DEFAULT NULL,
  "Title" varchar(45) DEFAULT NULL,
  "Department" varchar(45) DEFAULT NULL,
  "Position" varchar(45) DEFAULT NULL,
  "IDnumber" varchar(10) DEFAULT NULL,
  "AttachmentID" varchar(45) DEFAULT NULL,
  "DateCreated" timestamp  DEFAULT NULL,
  "DateModified" timestamp  DEFAULT NULL,
  "TravelBooker" varchar(45) DEFAULT NULL,
  "BusinessAddress" varchar(255) DEFAULT NULL,
  "BusinessPhone" varchar(12) DEFAULT NULL,
  "BusinessFax" varchar(12) DEFAULT NULL,
  "BusinessEmail" varchar(45) DEFAULT NULL,
  "HomeAddress" varchar(255) DEFAULT NULL,
  "HomePhone" varchar(12) DEFAULT NULL,
  "HomeEmail" varchar(45) DEFAULT NULL,
  "MobilePhone" varchar(12) DEFAULT NULL,
  "SpouseName" varchar(45) DEFAULT NULL,
  "SpouseContactNumber" varchar(45) DEFAULT NULL,
  "SpouseEmail" varchar(45) DEFAULT NULL,
  "DoctorsName" varchar(45) DEFAULT NULL,
  "DoctorsConctactNumber" varchar(45) DEFAULT NULL,
  "DoctorsEmail" varchar(45) DEFAULT NULL,
  "KnownMedicalConditions" varchar(512) DEFAULT NULL,
  "HotelPrefrences" varchar(200) DEFAULT NULL,
  "FrequentGuest" varchar(45) DEFAULT NULL,
  "NonSmoking" varchar(45) DEFAULT NULL,
  "CarPreferences" varchar(200) DEFAULT NULL,
  "RentalCompany" varchar(45) DEFAULT NULL,
  "ManualAutomatic" varchar(45) DEFAULT NULL,
  "Aircon" varchar(45) DEFAULT NULL,
  "AirlinePreferences" varchar(45) DEFAULT NULL,
  "Seating" varchar(45) DEFAULT NULL,
  "ClassDomestic" varchar(45) DEFAULT NULL,
  "ClassInternational" varchar(45) DEFAULT NULL,
  "MealRequirements" varchar(45) DEFAULT NULL,
  PRIMARY KEY ("idTravelerProfile"),
  CONSTRAINT "fk_TravelerProfile_1" FOREIGN KEY ("AccountID") REFERENCES "Account" ("idAccount") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "TravelerProfile"
--

-- LOCK TABLE "TravelerProfile" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "TravelDocument"
--

-- DROP TABLE  "TravelDocument";
CREATE TABLE "TravelDocument" (
  "idTravelDocuments" int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "PassportNumber" varchar(12) DEFAULT NULL,
  "Country" varchar(45) DEFAULT NULL,
  "DateOfIssue" timestamp  DEFAULT NULL,
  "ExpiryDate" timestamp  DEFAULT NULL,
  "ValidVisa" varchar(45) DEFAULT NULL,
  "TravlerProfile_idTravlerProfile" int NOT NULL,
  PRIMARY KEY ("idTravelDocuments"),
  CONSTRAINT "fk_TravelDocuments_TravelerProfile1" FOREIGN KEY ("TravlerProfile_idTravlerProfile") REFERENCES "TravelerProfile" ("idTravelerProfile") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "TravelDocument"
--

-- LOCK TABLE "TravelDocument" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "RewardsProgram"
--

-- DROP TABLE  "RewardsProgram";
CREATE TABLE "RewardsProgram" (
  "idRewardsProgram" int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "Description" varchar(100) DEFAULT NULL,
  "MembershipType" varchar(45) DEFAULT NULL,
  "Provider" varchar(45) DEFAULT NULL , --COMMENT 'The company the provides the rewards program',
  "MembershipNumber" varchar(45) DEFAULT NULL,
  "TravelerProfile_idTravelerProfile" int NOT NULL,
  PRIMARY KEY ("idRewardsProgram"),
  CONSTRAINT "fk_RewardsProgram_TravelerProfile1" FOREIGN KEY ("TravelerProfile_idTravelerProfile") REFERENCES "TravelerProfile" ("idTravelerProfile") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "RewardsProgram"
--

-- LOCK TABLE "RewardsProgram" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:55
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "Travel"
--

-- DROP TABLE  "Travel";
CREATE TABLE "Travel" (
  "idTravel" int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "DateDeparture" timestamp  DEFAULT NULL,
  "DateReturn" varchar(45) DEFAULT NULL,
  "Description" varchar(45) DEFAULT NULL,
  "Conference_idConference" int NOT NULL,
  PRIMARY KEY ("idTravel"),
  CONSTRAINT "fk_Travel_Conference1" FOREIGN KEY ("Conference_idConference") REFERENCES "Conference" ("idConference") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "Travel"
--

-- LOCK TABLE "Travel" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "Itinerary"
--

-- DROP TABLE  "Itinerary";
CREATE TABLE "Itinerary" (
  "idItinerary" int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "Date" varchar(45) DEFAULT NULL,
  "DateFrom" varchar(45) DEFAULT NULL,
  "DateTo" varchar(45) DEFAULT NULL,
  "LeaveType" varchar(45) DEFAULT NULL , --COMMENT 'business or other leave\n',
  "LeaveDiscritption" varchar(45) DEFAULT NULL,
  "TravelDay" varchar(45) DEFAULT NULL , --COMMENT 'or non working day\nother',
  "Travel_idTravel" int NOT NULL,
  PRIMARY KEY ("idItinerary"),
  CONSTRAINT "fk_Itinerary_Travel1" FOREIGN KEY ("Travel_idTravel") REFERENCES "Travel" ("idTravel") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "Itinerary"
--

-- LOCK TABLE "Itinerary" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "AccountRole"
--

-- DROP TABLE  "AccountRole";
CREATE TABLE "AccountRole" (
  "idUserRoles" int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "AccountID" int DEFAULT NULL,
  "RoleID" int DEFAULT NULL,
  PRIMARY KEY ("idUserRoles"),
  CONSTRAINT "fk_UserRoles_1" FOREIGN KEY ("RoleID") REFERENCES "Role" ("idroles") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_UserRoles_2" FOREIGN KEY ("AccountID") REFERENCES "Account" ("idAccount") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "AccountRole"
--

-- LOCK TABLE "AccountRole" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "Permission"
--

-- DROP TABLE  "Permission";
CREATE TABLE "Permission" (
  "idpermissions" int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "Permission" varchar(45) DEFAULT NULL,
  "Discritption" varchar(45) DEFAULT NULL,
  "CreatePerm" smallint DEFAULT 1,
  "DeletePerm" smallint DEFAULT 1,
  "UpdatePerm" smallint DEFAULT 1,
  "ReadPerm" smallint DEFAULT 0,
  "GrantPerm" smallint DEFAULT 1,
  "tasks_idtasks" int NOT NULL,
  "roles_idroles" int NOT NULL,
  PRIMARY KEY ("idpermissions"),
  CONSTRAINT "fk_permissions_tasks1" FOREIGN KEY ("tasks_idtasks") REFERENCES "Task" ("idtasks") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_permissions_roles1" FOREIGN KEY ("roles_idroles") REFERENCES "Role" ("idroles") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "Permission"
--

-- LOCK TABLE "Permission" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "Application"
--

-- DROP TABLE  "Application";
CREATE TABLE "Application" (
  "idApplication" int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "Description" varchar(100) DEFAULT NULL,
  "TravelerProfile_idTravelerProfile" int NOT NULL,
  "Quotes_idQuotes" int NOT NULL,
  "FinalCosting_idFinalCosting" int NOT NULL,
  "Travel_idTravel" int NOT NULL,
  "Account_idAccount" int NOT NULL,
  PRIMARY KEY ("idApplication"),
  CONSTRAINT "fk_Application_TravelerProfile1" FOREIGN KEY ("TravelerProfile_idTravelerProfile") REFERENCES "TravelerProfile" ("idTravelerProfile") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Application_Quotes1" FOREIGN KEY ("Quotes_idQuotes") REFERENCES "Quotes" ("idQuotes") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Application_FinalCosting1" FOREIGN KEY ("FinalCosting_idFinalCosting") REFERENCES "FinalCosting" ("idFinalCosting") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Application_Travel1" FOREIGN KEY ("Travel_idTravel") REFERENCES "Travel" ("idTravel") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Application_Account1" FOREIGN KEY ("Account_idAccount") REFERENCES "Account" ("idAccount") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "Application"
--

-- LOCK TABLE "Application" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "Approval"
--

-- DROP TABLE  "Approval";
CREATE TABLE "Approval" (
  "idApproval" int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "SectionApproved" int DEFAULT NULL,
  "Notes" varchar(200) DEFAULT NULL,
  "Date" varchar(45) DEFAULT NULL,
  "Application_idApplication" int NOT NULL,
  "Account_idAccount" int NOT NULL,
  PRIMARY KEY ("idApproval"),
  CONSTRAINT "fk_Approval_Application1" FOREIGN KEY ("Application_idApplication") REFERENCES "Application" ("idApplication") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Approval_Account1" FOREIGN KEY ("Account_idAccount") REFERENCES "Account" ("idAccount") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "Approval"
--

-- LOCK TABLE "Approval" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:56
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "Attachement"
--

-- DROP TABLE  "Attachement";
CREATE TABLE "Attachement" (
  "idAttachement" int NOT NULL,
  "Discription" varchar(45) DEFAULT NULL,
  "DocumentLocation" varchar(45) DEFAULT NULL,
  "Conference_idConference" int NOT NULL,
  "Itinerary_idItinerary" int NOT NULL,
  "Approval_idApproval" int NOT NULL,
  "Application_idApplication" int NOT NULL,
  "Travel_idTravel" int NOT NULL,
  "FinalCosting_idFinalCosting" int NOT NULL,
  "CarQuotes_idCarQuotes" int NOT NULL,
  "Quotes_idQuotes" int NOT NULL,
  "AccomodationQuotes_idAccomodationQuotes" int NOT NULL,
  "FlightQuotes_idFlightQuotes" int NOT NULL,
  "TravelDocument_idTravelDocuments" int NOT NULL,
  "TravelerProfile_idTravelerProfile" int NOT NULL,
  "RewardsProgram_idRewardsProgram" int NOT NULL,
  PRIMARY KEY ("idAttachement"),
  CONSTRAINT "fk_Attachement_Conference1" FOREIGN KEY ("Conference_idConference") REFERENCES "Conference" ("idConference") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Attachement_Itinerary1" FOREIGN KEY ("Itinerary_idItinerary") REFERENCES "Itinerary" ("idItinerary") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Attachement_Approval1" FOREIGN KEY ("Approval_idApproval") REFERENCES "Approval" ("idApproval") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Attachement_Application1" FOREIGN KEY ("Application_idApplication") REFERENCES "Application" ("idApplication") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Attachement_Travel1" FOREIGN KEY ("Travel_idTravel") REFERENCES "Travel" ("idTravel") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Attachement_FinalCosting1" FOREIGN KEY ("FinalCosting_idFinalCosting") REFERENCES "FinalCosting" ("idFinalCosting") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Attachement_CarQuotes1" FOREIGN KEY ("CarQuotes_idCarQuotes") REFERENCES "CarQuotes" ("idCarQuotes") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Attachement_Quotes1" FOREIGN KEY ("Quotes_idQuotes") REFERENCES "Quotes" ("idQuotes") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Attachement_AccomodationQuotes1" FOREIGN KEY ("AccomodationQuotes_idAccomodationQuotes") REFERENCES "AccomodationQuotes" ("idAccomodationQuotes") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Attachement_FlightQuotes1" FOREIGN KEY ("FlightQuotes_idFlightQuotes") REFERENCES "FlightQuotes" ("idFlightQuotes") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Attachement_TravelDocument1" FOREIGN KEY ("TravelDocument_idTravelDocuments") REFERENCES "TravelDocument" ("idTravelDocuments") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Attachement_TravelerProfile1" FOREIGN KEY ("TravelerProfile_idTravelerProfile") REFERENCES "TravelerProfile" ("idTravelerProfile") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Attachement_RewardsProgram1" FOREIGN KEY ("RewardsProgram_idRewardsProgram") REFERENCES "RewardsProgram" ("idRewardsProgram") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "Attachement"
--

-- LOCK TABLE "Attachement" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-23 11:47:55
