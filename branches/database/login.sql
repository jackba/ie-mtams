SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `mtams` ;
CREATE SCHEMA IF NOT EXISTS `mtams` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `mtams` ;

-- -----------------------------------------------------
-- Table `mtams`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`users` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `mtams`.`users` (
  `iduser` INT NOT NULL AUTO_INCREMENT ,
  `user` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(512) NOT NULL ,
  `salt` VARCHAR(45) NULL ,
  `Active` ENUM('N','Y') NULL ,
  PRIMARY KEY (`iduser`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mtams`.`tasks`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`tasks` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `mtams`.`tasks` (
  `idtasks` INT NOT NULL AUTO_INCREMENT ,
  `task` VARCHAR(45) NULL ,
  `description` VARCHAR(512) NULL ,
  PRIMARY KEY (`idtasks`) )
ENGINE = InnoDB
COMMENT = 'operations which require user privilages\n';

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mtams`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`roles` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `mtams`.`roles` (
  `idroles` INT NOT NULL AUTO_INCREMENT ,
  `role` VARCHAR(45) NOT NULL ,
  `Discritption` VARCHAR(512) NULL ,
  `Active` ENUM('N','Y') NULL ,
  `roleparent` INT NULL ,
  PRIMARY KEY (`idroles`) )
ENGINE = InnoDB
COMMENT = '				';

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mtams`.`permissions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`permissions` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `mtams`.`permissions` (
  `idpermissions` INT NOT NULL AUTO_INCREMENT ,
  `createPerm` ENUM('N','Y') NULL DEFAULT 'N' ,
  `deletePerm` ENUM('N','Y') NULL DEFAULT 'N' ,
  `updatePerm` ENUM('N','Y') NULL DEFAULT 'N' ,
  `readPerm` ENUM('N','Y') NULL DEFAULT 'Y' ,
  `grantPerm` ENUM('N','Y') NULL DEFAULT 'N' ,
  `tasks_idtasks` INT NOT NULL ,
  `roles_idroles` INT NOT NULL ,
  PRIMARY KEY (`idpermissions`) ,
  CONSTRAINT `fk_permissions_tasks1`
    FOREIGN KEY (`tasks_idtasks` )
    REFERENCES `mtams`.`tasks` (`idtasks` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_permissions_roles1`
    FOREIGN KEY (`roles_idroles` )
    REFERENCES `mtams`.`roles` (`idroles` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_permissions_tasks1_idx` ON `mtams`.`permissions` (`tasks_idtasks` ASC) ;

SHOW WARNINGS;
CREATE INDEX `fk_permissions_roles1_idx` ON `mtams`.`permissions` (`roles_idroles` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mtams`.`UserRoles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`UserRoles` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `mtams`.`UserRoles` (
  `idUserRoles` INT NOT NULL AUTO_INCREMENT ,
  `userID` INT NULL ,
  `roleID` INT NULL ,
  PRIMARY KEY (`idUserRoles`) ,
  CONSTRAINT `fk_UserRoles_1`
    FOREIGN KEY (`roleID` )
    REFERENCES `mtams`.`roles` (`idroles` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UserRoles_2`
    FOREIGN KEY (`userID` )
    REFERENCES `mtams`.`users` (`iduser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_UserRoles_role` ON `mtams`.`UserRoles` (`roleID` ASC) ;

SHOW WARNINGS;
CREATE INDEX `fk_UserRoles_user` ON `mtams`.`UserRoles` (`userID` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mtams`.`Sessions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`Sessions` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `mtams`.`Sessions` (
  `idSessions` INT NOT NULL AUTO_INCREMENT ,
  `users_iduser` INT NOT NULL ,
  `date` DATE NULL ,
  `expires` DATETIME NULL ,
  PRIMARY KEY (`idSessions`, `users_iduser`) ,
  CONSTRAINT `fk_Sessions_users1`
    FOREIGN KEY (`users_iduser` )
    REFERENCES `mtams`.`users` (`iduser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_Sessions_user_Idx` ON `mtams`.`Sessions` (`users_iduser` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mtams`.`TravlerProfile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`TravlerProfile` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `mtams`.`TravlerProfile` (
  `idTravlerProfile` INT NOT NULL AUTO_INCREMENT ,
  `users_iduser` INT NOT NULL ,
  `GivenName` VARCHAR(45) NULL ,
  `FamilyName` VARCHAR(45) NULL ,
  `Title` VARCHAR(45) NULL ,
  `Department` VARCHAR(45) NULL ,
  `Position` VARCHAR(45) NULL ,
  `TravelBooker` VARCHAR(45) NULL ,
  `IDnumber` VARCHAR(10) NULL ,
  `BusinessAddress` VARCHAR(255) NULL ,
  `BusinessPhone` VARCHAR(12) NULL ,
  `BusinessFax` VARCHAR(12) NULL ,
  `BusinessEmail` VARCHAR(45) NULL ,
  `HomeAddress` VARCHAR(255) NULL ,
  `HomePhone` VARCHAR(12) NULL ,
  `HomeEmail` VARCHAR(45) NULL ,
  `MobilePhone` VARCHAR(12) NULL ,
  `SpouseName` VARCHAR(45) NULL ,
  `SpouseContactNumber` VARCHAR(45) NULL ,
  `SpouseEmail` VARCHAR(45) NULL ,
  `DoctorsName` VARCHAR(45) NULL ,
  `DoctorsConctactNumber` VARCHAR(45) NULL ,
  `DoctorsEmail` VARCHAR(45) NULL ,
  `KnownMedicalConditions` VARCHAR(512) NULL ,
  `AttachmentID` VARCHAR(45) NULL ,
  PRIMARY KEY (`idTravlerProfile`, `users_iduser`) ,
  CONSTRAINT `fk_TravlerProfile_users1`
    FOREIGN KEY (`users_iduser` )
    REFERENCES `mtams`.`users` (`iduser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Details of staff member / applicant';

SHOW WARNINGS;
CREATE INDEX `fk_TravlerProfile_users1_idx` ON `mtams`.`TravlerProfile` (`users_iduser` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mtams`.`TravelDocuments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mtams`.`TravelDocuments` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `mtams`.`TravelDocuments` (
  `idTravelDocuments` INT NOT NULL AUTO_INCREMENT ,
  `PassportNumber` VARCHAR(12) NULL ,
  `Country` VARCHAR(45) NULL ,
  `DateOfIssue` VARCHAR(45) NULL ,
  `ExpiryDate` VARCHAR(45) NULL ,
  `ValidVisa` VARCHAR(45) NULL ,
  `TravlerProfile_idTravlerProfile` INT NOT NULL ,
  `TravlerProfile_users_iduser` INT NOT NULL ,
  PRIMARY KEY (`idTravelDocuments`) ,
  CONSTRAINT `fk_TravelDocuments_TravlerProfile1`
    FOREIGN KEY (`TravlerProfile_idTravlerProfile` , `TravlerProfile_users_iduser` )
    REFERENCES `mtams`.`TravlerProfile` (`idTravlerProfile` , `users_iduser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Passport and Visa Details\n';

SHOW WARNINGS;
CREATE INDEX `fk_TravelDocuments_TravlerProfile1_idx` ON `mtams`.`TravelDocuments` (`TravlerProfile_idTravlerProfile` ASC, `TravlerProfile_users_iduser` ASC) ;

SHOW WARNINGS;

CREATE USER `mtams` IDENTIFIED BY 'mtams';

grant ALL on TABLE `mtams`.`Approval` to mtams;
grant ALL on TABLE `mtams`.`Sessions` to mtams;
grant ALL on TABLE `mtams`.`FinalCosting` to mtams;
grant ALL on TABLE `mtams`.`tasks` to mtams;
grant ALL on TABLE `mtams`.`permissions` to mtams;
grant ALL on TABLE `mtams`.`UserRoles` to mtams;
grant ALL on TABLE `mtams`.`roles` to mtams;
grant ALL on TABLE `mtams`.`users` to mtams;
SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mtams`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `mtams`;
INSERT INTO `mtams`.`users` (`iduser`, `user`, `password`, `salt`, `Active`) VALUES (1, 'super', 'super', NULL, 'Y');
INSERT INTO `mtams`.`users` (`iduser`, `user`, `password`, `salt`, `Active`) VALUES (2, 'Admin', 'Admin', NULL, 'Y');
INSERT INTO `mtams`.`users` (`iduser`, `user`, `password`, `salt`, `Active`) VALUES (3, 'test', 'test', NULL, 'Y');

COMMIT;

-- -----------------------------------------------------
-- Data for table `mtams`.`tasks`
-- -----------------------------------------------------
START TRANSACTION;
USE `mtams`;
INSERT INTO `mtams`.`tasks` (`idtasks`, `task`, `description`) VALUES (1, 'Application', 'Travel application');
INSERT INTO `mtams`.`tasks` (`idtasks`, `task`, `description`) VALUES (2, 'Authorise', 'Authorise travel applications');
INSERT INTO `mtams`.`tasks` (`idtasks`, `task`, `description`) VALUES (3, 'Attach', 'Attach document');
INSERT INTO `mtams`.`tasks` (`idtasks`, `task`, `description`) VALUES (4, 'User', 'CRUD users');

COMMIT;

-- -----------------------------------------------------
-- Data for table `mtams`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `mtams`;
INSERT INTO `mtams`.`roles` (`idroles`, `role`, `Discritption`, `Active`, `roleparent`) VALUES (1, 'Super Admin', 'Full access to all functions', 'Y', NULL);
INSERT INTO `mtams`.`roles` (`idroles`, `role`, `Discritption`, `Active`, `roleparent`) VALUES (2, 'Admin', 'Admin functions only can not create applications', 'Y', NULL);
INSERT INTO `mtams`.`roles` (`idroles`, `role`, `Discritption`, `Active`, `roleparent`) VALUES (3, 'Applicant', 'Can only create application', 'Y', NULL);
INSERT INTO `mtams`.`roles` (`idroles`, `role`, `Discritption`, `Active`, `roleparent`) VALUES (4, 'Authorisor', 'Can authorise applications', 'Y', NULL);
INSERT INTO `mtams`.`roles` (`idroles`, `role`, `Discritption`, `Active`, `roleparent`) VALUES (5, 'Test', 'No login required', 'Y', NULL);

COMMIT;

-- -----------------------------------------------------
-- Data for table `mtams`.`UserRoles`
-- -----------------------------------------------------
START TRANSACTION;
USE `mtams`;
INSERT INTO `mtams`.`UserRoles` (`idUserRoles`, `userID`, `roleID`) VALUES (1, 1, 1);
INSERT INTO `mtams`.`UserRoles` (`idUserRoles`, `userID`, `roleID`) VALUES (2, 2, 2);
INSERT INTO `mtams`.`UserRoles` (`idUserRoles`, `userID`, `roleID`) VALUES (NULL, 3, 5);

COMMIT;

-- -----------------------------------------------------
-- Data for table `mtams`.`TravlerProfile`
-- -----------------------------------------------------
START TRANSACTION;
USE `mtams`;
INSERT INTO `mtams`.`TravlerProfile` (`idTravlerProfile`, `users_iduser`, `GivenName`, `FamilyName`, `Title`, `Department`, `Position`, `TravelBooker`, `IDnumber`, `BusinessAddress`, `BusinessPhone`, `BusinessFax`, `BusinessEmail`, `HomeAddress`, `HomePhone`, `HomeEmail`, `MobilePhone`, `SpouseName`, `SpouseContactNumber`, `SpouseEmail`, `DoctorsName`, `DoctorsConctactNumber`, `DoctorsEmail`, `KnownMedicalConditions`, `AttachmentID`) VALUES (1, 3, 'Test', 'Test', 'Test', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

COMMIT;
