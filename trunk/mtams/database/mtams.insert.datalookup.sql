-- The top section of inserts are conisered safe as they do not have any foreign key 
-- constraints
-- The section of inserts OTHER is unsafe and left commented
-- You can uses these inserts as templates for creating your own insert statements.
-- There is a simple application insert script to do just enough initialisation
-- of the system for most simple operations to work. It is also incomplete
-- mtams.insert.app.sql

--role inserts
--pulled down from netbeans so not optimal

INSERT INTO "ROLE" (IDROLES, "ROLE", DESCRIPTION) 
	VALUES (11, 'Applicant', DEFAULT);
INSERT INTO "ROLE" (IDROLES, "ROLE", DESCRIPTION) 
	VALUES (12, 'Authorizer', DEFAULT);
INSERT INTO "ROLE" (IDROLES, "ROLE", DESCRIPTION) 
	VALUES (21, 'Admin', DEFAULT);
INSERT INTO "ROLE" (IDROLES, "ROLE", DESCRIPTION) 
	VALUES (22, 'SuperAdmin', DEFAULT);
INSERT INTO "ROLE" (IDROLES, "ROLE", DESCRIPTION) 
	VALUES (99, 'Deactivated', DEFAULT);
INSERT INTO "ROLE" (IDROLES, "ROLE", DESCRIPTION) 
	VALUES (911, 'Applicant', 'Deactivated Applicant');
INSERT INTO "ROLE" (IDROLES, "ROLE", DESCRIPTION) 
	VALUES (912, 'Authorizer', 'Deactivated Authorizer');
INSERT INTO "ROLE" (IDROLES, "ROLE", DESCRIPTION) 
	VALUES (921, 'Admin', 'Deactivated Admin');
INSERT INTO "ROLE" (IDROLES, "ROLE", DESCRIPTION) 
	VALUES (922, 'SuperAdmin', 'Deactivated SuperAdmin');



-- Position inserts
INSERT INTO "POSITION" (POSITION) VALUES ('Lecturer' /*not nullable*/);
INSERT INTO "POSITION" (POSITION) VALUES ('Professor' /*not nullable*/);
INSERT INTO "POSITION" (POSITION) VALUES ('Assistant Lecturer' /*not nullable*/);
INSERT INTO "POSITION" (POSITION) VALUES ('Tutor' /*not nullable*/);
INSERT INTO "POSITION" (POSITION) VALUES ('Secretary' /*not nullable*/);
INSERT INTO "POSITION" (POSITION) VALUES ('Head of Department' /*not nullable*/);
INSERT INTO "POSITION" (POSITION) VALUES ('Administrator' /*not nullable*/);
INSERT INTO "POSITION" (POSITION) VALUES ('Manager' /*not nullable*/);
INSERT INTO "POSITION" (POSITION) VALUES ('Pro vice Chancellor' /*not nullable*/);
INSERT INTO "POSITION" (POSITION) VALUES ('Chancellor' /*not nullable*/);

-- Title inserts
-- simple quick inserts
--INSERT INTO "TITLE" (TITLE) VALUES ('s' /*not nullable*/);
INSERT INTO "TITLE" (TITLE) VALUES ('Mr' /*not nullable*/);
INSERT INTO "TITLE" (TITLE) VALUES ('Mrs' /*not nullable*/);
INSERT INTO "TITLE" (TITLE) VALUES ('Miss' /*not nullable*/);
INSERT INTO "TITLE" (TITLE) VALUES ('Dr' /*not nullable*/);
INSERT INTO "TITLE" (TITLE) VALUES ('Phd' /*not nullable*/);
INSERT INTO "TITLE" (TITLE) VALUES ('Sir' /*not nullable*/);


-- Department inserts
INSERT INTO "DEPARTMENT" (DEPARTMENT,IDDEPARTMENT) VALUES ('School of Information Technology' /*not nullable*/,1);
INSERT INTO "DEPARTMENT" (DEPARTMENT,IDDEPARTMENT) VALUES ('School of Social Science' /*not nullable*/,2);
INSERT INTO "DEPARTMENT" (DEPARTMENT,IDDEPARTMENT) VALUES ('Finance' /*not nullable*/,3);
INSERT INTO "DEPARTMENT" (DEPARTMENT,IDDEPARTMENT) VALUES ('Administration' /*not nullable*/,4);
INSERT INTO "DEPARTMENT" (DEPARTMENT,IDDEPARTMENT) VALUES ('School of Business and Economics' /*not nullable*/,5);
INSERT INTO "DEPARTMENT" (DEPARTMENT,IDDEPARTMENT) VALUES ('Student Services' /*not nullable*/,6);
INSERT INTO "DEPARTMENT" (DEPARTMENT,IDDEPARTMENT) VALUES ('School of Health Sciences' /*not nullable*/,7);
INSERT INTO "DEPARTMENT" (DEPARTMENT,IDDEPARTMENT) VALUES ('Information Technology Services' /*not nullable*/,8);

-- Leave type inserts
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Annual Leave' /*not nullable*/);
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Maternity Leave - Paid' /*not nullable*/);
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Paternity Leave - Paid' /*not nullable*/);
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Compassionate Leave' /*not nullable*/);
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Sick Leave' /*not nullable*/);
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Injury on Duty Leave' /*not nullable*/);
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Conference Leave' /*not nullable*/);
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Consultancy Leave' /*not nullable*/);
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Research Leave' /*not nullable*/);
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Long Service Leave - full pay' /*not nullable*/);
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Long Service Leave - half pay' /*not nullable*/);
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Long Service Leave - double pay' /*not nullable*/);
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Leave without pay' /*not nullable*/);
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Adoption Leave' /*not nullable*/);
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Family Leave' /*not nullable*/);
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Outside Studies Program International' /*not nullable*/);
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Outside Studies Program Domestic' /*not nullable*/);
INSERT INTO "LEAVELOOKUP" (LEAVETYPE) VALUES ('Other' /*not nullable*/);

-- *********************************************************************
-- 		OTHER
-- *********************************************************************

--INSERT INTO "TASK" (IDTASKS,TASK,DESCRIPTION) VALUES (1 /*not nullable*/,'s','s');
--
--INSERT INTO "PERMISSION" (PERMISSION,DISCRITPTION,CREATEPERM,DELETEPERM,UPDATEPERM,READPERM,GRANTPERM,TASKS_IDTASKS,ROLES_IDROLES) 
--	VALUES ('s','s',0,0,0,0,0,0 /*not nullable*/,0 /*not nullable*/);
--
--
--INSERT INTO "APPROVAL" (FROMSECTION,SECTIONID,SECTIONAPPROVED,NOTES,DATE,APPLICATION_IDAPPLICATION,ACCOUNT_IDACCOUNT) 
--	VALUES ('s',0,0,'s',{ts '2013-05-08 12:20:42.839000'},0 /*not nullable*/,0 /*not nullable*/);
--
--
--INSERT INTO "ATTACHEMENT" (DESCRIPTION,DOCUMENTLOCATION,CONFERENCE_IDCONFERENCE,ITINERARY_IDITINERARY,APPROVAL_IDAPPROVAL,APPLICATION_IDAPPLICATION,TRAVEL_IDTRAVEL,FINALCOSTING_IDFINALCOSTING,CARQUOTES_IDCARQUOTES,QUOTES_IDQUOTES,ACCOMODATIONQUOTES_IDACCOMODATIONQUOTES,FLIGHTQUOTES_IDFLIGHTQUOTES,TRAVELDOCUMENT_IDTRAVELDOCUMENTS,TRAVELERPROFILE_IDTRAVELERPROFILE,REWARDSPROGRAM_IDREWARDSPROGRAM,FOREXORDER_IDFOREXORDER,MOTIVATION_IDMOTIVATION) 
--	VALUES ('s','s',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
--
--INSERT INTO "ACCOMODATIONQUOTES" (DATECHECKIN,DATECHECKOUT,COUNTRY,CITY,DISCRITPTION,ACCOMODATIONPROVIDER,QUOTESOURCE,QUOTECOST,QUOTES_IDQUOTES) 
--	VALUES ({ts '2013-05-08 12:20:30.363000'},{ts '2013-05-08 12:20:30.363000'},'s','s','s','s','s','s',0 /*not nullable*/);
--
--INSERT INTO "CARQUOTES" (DATECOLLECT,DATERETURN,PROVIDER,DISCRITPTION,QUOTECOST,QUOTES_IDQUOTES) 
--	VALUES ({ts '2013-05-08 12:21:02.184000'},{ts '2013-05-08 12:21:02.184000'},'s','s','s',0 /*not nullable*/);
--
--
--INSERT INTO "FLIGHTQUOTES" (FLIGHTNUMBER,FLIGHTFROM,FLIGHTTO,DATEDEPARTURE,DATEARRIVAL,QUOTESOURCEDESCRIPTION,QUOTESOURCE,QUOTECOST,QUOTES_IDQUOTES) 
--	VALUES ('s','s','s',{ts '2013-05-08 12:24:17.284000'},{ts '2013-05-08 12:24:17.284000'},'s','s','s',0 /*not nullable*/);
--
--
--INSERT INTO "ITINERARY" (DATE,DATEFROM,DATETO,LEAVETYPE,LEAVEDISCRITPTION,TRAVELDAY,TRAVEL_IDTRAVEL,DESTINATION) 
--	VALUES ({ts '2013-05-08 12:24:23.370000'},{ts '2013-05-08 12:24:23.370000'},{ts '2013-05-08 12:24:23.370000'},'s','s','s',0 /*not nullable*/,'s');
--
--
--INSERT INTO "REWARDSPROGRAM" (DESCRIPTION,MEMBERSHIPTYPE,PROVIDER,MEMBERSHIPNUMBER,TRAVELERPROFILE_IDTRAVELERPROFILE) VALUES ('s','s','s','s',0 /*not nullable*/);
--
--
--INSERT INTO "SESSION" (ACCOUNTID,DATE,EXPIRES) VALUES (0 /*not nullable*/,{ts '2013-05-08 12:24:59.450000'},{ts '2013-05-08 12:24:59.450000'});
--INSERT INTO "TRAVELDOCUMENT" (PASSPORTNUMBER,COUNTRY,DATEOFISSUE,EXPIRYDATE,VALIDVISA,TRAVLERPROFILE_IDTRAVLERPROFILE) 
--	VALUES ('s','s',{ts '2013-05-08 12:25:22.150000'},{ts '2013-05-08 12:25:22.150000'},'s',0 /*not nullable*/);


