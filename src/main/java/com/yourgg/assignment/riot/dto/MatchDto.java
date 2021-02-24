package com.yourgg.assignment.riot.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MatchDto {

    @JsonProperty(value = "gameId")
    private long gameId;

    @JsonProperty(value = "participantIdentities")
    private List<ParticipantIdentityDto> participantIdentities;

    @JsonProperty(value = "gameMode")
    private String gameMode;

    @JsonProperty(value = "participants")
    private List<ParticipantDto> participants;
}
