package com.yourgg.assignment.riot.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MatchlistDto {

    @JsonProperty(value = "matches")
    private List<MatchReferenceDto> matches;
}
