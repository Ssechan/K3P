package com.group.k3p.domain.quiz;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group.k3p.domain.Lectures.Lesson;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Quiz 엔티티의 기본 키입니다.

    private String title; // 퀴즈의 제목을 저장합니다.

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Question> questions; // 퀴즈와 관련된 질문 목록입니다.

    @OneToMany(mappedBy = "quiz")
    private List<Lesson> lessons; // 퀴즈와 관련된 강의 목록입니다.

    // 기본 생성자
    public Quiz() {
    }

    // 사용자 정의 생성자
    public Quiz(String title) {
        this.title = title;
    }

    // Getter 및 Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
