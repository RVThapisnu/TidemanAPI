-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 24, 2025 at 10:46 AM
-- Server version: 10.11.11-MariaDB-0+deb12u1
-- PHP Version: 8.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `User`
--

--
-- Dumping data for table `election`
--

INSERT INTO `election` (`id`, `name` , `status`) VALUES
(1, 'E1', 1),
(2, 'E2', 1);

--
-- Dumping data for table `candidate`
--

INSERT INTO `candidate` (`election_id`, `id`, `name`) VALUES
(1, 1, 'C11'),
(1, 2, 'C12'),
(2, 3, 'C21'),
(2, 4, 'C22');

--
-- Dumping data for table `voter`
--

INSERT INTO `voter` (`election_id`, `id`, `name`) VALUES
(1, 1, 'V11'),
(2, 2, 'V21'),
(1, 3, 'V12'),
(1, 4, 'V13'),
(2, 5, 'V22'),
(2, 6, 'V23');

--
-- Dumping data for table `votes`
--

INSERT INTO `votes` (`candidate_id`, `id`, `rank`, `voter_id`) VALUES
(1, 1, 1, 1),
(2, 2, 2, 1),
(1, 3, 1, 3),
(2, 4, 2, 3),
(1, 5, 1, 4),
(2, 6, 2, 4);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
