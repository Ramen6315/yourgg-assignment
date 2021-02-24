package com.yourgg.assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yourgg.assignment.service.SummonerService;
import com.yourgg.assignment.service.dto.UserDto;

@RestController
public class SummonerController {

    private SummonerService summonerService;

    public SummonerController(final SummonerService summonerService) {
        this.summonerService = summonerService;
    }

    @GetMapping("search/{summonerName}")
    public UserDto getSummonerInfo(@PathVariable("summonerName") String summonerName) throws InterruptedException {
        return summonerService.getSummonerInfo(summonerName);
    }
}

