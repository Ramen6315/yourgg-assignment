package com.yourgg.assignment.service.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {

    private final List<MatchReferenceDto> matches;

    public static UserDto of( final MatchlistDto matchlistDto) {

        List<MatchReferenceDto> matches = matchlistDto.getMatches();
        List<MatchReferenceDto> latestTwentyMatches = new ArrayList<>();
        for (int index = 0; index < 20; index++) {
            latestTwentyMatches.add(matches.get(index));
        }

        return new UserDto(latestTwentyMatches);
    }
}
