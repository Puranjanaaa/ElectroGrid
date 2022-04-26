-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2022 at 05:24 PM
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
-- Database: `electrogrid`
--

-- --------------------------------------------------------

--
-- Table structure for table `monitoringservice`
--

CREATE TABLE `monitoringservice` (
  `AccountNumber` int(11) NOT NULL,
  `NoOfUnits` int(11) NOT NULL,
  `DateTime` varchar(30) NOT NULL,
  `AdditionalUnits` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `monitoringservice`
--

INSERT INTO `monitoringservice` (`AccountNumber`, `NoOfUnits`, `DateTime`, `AdditionalUnits`) VALUES
(464, 149, '21/04/2022 11:13:20', 49),
(465, 131, '23/04/2022 11:46:12', 31),
(466, 160, '23/04/2022 11:37:16', 60),
(467, 81, '23/04/2022 11:43:50', 0),
(468, 131, '23/04/2022 14:25:01', 31),
(469, 131, '23/04/2022 14:23:10', 31),
(470, 180, '24/04/2022 18:06:47', 80);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `accNo` int(11) NOT NULL,
  `units` double(10,5) NOT NULL,
  `additionalUnits` double(10,5) NOT NULL,
  `amount` double(10,5) NOT NULL,
  `dueDate` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`accNo`, `units`, `additionalUnits`, `amount`, `dueDate`) VALUES
(1001, 90.00000, 10.00000, 0.00000, '3/3/2022'),
(1002, 70.00000, 0.00000, 1710.00000, '3/3/2022'),
(1003, 90.00000, 10.00000, 1710.00000, '3/3/2022'),
(1004, 90.00000, 0.00000, 0.00000, '12/5/2022'),
(1010, 152.00000, 12.00000, 0.00000, '3/3/2022');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `monitoringservice`
--
ALTER TABLE `monitoringservice`
  ADD PRIMARY KEY (`AccountNumber`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`accNo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
