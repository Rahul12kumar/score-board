package com.phonepe.models;

import com.phonepe.exceptions.InvalidTeamNumbersException;

import java.util.ArrayList;
import java.util.List;

public class Team extends Auditable{

    private String name;
    List<Player> players;
    private int totalScore;
    private int totalExtras;
    private int numbersOfBallsPlayed;
    private int wicketsFallen;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalExtras() {
        return totalExtras;
    }

    public void setTotalExtras(int totalExtras) {
        this.totalExtras = totalExtras;
    }

    public int getNumbersOfBallsPlayed() {
        return numbersOfBallsPlayed;
    }

    public void setNumbersOfBallsPlayed(int numbersOfBallsPlayed) {
        this.numbersOfBallsPlayed = numbersOfBallsPlayed;
    }

    public int getWicketsFallen() {
        return wicketsFallen;
    }

    public void setWicketsFallen(int wicketsFallen) {
        this.wicketsFallen = wicketsFallen;
    }

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.totalScore = 0;
        this.totalExtras = 0;
        this.numbersOfBallsPlayed = 0;
        this.wicketsFallen = 0;
    }

    public Team(){

    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void incrementNumberOfBallsPlayed(){
        this.numbersOfBallsPlayed = this.numbersOfBallsPlayed+1;
    }

    public void incrementExtras() {
        this.totalExtras = this.totalExtras+1;
    }

    public void validateTeamPlayers(int numbersOfPlayers) throws InvalidTeamNumbersException {
        if(numbersOfPlayers<2)
            throw new InvalidTeamNumbersException("Team Players cannot be less than 2");
    }
}
