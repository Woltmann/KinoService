-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 28. Nov 2023 um 09:00
-- Server-Version: 10.4.25-MariaDB
-- PHP-Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `kinoservice`
--
CREATE DATABASE IF NOT EXISTS `kinoservice` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `kinoservice`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `booking`
--

CREATE TABLE `booking` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bookingclient`
--

CREATE TABLE `bookingclient` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bookingperformance`
--

CREATE TABLE `bookingperformance` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `book_seat`
--

CREATE TABLE `book_seat` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL,
  `basePrice` int(11) DEFAULT NULL,
  `priceSurchargeLoge` int(11) DEFAULT NULL,
  `priceSurchargeLogeService` int(11) DEFAULT NULL,
  `serviceTyp` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `categorie`
--

INSERT INTO `categorie` (`id`, `typeKey`, `basePrice`, `priceSurchargeLoge`, `priceSurchargeLogeService`, `serviceTyp`) VALUES
(25, 12, NULL, NULL, NULL, NULL),
(26, 13, NULL, NULL, NULL, NULL),
(27, 14, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `ciha_sero`
--

CREATE TABLE `ciha_sero` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `cinemahall`
--

CREATE TABLE `cinemahall` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL,
  `hallname` varchar(255) DEFAULT NULL,
  `isFree` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `client`
--

INSERT INTO `client` (`id`, `typeKey`, `name`, `email`) VALUES
(28, 20, 'BastiTest1', 'basti.test@gmail.gov'),
(29, 20, 'Basti', 'basti@mail.de');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `film`
--

CREATE TABLE `film` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL,
  `titel` varchar(255) DEFAULT NULL,
  `descritpion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `filmperformance`
--

CREATE TABLE `filmperformance` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `kinoservice`
--

CREATE TABLE `kinoservice` (
  `id` int(11) NOT NULL,
  `objectSequencer` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `kinoservice`
--

INSERT INTO `kinoservice` (`id`, `objectSequencer`) VALUES
(1, 29);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `kinoservicetypekeys`
--

CREATE TABLE `kinoservicetypekeys` (
  `id` int(11) NOT NULL,
  `typeName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `kinoservicetypekeys`
--

INSERT INTO `kinoservicetypekeys` (`id`, `typeName`) VALUES
(21, 'Booking'),
(22, 'bookingClient'),
(24, 'bookingPerformance'),
(23, 'book_Seat'),
(11, 'Categorie'),
(7, 'CiHa_SeRo'),
(6, 'Cinemahall'),
(20, 'Client'),
(2, 'Film'),
(4, 'filmPerformance'),
(13, 'Loge'),
(14, 'LogeService'),
(12, 'Parquet'),
(3, 'Performance'),
(5, 'perf_CiHa'),
(16, 'Reservation'),
(19, 'reservationClient'),
(18, 'reservationPerformance'),
(17, 'rese_Seat'),
(15, 'Seat'),
(8, 'SeatRow'),
(10, 'seatRowSeat'),
(9, 'seRo_Ca');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `performance`
--

CREATE TABLE `performance` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `perf_ciha`
--

CREATE TABLE `perf_ciha` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL,
  `valid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `reservationclient`
--

CREATE TABLE `reservationclient` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `reservationperformance`
--

CREATE TABLE `reservationperformance` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `rese_seat`
--

CREATE TABLE `rese_seat` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `seat`
--

CREATE TABLE `seat` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `seatrow`
--

CREATE TABLE `seatrow` (
  `id` int(11) NOT NULL,
  `typeKey` int(11) NOT NULL,
  `numberOfSeats` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `seatrowseat`
--

CREATE TABLE `seatrowseat` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `sero_ca`
--

CREATE TABLE `sero_ca` (
  `id` int(11) NOT NULL,
  `p1` int(11) NOT NULL,
  `p2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `typeKey` (`typeKey`);

--
-- Indizes für die Tabelle `bookingclient`
--
ALTER TABLE `bookingclient`
  ADD PRIMARY KEY (`id`),
  ADD KEY `p1` (`p1`),
  ADD KEY `p2` (`p2`);

--
-- Indizes für die Tabelle `bookingperformance`
--
ALTER TABLE `bookingperformance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `p1` (`p1`),
  ADD KEY `p2` (`p2`);

--
-- Indizes für die Tabelle `book_seat`
--
ALTER TABLE `book_seat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `p1` (`p1`),
  ADD KEY `p2` (`p2`);

--
-- Indizes für die Tabelle `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `typeKey` (`typeKey`);

--
-- Indizes für die Tabelle `ciha_sero`
--
ALTER TABLE `ciha_sero`
  ADD PRIMARY KEY (`id`),
  ADD KEY `p1` (`p1`),
  ADD KEY `p2` (`p2`);

--
-- Indizes für die Tabelle `cinemahall`
--
ALTER TABLE `cinemahall`
  ADD PRIMARY KEY (`id`),
  ADD KEY `typeKey` (`typeKey`);

--
-- Indizes für die Tabelle `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `typeKey` (`typeKey`);

--
-- Indizes für die Tabelle `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id`),
  ADD KEY `typeKey` (`typeKey`);

--
-- Indizes für die Tabelle `filmperformance`
--
ALTER TABLE `filmperformance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `p1` (`p1`),
  ADD KEY `p2` (`p2`);

--
-- Indizes für die Tabelle `kinoservice`
--
ALTER TABLE `kinoservice`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `kinoservicetypekeys`
--
ALTER TABLE `kinoservicetypekeys`
  ADD PRIMARY KEY (`id`),
  ADD KEY `typeName_index` (`typeName`);

--
-- Indizes für die Tabelle `performance`
--
ALTER TABLE `performance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `typeKey` (`typeKey`);

--
-- Indizes für die Tabelle `perf_ciha`
--
ALTER TABLE `perf_ciha`
  ADD PRIMARY KEY (`id`),
  ADD KEY `p1` (`p1`),
  ADD KEY `p2` (`p2`);

--
-- Indizes für die Tabelle `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `typeKey` (`typeKey`);

--
-- Indizes für die Tabelle `reservationclient`
--
ALTER TABLE `reservationclient`
  ADD PRIMARY KEY (`id`),
  ADD KEY `p1` (`p1`),
  ADD KEY `p2` (`p2`);

--
-- Indizes für die Tabelle `reservationperformance`
--
ALTER TABLE `reservationperformance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `p1` (`p1`),
  ADD KEY `p2` (`p2`);

--
-- Indizes für die Tabelle `rese_seat`
--
ALTER TABLE `rese_seat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `p1` (`p1`),
  ADD KEY `p2` (`p2`);

--
-- Indizes für die Tabelle `seat`
--
ALTER TABLE `seat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `typeKey` (`typeKey`);

--
-- Indizes für die Tabelle `seatrow`
--
ALTER TABLE `seatrow`
  ADD PRIMARY KEY (`id`),
  ADD KEY `typeKey` (`typeKey`);

--
-- Indizes für die Tabelle `seatrowseat`
--
ALTER TABLE `seatrowseat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `p1` (`p1`),
  ADD KEY `p2` (`p2`);

--
-- Indizes für die Tabelle `sero_ca`
--
ALTER TABLE `sero_ca`
  ADD PRIMARY KEY (`id`),
  ADD KEY `p1` (`p1`),
  ADD KEY `p2` (`p2`);

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `kinoservicetypekeys` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `bookingclient`
--
ALTER TABLE `bookingclient`
  ADD CONSTRAINT `bookingclient_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `booking` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `bookingclient_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `client` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `bookingperformance`
--
ALTER TABLE `bookingperformance`
  ADD CONSTRAINT `bookingperformance_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `booking` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `bookingperformance_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `performance` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `book_seat`
--
ALTER TABLE `book_seat`
  ADD CONSTRAINT `book_seat_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `booking` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `book_seat_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `seat` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `categorie`
--
ALTER TABLE `categorie`
  ADD CONSTRAINT `categorie_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `kinoservicetypekeys` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `ciha_sero`
--
ALTER TABLE `ciha_sero`
  ADD CONSTRAINT `ciha_sero_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `cinemahall` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `ciha_sero_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `seatrow` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `cinemahall`
--
ALTER TABLE `cinemahall`
  ADD CONSTRAINT `cinemahall_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `kinoservicetypekeys` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `kinoservicetypekeys` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `film_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `kinoservicetypekeys` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `filmperformance`
--
ALTER TABLE `filmperformance`
  ADD CONSTRAINT `filmperformance_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `performance` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `filmperformance_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `film` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `performance`
--
ALTER TABLE `performance`
  ADD CONSTRAINT `performance_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `kinoservicetypekeys` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `perf_ciha`
--
ALTER TABLE `perf_ciha`
  ADD CONSTRAINT `perf_ciha_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `performance` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `perf_ciha_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `cinemahall` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `kinoservicetypekeys` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `reservationclient`
--
ALTER TABLE `reservationclient`
  ADD CONSTRAINT `reservationclient_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `reservation` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `reservationclient_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `client` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `reservationperformance`
--
ALTER TABLE `reservationperformance`
  ADD CONSTRAINT `reservationperformance_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `reservation` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `reservationperformance_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `performance` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `rese_seat`
--
ALTER TABLE `rese_seat`
  ADD CONSTRAINT `rese_seat_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `reservation` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `rese_seat_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `seat` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `seat`
--
ALTER TABLE `seat`
  ADD CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `kinoservicetypekeys` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `seatrow`
--
ALTER TABLE `seatrow`
  ADD CONSTRAINT `seatrow_ibfk_1` FOREIGN KEY (`typeKey`) REFERENCES `kinoservicetypekeys` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `seatrowseat`
--
ALTER TABLE `seatrowseat`
  ADD CONSTRAINT `seatrowseat_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `seat` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `seatrowseat_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `seatrow` (`id`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `sero_ca`
--
ALTER TABLE `sero_ca`
  ADD CONSTRAINT `sero_ca_ibfk_1` FOREIGN KEY (`p1`) REFERENCES `seatrow` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `sero_ca_ibfk_2` FOREIGN KEY (`p2`) REFERENCES `categorie` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
