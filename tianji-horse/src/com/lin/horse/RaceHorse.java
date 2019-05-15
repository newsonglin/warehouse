package com.lin.horse;

public class RaceHorse {
    private String number;
    private HorseLevel level;
    private int speed;
    private boolean raced;

    public RaceHorse(String number,HorseLevel level, int speed){

        this.number=number;
        this.level=level;
        this.speed=speed;
    }

    @Override
    public String toString() {
        return this.number+":"+this.level.levelName()+":"+this.speed;
    }

    public HorseLevel getLevel() {
        return level;
    }

    public void setLevel(HorseLevel level) {
        this.level = level;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isRaced() {
        return raced;
    }

    public void setRaced(boolean raced) {
        this.raced = raced;
    }
}
