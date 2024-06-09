package com.group.k3p.controller;

import com.group.k3p.domain.Lectures.Lesson;
import com.group.k3p.repository.Lectures.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LessonController {

    @Autowired
    private LessonRepository lessonRepository;

    @GetMapping("/lessons")
    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = lessonRepository.findAll();
        lessons.forEach(lesson -> System.out.println(lesson));
        return lessons;
    }
}