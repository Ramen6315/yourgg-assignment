package com.yourgg.assignment.riot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ParticipantDto {

    @JsonProperty(value = "participantId")
    private int participantId;

    @JsonProperty(value = "championId")
    private int championId;

    @JsonProperty(value = "stats")
    private ParticipantStatsDto stats;

    @JsonProperty(value = "spell1Id")
    private int spellOneId;

    @JsonProperty(value = "spell2Id")
    private int spellTwoId;

}
