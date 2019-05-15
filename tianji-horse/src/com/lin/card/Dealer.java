package com.lin.card;

import com.lin.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

    private List<Card> cards;

    private void _initCards() {
        cards = new ArrayList<>();
        for (int k = 1; k < 14; k++) {
            if (k == 1) {
                cards.add(new Card("Acer", k + 13, CardType.Clubs));
            } else if (k == 2) {
                cards.add(new Card("Two", k + 13, CardType.Clubs));
            } else if (k == 11) {
                cards.add(new Card("Jack", k , CardType.Clubs));
            } else if (k == 12) {
                cards.add(new Card("Queen", k , CardType.Clubs));
            } else if (k == 13) {
                cards.add(new Card("King", k , CardType.Clubs));
            } else {
                cards.add(new Card(String.valueOf(k), k, CardType.Clubs));
            }
        }
    }

    public Dealer() {
        _initCards();
    }

    /**
     * Get certain amount cards in random order
     * @param amount the card amount
     * @return a list
     */
    public Card[] getRandomCards(int amount){
        if(amount>cards.size()){
            System.out.println("amount = [" + amount + "] exceed all cards size "+cards.size());
            return null;
        }
        Card[] cardArray= new Card[amount];
        for(int k=0;k<amount;k++){
            cardArray[k]=cards.get(k);
        }
        ArrayUtils.randomArray(cardArray);

        return cardArray;
    }

}
