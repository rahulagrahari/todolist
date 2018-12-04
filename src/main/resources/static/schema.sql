
CREATE TABLE IF NOT EXISTS `User` (
 `user_id` int(20) NOT NULL AUTO_INCREMENT,
 `name` varchar(200) NOT NULL,
 `last_name` varchar(200) NOT NULL,
 `email` varchar(200) NOT NULL,
 `active` int(20) NOT NULL,
 `password` varchar(200) NOT NULL,
 PRIMARY KEY (`user_id`)
);