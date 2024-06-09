package com.group.k3p.domain.Lectures;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String level; // 초급, 중급, 고급

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Lesson> lessons;

    // 기본 생성자
    public Course() {
    }

    // 사용자 정의 생성자, Getter 및 Setter 생략
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}