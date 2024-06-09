package com.group.k3p.controller.user;

import com.group.k3p.service.user.UserQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserQuizController {

    @Autowired
    private UserQuizService userQuizService;

    @GetMapping("/allQuizzesPassed/{userId}")
    public boolean allQuizzesPassed(@PathVariable Long userId) {
        return userQuizService.allQuizzesPassed(userId);
    }

    @GetMapping("/quizPassed/{quizId}/{userId}")
    public boolean isQuizPassed(@PathVariable Long quizId, @PathVariable Long userId) {
        return userQuizService.isQuizPassed(userId, quizId);
    }
}
