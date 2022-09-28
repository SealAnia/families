CREATE TABLE IF NOT EXISTS `family_member` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `given_name` varchar(100) NOT NULL,
    `family_name` varchar(100) NOT NULL,
    `age` int NOT NULL,
    `family_id` INT NOT NULL

);