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
