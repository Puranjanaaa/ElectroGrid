-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2022 at 04:53 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pafdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `monitoringservice`
--

CREATE TABLE `monitoringservice` (
  `AccountNumber` int(30) NOT NULL,
  `NoOfUnits` int(30) DEFAULT NULL,
  `DateTime` varchar(50) DEFAULT NULL,
  `AdditionalUnits` int(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `monitoringservice`
--

INSERT INTO `monitoringservice` (`AccountNumber`, `NoOfUnits`, `DateTime`, `AdditionalUnits`) VALUES
(465, 131, '23/04/2022 11:46:12', 31),
(466, 160, '23/04/2022 11:37:16', 60),
(467, 81, '23/04/2022 11:43:50', 0),
(468, 108, '26/04/2022 13:28:50', 8),
(469, 131, '23/04/2022 14:23:10', 31),
(470, 180, '24/04/2022 18:06:47', 80),
(471, 100, '24/04/2022 23:45:52', 0),
(472, 160, '26/04/2022 13:28:20', 60);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `monitoringservice`
--
ALTER TABLE `monitoringservice`
  ADD PRIMARY KEY (`AccountNumber`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
