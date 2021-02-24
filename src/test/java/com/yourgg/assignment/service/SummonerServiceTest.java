package com.yourgg.assignment.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yourgg.assignment.riot.adaptor.RiotAdaptor;
import com.yourgg.assignment.riot.adaptor.RiotDataParser;
import com.yourgg.assignment.riot.service.RiotApiService;
import com.yourgg.assignment.service.dto.UserDto;

@SpringBootTest
class SummonerServiceTest {

    @Autowired
    private RiotAdaptor riotAdaptor;

    @Autowired
    private RiotDataParser riotDataParser;

    @Autowired
    private RiotApiService riotApiService;

    private SummonerService summonerService;

    @BeforeEach
    void setUp() {
        riotApiService = new RiotApiService(riotAdaptor, riotDataParser);
        summonerService = new SummonerService(riotApiService);
    }

    @DisplayName("getSummonerInfo: 소환사 이름 검색시 소환사 정보를 가져온다.")
    @Test
    void getSummonerInfoTest() throws InterruptedException {
        //when
        UserDto result = summonerService.getSummonerInfo("큰고모부");

        //then\
        assertThat(result.getSummonerName()).isEqualTo("큰고모부");
        assertThat(result.getSummonerInGameDtos()).hasSize(20);

    }


}