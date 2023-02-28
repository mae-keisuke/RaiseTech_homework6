package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
public class HelloController {
    private static final Map<String, String> COUNTRY_TO_LANGUAGE =
        Map.of("Japan", "こんにちは", "America", "Hello！",
            "France", "Bonjour！", "Italy", "Ciao！");
    private static final DateTimeFormatter dateTimeFormatter =
        DateTimeFormatter.ofPattern("HH時mm分ss秒");

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/now")
    public String time() {
        LocalDateTime now = LocalDateTime.now();
        return dateTimeFormatter.format(now);
    }

    @GetMapping("/greeting")
    public String country(@RequestParam("country") String country) {
        if (COUNTRY_TO_LANGUAGE.containsKey(country)) {
            return COUNTRY_TO_LANGUAGE.get(country);
        } else {
            return "リストにありません。再検索してください。";
        }
    }
}
