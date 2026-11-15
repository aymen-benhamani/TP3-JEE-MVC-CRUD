# TP 3 – Architecture MVC et Gestion des Produits avec Jakarta EE

## Informations générales

- **Université :** Université Mohammed Premier
- **Établissement :** École Nationale de l'Intelligence Artificielle et du Digital (ENIAD), Berkane
- **Filière :** Génie Informatique (GINF2)
- **Module :** Java Enterprise Edition (JEE)
- **Professeur :** Pr. Hayat OUADI
- **Année universitaire :** 2026–2027
- **Étudiant :** Aymen BENHAMANI

## 1. Présentation du projet

Ce projet consiste à développer une application Web Java avec Jakarta EE en appliquant le modèle architectural MVC (Modèle – Vue – Contrôleur).

L'application permet aux utilisateurs authentifiés de consulter, ajouter, modifier et supprimer des produits à travers une interface Web.

Le projet met en œuvre les Servlets, les JSP, EL, JSTL, les sessions HTTP, les filtres et le pattern DAO.

## 2. Objectifs du TP

- Appliquer l'architecture MVC dans une application Web Java.
- Séparer la logique métier de la présentation.
- Utiliser les JSP avec EL et JSTL.
- Comprendre la différence entre `forward` et `sendRedirect`.
- Implémenter les opérations CRUD.
- Centraliser l'accès aux données avec un DAO.
- Gérer les accès avec un filtre d'authentification.
- Valider les données des formulaires.
- Appliquer le pattern PRG (Post/Redirect/Get).

## 3. Technologies utilisées

| Technologie | Utilisation |
|---|---|
| Java 17 | Langage de programmation |
| Jakarta EE | Développement Web |
| Jakarta Servlet 6.0 | Contrôleurs et filtres |
| JSP | Création des vues |
| JSTL 3.0 | Affichage dynamique |
| Expression Language (EL) | Accès aux données dans les JSP |
| Maven | Gestion des dépendances |
| Apache Tomcat 10.1 | Serveur d'application |
| HTML5 | Interfaces utilisateur |
| Git et GitHub | Gestion du code source |

## 4. Architecture du projet

Le projet suit le modèle MVC :

- **Modèle (Model) :** contient l'entité `Produit` et le `ProduitDAO` responsable de la gestion des données.
- **Vue (View) :** contient les pages JSP permettant d'afficher les données.
- **Contrôleur (Controller) :** contient les Servlets qui reçoivent les requêtes et communiquent avec le modèle.

Un filtre `AuthFilter` assure la protection des pages réservées aux utilisateurs connectés.

Un listener `AppInitListener` initialise le DAO au démarrage de l'application.

## 5. Fonctionnalités réalisées

### 5.1 Authentification
- Connexion utilisateur.
- Vérification des identifiants.
- Gestion des sessions.
- Déconnexion.
- Protection des pages avec `AuthFilter`.

### 5.2 Gestion des produits (CRUD)
- Affichage de la liste des produits.
- Ajout d'un produit.
- Modification d'un produit.
- Suppression d'un produit.
- Validation des champs.
- Affichage des erreurs dans les formulaires.
- Messages flash après les opérations.

### 5.3 Gestion des vues
- Utilisation de JSP.
- Utilisation de JSTL et EL.
- Séparation entre la logique métier et la présentation.
- Protection des JSP dans `WEB-INF/views`.

## 6. Gestion des données

Les produits sont stockés en mémoire dans une structure `ConcurrentHashMap`.

La classe `ProduitDAO` permet de réaliser les opérations suivantes :

- `findAll()` : récupérer tous les produits.
- `findById()` : rechercher un produit par son identifiant.
- `save()` : ajouter ou modifier un produit.
- `delete()` : supprimer un produit.

Une instance unique du DAO est partagée dans le `ServletContext`.

## 7. Installation et exécution

### Prérequis
- JDK 17
- Eclipse IDE
- Maven
- Apache Tomcat 10.1

### Étapes d'exécution

1. Cloner le dépôt GitHub :

```bash
git clone https://github.com/TON-USERNAME/TP3-JEE-MVC-CRUD.git
```

2. Importer le projet dans Eclipse en tant que projet Maven existant.

3. Construire le projet :

```bash
mvn clean package
```

4. Déployer le fichier WAR sur Apache Tomcat 10.1.

5. Démarrer le serveur et accéder à :

```text
http://localhost:8080/mon-app/login
```

### Identifiants de test

| Champ | Valeur |
|---|---|
| Username | admin |
| Password | password |

## 8. Tests

Les tests portent sur :

- L'accès non autorisé aux pages protégées.
- La connexion avec des identifiants incorrects.
- La connexion avec des identifiants corrects.
- L'ajout d'un produit.
- La validation des données.
- La modification d'un produit.
- La suppression d'un produit.
- La gestion des erreurs 404.
- La déconnexion et la protection du Dashboard.

## 9. Auteur

**Aymen BENHAMANI**

GINF2 – ENIAD Berkane

Projet réalisé dans le cadre du module JEE.

**Encadré par : Pr. Hayat OUADI**

Année universitaire 2026–2027.