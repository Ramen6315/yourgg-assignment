package com.yourgg.assignment.service.dto;

import com.yourgg.assignment.riot.adaptor.RiotDataParser;
import com.yourgg.assignment.riot.dto.ParticipantStatsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SummonerInGameStatsDto {

    private int itemZero;

    private int itemOne;

    private int itemTwo;

    private int itemThree;

    private int itemFour;

    private int itemFive;

    private int itemSix;

    private int kill;

    private int deaths;

    private int assists;

    private long totalDamageDealtToChampions;

    private int goldEarned;

    private int champLevel;

    private int creepScore;

    private String perkZeroUrl;

    private String perkSubStyleUrl;

    private boolean win;

    public static SummonerInGameStatsDto of(final ParticipantStatsDto participantDto, final RiotDataParser riotDataParser) {

        int itemZero = participantDto.getItemZero();
        int itemOne = participantDto.getItemOne();
        int itemTwo = participantDto.getItemTwo();
        int itemThree = participantDto.getItemThree();
        int itemFour = participantDto.getItemFour();
        int itemFive = participantDto.getItemFive();
        int itemSix = participantDto.getItemSix();
        int kill = participantDto.getKill();
        int deaths = participantDto.getDeaths();
        int assists = participantDto.getAssists();
        long totalDamageDealtToChampions = participantDto.getTotalDamageDealtToChampions();
        int goldEarned = participantDto.getGoldEarned();
        int champLevel = participantDto.getChampLevel();
        int creepScore = participantDto.getTotalMinionsKilled() + participantDto.getNeutralMinionsKilled();
        String perkZeroUrl = riotDataParser.perkZeroIdParser(participantDto.getPerkZero());
        String perkSubStyleUrl = riotDataParser.subRuneIdParser(participantDto.getPerkSubStyle());
        boolean win = participantDto.isWin();

        return new SummonerInGameStatsDto(itemZero, itemOne, itemTwo, itemThree, itemFour, itemFive, itemSix, kill
                , deaths, assists, totalDamageDealtToChampions, goldEarned, champLevel, creepScore, perkZeroUrl,
                perkSubStyleUrl, win);
    }
}
