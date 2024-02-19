-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 09:52 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `benegusenga_mbabazi_fidelite_mps`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `account_id` int(11) NOT NULL,
  `account_name` varchar(50) NOT NULL,
  `account_type` varchar(40) DEFAULT NULL,
  `currency` varchar(70) DEFAULT NULL,
  `balance` int(11) NOT NULL,
  `date` date NOT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`account_id`, `account_name`, `account_type`, `currency`, `balance`, `date`, `user_id`) VALUES
(1, 'fixed_account', 'Savings', 'EUR', 5000, '2023-03-08', NULL),
(2, 'Investment Account', 'Investment', 'GBP', 3000, '2023-03-08', NULL),
(3, 'wesdfghj', 'erty', 'erty', 3456, '2001-12-15', 1),
(4, 'asdfgdfgh', 'fgsdf', 'dfgh', 123456, '2001-12-18', 2);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoice_id` int(11) NOT NULL,
  `invoice_name` varchar(60) NOT NULL,
  `invoice_amount` int(11) NOT NULL,
  `due_date` date NOT NULL,
  `account_id` int(11) DEFAULT NULL,
  `transaction_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoice_id`, `invoice_name`, `invoice_amount`, `due_date`, `account_id`, `transaction_id`) VALUES
(1, 'sale_invoice', 1000, '2023-09-15', NULL, NULL),
(2, 'purchase_invoice', 2000, '2023-09-15', NULL, NULL),
(3, 'sale_invoice', 3000, '2023-09-15', NULL, NULL),
(4, 'sdfgh', 34567, '2002-12-12', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `Payment_id` int(11) NOT NULL,
  `payment_name` varchar(40) DEFAULT NULL,
  `date` date NOT NULL,
  `payment_amount` int(11) NOT NULL,
  `receipt` varchar(50) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `transaction_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`Payment_id`, `payment_name`, `date`, `payment_amount`, `receipt`, `user_id`, `transaction_id`) VALUES
(1, 'Payment 2', '2023-03-09', 2000, 'receipt2.pdf', NULL, NULL),
(2, 'Payment 3', '2023-03-10', 3000, 'receipt3.pdf', NULL, NULL),
(3, 'sdfghj', '2000-12-07', 4567, 'receipt3.pdf', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `transaction_currency`
--

CREATE TABLE `transaction_currency` (
  `transaction_id` int(11) NOT NULL,
  `transaction_code` varchar(3) NOT NULL,
  `exchange_rate` decimal(10,2) NOT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction_currency`
--

INSERT INTO `transaction_currency` (`transaction_id`, `transaction_code`, `exchange_rate`, `user_id`) VALUES
(1, 'USD', 1.23, NULL),
(2, 'EUR', 1.34, NULL),
(3, 'GBP', 1.45, NULL),
(4, 'fg', 345.80, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `gender` varchar(11) NOT NULL,
  `user_currency` varchar(70) DEFAULT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `name`, `email`, `address`, `phone_number`, `gender`, `user_currency`, `password`) VALUES
(1, 'audile', 'audile@gmail.com', 'America', '2147483647', 'male', 'USD', ''),
(2, 'Jane ', 'jane@gmail.com', 'France', '109758351', 'female', 'EUR', ''),
(3, 'Smith', 'smith@gmail.com', 'Rwanda', '0785583546', 'male', 'RWF', ''),
(27, 'fifi', 'rwanda', 'fifi@gmail.com', '0784352146', 'female', 'rwf', 'fifififi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`account_id`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoice_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`Payment_id`);

--
-- Indexes for table `transaction_currency`
--
ALTER TABLE `transaction_currency`
  ADD PRIMARY KEY (`transaction_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `account_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `invoice_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `Payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `transaction_currency`
--
ALTER TABLE `transaction_currency`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
