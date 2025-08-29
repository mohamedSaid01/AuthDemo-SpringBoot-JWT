# AuthDemo

![Java](https://img.shields.io/badge/Java-17+-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-green)
![MySQL](https://img.shields.io/badge/MySQL-8.0+-orange)
![License](https://img.shields.io/badge/License-MIT-red)

**AuthDemo** est une application backend développée avec **Spring Boot 3.5.5** qui fournit un système d'authentification et d'autorisation basé sur **JWT** (JSON Web Token) avec gestion des cookies. L'application utilise une base de données **MySQL** pour stocker les utilisateurs et implémente une gestion des rôles pour contrôler l'accès aux différents endpoints.

---

## Fonctionnalités

- **Inscription des utilisateurs** : Permet aux utilisateurs de s'inscrire avec un nom d'utilisateur, un email, un mot de passe et un rôle (`SIMPLE_USER` ou `ADMIN`).  
- **Connexion des utilisateurs** : Authentifie les utilisateurs avec leurs identifiants et génère un token JWT, stocké dans un cookie sécurisé (`jwtToken`).  
- **Déconnexion** : Supprime le cookie `jwtToken` pour déconnecter l'utilisateur.  
- **Récupération de l'utilisateur connecté** : Permet à un utilisateur authentifié de récupérer ses informations (`ID`, `username`, `email`, `role`).  
- **Gestion des rôles** :
  - `SIMPLE_USER` : accès à `/signup`, `/signin`, `/logout`, et `/getCurrentUser`.  
  - `ADMIN` : accès à `/signup`, `/signin`, `/logout` uniquement (`/getCurrentUser` interdit).

---

## Sécurité

- Authentification via **JWT**.  
- Stockage des tokens dans des cookies **HttpOnly** pour se protéger contre les attaques XSS.  
- Hachage des mots de passe avec **BCrypt**.  
- Désactivation du CSRF et gestion **stateless** des sessions via Spring Security.

---

## Prérequis

- Java 17 ou supérieur  
- Maven 3.8.6 ou supérieur  
- MySQL 8.0 ou supérieur  
- Postman (ou cURL) pour tester les endpoints  
- IDE (IntelliJ IDEA, Eclipse, VS Code)

---

## Installation

### 1. Cloner le dépôt

```bash
git clone https://github.com/mohamedSaid01/AuthDemo-SpringBoot-JWT.git
cd authdemo
