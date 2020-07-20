package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Paths {

    @GetMapping("/")
    public String helloWord(){
        return "Hello from Spring!";
    }
}
