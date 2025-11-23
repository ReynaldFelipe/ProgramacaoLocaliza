-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: localiza
-- ------------------------------------------------------
-- Server version	8.0.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `carro`
--

DROP TABLE IF EXISTS `carro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carro` (
  `placa` varchar(10) NOT NULL,
  `chassi` varchar(25) NOT NULL,
  `modelo` varchar(100) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `arCondicionado` tinyint(1) NOT NULL,
  `direcaoHidraulica` tinyint(1) NOT NULL,
  `anoFabricacao` int NOT NULL,
  `anoModelo` int NOT NULL,
  `kmInicial` int NOT NULL,
  `kmFinal` int NOT NULL,
  `status` varchar(20) NOT NULL,
  `diaria` float NOT NULL,
  PRIMARY KEY (`chassi`),
  UNIQUE KEY `placa` (`placa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carro`
--

LOCK TABLES `carro` WRITE;
/*!40000 ALTER TABLE `carro` DISABLE KEYS */;
INSERT INTO `carro` VALUES ('GYR6B86','1p9TKZpstBuRr7565','Hilux','Picape',1,1,2025,2025,900,900,'Não Disponível',650),('AOE2W62','2nGGhTygBztv18622','Gol','Hatch',1,1,2019,2019,15000,15000,'Disponível',140),('KNY1E20','2uLgk8Hl2lam22837','HB20','Hatch',1,1,2024,2024,1500,1500,'Disponível',200),('AYR4B50','3mzwguJ7KgUcw6362','SW4','SUV',1,1,2025,2025,450,450,'Disponível',900),('MDC8E77','6xfYfvJxgkzdr5657','Argo','Hatch',1,1,2025,2025,200,200,'Disponível',400);
/*!40000 ALTER TABLE `carro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cpf` varchar(14) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `endereco` varchar(150) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('	07912092455','	Jamerson Augusto','	Rua Arquiteto João de Barros','	81984262180','	jamerson_misso@hotmail.com'),('	13047149429','	Reynald','	Rua Professor Humberto da Costa Lins','	81988116366','	reynald889@gmail.com'),('10122129474','Eduardo Vilaça','Rua silvino lopes','81984802468','dudu@gmail.com');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `cpf` varchar(14) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `endereco` varchar(150) DEFAULT NULL,
  `matricula` varchar(50) NOT NULL,
  `cargo` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES ('01002003099','Luis','Matriz','1432','Atendente','luis123@gmail.com'),('12345678910','Ana Cristina','Rua Matriz','1234','Gerente','anacristina@gmail.com'),('98765432100','Lays','Caja','4321','Atendente','lays@gmail.com');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locacao`
--

DROP TABLE IF EXISTS `locacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locacao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `placa` varchar(10) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `dataInicio` varchar(20) DEFAULT NULL,
  `dataFimEstimada` varchar(20) DEFAULT NULL,
  `dataFimEfetiva` varchar(20) DEFAULT NULL,
  `qtdDiarias` int DEFAULT NULL,
  `valorTotal` float DEFAULT NULL,
  `valorDiaria` float DEFAULT NULL,
  `formaPagamento` varchar(30) DEFAULT NULL,
  `valorMultaAtrasoDiaria` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locacao`
--

LOCK TABLES `locacao` WRITE;
/*!40000 ALTER TABLE `locacao` DISABLE KEYS */;
INSERT INTO `locacao` VALUES (1,'KNY1E20','13047149429','2025-11-23','2025-11-26',NULL,0,0,200,NULL,0),(2,'AYR4B50','07912092455','2025-12-01','2025-12-07',NULL,0,0,900,NULL,0),(3,'MDC8E77','10122129474','2025-12-01','2025-12-10',NULL,0,0,400,NULL,0);
/*!40000 ALTER TABLE `locacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `cliente` varchar(14) NOT NULL,
  `carro` varchar(10) NOT NULL,
  `data_reserva` date DEFAULT NULL,
  `previsao_recebimento` date DEFAULT NULL,
  PRIMARY KEY (`cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES ('07912092455','SW4','2025-11-23','2025-11-30'),('10122129474','Argo','2025-12-01','2025-12-10'),('13047149429','HB20','2025-11-23','2025-11-26');
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-23 14:40:23
