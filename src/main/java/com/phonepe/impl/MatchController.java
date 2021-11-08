package com.phonepe.impl;

import com.phonepe.models.*;

public class MatchController {

    public boolean isValidBall(BallType ballType){
        return !ballType.equals(BallType.NO_BALL) && !ballType.equals(BallType.WIDE);
    }

    public boolean processBallAndValidateInnings(Ball ball, Match match) {
        Innings currentInnings = match.getInnings();
        Team currentTeam = currentInnings.getBattingTeam();
        Team oppositeTeam = currentInnings.getBowlingTeam();
        Player strikeBatsman = match.getInnings().getCurrentStrikeBatsman();
        BattingRecord battingRecord = (BattingRecord) strikeBatsman.getBattingRecord();
        ball.setPlayedBy(strikeBatsman);
        int score = ball.getRunsMade();
        switch (ball.getBallType().name()){
            case "WICKET":
                battingRecord.incrementBall();
                currentTeam.setWicketsFallen(currentTeam.getWicketsFallen()+1);
                currentTeam.incrementNumberOfBallsPlayed();
                if(currentTeam.getWicketsFallen()+1>=currentTeam.getPlayers().size()) {
                    currentInnings.setCurrentStrikeBatsman(null);
                    return false;
                }
                currentInnings.setCurrentStrikeBatsman(currentTeam.getPlayers().get(currentTeam.getWicketsFallen()+1));
                break;
            case "WIDE":
            case "NO_BALL":
                currentTeam.setTotalScore(currentTeam.getTotalScore()+1);
                currentTeam.incrementExtras();
                break;
            case "RUN_OUT":
                battingRecord.incrementBall();
                currentTeam.setWicketsFallen(currentTeam.getWicketsFallen()+1);
                currentTeam.incrementNumberOfBallsPlayed(); //Number of overs
                currentTeam.setTotalScore(currentTeam.getTotalScore()+score);
                battingRecord.updateStat(score,score==4,score==6);
                if(currentTeam.getWicketsFallen()+1>=currentTeam.getPlayers().size()) {
                    currentInnings.setCurrentStrikeBatsman(null);
                    return false;
                }
                if(score%2==0){
                    currentInnings.setOppositeStrikeBatsman(currentTeam.getPlayers().get(currentTeam.getWicketsFallen()+1));
                    currentInnings.swipeStrike();
                }
                else{
                    currentInnings.setCurrentStrikeBatsman(currentTeam.getPlayers().get(currentTeam.getWicketsFallen()+1));
                }
                break;
            default:
                currentTeam.setTotalScore(currentTeam.getTotalScore()+score);
                battingRecord.updateStat(score,score==4,score==6);
                if(score%2==1){
                    currentInnings.swipeStrike();
                }
                currentTeam.incrementNumberOfBallsPlayed();
                if(currentInnings.isSecondInnings() && currentTeam.getTotalScore()>oppositeTeam.getTotalScore())
                    return false;
                break;
        }
        return true;
    }

}
