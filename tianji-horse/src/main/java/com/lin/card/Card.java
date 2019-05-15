package com.lin.card;

public class Card {
    private String name;
    private int value;
    private CardType type;

    private boolean raced;

    public Card(String name, int value, CardType type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public boolean isRaced() {
        return raced;
    }

    public void setRaced(boolean raced) {
        this.raced = raced;
    }

    @Override
    public String toString() {
        return name+":"+value;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getName().equals(((Card)obj).getName());
    }
}
