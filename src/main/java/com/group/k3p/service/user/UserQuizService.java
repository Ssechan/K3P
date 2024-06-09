package com.group.k3p.service.user;

import com.group.k3p.domain.quiz.Quiz;
import com.group.k3p.domain.user.UserQuiz;
import com.group.k3p.repository.Quiz.QuizRepository;
import com.group.k3p.repository.user.UserQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQuizService {

    @Autowired
    private UserQuizRepository userQuizRepository;

    @Autowired
    private QuizRepository quizRepository;

    public boolean allQuizzesPassed(Long userId) {
        List<Quiz> allQuizzes = quizRepository.findAll();
        for (Quiz quiz : allQuizzes) {
            UserQuiz userQuiz = userQuizRepository.findByUserIdAndQuizId(userId, quiz.getId());
            if (userQuiz == null || !userQuiz.isPassed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isQuizPassed(Long userId, Long quizId) {
        UserQuiz userQuiz = userQuizRepository.findByUserIdAndQuizId(userId, quizId);
        return userQuiz != null && userQuiz.isPassed();
    }
}