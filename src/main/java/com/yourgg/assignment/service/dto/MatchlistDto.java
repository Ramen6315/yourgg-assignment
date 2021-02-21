package com.yourgg.assignment.service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MatchlistDto {

    @JsonProperty(value = "startIndex")
    private int startIndex;

    @JsonProperty(value = "totalGames")
    private int totalGames;

    @JsonProperty(value = "endIndex")
    private int endIndex;

    @JsonProperty(value = "matches")
    private List<MatchReferenceDto> matches;
}
