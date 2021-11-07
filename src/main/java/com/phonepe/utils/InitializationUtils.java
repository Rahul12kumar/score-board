package com.phonepe.utils;

import com.phonepe.config.ScannerSingleton;
import com.phonepe.models.Innings;
import com.phonepe.models.Match;
import com.phonepe.models.Player;
import com.phonepe.models.Team;

import java.util.Scanner;

public class InitializationUtils {

    public static void initializeTeam(Team team, int numberOfPlayers){
        Scanner sc = ScannerSingleton.getInstance();
        for(int i=0;i<numberOfPlayers;i++){
            String playerName = sc.next();
            Player player = new Player(playerName);
            team.addPlayer(player);
        }
    }

    public static void initializeInnings(Match match,boolean first){
        Innings innings;
        if(first) {
            innings = new Innings(match.getTeamOne(), match.getTeamTwo());
            innings.setSecondInnings(false);
        }
        else{
            innings = new Innings(match.getTeamTwo(), match.getTeamOne());
            innings.setSecondInnings(true);
        }
        match.setInnings(innings);
    }
}
