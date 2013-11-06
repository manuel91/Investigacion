-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 06-11-2013 a las 22:02:11
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `casosinv`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `casos_de_investigacion`
--

CREATE TABLE IF NOT EXISTS `casos_de_investigacion` (
  `nro_expediente` int(11) NOT NULL AUTO_INCREMENT,
  `investigador` varchar(50) NOT NULL DEFAULT '-',
  `cedula_investigador` int(11) NOT NULL DEFAULT '0',
  `fecha_inicio` date NOT NULL,
  `dias` int(11) NOT NULL,
  `mes` int(11) NOT NULL,
  `movil_afectado` varchar(15) NOT NULL,
  `tipo_de_caso` varchar(50) NOT NULL,
  `tipo_de_irregularidad` varchar(50) NOT NULL,
  `subtipo_de_irregularidad` varchar(50) NOT NULL,
  `objetivo_agraviado` varchar(50) NOT NULL,
  `incidencia` varchar(50) NOT NULL,
  `duracion` int(11) NOT NULL,
  `descripcion` varchar(500) NOT NULL DEFAULT '-',
  `area_apoyo` varchar(50) NOT NULL,
  `deteccion_procedencia` varchar(50) NOT NULL DEFAULT '-',
  `diagnostico_detalle` varchar(500) NOT NULL DEFAULT '-',
  `actuaciones_acciones` varchar(50) NOT NULL,
  `conclusiones` varchar(500) NOT NULL DEFAULT '-',
  `recomendaciones` varchar(500) NOT NULL DEFAULT '-',
  `observaciones` varchar(500) NOT NULL DEFAULT '-',
  `soporte` varchar(50) NOT NULL DEFAULT '-',
  `estado` varchar(50) NOT NULL DEFAULT '-',
  PRIMARY KEY (`nro_expediente`),
  KEY `cedula_investigador` (`cedula_investigador`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `casos_de_investigacion`
--

INSERT INTO `casos_de_investigacion` (`nro_expediente`, `investigador`, `cedula_investigador`, `fecha_inicio`, `dias`, `mes`, `movil_afectado`, `tipo_de_caso`, `tipo_de_irregularidad`, `subtipo_de_irregularidad`, `objetivo_agraviado`, `incidencia`, `duracion`, `descripcion`, `area_apoyo`, `deteccion_procedencia`, `diagnostico_detalle`, `actuaciones_acciones`, `conclusiones`, `recomendaciones`, `observaciones`, `soporte`, `estado`) VALUES
(1, 'Juan Perez', 15236899, '2013-10-10', 15, 10, '4146627711', 'Fraude', 'Detección de Brecha en Proceso', 'Activación de Líneas', 'Maria Perez', 'Activación de línea fraudulenta', 15, '', 'Investigación', '', '', 'Apertura de caso CICCPO', '', '', '', '', 'Negado'),
(2, 'Juan da silva', 16544789, '2013-10-01', 25, 10, '4165421876', 'Investigación', 'Detección de Brecha en Proceso', 'Activación de Sevicios', 'Josefina Armas', 'Activación de servicios repetidos ', 15, '', 'Investigación', '', '', 'Apertura de caso CICCPO', '', '', '', '', 'Asignado'),
(3, 'Pedro Perez', 15236889, '2013-09-25', 30, 9, '4125526771', 'Robo', 'Liberación de Serial', 'Aplicación de Ajustes', 'Maria Villas', 'Duplicación de serial', 15, '', 'TI', '', '', 'Suspender la línea', '', '', 'lo que sea', '', 'Negado'),
(4, 'John Rivas', 14544892, '2013-09-08', 45, 9, '4145556277', 'Fraude', 'Hurto Robo', 'Cambio de Datos', 'Jose Armas', 'Hurto de línea de dados', 45, '', 'TI', '', '', 'Suspender la línea', '', '', '', '', 'Cerrado'),
(5, 'Daniel Gonzalez', 15247896, '2013-09-01', 55, 9, '4145515551', 'Fraude', 'Hurto Robo', 'Cambio de Movil', 'Jacky Perozo', 'Hurto de línea de voz', 55, '', 'TI', '', '', 'Suspender la línea', '', '', '', '', 'Negado'),
(6, 'Fred Rivas', 18593321, '2013-10-01', 20, 15, '4169330111', 'Fraude', 'Activación de Servicios', 'Activación de Líneas', 'Manuel Fuentes', 'Activación de Línea Fraudulenta', 30, 'dsgdngkdmnbxdnbkdsbmnknzñlbnzkngsjogrje', 'TI', 'sfsafbobfoiawtiinatw', 'lkastehnpohjreoysngznghosjrgohjsyjosjyh', 'Suspender la Línea', '53535346', '34634636', '2142323532', '-', 'Seguimiento'),
(7, 'Pepito Garcia', 18439576, '2013-11-12', 20, 11, '4142657896', 'Investigación', 'Estafa', 'Cambio de Plan', 'dsgdsgdsg', 'Duplicación de Serial', 100, 'dsgdfgdsgsd', 'TI', 'dsgdsgdsgds', 'gdsgsdgdsg', 'Suspender la Línea', '4754756754', '87659679', '42353654657', 'dsgdsgdsg', 'Cerrado'),
(8, 'Lili del valle', 19372462, '2013-12-01', 5, 30, '4144552396', 'Investigación', 'Hurto - Robo', 'Canjes de Puntos', 'dtretryesz', 'Duplicación de Serial', 20, 'hdgfhdfghdfgh\ndsgsgfsh', 'TI', 'sdfsfsffdsg', 'shshdfsh\ndfhshfdshncvn\nhsdhsdhdash', 'Suspender la Línea', 'ityityityirti', 'rtyitityritirty', 'jgfjghfityity', 'dtretryesz', 'Negado'),
(9, 'Pepe Gonzales', 10258741, '2013-12-16', 20, 20, '', 'Investigación', 'Activación de Servicios', 'Activación de Líneas', '', '', 20, '', '', '', '', '', '-', '-', '-', '', 'Negado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo_robado`
--

CREATE TABLE IF NOT EXISTS `equipo_robado` (
  `nro_expediente` int(11) NOT NULL,
  `serial` varchar(50) NOT NULL DEFAULT '-',
  `tipo_equipo` varchar(50) NOT NULL DEFAULT '-',
  `marca` varchar(50) NOT NULL DEFAULT '-',
  `modelo` varchar(50) NOT NULL DEFAULT '-',
  `observaciones` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `equipo_robado`
--

INSERT INTO `equipo_robado` (`nro_expediente`, `serial`, `tipo_equipo`, `marca`, `modelo`, `observaciones`) VALUES
(3, '2142343534', 'celular', 'marca123', 'modelo123', ''),
(3, '32256', 'laptop', 'asus', '41an56n', 'kngipsnyinreisnjyry');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `investigador`
--

CREATE TABLE IF NOT EXISTS `investigador` (
  `cedula` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `empresa` varchar(50) NOT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `investigador`
--

INSERT INTO `investigador` (`cedula`, `nombre`, `apellido`, `empresa`) VALUES
(10258741, 'Pepe', 'Gonzales', 'Los investigadores'),
(14544892, 'John', 'Rivas', 'Los investigadores'),
(14789654, 'Jorge', 'de la cruz', 'AltaVista'),
(15236889, 'Pedro', 'Perez', 'Resuelve todo'),
(15236899, 'Juan', 'Perez', 'UCV'),
(15247896, 'Daniel', 'Gonzalez', 'Busca respuestas'),
(16544789, 'Juan', 'da silva', 'Los investigadores'),
(18439576, 'Pepito', 'Lopez', 'Busca respuestas'),
(18500247, 'Jorge', 'dos santos', 'UCV'),
(18593321, 'Fred', 'Rivas', 'Los investigadores'),
(19372462, 'Lili', 'del valle', 'Busca respuestas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal`
--

CREATE TABLE IF NOT EXISTS `personal` (
  `cedula` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `empresa` varchar(50) NOT NULL,
  `amonestado` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `personal`
--

INSERT INTO `personal` (`cedula`, `nombre`, `apellido`, `empresa`, `amonestado`) VALUES
(10258741, 'pepito', 'gomes', 'AltaVista', 1),
(12345678, 'Lola', 'Guillen', 'Resuelve todo', 1),
(19441733, 'Corina', 'Luongo', 'UCV', 1),
(19500253, 'Manuel', 'Fuentes', 'UCV', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal_casos`
--

CREATE TABLE IF NOT EXISTS `personal_casos` (
  `nro_expediente` int(11) NOT NULL,
  `cedula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `personal_casos`
--

INSERT INTO `personal_casos` (`nro_expediente`, `cedula`) VALUES
(8, 19441733),
(1, 19500253),
(8, 10258741),
(8, 19500253),
(8, 12345678);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguimiento_fraude`
--

CREATE TABLE IF NOT EXISTS `seguimiento_fraude` (
  `nro_expediente` int(11) NOT NULL,
  `actividades` varchar(500) NOT NULL DEFAULT '-',
  `personas` varchar(500) NOT NULL DEFAULT '-',
  `monto` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`nro_expediente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `seguimiento_fraude`
--

INSERT INTO `seguimiento_fraude` (`nro_expediente`, `actividades`, `personas`, `monto`) VALUES
(6, 'hgfjgjgfj', 'ghjgfhj', 50.55);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `seguimiento_fraude`
--
ALTER TABLE `seguimiento_fraude`
  ADD CONSTRAINT `seguimiento_fraude_ibfk_2` FOREIGN KEY (`nro_expediente`) REFERENCES `casos_de_investigacion` (`nro_expediente`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
