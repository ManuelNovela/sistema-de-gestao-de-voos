-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2019 at 02:26 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `AeroPorto`
--

-- --------------------------------------------------------

--
-- Table structure for table `aeronave`
--

CREATE TABLE `aeronave` (
  `CodAero` int(11) NOT NULL,
  `NrTotalAssentos` int(11) NOT NULL,
  `TipoAeronave` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aeronave`
--

INSERT INTO `aeronave` (`CodAero`, `NrTotalAssentos`, `TipoAeronave`) VALUES
(7, 53, '78'),
(1111, 11, '78'),
(87, 16, '85');

-- --------------------------------------------------------

--
-- Table structure for table `reservarassento`
--

CREATE TABLE `reservarassento` (
  `NrVoo` int(11) NOT NULL,
  `NrTreco` int(11) NOT NULL,
  `Data` varchar(250) NOT NULL,
  `NrdoAssento` int(11) NOT NULL,
  `NomeCliente` varchar(250) NOT NULL,
  `TelefoneCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tarifa`
--

CREATE TABLE `tarifa` (
  `NrVoo` int(11) NOT NULL,
  `CodTarifa` int(11) NOT NULL,
  `Quantidade` int(11) NOT NULL,
  `Restricoes` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tarifa`
--

INSERT INTO `tarifa` (`NrVoo`, `CodTarifa`, `Quantidade`, `Restricoes`) VALUES
(12, 45, 9, 'nada'),
(112, 78, 14, 'n');

-- --------------------------------------------------------

--
-- Table structure for table `tipoaeronave`
--

CREATE TABLE `tipoaeronave` (
  `NomeAeronave` varchar(250) NOT NULL,
  `QtdmaxAssetos` int(11) NOT NULL,
  `Companhia` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipoaeronave`
--

INSERT INTO `tipoaeronave` (`NomeAeronave`, `QtdmaxAssetos`, `Companhia`) VALUES
('23', 10, ''),
('bddof', 16, 'efrjj'),
('', 0, ''),
('b', 6, 'r');

-- --------------------------------------------------------

--
-- Table structure for table `treco`
--

CREATE TABLE `treco` (
  `NrVoo` int(11) NOT NULL,
  `NrTreco` int(11) NOT NULL,
  `Data` varchar(250) NOT NULL,
  `NrAssentos` int(11) NOT NULL,
  `CodAeronave` varchar(250) NOT NULL,
  `CodAeroPartida` varchar(250) NOT NULL,
  `HorarioPartida` varchar(250) NOT NULL,
  `CodAeroChegada` varchar(250) NOT NULL,
  `HorarioChegada` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `treco`
--

INSERT INTO `treco` (`NrVoo`, `NrTreco`, `Data`, `NrAssentos`, `CodAeronave`, `CodAeroPartida`, `HorarioPartida`, `CodAeroChegada`, `HorarioChegada`) VALUES
(112, 78, '12/9/2019', 51, '001', '01', '5/45', '45', '5/45');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tarifa`
--
ALTER TABLE `tarifa`
  ADD PRIMARY KEY (`CodTarifa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
