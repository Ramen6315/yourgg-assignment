package com.yourgg.assignment.summoner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yourgg.assignment.service.SummonerService;
import com.yourgg.assignment.service.dto.SummonerDto;

@RestController
public class SummonerController {

    private SummonerService summonerService;

    public SummonerController(final SummonerService summonerService) {
        this.summonerService = summonerService;
    }

    @GetMapping("/{summonerName}")
    public SummonerDto getSummonerInfo(@PathVariable("summonerName") String summonerName) {
        return summonerService.getSummonerInfo(summonerName);
    }
}
