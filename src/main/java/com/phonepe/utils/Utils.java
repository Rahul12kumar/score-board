package com.phonepe.utils;

public class Utils {

    public static float RoundOffUpToTwoPlaces(int x,int y){
        return (float) Math.round(((float) x / y) * 100) / 100;
    }

    public static String calculateTotalOvers(int numbersOfBallsPlayed) {
        int ballsInLastOver = numbersOfBallsPlayed%6;
        int ballsLeft = (numbersOfBallsPlayed-ballsInLastOver)/Constant.BALLS_IN_OVER;
        return ballsLeft + "." + ballsInLastOver;
    }
}
