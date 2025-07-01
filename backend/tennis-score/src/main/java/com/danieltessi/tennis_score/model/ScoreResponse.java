package com.danieltessi.tennis_score.model;

import java.util.List;

public class ScoreResponse {
    private List<String> scores;          // Score affiché à chaque point
    private String winner;                // Gagnant (ou null)
    private boolean deuce;                // Est-ce que la partie est à égalité ?
    private String advantagePlayer;       // Joueur ayant l'avantage ("A", "B", ou null)
    private int playerAPoints;            // Points bruts (0 à 4+)
    private int playerBPoints;
    private List<String> scoreHistory;    // Idem

    public ScoreResponse(List<String> scores, String winner,
                         boolean deuce, String advantagePlayer,
                         int playerAPoints, int playerBPoints, List<String> scoreHistory) {
        this.scores = scores;
        this.winner = winner;
        this.deuce = deuce;
        this.advantagePlayer = advantagePlayer;
        this.playerAPoints = playerAPoints;
        this.playerBPoints = playerBPoints;
        this.scoreHistory = scoreHistory;
    }

    public List<String> getScores() {
        return scores;
    }

    public void setScores(List<String> scores) {
        this.scores = scores;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public boolean isDeuce() {
        return deuce;
    }

    public void setDeuce(boolean deuce) {
        this.deuce = deuce;
    }

    public String getAdvantagePlayer() {
        return advantagePlayer;
    }

    public void setAdvantagePlayer(String advantagePlayer) {
        this.advantagePlayer = advantagePlayer;
    }

    public int getPlayerAPoints() {
        return playerAPoints;
    }

    public void setPlayerAPoints(int playerAPoints) {
        this.playerAPoints = playerAPoints;
    }

    public int getPlayerBPoints() {
        return playerBPoints;
    }

    public void setPlayerBPoints(int playerBPoints) {
        this.playerBPoints = playerBPoints;
    }

    public List<String> getScoreHistory() {
        return scoreHistory;
    }

    public void setScoreHistory(List<String> scoreHistory) {
        this.scoreHistory = scoreHistory;
    }
}

