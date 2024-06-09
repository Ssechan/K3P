package com.group.k3p.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.group.k3p.domain.Lectures.Lesson;
import jakarta.persistence.*;

@Entity
public class UserLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    @JsonBackReference
    private Lesson lesson;

    private boolean completed;
    private boolean passed;

    // Getters and Setters
    public void setId(Long id) {
        this.id = id;
    }

    public UserLesson() {
    }

    public UserLesson(User user, Lesson lesson, boolean completed, boolean passed) {
        this.user = user;
        this.lesson = lesson;
        this.completed = completed;
        this.passed = passed;
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

