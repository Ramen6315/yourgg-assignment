package com.yourgg.assignment.riot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ParticipantStatsDto {

    @JsonProperty(value = "item0")
    private int itemZero;

    @JsonProperty(value = "item1")
    private int itemOne;

    @JsonProperty(value = "item2")
    private int itemTwo;

    @JsonProperty(value = "item3")
    private int itemThree;

    @JsonProperty(value = "item4")
    private int itemFour;

    @JsonProperty(value = "item5")
    private int itemFive;

    @JsonProperty(value = "item6")
    private int itemSix;

    @JsonProperty(value = "kills")
    private int kill;

    @JsonProperty(value = "deaths")
    private int deaths;

    @JsonProperty(value = "assists")
    private int assists;

    @JsonProperty(value = "totalDamageDealtToChampions")
    private long totalDamageDealtToChampions;

    @JsonProperty(value = "goldEarned")
    private int goldEarned;

    @JsonProperty(value = "champLevel")
    private int champLevel;

    @JsonProperty(value = "totalMinionsKilled")
    private int totalMinionsKilled;

    @JsonProperty(value = "neutralMinionsKilled")
    private int neutralMinionsKilled;

    @JsonProperty(value = "perk0")
    private int perkZero;

    @JsonProperty(value = "perkSubStyle")
    private int perkSubStyle;

    @JsonProperty(value = "win")
    private boolean win;
}
