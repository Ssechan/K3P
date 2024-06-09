package com.group.k3p.repository.user;

import com.group.k3p.domain.quiz.Quiz;
import com.group.k3p.domain.user.User;
import com.group.k3p.domain.user.UserQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserQuizRepository extends JpaRepository<UserQuiz, Long> {
    Optional<UserQuiz> findByUserAndQuiz(User user, Quiz quiz);
    UserQuiz findByUserIdAndQuizId(Long userId, Long quizId);
}
