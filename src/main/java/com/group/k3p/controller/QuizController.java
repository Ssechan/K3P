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

    @GetMapping("/quiz/{quizId}")
    public Map<String, Object> getQuiz(@PathVariable Long quizId) {
        List<Question> questions = quizService.getRandomQuestionsFromQuiz(quizId, 10);
        return Map.of("questions", questions);
    }

    @PostMapping("/submit")
    public Map<String, Object> submitQuiz(@RequestBody Map<String, String> answers) {
        System.out.println("Received answers: " + answers); // 디버깅용 로그
        Long userId = 1L; // 임시로 userId를 1로 고정
        Long quizId = Long.parseLong(answers.get("quizId")); // 퀴즈 ID를 요청에서 가져오기
        int score = quizService.calculateScore(answers);
        System.out.println("Calculated score: " + score); // 디버깅용 로그
        quizService.processQuizResult(userId, quizId, score);
        return Map.of("score", score);
    }
}