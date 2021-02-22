package com.yourgg.assignment.service.dto;

import com.yourgg.assignment.riot.adaptor.RiotDataParser;
import com.yourgg.assignment.riot.dto.ParticipantDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SummonerInGameDto {

    private int participantId;

    private String championIdUrl;

    private SummonerInGameStatsDto stats;

    private String spellOneUrl;

    private String spellTwoUrl;

    public static SummonerInGameDto of(final ParticipantDto participantDto, final RiotDataParser riotDataParser) {

        int participantId = participantDto.getParticipantId();
        String championIdUrl = riotDataParser.championIdParser(participantDto.getChampionId());
        SummonerInGameStatsDto stats = SummonerInGameStatsDto.of(participantDto.getStats(), riotDataParser);
        String spellOneUrl = riotDataParser.spellIdParser(participantDto.getSpellOneId());
        String spellTwoUrl = riotDataParser.spellIdParser(participantDto.getSpellTwoId());
        return new SummonerInGameDto(participantId, championIdUrl, stats, spellOneUrl, spellTwoUrl);
    }
}
