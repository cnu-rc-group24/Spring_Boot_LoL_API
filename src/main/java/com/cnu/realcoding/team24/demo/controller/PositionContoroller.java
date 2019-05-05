package com.cnu.realcoding.team24.demo.controller;

import com.cnu.realcoding.team24.demo.domain.LeaguePositionDTO;
import com.cnu.realcoding.team24.demo.domain.SummonerDTO;
import com.cnu.realcoding.team24.demo.service.LOLPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Component
@RestController
@RequestMapping("/lolEncryptedSummonerId")
public class PositionContoroller {
    @Autowired
    private LOLPositionService lolPositionService;

    @GetMapping("/userSummonerId/{summonerName}")
    //public SummonerDTO getEncryptedSummonerId(@PathVariable String summonerName){
    public SummonerDTO getEncryptedSummonerId(@PathVariable String summonerName){
        return lolPositionService.getSummonerDTO(summonerName);
    }

    @GetMapping("/currentPosition/{summonerId}")
    public Set<LeaguePositionDTO> getCurrentPositionBySummonerId(@PathVariable String summonerId){
        return lolPositionService.getCurrentPositionDB(summonerId);
    }
}
