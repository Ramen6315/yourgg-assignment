package com.yourgg.assignment.riot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yourgg.assignment.riot.adaptor.RiotAdaptor;
import com.yourgg.assignment.riot.adaptor.RiotDataParser;
import com.yourgg.assignment.riot.dto.MatchDto;
import com.yourgg.assignment.riot.dto.MatchReferenceDto;
import com.yourgg.assignment.riot.dto.MatchlistDto;
import com.yourgg.assignment.riot.dto.ParticipantDto;
import com.yourgg.assignment.riot.dto.ParticipantIdentityDto;
import com.yourgg.assignment.riot.dto.SummonerDto;
import com.yourgg.assignment.service.dto.SummonerInGameDto;

@Service
public class RiotApiService {

    private final RiotAdaptor adaptor;

    private final RiotDataParser riotDataParser;

    public RiotApiService(final RiotAdaptor adaptor, final RiotDataParser riotDataParser) {

        this.adaptor = adaptor;
        this.riotDataParser = riotDataParser;
    }

    public List<SummonerInGameDto> getUserMatchlistInfo(String summonerName) throws InterruptedException {
        List<ParticipantDto> summonerMatchInfos = new ArrayList<>();
        List<SummonerInGameDto> summonerInGameDtos = new ArrayList<>();

        SummonerDto summonerDto = adaptor.getSummonerDto(summonerName);
        MatchlistDto matchlistDto = adaptor.getMatchlistDto(summonerDto.getAccountId());
        List<MatchReferenceDto> matchReferences = matchlistDto.getMatches();
        List<MatchDto> matchDtos = new ArrayList<>();

        getLatestMatchs(matchReferences, matchDtos);
        getLatestUserMatchs(summonerName, summonerMatchInfos, matchDtos);
        for (ParticipantDto participantDto : summonerMatchInfos) {
            summonerInGameDtos.add(SummonerInGameDto.of(participantDto, riotDataParser));
        }
        return summonerInGameDtos;
    }

    private void getLatestMatchs(final List<MatchReferenceDto> matchReferences, final List<MatchDto> matchDtos) throws
            InterruptedException {
        for (MatchReferenceDto matchReference: matchReferences) {
            Thread.sleep(1L);
            matchDtos.add(adaptor.getMatchDto(matchReference.getGameId()));
        }
    }

    private void getLatestUserMatchs(final String summonerName, final List<ParticipantDto> summonerMatchInfos,
            final List<MatchDto> matchDtos) {
        for (MatchDto matchDto : matchDtos) {
            extractUserMatchInfos(summonerName, summonerMatchInfos, matchDto);
        }
    }

    private void extractUserMatchInfos(final String summonerName, final List<ParticipantDto> summonerMatchInfos,
            final MatchDto matchDto) {
        for (ParticipantIdentityDto participantIdentityDto: matchDto.getParticipantIdentities()) {
            String summoner = participantIdentityDto.getSummonerName();
            if(summoner.equals(summonerName)) {
                getUserParticipant(summonerMatchInfos, matchDto, participantIdentityDto);
            }
        }
    }

    private void getUserParticipant(final List<ParticipantDto> summonerMatchInfos, final MatchDto matchDto,
            final ParticipantIdentityDto participantIdentityDto) {
        for (ParticipantDto participantDto : matchDto.getParticipants()) {
            if(participantDto.getParticipantId() == participantIdentityDto.getParticipantId()) {
                summonerMatchInfos.add(participantDto);
            }
        }
    }
}
