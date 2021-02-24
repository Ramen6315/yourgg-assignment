package com.yourgg.assignment.service.dto;

import com.yourgg.assignment.riot.dto.ParticipantStatsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SummonerInGameStatsDto {

    private final int kill;

    private final int deaths;

    private final int assists;

    private final long totalDamageDealtToChampions;

    private final int goldEarned;

    private final int champLevel;

    private final int creepScore;

    private final boolean win;

    public static SummonerInGameStatsDto of(final ParticipantStatsDto participantDto) {

        int kill = participantDto.getKill();
        int deaths = participantDto.getDeaths();
        int assists = participantDto.getAssists();
        long totalDamageDealtToChampions = participantDto.getTotalDamageDealtToChampions();
        int goldEarned = participantDto.getGoldEarned();
        int champLevel = participantDto.getChampLevel();
        int creepScore = participantDto.getTotalMinionsKilled() + participantDto.getNeutralMinionsKilled();
        boolean win = participantDto.isWin();

        return new SummonerInGameStatsDto( kill, deaths, assists, totalDamageDealtToChampions, goldEarned, champLevel
                , creepScore, win);
    }
}
