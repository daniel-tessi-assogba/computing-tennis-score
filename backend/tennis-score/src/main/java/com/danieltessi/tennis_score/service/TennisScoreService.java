package com.danieltessi.tennis_score.service;

import com.danieltessi.tennis_score.model.ScoreResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TennisScoreService {

    public ScoreResponse computeScore(String input) {
        int playerAScore = 0;
        int playerBScore = 0;
        boolean isDeuce = false;
        String advantagePlayer = null;
        String winner = null;

        List<String> scores = new ArrayList<>();
        List<String> scoreHistory = new ArrayList<>();

        for (char c : input.toCharArray()) {
            if (winner != null) break;

            if (c == 'A') {
                if (isDeuce) {
                    if ("A".equals(advantagePlayer)) {
                        winner = "Player A";
                    } else if ("B".equals(advantagePlayer)) {
                        advantagePlayer = null; // Retour à égalité
                    } else {
                        advantagePlayer = "A";
                    }
                } else {
                    playerAScore++;
                }
            } else if (c == 'B') {
                if (isDeuce) {
                    if ("B".equals(advantagePlayer)) {
                        winner = "Player B";
                    } else if ("A".equals(advantagePlayer)) {
                        advantagePlayer = null; // Retour à égalité
                    } else {
                        advantagePlayer = "B";
                    }
                } else {
                    playerBScore++;
                }
            }

            // Vérifie si on passe en deuce
            if (!isDeuce && playerAScore >= 3 && playerBScore >= 3 && playerAScore == playerBScore) {
                isDeuce = true;
            }

            // Vérifie si quelqu’un gagne avant le deuce
            if (!isDeuce && playerAScore >= 4 && playerAScore - playerBScore >= 2) {
                winner = "Player A";
            } else if (!isDeuce && playerBScore >= 4 && playerBScore - playerAScore >= 2) {
                winner = "Player B";
            }

            // Génère le message de score
            String message;
            if (winner != null) {
                message = winner + " wins the game";
            } else if (isDeuce && advantagePlayer == null) {
                message = "Deuce";
            } else if (isDeuce && advantagePlayer != null) {
                message = "Advantage Player " + advantagePlayer;
            } else {
                message = "Player A : " + mapScore(playerAScore) + " / Player B : " + mapScore(playerBScore);
            }

            // Ajoute aux deux listes
            scores.add(message);
            scoreHistory.add(message);
        }

        return new ScoreResponse(scores, winner, isDeuce, advantagePlayer, playerAScore, playerBScore, scoreHistory);
    }

    private String mapScore(int score) {
        return switch (score) {
            case 0 -> "0";
            case 1 -> "15";
            case 2 -> "30";
            case 3 -> "40";
            default -> "40+"; // cas rare
        };
    }
}
