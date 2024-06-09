package com.group.k3p.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.group.k3p.domain.quiz.Quiz;
import jakarta.persistence.*;

//퀴즈 수행기록 저장
@Entity
public class UserQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    @JsonBackReference
    private Quiz quiz;

    public UserQuiz() {
    }

    public UserQuiz(User user, Quiz quiz, boolean passed) {
        this.user = user;
        this.quiz = quiz;
        this.passed = passed;
    }

    private boolean passed;

    // Getters and Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public boolean isPassed() {
        return passed;
    }
}
