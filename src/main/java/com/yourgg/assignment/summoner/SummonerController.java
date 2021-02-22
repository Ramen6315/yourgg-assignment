package com.yourgg.assignment.summoner;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yourgg.assignment.service.SummonerService;
import com.yourgg.assignment.service.dto.SummonerInGameDto;

@RestController
public class SummonerController {

    private SummonerService summonerService;

    public SummonerController(final SummonerService summonerService) {
        this.summonerService = summonerService;
    }

    @GetMapping("/{summonerName}")
    public List<SummonerInGameDto> getSummonerInfo(@PathVariable("summonerName") String summonerName) throws InterruptedException {
        return summonerService.getSummonerInfo(summonerName);
    }
}

