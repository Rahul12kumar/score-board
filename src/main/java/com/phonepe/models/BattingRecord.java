package com.phonepe.models;

import com.phonepe.utils.Utils;

public class BattingRecord extends Record{

    private int runs;
    private double strikeRate;
    private int balls;
    private int numberOfFours;
    private int numberOfSixes;

    public BattingRecord(Builder builder) {
        this.runs = builder.runs;
        this.strikeRate = builder.strikeRate;
        this.balls = builder.balls;
        this.numberOfFours = builder.numberOfFours;
        this.numberOfSixes = builder.numberOfSixes;
    }

    @Override
    public void showRecords() {
        System.out.println(runs + "\t" +numberOfFours + "\t" +numberOfSixes + "\t" +balls);
    }


    public static final class Builder {
        private int runs;
        private double strikeRate;
        private int balls;
        private int numberOfFours;
        private int numberOfSixes;

        public Builder() {
        }

        public Builder runs(int runs) {
            this.runs = runs;
            return this;
        }

        public Builder strikeRate(double strikeRate) {
            this.strikeRate = strikeRate;
            return this;
        }

        public Builder balls(int balls) {
            this.balls = balls;
            return this;
        }

        public Builder fours(int numberOfFours) {
            this.numberOfFours = numberOfFours;
            return this;
        }

        public Builder sixes(int numberOfSixes) {
            this.numberOfSixes = numberOfSixes;
            return this;
        }

        public BattingRecord build() {
            return new BattingRecord(this);
        }

    }

    public void updateStat(int score,boolean isFour, boolean isSix){
        this.incrementBall();
        this.runs = this.runs+score;
        if(isFour)
            this.numberOfFours = this.numberOfFours+1;
        if(isSix)
            this.numberOfSixes = this.numberOfSixes+1;
    }

    public void incrementBall(){
        this.balls = this.balls+1;
    }

    public float getStrikeRate() {
        return Utils.RoundOffUpToTwoPlaces(runs,balls)*100;
    }
}
