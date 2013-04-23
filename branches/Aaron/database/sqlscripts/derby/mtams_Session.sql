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
