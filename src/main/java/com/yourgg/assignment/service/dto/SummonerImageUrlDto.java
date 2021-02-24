package com.yourgg.assignment.service.dto;

import com.yourgg.assignment.riot.adaptor.RiotDataParser;
import com.yourgg.assignment.riot.dto.ParticipantDto;
import com.yourgg.assignment.riot.dto.ParticipantStatsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SummonerImageUrlDto {

    private final String championImageUrl;

    private final String spellOneImageUrl;

    private final String spellTwoImageUrl;

    private final String perkZeroImageUrl;

    private final String perkSubStyleImageUrl;

    public static SummonerImageUrlDto of(final ParticipantDto participantDto, final RiotDataParser riotDataParser) {
        ParticipantStatsDto stats = participantDto.getStats();
        String championImageUrl = riotDataParser.championIdParser(participantDto.getChampionId());
        String spellOneImageUrl = riotDataParser.spellIdParser(participantDto.getSpellOneId());
        String spellTwoImageUrl = riotDataParser.spellIdParser(participantDto.getSpellTwoId());
        String perkZeroImageUrl = riotDataParser.perkZeroIdParser(stats.getPerkZero());
        String perkSubStyleImageUrl = riotDataParser.subRuneIdParser(stats.getPerkSubStyle());

        return new SummonerImageUrlDto(championImageUrl, spellOneImageUrl, spellTwoImageUrl, perkZeroImageUrl
                , perkSubStyleImageUrl);
    }
}
