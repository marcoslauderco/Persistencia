CREATE TABLE `categorias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

/*
-- Query: SELECT * FROM persistencia.categorias
LIMIT 0, 1000
-- Date: 2022-11-10 09:33
*/
INSERT INTO `categorias` (`id`,`descricao`) VALUES (1,'Computadores');
INSERT INTO `categorias` (`id`,`descricao`) VALUES (2,'Monitores');
INSERT INTO `categorias` (`id`,`descricao`) VALUES (3,'Periféricos');