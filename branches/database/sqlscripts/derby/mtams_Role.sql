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

-- DROP TABLE IF EXISTS "Role";
CREATE TABLE "Role" (
  "idroles" int NOT NULL,
  "role" varchar(45) NOT NULL,
  "discritption" varchar(512) DEFAULT NULL,
  PRIMARY KEY ("idroles")
);

--
-- Dumping data for table "Role"
--
-- ORDER BY:  "idroles"

LOCK TABLE "Role" IN EXCLUSIVE MODE;
-- INSERT INTO "Role" ("idroles", "role", "discritption") VALUES (DEFAULT,'Super Admin','Full access to all functions');
-- INSERT INTO "Role" ("idroles", "role", "discritption") VALUES (DEFAULT,'Admin','Admin functions only can not create applications');
-- INSERT INTO "Role" ("idroles", "role", "discritption") VALUES (DEFAULT,'Applicant','Can only create application');
-- INSERT INTO "Role" ("idroles", "role", "discritption") VALUES (DEFAULT,'Authorisor','Can authorise applications');
-- INSERT INTO "Role" ("idroles", "role", "discritption") VALUES (DEFAULT,'Test','No login required');


-- Dump completed on 2013-04-15 22:28:44
