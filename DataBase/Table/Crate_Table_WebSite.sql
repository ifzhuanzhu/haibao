/*
 *Create By:    AntSoul
 *Create Date:  11/24/2012
 *Change Hitory:
 *-----------------------------------------------
 *
 *-----------------------------------------------
*/

create table tb_website(
    websiteId INT NOT NULL PRIMARY KEY auto_increment,
    name VARCHAR(100),
    url VARCHAR(100),
    description VARCHAR(1000),
    imageUri VARCHAR(100)
)