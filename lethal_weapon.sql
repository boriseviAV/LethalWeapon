-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema lethal_weapon
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lethal_weapon
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `lethal_weapon`;
CREATE SCHEMA IF NOT EXISTS `lethal_weapon` DEFAULT CHARACTER SET utf8 ;
USE `lethal_weapon` ;

-- -----------------------------------------------------
-- Table `lethal_weapon`.`accessories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lethal_weapon`.`accessories` ;

CREATE TABLE IF NOT EXISTS `lethal_weapon`.`accessories` (
  `accessory_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `description` LONGTEXT NULL DEFAULT NULL,
  `picture_url` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`accessory_id`),
  UNIQUE INDEX `accessory_id_UNIQUE` (`accessory_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lethal_weapon`.`categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lethal_weapon`.`categories` ;

CREATE TABLE IF NOT EXISTS `lethal_weapon`.`categories` (
  `category_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `picture_url` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE INDEX `category_id_UNIQUE` (`category_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lethal_weapon`.`weapons`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lethal_weapon`.`weapons` ;

CREATE TABLE IF NOT EXISTS `lethal_weapon`.`weapons` (
  `weapon_id` INT(11) NOT NULL AUTO_INCREMENT,
  `model_name` VARCHAR(45) NULL DEFAULT NULL,
  `holding_way` VARCHAR(45) NULL DEFAULT NULL,
  `country` VARCHAR(45) NULL DEFAULT NULL,
  `weapon_range` VARCHAR(45) NULL DEFAULT NULL,
  `caliber` VARCHAR(45) NULL DEFAULT NULL,
  `ammo_number` INT(11) NULL DEFAULT NULL,
  `optics` TINYINT(1) NULL DEFAULT NULL,
  `stuff` VARCHAR(45) NULL DEFAULT NULL,
  `category_id` INT(11) NULL DEFAULT NULL,
  `picture_url` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`weapon_id`),
  UNIQUE INDEX `weapon_id_UNIQUE` (`weapon_id` ASC),
  INDEX `category_id_idx` (`category_id` ASC),
  CONSTRAINT `category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `lethal_weapon`.`categories` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lethal_weapon`.`weapon_collections`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lethal_weapon`.`weapon_collections` ;

CREATE TABLE IF NOT EXISTS `lethal_weapon`.`weapon_collections` (
  `collection_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL DEFAULT NULL,
  `picture_url` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`collection_id`),
  UNIQUE INDEX `collection_id_UNIQUE` (`collection_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `lethal_weapon`.`weapons_and_collections`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lethal_weapon`.`weapons_and_collections` ;

CREATE TABLE IF NOT EXISTS `lethal_weapon`.`weapons_and_collections` (
  `weap_col_id` INT(11) NOT NULL AUTO_INCREMENT,
  `collection_id` INT(11) NULL DEFAULT NULL,
  `weapon_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`weap_col_id`),
  UNIQUE INDEX `weap_col_id_UNIQUE` (`weap_col_id` ASC),
  INDEX `collection_id_idx` (`collection_id` ASC),
  CONSTRAINT `collection_id`
  FOREIGN KEY (`collection_id`)
  REFERENCES `lethal_weapon`.`weapon_collections` (`collection_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  INDEX `weapon_id_idx` (`weapon_id` ASC),
  CONSTRAINT `weapon_id`
  FOREIGN KEY (`weapon_id`)
  REFERENCES `lethal_weapon`.`weapons` (`weapon_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lethal_weapon`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lethal_weapon`.`users` ;

CREATE TABLE IF NOT EXISTS `lethal_weapon`.`users` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL UNIQUE,
  `password_hash` VARCHAR(200) NOT NULL,
  `email` VARCHAR(40) NOT NULL,
  `role` VARCHAR(40) NOT NULL DEFAULT 'user',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

INSERT INTO users(login, password_hash, email, role) VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', 'admin@mail.ru', 'admin');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
