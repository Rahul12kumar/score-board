package com.phonepe.impl;

import com.phonepe.models.Match;
import com.phonepe.models.Player;
import com.phonepe.models.Team;
import com.phonepe.utils.Utils;

public class ScoreBoardService {


    public void displayScoreBoard(Match match) {
        Team currentTeam = match.getInnings().getBattingTeam();
        System.out.println("Scorecard for team "+currentTeam.getName() + ":");
        System.out.println("Player Name\t Score\t 4s\t 6s\t Balls");
        for(Player player:currentTeam.getPlayers()){
            System.out.print(player.getName());
            if(match.getInnings().getCurrentStrikeBatsman()!=null)
                System.out.print((player.equals(match.getInnings().getCurrentStrikeBatsman()) || player.equals(match.getInnings().getOppositeStrikeBatsman()))?"*\t":"\t");
            else
                System.out.print(player.equals(match.getInnings().getOppositeStrikeBatsman())?"*\t":"\t");
            player.getBattingRecord().showRecords();
        }
        System.out.println("Total: "+currentTeam.getTotalScore() + "/" +currentTeam.getWicketsFallen());
        System.out.println("Overs: "+ Utils.calculateTotalOvers(currentTeam.getNumbersOfBallsPlayed()));
    }

    public void showResults(Match match){
        Team teamOne = match.getTeamOne();
        Team teamTwo = match.getTeamTwo();
        System.out.print("Result: ");
        if(teamOne.getTotalScore()>teamTwo.getTotalScore()){
            System.out.println(teamOne.getName() + " won the match by " + (teamOne.getTotalScore()-teamTwo.getTotalScore()) + " runs");
        }
        else if(teamTwo.getTotalScore()>teamOne.getTotalScore()){
            System.out.println(teamTwo.getName() + " won the match by " + (teamTwo.getPlayers().size()-teamTwo.getWicketsFallen()) + " wickets");
        }
        else{
            System.out.println("NO RESULT");
        }
    }

}
