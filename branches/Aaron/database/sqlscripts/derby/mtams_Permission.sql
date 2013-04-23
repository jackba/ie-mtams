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
