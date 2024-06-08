package com.group.k3p.service.quiz;

import com.group.k3p.domain.Lectures.Lesson;
import com.group.k3p.domain.quiz.Question;
import com.group.k3p.domain.quiz.Quiz;
import com.group.k3p.domain.user.User;
import com.group.k3p.domain.user.UserLesson;
import com.group.k3p.domain.user.UserQuiz;
import com.group.k3p.repository.Quiz.QuestionRepository;
import com.group.k3p.repository.Quiz.QuizRepository;
import com.group.k3p.repository.user.UserLessonRepository;
import com.group.k3p.repository.user.UserQuizRepository;
import com.group.k3p.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class QuizService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserQuizRepository userQuizRepository;

    @Autowired
    private UserLessonRepository userLessonRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuizRepository quizRepository;

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

    @Transactional
    public void processQuizResult(Long userId, Long quizId, int score) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + userId));
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid quiz ID: " + quizId));

        boolean passed = score >= 9;

        UserQuiz userQuiz = userQuizRepository.findByUserAndQuiz(user, quiz)
                .orElse(new UserQuiz(user, quiz, passed));
        userQuiz.setPassed(passed);
        userQuizRepository.save(userQuiz);

        if (passed) {
            for (Lesson lesson : quiz.getLessons()) {
                UserLesson userLesson = userLessonRepository.findByUserAndLesson(user, lesson);
                if (userLesson == null) {
                    userLesson = new UserLesson(user, lesson, false, true);
                } else {
                    userLesson.setPassed(true);
                }
                userLessonRepository.save(userLesson);
            }
        }
    }
}
