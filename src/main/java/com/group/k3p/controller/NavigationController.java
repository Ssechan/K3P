package com.group.k3p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class NavigationController {
    @GetMapping("/test_1")
    public String redirectToQuiz1(Model model) {
        model.addAttribute("quizId", 1);
        return "quiz";
    }

    @GetMapping("/test_2")
    public String redirectToQuiz2(Model model) {
        model.addAttribute("quizId", 2);
        return "quiz";
    }

    @GetMapping("/test_3")
    public String redirectToQuiz3(Model model) {
        model.addAttribute("quizId", 3);
        return "quiz";
    }

    @GetMapping("/test_4")
    public String redirectToQuiz4(Model model) {
        model.addAttribute("quizId", 4);
        return "quiz";
    }

    @GetMapping("/test_5")
    public String redirectToQuiz5(Model model) {
        model.addAttribute("quizId", 5);
        return "quiz";
    }
}