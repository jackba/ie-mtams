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

-- DROP TABLE IF EXISTS "Account";
CREATE TABLE "Account" (
  "idAccount" int NOT NULL,
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
-- ORDER BY:  "idAccount"

LOCK TABLE "Account" IN EXCLUSIVE MODE;
-- INSERT INTO "Account" ("idAccount", "Account", "Password", "Salt", "DateCreated", "DateLogin") VALUES (DEFAULT,'superadmin','super','1','0000-00-00 00:00:00','0000-00-00 00:00:00');
-- INSERT INTO "Account" ("idAccount", "Account", "Password", "Salt", "DateCreated", "DateLogin") VALUES (DEFAULT,'admin','admin','1','0000-00-00 00:00:00','0000-00-00 00:00:00');
-- INSERT INTO "Account" ("idAccount", "Account", "Password", "Salt", "DateCreated", "DateLogin") VALUES (DEFAULT,'testapplicant','test','1','0000-00-00 00:00:00','0000-00-00 00:00:00');
-- INSERT INTO "Account" ("idAccount", "Account", "Password", "Salt", "DateCreated", "DateLogin") VALUES (DEFAULT,'testauthoriser','test','1','0000-00-00 00:00:00','0000-00-00 00:00:00');


-- Dump completed on 2013-04-15 22:28:43
