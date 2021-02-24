package com.yourgg.assignment.service.dto;

import com.yourgg.assignment.riot.adaptor.RiotDataParser;
import com.yourgg.assignment.riot.dto.ParticipantDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SummonerInGameDto {

    private final int participantId;

    private final SummonerInGameStatsDto summonerInGameStatsDto;

    private final SummonerItemDto summonerInGameItemDto;

    private final SummonerImageUrlDto summonerImageUrlDto;

    public static SummonerInGameDto of(final ParticipantDto participantDto, final RiotDataParser riotDataParser) {

        SummonerInGameStatsDto summonerInGameStatsDto = SummonerInGameStatsDto.of(participantDto.getStats());
        SummonerItemDto summonerItemDto = SummonerItemDto.of(participantDto.getStats());
        SummonerImageUrlDto summonerImageUrlDto = SummonerImageUrlDto.of(participantDto, riotDataParser);

        return new SummonerInGameDto(participantDto.getParticipantId(), summonerInGameStatsDto, summonerItemDto
                , summonerImageUrlDto);
    }
}
