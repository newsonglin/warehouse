package com.lin.card;


import com.lin.utils.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class CardApp {

    private static Card[] yourCards;
    private static Card[] computerCards;
    private static ArrayList<CardRateRecord>  rateTable=new ArrayList<>();

    private void dealCards(){
        int dealCardAmount=12;
        Dealer dealer=new Dealer();
        Card[] radomCards=dealer.getRandomCards(dealCardAmount);
        yourCards=new Card[dealCardAmount/2];
        computerCards=new Card[dealCardAmount/2];

        //deal cards now
        int yourIndex=0;
        int computerIndex=0;
        for(int i=0;i<radomCards.length;i++){
            if(i%2==0){
                yourCards[yourIndex]=radomCards[i];
                yourIndex++;
            }else{
                computerCards[computerIndex]=radomCards[i];
                computerIndex++;
            }
        }

    }

    /**
     * Select the good Card
     * @param opponent
     * @param yours
     * @return
     */

    private Card chooseCard(Card opponent, Card[] yours) {
        Card selectedCard = null;
        double currenWinRate = -100000;

        for (int i = 0; i < rateTable.size(); i++) {
            CardRateRecord cardRateRecord = rateTable.get(i);
            if (opponent.equals(cardRateRecord.getYourCard())&&cardRateRecord.getWinRate() > currenWinRate) {
                Card current = cardRateRecord.getComputerCard();
                if (!cardUsed(current,yours)) {
                    selectedCard = current;
                    currenWinRate = cardRateRecord.getWinRate();
                }
            }

        }

        //Win rate has no record yet, let's choose one by random
        if(selectedCard==null){
            for(Card card:yours){
                if(!card.isRaced()){
                    return card;
                }
            }
        }else{
            for(Card card:yours){
                if(selectedCard.equals(card)){
                    return card;
                }
            }
        }


        return selectedCard;
    }

    private boolean cardUsed(Card checkCard, Card[] yours){
        for(Card card:yours){
            if(checkCard.equals(card)&&card.isRaced()){
                return true;
            }
        }
        return false;
    }


    private void race() {


        for(int k=0;k<yourCards.length;k++){
            yourCards[k].setRaced(false);
        }
        for(int k=0;k<computerCards.length;k++){
            computerCards[k].setRaced(false);
        }



        double computerWinCounts=0;
        Card[] selectedCards= new Card[computerCards.length];
        System.out.println("Race begin now...");
        for (int index = 0; index < yourCards.length; index++) {
            boolean computerWin=false;
            System.out.print("Hand "+(index+1)+">>>>");
            System.out.print("Your Card:"+yourCards[index].toString()+ StringUtils.blanks(9-yourCards[index].toString().length()));
            Card selectedCard=chooseCard(yourCards[index], computerCards);
            selectedCards[index]=selectedCard;
            System.out.print("        Computer Card:"+selectedCard.toString()+StringUtils.blanks(9-selectedCard.toString().length()));

            if(selectedCard.getValue()>yourCards[index].getValue()){
                computerWin=true;
            }
            selectedCard.setRaced(true);

            if(computerWin){
                computerWinCounts++;
                System.out.println("   Computer Win!");
            }else{
                System.out.println("   You Win!");
            }

        }

        if(computerWinCounts>=computerCards.length/2){
            System.out.println("Final Winner: Computer");
            updateRateTable(yourCards,selectedCards,1*computerWinCounts/computerCards.length);
        }else{
            System.out.println("Final Winner: You");
            updateRateTable(yourCards,selectedCards,-1*(computerCards.length-computerWinCounts)/computerCards.length);

        }

        System.out.println("Race End");

    }

    private void updateRateTable(Card[] opponet, Card[] computer, double delta) {
        for (int k = 0; k < opponet.length; k++) {
            boolean isRateExist=false;
            for (int i = 0; i < rateTable.size(); i++) {
                CardRateRecord cardRateRecord = rateTable.get(i);
                if (cardRateRecord.getYourCard().equals(opponet[k])
                        && cardRateRecord.getComputerCard().equals(computer[k])) {
                    cardRateRecord.setWinRate(cardRateRecord.getWinRate() + delta);
                    isRateExist=true;
                    break;
                }
            }
            if(!isRateExist){
                CardRateRecord cardRateRecord=new CardRateRecord(opponet[k],computer[k],delta);
                rateTable.add(cardRateRecord);
            }

        }
    }

    private void saveRateToFile(){
        //Sort rate record
        rateTable.sort((left, right) -> left.getYourCard().getValue() - right.getYourCard().getValue());
        rateTable.sort(Comparator.comparing(cardRateRecord -> cardRateRecord.getYourCard().getValue()*cardRateRecord.getComputerCard().getValue()));

        for(CardRateRecord cardRateRecord:rateTable){
            System.out.println(cardRateRecord.toString());
        }
    }

    public static void main(String[] args) {

/*        CardApp cardApp =new CardApp();


        for (int k=0;k<100000000;k++) {
            cardApp.dealCards();
            cardApp.race();
        }
        Collections.sort(rateTable, new Comparator<CardRateRecord>() {
            @Override
            public int compare(CardRateRecord o1, CardRateRecord o2) {
                if (o1.getYourCard().getValue() == o2.getYourCard().getValue()) {
                    return o1.getComputerCard().getValue() - o2.getComputerCard().getValue();
                } else {
                    return o1.getYourCard().getValue() - o2.getYourCard().getValue();
                }
            }
        });

        for(CardRateRecord cardRateRecord:rateTable){
            System.out.println(cardRateRecord.toString());
        }

        System.out.println("=========================================================");

        cardApp.dealCards();
        cardApp.race();*/

        BigDecimal b1=new BigDecimal("0.00");
        b1.setScale(2, RoundingMode.HALF_UP);
        BigDecimal b2=new BigDecimal(0);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1.equals(b2));
    }
}
