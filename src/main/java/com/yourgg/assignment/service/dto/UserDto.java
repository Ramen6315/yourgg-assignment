package com.yourgg.assignment.service.dto;

import java.util.List;

import com.yourgg.assignment.riot.dto.ParticipantDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {

    private final String summonerName;

    private final List<ParticipantDto> summonerMatchInfos;

    public static UserDto of(final String summonerName, final List<ParticipantDto> summonerMatchInfos) {
        return new UserDto(summonerName, summonerMatchInfos);
    }
}
