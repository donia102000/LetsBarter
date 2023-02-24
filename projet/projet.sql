-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 24 fév. 2023 à 01:46
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
-- Structure de la table `annonce`
--

CREATE TABLE `annonce` (
  `id` int(11) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `categorie` varchar(50) NOT NULL,
  `souscategorie` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `valeurobjet` varchar(50) NOT NULL,
  `image` varchar(50) NOT NULL,
  `video` varchar(50) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `tel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `annonce`
--

INSERT INTO `annonce` (`id`, `titre`, `categorie`, `souscategorie`, `description`, `valeurobjet`, `image`, `video`, `adresse`, `tel`) VALUES
(22, 'mixeur', 'electromenager', 'electromenager', 'en bon etat', '80dt', 'Image', 'video', 'ariana', 53655881),
(23, 'troc de voiture', 'vehicule', 'voiture', 'en bon etat', '100dt', 'Image', 'video', 'bizerte', 22500158),
(24, 'troc pull', 'vetement', 'pull', 'en bon etat', '10dt', 'Image', 'video', 'ariana', 25639852);

-- --------------------------------------------------------

--
-- Structure de la table `offre`
--

CREATE TABLE `offre` (
  `idOffre` int(11) NOT NULL,
  `refUtilisateur` int(11) NOT NULL,
  `idAnnonce` int(11) NOT NULL,
  `dateDebut` varchar(255) NOT NULL,
  `dateFin` varchar(255) NOT NULL,
  `pourcentage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `offre`
--

INSERT INTO `offre` (`idOffre`, `refUtilisateur`, `idAnnonce`, `dateDebut`, `dateFin`, `pourcentage`) VALUES
(5, 22, 22, '30/12/20444', '25/10/2023', 28),
(6, 24, 22, '21/04/2020', '25/10/2023', 28);

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
(19, 'soni', 'dbdbb', 'ssssssss', 'sss', 'Femme', 'Date de Naissance', 45878, 'nnn', 'organisateur', 0, 0),
(20, 'tayssir', 'gggg', 'njndj', 'dhhd', 'Homme', '02/02/2023', 45878, 'gggg', 'admin', 0, 0),
(21, 'hhhhh', 'fffff', 'gggg', 'hhhhhhhh', 'Femme', '01/02/2023', 45878, 'jjjjj', 'client', 0, 0),
(22, 'siwar', 'hzhz', 'xxx@gmail.com', 'xxx', 'Femme', '07/02/2018', 45878, 'tunis', 'client', 0, 0),
(23, 'donia', 'ffqf', 'jjjj', 'ajqj', 'Femme', '10/02/2023', 45878, 'jjjj', 'client', 0, 0),
(24, 'donia', 'ben', 'xxxx@gmail.com', 'xxx', 'Femme', '09/02/2023', 124578, 'ffsfsz', 'admin', 124578, 1),
(26, 'fathiza', 'prenomUtilisateur', 'fathiza@gamil.com', 'Fathiza2154', 'genre', 'dateDeNaissance', 0, 'adresse', 'admin', 0, 124789),
(27, 'amal', 'prenomUtilisateur', 'email', 'motDePasse', 'genre', 'dateDeNaissance', 0, 'adresse', 'organisateur', 0, 124789),
(31, 'donia', 'ben', 'donia@gmail.com', 'Donito2000', 'Femme', '02/02/2023', 12457896, 'tunis', 'client', 12457896, 0),
(32, 'mouna', 'hhh', 'mouna@gmail.com', 'Mouna1245', 'Femme', '02/02/2023', 12459631, 'bizerte', 'admin', 12457896, 0),
(33, 'mayssa', 'hhh', 'mayssa@gamil.com', 'mayssaD1254', 'Femme', '01/02/2023', 12547896, 'hhhhh', 'client', 0, 0),
(34, 'donia', 'jjj', 'gggg@gmail.sb', 'Sdftt1254', 'Femme', '03/02/2023', 12457896, 'ggggg', 'client', 0, 78459627),
(35, 'doniaa', 'ggggggg', 'gggg@gmail.sb', 'gggRnn155', 'Femme', '01/02/2023', 45789612, 'dgggg', 'client', 0, 78459628),
(38, 'tassnim', 'ayari', 'tassnim23@gmail.tn', 'Aze3?********', 'Autre', '24/02/2023', 12345678, 'citeenchirah', 'organisateur', 0, 23445678),
(40, 'michel', 'assil', 'xxxx@hhhh.com', 'Xeee1258uu', 'Femme', '31/01/2023', 78451296, 'ffffff', 'organisateur', 0, 12457878),
(42, 'Abir', 'abir', 'abir@gmail.com', 'Abir1458', 'Femme', '01/02/2023', 12457896, 'tunis', 'client', 0, 12458789),
(43, 'salmen', 'benahmed', 'salmen@gmail.com', 'Aslthn123', 'Homme', '01/02/1920', 45768456, 'azetetetetddfdf', 'client', 0, 98765655),
(45, 'donia', 'ben', 'doni@gmail.tn', 'Doni1245', 'Femme', '01/02/2000', 78451296, 'bizerte', 'client', 0, 12457896);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `offre`
--
ALTER TABLE `offre`
  ADD PRIMARY KEY (`idOffre`),
  ADD KEY `refUtilisateur` (`refUtilisateur`),
  ADD KEY `idAnnonce` (`idAnnonce`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `annonce`
--
ALTER TABLE `annonce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT pour la table `offre`
--
ALTER TABLE `offre`
  MODIFY `idOffre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `offre`
--
ALTER TABLE `offre`
  ADD CONSTRAINT `refAnnonceOffre` FOREIGN KEY (`idAnnonce`) REFERENCES `annonce` (`id`),
  ADD CONSTRAINT `refUtilisateurOffre` FOREIGN KEY (`refUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
