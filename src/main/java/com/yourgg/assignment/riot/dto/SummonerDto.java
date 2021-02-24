package com.yourgg.assignment.riot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SummonerDto {

    @JsonProperty(value = "accountId")
    private String accountId;

    @JsonProperty(value = "profileIconId")
    private int profileIconId;

    @JsonProperty(value = "revisionDate")
    private long revisionDate;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "puuid")
    private String puuid;

    @JsonProperty(value = "summonerLevel")
    private long summonerLevel;
}
