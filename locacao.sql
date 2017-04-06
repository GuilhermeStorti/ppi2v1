-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 06, 2017 at 08:31 
-- Server version: 10.1.19-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `locacao`
--

-- --------------------------------------------------------

--
-- Table structure for table `avaria`
--

CREATE TABLE `avaria` (
  `id_avaria` int(11) NOT NULL,
  `descricao` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `avaria`
--

INSERT INTO `avaria` (`id_avaria`, `descricao`) VALUES
(1, 'Batida');

-- --------------------------------------------------------

--
-- Table structure for table `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `preco` decimal(19,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `descricao`, `preco`) VALUES
(2, 'Hatch', '12.50'),
(3, 'Sedã', '15.50'),
(4, 'Utilitario', '20.90');

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `cnh` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `situacao` char(1) NOT NULL,
  `telefone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `cnh`, `cpf`, `nome`, `situacao`, `telefone`) VALUES
(1, '123456', '123456', 'Cliente de testes', 'A', '12345678');

-- --------------------------------------------------------

--
-- Table structure for table `funcionario`
--

CREATE TABLE `funcionario` (
  `idfuncionario` int(11) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `data_nascimento` date NOT NULL,
  `matricula` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `usuario` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `funcionario`
--

INSERT INTO `funcionario` (`idfuncionario`, `cpf`, `data_nascimento`, `matricula`, `nome`, `senha`, `usuario`) VALUES
(1, '321654', '2016-04-08', '12', 'Jaumzin', '123', 'jaum');

-- --------------------------------------------------------

--
-- Table structure for table `locacao`
--

CREATE TABLE `locacao` (
  `id_locacao` int(11) NOT NULL,
  `data_locacao` date DEFAULT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_funcionario_cad` int(11) NOT NULL,
  `id_funcionario_rec` int(11) DEFAULT NULL,
  `id_veiculo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `locacao`
--

INSERT INTO `locacao` (`id_locacao`, `data_locacao`, `id_cliente`, `id_funcionario_cad`, `id_funcionario_rec`, `id_veiculo`) VALUES
(1, '2017-04-06', 1, 1, NULL, 2);

-- --------------------------------------------------------

--
-- Table structure for table `locacao_avaria`
--

CREATE TABLE `locacao_avaria` (
  `id_avaria` int(11) NOT NULL,
  `id_locacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `locacao_avaria`
--

INSERT INTO `locacao_avaria` (`id_avaria`, `id_locacao`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `locacao_multa`
--

CREATE TABLE `locacao_multa` (
  `id_locacao` int(11) NOT NULL,
  `id_multa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `locacao_multa`
--

INSERT INTO `locacao_multa` (`id_locacao`, `id_multa`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `multa`
--

CREATE TABLE `multa` (
  `id_multa` int(11) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `valor` double NOT NULL,
  `id_veiculo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `multa`
--

INSERT INTO `multa` (`id_multa`, `descricao`, `valor`, `id_veiculo`) VALUES
(1, 'Excesso de Velocidade', 100, 2);

-- --------------------------------------------------------

--
-- Table structure for table `veiculo`
--

CREATE TABLE `veiculo` (
  `id_veiculo` int(11) NOT NULL,
  `marca` varchar(255) NOT NULL,
  `modelo` varchar(255) NOT NULL,
  `placa` varchar(255) NOT NULL,
  `id_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `veiculo`
--

INSERT INTO `veiculo` (`id_veiculo`, `marca`, `modelo`, `placa`, `id_categoria`) VALUES
(2, 'VolksWagen', 'Gol', 'VWG0001', 2),
(3, 'VolksWagen', 'Voyage', 'VWG0002', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `avaria`
--
ALTER TABLE `avaria`
  ADD PRIMARY KEY (`id_avaria`);

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idfuncionario`);

--
-- Indexes for table `locacao`
--
ALTER TABLE `locacao`
  ADD PRIMARY KEY (`id_locacao`),
  ADD KEY `FKlsy3ikif819btwjy89h4ee1cv` (`id_cliente`),
  ADD KEY `FKl8kx9nqsl3wynofwacsp2g3eh` (`id_funcionario_cad`),
  ADD KEY `FK9ed7oddpw0f1gi8cmpwwm28qg` (`id_funcionario_rec`),
  ADD KEY `FKl6a4twqv4qwul6grnxhpdqcxd` (`id_veiculo`);

--
-- Indexes for table `locacao_avaria`
--
ALTER TABLE `locacao_avaria`
  ADD KEY `FKqmblrp97te7j81c8k2oqpgfd1` (`id_locacao`),
  ADD KEY `FK7o1bgfeh32gpb3w79qj58ntmw` (`id_avaria`);

--
-- Indexes for table `locacao_multa`
--
ALTER TABLE `locacao_multa`
  ADD KEY `FKibxbjmpnrw25t0jj191xmrwpt` (`id_multa`),
  ADD KEY `FKk6gilbidnbli542qf62806pgq` (`id_locacao`);

--
-- Indexes for table `multa`
--
ALTER TABLE `multa`
  ADD PRIMARY KEY (`id_multa`),
  ADD KEY `FKeh99aa9ntw8mjp27q5ldns71t` (`id_veiculo`);

--
-- Indexes for table `veiculo`
--
ALTER TABLE `veiculo`
  ADD PRIMARY KEY (`id_veiculo`),
  ADD KEY `FKsjr07rwxrd9rsjabp71fmh02b` (`id_categoria`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `avaria`
--
ALTER TABLE `avaria`
  MODIFY `id_avaria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idfuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `locacao`
--
ALTER TABLE `locacao`
  MODIFY `id_locacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `multa`
--
ALTER TABLE `multa`
  MODIFY `id_multa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `veiculo`
--
ALTER TABLE `veiculo`
  MODIFY `id_veiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `locacao`
--
ALTER TABLE `locacao`
  ADD CONSTRAINT `FK9ed7oddpw0f1gi8cmpwwm28qg` FOREIGN KEY (`id_funcionario_rec`) REFERENCES `funcionario` (`idfuncionario`),
  ADD CONSTRAINT `FKl6a4twqv4qwul6grnxhpdqcxd` FOREIGN KEY (`id_veiculo`) REFERENCES `veiculo` (`id_veiculo`),
  ADD CONSTRAINT `FKl8kx9nqsl3wynofwacsp2g3eh` FOREIGN KEY (`id_funcionario_cad`) REFERENCES `funcionario` (`idfuncionario`),
  ADD CONSTRAINT `FKlsy3ikif819btwjy89h4ee1cv` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`);

--
-- Constraints for table `locacao_avaria`
--
ALTER TABLE `locacao_avaria`
  ADD CONSTRAINT `FK7o1bgfeh32gpb3w79qj58ntmw` FOREIGN KEY (`id_avaria`) REFERENCES `avaria` (`id_avaria`),
  ADD CONSTRAINT `FKqmblrp97te7j81c8k2oqpgfd1` FOREIGN KEY (`id_locacao`) REFERENCES `locacao` (`id_locacao`);

--
-- Constraints for table `locacao_multa`
--
ALTER TABLE `locacao_multa`
  ADD CONSTRAINT `FKibxbjmpnrw25t0jj191xmrwpt` FOREIGN KEY (`id_multa`) REFERENCES `multa` (`id_multa`),
  ADD CONSTRAINT `FKk6gilbidnbli542qf62806pgq` FOREIGN KEY (`id_locacao`) REFERENCES `locacao` (`id_locacao`);

--
-- Constraints for table `multa`
--
ALTER TABLE `multa`
  ADD CONSTRAINT `FKeh99aa9ntw8mjp27q5ldns71t` FOREIGN KEY (`id_veiculo`) REFERENCES `veiculo` (`id_veiculo`);

--
-- Constraints for table `veiculo`
--
ALTER TABLE `veiculo`
  ADD CONSTRAINT `FKsjr07rwxrd9rsjabp71fmh02b` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
