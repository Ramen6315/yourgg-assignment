package com.yourgg.assignment.service.dto;

import com.yourgg.assignment.riot.dto.ParticipantStatsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SummonerItemDto {

    private final int itemZero;

    private final int itemOne;

    private final int itemTwo;

    private final int itemThree;

    private final int itemFour;

    private final int itemFive;

    private final int itemSix;

    public static SummonerItemDto of(final ParticipantStatsDto participantDto) {

        int itemZero = participantDto.getItemZero();
        int itemOne = participantDto.getItemOne();
        int itemTwo = participantDto.getItemTwo();
        int itemThree = participantDto.getItemThree();
        int itemFour = participantDto.getItemFour();
        int itemFive = participantDto.getItemFive();
        int itemSix = participantDto.getItemSix();

        return new SummonerItemDto(itemZero, itemOne, itemTwo, itemThree, itemFour, itemFive, itemSix);
    }
}
