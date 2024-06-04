package com.group.k3p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class NavigationController {
    @GetMapping("/ad3")
    public String showAD3() {
        return "AD3";
    }
    @GetMapping("/aidrug")
    public String showAiDrug() {
        return "AIDrug";
    }
    @GetMapping("/cskstudio")
    public String showCSKStudio() {
        return "CSKStudio";
    }
    @GetMapping("/milearn")
    public String showMiLearn() {
        return "MiLearn";
    }

}
