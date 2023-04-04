package com.eric.study.cloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/admin")
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public ResponseEntity admin() {
        System.out.println("admin request come in");
        return ResponseEntity.ok("welcome to soda.com");
    }
}
