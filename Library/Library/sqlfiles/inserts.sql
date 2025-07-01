use library;

--
-- Volcado de datos para la tabla `books`
--

INSERT INTO `books` (`id`, `title`, `synopsis`, `author`, `year`, `genre`) VALUES
(1, 'Harry Potter 1', 'las mágicas aventuras de Harry y sus amigos', 'J.K.Rowling', 2001, 'Fantasía'),
(2, 'El Misterio del Bosque', 'Un grupo de amigos se adentra en un bosque encantado.', 'Laura Méndez', 1998, 'Fantasía'),
(3, 'Códigos del Pasado', 'Un arqueólogo encuentra un códice que cambiará la historia.', 'Carlos Romero', 2007, 'Aventura'),
(4, 'Amor en la Lluvia', 'Una historia romántica entre dos desconocidos en París.', 'Isabel Fernández', 2015, 'Romance'),
(5, 'La Máquina del Tiempo', 'Un científico viaja accidentalmente al futuro.', 'Miguel Torres', 2003, 'Ciencia ficción'),
(6, 'Sombras del Alma', 'Un thriller psicológico sobre un crimen sin resolver.', 'Ana Beltrán', 2011, 'Suspenso'),
(7, 'La Rebelión del Fénix', 'Un reino oprimido se levanta contra su tirano.', 'Julio Santamaría', 2019, 'Fantasía'),
(8, 'Bajo el Mar del Norte', 'Un grupo de buzos descubre un secreto bajo el océano.', 'Clara Ruiz', 2005, 'Aventura'),
(9, 'Recuerdos en Papel', 'Un escritor revive su pasado a través de antiguos manuscritos.', 'Fernando Pérez', 1995, 'Drama'),
(10, 'El Último Hacker', 'Un joven prodigio se enfrenta a una conspiración global.', 'Ricardo Molina', 2020, 'Tecnología'),
(11, 'Estación Aurora', 'Un astronauta lucha por sobrevivir en una estación espacial.', 'Marina Soto', 2023, 'Ciencia ficción'),
(12, 'Harry Potter 2', 'las mágicas aventuras de Harry y sus amigos y las arañas', 'J.K.Rowling', 2002, 'Fantasía');

-- --------------------------------------------------------

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `password`) VALUES
(1, 'Marc', 'MarcMarc', '123456'),
(2, 'Lucía', 'lucia_star', 'pass1234'),
(3, 'Andrés', 'andres89', 'qwerty89'),
(4, 'Valeria', 'val.val', 'sunshine!'),
(5, 'Tomás', 'tomas_dev', 'codeMe2024'),
(6, 'Sofía', 'sof_1990', 'myPass@1'),
(7, 'Diego', 'dieguito', 'abcDEF123'),
(8, 'Camila', 'camila_ro', '!holaMundo'),
(9, 'Mateo', 'mateo_xx', 'passWORD321'),
(10, 'Elena', 'elena_love', 'cats4Life'),
(11, 'Gabriel', 'gab_777', 'secure!22'),
(12, 'Paco', 'P4C0_360', 'olmpfwfe');

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

