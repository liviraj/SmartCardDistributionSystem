CREATE database `scds` ;

use scds;

CREATE TABLE `scds`.`rationcarddetails` (
  `rationCardId` INT NOT NULL AUTO_INCREMENT,
  `familyHeadName` VARCHAR(45) NULL,
  `dob` DATE NULL,
  `gender` VARCHAR(45) NULL,
  `fatherName` VARCHAR(45) NULL,
  `motherName` VARCHAR(45) NULL,
  `occupation` VARCHAR(45) NULL,
  `nofoFamilyMembers` INT NULL,
  `address1` VARCHAR(45) NULL,
  `address2` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `district` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `pincode` VARCHAR(45) NULL,
  PRIMARY KEY (`rationCardId`));
  

ALTER TABLE `scds`.`rationcarddetails` 
ADD COLUMN `rationCardNumber` VARCHAR(45) NULL AFTER `rationCardId`;
