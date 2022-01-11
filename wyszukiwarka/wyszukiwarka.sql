-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 09 Sty 2022, 19:01
-- Wersja serwera: 10.4.22-MariaDB
-- Wersja PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `wyszukiwarka`
--
CREATE DATABASE IF NOT EXISTS `wyszukiwarka` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `wyszukiwarka`;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pociagi`
--

DROP TABLE IF EXISTS `pociagi`;
CREATE TABLE `pociagi` (
  `idPociagu` int(11) NOT NULL,
  `nazwaPociagu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `rozpiska`
--

DROP TABLE IF EXISTS `rozpiska`;
CREATE TABLE `rozpiska` (
  `idPociagu` int(11) NOT NULL,
  `idTrasy` int(11) NOT NULL,
  `dataOdjazdu` datetime NOT NULL,
  `dataPrzyjazdu` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `stacja`
--

DROP TABLE IF EXISTS `stacja`;
CREATE TABLE `stacja` (
  `idStacji` int(11) NOT NULL,
  `nazwaStacji` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `trasa`
--

DROP TABLE IF EXISTS `trasa`;
CREATE TABLE `trasa` (
  `idTrasy` int(11) NOT NULL,
  `nazwaTrasy` varchar(100) NOT NULL,
  `idStacjiPoczatkowej` int(11) NOT NULL,
  `idStacjiKoncowej` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `pociagi`
--
ALTER TABLE `pociagi`
  ADD PRIMARY KEY (`idPociagu`);

--
-- Indeksy dla tabeli `rozpiska`
--
ALTER TABLE `rozpiska`
  ADD KEY `idPociagu` (`idPociagu`,`idTrasy`),
  ADD KEY `idTrasy` (`idTrasy`);

--
-- Indeksy dla tabeli `stacja`
--
ALTER TABLE `stacja`
  ADD PRIMARY KEY (`idStacji`);

--
-- Indeksy dla tabeli `trasa`
--
ALTER TABLE `trasa`
  ADD PRIMARY KEY (`idTrasy`),
  ADD KEY `idStacjiPoczatkowej` (`idStacjiPoczatkowej`),
  ADD KEY `idStacjiKoncowej` (`idStacjiKoncowej`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `pociagi`
--
ALTER TABLE `pociagi`
  MODIFY `idPociagu` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `stacja`
--
ALTER TABLE `stacja`
  MODIFY `idStacji` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `trasa`
--
ALTER TABLE `trasa`
  MODIFY `idTrasy` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `rozpiska`
--
ALTER TABLE `rozpiska`
  ADD CONSTRAINT `rozpiska_ibfk_1` FOREIGN KEY (`idPociagu`) REFERENCES `pociagi` (`idPociagu`),
  ADD CONSTRAINT `rozpiska_ibfk_2` FOREIGN KEY (`idTrasy`) REFERENCES `trasa` (`idTrasy`);

--
-- Ograniczenia dla tabeli `trasa`
--
ALTER TABLE `trasa`
  ADD CONSTRAINT `trasa_ibfk_1` FOREIGN KEY (`idStacjiPoczatkowej`) REFERENCES `stacja` (`idStacji`),
  ADD CONSTRAINT `trasa_ibfk_2` FOREIGN KEY (`idStacjiKoncowej`) REFERENCES `stacja` (`idStacji`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
