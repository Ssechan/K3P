package com.group.k3p.controller;

import com.group.k3p.domain.quiz.Question;
import com.group.k3p.service.quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping("/quiz")
    public Map<String, Object> getQuiz() {
        List<Question> questions = quizService.getRandomQuestions(10);
        return Map.of("questions", questions);
    }

    @PostMapping("/submit")
    public Map<String, Object> submitQuiz(@RequestBody Map<String, String> answers) {
        int score = quizService.calculateScore(answers);
        return Map.of("score", score);
    }
}
