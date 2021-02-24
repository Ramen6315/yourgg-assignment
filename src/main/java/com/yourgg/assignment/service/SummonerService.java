package com.yourgg.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yourgg.assignment.riot.service.RiotApiService;
import com.yourgg.assignment.service.dto.SummonerInGameDto;
import com.yourgg.assignment.service.dto.UserDto;

@Service
public class SummonerService {

    private final RiotApiService riotApiService;

    public SummonerService(final RiotApiService riotApiService) {

        this.riotApiService = riotApiService;
    }

    public UserDto getSummonerInfo(final String summonerName) throws InterruptedException {

        List<SummonerInGameDto> summonerInGameDtos = riotApiService.getUserMatchlistInfo(summonerName);
        return new UserDto(summonerName, summonerInGameDtos);
    }
}