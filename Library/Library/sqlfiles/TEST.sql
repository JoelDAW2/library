-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-06-2025 a las 13:13:19
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

Create database if not exists library;
use library;

drop table if exists books, users, reviews;

CREATE TABLE `books` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `title` varchar(255) DEFAULT NULL,
  `synopsis` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reviews`
--

CREATE TABLE `reviews` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`user_id` int(11) NOT NULL,
	`book_id` int(11) NOT NULL,
	`score` int(11) DEFAULT NULL,
	`comment` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`name` varchar(255) DEFAULT NULL,
	`username` varchar(255) DEFAULT NULL,
	`password` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE `reviews` ADD CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`), ADD CONSTRAINT `reviews_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`); COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
-- ------------------------------------------------------------------------------------------
INSERT INTO `books` (`title`, `synopsis`, `author`, `year`, `genre`) VALUES
('Harry Potter 1', 'las mágicas aventuras de Harry y sus amigos', 'J.K.Rowling', 2001, 'Fantasía'),
('El Misterio del Bosque', 'Un grupo de amigos se adentra en un bosque encantado.', 'Laura Méndez', 1998, 'Fantasía'),
('Códigos del Pasado', 'Un arqueólogo encuentra un códice que cambiará la historia.', 'Carlos Romero', 2007, 'Aventura'),
('Amor en la Lluvia', 'Una historia romántica entre dos desconocidos en París.', 'Isabel Fernández', 2015, 'Romance'),
('La Máquina del Tiempo', 'Un científico viaja accidentalmente al futuro.', 'Miguel Torres', 2003, 'Ciencia ficción'),
('Sombras del Alma', 'Un thriller psicológico sobre un crimen sin resolver.', 'Ana Beltrán', 2011, 'Suspenso'),
('La Rebelión del Fénix', 'Un reino oprimido se levanta contra su tirano.', 'Julio Santamaría', 2019, 'Fantasía'),
('Bajo el Mar del Norte', 'Un grupo de buzos descubre un secreto bajo el océano.', 'Clara Ruiz', 2005, 'Aventura'),
('Recuerdos en Papel', 'Un escritor revive su pasado a través de antiguos manuscritos.', 'Fernando Pérez', 1995, 'Drama'),
('El Último Hacker', 'Un joven prodigio se enfrenta a una conspiración global.', 'Ricardo Molina', 2020, 'Tecnología'),
('Estación Aurora', 'Un astronauta lucha por sobrevivir en una estación espacial.', 'Marina Soto', 2023, 'Ciencia ficción'),
('Harry Potter 2', 'las mágicas aventuras de Harry y sus amigos y las arañas', 'J.K.Rowling', 2002, 'Fantasía');

-- --------------------------------------------------------
--
-- Volcado de datos para la tabla `users`
--
INSERT INTO `users` (`name`, `username`, `password`) VALUES
('Marc', 'MarcMarc', '123456'),
('Lucía', 'lucia_star', 'pass1234'),
('Andrés', 'andres89', 'qwerty89'),
('Valeria', 'val.val', 'sunshine!'),
('Tomás', 'tomas_dev', 'codeMe2024'),
('Sofía', 'sof_1990', 'myPass@1'),
('Diego', 'dieguito', 'abcDEF123'),
('Camila', 'camila_ro', '!holaMundo'),
('Mateo', 'mateo_xx', 'passWORD321'),
('Elena', 'elena_love', 'cats4Life'),
('Gabriel', 'gab_777', 'secure!22'),
('Paco', 'P4C0_360', 'olmpfwfe');
-- --------------------------------------------------------
--
-- Volcado de datos para la tabla `reviews`
--
INSERT INTO `reviews` (`user_id`, `book_id`, `score`, `comment`) VALUES
(1, 4, 8, 'Muy bien narrado, me mantuvo enganchado.'),
(2, 7, 6, 'Le faltó algo de emoción.'),
(3, 1, 9, 'Un libro excelente, lo recomiendo.'),
(4, 12, 7, 'Interesante, aunque algo predecible.'),
(5, 3, 10, 'Una joya literaria, me encantó.'),
(6, 9, 4, 'No logró atraparme.'),
(7, 11, 5, 'Meh, esperaba más.'),
(8, 2, 9, 'Muy buena historia, personajes entrañables.'),
(9, 10, 6, 'Bien escrito, pero un poco largo.'),
(12, 8, 8, 'Entretenido y con buen ritmo.');

Select * from users;
Select * from books;
Select * from reviews;