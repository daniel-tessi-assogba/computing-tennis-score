# 🎾 Calculateur de score de tennis

[![Global Project](https://github.com/daniel-tessi-assogba/computing-tennis-score)
[![Bakend Structure](https://github.com/daniel-tessi-assogba/computing-tennis-score/tree/main/backend/README.md)](LICENCE)
[![Frontend Structure](https://github.com/daniel-tessi-assogba/computing-tennis-score/tree/main/frontend/README.md)](LICENSE)  


---

## Description

Cette application permet de calculer et d’afficher le score d’un match de tennis.  
Elle est composée de deux parties :
- Backend en **Spring Boot** (Java)
- Frontend en **React** (TypeScript)

Un fichier **OpenAPI** YAML est aussi disponible pour documenter l’API.

---

## Prérequis

- Java 17 ou supérieur
- Maven
- Node.js (version 18 recommandée)
- npm ou yarn

---

## Installation et lancement

### Backend (Spring Boot)

## ```bash

## cd computing-tennis-score/backend
## mvn spring-boot:run

Le backend sera disponible sur : http://localhost:8080


Frontend (React)
cd computing-tennis-score/frontend/tennis-score-ui
npm install
PORT=3001 npm start

API
POST /api/tennis/score
Corps de la requête :

{
  "sequence": "ABABABB"
}

Réponse :
{
  "winner": "Player B",
  "deuce": true,
  "advantagePlayer": null,
  "scoreHistory": ["Player A scores. Score: 15 - 0", "..."],
  "scores": {
    "playerA": "40",
    "playerB": "Win"
  }
}

Documentation OpenAPI
Le fichier /computing-tennis-score/specificqtions/tennis-score.yaml contient la spécification de l’API.

Conseils
Vérifiez que le backend tourne bien sur le port 8080 et le frontend sur 3001 pour éviter les problèmes CORS.

Adaptez la valeur de @CrossOrigin dans le contrôleur si vous changez les ports.

Contribution
N’hésitez pas à proposer des améliorations via des pull requests !

© 2025 Daniel Tessi ASSOGBA
