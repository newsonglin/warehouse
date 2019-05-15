package com.lin.horse;

public class RaceRateRecord
{
    private String computerHorseNumber;
    private String yourHorseNumber;
    private int winRate=0;

    public RaceRateRecord(String computerHorseNumber, String yourHorseNumber, int winRate) {
        this.computerHorseNumber = computerHorseNumber;
        this.yourHorseNumber = yourHorseNumber;
        this.winRate = winRate;
    }

    public String getComputerHorseNumber() {
        return computerHorseNumber;
    }

    public void setComputerHorseNumber(String computerHorseNumber) {
        this.computerHorseNumber = computerHorseNumber;
    }

    public String getYourHorseNumber() {
        return yourHorseNumber;
    }

    public void setYourHorseNumber(String yourHorseNumber) {
        this.yourHorseNumber = yourHorseNumber;
    }

    public int getWinRate() {
        return winRate;
    }

    public void setWinRate(int winRate) {
        this.winRate = winRate;
    }

    @Override
    public String toString() {
        return yourHorseNumber+":"+computerHorseNumber+":"+winRate;
    }
}
