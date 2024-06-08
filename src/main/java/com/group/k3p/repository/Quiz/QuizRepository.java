package com.group.k3p.repository.Quiz;

import com.group.k3p.domain.quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}