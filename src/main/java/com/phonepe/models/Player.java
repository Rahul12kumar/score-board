package com.phonepe.models;

import java.util.Objects;

public class Player extends User{

    private String countryCode;
    Record battingRecord;
    Record bowlingRecord;

    public Record getBowlingRecord() {
        return bowlingRecord;
    }

    public void setBowlingRecord(Record bowlingRecord) {
        this.bowlingRecord = bowlingRecord;
    }

    public Record getBattingRecord() {
        return battingRecord;
    }

    public void setBattingRecord(Record battingRecord) {
        this.battingRecord = battingRecord;
    }

    public Player(String name) {
        super(name);
        battingRecord = new BattingRecord.Builder().build();
        bowlingRecord = new BowlingRecord.Builder().build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(countryCode, player.countryCode) && Objects.equals(battingRecord, player.battingRecord) && Objects.equals(bowlingRecord, player.bowlingRecord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, battingRecord, bowlingRecord);
    }
}
