package com.yourgg.assignment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yourgg.assignment.config.FeignRetryConfiguration;
import com.yourgg.assignment.service.dto.SummonerDto;

@FeignClient(value="get-summoner-api",url="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name", decode404 = true, configuration = {
        FeignRetryConfiguration.class})
public interface RiotClient {

    @GetMapping("/{summonerName}?api_key=")
    SummonerDto getSummonerInfo(@PathVariable("summonerName") String summonerName);

}