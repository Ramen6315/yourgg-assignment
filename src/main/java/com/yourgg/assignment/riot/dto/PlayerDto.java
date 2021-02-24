package com.yourgg.assignment.riot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PlayerDto {

    @JsonProperty(value = "participantId")
    private int participantId;

    @JsonProperty(value = "summonerName")
    private String summonerName;

}
