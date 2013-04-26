SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `mtams` ;
CREATE SCHEMA IF NOT EXISTS `mtams` DEFAULT CHARACTER SET utf8 ;
USE `mtams` ;

-- -----------------------------------------------------
-- Table `mtams`.`Account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`Account` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`Account` (
  `idAccount` INT NOT NULL AUTO_INCREMENT ,
  `Account` VARCHAR(45) NOT NULL ,
  `Password` VARCHAR(512) NOT NULL ,
  `Salt` VARCHAR(45) NULL DEFAULT NULL ,
  `DateCreated` TIMESTAMP NULL DEFAULT NULL ,
  `DateLogin` TIMESTAMP NULL DEFAULT NULL ,
  PRIMARY KEY (`idAccount`) )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = 'Our user  / login details ';


-- -----------------------------------------------------
-- Table `mtams`.`TravelerProfile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`TravelerProfile` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`TravelerProfile` (
  `idTravelerProfile` INT(11) NOT NULL AUTO_INCREMENT ,
  `AccountID` INT(11) NOT NULL ,
  `StaffID` VARCHAR(45) NULL DEFAULT NULL ,
  `GivenName` VARCHAR(45) NULL DEFAULT NULL ,
  `FamilyName` VARCHAR(45) NULL DEFAULT NULL ,
  `Title` VARCHAR(45) NULL DEFAULT NULL ,
  `Department` VARCHAR(45) NULL DEFAULT NULL ,
  `Position` VARCHAR(45) NULL DEFAULT NULL ,
  `IDnumber` VARCHAR(10) NULL DEFAULT NULL ,
  `AttachmentID` VARCHAR(45) NULL DEFAULT NULL ,
  `DateCreated` TIMESTAMP NULL DEFAULT NULL ,
  `DateModified` TIMESTAMP NULL DEFAULT NULL ,
  `TravelBooker` VARCHAR(45) NULL DEFAULT NULL ,
  `BusinessAddress` VARCHAR(255) NULL DEFAULT NULL ,
  `BusinessPhone` VARCHAR(12) NULL DEFAULT NULL ,
  `BusinessFax` VARCHAR(12) NULL DEFAULT NULL ,
  `BusinessEmail` VARCHAR(45) NULL DEFAULT NULL ,
  `HomeAddress` VARCHAR(255) NULL DEFAULT NULL ,
  `HomePhone` VARCHAR(12) NULL DEFAULT NULL ,
  `HomeEmail` VARCHAR(45) NULL DEFAULT NULL ,
  `MobilePhone` VARCHAR(12) NULL DEFAULT NULL ,
  `SpouseName` VARCHAR(45) NULL DEFAULT NULL ,
  `SpouseContactNumber` VARCHAR(45) NULL DEFAULT NULL ,
  `SpouseEmail` VARCHAR(45) NULL DEFAULT NULL ,
  `DoctorsName` VARCHAR(45) NULL DEFAULT NULL ,
  `DoctorsConctactNumber` VARCHAR(45) NULL DEFAULT NULL ,
  `DoctorsEmail` VARCHAR(45) NULL DEFAULT NULL ,
  `KnownMedicalConditions` VARCHAR(512) NULL DEFAULT NULL ,
  `HotelPrefrences` VARCHAR(200) NULL DEFAULT NULL ,
  `FrequentGuest` VARCHAR(45) NULL DEFAULT NULL ,
  `NonSmoking` VARCHAR(45) NULL DEFAULT NULL ,
  `CarPreferences` VARCHAR(200) NULL DEFAULT NULL ,
  `RentalCompany` VARCHAR(45) NULL DEFAULT NULL ,
  `ManualAutomatic` VARCHAR(45) NULL DEFAULT NULL ,
  `Aircon` VARCHAR(45) NULL DEFAULT NULL ,
  `AirlinePreferences` VARCHAR(45) NULL DEFAULT NULL ,
  `Seating` VARCHAR(45) NULL DEFAULT NULL ,
  `ClassDomestic` VARCHAR(45) NULL DEFAULT NULL ,
  `ClassInternational` VARCHAR(45) NULL DEFAULT NULL ,
  `MealRequirements` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idTravelerProfile`) ,
  INDEX `fk_TravlerProfile_users1_idx` (`AccountID` ASC) ,
  INDEX `fk_TravelerProfile_1` (`AccountID` ASC) ,
  CONSTRAINT `fk_TravelerProfile_1`
    FOREIGN KEY (`AccountID` )
    REFERENCES `mtams`.`Account` (`idAccount` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = 'Details of staff member / applicant';


-- -----------------------------------------------------
-- Table `mtams`.`Quotes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`Quotes` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`Quotes` (
  `idQuotes` INT NOT NULL AUTO_INCREMENT ,
  `New` VARCHAR(45) NULL COMMENT 'New or amended\n' ,
  `CostCenter` VARCHAR(45) NULL ,
  `Discritption` VARCHAR(45) NULL ,
  PRIMARY KEY (`idQuotes`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtams`.`FinalCosting`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`FinalCosting` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`FinalCosting` (
  `idFinalCosting` INT NOT NULL AUTO_INCREMENT ,
  `AirfareBudget` FLOAT NULL ,
  `AirfareCost` FLOAT NULL ,
  `CarRentalBudget` FLOAT NULL ,
  `CarRentalCost` FLOAT NULL ,
  `AccommodationBudget` FLOAT NULL ,
  `AccommodationCost` FLOAT NULL ,
  `Quotes_idQuotes` INT NOT NULL ,
  PRIMARY KEY (`idFinalCosting`) ,
  INDEX `fk_FinalCosting_Quotes1` (`Quotes_idQuotes` ASC) ,
  CONSTRAINT `fk_FinalCosting_Quotes1`
    FOREIGN KEY (`Quotes_idQuotes` )
    REFERENCES `mtams`.`Quotes` (`idQuotes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtams`.`Conference`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`Conference` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`Conference` (
  `idConference` INT NOT NULL ,
  `ConferenceName` VARCHAR(45) NULL ,
  `Webpage` VARCHAR(45) NULL ,
  `Country` VARCHAR(45) NULL ,
  `City` VARCHAR(45) NULL ,
  `Presenting` SMALLINT NULL COMMENT 'Are you presenting\n' ,
  `PresentationTitle` VARCHAR(45) NULL ,
  `Authors` VARCHAR(45) NULL ,
  `OtherReasonAttendance` VARCHAR(45) NULL ,
  `DateMSAPresentation` VARCHAR(45) NULL ,
  `ConferenceDuration` VARCHAR(45) NULL ,
  `DateFrom` VARCHAR(45) NULL ,
  `DateTo` VARCHAR(45) NULL ,
  `Replacement` VARCHAR(45) NULL COMMENT 'Do you need coverage for teaching comitments\n' ,
  `ReplacementArrangments` VARCHAR(45) NULL ,
  PRIMARY KEY (`idConference`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtams`.`Travel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`Travel` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`Travel` (
  `idTravel` INT NOT NULL AUTO_INCREMENT ,
  `DateDeparture` TIMESTAMP NULL ,
  `DateReturn` VARCHAR(45) NULL ,
  `Description` VARCHAR(45) NULL ,
  `Conference_idConference` INT NOT NULL ,
  PRIMARY KEY (`idTravel`) ,
  INDEX `fk_Travel_Conference1` (`Conference_idConference` ASC) ,
  CONSTRAINT `fk_Travel_Conference1`
    FOREIGN KEY (`Conference_idConference` )
    REFERENCES `mtams`.`Conference` (`idConference` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtams`.`Application`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`Application` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`Application` (
  `idApplication` INT NOT NULL AUTO_INCREMENT ,
  `Description` VARCHAR(100) NULL ,
  `TravelerProfile_idTravelerProfile` INT NOT NULL ,
  `Quotes_idQuotes` INT NOT NULL ,
  `FinalCosting_idFinalCosting` INT NOT NULL ,
  `Travel_idTravel` INT NOT NULL ,
  `Account_idAccount` INT(11) NOT NULL ,
  PRIMARY KEY (`idApplication`) ,
  INDEX `fk_Application_TravelerProfile1` (`TravelerProfile_idTravelerProfile` ASC) ,
  INDEX `fk_Application_Quotes1` (`Quotes_idQuotes` ASC) ,
  INDEX `fk_Application_FinalCosting1` (`FinalCosting_idFinalCosting` ASC) ,
  INDEX `fk_Application_Travel1` (`Travel_idTravel` ASC) ,
  INDEX `fk_Application_Account1` (`Account_idAccount` ASC) ,
  CONSTRAINT `fk_Application_TravelerProfile1`
    FOREIGN KEY (`TravelerProfile_idTravelerProfile` )
    REFERENCES `mtams`.`TravelerProfile` (`idTravelerProfile` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Application_Quotes1`
    FOREIGN KEY (`Quotes_idQuotes` )
    REFERENCES `mtams`.`Quotes` (`idQuotes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Application_FinalCosting1`
    FOREIGN KEY (`FinalCosting_idFinalCosting` )
    REFERENCES `mtams`.`FinalCosting` (`idFinalCosting` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Application_Travel1`
    FOREIGN KEY (`Travel_idTravel` )
    REFERENCES `mtams`.`Travel` (`idTravel` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Application_Account1`
    FOREIGN KEY (`Account_idAccount` )
    REFERENCES `mtams`.`Account` (`idAccount` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtams`.`Approval`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`Approval` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`Approval` (
  `idApproval` INT NOT NULL AUTO_INCREMENT ,
  `SectionApproved` INT NULL ,
  `Notes` VARCHAR(200) NULL ,
  `Date` VARCHAR(45) NULL ,
  `Application_idApplication` INT NOT NULL ,
  `Account_idAccount` INT(11) NOT NULL ,
  PRIMARY KEY (`idApproval`) ,
  INDEX `fk_Approval_Application1` (`Application_idApplication` ASC) ,
  INDEX `fk_Approval_Account1` (`Account_idAccount` ASC) ,
  CONSTRAINT `fk_Approval_Application1`
    FOREIGN KEY (`Application_idApplication` )
    REFERENCES `mtams`.`Application` (`idApplication` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Approval_Account1`
    FOREIGN KEY (`Account_idAccount` )
    REFERENCES `mtams`.`Account` (`idAccount` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Persons who have to Approve sections of the application';


-- -----------------------------------------------------
-- Table `mtams`.`Task`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`Task` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`Task` (
  `idtasks` INT NOT NULL AUTO_INCREMENT ,
  `task` VARCHAR(45) NULL ,
  `description` VARCHAR(512) NULL ,
  PRIMARY KEY (`idtasks`) )
ENGINE = InnoDB
COMMENT = 'operations which require user privilages\n';


-- -----------------------------------------------------
-- Table `mtams`.`Role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`Role` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`Role` (
  `idroles` INT NOT NULL AUTO_INCREMENT ,
  `role` VARCHAR(45) NOT NULL ,
  `discritption` VARCHAR(512) NULL ,
  PRIMARY KEY (`idroles`) )
ENGINE = InnoDB
COMMENT = 'User are grouped in to roles to simplify the permisions stru' /* comment truncated */;


-- -----------------------------------------------------
-- Table `mtams`.`Permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`Permission` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`Permission` (
  `idpermissions` INT NOT NULL AUTO_INCREMENT ,
  `Permission` VARCHAR(45) NULL ,
  `Discritption` VARCHAR(45) NULL ,
  `CreatePerm` SMALLINT NULL DEFAULT 1 ,
  `DeletePerm` SMALLINT NULL DEFAULT 1 ,
  `UpdatePerm` SMALLINT NULL DEFAULT 1 ,
  `ReadPerm` SMALLINT NULL DEFAULT 0 ,
  `GrantPerm` SMALLINT NULL DEFAULT 1 ,
  `tasks_idtasks` INT NOT NULL ,
  `roles_idroles` INT NOT NULL ,
  PRIMARY KEY (`idpermissions`) ,
  INDEX `fk_permissions_tasks1_idx` (`tasks_idtasks` ASC) ,
  INDEX `fk_permissions_roles1_idx` (`roles_idroles` ASC) ,
  CONSTRAINT `fk_permissions_tasks1`
    FOREIGN KEY (`tasks_idtasks` )
    REFERENCES `mtams`.`Task` (`idtasks` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_permissions_roles1`
    FOREIGN KEY (`roles_idroles` )
    REFERENCES `mtams`.`Role` (`idroles` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Permission controls based on roles in the system\n';


-- -----------------------------------------------------
-- Table `mtams`.`AccountRole`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`AccountRole` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`AccountRole` (
  `idUserRoles` INT NOT NULL AUTO_INCREMENT ,
  `AccountID` INT NULL ,
  `RoleID` INT NULL ,
  PRIMARY KEY (`idUserRoles`) ,
  INDEX `fk_UserRoles_role` (`RoleID` ASC) ,
  INDEX `fk_UserRoles_user` (`AccountID` ASC) ,
  CONSTRAINT `fk_UserRoles_1`
    FOREIGN KEY (`RoleID` )
    REFERENCES `mtams`.`Role` (`idroles` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UserRoles_2`
    FOREIGN KEY (`AccountID` )
    REFERENCES `mtams`.`Account` (`idAccount` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Allows the formation of many to many relationships between a' /* comment truncated */;


-- -----------------------------------------------------
-- Table `mtams`.`Session`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`Session` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`Session` (
  `idSessions` INT NOT NULL AUTO_INCREMENT ,
  `accountid` INT NOT NULL ,
  `Date` TIMESTAMP NULL ,
  `Expires` TIMESTAMP NULL ,
  PRIMARY KEY (`idSessions`, `accountid`) ,
  INDEX `fk_Sessions_user_Idx` (`accountid` ASC) ,
  CONSTRAINT `fk_Sessions_users1`
    FOREIGN KEY (`accountid` )
    REFERENCES `mtams`.`Account` (`idAccount` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'manages the session infomation in the system';


-- -----------------------------------------------------
-- Table `mtams`.`TravelDocument`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`TravelDocument` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`TravelDocument` (
  `idTravelDocuments` INT NOT NULL AUTO_INCREMENT ,
  `PassportNumber` VARCHAR(12) NULL ,
  `Country` VARCHAR(45) NULL ,
  `DateOfIssue` TIMESTAMP NULL ,
  `ExpiryDate` TIMESTAMP NULL ,
  `ValidVisa` VARCHAR(45) NULL ,
  `TravlerProfile_idTravlerProfile` INT NOT NULL ,
  PRIMARY KEY (`idTravelDocuments`) ,
  INDEX `fk_TravelDocuments_TravelerProfile1` (`TravlerProfile_idTravlerProfile` ASC) ,
  CONSTRAINT `fk_TravelDocuments_TravelerProfile1`
    FOREIGN KEY (`TravlerProfile_idTravlerProfile` )
    REFERENCES `mtams`.`TravelerProfile` (`idTravelerProfile` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Passport and Visa Details\n';


-- -----------------------------------------------------
-- Table `mtams`.`Itinerary`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`Itinerary` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`Itinerary` (
  `idItinerary` INT NOT NULL AUTO_INCREMENT ,
  `Date` VARCHAR(45) NULL ,
  `DateFrom` VARCHAR(45) NULL ,
  `DateTo` VARCHAR(45) NULL ,
  `LeaveType` VARCHAR(45) NULL COMMENT 'business or other leave\n' ,
  `LeaveDiscritption` VARCHAR(45) NULL ,
  `TravelDay` VARCHAR(45) NULL COMMENT 'or non working day\nother' ,
  `Travel_idTravel` INT NOT NULL ,
  PRIMARY KEY (`idItinerary`) ,
  INDEX `fk_Itinerary_Travel1` (`Travel_idTravel` ASC) ,
  CONSTRAINT `fk_Itinerary_Travel1`
    FOREIGN KEY (`Travel_idTravel` )
    REFERENCES `mtams`.`Travel` (`idTravel` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtams`.`FlightQuotes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`FlightQuotes` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`FlightQuotes` (
  `idFlightQuotes` INT NOT NULL ,
  `FlightFrom` VARCHAR(45) NULL ,
  `FlightTo` VARCHAR(45) NULL ,
  `DateDeparture` VARCHAR(45) NULL ,
  `DateArrival` VARCHAR(45) NULL ,
  `QuoteSourceDiscription` VARCHAR(45) NULL ,
  `QuoteSource` VARCHAR(45) NULL ,
  `QuoteCost` VARCHAR(45) NULL ,
  `Quotes_idQuotes` INT NOT NULL ,
  PRIMARY KEY (`idFlightQuotes`) ,
  INDEX `fk_FlightQuotes_Quotes1` (`Quotes_idQuotes` ASC) ,
  CONSTRAINT `fk_FlightQuotes_Quotes1`
    FOREIGN KEY (`Quotes_idQuotes` )
    REFERENCES `mtams`.`Quotes` (`idQuotes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtams`.`AccomodationQuotes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`AccomodationQuotes` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`AccomodationQuotes` (
  `idAccomodationQuotes` INT NOT NULL ,
  `DateCheckin` TIMESTAMP NULL ,
  `DateCheckout` TIMESTAMP NULL ,
  `Country` VARCHAR(45) NULL ,
  `City` VARCHAR(45) NULL ,
  `Discritption` VARCHAR(45) NULL ,
  `AccomodationProvider` VARCHAR(45) NULL ,
  `QuoteSource` VARCHAR(45) NULL ,
  `QuoteCost` VARCHAR(45) NULL ,
  `Quotes_idQuotes` INT NOT NULL ,
  PRIMARY KEY (`idAccomodationQuotes`) ,
  INDEX `fk_AccomodationQuotes_Quotes1` (`Quotes_idQuotes` ASC) ,
  CONSTRAINT `fk_AccomodationQuotes_Quotes1`
    FOREIGN KEY (`Quotes_idQuotes` )
    REFERENCES `mtams`.`Quotes` (`idQuotes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtams`.`CarQuotes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`CarQuotes` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`CarQuotes` (
  `idCarQuotes` INT NOT NULL ,
  `DateCollect` TIMESTAMP NULL ,
  `DateReturn` TIMESTAMP NULL ,
  `Provider` VARCHAR(45) NULL ,
  `Discritption` VARCHAR(45) NULL ,
  `QuoteCost` VARCHAR(45) NULL ,
  `Quotes_idQuotes` INT NOT NULL ,
  PRIMARY KEY (`idCarQuotes`) ,
  INDEX `fk_CarQuotes_Quotes1` (`Quotes_idQuotes` ASC) ,
  CONSTRAINT `fk_CarQuotes_Quotes1`
    FOREIGN KEY (`Quotes_idQuotes` )
    REFERENCES `mtams`.`Quotes` (`idQuotes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtams`.`RewardsProgram`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`RewardsProgram` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`RewardsProgram` (
  `idRewardsProgram` INT NOT NULL AUTO_INCREMENT ,
  `Description` VARCHAR(100) NULL ,
  `MembershipType` VARCHAR(45) NULL ,
  `Provider` VARCHAR(45) NULL COMMENT 'The company the provides the rewards program' ,
  `MembershipNumber` VARCHAR(45) NULL ,
  `TravelerProfile_idTravelerProfile` INT NOT NULL ,
  PRIMARY KEY (`idRewardsProgram`) ,
  INDEX `fk_RewardsProgram_TravelerProfile1` (`TravelerProfile_idTravelerProfile` ASC) ,
  CONSTRAINT `fk_RewardsProgram_TravelerProfile1`
    FOREIGN KEY (`TravelerProfile_idTravelerProfile` )
    REFERENCES `mtams`.`TravelerProfile` (`idTravelerProfile` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Frequent Fligher etc';


-- -----------------------------------------------------
-- Table `mtams`.`Attachement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`Attachement` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`Attachement` (
  `idAttachement` INT NOT NULL ,
  `Discription` VARCHAR(45) NULL ,
  `DocumentLocation` VARCHAR(45) NULL ,
  `Conference_idConference` INT NOT NULL ,
  `Itinerary_idItinerary` INT NOT NULL ,
  `Approval_idApproval` INT NOT NULL ,
  `Application_idApplication` INT NOT NULL ,
  `Travel_idTravel` INT NOT NULL ,
  `FinalCosting_idFinalCosting` INT NOT NULL ,
  `CarQuotes_idCarQuotes` INT NOT NULL ,
  `Quotes_idQuotes` INT NOT NULL ,
  `AccomodationQuotes_idAccomodationQuotes` INT NOT NULL ,
  `FlightQuotes_idFlightQuotes` INT NOT NULL ,
  `TravelDocument_idTravelDocuments` INT NOT NULL ,
  `TravelerProfile_idTravelerProfile` INT NOT NULL ,
  `RewardsProgram_idRewardsProgram` INT NOT NULL ,
  PRIMARY KEY (`idAttachement`) ,
  INDEX `fk_Attachement_Conference1` (`Conference_idConference` ASC) ,
  INDEX `fk_Attachement_Itinerary1` (`Itinerary_idItinerary` ASC) ,
  INDEX `fk_Attachement_Approval1` (`Approval_idApproval` ASC) ,
  INDEX `fk_Attachement_Application1` (`Application_idApplication` ASC) ,
  INDEX `fk_Attachement_Travel1` (`Travel_idTravel` ASC) ,
  INDEX `fk_Attachement_FinalCosting1` (`FinalCosting_idFinalCosting` ASC) ,
  INDEX `fk_Attachement_CarQuotes1` (`CarQuotes_idCarQuotes` ASC) ,
  INDEX `fk_Attachement_Quotes1` (`Quotes_idQuotes` ASC) ,
  INDEX `fk_Attachement_AccomodationQuotes1` (`AccomodationQuotes_idAccomodationQuotes` ASC) ,
  INDEX `fk_Attachement_FlightQuotes1` (`FlightQuotes_idFlightQuotes` ASC) ,
  INDEX `fk_Attachement_TravelDocument1` (`TravelDocument_idTravelDocuments` ASC) ,
  INDEX `fk_Attachement_TravelerProfile1` (`TravelerProfile_idTravelerProfile` ASC) ,
  INDEX `fk_Attachement_RewardsProgram1` (`RewardsProgram_idRewardsProgram` ASC) ,
  CONSTRAINT `fk_Attachement_Conference1`
    FOREIGN KEY (`Conference_idConference` )
    REFERENCES `mtams`.`Conference` (`idConference` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_Itinerary1`
    FOREIGN KEY (`Itinerary_idItinerary` )
    REFERENCES `mtams`.`Itinerary` (`idItinerary` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_Approval1`
    FOREIGN KEY (`Approval_idApproval` )
    REFERENCES `mtams`.`Approval` (`idApproval` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_Application1`
    FOREIGN KEY (`Application_idApplication` )
    REFERENCES `mtams`.`Application` (`idApplication` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_Travel1`
    FOREIGN KEY (`Travel_idTravel` )
    REFERENCES `mtams`.`Travel` (`idTravel` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_FinalCosting1`
    FOREIGN KEY (`FinalCosting_idFinalCosting` )
    REFERENCES `mtams`.`FinalCosting` (`idFinalCosting` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_CarQuotes1`
    FOREIGN KEY (`CarQuotes_idCarQuotes` )
    REFERENCES `mtams`.`CarQuotes` (`idCarQuotes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_Quotes1`
    FOREIGN KEY (`Quotes_idQuotes` )
    REFERENCES `mtams`.`Quotes` (`idQuotes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_AccomodationQuotes1`
    FOREIGN KEY (`AccomodationQuotes_idAccomodationQuotes` )
    REFERENCES `mtams`.`AccomodationQuotes` (`idAccomodationQuotes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_FlightQuotes1`
    FOREIGN KEY (`FlightQuotes_idFlightQuotes` )
    REFERENCES `mtams`.`FlightQuotes` (`idFlightQuotes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_TravelDocument1`
    FOREIGN KEY (`TravelDocument_idTravelDocuments` )
    REFERENCES `mtams`.`TravelDocument` (`idTravelDocuments` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_TravelerProfile1`
    FOREIGN KEY (`TravelerProfile_idTravelerProfile` )
    REFERENCES `mtams`.`TravelerProfile` (`idTravelerProfile` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attachement_RewardsProgram1`
    FOREIGN KEY (`RewardsProgram_idRewardsProgram` )
    REFERENCES `mtams`.`RewardsProgram` (`idRewardsProgram` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtams`.`CountryLookup`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`CountryLookup` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`CountryLookup` (
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtams`.`CityLookup`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`CityLookup` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`CityLookup` (
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtams`.`LeaveLookup`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`LeaveLookup` ;

CREATE  TABLE IF NOT EXISTS `mtams`.`LeaveLookup` (
)
ENGINE = InnoDB;


CREATE USER `mtams` IDENTIFIED BY 'mtams';

grant ALL on TABLE `mtams`.`Approval` to mtams;
grant ALL on TABLE `mtams`.`Session` to mtams;
grant ALL on TABLE `mtams`.`FinalCosting` to mtams;
grant ALL on TABLE `mtams`.`Task` to mtams;
grant ALL on TABLE `mtams`.`Permission` to mtams;
grant ALL on TABLE `mtams`.`AccountRole` to mtams;
grant ALL on TABLE `mtams`.`Role` to mtams;
grant ALL on   to mtams;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mtams`.`Task`
-- -----------------------------------------------------
START TRANSACTION;
USE `mtams`;
INSERT INTO `mtams`.`Task` (`idtasks`, `task`, `description`) VALUES (1, 'Application', 'Travel application');
INSERT INTO `mtams`.`Task` (`idtasks`, `task`, `description`) VALUES (2, 'Authorise', 'Authorise travel applications');
INSERT INTO `mtams`.`Task` (`idtasks`, `task`, `description`) VALUES (3, 'Attach', 'Attach document');
INSERT INTO `mtams`.`Task` (`idtasks`, `task`, `description`) VALUES (4, 'Account', 'CRUD users Accounts');

COMMIT;

-- -----------------------------------------------------
-- Data for table `mtams`.`Role`
-- -----------------------------------------------------
START TRANSACTION;
USE `mtams`;
INSERT INTO `mtams`.`Role` (`idroles`, `role`, `discritption`) VALUES (1, 'Super Admin', 'Full access to all functions');
INSERT INTO `mtams`.`Role` (`idroles`, `role`, `discritption`) VALUES (2, 'Admin', 'Admin functions only can not create applications');
INSERT INTO `mtams`.`Role` (`idroles`, `role`, `discritption`) VALUES (3, 'Applicant', 'Can only create application');
INSERT INTO `mtams`.`Role` (`idroles`, `role`, `discritption`) VALUES (4, 'Authorisor', 'Can authorise applications');
INSERT INTO `mtams`.`Role` (`idroles`, `role`, `discritption`) VALUES (5, 'Deactivated', 'No login ');

COMMIT;

-- -----------------------------------------------------
-- Data for table `mtams`.`AccountRole`
-- -----------------------------------------------------
START TRANSACTION;
USE `mtams`;
INSERT INTO `mtams`.`AccountRole` (`idUserRoles`, `AccountID`, `RoleID`) VALUES (1, 1, 1);
INSERT INTO `mtams`.`AccountRole` (`idUserRoles`, `AccountID`, `RoleID`) VALUES (2, 2, 2);
INSERT INTO `mtams`.`AccountRole` (`idUserRoles`, `AccountID`, `RoleID`) VALUES (3, 3, 5);

COMMIT;
