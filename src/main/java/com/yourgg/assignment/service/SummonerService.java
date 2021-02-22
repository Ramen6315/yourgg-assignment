package com.yourgg.assignment.service;

import org.springframework.stereotype.Service;

import com.yourgg.assignment.riot.service.RiotApiService;


@Service
public class SummonerService {

    private final RiotApiService riotApiService;

    public SummonerService(final RiotApiService riotApiService) {

        this.riotApiService = riotApiService;
    }

    public UserDto getSummonerInfo(final String summonerName) throws InterruptedException {

        return riotApiService.getUserMatchlistInfo(summonerName);
    }
}