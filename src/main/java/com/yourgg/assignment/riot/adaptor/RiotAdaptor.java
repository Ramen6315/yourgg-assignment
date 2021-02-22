package com.yourgg.assignment.riot.adaptor;

import org.springframework.stereotype.Component;

import com.yourgg.assignment.riot.client.RiotClient;
import com.yourgg.assignment.riot.dto.MatchDto;
import com.yourgg.assignment.riot.dto.MatchlistDto;
import com.yourgg.assignment.riot.dto.SummonerDto;

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

    public MatchDto getMatchDto(long matchId) {
        return riotClient.getMatchInfo(matchId);
    }
}
