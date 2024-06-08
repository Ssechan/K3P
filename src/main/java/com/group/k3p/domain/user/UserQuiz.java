package com.group.k3p.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.group.k3p.domain.quiz.Quiz;
import jakarta.persistence.*;

//퀴즈 수행기록 저장
@Entity
public class UserQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 기본 키.

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user; // 퀴즈를 수행한 사용자와의 관계.

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz; // 수행한 퀴즈와의 관계.

    private boolean passed; // 퀴즈 통과 여부를 저장.

    // 기본 생성자
    public UserQuiz() {
    }

    // 사용자 정의 생성자
    public UserQuiz(User user, Quiz quiz, boolean passed) {
        this.user = user;
        this.quiz = quiz;
        this.passed = passed;
    }

    // Getter 및 Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
