-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Generation Time: Aug 13, 2016 at 04:04 PM
-- Server version: 5.5.42
-- PHP Version: 5.6.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `projekatPS`
--

-- --------------------------------------------------------

--
-- Table structure for table `Mesto`
--

CREATE TABLE `Mesto` (
  `MestoID` int(50) NOT NULL,
  `Ptt` varchar(50) CHARACTER SET utf8 NOT NULL,
  `Naziv` varchar(150) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Mesto`
--

INSERT INTO `Mesto` (`MestoID`, `Ptt`, `Naziv`) VALUES
(1, '11000', 'Beograd'),
(2, '21000', 'Novi Sad'),
(3, '14000', 'Valjevo'),
(4, '31000', 'Uzice'),
(5, '37000', 'Krusevac'),
(6, '34000', 'Kragujevac '),
(7, '15300', 'Loznica');

-- --------------------------------------------------------

--
-- Table structure for table `NadleznoLice`
--

CREATE TABLE `NadleznoLice` (
  `nadLiceID` int(50) NOT NULL,
  `ime` varchar(50) CHARACTER SET utf8 NOT NULL,
  `prezime` varchar(50) CHARACTER SET utf8 NOT NULL,
  `korisnickoIme` varchar(50) CHARACTER SET utf8 NOT NULL,
  `korisnickaSifra` varchar(50) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `NadleznoLice`
--

INSERT INTO `NadleznoLice` (`nadLiceID`, `ime`, `prezime`, `korisnickoIme`, `korisnickaSifra`) VALUES
(1, 'Mirko', 'Mirkovic', 'mir91', '123');

-- --------------------------------------------------------

--
-- Table structure for table `Predmet`
--

CREATE TABLE `Predmet` (
  `predmetID` int(50) NOT NULL,
  `NazivPredmeta` varchar(50) NOT NULL,
  `godina` int(50) NOT NULL,
  `smer` varchar(50) NOT NULL,
  `brESPB` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Predmet`
--

INSERT INTO `Predmet` (`predmetID`, `NazivPredmeta`, `godina`, `smer`, `brESPB`) VALUES
(1, 'Matematika 1', 1, 'Oba', 6),
(2, 'OIKT', 1, 'Oba', 5),
(3, 'Ekonomija', 1, 'Oba', 6),
(4, 'Engleski', 1, 'Oba', 4),
(5, 'Menadzment', 1, 'Oba', 5),
(6, 'UIS', 1, 'Oba', 5),
(7, 'Osnovi organizacije', 1, 'Oba', 5),
(8, 'Matematika 2', 1, 'Oba', 6),
(9, 'Proizvodni sistemi', 1, 'Oba', 4),
(10, 'Psihologija', 1, 'Oba', 4),
(11, 'AROS 1', 2, 'ISiT', 8),
(12, 'Principi programiranja', 2, 'ISiT', 10),
(13, 'Strukture podataka i algoritmi', 2, 'ISiT', 10),
(14, 'DMS', 2, 'ISiT', 6),
(15, 'Ekonomika poslovanja', 2, 'Men', 6),
(16, 'Upravljanje troskovima', 2, 'Men', 9),
(17, 'Racunovodstvo', 2, 'Men', 9),
(18, 'Finansije', 2, 'Men', 10),
(19, 'Teorija verovatnoce', 2, 'Oba', 8),
(20, 'Statistika', 2, 'Oba', 8),
(21, 'Racunarske mreze', 3, 'ISiT', 10),
(22, 'Teorija sistema', 3, 'ISiT', 6),
(23, 'Baze podataka', 3, 'ISiT', 9),
(24, 'Programski jezici', 3, 'ISiT', 10),
(25, 'Upravljanje investicijama', 3, 'Men', 10),
(26, 'Poslovno pravo', 3, 'Men', 6),
(27, 'Upravljanje projektima', 3, 'Men', 10),
(28, 'Teorija odlucivanja', 3, 'Men', 9),
(29, 'Elektronsko poslovanje', 3, 'Oba', 9),
(30, 'Menadzment ljudskih resursa', 3, 'Oba', 8),
(31, 'Inteligentni sistemi', 4, 'ISiT', 10),
(32, 'Projektovanje softvera', 4, 'ISiT', 10),
(33, 'Internet tehnologije', 4, 'ISiT', 10),
(34, 'Projektovanje informacionih sistema', 4, 'ISiT', 10),
(35, 'Finansijska trzista', 4, 'Men', 10),
(36, 'Poslovna inteligencija', 4, 'Men', 10),
(37, 'Medjunarodni menadzment', 4, 'Men', 10),
(38, 'Strateski marketing', 4, 'Men', 10),
(39, 'Osnove kvaliteta', 4, 'Oba', 5),
(40, 'Strucna praksa', 4, 'Oba', 5);

-- --------------------------------------------------------

--
-- Table structure for table `Prijava`
--

CREATE TABLE `Prijava` (
  `predmetID` int(50) NOT NULL,
  `ispitID` int(50) NOT NULL,
  `ocena` int(10) NOT NULL,
  `StudentID` int(50) NOT NULL,
  `ispitniRokID` int(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Prijava`
--

INSERT INTO `Prijava` (`predmetID`, `ispitID`, `ocena`, `StudentID`, `ispitniRokID`) VALUES
(2, 46, -5, 1, 4),
(4, 47, -5, 1, 4),
(12, 48, -5, 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `Reprezentacija`
--

CREATE TABLE `Reprezentacija` (
  `id` int(50) NOT NULL,
  `naziv` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Reprezentacija`
--

INSERT INTO `Reprezentacija` (`id`, `naziv`) VALUES
(1, 'Nemacka'),
(2, 'Spanija'),
(3, 'Engleska'),
(4, 'Portugal');

-- --------------------------------------------------------

--
-- Table structure for table `Rok`
--

CREATE TABLE `Rok` (
  `ispitniRokID` int(50) NOT NULL,
  `ispitniRokNaziv` varchar(50) NOT NULL,
  `ispitniRokPeriod` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Rok`
--

INSERT INTO `Rok` (`ispitniRokID`, `ispitniRokNaziv`, `ispitniRokPeriod`) VALUES
(1, 'januar', '01.07.2016.-15.01.2016.'),
(2, 'februar', '01.02.2016.-15.02.2016.'),
(3, 'jun', '01.06.2016.-15.06.2016.'),
(4, 'jul', '01.07.2016.-15.07.2016.'),
(5, 'septembar', '01.09.2016.-15.09.2016.'),
(6, 'oktobar', '01.10.2016.-15.10.2016.');

-- --------------------------------------------------------

--
-- Table structure for table `Student`
--

CREATE TABLE `Student` (
  `StudentID` int(50) NOT NULL,
  `brIndeksa` varchar(50) NOT NULL,
  `Ime` varchar(50) NOT NULL,
  `Prezime` varchar(50) NOT NULL,
  `godina` int(10) NOT NULL,
  `smer` varchar(50) NOT NULL,
  `JMBG` bigint(255) NOT NULL,
  `Kontakt` varchar(50) NOT NULL,
  `Mail` varchar(50) NOT NULL,
  `Ulica` varchar(50) NOT NULL,
  `Broj` varchar(50) NOT NULL,
  `MestoID` int(50) NOT NULL,
  `nadLiceID` int(50) NOT NULL,
  `sifra` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=566 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Student`
--

INSERT INTO `Student` (`StudentID`, `brIndeksa`, `Ime`, `Prezime`, `godina`, `smer`, `JMBG`, `Kontakt`, `Mail`, `Ulica`, `Broj`, `MestoID`, `nadLiceID`, `sifra`) VALUES
(1, '643/12', 'Radomir', 'Popovic', 4, 'isit', 1504993210090, '063/291-491', 'radomir.popovic@ymail.com', 'Marka Markovica', '5a', 1, 1, '2'),
(7, 's', 's', 's', 2, 'isit', 1504993210090, 'sad', 'asd@', 'asd', 'as', 1, 1, '7'),
(12, '1', '1', '1', 1, 'isit', 1504993210091, '1', '1@', '2', '1', 1, 1, '123'),
(565, '455/12', 'Jovana', 'Jovanovic', 4, 'isit', 1404932123321, '063/492-111', 'joca@as', 'Ulica', '2a', 1, 1, '123');

-- --------------------------------------------------------

--
-- Table structure for table `StudentPredmet`
--

CREATE TABLE `StudentPredmet` (
  `idPrijavljenogPredmeta` int(50) NOT NULL,
  `StudentID` int(50) NOT NULL,
  `predmetID` int(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `StudentPredmet`
--

INSERT INTO `StudentPredmet` (`idPrijavljenogPredmeta`, `StudentID`, `predmetID`) VALUES
(2, 1, 2),
(4, 1, 4),
(5, 1, 7),
(6, 1, 1),
(10, 1, 12),
(11, 1, 14),
(12, 1, 5),
(13, 1, 6),
(7, 12, 1),
(8, 12, 5);

-- --------------------------------------------------------

--
-- Table structure for table `Zemlja`
--

CREATE TABLE `Zemlja` (
  `idD` int(15) NOT NULL,
  `naziv` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Zemlja`
--

INSERT INTO `Zemlja` (`idD`, `naziv`) VALUES
(3, 'Bugarska');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Mesto`
--
ALTER TABLE `Mesto`
  ADD PRIMARY KEY (`MestoID`);

--
-- Indexes for table `NadleznoLice`
--
ALTER TABLE `NadleznoLice`
  ADD PRIMARY KEY (`nadLiceID`);

--
-- Indexes for table `Predmet`
--
ALTER TABLE `Predmet`
  ADD PRIMARY KEY (`predmetID`);

--
-- Indexes for table `Prijava`
--
ALTER TABLE `Prijava`
  ADD PRIMARY KEY (`ispitID`,`predmetID`),
  ADD KEY `predmetID` (`predmetID`),
  ADD KEY `StudentID` (`StudentID`),
  ADD KEY `ispitniRokID` (`ispitniRokID`);

--
-- Indexes for table `Reprezentacija`
--
ALTER TABLE `Reprezentacija`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Rok`
--
ALTER TABLE `Rok`
  ADD PRIMARY KEY (`ispitniRokID`);

--
-- Indexes for table `Student`
--
ALTER TABLE `Student`
  ADD PRIMARY KEY (`StudentID`),
  ADD KEY `MestoID` (`MestoID`),
  ADD KEY `nadLiceID` (`nadLiceID`);

--
-- Indexes for table `StudentPredmet`
--
ALTER TABLE `StudentPredmet`
  ADD PRIMARY KEY (`idPrijavljenogPredmeta`,`predmetID`,`StudentID`),
  ADD KEY `StudentID` (`StudentID`),
  ADD KEY `predmetID` (`predmetID`);

--
-- Indexes for table `Zemlja`
--
ALTER TABLE `Zemlja`
  ADD PRIMARY KEY (`idD`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Mesto`
--
ALTER TABLE `Mesto`
  MODIFY `MestoID` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `NadleznoLice`
--
ALTER TABLE `NadleznoLice`
  MODIFY `nadLiceID` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `Prijava`
--
ALTER TABLE `Prijava`
  MODIFY `ispitID` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=49;
--
-- AUTO_INCREMENT for table `Rok`
--
ALTER TABLE `Rok`
  MODIFY `ispitniRokID` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `Student`
--
ALTER TABLE `Student`
  MODIFY `StudentID` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=566;
--
-- AUTO_INCREMENT for table `StudentPredmet`
--
ALTER TABLE `StudentPredmet`
  MODIFY `idPrijavljenogPredmeta` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `Zemlja`
--
ALTER TABLE `Zemlja`
  MODIFY `idD` int(15) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Prijava`
--
ALTER TABLE `Prijava`
  ADD CONSTRAINT `prijava_ibfkk_1` FOREIGN KEY (`predmetID`) REFERENCES `Predmet` (`predmetID`),
  ADD CONSTRAINT `prijava_ibfkk_2` FOREIGN KEY (`StudentID`) REFERENCES `Student` (`StudentID`),
  ADD CONSTRAINT `prijava_ibfk_1` FOREIGN KEY (`ispitniRokID`) REFERENCES `Rok` (`ispitniRokID`);

--
-- Constraints for table `Student`
--
ALTER TABLE `Student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`MestoID`) REFERENCES `Mesto` (`MestoID`),
  ADD CONSTRAINT `student_ibfk_2` FOREIGN KEY (`nadLiceID`) REFERENCES `NadleznoLice` (`nadLiceID`);

--
-- Constraints for table `StudentPredmet`
--
ALTER TABLE `StudentPredmet`
  ADD CONSTRAINT `studentpredmet_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `Student` (`StudentID`),
  ADD CONSTRAINT `studentpredmet_ibfk_2` FOREIGN KEY (`predmetID`) REFERENCES `Predmet` (`predmetID`);
