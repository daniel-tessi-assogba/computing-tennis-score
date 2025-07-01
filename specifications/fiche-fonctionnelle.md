🔧 Nom du projet
Tennis Score Computer

✅ 1. Spécifications fonctionnelles
🎯 Objectif
Simuler et afficher l'évolution du score d'un jeu de tennis simple entre deux joueurs (A et B), à partir d'une chaîne d’entrée contenant la suite des points gagnés.

🧑‍🤝‍🧑 Acteurs
Joueur A

Joueur B

📥 Entrée
Une chaîne de caractères (String) contenant uniquement les caractères A ou B (ex: "ABABAA"), représentant les points gagnés respectivement par le joueur A ou B.

📤 Sortie
Affichage dans la console du score après chaque point.

Affichage du message de victoire lorsqu’un joueur remporte le jeu.

🔁 Règles de gestion
Les scores progressent : 0 → 15 → 30 → 40

Si un joueur a 40 points et gagne un point alors que l’autre a strictement moins de 40, il gagne la partie.

Si les deux joueurs atteignent 40 : c’est le deuce

En situation de deuce :

Le joueur qui gagne un point prend l’avantage

S’il gagne le point suivant, il gagne la partie

Sinon, on revient à deuce

📝 Exemple de sortie
Pour l’entrée "ABABAA", la sortie attendue est :

text
Copier
Modifier
Player A : 15 / Player B : 0  
Player A : 15 / Player B : 15  
Player A : 30 / Player B : 15  
Player A : 30 / Player B : 30  
Player A : 40 / Player B : 30  
Player A wins the game