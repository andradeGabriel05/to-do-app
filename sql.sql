CREATE DATABASE IF NOT EXISTS `to_do_app` 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_unicode_ci;

USE `to_do_app`;

CREATE TABLE `project` (
  `idProject` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `description` varchar(200) NOT NULL,
  PRIMARY KEY (`idProject`)
);

CREATE TABLE `task` (
  `idTask` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `description` varchar(60) NOT NULL,
  `period` varchar(30) NOT NULL,
  PRIMARY KEY (`idTask`)
);

COMMIT;
