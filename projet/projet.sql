-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 21 fév. 2023 à 00:06
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idUtilisateur` int(11) NOT NULL,
  `nomUtilisateur` varchar(255) NOT NULL,
  `prenomUtilisateur` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `motDePasse` varchar(255) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `dateDeNaissance` varchar(255) NOT NULL,
  `numTelephone` int(11) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `nbPoint` int(11) NOT NULL,
  `cin` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `nomUtilisateur`, `prenomUtilisateur`, `email`, `motDePasse`, `genre`, `dateDeNaissance`, `numTelephone`, `adresse`, `role`, `nbPoint`, `cin`) VALUES
(19, 'soni', 'dbdbb', 'ssssssss', 'sss', 'Femme', 'Date de Naissance', 45878, 'nnn', 'client', 0, 0),
(20, 'tayssir', 'gggg', 'njndj', 'dhhd', 'Homme', '02/02/2023', 45878, 'gggg', 'admin', 0, 0),
(21, 'hhhhh', 'fffff', 'gggg', 'hhhhhhhh', 'Femme', '01/02/2023', 45878, 'jjjjj', 'client', 0, 0),
(22, 'siwar', 'hzhz', 'xxx@gmail.com', 'xxx', 'Femme', '07/02/2018', 45878, 'tunis', 'client', 0, 0),
(23, 'donia', 'ffqf', 'jjjj', 'ajqj', 'Femme', '10/02/2023', 45878, 'jjjj', 'client', 0, 0),
(24, 'donia', 'ben', 'xxx@gmail.com', 'xxx', 'Femme', '09/02/2023', 124578, 'ffsfsz', 'client', 124578, 0);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
