package com.lin.horse;

import com.lin.utils.ArrayUtils;

import java.util.ArrayList;

public class MainApp {

    private static RaceHorse[] yourHorses;
    private static RaceHorse[] computerHorses;
    private static ArrayList<RaceRateRecord>  rateTable=new ArrayList<RaceRateRecord>();

    private void initHorsesAndRate(){
        yourHorses=new RaceHorse[3];
        yourHorses[0]=new RaceHorse("Your001",HorseLevel.TOP,99);
        yourHorses[1]=new RaceHorse("Your002",HorseLevel.MEDIUM,49);
        yourHorses[2]=new RaceHorse("Your003",HorseLevel.LOW,19);

        computerHorses=new RaceHorse[3];
        computerHorses[0]=new RaceHorse("Computer001",HorseLevel.TOP,98);
        computerHorses[1]=new RaceHorse("Computer002",HorseLevel.MEDIUM,48);
        computerHorses[2]=new RaceHorse("Computer003",HorseLevel.LOW,18);


        for(int i=0;i<yourHorses.length;i++){
            for(int k=0;k<computerHorses.length;k++){
                rateTable.add( new RaceRateRecord(computerHorses[k].getNumber(),yourHorses[i].getNumber(),0));
            }
        }

    }

    /**
     * Select the good horse
     * @param opponent
     * @param yours
     * @return
     */

    private RaceHorse chooseHorse(RaceHorse opponent, RaceHorse[] yours) {
        RaceHorse selectedHorse = null;
        int currenWinRate = -10000;

        for (int i = 0; i < rateTable.size(); i++) {
            RaceRateRecord raceRateRecord = rateTable.get(i);
            if (opponent.getNumber().equals(raceRateRecord.getYourHorseNumber()) &&raceRateRecord.getWinRate() > currenWinRate) {
                RaceHorse current = getHorseByNumber(yours, raceRateRecord.getComputerHorseNumber());
                if (!current.isRaced()) {
                    selectedHorse = current;
                    currenWinRate = raceRateRecord.getWinRate();
                }
            }

        }


        return selectedHorse;
    }


    private RaceHorse getHorseByNumber(RaceHorse[] horses, String number){
        for(int i=0;i<horses.length;i++){
            if(number.equals(horses[i].getNumber())){
                return horses[i];
            }
        }
        return null;
    }

    private void race() {

        for(int k=0;k<yourHorses.length;k++){
            yourHorses[k].setRaced(false);
        }
        for(int k=0;k<computerHorses.length;k++){
            computerHorses[k].setRaced(false);
        }

        int computerWinCounts=0;
        RaceHorse[] selectedHorses= new RaceHorse[3];
        System.out.println("Race begin now...");
        for (int index = 0; index < yourHorses.length; index++) {
            boolean computerWin=false;
            System.out.print("Round "+(index+1)+">>>>");
            System.out.print("Your Horse:"+yourHorses[index].toString());
            RaceHorse selectedHorse=chooseHorse(yourHorses[index], computerHorses);
            selectedHorses[index]=selectedHorse;
            System.out.print("        Computer Horse:"+selectedHorse.toString());

            if(selectedHorse.getLevel().value()>yourHorses[index].getLevel().value()){
                computerWin=true;
            }else if (selectedHorse.getLevel().value()==yourHorses[index].getLevel().value()){
                if(selectedHorse.getSpeed()>yourHorses[index].getSpeed()){
                    computerWin=true;
                }
            }

            selectedHorse.setRaced(true);

            if(computerWin){
                computerWinCounts++;
                System.out.println("   Computer Win!");
            }else{
                System.out.println("   You Win!");
            }

        }

        if(computerWinCounts>=2){
            System.out.println("Final Winner: Computer");
            updateRateTable(yourHorses,selectedHorses,1);
        }else{
            System.out.println("Final Winner: Your");
            updateRateTable(yourHorses,selectedHorses,-1);

        }

        System.out.println("Race End");

    }

    private void updateRateTable(RaceHorse[] opponet,RaceHorse[] computer,int delta){

        for (int i = 0; i < rateTable.size(); i++) {
            RaceRateRecord raceRateRecord = rateTable.get(i);
            for(int k=0;k<opponet.length;k++){
                if(raceRateRecord.getYourHorseNumber().equals(opponet[k].getNumber())
                        && raceRateRecord.getComputerHorseNumber().equals(computer[k].getNumber())){
                    raceRateRecord.setWinRate(raceRateRecord.getWinRate()+delta);
                }
            }

        }
    }


    public static void main(String[] args) {

        MainApp mainApp=new MainApp();
        mainApp.initHorsesAndRate();


        for (int k=0;k<100;k++) {
            ArrayUtils.randomArray(yourHorses);
            mainApp.race();
        }


    }
}
