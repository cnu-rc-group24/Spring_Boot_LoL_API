package com.cnu.realcoding.team24.demo.domain;

import lombok.Data;

@Data
public class LeaguePositionDTO {
    /*queueType	string
    summonerName	string
    hotStreak	boolean
    miniSeries	MiniSeriesDTO
    wins	int
    veteran	boolean
    losses	int
    rank	string
    leagueId	string
    inactive	boolean
    freshBlood	boolean
    leagueName	string
    position	string	(Legal values: APEX, TOP, JUNGLE, MIDDLE, BOTTOM, UTILITY, NONE)
    tier	string
    summonerId	string	Player's summonerId (Encrypted)
    leaguePoints	int*/
    private String leagueId;

    private String leagueName;

    private String queueType;

    private String position;

    private String tier;

    private String rank;

    private String summonerId;

    private String summonerName;

    private int leaguePoints;

    private int wins;

    private int losses;

    private boolean veteran;

    private boolean inactive;

    private boolean freshBlood;

    private boolean hotStreak;

    private MiniSeriesDTO miniSeries;
    /*private String queueType;
    private String summonerName;
    private boolean hotStreak;
    //private MiniSeriesDTO miniSeries;
    private int wins;
    private boolean veteran;
    private int losses;
    private String rank;
    private String leagueId;
    private boolean inactive;
    private boolean freshBlood;
    private String leagueName;
    private String position;
    private String tier;
    private String summonerId;
    private int leaguePoints;*/

}
