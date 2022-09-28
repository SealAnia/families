CREATE TABLE IF NOT EXISTS `family` (
	`familyid` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `family_name` varchar(100) NOT NULL,
    `number_of_infants` int default 0,
    `number_of_children` int default 0,
    `number_of_adults` int default 0
);