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
