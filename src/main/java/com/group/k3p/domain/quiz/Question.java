package com.group.k3p.domain.quiz;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.group.k3p.controller.StringListConverter;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String question;

    @Convert(converter = StringListConverter.class)
    private List<String> options;

    private String correctAnswer;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    @JsonBackReference
    private Quiz quiz;

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
