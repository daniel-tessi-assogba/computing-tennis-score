package com.danieltessi.tennis_score.controller;
import com.danieltessi.tennis_score.model.ScoreRequest;
import com.danieltessi.tennis_score.service.TennisScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.danieltessi.tennis_score.model.ScoreResponse;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/tennis")
public class TennisScoreController {

    private final TennisScoreService tennisScoreService;

    public TennisScoreController(TennisScoreService tennisScoreService) {
        this.tennisScoreService = tennisScoreService;
    }

    @PostMapping("/score")
    public ResponseEntity<ScoreResponse> computeScore(@RequestBody ScoreRequest request) {
        ScoreResponse response = tennisScoreService.computeScore(request.getSequence());
        return ResponseEntity.ok(response);
    }
}


