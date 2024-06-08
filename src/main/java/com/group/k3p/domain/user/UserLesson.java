package com.group.k3p.domain.user;

import com.group.k3p.domain.Lectures.Lesson;
import jakarta.persistence.*;

@Entity
public class UserLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //기본 키

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; //강의를 수강한 사용자와의 관계

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson; //수강한 강의와의 관계

    private boolean completed; //강의 수강 완료 여부
    private boolean passed; //강의 통과 여부

    // 기본 생성자
    public UserLesson() {
    }

    // 사용자 정의 생성자
    public UserLesson(User user, Lesson lesson, boolean completed, boolean passed) {
        this.user = user;
        this.lesson = lesson;
        this.completed = completed;
        this.passed = passed;
    }

    // Getter 및 Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
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

    public Lesson getLesson() {
        return lesson;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isPassed() {
        return passed;
    }
}

