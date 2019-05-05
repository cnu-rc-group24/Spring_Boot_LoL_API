package com.cnu.realcoding.team24.demo.service;


import com.cnu.realcoding.team24.demo.api.OpenSummonerInforApiClient;
import com.cnu.realcoding.team24.demo.api.PositionInforApiClient;
import com.cnu.realcoding.team24.demo.domain.LeaguePositionDTO;
import com.cnu.realcoding.team24.demo.domain.SummonerDTO;
import com.cnu.realcoding.team24.demo.repository.CurrentPositionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Set;

@Service
@Slf4j
public class LOLPositionService {
    @Autowired
    private OpenSummonerInforApiClient openSummonerInforApiClient;

    @Autowired
    private PositionInforApiClient positionInforApiClient;

    @Autowired
    private CurrentPositionRepository currentPositionRepository;

    private LinkedList<String> summonerNameList = new LinkedList<String>();
    private String SummonerName = new String();

    public SummonerDTO getSummonerDTO(String summonerName) {
        log.info(summonerName);
        SummonerDTO summonerDTO = openSummonerInforApiClient.getSummonerInformation(summonerName);
       return summonerDTO;
    }

    public Set<LeaguePositionDTO> getCurrentPositionDB(String summonerName){
        SummonerDTO summoerinfor = openSummonerInforApiClient.getSummonerInformation(summonerName);
        String summonerId = summoerinfor.getId();
        log.info(summonerId);
        return positionInforApiClient.getPositionInfor(summonerId);
    }
}
