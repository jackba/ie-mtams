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
