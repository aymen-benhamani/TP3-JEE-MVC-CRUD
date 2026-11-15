# TP3 – Développement Web avec Jakarta EE

## Informations générales

- **Établissement :** ENIAD – Université Mohammed Premier
- **Filière :** Génie Informatique (GINF2)
- **Module :** JEE
- **Encadrante :** Mme Hayat OUADI
- **Année universitaire :** 2026–2027
- **Étudiant :** Aymen BENHAMANI

## Description du projet

Ce projet consiste à développer une application web Java avec Jakarta EE en utilisant l'architecture MVC.

L'application permet de gérer des produits à travers différentes fonctionnalités : authentification, consultation, ajout, modification et suppression.

## Technologies utilisées

- Java 17
- Jakarta EE
- Servlets
- JSP
- JSTL
- Maven
- Apache Tomcat 10.1
- Eclipse IDE

## Fonctionnalités

- Authentification des utilisateurs.
- Gestion des sessions.
- Protection des pages avec un filtre d'authentification.
- Affichage de la liste des produits.
- Ajout d'un produit.
- Modification d'un produit.
- Suppression d'un produit.
- Utilisation de JSP et JSTL pour l'affichage.

## Structure du projet

```text
mon-app_TP3/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/
│       │       ├── model/
│       │       ├── web/
│       │       ├── filter/
│       │       └── listener/
│       ├── resources/
│       └── webapp/
│           └── WEB-INF/
│               └── views/
├── pom.xml
├── README.md
└── REPONSES.md
```

## Installation et exécution

### 1. Prérequis

- JDK 17
- Maven
- Eclipse IDE
- Apache Tomcat 10.1

### 2. Cloner le projet

```bash
git clone https://github.com/aymen-benhamani/TP3-JEE-MVC-CRUD.git
```

### 3. Importer le projet dans Eclipse

- Ouvrir Eclipse.
- Choisir **File → Import**.
- Sélectionner **Existing Maven Projects**.
- Choisir le dossier du projet.
- Cliquer sur **Finish**.

### 4. Exécuter l'application

- Configurer Apache Tomcat 10.1 dans Eclipse.
- Ajouter le projet au serveur Tomcat.
- Démarrer le serveur.

### 5. Accéder à l'application

Ouvrir le navigateur à l'adresse suivante :

**http://localhost:8080/mon-app_TP3/login**

## Réponses aux questions

Les réponses aux questions du TP sont disponibles dans le fichier `REPONSES.md`.

## Auteur

**Aymen BENHAMANI**

ENIAD – GINF2 – Année universitaire 2026–2027