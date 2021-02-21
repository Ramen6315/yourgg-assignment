package com.yourgg.assignment.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yourgg.assignment.client.RiotClient;
import com.yourgg.assignment.service.dto.SummonerDto;

@SpringBootTest
class SummonerServiceTest {

    @Autowired
    private RiotClient riotClient;

    private SummonerService summonerService;

    @BeforeEach
    void setUp() {

        summonerService = new SummonerService(riotClient);
    }

    @DisplayName("getSummonerInfo: 소환사 이름 검색시 소환사 정보를 가져온다.")
    @Test
    void getSummonerInfoTest() {

        SummonerDto result = summonerService.getSummonerInfo("큰고모부");

        assertThat(result.getName()).isEqualTo("큰고모부");
    }

}