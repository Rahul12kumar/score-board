package com.phonepe.models;


import java.util.List;

public class Match extends Auditable{

    private String name;
    private Innings innings;
    private Team teamOne;
    private Team teamTwo;
    private MatchResult matchResult;
    private Over over[];
    private String toss;

    public Match(int numberOfOvers, String name) {
        super();
        this.name = name;
        this.over = new Over[numberOfOvers];
        this.matchResult = MatchResult.LIVE;
        this.teamOne = new Team("Team One");
        this.teamTwo = new Team("Team Two");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Innings getInnings() {
        return innings;
    }

    public void setInnings(Innings innings) {
        this.innings = innings;
    }

    public MatchResult getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(MatchResult matchResult) {
        this.matchResult = matchResult;
    }

    public Over[] getOver() {
        return over;
    }

    public void setOver(Over[] over) {
        this.over = over;
    }

    public Team getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(Team teamOne) {
        this.teamOne = teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(Team teamTwo) {
        this.teamTwo = teamTwo;
    }

}
