-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-07-2025 a las 19:56:12
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistema`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `centrosalud`
--

CREATE TABLE `centrosalud` (
  `id_centro` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `direccion` text DEFAULT NULL,
  `ubicacion_gps` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `centrosalud`
--

INSERT INTO `centrosalud` (`id_centro`, `nombre`, `direccion`, `ubicacion_gps`) VALUES
(2, 'Hospital Negreiros', 'asdasdasd', ''),
(3, 'Hospital Rebagliati', 'asdad', ''),
(4, 'Centro de Salud Miraflores', 'Av. Pardo 123, Miraflores', NULL),
(5, 'Centro Médico San Juan', 'Jr. Los Próceres 456, San Juan de Lurigancho', NULL),
(6, 'Policlínico Santa Rosa', 'Av. Grau 789, Cercado de Lima', NULL),
(7, 'Posta Médica Villa El Salvador', 'Mz. A Lt. 5, Villa El Salvador', NULL),
(8, 'Centro de Salud Comas', 'Av. Universitaria 999, Comas', NULL),
(9, 'Clínica Los Olivos', 'Av. Palmeras 222, Los Olivos', NULL),
(10, 'Centro Médico Callao', 'Av. Sáenz Peña 333, Callao', NULL),
(11, 'Centro Médico Jesús María', 'Av. Arenales 567, Jesús María', NULL),
(12, 'Centro de Salud Surco', 'Av. Caminos del Inca 1010, Santiago de Surco', NULL),
(13, 'Clínica Pueblo Libre', 'Av. Bolívar 444, Pueblo Libre', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citamedica`
--

CREATE TABLE `citamedica` (
  `id_cita` int(11) NOT NULL,
  `fecha_hora` datetime DEFAULT NULL,
  `tipo_atencion` varchar(100) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `id_paciente` int(11) DEFAULT NULL,
  `id_medico` int(11) DEFAULT NULL,
  `id_centro` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `citamedica`
--

INSERT INTO `citamedica` (`id_cita`, `fecha_hora`, `tipo_atencion`, `estado`, `id_paciente`, `id_medico`, `id_centro`) VALUES
(6, '2025-07-17 00:00:00', 'Traumatología', 'Pendiente', 23, 21, 4),
(7, '2025-07-07 00:00:00', 'Urologia', 'Atendido', 23, 8, 2),
(8, '2025-08-19 00:00:00', 'Neurología', 'Pendiente', 23, 18, 5),
(9, '2025-07-15 00:00:00', 'Neurología', 'Pendiente', 23, 18, 8),
(10, '2025-07-31 00:00:00', 'Urologia', 'Pendiente', 23, 8, 2),
(11, '2025-09-18 00:00:00', 'Urologia', 'Atendido', 23, 8, 2),
(12, '2026-10-07 00:00:00', 'Pediatría', 'Atendido', 23, 16, 2),
(13, '2025-07-15 12:30:00', 'Ginecología', 'Atendido', 23, 42, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historialclinico`
--

CREATE TABLE `historialclinico` (
  `id_historial` int(11) NOT NULL,
  `id_paciente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `historialclinico`
--

INSERT INTO `historialclinico` (`id_historial`, `id_paciente`) VALUES
(1, 23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE `mensaje` (
  `id_mensaje` int(11) NOT NULL,
  `id_remitente` int(11) DEFAULT NULL,
  `id_destinatario` int(11) DEFAULT NULL,
  `contenido` text DEFAULT NULL,
  `fecha_hora` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notificacion`
--

CREATE TABLE `notificacion` (
  `id_notificacion` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `mensaje` text DEFAULT NULL,
  `fecha_hora_envio` datetime DEFAULT current_timestamp(),
  `tipo` enum('Recordatorio','Resultado','Campaña','Cita') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `id_paciente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`id_paciente`) VALUES
(23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personalmedico`
--

CREATE TABLE `personalmedico` (
  `id_medico` int(11) NOT NULL,
  `especialidad` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `DNI` varchar(20) DEFAULT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `contacto` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `personalmedico`
--

INSERT INTO `personalmedico` (`id_medico`, `especialidad`, `nombre`, `apellido`, `DNI`, `direccion`, `contacto`) VALUES
(8, 'Urologia', NULL, NULL, NULL, NULL, NULL),
(16, 'Pediatría', 'Carlos', 'Ramírez', '12345668', 'Av. Los Álamos 123', '987654321'),
(17, 'Cardiología', 'Ana', 'García', '87654321', 'Jr. Las Flores 456', '912345678'),
(18, 'Neurología', 'Luis', 'Fernández', '11223344', 'Calle Los Pinos 789', '921234567'),
(19, 'Ginecología', 'María', 'Torres', '33445566', 'Av. La Paz 321', '934567890'),
(20, 'Dermatología', 'Pedro', 'López', '55667788', 'Calle Lima 654', '945678901'),
(21, 'Traumatología', 'Lucía', 'Martínez', '99887766', 'Jr. Arequipa 321', '956789012'),
(22, 'Psiquiatría', 'Jorge', 'Sánchez', '44556677', 'Av. Bolívar 111', '967890123'),
(24, 'Pediatría', 'Laura', 'Quispe', '11110001', 'Av. Lima 100', '900100001'),
(25, 'Pediatría', 'Mario', 'Alvarez', '11110002', 'Jr. Cuzco 101', '900100002'),
(26, 'Pediatría', 'Rosa', 'Valle', '11110003', 'Calle Piura 102', '900100003'),
(27, 'Pediatría', 'Elías', 'Mendoza', '11110004', 'Av. Arequipa 103', '900100004'),
(28, 'Pediatría', 'Karla', 'Soto', '11110005', 'Av. Brasil 104', '900100005'),
(29, 'Cardiología', 'Víctor', 'Pérez', '11120001', 'Av. Grau 200', '900200001'),
(30, 'Cardiología', 'Isabel', 'Chávez', '11120002', 'Jr. Puno 201', '900200002'),
(31, 'Cardiología', 'Fernando', 'Ruiz', '11120003', 'Calle Lima 202', '900200003'),
(32, 'Cardiología', 'Diana', 'Ramos', '11120004', 'Av. Túpac 203', '900200004'),
(33, 'Cardiología', 'Alonso', 'Gómez', '11120005', 'Av. Salaverry 204', '900200005'),
(34, 'Neurología', 'Carmen', 'Torres', '11130001', 'Av. Benavides 300', '900300001'),
(35, 'Neurología', 'Raúl', 'Luna', '11130002', 'Jr. Bolívar 301', '900300002'),
(36, 'Neurología', 'Sara', 'Campos', '11130003', 'Calle San Martín 302', '900300003'),
(37, 'Neurología', 'Jorge', 'León', '11130004', 'Av. Colonial 303', '900300004'),
(38, 'Neurología', 'Milagros', 'Salas', '11130005', 'Jr. Tarata 304', '900300005'),
(39, 'Ginecología', 'Natalia', 'Muñoz', '11140001', 'Av. San Juan 400', '900400001'),
(40, 'Ginecología', 'Daniel', 'Herrera', '11140002', 'Jr. México 401', '900400002'),
(41, 'Ginecología', 'Julia', 'Silva', '11140003', 'Calle Cusco 402', '900400003'),
(42, 'Ginecología', 'Andrés', 'Peña', '11140004', 'Av. Independencia 403', '900400004'),
(43, 'Ginecología', 'Rocío', 'Ibáñez', '11140005', 'Av. Zarumilla 404', '900400005'),
(44, 'Dermatología', 'Patricia', 'Aguilar', '11150001', 'Av. Progreso 500', '900500001'),
(45, 'Dermatología', 'Esteban', 'Delgado', '11150002', 'Jr. Unión 501', '900500002'),
(46, 'Dermatología', 'Lucero', 'Ríos', '11150003', 'Calle Los Andes 502', '900500003'),
(47, 'Dermatología', 'Óscar', 'Navarro', '11150004', 'Av. Javier Prado 503', '900500004'),
(48, 'Dermatología', 'Gina', 'Vásquez', '11150005', 'Av. Universitaria 504', '900500005'),
(49, 'Traumatología', 'Henry', 'Sánchez', '11160001', 'Av. Angamos 600', '900600001'),
(50, 'Traumatología', 'Elena', 'Ramírez', '11160002', 'Jr. San Pedro 601', '900600002'),
(51, 'Traumatología', 'Iván', 'Guerra', '11160003', 'Calle Loreto 602', '900600003'),
(52, 'Traumatología', 'Silvana', 'Vega', '11160004', 'Av. Perú 603', '900600004'),
(53, 'Traumatología', 'Paolo', 'Zamora', '11160005', 'Av. Argentina 604', '900600005'),
(54, 'Psiquiatría', 'Martha', 'Solis', '11170001', 'Av. Guardia Civil 700', '900700001'),
(55, 'Psiquiatría', 'Bruno', 'Pineda', '11170002', 'Jr. Francia 701', '900700002'),
(56, 'Psiquiatría', 'Nuria', 'Campos', '11170003', 'Calle Amazonas 702', '900700003'),
(57, 'Psiquiatría', 'Tomás', 'Reyes', '11170004', 'Av. Venezuela 703', '900700004'),
(58, 'Psiquiatría', 'Yesenia', 'Bravo', '11170005', 'Av. Canadá 704', '900700005'),
(59, 'Urología', 'Renato', 'Gonzales', '11180001', 'Av. La Marina 800', '900800001'),
(60, 'Urología', 'Luciana', 'Paredes', '11180002', 'Calle El Sol 801', '900800002'),
(61, 'Urología', 'Cristian', 'Morales', '11180003', 'Jr. Primavera 802', '900800003'),
(62, 'Urología', 'Fiorella', 'Ramirez', '11180004', 'Av. Canadá 803', '900800004'),
(63, 'Urología', 'Gustavo', 'Rojas', '11180005', 'Av. Javier Prado 804', '900800005');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registrohistorial`
--

CREATE TABLE `registrohistorial` (
  `id_registro` int(11) NOT NULL,
  `id_historial` int(11) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `fecha_registro` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombres` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `dni` char(8) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `direccion` text DEFAULT NULL,
  `contacto` varchar(20) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `contraseña` varchar(255) DEFAULT NULL,
  `rol` enum('admin','paciente','medico') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombres`, `apellidos`, `dni`, `fecha_nacimiento`, `direccion`, `contacto`, `correo`, `contraseña`, `rol`) VALUES
(3, 'Admin', 'General', '99999999', '1990-01-01', 'Sistema Central', '999999999', 'admin', 'admin', 'admin'),
(4, 'Diego', 'Chu', '70913815', '2003-03-06', 'asdasdsa', '973352963', 'diego@gmail.com', '12345', 'paciente'),
(8, 'asdasd', 'asdasd', '12345678', '2003-05-04', 'asdsadsa', '123456789', NULL, NULL, 'medico'),
(16, 'Carlos', 'Ramírez', '12345677', '1980-01-01', 'Av. Los Álamos 123', '987654321', 'carlos@correo.com', '1234', 'medico'),
(17, 'Ana', 'García', '87654321', '1985-02-15', 'Jr. Las Flores 456', '912345678', 'ana@correo.com', '1234', 'medico'),
(18, 'Luis', 'Fernández', '11223344', '1978-03-20', 'Calle Los Pinos 789', '921234567', 'luis@correo.com', '1234', 'medico'),
(19, 'María', 'Torres', '33445566', '1990-04-10', 'Av. La Paz 321', '934567890', 'maria@correo.com', '1234', 'medico'),
(20, 'Pedro', 'López', '55667788', '1982-05-05', 'Calle Lima 654', '945678901', 'pedro@correo.com', '1234', 'medico'),
(21, 'Lucía', 'Martínez', '99887766', '1987-06-12', 'Jr. Arequipa 321', '956789012', 'lucia@correo.com', '1234', 'medico'),
(22, 'Jorge', 'Sánchez', '44556677', '1975-07-30', 'Av. Bolívar 111', '967890123', 'jorge@correo.com', '1234', 'medico'),
(23, 'Mauricio', 'Revilla Sotomayor', '75576374', '2003-02-12', 'Calle Talara 2010 Santiago de Surco', '955099552', 'mauricio@123', '1234567', 'paciente'),
(24, 'Laura', 'Quispe', '11110001', '1990-01-01', 'Av. Lima 100', '900100001', 'laura1@correo.com', '1234', 'medico'),
(25, 'Mario', 'Alvarez', '11110002', '1988-01-02', 'Jr. Cuzco 101', '900100002', 'mario2@correo.com', '1234', 'medico'),
(26, 'Rosa', 'Valle', '11110003', '1992-01-03', 'Calle Piura 102', '900100003', 'rosa3@correo.com', '1234', 'medico'),
(27, 'Elías', 'Mendoza', '11110004', '1991-01-04', 'Av. Arequipa 103', '900100004', 'elias4@correo.com', '1234', 'medico'),
(28, 'Karla', 'Soto', '11110005', '1993-01-05', 'Av. Brasil 104', '900100005', 'karla5@correo.com', '1234', 'medico'),
(29, 'Víctor', 'Pérez', '11120001', '1987-02-01', 'Av. Grau 200', '900200001', 'victor1@correo.com', '1234', 'medico'),
(30, 'Isabel', 'Chávez', '11120002', '1990-02-02', 'Jr. Puno 201', '900200002', 'isabel2@correo.com', '1234', 'medico'),
(31, 'Fernando', 'Ruiz', '11120003', '1991-02-03', 'Calle Lima 202', '900200003', 'fernando3@correo.com', '1234', 'medico'),
(32, 'Diana', 'Ramos', '11120004', '1992-02-04', 'Av. Túpac 203', '900200004', 'diana4@correo.com', '1234', 'medico'),
(33, 'Alonso', 'Gómez', '11120005', '1989-02-05', 'Av. Salaverry 204', '900200005', 'alonso5@correo.com', '1234', 'medico'),
(34, 'Carmen', 'Torres', '11130001', '1986-03-01', 'Av. Benavides 300', '900300001', 'carmen1@correo.com', '1234', 'medico'),
(35, 'Raúl', 'Luna', '11130002', '1990-03-02', 'Jr. Bolívar 301', '900300002', 'raul2@correo.com', '1234', 'medico'),
(36, 'Sara', 'Campos', '11130003', '1985-03-03', 'Calle San Martín 302', '900300003', 'sara3@correo.com', '1234', 'medico'),
(37, 'Jorge', 'León', '11130004', '1989-03-04', 'Av. Colonial 303', '900300004', 'jorge4@correo.com', '1234', 'medico'),
(38, 'Milagros', 'Salas', '11130005', '1992-03-05', 'Jr. Tarata 304', '900300005', 'milagros5@correo.com', '1234', 'medico'),
(39, 'Natalia', 'Muñoz', '11140001', '1993-04-01', 'Av. San Juan 400', '900400001', 'natalia1@correo.com', '1234', 'medico'),
(40, 'Daniel', 'Herrera', '11140002', '1987-04-02', 'Jr. México 401', '900400002', 'daniel2@correo.com', '1234', 'medico'),
(41, 'Julia', 'Silva', '11140003', '1986-04-03', 'Calle Cusco 402', '900400003', 'julia3@correo.com', '1234', 'medico'),
(42, 'Andrés', 'Peña', '11140004', '1991-04-04', 'Av. Independencia 403', '900400004', 'andres4@correo.com', '1234', 'medico'),
(43, 'Rocío', 'Ibáñez', '11140005', '1990-04-05', 'Av. Zarumilla 404', '900400005', 'rocio5@correo.com', '1234', 'medico'),
(44, 'Patricia', 'Aguilar', '11150001', '1989-05-01', 'Av. Progreso 500', '900500001', 'patricia1@correo.com', '1234', 'medico'),
(45, 'Esteban', 'Delgado', '11150002', '1992-05-02', 'Jr. Unión 501', '900500002', 'esteban2@correo.com', '1234', 'medico'),
(46, 'Lucero', 'Ríos', '11150003', '1988-05-03', 'Calle Los Andes 502', '900500003', 'lucero3@correo.com', '1234', 'medico'),
(47, 'Óscar', 'Navarro', '11150004', '1987-05-04', 'Av. Javier Prado 503', '900500004', 'oscar4@correo.com', '1234', 'medico'),
(48, 'Gina', 'Vásquez', '11150005', '1991-05-05', 'Av. Universitaria 504', '900500005', 'gina5@correo.com', '1234', 'medico'),
(49, 'Henry', 'Sánchez', '11160001', '1986-06-01', 'Av. Angamos 600', '900600001', 'henry1@correo.com', '1234', 'medico'),
(50, 'Elena', 'Ramírez', '11160002', '1987-06-02', 'Jr. San Pedro 601', '900600002', 'elena2@correo.com', '1234', 'medico'),
(51, 'Iván', 'Guerra', '11160003', '1989-06-03', 'Calle Loreto 602', '900600003', 'ivan3@correo.com', '1234', 'medico'),
(52, 'Silvana', 'Vega', '11160004', '1990-06-04', 'Av. Perú 603', '900600004', 'silvana4@correo.com', '1234', 'medico'),
(53, 'Paolo', 'Zamora', '11160005', '1991-06-05', 'Av. Argentina 604', '900600005', 'paolo5@correo.com', '1234', 'medico'),
(54, 'Martha', 'Solis', '11170001', '1990-07-01', 'Av. Guardia Civil 700', '900700001', 'martha1@correo.com', '1234', 'medico'),
(55, 'Bruno', 'Pineda', '11170002', '1988-07-02', 'Jr. Francia 701', '900700002', 'bruno2@correo.com', '1234', 'medico'),
(56, 'Nuria', 'Campos', '11170003', '1992-07-03', 'Calle Amazonas 702', '900700003', 'nuria3@correo.com', '1234', 'medico'),
(57, 'Tomás', 'Reyes', '11170004', '1989-07-04', 'Av. Venezuela 703', '900700004', 'tomas4@correo.com', '1234', 'medico'),
(58, 'Yesenia', 'Bravo', '11170005', '1991-07-05', 'Av. Canadá 704', '900700005', 'yesenia5@correo.com', '1234', 'medico'),
(59, 'Renato', 'Gonzales', '11180001', '1985-08-01', 'Av. La Marina 800', '900800001', 'renato1@correo.com', '1234', 'medico'),
(60, 'Luciana', 'Paredes', '11180002', '1990-08-02', 'Calle El Sol 801', '900800002', 'luciana2@correo.com', '1234', 'medico'),
(61, 'Cristian', 'Morales', '11180003', '1988-08-03', 'Jr. Primavera 802', '900800003', 'cristian3@correo.com', '1234', 'medico'),
(62, 'Fiorella', 'Ramirez', '11180004', '1992-08-04', 'Av. Canadá 803', '900800004', 'fiorella4@correo.com', '1234', 'medico'),
(63, 'Gustavo', 'Rojas', '11180005', '1987-08-05', 'Av. Javier Prado 804', '900800005', 'gustavo5@correo.com', '1234', 'medico');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `centrosalud`
--
ALTER TABLE `centrosalud`
  ADD PRIMARY KEY (`id_centro`);

--
-- Indices de la tabla `citamedica`
--
ALTER TABLE `citamedica`
  ADD PRIMARY KEY (`id_cita`),
  ADD KEY `id_paciente` (`id_paciente`),
  ADD KEY `id_medico` (`id_medico`),
  ADD KEY `id_centro` (`id_centro`);

--
-- Indices de la tabla `historialclinico`
--
ALTER TABLE `historialclinico`
  ADD PRIMARY KEY (`id_historial`),
  ADD UNIQUE KEY `id_paciente` (`id_paciente`);

--
-- Indices de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD PRIMARY KEY (`id_mensaje`),
  ADD KEY `id_remitente` (`id_remitente`),
  ADD KEY `id_destinatario` (`id_destinatario`);

--
-- Indices de la tabla `notificacion`
--
ALTER TABLE `notificacion`
  ADD PRIMARY KEY (`id_notificacion`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id_paciente`);

--
-- Indices de la tabla `personalmedico`
--
ALTER TABLE `personalmedico`
  ADD PRIMARY KEY (`id_medico`);

--
-- Indices de la tabla `registrohistorial`
--
ALTER TABLE `registrohistorial`
  ADD PRIMARY KEY (`id_registro`),
  ADD KEY `id_historial` (`id_historial`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `centrosalud`
--
ALTER TABLE `centrosalud`
  MODIFY `id_centro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `citamedica`
--
ALTER TABLE `citamedica`
  MODIFY `id_cita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `historialclinico`
--
ALTER TABLE `historialclinico`
  MODIFY `id_historial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  MODIFY `id_mensaje` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `notificacion`
--
ALTER TABLE `notificacion`
  MODIFY `id_notificacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `registrohistorial`
--
ALTER TABLE `registrohistorial`
  MODIFY `id_registro` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citamedica`
--
ALTER TABLE `citamedica`
  ADD CONSTRAINT `citamedica_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`),
  ADD CONSTRAINT `citamedica_ibfk_2` FOREIGN KEY (`id_medico`) REFERENCES `personalmedico` (`id_medico`),
  ADD CONSTRAINT `citamedica_ibfk_3` FOREIGN KEY (`id_centro`) REFERENCES `centrosalud` (`id_centro`);

--
-- Filtros para la tabla `historialclinico`
--
ALTER TABLE `historialclinico`
  ADD CONSTRAINT `historialclinico_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`);

--
-- Filtros para la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD CONSTRAINT `mensaje_ibfk_1` FOREIGN KEY (`id_remitente`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `mensaje_ibfk_2` FOREIGN KEY (`id_destinatario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `notificacion`
--
ALTER TABLE `notificacion`
  ADD CONSTRAINT `notificacion_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `personalmedico`
--
ALTER TABLE `personalmedico`
  ADD CONSTRAINT `personalmedico_ibfk_1` FOREIGN KEY (`id_medico`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `registrohistorial`
--
ALTER TABLE `registrohistorial`
  ADD CONSTRAINT `registrohistorial_ibfk_1` FOREIGN KEY (`id_historial`) REFERENCES `historialclinico` (`id_historial`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
