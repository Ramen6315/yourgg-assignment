package com.yourgg.assignment.service.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {

    private final String summonerName;

    private List<SummonerInGameDto> summonerInGameDtos;

    public static UserDto of(String summonerName, List<SummonerInGameDto> summonerInGameDtos) {

        return new UserDto(summonerName, summonerInGameDtos);
    }


}
