package com.yourgg.assignment.adaptor;

import org.springframework.stereotype.Component;

import com.yourgg.assignment.client.RiotClient;
import com.yourgg.assignment.service.dto.MatchlistDto;
import com.yourgg.assignment.service.dto.SummonerDto;

@Component
public class RiotAdaptor {

    private final RiotClient riotClient;

    public RiotAdaptor(final RiotClient riotClient) {
        this.riotClient = riotClient;
    }

    public SummonerDto getSummonerDto(String summonerName) {
        return riotClient.getSummonerInfo(summonerName);
    }

    public MatchlistDto getMatchlistDto(String encryptedAccountId) {
        return riotClient.getMachlistInfo(encryptedAccountId);
    }
}
