package com.cnu.realcoding.team24.demo.api;

import com.cnu.realcoding.team24.demo.domain.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenSummonerInforApiClient {
    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "RGAPI-6130cf9f-0c11-422d-9f69-1b915b42baa7";
    //https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/
    private final String SummonerURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{EncryptedSummonerId}?api_key={apiKey}";

    public SummonerDTO getSummonerInformation(String EncryptedSummonerId) {
        SummonerDTO summonerDTO = restTemplate.exchange(SummonerURL, HttpMethod.GET, null, SummonerDTO.class, EncryptedSummonerId, apiKey).getBody();
        return summonerDTO;
    }
}
