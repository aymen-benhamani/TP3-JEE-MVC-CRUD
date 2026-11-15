# Réponses aux questions – TP3 JEE

## Question 1 : Pourquoi utiliser forward en cas d'échec et redirect en cas de succès ?

En cas d'échec de connexion, on utilise `forward()` pour retourner à la page de connexion et afficher un message d'erreur.

En cas de succès, on utilise `sendRedirect()` pour envoyer l'utilisateur vers le tableau de bord.

Cela permet de séparer les deux situations et d'éviter de renvoyer le formulaire après une connexion réussie.

## Question 2 : Que se passe-t-il si on actualise une page après un POST ? Comment éviter ce problème ?

Si on actualise une page après une requête POST, le navigateur peut envoyer les mêmes données une deuxième fois.

Par exemple, un produit peut être ajouté plusieurs fois.

Pour éviter ce problème, on utilise le principe PRG (Post/Redirect/Get) :
- POST : envoyer les données du formulaire.
- Redirect : rediriger vers une autre page.
- GET : afficher le résultat.

Ainsi, l'actualisation ne répète pas l'ajout du produit.

## Question 3 : Quel est le risque d'utiliser directement ${produit.nom} dans une JSP ? Comment c:out permet-il de l'éviter ?

L'utilisation directe de `${produit.nom}` peut provoquer une attaque XSS si un utilisateur saisit du code JavaScript dans le nom du produit.

Ce code pourrait être exécuté dans le navigateur d'un autre utilisateur.

Pour éviter cela, on utilise`<c:out>` qui transforme les caractères spéciaux en texte normal.

Cela permet d'afficher le nom du produit sans exécuter un éventuel code HTML ou JavaScript.

## Question 4 : Quel est l'avantage d'un filtre d'authentification ? Citez deux autres utilisations possibles des filtres.

Un filtre d'authentification permet de vérifier si l'utilisateur est connecté avant d'accéder aux pages protégées.

Il évite de répéter le même code de vérification dans plusieurs servlets.

Deux autres utilisations possibles :

1. **Gestion de l'encodage :** configurer l'encodage UTF-8 pour afficher correctement les caractères accentués.
2. **Journalisation :** enregistrer les requêtes des utilisateurs pour suivre l'activité de l'application.