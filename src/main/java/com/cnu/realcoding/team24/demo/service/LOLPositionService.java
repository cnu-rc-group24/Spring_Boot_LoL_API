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


//    @Scheduled(initialDelay = 5000L, fixedDelay = 2000L)
//    public void getCurrentWeatherPeriodicallyByCitNamye() {
//        if(summonerNameList.isEmpty()){
//            String[] summonerNames = {"hide on bush", "Cuzz", "Gen G Ruler", "KZ Keria"};
//
//            if (summonerNameList.isEmpty()) {
//                for(int i = 0; i < summonerNames.length; i++) {
//                    SummonerDTO availableSummonerId = this.getSummonerDTO(summonerNames[i]);
//                    summonerNameList.add(availableSummonerId.getId());
//                }
//            }
//
//            String summonerId = summonerNameList.pop();
//            summonerNameList.add(summonerId);
//            log.info("CurrentWeather has inserted successfully. CurrentWeather : {}", summonerId);
//            LeaguePositionDTO SummonerPosition = positionInforApiClient.getPositionInfor(summonerId);
//
//            LeaguePositionDTO insertedPostion = currentPositionRepository.insertCurrentPositionDB(SummonerPosition);
//            log.info("CurrentWeather has inserted successfully. CurrentWeather : {}", insertedPostion);
//        }
//    }

    public Set<LeaguePositionDTO> getCurrentPositionDB(String summonerName){
        SummonerDTO summoerinfor = openSummonerInforApiClient.getSummonerInformation(summonerName);
        String summonerId = summoerinfor.getId();
        log.info(summonerId);
        return positionInforApiClient.getPositionInfor(summonerId);
    }
}
