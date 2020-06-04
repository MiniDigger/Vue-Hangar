package me.minidigger.hangar.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @GetMapping("/")
    public String test() {
        return "Hello " + SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
