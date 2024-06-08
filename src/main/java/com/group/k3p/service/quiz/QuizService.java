package com.group.k3p.service.quiz;

import com.group.k3p.domain.quiz.Question;
import com.group.k3p.repository.Quiz.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class QuizService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getRandomQuestions(int numQuestions) {
        List<Question> allQuestions = questionRepository.findAll();
        Collections.shuffle(allQuestions);
        return allQuestions.subList(0, Math.min(numQuestions, allQuestions.size()));
    }

    public int calculateScore(Map<String, String> answers) {
        int score = 0;
        for (String key : answers.keySet()) {
            if (key.startsWith("answer")) {
                int index = Integer.parseInt(key.substring(6));
                int questionId = Integer.parseInt(answers.get("questionId" + index));
                String givenAnswer = answers.get(key);
                Question question = questionRepository.findById(questionId).orElse(null);
                if (question != null && question.getCorrectAnswer().equals(givenAnswer)) {
                    score++;
                }
            }
        }
        return score;
    }
}
