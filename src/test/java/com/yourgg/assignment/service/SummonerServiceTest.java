package com.yourgg.assignment.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yourgg.assignment.adaptor.RiotAdaptor;
import com.yourgg.assignment.service.dto.MatchReferenceDto;
import com.yourgg.assignment.service.dto.MatchlistDto;
import com.yourgg.assignment.service.dto.SummonerDto;
import com.yourgg.assignment.service.dto.UserDto;

@SpringBootTest
class SummonerServiceTest {

    @Autowired
    private RiotAdaptor riotAdaptor;

    @Autowired
    private RiotApiService riotApiService;

    private SummonerService summonerService;

    @BeforeEach
    void setUp() {
        riotApiService = new RiotApiService(riotAdaptor);
        summonerService = new SummonerService(riotApiService);
    }

    @DisplayName("getSummonerInfo: 소환사 이름 검색시 소환사 정보를 가져온다.")
    @Test
    void getSummonerInfoTest() {

        //given
        SummonerDto summonerDto = riotAdaptor.getSummonerDto("큰고모부");
        MatchlistDto matchlistDto = riotAdaptor.getMatchlistDto(summonerDto.getAccountId());
        List<MatchReferenceDto> matches = matchlistDto.getMatches();
        MatchReferenceDto matchReferenceDto = matches.get(0);

        //when
        UserDto result = summonerService.getSummonerInfo("큰고모부");

        //then
        MatchReferenceDto endMatchResult = result.getMatches().get(0);

        assertThat(endMatchResult.getGameId()).isEqualTo(matchReferenceDto.getGameId());
        assertThat(result.getMatches()).hasSize(20);

    }

}