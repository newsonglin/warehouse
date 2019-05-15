package com.lin.card;

public enum CardType {
    Spades("黑桃"),
    Hearts("红心"),
    Diamonds("方块"),
    Clubs("草花");

    CardType(String typeName) {
        this.typeName = typeName;
    }

    private String typeName;

    public String typeName() {
        return typeName;
    }

}
