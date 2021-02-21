package com.yourgg.assignment.service;

import org.springframework.stereotype.Service;

import com.yourgg.assignment.client.RiotClient;
import com.yourgg.assignment.service.dto.SummonerDto;

@Service
public class SummonerService {
    private RiotClient riotClient;

    public SummonerService(final RiotClient riotClient) {
        this.riotClient = riotClient;
    }

    public SummonerDto getSummonerInfo(final String summonerName) {
        return riotClient.getSummonerInfo(summonerName);
    }
}