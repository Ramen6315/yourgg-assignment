package com.yourgg.assignment.summoner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yourgg.assignment.service.SummonerService;
import com.yourgg.assignment.service.dto.SummonerDto;

@Controller
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
