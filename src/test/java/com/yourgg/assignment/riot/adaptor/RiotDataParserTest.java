package com.yourgg.assignment.riot.adaptor;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RiotDataParserTest {

    private RiotDataParser riotDataParser;

    @BeforeEach
    void setUp() {
        riotDataParser = new RiotDataParser();
    }

    @DisplayName("championIdParser: 챔피언 아이디에 해당하는 챔피언이름을 Return 한다.")
    @Test
    void championIdParserTest() {
        int championId = 266;

        String championName = riotDataParser.championIdParser(championId);

        assertThat(championName).isEqualTo("Aatrox.png");
    }

    @DisplayName("subRuneIdParserTest: 서브 대표룬 이미지 url을 가져온다")
    @Test
    void subRuneIdParserTest() {
        int runeId = 8100;
        String runeUrl = riotDataParser.subRuneIdParser(runeId);

        assertThat(runeUrl).isEqualTo("perk-images/Styles/7200_Domination.png");
    }

    @DisplayName("test")
    @Test
    void perkZeroIdParserTest() {
        int runeId = 8021;
        String runeUrl = riotDataParser.perkZeroIdParser(runeId);

        assertThat(runeUrl).isEqualTo("perk-images/Styles/Precision/FleetFootwork/FleetFootwork.png");
    }

    @DisplayName("test")
    @Test
    void test() {
        int spellId = 4;

        String spellUrl = riotDataParser.spellIdParser(spellId);

        assertThat(spellUrl).isEqualTo("SummonerFlash.png");
    }
}