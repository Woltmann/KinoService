-- MariaDB dump 10.19-11.2.2-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: KinoService
-- ------------------------------------------------------
-- Server version	11.2.2-MariaDB-1:11.2.2+maria~ubu2204

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Booking`
--


CREATE DATABASE IF NOT EXISTS `KinoService` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `KinoService`;

DROP TABLE IF EXISTS `Booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Booking` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `typeKey` (`typeKey`),
  CONSTRAINT `Booking_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `KinoServiceTYPEKEYS` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Booking`
--

LOCK TABLES `Booking` WRITE;
/*!40000 ALTER TABLE `Booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `Booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Categorie`
--

DROP TABLE IF EXISTS `Categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Categorie` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL,
  `basePrice` int(11) DEFAULT NULL,
  `priceSurchargeLogeService` int(11) DEFAULT NULL,
  `serviceTyp` varchar(255) DEFAULT NULL,
  `priceSurchargeLoge` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeKey` (`typeKey`),
  CONSTRAINT `Categorie_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `KinoServiceTYPEKEYS` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Categorie`
--

LOCK TABLES `Categorie` WRITE;
/*!40000 ALTER TABLE `Categorie` DISABLE KEYS */;
INSERT INTO `Categorie` VALUES
(25,12,NULL,NULL,NULL,NULL),
(26,13,NULL,NULL,NULL,NULL),
(27,14,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `Categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CiHa_SeRo`
--

DROP TABLE IF EXISTS `CiHa_SeRo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CiHa_SeRo` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `p1` (`p1`),
  KEY `p2` (`p2`),
  CONSTRAINT `CiHa_SeRo_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `Cinemahall` (`id`) ON DELETE CASCADE,
  CONSTRAINT `CiHa_SeRo_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `SeatRow` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CiHa_SeRo`
--

LOCK TABLES `CiHa_SeRo` WRITE;
/*!40000 ALTER TABLE `CiHa_SeRo` DISABLE KEYS */;
/*!40000 ALTER TABLE `CiHa_SeRo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cinemahall`
--

DROP TABLE IF EXISTS `Cinemahall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cinemahall` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL,
  `hallname` varchar(255) DEFAULT NULL,
  `isFree` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeKey` (`typeKey`),
  CONSTRAINT `Cinemahall_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `KinoServiceTYPEKEYS` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cinemahall`
--

LOCK TABLES `Cinemahall` WRITE;
/*!40000 ALTER TABLE `Cinemahall` DISABLE KEYS */;
/*!40000 ALTER TABLE `Cinemahall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Client`
--

DROP TABLE IF EXISTS `Client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Client` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeKey` (`typeKey`),
  CONSTRAINT `Client_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `KinoServiceTYPEKEYS` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Client`
--

LOCK TABLES `Client` WRITE;
/*!40000 ALTER TABLE `Client` DISABLE KEYS */;
/*!40000 ALTER TABLE `Client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Film`
--

DROP TABLE IF EXISTS `Film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Film` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL,
  `titel` varchar(255) DEFAULT NULL,
  `descritpion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeKey` (`typeKey`),
  CONSTRAINT `Film_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `KinoServiceTYPEKEYS` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Film`
--

LOCK TABLES `Film` WRITE;
/*!40000 ALTER TABLE `Film` DISABLE KEYS */;
/*!40000 ALTER TABLE `Film` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `KinoService`
--

DROP TABLE IF EXISTS `KinoService`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `KinoService` (
  `id` int(11) NOT NULL,
  `objectSequencer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `KinoService`
--

LOCK TABLES `KinoService` WRITE;
/*!40000 ALTER TABLE `KinoService` DISABLE KEYS */;
INSERT INTO `KinoService` VALUES
(1,27);
/*!40000 ALTER TABLE `KinoService` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `KinoServiceTYPEKEYS`
--

DROP TABLE IF EXISTS `KinoServiceTYPEKEYS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `KinoServiceTYPEKEYS` (
  `id` int(11) NOT NULL,
  `typeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeName_index` (`typeName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `KinoServiceTYPEKEYS`
--

LOCK TABLES `KinoServiceTYPEKEYS` WRITE;
/*!40000 ALTER TABLE `KinoServiceTYPEKEYS` DISABLE KEYS */;
INSERT INTO `KinoServiceTYPEKEYS` VALUES
(22,'Booking'),
(24,'bookingPerformance'),
(23,'book_Seat'),
(11,'Categorie'),
(7,'CiHa_SeRo'),
(6,'Cinemahall'),
(19,'Client'),
(20,'clie_book'),
(21,'clie_rese'),
(2,'Film'),
(4,'filmPerformance'),
(13,'Loge'),
(14,'LogeService'),
(12,'Parquet'),
(3,'Performance'),
(5,'perf_CiHa'),
(16,'Reservation'),
(18,'reservationPerformance'),
(17,'rese_Seat'),
(15,'Seat'),
(8,'SeatRow'),
(10,'seatRowSeat'),
(9,'seRo_Ca');
/*!40000 ALTER TABLE `KinoServiceTYPEKEYS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Performance`
--

DROP TABLE IF EXISTS `Performance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Performance` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `typeKey` (`typeKey`),
  CONSTRAINT `Performance_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `KinoServiceTYPEKEYS` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Performance`
--

LOCK TABLES `Performance` WRITE;
/*!40000 ALTER TABLE `Performance` DISABLE KEYS */;
/*!40000 ALTER TABLE `Performance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Reservation`
--

DROP TABLE IF EXISTS `Reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Reservation` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL,
  `valid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeKey` (`typeKey`),
  CONSTRAINT `Reservation_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `KinoServiceTYPEKEYS` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reservation`
--

LOCK TABLES `Reservation` WRITE;
/*!40000 ALTER TABLE `Reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `Reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Seat`
--

DROP TABLE IF EXISTS `Seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Seat` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `typeKey` (`typeKey`),
  CONSTRAINT `Seat_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `KinoServiceTYPEKEYS` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Seat`
--

LOCK TABLES `Seat` WRITE;
/*!40000 ALTER TABLE `Seat` DISABLE KEYS */;
/*!40000 ALTER TABLE `Seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SeatRow`
--

DROP TABLE IF EXISTS `SeatRow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SeatRow` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL,
  `numberOfSeats` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeKey` (`typeKey`),
  CONSTRAINT `SeatRow_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `KinoServiceTYPEKEYS` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SeatRow`
--

LOCK TABLES `SeatRow` WRITE;
/*!40000 ALTER TABLE `SeatRow` DISABLE KEYS */;
/*!40000 ALTER TABLE `SeatRow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_Seat`
--

DROP TABLE IF EXISTS `book_Seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_Seat` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `p1` (`p1`),
  KEY `p2` (`p2`),
  CONSTRAINT `book_Seat_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `Booking` (`id`) ON DELETE CASCADE,
  CONSTRAINT `book_Seat_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `Seat` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_Seat`
--

LOCK TABLES `book_Seat` WRITE;
/*!40000 ALTER TABLE `book_Seat` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_Seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookingPerformance`
--

DROP TABLE IF EXISTS `bookingPerformance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookingPerformance` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `p1` (`p1`),
  KEY `p2` (`p2`),
  CONSTRAINT `bookingPerformance_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `Booking` (`id`) ON DELETE CASCADE,
  CONSTRAINT `bookingPerformance_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `Performance` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookingPerformance`
--

LOCK TABLES `bookingPerformance` WRITE;
/*!40000 ALTER TABLE `bookingPerformance` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookingPerformance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clie_book`
--

DROP TABLE IF EXISTS `clie_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clie_book` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `p1` (`p1`),
  KEY `p2` (`p2`),
  CONSTRAINT `clie_book_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `Client` (`id`) ON DELETE CASCADE,
  CONSTRAINT `clie_book_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `Booking` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clie_book`
--

LOCK TABLES `clie_book` WRITE;
/*!40000 ALTER TABLE `clie_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `clie_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clie_rese`
--

DROP TABLE IF EXISTS `clie_rese`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clie_rese` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `p1` (`p1`),
  KEY `p2` (`p2`),
  CONSTRAINT `clie_rese_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `Client` (`id`) ON DELETE CASCADE,
  CONSTRAINT `clie_rese_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `Reservation` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clie_rese`
--

LOCK TABLES `clie_rese` WRITE;
/*!40000 ALTER TABLE `clie_rese` DISABLE KEYS */;
/*!40000 ALTER TABLE `clie_rese` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filmPerformance`
--

DROP TABLE IF EXISTS `filmPerformance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filmPerformance` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `p1` (`p1`),
  KEY `p2` (`p2`),
  CONSTRAINT `filmPerformance_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `Performance` (`id`) ON DELETE CASCADE,
  CONSTRAINT `filmPerformance_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `Film` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filmPerformance`
--

LOCK TABLES `filmPerformance` WRITE;
/*!40000 ALTER TABLE `filmPerformance` DISABLE KEYS */;
/*!40000 ALTER TABLE `filmPerformance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perf_CiHa`
--

DROP TABLE IF EXISTS `perf_CiHa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perf_CiHa` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `p1` (`p1`),
  KEY `p2` (`p2`),
  CONSTRAINT `perf_CiHa_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `Performance` (`id`) ON DELETE CASCADE,
  CONSTRAINT `perf_CiHa_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `Cinemahall` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perf_CiHa`
--

LOCK TABLES `perf_CiHa` WRITE;
/*!40000 ALTER TABLE `perf_CiHa` DISABLE KEYS */;
/*!40000 ALTER TABLE `perf_CiHa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rese_Seat`
--

DROP TABLE IF EXISTS `rese_Seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rese_Seat` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `p1` (`p1`),
  KEY `p2` (`p2`),
  CONSTRAINT `rese_Seat_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `Reservation` (`id`) ON DELETE CASCADE,
  CONSTRAINT `rese_Seat_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `Seat` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rese_Seat`
--

LOCK TABLES `rese_Seat` WRITE;
/*!40000 ALTER TABLE `rese_Seat` DISABLE KEYS */;
/*!40000 ALTER TABLE `rese_Seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservationPerformance`
--

DROP TABLE IF EXISTS `reservationPerformance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservationPerformance` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `p1` (`p1`),
  KEY `p2` (`p2`),
  CONSTRAINT `reservationPerformance_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `Reservation` (`id`) ON DELETE CASCADE,
  CONSTRAINT `reservationPerformance_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `Performance` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservationPerformance`
--

LOCK TABLES `reservationPerformance` WRITE;
/*!40000 ALTER TABLE `reservationPerformance` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservationPerformance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seRo_Ca`
--

DROP TABLE IF EXISTS `seRo_Ca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seRo_Ca` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `p1` (`p1`),
  KEY `p2` (`p2`),
  CONSTRAINT `seRo_Ca_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `SeatRow` (`id`) ON DELETE CASCADE,
  CONSTRAINT `seRo_Ca_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `Categorie` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seRo_Ca`
--

LOCK TABLES `seRo_Ca` WRITE;
/*!40000 ALTER TABLE `seRo_Ca` DISABLE KEYS */;
/*!40000 ALTER TABLE `seRo_Ca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seatRowSeat`
--

DROP TABLE IF EXISTS `seatRowSeat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seatRowSeat` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `p1` (`p1`),
  KEY `p2` (`p2`),
  CONSTRAINT `seatRowSeat_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `Seat` (`id`) ON DELETE CASCADE,
  CONSTRAINT `seatRowSeat_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `SeatRow` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seatRowSeat`
--

LOCK TABLES `seatRowSeat` WRITE;
/*!40000 ALTER TABLE `seatRowSeat` DISABLE KEYS */;
/*!40000 ALTER TABLE `seatRowSeat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-29 14:41:06
