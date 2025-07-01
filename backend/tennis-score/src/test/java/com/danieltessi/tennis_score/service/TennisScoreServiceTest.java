package com.danieltessi.tennis_score.service;

import com.danieltessi.tennis_score.model.ScoreResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TennisScoreServiceTest {

    private TennisScoreService service;

    @BeforeEach
    void setUp() {
        service = new TennisScoreService();
    }

    @Test
    void testPlayerAWinsDirectly() {
        ScoreResponse response = service.computeScore("AAAA");
        assertEquals("Player A", response.getWinner());
        assertFalse(response.isDeuce());
        assertNull(response.getAdvantagePlayer());
        assertTrue(response.getScoreHistory().getLast().contains("wins"));
    }

    @Test
    void testPlayerBWinsAfterDeuceAndAdvantage() {
        ScoreResponse response = service.computeScore("ABABABBB");
        assertEquals("Player B", response.getWinner());
        assertTrue(response.getScoreHistory().contains("Deuce"));
        assertTrue(response.getScoreHistory().contains("Advantage Player B"));
        assertTrue(response.getScoreHistory().getLast().contains("Player B wins"));
    }

    @Test
    void testDeuceScenario() {
        ScoreResponse response = service.computeScore("ABABAB");
        assertNull(response.getWinner());
        assertTrue(response.isDeuce());
        assertNull(response.getAdvantagePlayer());
        assertEquals("Deuce", response.getScoreHistory().getLast());
    }

    @Test
    void testAdvantageBackToDeuce() {
        String input = "AAABBBAB";
        ScoreResponse response = service.computeScore(input);
        assertNull(response.getWinner());
        assertTrue(response.isDeuce());
        assertNull(response.getAdvantagePlayer());
        assertEquals("Deuce", response.getScoreHistory().getLast());
    }

    @Test
    void testEmptyInput() {
        ScoreResponse response = service.computeScore("");
        System.out.println("Test EmptyInput - ScoreResponse: " + response);
        assertTrue(response.getScoreHistory().isEmpty());
        assertTrue(response.getScores().isEmpty(), "Expected no scores for empty input");
        assertNull(response.getWinner(), "Expected no winner for empty input");
        assertFalse(response.isDeuce(), "Expected not deuce for empty input");
    }

    @Test
    void testLongGameWithManyDeuce() {
        ScoreResponse response = service.computeScore("ABABABABABABABBBAAABBAAA");
        assertNotNull(response.getWinner()); // Someone eventually wins
        assertTrue(response.getScoreHistory().stream().anyMatch(line -> line.contains("Deuce")));
    }

    @Test
    void testInvalidCharactersAreIgnoredOrHandled() {
        ScoreResponse response = service.computeScore("ABXAYBZ"); // includes X, Y, Z
        // Expected to ignore or stop before invalid char depending on your implementation.
        assertNotNull(response.getScoreHistory()); // At least some output
        // Optional: validate input in your service
    }
}
