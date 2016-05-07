--USUARIO: "gp"
--SENHA: 123456

CREATE USER 'gp'@'localhost' IDENTIFIED WITH mysql_native_password;GRANT USAGE ON *.* TO 'gp'@'localhost' REQUIRE NONE WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;SET PASSWORD FOR 'gp'@'localhost' = '***';GRANT ALL PRIVILEGES ON `gp\_%`.* TO 'gp'@'localhost';


-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 07, 2016 at 12:38 AM
-- Server version: 5.6.24-log
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gp_offstation`
--
CREATE DATABASE IF NOT EXISTS `gp_offstation` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `gp_offstation`;

-- --------------------------------------------------------

--
-- Table structure for table `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nome` varchar(32) NOT NULL,
  `sobrenome` varchar(32) NOT NULL,
  `email` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `funcionarios`
--

CREATE TABLE `funcionarios` (
  `cpf` int(11) UNSIGNED NOT NULL,
  `tipo` int(1) UNSIGNED DEFAULT NULL,
  `nome` varchar(32) NOT NULL,
  `sobrenome` varchar(32) NOT NULL,
  `email` varchar(64) NOT NULL,
  `senha` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `funcionarios`
--

INSERT INTO `funcionarios` (`cpf`, `tipo`, `nome`, `sobrenome`, `email`, `senha`) VALUES
(1, NULL, 'Luan', 'Augusto', 'luan@hotmail.com', '123luan');

-- --------------------------------------------------------

--
-- Table structure for table `orcamento`
--

CREATE TABLE `orcamento` (
  `id` int(11) NOT NULL,
  `veiculoID` int(11) DEFAULT NULL,
  `pecaID` int(11) DEFAULT NULL,
  `quantidade` int(11) UNSIGNED NOT NULL DEFAULT '1',
  `data` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `pecas`
--

CREATE TABLE `pecas` (
  `id` int(11) NOT NULL,
  `nome` varchar(64) NOT NULL,
  `preco` decimal(7,2) NOT NULL,
  `tipo` int(1) NOT NULL DEFAULT '1',
  `estoque` int(11) UNSIGNED NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pecas`
--

INSERT INTO `pecas` (`id`, `nome`, `preco`, `tipo`, `estoque`) VALUES
(1, 'Pastilha de freio', '10.00', 1, 40),
(2, 'Pneu', '150.00', 1, 9),
(3, 'Lâmpada da seta', '2.00', 1, 184),
(4, 'Troca de óleo', '25.00', 2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `veiculos`
--

CREATE TABLE `veiculos` (
  `id` int(11) NOT NULL,
  `clienteID` int(11) DEFAULT NULL,
  `placa` varchar(8) NOT NULL,
  `descricao` text NOT NULL,
  `entrada` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `saida` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `veiculos_mecanicos`
--

CREATE TABLE `veiculos_mecanicos` (
  `veiculoID` int(11) NOT NULL DEFAULT '0',
  `funcionarioCPF` int(11) UNSIGNED NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD PRIMARY KEY (`cpf`);

--
-- Indexes for table `orcamento`
--
ALTER TABLE `orcamento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `orcamento_ibfk_1` (`veiculoID`),
  ADD KEY `orcamento_ibfk_2` (`pecaID`);

--
-- Indexes for table `pecas`
--
ALTER TABLE `pecas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `veiculos`
--
ALTER TABLE `veiculos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `clienteID` (`clienteID`);

--
-- Indexes for table `veiculos_mecanicos`
--
ALTER TABLE `veiculos_mecanicos`
  ADD PRIMARY KEY (`veiculoID`,`funcionarioCPF`),
  ADD KEY `funcionarioCPF` (`funcionarioCPF`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `orcamento`
--
ALTER TABLE `orcamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pecas`
--
ALTER TABLE `pecas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `veiculos`
--
ALTER TABLE `veiculos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `orcamento`
--
ALTER TABLE `orcamento`
  ADD CONSTRAINT `orcamento_ibfk_1` FOREIGN KEY (`veiculoID`) REFERENCES `veiculos` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `orcamento_ibfk_2` FOREIGN KEY (`pecaID`) REFERENCES `pecas` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `veiculos`
--
ALTER TABLE `veiculos`
  ADD CONSTRAINT `veiculos_ibfk_1` FOREIGN KEY (`clienteID`) REFERENCES `clientes` (`id`);

--
-- Constraints for table `veiculos_mecanicos`
--
ALTER TABLE `veiculos_mecanicos`
  ADD CONSTRAINT `veiculos_mecanicos_ibfk_1` FOREIGN KEY (`veiculoID`) REFERENCES `veiculos` (`id`),
  ADD CONSTRAINT `veiculos_mecanicos_ibfk_2` FOREIGN KEY (`funcionarioCPF`) REFERENCES `funcionarios` (`cpf`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
