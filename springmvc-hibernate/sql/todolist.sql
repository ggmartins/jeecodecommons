CREATE TABLE `todolist` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `taskname` varchar(20) NOT NULL DEFAULT '',
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
