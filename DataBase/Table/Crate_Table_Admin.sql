/*
 *Create By:    AntSoul
 *Create Date:  11/24/2012
 *Change Hitory:
 *-----------------------------------------------
 *
 *-----------------------------------------------
*/

CREATE TABLE `tb_Admin` (
  `adminID` int(11) NOT NULL auto_increment,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `loginName` varchar(255) DEFAULT NULL,
  `passWord` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adminID`)
)
