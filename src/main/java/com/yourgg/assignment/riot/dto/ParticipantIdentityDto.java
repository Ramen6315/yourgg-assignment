package com.yourgg.assignment.riot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ParticipantIdentityDto {

    @JsonProperty(value = "participantId")
    private int participantId;

    @JsonProperty(value = "player")
    private PlayerDto player;

    public String getSummonerName() {
        return player.getSummonerName();
    }
}
