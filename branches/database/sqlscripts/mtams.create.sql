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

-- DROP TABLE IF EXISTS "AccountRole";
CREATE TABLE "AccountRole" (
  "idUserRoles" int NOT NULL,
  "AccountID" int DEFAULT NULL,
  "RoleID" int DEFAULT NULL,
  PRIMARY KEY ("idUserRoles"),
  CONSTRAINT "fk_UserRoles_1" FOREIGN KEY ("RoleID") REFERENCES "Role" ("idroles") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_UserRoles_2" FOREIGN KEY ("AccountID") REFERENCES "Account" ("idAccount") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "AccountRole"
--
-- ORDER BY:  "idUserRoles"

LOCK TABLE "AccountRole" IN EXCLUSIVE MODE;
-- INSERT INTO "AccountRole" ("idUserRoles", "AccountID", "RoleID") VALUES (DEFAULT,1,1);
-- INSERT INTO "AccountRole" ("idUserRoles", "AccountID", "RoleID") VALUES (DEFAULT,2,2);
-- INSERT INTO "AccountRole" ("idUserRoles", "AccountID", "RoleID") VALUES (DEFAULT,3,5);


-- Dump completed on 2013-04-15 22:28:43
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

-- DROP TABLE IF EXISTS "Permission";
CREATE TABLE "Permission" (
  "idpermissions" int NOT NULL,
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
-- ORDER BY:  "idpermissions"

LOCK TABLE "Permission" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-15 22:28:43
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

-- DROP TABLE IF EXISTS "Session";
CREATE TABLE "Session" (
  "idSessions" int NOT NULL,
  "accountid" int NOT NULL,
  "Date" timestamp  DEFAULT NULL,
  "Expires" timestamp  DEFAULT NULL,
  PRIMARY KEY ("idSessions","accountid"),
  CONSTRAINT "fk_Sessions_users1" FOREIGN KEY ("accountid") REFERENCES "Account" ("idAccount") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "Session"
--
-- ORDER BY:  "idSessions","accountid"

LOCK TABLE "Session" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-15 22:28:43
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
-- CREATE SCHEMA "mtams" ;
-- SET SCHEMA  "mtams";
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mtams
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.04.2


--
-- Table structure for table "TravelDocument"
--

-- DROP TABLE IF EXISTS "TravelDocument";
CREATE TABLE "TravelDocument" (
  "idTravelDocuments" int NOT NULL,
  "PassportNumber" varchar(12) DEFAULT NULL,
  "Country" varchar(45) DEFAULT NULL,
  "DateOfIssue" timestamp  DEFAULT NULL,
  "ExpiryDate" timestamp  DEFAULT NULL,
  "ValidVisa" varchar(45) DEFAULT NULL,
  "TravlerProfile_idTravlerProfile" int NOT NULL,
  PRIMARY KEY ("idTravelDocuments"),
  CONSTRAINT "fk_TravelDocuments_TravelerProfile1" FOREIGN KEY ("TravlerProfile_idTravlerProfile") REFERENCES "TravelerProfile" ("idTravelerProfile") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table "TravelDocument"
--
-- ORDER BY:  "idTravelDocuments"

LOCK TABLE "TravelDocument" IN EXCLUSIVE MODE;


-- Dump completed on 2013-04-15 22:28:43
