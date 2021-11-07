package com.phonepe.models;


import com.phonepe.exceptions.InvalidBallTypeException;

public class Ball {

    BallType ballType;
    private Player balledBy;
    private Player playedBy;
    private short runsMade;

    public Ball(String ballType) throws InvalidBallTypeException {
        setBallType(ballType);
    }

    public BallType getBallType() {
        return ballType;
    }

    public void setBallType(String ballType) throws InvalidBallTypeException {
        switch (ballType){
            case "W":
                this.ballType = BallType.WICKET;
                break;
            case "NB":
                this.ballType = BallType.NO_BALL;
                break;
            case "Wd":
                this.ballType = BallType.WIDE;
                break;
            default:
                try {
                    this.runsMade = Short.parseShort(ballType);
                    this.ballType = BallType.NORMAL;
                }
                catch (Exception e){
                    throw new InvalidBallTypeException("Please Enter valid Ball");
                }
        }
    }

    public Player getBalledBy() {
        return balledBy;
    }

    public void setBalledBy(Player balledBy) {
        this.balledBy = balledBy;
    }

    public Player getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(Player playedBy) {
        this.playedBy = playedBy;
    }

    public short getRunsMade() {
        return runsMade;
    }

    public void setRunsMade(short runsMade) {
        this.runsMade = runsMade;
    }

}
