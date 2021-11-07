package com.phonepe.models;

public class BowlingRecord extends Record {

    private int totalOversBowled;
    private int runsConceded;
    private int totalWickets;
    private double economy;
    private int maidenOvers;
    private int dotBalls;

    public BowlingRecord(BowlingRecord.Builder builder) {
        this.totalOversBowled = builder.totalOversBowled;
        this.runsConceded = builder.runsConceded;
        this.totalWickets = builder.totalWickets;
        this.economy = builder.economy;
        this.maidenOvers = builder.maidenOvers;
        this.dotBalls = builder.dotBalls;
    }

    @Override
    public void showRecords() {
        System.out.println(totalOversBowled + "\t" +runsConceded + "\t" +totalWickets + "\t" +economy +"\t" +maidenOvers);
    }


    public static final class Builder {
        private int totalOversBowled;
        private int runsConceded;
        private int totalWickets;
        private double economy;
        private int maidenOvers;
        private int dotBalls;

        public Builder() {
        }

        public BowlingRecord.Builder totalOvers(int totalOversBowled) {
            this.totalOversBowled = totalOversBowled;
            return this;
        }

        public BowlingRecord.Builder runsConceded(int runsConceded) {
            this.runsConceded = runsConceded;
            return this;
        }

        public BowlingRecord.Builder totalWickets(int totalWickets) {
            this.totalWickets = totalWickets;
            return this;
        }

        public BowlingRecord.Builder economy(double economy) {
            this.economy = economy;
            return this;
        }

        public BowlingRecord.Builder maidenOvers(int maidenOvers) {
            this.maidenOvers = maidenOvers;
            return this;
        }

        public BowlingRecord.Builder dotBalls(int dotBalls) {
            this.dotBalls = dotBalls;
            return this;
        }

        public BowlingRecord build() {
            return new BowlingRecord(this);
        }

    }

    public void updateRunsConceded(int runsConceded){
        this.runsConceded = this.runsConceded + runsConceded;
    }
}
