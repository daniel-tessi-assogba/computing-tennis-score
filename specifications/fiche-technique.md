🛠️ Technologies
Langage : Java (Java 17+ recommandé)

Type d’application : Application console simple (sans interface graphique)

Structure du projet : un seul fichier TennisGame.java peut suffire pour le MVP

📂 Structure minimale du code

public class TennisGame {
public static void main(String[] args) {
String input = "ABABAA";
playGame(input);
}

    public static void playGame(String sequence) {
        // Implémentation ici
    }
}
🔢 Modélisation du score
Utiliser une méthode de conversion des points :
Exemple : 0, 1, 2, 3 correspondant respectivement à 0, 15, 30, 40

Statut du match :

Normal

Deuce

Advantage A / B

Game Over

🧪 Tests à prévoir
Cas normal sans deuce (ex: "AAAA" ou "BBBB")

Cas avec deuce puis victoire (ex: "ABABABAA")

Cas où le joueur perd l’avantage et on revient à deuce (ex: "ABABABAABB")

Cas où un seul joueur marque tous les points

🧠 Cas limites à prévoir
Entrée vide ⇒ Aucun affichage

Caractères invalides ⇒ À ignorer ou lever une exception (selon le besoin)

Score déjà terminé mais des caractères supplémentaires ⇒ À ignorer après la fin