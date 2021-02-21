package com.yourgg.assignment.adaptor;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yourgg.assignment.client.RiotClient;
import com.yourgg.assignment.service.dto.MatchlistDto;
import com.yourgg.assignment.service.dto.SummonerDto;

@SpringBootTest
class RiotAdaptorTest {

    @Autowired
    private RiotClient riotClient;

    private RiotAdaptor riotAdaptor;

    private String summonerName;

    @BeforeEach
    void setUp() {
        summonerName = "큰고모부";
        riotAdaptor = new RiotAdaptor(riotClient);
    }

    @DisplayName("getSummonerDto: 소환사 이름 검색시 소환사 정보를 가져온다.")
    @Test
    void getSummonerDtoTest() {

        SummonerDto result = riotAdaptor.getSummonerDto(summonerName);

        assertThat(result.getName()).isEqualTo("큰고모부");
    }

    @DisplayName("MatchlistDtoTest: 소환사 encryptedAccountId로 최근 경기 정보를 가져온다")
    @Test
    void getMatchlistDtoTest() {
        SummonerDto summonerDto = riotAdaptor.getSummonerDto(summonerName);
        MatchlistDto matchlistDto = riotAdaptor.getMatchlistDto(summonerDto.getAccountId());

        assertThat(matchlistDto.getMatches()).hasSize(100);
    }
}
