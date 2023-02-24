package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/now")
    public String time() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter nowFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        return nowFormat.format(now);
    }

    @GetMapping("/greeting")
    public String country(@RequestParam("country") String country) {
        Map<String, String> countryLanguage = new HashMap<>();
        countryLanguage.put("Japan", "こんにちは！");
        countryLanguage.put("America", "Hello！");
        countryLanguage.put("France", "Bonjour！");
        countryLanguage.put("Italy", "Ciao！");

        if (countryLanguage.get(country) == null) {
            return "リストにありません。再検索してください。";
        } else {
            return countryLanguage.get(country);
        }
    }
}
