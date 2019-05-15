package com.lin.card;

import com.lin.utils.StringUtils;

public class CardRateRecord
{
    private Card yourCard;
    private Card computerCard;
    private double winRate=0;

    public CardRateRecord(Card yourCard, Card computerCard, double winRate) {
        this.yourCard = yourCard;
        this.computerCard = computerCard;
        this.winRate = winRate;
    }

    public Card getYourCard() {
        return yourCard;
    }

    public void setYourCard(Card yourCard) {
        this.yourCard = yourCard;
    }

    public Card getComputerCard() {
        return computerCard;
    }

    public void setComputerCard(Card computerCard) {
        this.computerCard = computerCard;
    }

    public double getWinRate() {
        return winRate;
    }

    public void setWinRate(double winRate) {
        this.winRate = winRate;
    }

    @Override
    public String toString() {
        return yourCard.getName() + StringUtils.blanks(6 - yourCard.getName().length()) + ":" + computerCard.getName()+StringUtils.blanks(6 - computerCard.getName().length()) + ":" + winRate;
    }
}
