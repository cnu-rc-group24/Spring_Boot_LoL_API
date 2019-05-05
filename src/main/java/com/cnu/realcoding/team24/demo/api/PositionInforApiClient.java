package com.cnu.realcoding.team24.demo.api;

import com.cnu.realcoding.team24.demo.domain.LeaguePositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@Service
public class PositionInforApiClient {
    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "RGAPI-6130cf9f-0c11-422d-9f69-1b915b42baa7";
    private final String SummonerURL = "https://kr.api.riotgames.com/lol/league/v4/positions/by-summoner/{EncryptedSummonerId}?api_key={apiKey}";

    HttpHeaders requestHeaders = new HttpHeaders();

    public HttpHeaders setRequestHeaders(HttpHeaders requestHeaders) {
        requestHeaders.set("Content-Type","application/json;charset=utf-8");
        return requestHeaders;
    }

    private final ParameterizedTypeReference<Set<LeaguePositionDTO>> responseType = new ParameterizedTypeReference<Set<LeaguePositionDTO>>(){};

    HttpEntity<?> httpEntity = new HttpEntity<>(setRequestHeaders(requestHeaders));

    public Set<LeaguePositionDTO> getPositionInfor(String SummoenrId) {
        ResponseEntity<Set<LeaguePositionDTO>> leaguePositionDTO = restTemplate.exchange(SummonerURL, HttpMethod.GET, httpEntity,responseType, SummoenrId, apiKey);
        Set<LeaguePositionDTO> body = leaguePositionDTO.getBody();
        return body;
    }
}
