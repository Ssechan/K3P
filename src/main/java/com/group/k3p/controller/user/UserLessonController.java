package com.group.k3p.controller.user;

import com.group.k3p.domain.Lectures.LessonRequest;
import com.group.k3p.service.user.UserLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserLessonController {

    @Autowired
    private UserLessonService userLessonService;

    @GetMapping("/checkLessonCompleted/{lessonId}")
    public ResponseEntity<Map<String, Object>> checkLessonCompleted(@PathVariable Long lessonId) {
        Long userId = 1L; // 임시로 userId를 1로 고정
        boolean completed = userLessonService.isLessonCompleted(userId, lessonId);
        List<Long> completedLessons = userLessonService.getCompletedLessons(userId);
        Map<String, Object> response = new HashMap<>();
        response.put("completed", completed);
        response.put("completedLessons", completedLessons);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/completeLesson")
    public ResponseEntity<Map<String, Object>> completeLesson(@RequestBody LessonRequest lessonRequest) {
        Long userId = 1L; // 임시로 userId를 1로 고정
        boolean completed = userLessonService.completeLesson(userId, lessonRequest.getLessonId());
        Map<String, Object> response = new HashMap<>();
        response.put("completed", completed);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/completedLessons")
    public Map<String, List<Long>> getCompletedLessons() {
        Long userId = 1L; // 임시로 userId를 1로 고정
        return userLessonService.getCompletedAndPassedLessons(userId);
    }
}