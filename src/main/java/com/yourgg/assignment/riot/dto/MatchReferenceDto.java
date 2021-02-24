package com.yourgg.assignment.riot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MatchReferenceDto {

    @JsonProperty(value = "gameId")
    private long gameId;

    @JsonProperty(value = "role")
    private String role;

    @JsonProperty(value = "platformId")
    private String platformId;

    @JsonProperty(value = "champion")
    private int champion;

    @JsonProperty(value = "queue")
    private int queue;

    @JsonProperty(value = "lane")
    private String lane;
}
