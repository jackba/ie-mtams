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
