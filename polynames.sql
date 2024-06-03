-- Création de la base de données --
CREATE DATABASE Polynames;

USE Polynames;

-- Définition des tables de la base de données --
CREATE TABLE `jeu`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `code` VARCHAR(50) NOT NULL,
    `score` INT NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `carte`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `etat` VARCHAR(20) NOT NULL,
    `position` INT NOT NULL,
    `idCouleur` INT NOT NULL,
    `idMot` INT NOT NULL,
    PRIMARY KEY (`id`)
)

CREATE TABLE `couleur`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `nom` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`id`)
)

CREATE TABLE `mot`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `nom` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`id`)
)

CREATE TABLE `joueur`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `pseudo` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`id`)
)

-- Gestion des clés étrangères --
ALTER TABLE `carte`
ADD CONSTRAINT `FK_carte_couleur`
FOREIGN KEY (`idCouleur`)
REFERENCES `couleur` (`id`)
ON UPDATE NO ACTION
ON DELETE NO ACTION;

ALTER TABLE `carte`
ADD CONSTRAINT `FK_carte_mot`
FOREIGN KEY (`idMot`)
REFERENCES `mot` (`id`)
ON UPDATE NO ACTION
ON DELETE NO ACTION;


-- Insertion des données dans les différentes tables --

INSERT INTO `couleur` (nom) VALUES ('Bleu'), ('Gris'), ('Noir'); 

INSERT INTO `mot` (`nom`) VALUES ('Afrique'), ('Aiguille'), ('Aile'), ('Air'), ('Alien'), ('Allemagne'), ('Alpes'), ('Amour'), 
('Ampoule'), ('Amérique'), ('Ange'), ('Angleterre'), ('Anneau'), ('Appareil'), ('Araignée'), ('Arc'), ('Argent'), ('Asile'), ('Astérix'), 
('Atlantique'), ('Atout'), ('Australie'), ('Avion'), ('Avocat'), ('Baguette'), ('Baie'), ('Balance'), ('Baleine'), ('Balle'), ('Ballon'), 
('Banane'), ('Banc'), ('Bande'), ('Banque'), ('Bar'), ('Barbe'), ('Base'), ('Bateau'), ('Berlin'), ('Bière'), ('Blé'), ('Bombe'), 
('Bon'), ('Botte'), ('Bouche'), ('Bouchon'), ('Bougie'), ('Boulet'), ('Bourse'), ('Bouteille'), ('Bouton'), ('Boîte'), ('Branche'), 
('Bretelle'), ('Brique'), ('Bureau'), ('But'), ('Bâton'), ('Bête'), ('Bûche'), ('Bœuf'), ('Cabinet'), ('Cadre'), ('Cafard'), ('Café'), 
('Camembert'), ('Campagne'), ('Canada'), ('Canard'), ('Canne'), ('Canon'), ('Carreau'), ('Carrière'), ('Carte'), ('Carton'), 
('Cartouche'), ('Casino'), ('Ceinture'), ('Cellule'), ('Centre'), ('Cercle'), ('Champ'), ('Champagne'), ('Chance'), ('Chapeau'), 
('Charge'), ('Charme'), ('Chasse'), ('Chat'), ('Chausson'), ('Chaîne'), ('Chef'), ('Chemise'), ('Cheval'), ('Chevalier'), ('Chien'), 
('Chine'), ('Chocolat'), ('Chou'), ('Château'), ('Cinéma'), ('Cirque'), ('Citrouille'), ('Classe'), ('Club'), ('Clé'), ('Cochon'), 
('Code'), ('Col'), ('Colle'), ('Commerce'), ('Coq'), ('Corde'), ('Corne'), ('Coton'), ('Coupe'), ('Courant'), ('Couronne'), ('Course'), 
('Court'), ('Couteau'), ('Couverture'), ('Critique'), ('Crochet'), ('Cuisine'), ('Cycle'), ('Cœur'), ('Danse'), ('Dinosaure'), 
('Docteur'), ('Don'), ('Dragon'), ('Droit'), ('Droite'), ('Eau'), ('Enceinte'), ('Ensemble'), ('Entrée'), ('Espace'), ('Espagne'), 
('Espion'), ('Esprit'), ('Essence'), ('Europe'), ('Facteur'), ('Fantôme'), ('Farce'), ('Fer'), ('Ferme'), ('Feu'), ('Feuille'), 
('Figure'), ('Filet'), ('Fin'), ('Flûte'), ('Formule'), ('Fort'), ('Forêt'), ('Fou'), ('Foyer'), ('Fraise'), ('Français'), ('Front'), 
('Fuite'), ('Garde'), ('Gauche'), ('Gel'), ('Glace'), ('Gorge'), ('Grain'), ('Grenade'), ('Grue'), ('Grèce'), ('Guerre'), ('Guide'), 
('Géant'), ('Génie'), ('Herbe'), ('Himalaya'), ('Histoire'), ('Hiver'), ('Hollywood'), ('Héros'), ('Hôpital'), ('Hôtel'), ('Indien'), 
('Iris'), ('Jet'), ('Jeu'), ('Jour'), ('Journal'), ('Jumelles'), ('Jungle'), ('Kangourou'), ('Kiwi'), ('Lait'), ('Langue'), ('Laser'), 
('Lentille'), ('Lettre'), ('Licorne'), ('Lien'), ('Ligne'), ('Lion'), ('Liquide'), ('Lit'), ('Livre'), ('Londres'), ('Louche'), 
('Lumière'), ('Lune'), ('Lunettes'), ('Luxe'), ('Machine'), ('Magie'), ('Main'), ('Majeur'), ('Maladie'), ('Manche'), ('Manège'), 
('Marche'), ('Marin'), ('Marque'), ('Marron'), ('Mars'), ('Maîtresse'), ('Membre'), ('Menu'), ('Meuble'), ('Microscope'), ('Miel'), 
('Millionaire'), ('Mine'), ('Mineur'), ('Mode'), ('Molière'), ('Mort'), ('Mouche'), ('Moule'), ('Mousse'), ('Moustache'), ('Mémoire'), 
('Nain'), ('Napoléon'), ('Neige'), ('New-York'), ('Ninja'), ('Noir'), ('Note'), ('Noël'), ('Nuit'), ('Numéro'), ('Nœud'), ('Oiseau'), 
('Opéra'), ('Opération'), ('Or'), ('Orange'), ('Ordre'), ('Page'), ('Paille'), ('Palais'), ('Palme'), ('Papier'), ('Parachute'), 
('Paris'), ('Partie'), ('Passe'), ('Patron'), ('Pendule'), ('Pensée'), ('Perle'), ('Peste'), ('Phare'), ('Physique'), ('Piano'), 
('Pied'), ('Pigeon'), ('Pile'), ('Pilote'), ('Pingouin'), ('Pirate'), ('Pièce'), ('Place'), ('Plage'), ('Plan'), ('Planche'), 
('Plante'), ('Plat'), ('Plateau'), ('Plume'), ('Point'), ('Poire'), ('Poison'), ('Poisson'), ('Police'), ('Pomme'), ('Pompe'), 
('Portable'), ('Poste'), ('Pouce'), ('Poêle'), ('Princesse'), ('Prise'), ('Prêt'), ('Pyramide'), ('Pétrole'), ('Pêche'), ('Pôle'), 
('Quartier'), ('Queue'), ('Radio'), ('Raie'), ('Rame'), ('Rat'), ('Rayon'), ('Recette'), ('Reine'), ('Religieuse'), ('Remise'), 
('Requin'), ('Restaurant'), ('Robe'), ('Robot'), ('Roi'), ('Rome'), ('Ronde'), ('Rose'), ('Rouge'), ('Rouleau'), ('Roulette'), 
('Russie'), ('Règle'), ('Résistance'), ('Révolution'), ('Sardine'), ('Satellite'), ('Schtroumpf'), ('Science'), ('Scène'), ('Sens'), 
('Sept'), ('Serpent'), ('Sirène'), ('Siège'), ('Sol'), ('Soldat'), ('Soleil'), ('Solution'), ('Somme'), ('Sorcière'), ('Sortie'), 
('Souris'), ('Table'), ('Tableau'), ('Talon'), ('Tambour'), ('Temple'), ('Temps'), ('Tennis'), ('Terre'), ('Timbre'), ('Titre'), 
('Toile'), ('Tokyo'), ('Tour'), ('Trait'), ('Trou'), ('Trésor'), ('Tube'), ('Tuile'), ('Tête'), ('Uniforme'), ('Vague'), ('Vaisseau'), 
('Vampire'), ('Vase'), ('Vent'), ('Verre'), ('Vert'), ('Vie'), ('Vin'), ('Visage'), ('Vision'), ('Voile'), ('Voiture'), ('Vol'), 
('Voleur'), ('Volume'), ('Zéro'), ('Échelle'), ('Éclair'), ('École'), ('Égalité'), ('Égypte'), ('Éponge'), ('Étoile'), ('Étude'), 
('Œil'), ('Œuf');