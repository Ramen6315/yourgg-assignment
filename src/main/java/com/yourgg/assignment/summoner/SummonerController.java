package com.yourgg.assignment.summoner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SummonerController {
    @GetMapping("/")
    public String test() {
        return "index.html";
    }
}
