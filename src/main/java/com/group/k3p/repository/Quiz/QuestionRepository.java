package com.group.k3p.repository.Quiz;

import com.group.k3p.domain.quiz.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
