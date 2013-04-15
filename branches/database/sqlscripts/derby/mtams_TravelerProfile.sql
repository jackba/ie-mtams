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

-- DROP TABLE IF EXISTS "TravelerProfile";
CREATE TABLE "TravelerProfile" (
  "idTravelerProfile" int NOT NULL,
  "AccountID" int NOT NULL,
  "GivenName" varchar(45) DEFAULT NULL,
  "FamilyName" varchar(45) DEFAULT NULL,
  "Title" varchar(45) DEFAULT NULL,
  "Department" varchar(45) DEFAULT NULL,
  "Position" varchar(45) DEFAULT NULL,
  "TravelBooker" varchar(45) DEFAULT NULL,
  "IDnumber" varchar(10) DEFAULT NULL,
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
  "AttachmentID" varchar(45) DEFAULT NULL,
  "DateCreated" timestamp  DEFAULT NULL,
  "DateModified" timestamp  DEFAULT NULL,
  PRIMARY KEY ("idTravelerProfile"),
);

--
-- Dumping data for table "TravelerProfile"
--
-- ORDER BY:  "idTravelerProfile"

LOCK TABLE "TravelerProfile" IN EXCLUSIVE MODE;
-- INSERT INTO "TravelerProfile" ("idTravelerProfile", "AccountID", "GivenName", "FamilyName", "Title", "Department", "Position", "TravelBooker", "IDnumber", "BusinessAddress", "BusinessPhone", "BusinessFax", "BusinessEmail", "HomeAddress", "HomePhone", "HomeEmail", "MobilePhone", "SpouseName", "SpouseContactNumber", "SpouseEmail", "DoctorsName", "DoctorsConctactNumber", "DoctorsEmail", "KnownMedicalConditions", "AttachmentID", "DateCreated", "DateModified") VALUES (DEFAULT,3,'Test','Test','Test',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);


-- Dump completed on 2013-04-15 22:28:44
