CREATE SCHEMA "MTAMS" ;

SET SCHEMA  "MTAMS";
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "ACCOUNT"
--
-- DROP TABLE  "ACCOUNT";
CREATE TABLE "ACCOUNT" (
  "IDACCOUNT" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "USERNAME" VARCHAR(45) NOT NULL,
  "PASSWORD" VARCHAR(512) NOT NULL,
  "SALT" VARCHAR(45) DEFAULT NULL,
  "DATECREATED" TIMESTAMP  DEFAULT NULL,
  "DATELOGIN" TIMESTAMP  DEFAULT NULL,
  PRIMARY KEY ("IDACCOUNT")
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "CONFERENCE"
--
-- DROP TABLE  "CONFERENCE";
CREATE TABLE "CONFERENCE" (
  "IDCONFERENCE" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "CONFERENCENAME" VARCHAR(45) DEFAULT NULL,
  "WEBPAGE" VARCHAR(45) DEFAULT NULL,
  "COUNTRY" VARCHAR(45) DEFAULT NULL,
  "CITY" VARCHAR(45) DEFAULT NULL,
  "PRESENTING" INT DEFAULT NULL , --COMMENT ARE YOU PRESENTING\N,
  "PRESENTATIONTITLE" VARCHAR(45) DEFAULT NULL,
  "AUTHORS" VARCHAR(45) DEFAULT NULL,
  "OTHERREASONATTENDANCE" VARCHAR(45) DEFAULT NULL,
  "DATEMSAPRESENTATION" TIMESTAMP  DEFAULT NULL,
  "CONFERENCEDURATION" INT DEFAULT NULL,
  "DATEFROM" TIMESTAMP  DEFAULT NULL,
  "DATETO" TIMESTAMP  DEFAULT NULL,
  "REPLACEMENT" VARCHAR(45) DEFAULT NULL , --COMMENT 'DO YOU NEED COVERAGE FOR TEACHING COMITMENTS\N',
  "REPLACEMENTARRANGMENTS" VARCHAR(45) DEFAULT NULL,
  "FUNDINGSOURCES"  VARCHAR(45) DEFAULT NULL,
  "OTHERFUNDINGSOURCES" VARCHAR(45) DEFAULT NULL,
  "FUNDNAME" VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY ("IDCONFERENCE")
);
--
-- ------------------------------------------------------
-- TABLE STRUCTURE FOR TABLE "DEPARTMENT"
--
-- DROP TABLE  "DEPARTMENT";
CREATE TABLE "DEPARTMENT" (
  "DEPARTMENT" VARCHAR(45) NOT NULL DEFAULT 'ADMINISTRATION',
  "IDDEPARTMENT" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  PRIMARY KEY ("IDDEPARTMENT")
);
--
-- ------------------------------------------------------
--
--
-- TABLE STRUCTURE FOR TABLE "ACCOUNTDEPARTMENT"
--
CREATE TABLE "ACCOUNTDEPARTMENT" (
  "IDACCOUNTDEPARTMENT" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),  
  "IDACCOUNT" INT NOT NULL,
  "IDDEPARTMENT" INT NOT NULL,
  "DEPARTMENTROLE" INT NOT NULL DEFAULT 0,
  PRIMARY KEY ("IDACCOUNTDEPARTMENT"),
  CONSTRAINT "FK_ACCOUNTDEPRTMENT_DEPARTMENT" FOREIGN KEY ("IDDEPARTMENT") REFERENCES "DEPARTMENT" ("IDDEPARTMENT")  ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ACCOUNTDEPRTMENT_ACCOUNT" FOREIGN KEY ("IDACCOUNT") REFERENCES "ACCOUNT" ("IDACCOUNT") ON DELETE NO ACTION ON UPDATE NO ACTION
);
--
-- ------------------------------------------------------
-- TABLE STRUCTURE FOR TABLE "MESSAGES"
--
-- DROP TABLE  "MESSAGES";
CREATE TABLE "MESSAGES" (
  "IDMESSAGE" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  "NAME" VARCHAR(45) NOT NULL DEFAULT 'EMAIL',
  "DESCRITION" VARCHAR(45) NOT NULL DEFAULT 'EMAIL',
  "SUBJECT" VARCHAR(100) NOT NULL DEFAULT 'EMAIL SUBJECT',
  "MESSAGE" VARCHAR(1000) NOT NULL DEFAULT '',
  PRIMARY KEY ("IDMESSAGE")
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "FOREXORDER"
--
-- DROP TABLE  "FOREXORDER";
CREATE TABLE "FOREXORDER" (
  "IDFOREXORDER" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  "DATEOFREQUIRED" TIMESTAMP  DEFAULT NULL,
  "DATEWILLBECONFIRMED" TIMESTAMP DEFAULT NULL,
  "TICKETNUM" VARCHAR(45) DEFAULT NULL,
  "VOYAGERNUM" VARCHAR(45) DEFAULT NULL,
  --"DATEOFDEPART" TIMESTAMP DEFAULT NULL,
  --"DATEOFRETURN" TIMESTAMP DEFAULT NULL,
  "CURRENCYCHEQUE" VARCHAR(45) DEFAULT NULL,
  "TRAVELERSCHEQUES" DOUBLE DEFAULT NULL,
  "CURRENCYCASH" VARCHAR(45) DEFAULT NULL,
  "CASH" DOUBLE  DEFAULT NULL,
  "CASHPASSPORT" DOUBLE  DEFAULT NULL,
  --"CASHPASSPORT" VARCHAR(45)  DEFAULT NULL,
  "CCTYPE" VARCHAR(45) DEFAULT NULL,
  "CCNUMBER" VARCHAR(45) DEFAULT NULL,
  "CCLAST3" VARCHAR(3) DEFAULT NULL,
  "CCEXPIRYDATE" TIMESTAMP  DEFAULT NULL,
  "CURRENCYCC" VARCHAR(45) DEFAULT NULL,
  "CCPAYMENTAMOUNT" DOUBLE  DEFAULT NULL,
  "REASONFORTRAVEL" VARCHAR(500) DEFAULT NULL,
  PRIMARY KEY ("IDFOREXORDER")
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "LEAVELOOKUP"
--
-- DROP TABLE  "LEAVELOOKUP";
CREATE TABLE "LEAVELOOKUP" (
  "LEAVETYPE" VARCHAR(45) NOT NULL,
  PRIMARY KEY ("LEAVETYPE")
);

CREATE TABLE "STAGE"(
"IDSTAGE" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),

"STAGE" VARCHAR(45) DEFAULT NULL,
PRIMARY KEY ("IDSTAGE")
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "MOTIVATION"
--
-- DROP TABLE  "MOTIVATION";
CREATE TABLE "MOTIVATION" (
  "IDMOTIVATION" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  "SUPPLIER" VARCHAR(45) DEFAULT NULL,
  "CURRENCY" VARCHAR(45) DEFAULT NULL,
  "AMOUNT" FLOAT DEFAULT NULL,
  "COSTCENTER" VARCHAR(45) DEFAULT NULL,
  "MOTIVATION" VARCHAR(255) DEFAULT NULL,
  "BUDGET" VARCHAR(45) DEFAULT NULL,
  "RECOMMENDED" VARCHAR(45) DEFAULT NULL,
  "REQUESTEDBY" VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY ("IDMOTIVATION")
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "QUOTES"
--
-- DROP TABLE  "QUOTES";
CREATE TABLE "QUOTES" (
  "IDQUOTES" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "AMENDED" INT DEFAULT NULL , --COMMENT 'NEW OR AMENDED\N',
  "COSTCENTER" VARCHAR(45) DEFAULT NULL,
  "DESCRIPTION" VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY ("IDQUOTES")
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "ROLE"
--
-- DROP TABLE  "ROLE";
CREATE TABLE "ROLE" (
  "IDROLES" INT NOT NULL,
  --"IDROLES" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "ROLE" VARCHAR(45) NOT NULL,
  "DESCRIPTION" VARCHAR(512) DEFAULT NULL,
  PRIMARY KEY ("IDROLES")
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "TASK"
--
-- DROP TABLE  "TASK";
CREATE TABLE "TASK" (
  "IDTASKS" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "TASK" VARCHAR(45) DEFAULT NULL,
  "DESCRIPTION" VARCHAR(512) DEFAULT NULL,
  PRIMARY KEY ("IDTASKS")
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "TITLE"
--
-- DROP TABLE  "TITLE";
CREATE TABLE "TITLE" (
  "TITLE" VARCHAR(45) NOT NULL,
  PRIMARY KEY ("TITLE")
);
--
-- TABLE STRUCTURE FOR TABLE "POSITION"
--
-- DROP TABLE  "POSITION";
CREATE TABLE "POSITION" (
  "POSITION" VARCHAR(45) NOT NULL,
  PRIMARY KEY ("POSITION")
);
--
-- ------------------------------------------------------
--
-- ----------------------------
-- TABLE STRUCTURE FOR "COUNTRIES"
-- ----------------------------
--DROP TABLE IF EXISTS "COUNTRIES";
CREATE TABLE "COUNTRY" (
  "CODE2" VARCHAR(2) NOT NULL,
  "CODE3" VARCHAR(3) NOT NULL,
  "URL" VARCHAR(50) NOT NULL,
  "NAME" VARCHAR(50) NOT NULL,
  "LATITUDE" FLOAT NOT NULL,
  "LONGITUDE" FLOAT NOT NULL,
  "REGIONS" INT NOT NULL,
  PRIMARY KEY  ("CODE2")
--  UNIQUE KEY "NAME" USING BTREE ("NAME"),
--  KEY "URL" ("URL")
); 

--
-- ------------------------------------------------------
--
-- ----------------------------
-- TABLE STRUCTURE FOR "REGIONS"
-- ----------------------------
--DROP TABLE IF EXISTS "REGIONS";
CREATE TABLE "REGION" (
--  "ID" INT(4) UNSIGNED NOT NULL AUTO_INCREMENT,
--  "ID" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "IDREGION" INT NOT NULL,
  "CODE2" VARCHAR(2) NOT NULL,
  "CODE" VARCHAR(3) NOT NULL,
  "URL" VARCHAR(50) NOT NULL,
  "NAME" VARCHAR(50) NOT NULL,
  "LATITUDE" FLOAT NOT NULL,
  "LONGITUDE" FLOAT NOT NULL,
  "CITIES" INT NOT NULL,
  PRIMARY KEY  ("IDREGION"),
  CONSTRAINT "FK_REGION_COUNTRYCODE2" FOREIGN KEY ("CODE2") REFERENCES "COUNTRY" ("CODE2") ON DELETE NO ACTION ON UPDATE NO ACTION
--  UNIQUE KEY "COUNTRYCODE" ("COUNTRY","CODE"),
--  UNIQUE KEY "COUNTRYCODE_2" ("COUNTRY","NAME")
);

--
-- ------------------------------------------------------
--
-- ----------------------------
-- TABLE STRUCTURE FOR "CITIES"
-- ----------------------------
--DROP TABLE IF EXISTS "CITIES";
CREATE TABLE "CITY" (
  "IDCITY" INT NOT NULL,
  "CODE2" VARCHAR(2) NOT NULL,
  "REGION" VARCHAR(3) NOT NULL,
  "URL" VARCHAR(50) NOT NULL,
  "NAME" VARCHAR(50) NOT NULL,
  "LATITUDE" FLOAT NOT NULL,
  "LONGITUDE" FLOAT NOT NULL,
  PRIMARY KEY  ("IDCITY"),
  CONSTRAINT "FK_CITY_COUNTRYCODE2" FOREIGN KEY ("CODE2") REFERENCES "COUNTRY" ("CODE2") ON DELETE NO ACTION ON UPDATE NO ACTION
  --CONSTRAINT "FK_CITY_REGION" FOREIGN KEY ("REGION") REFERENCES "REGION" ("CODE") ON DELETE NO ACTION ON UPDATE NO ACTION
--  UNIQUE KEY "COUNTRY" USING BTREE ("COUNTRY","NAME","REGION")
); 

--
-- ------------------------------------------------------
--
-- ----------------------------
-- TABLE STRUCTURE FOR "CURRENCY"
-- ----------------------------
--DROP TABLE IF EXISTS "CURRENCY";
CREATE TABLE "CURRENCY" (
  "IDCURRENCY" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "COUNTRYNAME" VARCHAR(70) NOT NULL,
  "CURRENCYNAME" VARCHAR(50) NOT NULL,
  "CODE2" VARCHAR(2) NOT NULL,
  "CODE3" VARCHAR(3) NOT NULL,
  "CURRENCYCODE3"VARCHAR(3) NOT NULL,
  PRIMARY KEY  ("IDCURRENCY"),
  CONSTRAINT "FK_CURRENCY_COUNTRYCODE2" FOREIGN KEY ("CODE2") REFERENCES "COUNTRY" ("CODE2") ON DELETE NO ACTION ON UPDATE NO ACTION
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "ACCOMODATIONQUOTES"
--
-- DROP TABLE  "ACCOMODATIONQUOTES";
CREATE TABLE "ACCOMODATIONQUOTES" (
  "IDACCOMODATIONQUOTES" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "DATECHECKIN" TIMESTAMP  DEFAULT NULL,
  "DATECHECKOUT" TIMESTAMP  DEFAULT NULL,
  "COUNTRY" VARCHAR(45) DEFAULT NULL,
  "CITY" VARCHAR(45) DEFAULT NULL,
  "DESCRIPTION" VARCHAR(45) DEFAULT NULL,
  "ACCOMODATIONPROVIDER" VARCHAR(45) DEFAULT NULL,
  "QUOTESOURCE" VARCHAR(45) DEFAULT NULL,
  "CURRENCY" VARCHAR(45) DEFAULT NULL,
  "QUOTECOST" FLOAT  DEFAULT NULL,
  "QUOTES_IDQUOTES" INT NOT NULL,
  "SELECTED" INT DEFAULT 0,
  PRIMARY KEY ("IDACCOMODATIONQUOTES"),
  CONSTRAINT "FK_ACCOMODATIONQUOTES_QUOTES1" FOREIGN KEY ("QUOTES_IDQUOTES") REFERENCES "QUOTES" ("IDQUOTES") ON DELETE NO ACTION ON UPDATE NO ACTION
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "CARQUOTES"
--
-- DROP TABLE  "CARQUOTES";
CREATE TABLE "CARQUOTES" (
  "IDCARQUOTES" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "DATECOLLECT" TIMESTAMP  DEFAULT NULL,
  "DATERETURN" TIMESTAMP  DEFAULT NULL,
  "PROVIDER" VARCHAR(45) DEFAULT NULL,
  "DESCRIPTION" VARCHAR(45) DEFAULT NULL,
  "CURRENCY" VARCHAR(45) DEFAULT NULL,
  "QUOTECOST" FLOAT  DEFAULT NULL,
  "QUOTES_IDQUOTES" INT NOT NULL,
  "SELECTED" INT DEFAULT 0,
  PRIMARY KEY ("IDCARQUOTES"),
  CONSTRAINT "FK_CARQUOTES_QUOTES1" FOREIGN KEY ("QUOTES_IDQUOTES") REFERENCES "QUOTES" ("IDQUOTES") ON DELETE NO ACTION ON UPDATE NO ACTION
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "FLIGHTQUOTES"
--
-- DROP TABLE  "FLIGHTQUOTES";
CREATE TABLE "FLIGHTQUOTES" (
  "IDFLIGHTQUOTES" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "FLIGHTNUMBER" VARCHAR(45) DEFAULT NULL,
  "FLIGHTFROM_COUNTRY" VARCHAR(45) DEFAULT NULL,
  "FLIGHTFROM_CITY" VARCHAR(45) DEFAULT NULL,
  "FLIGHTTO_COUNTRY" VARCHAR(45) DEFAULT NULL,
  "FLIGHTTO_CITY" VARCHAR(45) DEFAULT NULL,
  "DATEDEPARTURE" TIMESTAMP  DEFAULT NULL,
  "DATEARRIVAL" TIMESTAMP  DEFAULT NULL,
  "QUOTESOURCEDESCRIPTION" VARCHAR(45) DEFAULT NULL,
  "QUOTESOURCE" VARCHAR(45) DEFAULT NULL,
  "CURRENCY" VARCHAR(45) DEFAULT NULL,
  "QUOTECOST" FLOAT DEFAULT NULL,
  "QUOTES_IDQUOTES" INT NOT NULL,
  "SELECTED" INT DEFAULT 0,
  PRIMARY KEY ("IDFLIGHTQUOTES"),
  CONSTRAINT "FK_FLIGHTQUOTES_QUOTES1" FOREIGN KEY ("QUOTES_IDQUOTES") REFERENCES "QUOTES" ("IDQUOTES") ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "FINALCOSTING"
--
-- DROP TABLE  "FINALCOSTING";
CREATE TABLE "FINALCOSTING" (
  "IDFINALCOSTING" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "NAME" VARCHAR(45) DEFAULT NULL,
  "ADMINISTRATIVEUNIT" VARCHAR(45) DEFAULT NULL,
  "ABSENCEBUSSINESS" INT DEFAULT NULL,
  "ABSENCEPRIVATE" INT DEFAULT NULL,
  "COUNTRIES" VARCHAR(45) DEFAULT NULL,
  "CITYS" VARCHAR(45) DEFAULT NULL,
  "CURRENCY" VARCHAR(45) DEFAULT NULL,
  "CHECKS" INT DEFAULT NULL,
  "AIRFAREBUDGET" FLOAT DEFAULT NULL,
  "AIRFARECOST" FLOAT DEFAULT NULL,
  "CARRENTALBUDGET" FLOAT DEFAULT NULL,
  "CARRENTALCOST" FLOAT DEFAULT NULL,
  "ACCOMMODATIONBUDGET" FLOAT DEFAULT NULL,
  "ACCOMMODATIONCOST" FLOAT DEFAULT NULL,
  "ACCOMMODATEDAYS" INT NOT NULL,
  "PERDIEMBUDGET" FLOAT DEFAULT NULL,
  "PERDIEMCOST" FLOAT DEFAULT NULL,
  "PERDIEMDAYS" INT NOT NULL,
  "CONFERENCEBUDGET" FLOAT DEFAULT NULL,
  "CONFERENCECOST" FLOAT DEFAULT NULL,
  "VISABUDGET" FLOAT DEFAULT NULL,
  "VISACOST" FLOAT DEFAULT NULL,
  "OTHERBUDGET" FLOAT DEFAULT NULL,
  "OTHERCOST" FLOAT DEFAULT NULL,
  "OTHERDISCRIPTION" VARCHAR(200) DEFAULT NULL,
  "APPROVEDBUDGET" FLOAT DEFAULT NULL,
  "APPROVEDCOST" FLOAT DEFAULT NULL,
  "QUOTES_IDQUOTES" INT NOT NULL,
  "FROMOZ" INT DEFAULT NULL,
  "OZNAME" VARCHAR(45) DEFAULT NULL,
  "OZTEL" VARCHAR(45) DEFAULT NULL,
  "OZEMAIL" VARCHAR(45) DEFAULT NULL,
  
  PRIMARY KEY ("IDFINALCOSTING"),
  CONSTRAINT "FK_FINALCOSTING_QUOTES1" FOREIGN KEY ("QUOTES_IDQUOTES") REFERENCES "QUOTES" ("IDQUOTES") ON DELETE NO ACTION ON UPDATE NO ACTION
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "SESSION"
--
-- DROP TABLE  "SESSION";
CREATE TABLE "SESSION" (
  "IDSESSIONS" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "ACCOUNTID" INT NOT NULL,
  "DATE" TIMESTAMP  DEFAULT NULL,
  "EXPIRES" TIMESTAMP  DEFAULT NULL,
  PRIMARY KEY ("IDSESSIONS"),
  CONSTRAINT "FK_SESSIONS_USERS1" FOREIGN KEY ("ACCOUNTID") REFERENCES "ACCOUNT" ("IDACCOUNT") ON DELETE NO ACTION ON UPDATE NO ACTION
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "TRAVELERPROFILE"
--
-- DROP TABLE  "TRAVELERPROFILE";
CREATE TABLE "TRAVELERPROFILE" (
  "IDTRAVELERPROFILE" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "ACCOUNTID" INT NOT NULL,
  "STAFFID" VARCHAR(45) DEFAULT NULL,
  "DEPARTMENT" VARCHAR(45) DEFAULT NULL,
  "POSITION" VARCHAR(45) DEFAULT NULL,
  "TRAVELBOOKER" VARCHAR(45) DEFAULT NULL,
  "FIRSTNAME" VARCHAR(45) DEFAULT NULL,  
  "FAMILYNAME" VARCHAR(45) DEFAULT NULL,
  "MIDDLENAME" VARCHAR(45) DEFAULT NULL,
  "TITLE" VARCHAR(45) DEFAULT NULL,  
  "IDNUMBER" VARCHAR(20) DEFAULT NULL,   
  "BUSINESSADDRESS" VARCHAR(255) DEFAULT NULL,
  "BUSINESSPHONE" VARCHAR(15) DEFAULT NULL,
  "BUSINESSFAX" VARCHAR(15) DEFAULT NULL,
  "HOMEADDRESS1" VARCHAR(255) DEFAULT NULL,
  "HOMEADDRESS2" VARCHAR(255) DEFAULT NULL,
  "CITY" VARCHAR(100) DEFAULT NULL,
  "COUNTRY" VARCHAR(100) DEFAULT NULL,
  "PROVINCE" VARCHAR(100) DEFAULT NULL,
  "POSTALCODE" VARCHAR(100) DEFAULT NULL,
  "MOBILEPHONE" VARCHAR(15) DEFAULT NULL,
  "HOMEPHONE" VARCHAR(15) DEFAULT NULL,
  "HOMEEMAIL" VARCHAR(45) DEFAULT NULL,
  "SPOUSENAME" VARCHAR(45) DEFAULT NULL,
  "SPOUSECONTACTNUMBER" VARCHAR(45) DEFAULT NULL,
  "SPOUSEEMAIL" VARCHAR(45) DEFAULT NULL,
  "DOCTORSNAME" VARCHAR(45) DEFAULT NULL,
  "DOCTORSCONCTACTNUMBER" VARCHAR(45) DEFAULT NULL,
  "DOCTORSEMAIL" VARCHAR(45) DEFAULT NULL,
  "KNOWNMEDICALCONDITIONS" VARCHAR(512) DEFAULT NULL,  
  "CARPREFERENCE1" VARCHAR(200) DEFAULT NULL,
  "CARPREFERENCE2" VARCHAR(200) DEFAULT NULL,
  "CARGROUP" VARCHAR(45) DEFAULT NULL,
  "MANUALAUTOMATIC" VARCHAR(45) DEFAULT NULL,
  "AIRCON" VARCHAR(45) DEFAULT NULL,
  "CARADDITIONALREQUIREMENTS" VARCHAR(500) DEFAULT NULL,
  "HOTELPREFRENCE" VARCHAR(200) DEFAULT NULL,
  "FREQUENTGUESTNUM" VARCHAR(45) DEFAULT NULL,
  "SMOKING" VARCHAR(45) DEFAULT NULL,
  "HOTELADDITIONALREQUIREMENTS" VARCHAR(500) DEFAULT NULL,
  "SEATINGPOSITION" VARCHAR(45) DEFAULT NULL,
  "SEATINGLOCATION" VARCHAR(45) DEFAULT NULL,
  "CLASSDOMESTIC" VARCHAR(45) DEFAULT NULL,
  "CLASSINTERNATIONAL" VARCHAR(45) DEFAULT NULL,
  "MEALREQUIREMENTS" VARCHAR(500) DEFAULT NULL,
  "AIRADDITIONALREQUIREMENTS" VARCHAR(500) DEFAULT NULL,
  "ATTACHMENTID" VARCHAR(45) DEFAULT NULL,
  "DATECREATED" TIMESTAMP  DEFAULT NULL,
  "DATEMODIFIED" TIMESTAMP  DEFAULT NULL,
  PRIMARY KEY ("IDTRAVELERPROFILE"),
  CONSTRAINT "FK_TRAVELERPROFILE_1" FOREIGN KEY ("ACCOUNTID") REFERENCES "ACCOUNT" ("IDACCOUNT") ON DELETE NO ACTION ON UPDATE NO ACTION
 );
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "REWARDSPROGRAM"
--
-- DROP TABLE  "REWARDSPROGRAM";
CREATE TABLE "REWARDSPROGRAM" (
  "IDREWARDSPROGRAM" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "DESCRIPTION" VARCHAR(100) DEFAULT NULL,
  "MEMBERSHIPTYPE" VARCHAR(45) DEFAULT NULL,
  "PROVIDER" VARCHAR(45) DEFAULT NULL , --COMMENT 'THE COMPANY THE PROVIDES THE REWARDS PROGRAM',
  "MEMBERSHIPNUMBER" VARCHAR(45) DEFAULT NULL,
  "TRAVELERPROFILE_IDTRAVELERPROFILE" INT NOT NULL,
  PRIMARY KEY ("IDREWARDSPROGRAM"),
  CONSTRAINT "FK_REWARDSPROGRAM_TRAVELERPROFILE1" FOREIGN KEY ("TRAVELERPROFILE_IDTRAVELERPROFILE") REFERENCES "TRAVELERPROFILE" ("IDTRAVELERPROFILE") ON DELETE NO ACTION ON UPDATE NO ACTION
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "TRAVELDOCUMENT"
--
-- DROP TABLE  "TRAVELDOCUMENT";
CREATE TABLE "TRAVELDOCUMENT" (
  "IDTRAVELDOCUMENTS" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "PASSPORTNUMBER" VARCHAR(12) DEFAULT NULL,
  "COUNTRY" VARCHAR(45) DEFAULT NULL,
  "DATEOFISSUE" TIMESTAMP  DEFAULT NULL,
  "EXPIRYDATE" TIMESTAMP  DEFAULT NULL,
  "VALIDVISA" VARCHAR(45) DEFAULT NULL,
  "TRAVLERPROFILE_IDTRAVLERPROFILE" INT NOT NULL,
  PRIMARY KEY ("IDTRAVELDOCUMENTS"),
  CONSTRAINT "FK_TRAVELDOCUMENTS_TRAVELERPROFILE1" FOREIGN KEY ("TRAVLERPROFILE_IDTRAVLERPROFILE") REFERENCES "TRAVELERPROFILE" ("IDTRAVELERPROFILE") ON DELETE NO ACTION ON UPDATE NO ACTION
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "TRAVEL"
--
-- DROP TABLE  "TRAVEL";
CREATE TABLE "TRAVEL" (
  "IDTRAVEL" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "DATEDEPARTURE" TIMESTAMP  DEFAULT NULL,
  "DATERETURN" TIMESTAMP  DEFAULT NULL,
  "DESCRIPTION" VARCHAR(100) DEFAULT NULL,
  "CONFERENCE_IDCONFERENCE" INT NOT NULL,
  PRIMARY KEY ("IDTRAVEL"),
  CONSTRAINT "FK_TRAVEL_CONFERENCE1" FOREIGN KEY ("CONFERENCE_IDCONFERENCE") REFERENCES "CONFERENCE" ("IDCONFERENCE") ON DELETE NO ACTION ON UPDATE NO ACTION
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "ITINERARY"
--
-- DROP TABLE  "ITINERARY";
CREATE TABLE "ITINERARY" (
  "IDITINERARY" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "DATE" TIMESTAMP  DEFAULT NULL,
  "DATEFROM" TIMESTAMP  DEFAULT NULL,
  "DATETO" TIMESTAMP  DEFAULT NULL,
  "LEAVETYPE" VARCHAR(45) DEFAULT NULL , --COMMENT 'BUSINESS OR OTHER LEAVE\N',
  "LEAVEDESCRIPTION" VARCHAR(45) DEFAULT NULL,
  "TRAVELDAY" VARCHAR(45) DEFAULT NULL , --COMMENT 'OR NON WORKING DAY\NOTHER',
  "TRAVEL_IDTRAVEL" INT NOT NULL,
 -- "DESTINATION" VARCHAR(45) DEFAULT NULL,
  "DESTINATION_CITY" VARCHAR(45) DEFAULT NULL,
  "DESTINATION_COUNTRY" VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY ("IDITINERARY"),
  CONSTRAINT "FK_ITINERARY_TRAVEL1" FOREIGN KEY ("TRAVEL_IDTRAVEL") REFERENCES "TRAVEL" ("IDTRAVEL") ON DELETE NO ACTION ON UPDATE NO ACTION
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "ACCOUNTROLE"
--
-- DROP TABLE  "ACCOUNTROLE";
CREATE TABLE "ACCOUNTROLE" (
  "IDUSERROLES" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "ACCOUNTID" INT DEFAULT NULL,
  "ROLEID" INT DEFAULT NULL,
  PRIMARY KEY ("IDUSERROLES"),
  CONSTRAINT "FK_USERROLES_1" FOREIGN KEY ("ROLEID") REFERENCES "ROLE" ("IDROLES") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_USERROLES_2" FOREIGN KEY ("ACCOUNTID") REFERENCES "ACCOUNT" ("IDACCOUNT") ON DELETE NO ACTION ON UPDATE NO ACTION
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "PERMISSION"
--
-- DROP TABLE  "PERMISSION";
CREATE TABLE "PERMISSION" (
  "IDPERMISSIONS" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "PERMISSION" VARCHAR(45) DEFAULT NULL,
  "DESCRIPTION" VARCHAR(45) DEFAULT NULL,
  "CREATEPERM" SMALLINT DEFAULT 1,
  "DELETEPERM" SMALLINT DEFAULT 1,
  "UPDATEPERM" SMALLINT DEFAULT 1,
  "READPERM" SMALLINT DEFAULT 0,
  "GRANTPERM" SMALLINT DEFAULT 1,
  "TASKS_IDTASKS" INT NOT NULL,
  "ROLES_IDROLES" INT NOT NULL,
  PRIMARY KEY ("IDPERMISSIONS"),
  CONSTRAINT "FK_PERMISSIONS_TASKS1" FOREIGN KEY ("TASKS_IDTASKS") REFERENCES "TASK" ("IDTASKS") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_PERMISSIONS_ROLES1" FOREIGN KEY ("ROLES_IDROLES") REFERENCES "ROLE" ("IDROLES") ON DELETE NO ACTION ON UPDATE NO ACTION
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "APPLICATION"
--
-- DROP TABLE  "APPLICATION";
CREATE TABLE "APPLICATION" (
  "IDAPPLICATION" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "DESCRIPTION" VARCHAR(100) DEFAULT NULL,
  "TRAVELERPROFILE_IDTRAVELERPROFILE" INT NOT NULL,
  "QUOTES_IDQUOTES" INT NOT NULL,
  "FINALCOSTING_IDFINALCOSTING" INT NOT NULL,
  "FINALCOSTINGCOMPLETE" INT NOT NULL DEFAULT 0,
  "TRAVEL_IDTRAVEL" INT NOT NULL,
  "CONFERENCECOMPLETE" INT NOT NULL DEFAULT 0,
  "ACCOUNT_IDACCOUNT" INT NOT NULL,
  "FOREXORDER_IDFOREXORDER" INT NOT NULL,
  "FOREXCOMPLETE" INT NOT NULL DEFAULT 0,
  "MOTIVATION_IDMOTIVATION" INT NOT NULL,
  "MOTIVATIONCOMPLETE" INT NOT NULL DEFAULT 0,
  "DATEMODIFIED" TIMESTAMP  DEFAULT NULL,
  PRIMARY KEY ("IDAPPLICATION"),
  CONSTRAINT "FK_APPLICATION_TRAVELERPROFILE1" FOREIGN KEY ("TRAVELERPROFILE_IDTRAVELERPROFILE") REFERENCES "TRAVELERPROFILE" ("IDTRAVELERPROFILE") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_APPLICATION_QUOTES1" FOREIGN KEY ("QUOTES_IDQUOTES") REFERENCES "QUOTES" ("IDQUOTES") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_APPLICATION_ACCOUNT1" FOREIGN KEY ("ACCOUNT_IDACCOUNT") REFERENCES "ACCOUNT" ("IDACCOUNT") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_APPLICATION_FOREXORDER1" FOREIGN KEY ("FOREXORDER_IDFOREXORDER") REFERENCES "FOREXORDER" ("IDFOREXORDER") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_APPLICATION_MOTIVATION1" FOREIGN KEY ("MOTIVATION_IDMOTIVATION") REFERENCES "MOTIVATION" ("IDMOTIVATION") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_APPLICATION_FINALCOSTING1" FOREIGN KEY ("FINALCOSTING_IDFINALCOSTING") REFERENCES "FINALCOSTING" ("IDFINALCOSTING") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_APPLICATION_TRAVEL1" FOREIGN KEY ("TRAVEL_IDTRAVEL") REFERENCES "TRAVEL" ("IDTRAVEL") ON DELETE NO ACTION ON UPDATE NO ACTION
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "APPROVAL"
--
-- DROP TABLE  "APPROVAL";
CREATE TABLE "APPROVAL" (
  "IDAPPROVAL" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "FROMSECTION" VARCHAR(30) DEFAULT NULL,
  "SECTIONID" INT DEFAULT NULL,  --WHICH PART OF THE FORM IS APPROVED, TRAVEL, ECT LIKE A SIGNATURE    
  "SECTIONAPPROVED" INT DEFAULT NULL,  --Yes | NO 0 | 1
  "NOTES" VARCHAR(300) DEFAULT NULL,
  "DATE" TIMESTAMP  DEFAULT NULL,
  "APPLICATION_IDAPPLICATION" INT NOT NULL,
  "ACCOUNT_IDACCOUNT" INT NOT NULL,
  PRIMARY KEY ("IDAPPROVAL"),
  CONSTRAINT "FK_APPROVAL_APPLICATION1" FOREIGN KEY ("APPLICATION_IDAPPLICATION") REFERENCES "APPLICATION" ("IDAPPLICATION") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_APPROVAL_ACCOUNT1" FOREIGN KEY ("ACCOUNT_IDACCOUNT") REFERENCES "ACCOUNT" ("IDACCOUNT") ON DELETE NO ACTION ON UPDATE NO ACTION
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "ATTACHEMENT"
--
-- DROP TABLE  "ATTACHEMENT";
CREATE TABLE "ATTACHEMENT" (
  "IDATTACHEMENT" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "DESCRIPTION" VARCHAR(45) DEFAULT NULL,
  "DOCUMENTLOCATION" VARCHAR(45) DEFAULT NULL,
  "CONFERENCE_IDCONFERENCE" INT DEFAULT NULL,
  "ITINERARY_IDITINERARY" INT DEFAULT NULL,
  "APPROVAL_IDAPPROVAL" INT DEFAULT NULL,
  "APPLICATION_IDAPPLICATION" INT DEFAULT NULL,
  "TRAVEL_IDTRAVEL" INT DEFAULT NULL,
  "FINALCOSTING_IDFINALCOSTING" INT DEFAULT NULL,
  "CARQUOTES_IDCARQUOTES" INT DEFAULT NULL,
  "QUOTES_IDQUOTES" INT DEFAULT NULL,
  "ACCOMODATIONQUOTES_IDACCOMODATIONQUOTES" INT DEFAULT NULL,
  "FLIGHTQUOTES_IDFLIGHTQUOTES" INT DEFAULT NULL,
  "TRAVELDOCUMENT_IDTRAVELDOCUMENTS" INT DEFAULT NULL,
  "TRAVELERPROFILE_IDTRAVELERPROFILE" INT DEFAULT NULL,
  "REWARDSPROGRAM_IDREWARDSPROGRAM" INT DEFAULT NULL,
  "FOREXORDER_IDFOREXORDER" INT DEFAULT NULL,
  "MOTIVATION_IDMOTIVATION" INT DEFAULT NULL,
  PRIMARY KEY ("IDATTACHEMENT"),
  CONSTRAINT "FK_ATTACHEMENT_CONFERENCE1" FOREIGN KEY ("CONFERENCE_IDCONFERENCE") REFERENCES "CONFERENCE" ("IDCONFERENCE") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ATTACHEMENT_ITINERARY1" FOREIGN KEY ("ITINERARY_IDITINERARY") REFERENCES "ITINERARY" ("IDITINERARY") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ATTACHEMENT_APPROVAL1" FOREIGN KEY ("APPROVAL_IDAPPROVAL") REFERENCES "APPROVAL" ("IDAPPROVAL") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ATTACHEMENT_APPLICATION1" FOREIGN KEY ("APPLICATION_IDAPPLICATION") REFERENCES "APPLICATION" ("IDAPPLICATION") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ATTACHEMENT_TRAVEL1" FOREIGN KEY ("TRAVEL_IDTRAVEL") REFERENCES "TRAVEL" ("IDTRAVEL") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ATTACHEMENT_FINALCOSTING1" FOREIGN KEY ("FINALCOSTING_IDFINALCOSTING") REFERENCES "FINALCOSTING" ("IDFINALCOSTING") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ATTACHEMENT_CARQUOTES1" FOREIGN KEY ("CARQUOTES_IDCARQUOTES") REFERENCES "CARQUOTES" ("IDCARQUOTES") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ATTACHEMENT_QUOTES1" FOREIGN KEY ("QUOTES_IDQUOTES") REFERENCES "QUOTES" ("IDQUOTES") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ATTACHEMENT_ACCOMODATIONQUOTES1" FOREIGN KEY ("ACCOMODATIONQUOTES_IDACCOMODATIONQUOTES") REFERENCES "ACCOMODATIONQUOTES" ("IDACCOMODATIONQUOTES") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ATTACHEMENT_FLIGHTQUOTES1" FOREIGN KEY ("FLIGHTQUOTES_IDFLIGHTQUOTES") REFERENCES "FLIGHTQUOTES" ("IDFLIGHTQUOTES") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ATTACHEMENT_TRAVELDOCUMENT1" FOREIGN KEY ("TRAVELDOCUMENT_IDTRAVELDOCUMENTS") REFERENCES "TRAVELDOCUMENT" ("IDTRAVELDOCUMENTS") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ATTACHEMENT_TRAVELERPROFILE1" FOREIGN KEY ("TRAVELERPROFILE_IDTRAVELERPROFILE") REFERENCES "TRAVELERPROFILE" ("IDTRAVELERPROFILE") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ATTACHEMENT_REWARDSPROGRAM1" FOREIGN KEY ("REWARDSPROGRAM_IDREWARDSPROGRAM") REFERENCES "REWARDSPROGRAM" ("IDREWARDSPROGRAM") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ATTACHEMENT_FOREXORDER1" FOREIGN KEY ("FOREXORDER_IDFOREXORDER") REFERENCES "FOREXORDER" ("IDFOREXORDER") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ATTACHEMENT_MOTIVATION1" FOREIGN KEY ("MOTIVATION_IDMOTIVATION") REFERENCES "MOTIVATION" ("IDMOTIVATION") ON DELETE NO ACTION ON UPDATE NO ACTION
);
--
-- ------------------------------------------------------
--
-- TABLE STRUCTURE FOR TABLE "APPROVALCHAIN"
--
-- DROP TABLE  "APPROVALCHAIN";
CREATE TABLE "APPROVALCHAIN" (
  "ID" INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  "ACCOUNTID" INT NOT NULL,
  "APPLICATIONID" INT NOT NULL,
  "APPLICATIONCOMPLETE" INT DEFAULT NULL,
  "SCHOOLADMIN" INT DEFAULT NULL,
  "SCHOOLADMINCOMPLETE" INT DEFAULT NULL,
  "SCHOOLADMINAPPROVED" INT DEFAULT NULL,
  "HOD" INT DEFAULT NULL,
  "HODCOMPLETE" INT DEFAULT NULL,
  "HODAPPROVED" INT DEFAULT NULL,
  "FINANCE" INT DEFAULT NULL,
  "FINANCECOMPLETE" INT DEFAULT NULL,
  "FINANCEAPPROVED" INT DEFAULT NULL,
  "PVC" INT DEFAULT NULL,
  "PVCCOMPLETE" INT DEFAULT NULL,
  "PVCAPPROVED" INT DEFAULT NULL,
  "FINALFINANCE" INT DEFAULT NULL,
  "FINALCOMPLETE" INT DEFAULT NULL,
  "FINALAPPROVED" INT DEFAULT NULL,
  PRIMARY KEY ("ID"),
  CONSTRAINT "FK_ACCOUNT_1" FOREIGN KEY ("ACCOUNTID") REFERENCES "ACCOUNT" ("IDACCOUNT") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ACCOUNT_2" FOREIGN KEY ("SCHOOLADMIN") REFERENCES "ACCOUNT" ("IDACCOUNT") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ACCOUNT_3" FOREIGN KEY ("HOD") REFERENCES "ACCOUNT" ("IDACCOUNT") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ACCOUNT_4" FOREIGN KEY ("FINANCE") REFERENCES "ACCOUNT" ("IDACCOUNT") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ACCOUNT_5" FOREIGN KEY ("PVC") REFERENCES "ACCOUNT" ("IDACCOUNT") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ACCOUNT_6" FOREIGN KEY ("FINALFINANCE") REFERENCES "ACCOUNT" ("IDACCOUNT") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_ATTACHEMENT_APPLICATION_1" FOREIGN KEY ("APPLICATIONID") REFERENCES "APPLICATION" ("IDAPPLICATION") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_APPROVAL_1" FOREIGN KEY ("SCHOOLADMINAPPROVED") REFERENCES "APPROVAL" ("IDAPPROVAL") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_APPROVAL_2" FOREIGN KEY ("HODAPPROVED") REFERENCES "APPROVAL" ("IDAPPROVAL") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_APPROVAL_3" FOREIGN KEY ("FINANCEAPPROVED") REFERENCES "APPROVAL" ("IDAPPROVAL") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_APPROVAL_4" FOREIGN KEY ("PVCAPPROVED") REFERENCES "APPROVAL" ("IDAPPROVAL") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "FK_APPROVAL_5" FOREIGN KEY ("FINALAPPROVED") REFERENCES "APPROVAL" ("IDAPPROVAL") ON DELETE NO ACTION ON UPDATE NO ACTION
);