package models.tarot;

import models.Rank;

public enum MinorArcanaRank implements Rank {
    ACE(1, "the start of"),
    TWO(2, "the joining of"),
    THREE(3, "a celebration of"),
    FOUR(4, "a stagnation of"),
    FIVE(5, "a betrayal of"),
    SIX(6, "a success in"),
    SEVEN(7, "a forced departure from"),
    EIGHT(8, "a selective departue from"),
    NINE(9, "a sudden rise in"),
    TEN(10, "a sustained pattern of"),
    PAIGE(11, "a naive perspective on"),
    KNIGHT(12, "a person relating to"),
    QUEEN(13, "a harmonious relationship with"),
    KING(14, "a strong control over");

    private int value;
    private String meaning;

    MinorArcanaRank(int value, String meaning) {
        this.value = value;
        this.meaning = meaning;
    }

    public int getValue() {
        return value;
    }

    public String getMeaning() {
        return meaning;
    }
}

