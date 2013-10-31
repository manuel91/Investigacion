-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 31-10-2013 a las 19:25:21
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
  PRIMARY KEY (`nro_expediente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `casos_de_investigacion`
--

INSERT INTO `casos_de_investigacion` (`nro_expediente`, `investigador`, `fecha_inicio`, `dias`, `mes`, `movil_afectado`, `tipo_de_caso`, `tipo_de_irregularidad`, `subtipo_de_irregularidad`, `objetivo_agraviado`, `incidencia`, `duracion`, `descripcion`, `area_apoyo`, `deteccion_procedencia`, `diagnostico_detalle`, `actuaciones_acciones`, `conclusiones`, `recomendaciones`, `observaciones`, `soporte`, `estado`) VALUES
(1, 'Pedro Perez', '2013-10-10', 15, 10, '4146627711', 'Fraude', 'Detección de Brecha en Proceso', 'Activación de Líneas', 'Maria Perez', 'Activación de línea fraudulenta', 15, '', 'Investigación', '', '', 'Apertura de caso CICCPO', '', '', '', '', 'Asignado'),
(2, 'Juan da silva', '2013-10-01', 25, 10, '4165421876', 'Investigación', 'Detección de Brecha en Proceso', 'Activación de Sevicios', 'Josefina Armas', 'Activación de servicios repetidos ', 15, '', 'Investigación', '', '', 'Apertura de caso CICCPO', '', '', '', '', 'Asignado'),
(3, 'Jenifer Rodriguez', '2013-09-25', 30, 9, '4125526771', 'Robo', 'Liberación de Serial', 'Aplicación de Ajustes', 'Maria Villas', 'Duplicación de serial', 15, '', 'TI', '', '', 'Suspender la línea', '', '', '', '', 'Abierto'),
(4, 'John Rivas', '2013-09-08', 45, 9, '4145556277', 'Fraude', 'Hurto Robo', 'Cambio de Datos', 'Jose Armas', 'Hurto de línea de dados', 45, '', 'TI', '', '', 'Suspender la línea', '', '', '', '', 'Cerrado'),
(5, 'Keila Gonzalez', '2013-09-01', 55, 9, '4145515551', 'Fraude', 'Hurto Robo', 'Cambio de Movil', 'Jacky Perozo', 'Hurto de línea de voz', 55, '', 'TI', '', '', 'Suspender la línea', '', '', '', '', 'Negado'),
(6, '-', '2013-10-01', 20, 15, '4169330111', 'Robo', 'Activación de Servicios', 'Activación de Líneas', 'Manuel Fuentes', 'Activación de Línea Fraudulenta', 30, 'dsgdngkdmnbxdnbkdsbmnknzñlbnzkngsjogrje', 'TI', 'sfsafbobfoiawtiinatw', 'lkastehnpohjreoysngznghosjrgohjsyjosjyh', 'Suspender la Línea', '-', '-', '-', '-', 'Seguimiento'),
(7, '-', '2013-11-12', 20, 11, '4142657896', 'Investigación', 'Estafa', 'Cambio de Plan', 'dsgdsgdsg', 'Duplicación de Serial', 30, 'dsgdfgdsgsd', 'TI', 'dsgdsgdsgds', 'gdsgsdgdsg', 'Suspender la Línea', '-', '-', '-', 'dsgdsgdsg', 'Asignado'),
(8, '-', '2013-12-01', 5, 30, '4144552396', 'Investigación', 'Hurto - Robo', 'Canjes de Puntos', 'dtretryesz', 'Duplicación de Serial', 20, 'hdgfhdfghdfgh\ndsgsgfsh', 'TI', 'sdfsfsffdsg', 'shshdfsh\ndfhshfdshncvn\nhsdhsdhdash', 'Suspender la Línea', '-', '-', '-', 'dtretryesz', 'Asignado'),
(9, '-', '2013-12-16', 20, 20, '', 'Investigación', 'Activación de Servicios', 'Activación de Líneas', '', '', 20, '', '', '', '', '', '-', '-', '-', '', 'Asignado'),
(10, '-', '2013-12-01', 20, 12, '4142654789', 'Investigación', 'Hurto - Robo', 'Equipos Celulares', 'Corina', 'Hurto de Línea de Datos', 15, 'dudufjvbngjghfk\nhñmhmdgfpkjd\nfñhpmfkjkkjd', 'TI', 'gfhfjfjf', 'dfñlmgdgpodjh\nljhodfjhjd\nlfhojhojdy', 'Suspender la línea', '-', '-', '-', 'erwedfgdfghtry', 'Asignado');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;