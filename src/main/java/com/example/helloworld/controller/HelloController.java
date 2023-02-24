package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
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
        int hour = now.getHour();
        int minutes = now.getMinute();
        int sec = now.getSecond();
        return hour + "時" + minutes + "分" + sec + "秒";
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
