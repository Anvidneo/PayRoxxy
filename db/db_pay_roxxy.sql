-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-06-2021 a las 04:42:46
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_pay_roxxy`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_condominiums`
--

CREATE TABLE `tbl_condominiums` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_condominiums`
--

INSERT INTO `tbl_condominiums` (`id`, `name`) VALUES
(1, 'COND001'),
(2, 'COND002');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_entitys`
--

CREATE TABLE `tbl_entitys` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_entitys`
--

INSERT INTO `tbl_entitys` (`id`, `name`) VALUES
(1, 'Neivor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_fees_paid`
--

CREATE TABLE `tbl_fees_paid` (
  `id` int(11) NOT NULL,
  `amount_paid` double DEFAULT NULL,
  `date_paid` varchar(255) DEFAULT NULL,
  `id_quota` int(11) DEFAULT NULL,
  `place_paid` varchar(255) DEFAULT NULL,
  `id_transaction` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_quotas`
--

CREATE TABLE `tbl_quotas` (
  `num_quota` int(11) NOT NULL,
  `amount_comision` double DEFAULT NULL,
  `amount_cuota` double DEFAULT NULL,
  `detail_quota` varchar(255) DEFAULT NULL,
  `expiration_date` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_quotas`
--

INSERT INTO `tbl_quotas` (`num_quota`, `amount_comision`, `amount_cuota`, `detail_quota`, `expiration_date`, `user_id`) VALUES
(1, 0, 750, 'pedido de  Enero', '20160131', 1),
(2, 0, 750, 'pedido de  Febrero', '20160231', 1),
(3, 0, 750, 'pedido de  Marzo', '20160331', 1),
(4, 0, 750, 'pedido de  Junio', '20210630', 1),
(5, 0, 750, 'pedido de  Enero', '20210131', 2),
(6, 0, 750, 'pedido de  Febrero', '20210231', 2),
(7, 0, 750, 'pedido de  Marzo', '20210331', 2),
(8, 0, 750, 'pedido de  Junio', '20210530', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_reversed_paids`
--

CREATE TABLE `tbl_reversed_paids` (
  `id` int(11) NOT NULL,
  `date_reverserd` varchar(255) DEFAULT NULL,
  `id_quota` int(11) DEFAULT NULL,
  `id_transaction` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_reversed_paids`
--

INSERT INTO `tbl_reversed_paids` (`id`, `date_reverserd`, `id_quota`, `id_transaction`) VALUES
(4, '20210615', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_users`
--

CREATE TABLE `tbl_users` (
  `id` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `entity_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_users`
--

INSERT INTO `tbl_users` (`id`, `password`, `user`, `entity_id`, `name`) VALUES
(1, '123456', 'Anvidneo', 1, 'Juan Botero'),
(2, '456789', 'Anvid', 1, 'Carlos Giraldo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_condominiums`
--
ALTER TABLE `tbl_condominiums`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tbl_entitys`
--
ALTER TABLE `tbl_entitys`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tbl_fees_paid`
--
ALTER TABLE `tbl_fees_paid`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tbl_quotas`
--
ALTER TABLE `tbl_quotas`
  ADD PRIMARY KEY (`num_quota`);

--
-- Indices de la tabla `tbl_reversed_paids`
--
ALTER TABLE `tbl_reversed_paids`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tbl_users`
--
ALTER TABLE `tbl_users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_condominiums`
--
ALTER TABLE `tbl_condominiums`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tbl_entitys`
--
ALTER TABLE `tbl_entitys`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tbl_fees_paid`
--
ALTER TABLE `tbl_fees_paid`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tbl_quotas`
--
ALTER TABLE `tbl_quotas`
  MODIFY `num_quota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tbl_reversed_paids`
--
ALTER TABLE `tbl_reversed_paids`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tbl_users`
--
ALTER TABLE `tbl_users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
