package com.phonepe.scoreboard;

import com.phonepe.config.ScannerSingleton;
import com.phonepe.exceptions.InvalidBallTypeException;
import com.phonepe.exceptions.InvalidOverNumberException;
import com.phonepe.exceptions.InvalidTeamNumbersException;
import com.phonepe.impl.MatchController;
import com.phonepe.impl.ScoreBoardService;
import com.phonepe.models.*;
import com.phonepe.utils.Constant;
import com.phonepe.utils.InitializationUtils;

import java.util.Scanner;

public class ScoreBoardApp {

    static MatchController matchController = new MatchController();
    static ScoreBoardService scoreBoardService = new ScoreBoardService();
    static Scanner sc = null;

    public static void main(String[] args) {

        System.out.println("Welcome to cricket Score Board Application");
        System.out.println("Please Enter No. of players for each team:");
        sc = ScannerSingleton.getInstance();
        int numberOfPlayers = sc.nextInt();
        try{
            new Team().validateTeamPlayers(numberOfPlayers);
        }
        catch (InvalidTeamNumbersException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Please Enter No. of overs:");
        int numberOfOvers = sc.nextInt();
        try {
            new Over().validateOverNumbers(numberOfOvers);
        }
        catch (InvalidOverNumberException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Thank you for the Input! Starting match");
        Match match = new Match(numberOfOvers,"IND VS AUS");
        System.out.println("Please Enter Batting Order for team 1:");
        InitializationUtils.initializeTeam(match.getTeamOne(),numberOfPlayers);
        System.out.println("Batting order initialized for Team 1");
        InitializationUtils.initializeInnings(match,true);
        System.out.println("Current Innings Started For Team 1");
        playInnings(match);
        System.out.println("Innings One Played");
        System.out.println("Please Enter Batting Order for team 2:");
        InitializationUtils.initializeTeam(match.getTeamTwo(),numberOfPlayers);
        System.out.println("Current Innings Started For Team 2");
        InitializationUtils.initializeInnings(match,false);
        System.out.println("Batting order initialized for Team 2");
        playInnings(match);
        System.out.println("Innings Two Played");
        scoreBoardService.showResults(match);
        sc.close();
    }


    public static void playInnings(Match match) {
        int overBowlNumber = 0;
        boolean isInningsInValid = false;
        for(int i=0;i<match.getOver().length;i++)
        {
            System.out.println("Please Enter Over "+(i+1)+"");
            match.getOver()[i] = new Over();
            while (overBowlNumber < Constant.BALLS_IN_OVER)
            {
                try {
                    String ballType = sc.next();
                    Ball ball = new Ball(ballType);
                    if(ball.getBallType().equals(BallType.RUN_OUT)){
                        short runsMade = Short.parseShort(sc.next());
                        ball.setRunsMade(runsMade);
                    }
                    if(matchController.isValidBall(ball.getBallType()))
                        overBowlNumber++;
                    match.getOver()[i].addBalls(ball);
                    if(!matchController.processBallAndValidateInnings(ball,match)){
                        isInningsInValid = true;
                        break;
                    }
                }
                catch (InvalidBallTypeException e){
                    System.out.println(e.getMessage());
                }
            }
            scoreBoardService.displayScoreBoard(match);
            if(isInningsInValid)
                break;
            match.getInnings().swipeStrike();
            overBowlNumber = 0;
        }
    }
}

