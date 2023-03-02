-- phpMyAdmin SQL Dump
-- version 2.11.6
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 09, 2021 at 07:30 AM
-- Server version: 5.0.51
-- PHP Version: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `studentrecord`
--

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE `marks` (
  `StudentID` int(100) default NULL,
  `Firstname` varchar(100) default NULL,
  `Surname` varchar(100) default NULL,
  `Maths` int(100) default NULL,
  `English` int(100) default NULL,
  `ET1` int(100) NOT NULL default '0',
  `ET2` int(100) NOT NULL default '0',
  `ET3` int(100) NOT NULL default '0',
  `EA1` int(100) NOT NULL default '0',
  `EA2` int(100) NOT NULL default '0',
  `EA3` int(100) NOT NULL default '0',
  `EA4` int(100) NOT NULL default '0',
  `Biology` int(100) default NULL,
  `Computing` int(100) default NULL,
  `Chemistry` int(100) default NULL,
  `Physics` int(100) default NULL,
  `Add_Maths` int(100) default NULL,
  `Business` int(100) default NULL,
  `Total_Score` int(100) default NULL,
  `Average` int(100) default NULL,
  `Ranking` varchar(10) default NULL,
  `MT1` int(100) default NULL,
  `MT2` int(100) default NULL,
  `MT3` int(100) default NULL,
  `MT4` int(100) default NULL,
  `MathsTotal` int(100) default NULL,
  `MathsRank` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`StudentID`, `Firstname`, `Surname`, `Maths`, `English`, `ET1`, `ET2`, `ET3`, `EA1`, `EA2`, `EA3`, `EA4`, `Biology`, `Computing`, `Chemistry`, `Physics`, `Add_Maths`, `Business`, `Total_Score`, `Average`, `Ranking`, `MT1`, `MT2`, `MT3`, `MT4`, `MathsTotal`, `MathsRank`) VALUES
(NULL, '', '', NULL, 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(789456, 'ee', 'dd', 86, 87, 0, 0, 0, 0, 0, 0, 0, 90, 99, 70, 86, 86, 76, 692, 98, 'B', 20, 21, 22, 23, NULL, NULL),
(55055, 'Kenny', 'Henoma', 86, 98, 20, 19, 20, 10, 9, 10, 10, 79, 83, 91, 86, 69, 94, 662, 92, 'B', 20, 21, 22, 23, NULL, NULL),
(8963, 'york', 'kemp', 93, 85, 0, 0, 0, 0, 0, 0, 0, 96, 92, 89, 87, 82, 64, 691, 96, 'B', 3, 4, 5, 6, NULL, NULL),
(37896, 'bob', 's', 93, 98, 0, 0, 0, 0, 0, 0, 0, 86, 78, 96, 48, 86, 97, 675, 86, 'B', 24, 21, 22, 23, NULL, NULL),
(12345678, 'Jack', 'Johnson', 98, 90, 0, 0, 0, 0, 0, 0, 0, 97, 92, 89, 81, 94, 96, 737, 98, 'A', NULL, NULL, NULL, NULL, NULL, NULL),
(7, 'James', 'Bond', 99, 87, 0, 0, 0, 0, 0, 0, 0, 77, 67, 57, 47, 37, 27, 496, 97, 'D', NULL, NULL, NULL, NULL, NULL, NULL),
(22005, 'tom', 'leps', 92, 93, 0, 0, 0, 0, 0, 0, 0, 95, 99, 91, 97, 96, 97, 760, 92, 'A', NULL, NULL, NULL, NULL, NULL, NULL),
(6665522, 'steele', 'Baue', 96, 99, 0, 0, 0, 0, 0, 0, 0, 98, 92, 91, 99, 90, 97, 762, 96, 'A', NULL, NULL, NULL, NULL, NULL, NULL),
(969696, 'mark', 'Baue', 96, 99, 0, 0, 0, 0, 0, 0, 0, 98, 92, 91, 99, 90, 97, 762, 96, 'A', NULL, NULL, NULL, NULL, NULL, NULL),
(521478, 'cemberly', 'brook', 93, 85, 0, 0, 0, 0, 0, 0, 0, 92, 89, 87, 92, 82, 64, 684, 93, 'B', NULL, NULL, NULL, NULL, NULL, NULL),
(565, 'yothh', 'serty', 98, 45, 0, 0, 0, 0, 0, 0, 0, 56, 45, 51, 87, 87, 69, 538, 98, 'C', NULL, NULL, NULL, NULL, NULL, NULL),
(12467869, 'tee', 'gee', 98, 65, 0, 0, 0, 0, 0, 0, 0, 32, 98, 100, 86, 96, 99, 674, 98, 'B', NULL, NULL, NULL, NULL, NULL, NULL),
(1001, 'Mikes', 'Torot', 100, 68, 0, 0, 0, 0, 0, 0, 0, 79, 83, 91, 86, 69, 94, 670, 100, 'B', NULL, NULL, NULL, NULL, NULL, NULL),
(NULL, NULL, NULL, NULL, NULL, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '8'),
(NULL, NULL, NULL, NULL, NULL, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1'),
(225, 'Simon', 'Max', 89, 63, 0, 0, 0, 0, 0, 0, 0, 93, 82, 91, 89, 91, 93, 691, 89, 'B', NULL, NULL, NULL, NULL, NULL, NULL),
(456826, 'Jerrty', 'Tom', 93, 92, 0, 0, 0, 0, 0, 0, 0, 90, 82, 81, 91, 70, 92, 691, 93, 'B', NULL, NULL, NULL, NULL, NULL, NULL),
(76602, 'Jimmy ', 'Barnes', 89, 92, 0, 0, 0, 0, 0, 0, 0, 91, 92, 86, 94, 82, 69, 695, 89, 'B', NULL, NULL, NULL, NULL, NULL, NULL),
(8300778, 'Kay', 'Sam', 10, 45, 0, 0, 0, 0, 0, 0, 0, 45, 45, 45, 45, 45, 45, 325, 10, 'E', NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'fg', 'po', 45, 45, 0, 0, 0, 0, 0, 0, 0, 45, 45, 54, 45, 45, 45, 369, 45, 'E', NULL, NULL, NULL, NULL, NULL, NULL),
(687, 'sdf', 'xcv', 96, 25, 0, 0, 0, 0, 0, 0, 0, 99, 87, 96, 86, 47, 86, 622, 96, 'B', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `overall`
--

CREATE TABLE `overall` (
  `StudentID` int(100) NOT NULL default '0',
  `FirstName` varchar(100) default NULL,
  `LastName` varchar(100) default NULL,
  `English` int(100) NOT NULL default '0',
  `ET1` int(100) NOT NULL default '0',
  `ET2` int(100) NOT NULL default '0',
  `ET3` int(100) NOT NULL default '0',
  `EA1` int(100) NOT NULL default '0',
  `EA2` int(100) NOT NULL default '0',
  `EA3` int(100) NOT NULL default '0',
  `EA4` int(100) NOT NULL default '0',
  `English_Ranking` int(100) default NULL,
  `Maths` int(100) NOT NULL default '0',
  `MT1` int(100) NOT NULL default '0',
  `MT2` int(100) NOT NULL default '0',
  `MT3` int(100) NOT NULL default '0',
  `MA1` int(100) NOT NULL default '0',
  `MA2` int(100) NOT NULL default '0',
  `MA3` int(100) NOT NULL default '0',
  `MA4` int(100) NOT NULL default '0',
  `Maths_Ranking` int(100) default NULL,
  `Science` int(100) NOT NULL default '0',
  `ST1` int(100) NOT NULL default '0',
  `ST2` int(100) NOT NULL default '0',
  `ST3` int(100) NOT NULL default '0',
  `SA1` int(100) NOT NULL default '0',
  `SA2` int(100) NOT NULL default '0',
  `SA3` int(100) NOT NULL default '0',
  `SA4` int(100) NOT NULL default '0',
  `Science_Ranking` int(100) default NULL,
  `Social_Science` int(100) NOT NULL default '0',
  `SST1` int(100) NOT NULL default '0',
  `SST2` int(100) NOT NULL default '0',
  `SST3` int(100) NOT NULL default '0',
  `SSA1` int(100) NOT NULL default '0',
  `SSA2` int(100) NOT NULL default '0',
  `SSA3` int(100) NOT NULL default '0',
  `SSA4` int(100) NOT NULL default '0',
  `Social_Science_Ranking` int(100) default NULL,
  `MAL` int(100) NOT NULL default '0',
  `MALT1` int(100) NOT NULL default '0',
  `MALT2` int(100) NOT NULL default '0',
  `MALT3` int(100) NOT NULL default '0',
  `MALA1` int(100) NOT NULL default '0',
  `MALA2` int(100) NOT NULL default '0',
  `MALA3` int(100) NOT NULL default '0',
  `MALA4` int(100) NOT NULL default '0',
  `Making_A_Living_Ranking` int(100) default NULL,
  `HPE` int(100) NOT NULL default '0',
  `HPET1` int(100) NOT NULL default '0',
  `HPET2` int(100) NOT NULL default '0',
  `HPET3` int(100) NOT NULL default '0',
  `HPEA1` int(100) NOT NULL default '0',
  `HPEA2` int(100) NOT NULL default '0',
  `HPEA3` int(100) default '0',
  `HPEA4` int(100) NOT NULL default '0',
  `Health_PE_Ranking` int(100) default NULL,
  `Arts` int(100) NOT NULL default '0',
  `AT1` int(100) NOT NULL default '0',
  `AT2` int(100) NOT NULL default '0',
  `AT3` int(100) NOT NULL default '0',
  `AS1` int(100) NOT NULL default '0',
  `AS2` int(100) NOT NULL default '0',
  `AS3` int(100) NOT NULL default '0',
  `AS4` int(100) NOT NULL default '0',
  `Arts_Ranking` int(100) default NULL,
  `Total_Score` int(100) NOT NULL default '0',
  `Overall_Ranking` int(100) NOT NULL default '1',
  `Average` int(100) NOT NULL default '0',
  `GPA` int(100) NOT NULL default '0',
  `Grade` varchar(100) default NULL,
  `created_at` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`StudentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `overall`
--

INSERT INTO `overall` (`StudentID`, `FirstName`, `LastName`, `English`, `ET1`, `ET2`, `ET3`, `EA1`, `EA2`, `EA3`, `EA4`, `English_Ranking`, `Maths`, `MT1`, `MT2`, `MT3`, `MA1`, `MA2`, `MA3`, `MA4`, `Maths_Ranking`, `Science`, `ST1`, `ST2`, `ST3`, `SA1`, `SA2`, `SA3`, `SA4`, `Science_Ranking`, `Social_Science`, `SST1`, `SST2`, `SST3`, `SSA1`, `SSA2`, `SSA3`, `SSA4`, `Social_Science_Ranking`, `MAL`, `MALT1`, `MALT2`, `MALT3`, `MALA1`, `MALA2`, `MALA3`, `MALA4`, `Making_A_Living_Ranking`, `HPE`, `HPET1`, `HPET2`, `HPET3`, `HPEA1`, `HPEA2`, `HPEA3`, `HPEA4`, `Health_PE_Ranking`, `Arts`, `AT1`, `AT2`, `AT3`, `AS1`, `AS2`, `AS3`, `AS4`, `Arts_Ranking`, `Total_Score`, `Overall_Ranking`, `Average`, `GPA`, `Grade`, `created_at`) VALUES
(3500111, 'Duncan', 'Kottson', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 40, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 40, 1, 0, 0, 'Grade3', '2021-03-08 20:09:32'),
(3500122, 'Silas', 'Mark', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 50, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 50, 1, 0, 0, 'Grade4', '2021-03-08 11:55:09'),
(3500123, 'Tim', 'Tom', 80, 0, 0, 0, 0, 0, 0, 0, NULL, 110, 0, 0, 0, 0, 0, 0, 0, NULL, 60, 0, 0, 0, 0, 0, 0, 0, NULL, 60, 0, 0, 0, 0, 0, 0, 0, NULL, 60, 0, 0, 0, 0, 0, 0, 0, NULL, 60, 0, 0, 0, 0, 0, 0, 0, NULL, 60, 0, 0, 0, 0, 0, 0, 0, NULL, 490, 1, 0, 0, 'Grade3', '2021-02-27 16:56:37'),
(4100124, 'Sally', 'Peter', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 1, 0, 0, 'Grade4', '2021-02-18 12:43:02'),
(5100124, 'Robert', 'Simon', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 1, 0, 0, 'Grade5', '2021-02-18 12:43:49'),
(5100125, 'Nathan', 'Harris', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 1, 0, 0, 'Grade5', '2021-02-18 12:44:22'),
(6100125, 'Melany', 'Jerry', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 1, 0, 0, 'Grade6', '2021-02-18 12:45:15'),
(7100126, 'Albert', 'Knigh', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 1, 0, 0, 'Grade7', '2021-02-18 12:46:19'),
(7100127, 'Abraham', 'Kenny', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 1, 0, 0, 'Grade7', '2021-02-18 12:46:55'),
(8100127, 'Solomon', 'Vande', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 1, 0, 0, 'Grade8', '2021-02-18 12:48:35'),
(8100128, 'Emmanuel', 'Petrus', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 1, 0, 0, 'Grade8', '2021-02-18 12:49:11');

-- --------------------------------------------------------

--
-- Table structure for table `studentdetails`
--

CREATE TABLE `studentdetails` (
  `StudentID` int(100) NOT NULL default '0',
  `Firstname` char(100) default NULL,
  `Surname` char(100) default NULL,
  `Course_Code` char(100) default NULL,
  PRIMARY KEY  (`StudentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentdetails`
--


-- --------------------------------------------------------

--
-- Table structure for table `term1`
--

CREATE TABLE `term1` (
  `StudentID` int(100) NOT NULL default '0',
  `FirstName` varchar(100) default NULL,
  `LastName` varchar(100) default NULL,
  `English` int(100) NOT NULL default '0',
  `ET1` int(100) NOT NULL default '0',
  `ET2` int(100) NOT NULL default '0',
  `ET3` int(100) NOT NULL default '0',
  `EA1` int(100) NOT NULL default '0',
  `EA2` int(100) NOT NULL default '0',
  `EA3` int(100) NOT NULL default '0',
  `EA4` int(100) NOT NULL default '0',
  `English_Ranking` int(100) default NULL,
  `Maths` int(100) NOT NULL default '0',
  `MT1` int(100) NOT NULL default '0',
  `MT2` int(100) NOT NULL default '0',
  `MT3` int(100) NOT NULL default '0',
  `MA1` int(100) NOT NULL default '0',
  `MA2` int(100) NOT NULL default '0',
  `MA3` int(100) NOT NULL default '0',
  `MA4` int(100) NOT NULL default '0',
  `Maths_Ranking` int(100) default NULL,
  `Science` int(100) NOT NULL default '0',
  `ST1` int(100) NOT NULL default '0',
  `ST2` int(100) NOT NULL default '0',
  `ST3` int(100) NOT NULL default '0',
  `SA1` int(100) NOT NULL default '0',
  `SA2` int(100) NOT NULL default '0',
  `SA3` int(100) NOT NULL default '0',
  `SA4` int(100) NOT NULL default '0',
  `Science_Ranking` int(100) default NULL,
  `Social_Science` int(100) NOT NULL default '0',
  `SST1` int(100) NOT NULL default '0',
  `SST2` int(100) NOT NULL default '0',
  `SST3` int(100) NOT NULL default '0',
  `SSA1` int(100) NOT NULL default '0',
  `SSA2` int(100) NOT NULL default '0',
  `SSA3` int(100) NOT NULL default '0',
  `SSA4` int(100) NOT NULL default '0',
  `Social_Science_Ranking` int(100) default NULL,
  `MAL` int(100) NOT NULL default '0',
  `MALT1` int(100) NOT NULL default '0',
  `MALT2` int(100) NOT NULL default '0',
  `MALT3` int(100) NOT NULL default '0',
  `MALA1` int(100) NOT NULL default '0',
  `MALA2` int(100) NOT NULL default '0',
  `MALA3` int(100) NOT NULL default '0',
  `MALA4` int(100) NOT NULL default '0',
  `Making_A_Living_Ranking` int(100) default NULL,
  `HPE` int(100) NOT NULL default '0',
  `HPET1` int(100) NOT NULL default '0',
  `HPET2` int(100) NOT NULL default '0',
  `HPET3` int(100) NOT NULL default '0',
  `HPEA1` int(100) NOT NULL default '0',
  `HPEA2` int(100) NOT NULL default '0',
  `HPEA3` int(100) default '0',
  `HPEA4` int(100) NOT NULL default '0',
  `Health_PE_Ranking` int(100) default NULL,
  `Arts` int(100) NOT NULL default '0',
  `AT1` int(100) NOT NULL default '0',
  `AT2` int(100) NOT NULL default '0',
  `AT3` int(100) NOT NULL default '0',
  `AS1` int(100) NOT NULL default '0',
  `AS2` int(100) NOT NULL default '0',
  `AS3` int(100) NOT NULL default '0',
  `AS4` int(100) NOT NULL default '0',
  `Arts_Ranking` int(100) default NULL,
  `Total_Score` int(100) NOT NULL default '0',
  `Overall_Ranking` int(100) NOT NULL default '1',
  `Average` int(100) NOT NULL default '0',
  `GPA` int(100) NOT NULL default '0',
  `Grade` varchar(100) default NULL,
  `created_at` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`StudentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `term1`
--

INSERT INTO `term1` (`StudentID`, `FirstName`, `LastName`, `English`, `ET1`, `ET2`, `ET3`, `EA1`, `EA2`, `EA3`, `EA4`, `English_Ranking`, `Maths`, `MT1`, `MT2`, `MT3`, `MA1`, `MA2`, `MA3`, `MA4`, `Maths_Ranking`, `Science`, `ST1`, `ST2`, `ST3`, `SA1`, `SA2`, `SA3`, `SA4`, `Science_Ranking`, `Social_Science`, `SST1`, `SST2`, `SST3`, `SSA1`, `SSA2`, `SSA3`, `SSA4`, `Social_Science_Ranking`, `MAL`, `MALT1`, `MALT2`, `MALT3`, `MALA1`, `MALA2`, `MALA3`, `MALA4`, `Making_A_Living_Ranking`, `HPE`, `HPET1`, `HPET2`, `HPET3`, `HPEA1`, `HPEA2`, `HPEA3`, `HPEA4`, `Health_PE_Ranking`, `Arts`, `AT1`, `AT2`, `AT3`, `AS1`, `AS2`, `AS3`, `AS4`, `Arts_Ranking`, `Total_Score`, `Overall_Ranking`, `Average`, `GPA`, `Grade`, `created_at`) VALUES
(3500111, 'Duncan', 'Kottson', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 20, 20, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 20, 1, 0, 0, 'Grade3', '2021-03-08 20:09:27'),
(3500122, 'Silas', 'Mark', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 20, 20, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 20, 1, 0, 0, 'Grade4', '2021-03-08 11:55:07'),
(3500123, 'Tim', 'Tom', 30, 0, 0, 0, 20, 0, 0, 0, NULL, 60, 0, 40, 0, 10, 0, 0, 0, NULL, 10, 0, 0, 0, 0, 0, 0, 0, NULL, 10, 0, 0, 0, 0, 0, 0, 0, NULL, 10, 0, 0, 0, 0, 0, 0, 0, NULL, 10, 0, 0, 0, 0, 0, 0, 0, NULL, 10, 0, 0, 0, 0, 0, 0, 0, NULL, 140, 1, 10, 0, 'Grade3', '2021-02-27 16:56:36'),
(4100124, 'Sally', 'Peter', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 1, 0, 0, 'Grade4', '2021-02-18 12:43:00'),
(5100124, 'Robert', 'Simon', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 1, 0, 0, 'Grade5', '2021-02-18 12:43:47'),
(5100125, 'Nathan', 'Harris', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 1, 0, 0, 'Grade5', '2021-02-18 12:44:21'),
(6100125, 'Melany', 'Jerry', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 1, 0, 0, 'Grade6', '2021-02-18 12:45:14'),
(7100126, 'Albert', 'Knigh', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 1, 0, 0, 'Grade7', '2021-02-18 12:46:18'),
(7100127, 'Abraham', 'Kenny', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 1, 0, 0, 'Grade7', '2021-02-18 12:46:53'),
(8100127, 'Solomon', 'Vande', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 1, 0, 0, 'Grade8', '2021-02-18 12:48:34'),
(8100128, 'Emmanuel', 'Petrus', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 1, 0, 0, 'Grade8', '2021-02-18 12:49:10');

-- --------------------------------------------------------

--
-- Table structure for table `term2`
--

CREATE TABLE `term2` (
  `StudentID` int(100) NOT NULL default '0',
  `FirstName` varchar(100) default NULL,
  `LastName` varchar(100) default NULL,
  `English` int(100) NOT NULL default '0',
  `ET1` int(100) NOT NULL default '0',
  `ET2` int(100) NOT NULL default '0',
  `ET3` int(100) NOT NULL default '0',
  `EA1` int(100) NOT NULL default '0',
  `EA2` int(100) NOT NULL default '0',
  `EA3` int(100) NOT NULL default '0',
  `EA4` int(100) NOT NULL default '0',
  `English_Ranking` int(100) default NULL,
  `Maths` int(100) NOT NULL default '0',
  `MT1` int(100) NOT NULL default '0',
  `MT2` int(100) NOT NULL default '0',
  `MT3` int(100) NOT NULL default '0',
  `MA1` int(100) NOT NULL default '0',
  `MA2` int(100) NOT NULL default '0',
  `MA3` int(100) NOT NULL default '0',
  `MA4` int(100) NOT NULL default '0',
  `Maths_Ranking` int(100) default NULL,
  `Science` int(100) NOT NULL default '0',
  `ST1` int(100) NOT NULL default '0',
  `ST2` int(100) NOT NULL default '0',
  `ST3` int(100) NOT NULL default '0',
  `SA1` int(100) NOT NULL default '0',
  `SA2` int(100) NOT NULL default '0',
  `SA3` int(100) NOT NULL default '0',
  `SA4` int(100) NOT NULL default '0',
  `Science_Ranking` int(100) default NULL,
  `Social_Science` int(100) NOT NULL default '0',
  `SST1` int(100) NOT NULL default '0',
  `SST2` int(100) NOT NULL default '0',
  `SST3` int(100) NOT NULL default '0',
  `SSA1` int(100) NOT NULL default '0',
  `SSA2` int(100) NOT NULL default '0',
  `SSA3` int(100) NOT NULL default '0',
  `SSA4` int(100) NOT NULL default '0',
  `Social_Science_Ranking` int(100) default NULL,
  `MAL` int(100) NOT NULL default '0',
  `MALT1` int(100) NOT NULL default '0',
  `MALT2` int(100) NOT NULL default '0',
  `MALT3` int(100) NOT NULL default '0',
  `MALA1` int(100) NOT NULL default '0',
  `MALA2` int(100) NOT NULL default '0',
  `MALA3` int(100) NOT NULL default '0',
  `MALA4` int(100) NOT NULL default '0',
  `MAL_Ranking` int(100) default NULL,
  `HPE` int(100) NOT NULL default '0',
  `HPET1` int(100) NOT NULL default '0',
  `HPET2` int(100) NOT NULL default '0',
  `HPET3` int(100) NOT NULL default '0',
  `HPEA1` int(100) NOT NULL default '0',
  `HPEA2` int(100) NOT NULL default '0',
  `HPEA3` int(100) default '0',
  `HPEA4` int(100) NOT NULL default '0',
  `HPE_Ranking` int(100) default NULL,
  `Arts` int(100) NOT NULL default '0',
  `AT1` int(100) NOT NULL default '0',
  `AT2` int(100) NOT NULL default '0',
  `AT3` int(100) NOT NULL default '0',
  `AS1` int(100) NOT NULL default '0',
  `AS2` int(100) NOT NULL default '0',
  `AS3` int(100) NOT NULL default '0',
  `AS4` int(100) NOT NULL default '0',
  `Arts_Ranking` int(100) default NULL,
  `Total_Score` int(100) NOT NULL default '0',
  `Overall_Ranking` int(100) default NULL,
  `Average` int(100) NOT NULL default '0',
  `GPA` int(100) NOT NULL default '0',
  `Grade` varchar(100) default NULL,
  `created_at` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`StudentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `term2`
--

INSERT INTO `term2` (`StudentID`, `FirstName`, `LastName`, `English`, `ET1`, `ET2`, `ET3`, `EA1`, `EA2`, `EA3`, `EA4`, `English_Ranking`, `Maths`, `MT1`, `MT2`, `MT3`, `MA1`, `MA2`, `MA3`, `MA4`, `Maths_Ranking`, `Science`, `ST1`, `ST2`, `ST3`, `SA1`, `SA2`, `SA3`, `SA4`, `Science_Ranking`, `Social_Science`, `SST1`, `SST2`, `SST3`, `SSA1`, `SSA2`, `SSA3`, `SSA4`, `Social_Science_Ranking`, `MAL`, `MALT1`, `MALT2`, `MALT3`, `MALA1`, `MALA2`, `MALA3`, `MALA4`, `MAL_Ranking`, `HPE`, `HPET1`, `HPET2`, `HPET3`, `HPEA1`, `HPEA2`, `HPEA3`, `HPEA4`, `HPE_Ranking`, `Arts`, `AT1`, `AT2`, `AT3`, `AS1`, `AS2`, `AS3`, `AS4`, `Arts_Ranking`, `Total_Score`, `Overall_Ranking`, `Average`, `GPA`, `Grade`, `created_at`) VALUES
(3500111, 'Duncan', 'Kottson', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 20, 20, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 20, NULL, 0, 0, 'Grade3', '2021-03-08 20:11:48'),
(3500122, 'Silas', 'Mark', 0, 0, 0, 0, 0, 0, 0, 0, NULL, 15, 15, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 15, NULL, 0, 0, 'Grade4', '2021-03-08 12:01:30'),
(3500123, 'Tim', 'Tom', 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 70, NULL, 0, 0, 'Grade3', '2021-02-28 11:56:04');

-- --------------------------------------------------------

--
-- Table structure for table `term3`
--

CREATE TABLE `term3` (
  `StudentID` int(100) NOT NULL default '0',
  `FirstName` varchar(100) default NULL,
  `LastName` varchar(100) default NULL,
  `English` int(100) NOT NULL default '0',
  `ET1` int(100) NOT NULL default '0',
  `ET2` int(100) NOT NULL default '0',
  `ET3` int(100) NOT NULL default '0',
  `EA1` int(100) NOT NULL default '0',
  `EA2` int(100) NOT NULL default '0',
  `EA3` int(100) NOT NULL default '0',
  `EA4` int(100) NOT NULL default '0',
  `English_Ranking` int(100) default NULL,
  `Maths` int(100) NOT NULL default '0',
  `MT1` int(100) NOT NULL default '0',
  `MT2` int(100) NOT NULL default '0',
  `MT3` int(100) NOT NULL default '0',
  `MA1` int(100) NOT NULL default '0',
  `MA2` int(100) NOT NULL default '0',
  `MA3` int(100) NOT NULL default '0',
  `MA4` int(100) NOT NULL default '0',
  `Maths_Ranking` int(100) default NULL,
  `Science` int(100) NOT NULL default '0',
  `ST1` int(100) NOT NULL default '0',
  `ST2` int(100) NOT NULL default '0',
  `ST3` int(100) NOT NULL default '0',
  `SA1` int(100) NOT NULL default '0',
  `SA2` int(100) NOT NULL default '0',
  `SA3` int(100) NOT NULL default '0',
  `SA4` int(100) NOT NULL default '0',
  `Science_Ranking` int(100) default NULL,
  `Social_Science` int(100) NOT NULL default '0',
  `SST1` int(100) NOT NULL default '0',
  `SST2` int(100) NOT NULL default '0',
  `SST3` int(100) NOT NULL default '0',
  `SSA1` int(100) NOT NULL default '0',
  `SSA2` int(100) NOT NULL default '0',
  `SSA3` int(100) NOT NULL default '0',
  `SSA4` int(100) NOT NULL default '0',
  `Social_Science_Ranking` int(100) default NULL,
  `MAL` int(100) NOT NULL default '0',
  `MALT1` int(100) NOT NULL default '0',
  `MALT2` int(100) NOT NULL default '0',
  `MALT3` int(100) NOT NULL default '0',
  `MALA1` int(100) NOT NULL default '0',
  `MALA2` int(100) NOT NULL default '0',
  `MALA3` int(100) NOT NULL default '0',
  `MALA4` int(100) NOT NULL default '0',
  `Making_A_Living_Ranking` int(100) default NULL,
  `HPE` int(100) NOT NULL default '0',
  `HPET1` int(100) NOT NULL default '0',
  `HPET2` int(100) NOT NULL default '0',
  `HPET3` int(100) NOT NULL default '0',
  `HPEA1` int(100) NOT NULL default '0',
  `HPEA2` int(100) NOT NULL default '0',
  `HPEA3` int(100) default '0',
  `HPEA4` int(100) NOT NULL default '0',
  `Health_PE_Ranking` int(100) default NULL,
  `Arts` int(100) NOT NULL default '0',
  `AT1` int(100) NOT NULL default '0',
  `AT2` int(100) NOT NULL default '0',
  `AT3` int(100) NOT NULL default '0',
  `AS1` int(100) NOT NULL default '0',
  `AS2` int(100) NOT NULL default '0',
  `AS3` int(100) NOT NULL default '0',
  `AS4` int(100) NOT NULL default '0',
  `Arts_Ranking` int(100) default NULL,
  `Total_Score` int(100) NOT NULL default '0',
  `Overall_Ranking` int(100) default '1',
  `Average` int(100) NOT NULL default '0',
  `GPA` int(100) NOT NULL default '0',
  `Grade` varchar(100) default NULL,
  `created_at` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`StudentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `term3`
--

INSERT INTO `term3` (`StudentID`, `FirstName`, `LastName`, `English`, `ET1`, `ET2`, `ET3`, `EA1`, `EA2`, `EA3`, `EA4`, `English_Ranking`, `Maths`, `MT1`, `MT2`, `MT3`, `MA1`, `MA2`, `MA3`, `MA4`, `Maths_Ranking`, `Science`, `ST1`, `ST2`, `ST3`, `SA1`, `SA2`, `SA3`, `SA4`, `Science_Ranking`, `Social_Science`, `SST1`, `SST2`, `SST3`, `SSA1`, `SSA2`, `SSA3`, `SSA4`, `Social_Science_Ranking`, `MAL`, `MALT1`, `MALT2`, `MALT3`, `MALA1`, `MALA2`, `MALA3`, `MALA4`, `Making_A_Living_Ranking`, `HPE`, `HPET1`, `HPET2`, `HPET3`, `HPEA1`, `HPEA2`, `HPEA3`, `HPEA4`, `Health_PE_Ranking`, `Arts`, `AT1`, `AT2`, `AT3`, `AS1`, `AS2`, `AS3`, `AS4`, `Arts_Ranking`, `Total_Score`, `Overall_Ranking`, `Average`, `GPA`, `Grade`, `created_at`) VALUES
(3500123, 'Tim', 'Tom', 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 70, 1, 0, 0, 'Grade3', '2021-02-28 12:00:18');

-- --------------------------------------------------------

--
-- Table structure for table `term4`
--

CREATE TABLE `term4` (
  `StudentID` int(100) NOT NULL default '0',
  `FirstName` varchar(100) default NULL,
  `LastName` varchar(100) default NULL,
  `English` int(100) NOT NULL default '0',
  `ET1` int(100) NOT NULL default '0',
  `ET2` int(100) NOT NULL default '0',
  `ET3` int(100) NOT NULL default '0',
  `EA1` int(100) NOT NULL default '0',
  `EA2` int(100) NOT NULL default '0',
  `EA3` int(100) NOT NULL default '0',
  `EA4` int(100) NOT NULL default '0',
  `English_Ranking` int(100) default NULL,
  `Maths` int(100) NOT NULL default '0',
  `MT1` int(100) NOT NULL default '0',
  `MT2` int(100) NOT NULL default '0',
  `MT3` int(100) NOT NULL default '0',
  `MA1` int(100) NOT NULL default '0',
  `MA2` int(100) NOT NULL default '0',
  `MA3` int(100) NOT NULL default '0',
  `MA4` int(100) NOT NULL default '0',
  `Maths_Ranking` int(100) default NULL,
  `Science` int(100) NOT NULL default '0',
  `ST1` int(100) NOT NULL default '0',
  `ST2` int(100) NOT NULL default '0',
  `ST3` int(100) NOT NULL default '0',
  `SA1` int(100) NOT NULL default '0',
  `SA2` int(100) NOT NULL default '0',
  `SA3` int(100) NOT NULL default '0',
  `SA4` int(100) NOT NULL default '0',
  `Science_Ranking` int(100) default NULL,
  `Social_Science` int(100) NOT NULL default '0',
  `SST1` int(100) NOT NULL default '0',
  `SST2` int(100) NOT NULL default '0',
  `SST3` int(100) NOT NULL default '0',
  `SSA1` int(100) NOT NULL default '0',
  `SSA2` int(100) NOT NULL default '0',
  `SSA3` int(100) NOT NULL default '0',
  `SSA4` int(100) NOT NULL default '0',
  `Social_Science_Ranking` int(100) default NULL,
  `MAL` int(100) NOT NULL default '0',
  `MALT1` int(100) NOT NULL default '0',
  `MALT2` int(100) NOT NULL default '0',
  `MALT3` int(100) NOT NULL default '0',
  `MALA1` int(100) NOT NULL default '0',
  `MALA2` int(100) NOT NULL default '0',
  `MALA3` int(100) NOT NULL default '0',
  `MALA4` int(100) NOT NULL default '0',
  `Making_A_Living_Ranking` int(100) default NULL,
  `HPE` int(100) NOT NULL default '0',
  `HPET1` int(100) NOT NULL default '0',
  `HPET2` int(100) NOT NULL default '0',
  `HPET3` int(100) NOT NULL default '0',
  `HPEA1` int(100) NOT NULL default '0',
  `HPEA2` int(100) NOT NULL default '0',
  `HPEA3` int(100) default '0',
  `HPEA4` int(100) NOT NULL default '0',
  `Health_PE_Ranking` int(100) default NULL,
  `Arts` int(100) NOT NULL default '0',
  `AT1` int(100) NOT NULL default '0',
  `AT2` int(100) NOT NULL default '0',
  `AT3` int(100) NOT NULL default '0',
  `AS1` int(100) NOT NULL default '0',
  `AS2` int(100) NOT NULL default '0',
  `AS3` int(100) NOT NULL default '0',
  `AS4` int(100) NOT NULL default '0',
  `Arts_Ranking` int(100) default NULL,
  `Total_Score` int(100) NOT NULL default '0',
  `Overall_Ranking` int(100) default NULL,
  `Average` int(100) NOT NULL default '0',
  `GPA` int(100) NOT NULL default '0',
  `Grade` varchar(100) default NULL,
  `created_at` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`StudentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `term4`
--

INSERT INTO `term4` (`StudentID`, `FirstName`, `LastName`, `English`, `ET1`, `ET2`, `ET3`, `EA1`, `EA2`, `EA3`, `EA4`, `English_Ranking`, `Maths`, `MT1`, `MT2`, `MT3`, `MA1`, `MA2`, `MA3`, `MA4`, `Maths_Ranking`, `Science`, `ST1`, `ST2`, `ST3`, `SA1`, `SA2`, `SA3`, `SA4`, `Science_Ranking`, `Social_Science`, `SST1`, `SST2`, `SST3`, `SSA1`, `SSA2`, `SSA3`, `SSA4`, `Social_Science_Ranking`, `MAL`, `MALT1`, `MALT2`, `MALT3`, `MALA1`, `MALA2`, `MALA3`, `MALA4`, `Making_A_Living_Ranking`, `HPE`, `HPET1`, `HPET2`, `HPET3`, `HPEA1`, `HPEA2`, `HPEA3`, `HPEA4`, `Health_PE_Ranking`, `Arts`, `AT1`, `AT2`, `AT3`, `AS1`, `AS2`, `AS3`, `AS4`, `Arts_Ranking`, `Total_Score`, `Overall_Ranking`, `Average`, `GPA`, `Grade`, `created_at`) VALUES
(3500123, 'Tim', 'Tom', 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 10, 10, 0, 0, 0, 0, 0, 0, NULL, 70, NULL, 0, 0, 'Grade3', '2021-02-27 16:57:57');
