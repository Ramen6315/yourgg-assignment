package com.yourgg.assignment.riot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yourgg.assignment.config.FeignRetryConfiguration;
import com.yourgg.assignment.riot.dto.MatchDto;
import com.yourgg.assignment.riot.dto.MatchlistDto;
import com.yourgg.assignment.riot.dto.SummonerDto;

@FeignClient(value="get-summoner-api",url="https://kr.api.riotgames.com", decode404 = true, configuration = {
        FeignRetryConfiguration.class})
public interface RiotClient {

    String endIndex = "20";
    String beginIndex = "0";

    @GetMapping("/lol/summoner/v4/summoners/by-name/{summonerName}?api_key=RGAPI-12780316-453c-40a1-b3f0-266e58d256ee")
    SummonerDto getSummonerInfo(@PathVariable("summonerName") String summonerName);

    @GetMapping("/lol/match/v4/matchlists/by-account/{encryptedAccountId}?endIndex=" + endIndex + "&beginIndex=" + beginIndex + "&api_key=RGAPI-12780316-453c-40a1-b3f0-266e58d256ee")
    MatchlistDto getMachlistInfo(@PathVariable("encryptedAccountId") String encryptedAccountId);

    @GetMapping("/lol/match/v4/matches/{matchId}?api_key=RGAPI-12780316-453c-40a1-b3f0-266e58d256ee")
    MatchDto getMatchInfo(@PathVariable("matchId") long matchId);
}

