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

-- DROP TABLE IF EXISTS "Task";
CREATE TABLE "Task" (
  "idtasks" int NOT NULL,
  "task" varchar(45) DEFAULT NULL,
  "description" varchar(512) DEFAULT NULL,
  PRIMARY KEY ("idtasks")
);

--
-- Dumping data for table "Task"
--
-- ORDER BY:  "idtasks"

LOCK TABLE "Task" IN EXCLUSIVE MODE;
-- INSERT INTO "Task" ("idtasks", "task", "description") VALUES (DEFAULT,'Application','Travel application');
-- INSERT INTO "Task" ("idtasks", "task", "description") VALUES (DEFAULT,'Authorise','Authorise travel applications');
-- INSERT INTO "Task" ("idtasks", "task", "description") VALUES (DEFAULT,'Attach','Attach document');
-- INSERT INTO "Task" ("idtasks", "task", "description") VALUES (DEFAULT,'User','CRUD users');


-- Dump completed on 2013-04-15 22:28:43
