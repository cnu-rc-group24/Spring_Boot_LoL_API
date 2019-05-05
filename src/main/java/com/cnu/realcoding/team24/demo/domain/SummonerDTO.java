package com.cnu.realcoding.team24.demo.domain;

import lombok.Data;

import java.security.SecureRandom;

@Data
public class SummonerDTO {
    /*profileIconId	int	ID of the summoner icon associated with the summoner.
    name	string	Summoner name.
    puuid	string	Encrypted PUUID. Exact length of 78 characters.
    summonerLevel	long	Summoner level associated with the summoner.
    revisionDate	long	Date summoner was last modified specified as epoch milliseconds. The following events will update this timestamp: profile icon change, playing the tutorial or advanced tutorial, finishing a game, summoner name change
    id	string	Encrypted summoner ID. Max length 63 characters.
    accountId	string	Encrypted account ID. Max length 56 characters.*/

    private String id;

    private String accountId;

    private String puuid;

    private String name;

    private int profileIconId;

    private long revisionDate;

    private long summonerLevel;

}
