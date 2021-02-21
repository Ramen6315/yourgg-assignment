package com.yourgg.assignment.service;

import org.springframework.stereotype.Service;

import com.yourgg.assignment.adaptor.RiotAdaptor;
import com.yourgg.assignment.service.dto.MatchlistDto;
import com.yourgg.assignment.service.dto.SummonerDto;
import com.yourgg.assignment.service.dto.UserDto;

@Service
public class RiotApiService {

    private final RiotAdaptor adaptor;

    public RiotApiService(final RiotAdaptor adaptor) {

        this.adaptor = adaptor;
    }

    public UserDto getUserMatchlistInfo(String summonerName) {

        SummonerDto summonerDto = adaptor.getSummonerDto(summonerName);
        MatchlistDto matchlistDto = adaptor.getMatchlistDto(summonerDto.getAccountId());

        return UserDto.of(matchlistDto);
    }
}
