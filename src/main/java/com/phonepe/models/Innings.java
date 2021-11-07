package com.phonepe.models;

public class Innings {

    private String currentInningsTeamName;
    private Player currentStrikeBatsman;
    private Player oppositeStrikeBatsman;
    private Player currentBowler;
    private Team battingTeam;
    private Team bowlingTeam;
    private boolean isSecondInnings;

    public Innings(Team teamOne, Team teamTwo) {
        this.currentInningsTeamName = teamOne.getName();
        this.battingTeam = teamOne;
        this.bowlingTeam = teamTwo;
        this.currentStrikeBatsman  = teamOne.getPlayers().get(0);
        this.oppositeStrikeBatsman = teamOne.getPlayers().get(1);
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(Team battingTeam) {
        this.battingTeam = battingTeam;
    }

    public Team getBowlingTeam() {
        return bowlingTeam;
    }

    public void setBowlingTeam(Team bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }

    public String getCurrentInningsTeamName() {
        return currentInningsTeamName;
    }

    public void setCurrentInningsTeamName(String currentInningsTeamName) {
        this.currentInningsTeamName = currentInningsTeamName;
    }

    public Player getCurrentStrikeBatsman() {
        return currentStrikeBatsman;
    }

    public void setCurrentStrikeBatsman(Player currentStrikeBatsman) {
        this.currentStrikeBatsman = currentStrikeBatsman;
    }

    public Player getOppositeStrikeBatsman() {
        return oppositeStrikeBatsman;
    }

    public void setOppositeStrikeBatsman(Player oppositeStrikeBatsman) {
        this.oppositeStrikeBatsman = oppositeStrikeBatsman;
    }

    public Player getCurrentBowler() {
        return currentBowler;
    }

    public void setCurrentBowler(Player currentBowler) {
        this.currentBowler = currentBowler;
    }

    public void swipeStrike() {
        Player temp = this.currentStrikeBatsman;
        this.currentStrikeBatsman = this.oppositeStrikeBatsman;
        this.oppositeStrikeBatsman = temp;
    }

    public boolean isSecondInnings() {
        return isSecondInnings;
    }

    public void setSecondInnings(boolean secondInnings) {
        isSecondInnings = secondInnings;
    }
}
