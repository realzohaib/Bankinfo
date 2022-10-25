-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 18, 2022 at 08:40 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `zohaibdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `Accountno` int(11) NOT NULL,
  `Fname` varchar(30) DEFAULT NULL,
  `Lname` varchar(30) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `Pincode` varchar(10) DEFAULT NULL,
  `Mobileno` varchar(10) DEFAULT NULL,
  `Regdate` date DEFAULT NULL,
  `currentstatus` varchar(10) DEFAULT NULL CHECK (`currentstatus` in ('active','close'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`Accountno`, `Fname`, `Lname`, `Gender`, `Address`, `City`, `Pincode`, `Mobileno`, `Regdate`, `currentstatus`) VALUES
(101, 'zohaib ', 'khan', 'male', 'idgah hils', 'Bhopal', '462001', '774593910', '2022-10-17', 'active'),
(102, 'shszeb', 'khan', 'male', 'kohefiza', 'bhopal', '462001', '34455788', '2022-12-02', 'active'),
(103, 'mujeeb', 'khan', 'male', 'idgah hills', 'bhopal', '462001', '8871457899', '2022-10-17', 'active'),
(104, 'ajay', 'nagar', 'male', 'Park hills', 'Mumbai', '6478', '5674036593', '2021-04-23', 'active'),
(105, 'moiz', 'khan', 'male', 'ghar', 'Bhopal', '462001', '7585813486', '2022-03-28', 'active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`Accountno`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
