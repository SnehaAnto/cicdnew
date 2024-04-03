package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DoubleNumController {
    @GetMapping("/double")
    public int doubleNum(@RequestParam(value = "value", defaultValue = "5") int value) {

        return value * 2;
    }
}