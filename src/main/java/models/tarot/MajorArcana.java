package models.tarot;

import models.Suit;

import static models.tarot.MajorArcanaNumeral.*;

public enum MajorArcana implements Suit {
    FOOL(O, "The Fool", "awareness"),
    MAGICIAN(I, "The Magician", "attention"),
    HIGH_PRIESTESS(II, "High Priestess", "memory"),
    EMPRESS(III, "The Empress", "imagination"),
    EMPEROR(IV, "The Emperor", "reason"),
    HIEROPHANT(V, "The Hierophant", "intuition"),
    LOVERS(VI, "The Lovers", "discrimination"),
    CHARIOT(VII, "The Chariot", "receptivity"),
    STRENGTH(VIII, "Strength", "courage"),
    HERMIT(IX, "The Hermit", "exemplification"),
    WHEEL_OF_FORTUNE(X, "The Wheel of Fortune", "cycles"),
    JUSTICE(XI, "Justice", "unfailing justice"),
    HANGED_MAN(XII, "The Hanged Man", "a change in thinking"),
    DEATH(XIII, "Death", "a change in behaviour"),
    TEMPERANCE(XIV, "Temperance", "verification"),
    DEVIL(XV, "The Devil", "materialism"),
    TOWER(XVI, "The Tower", "awakening"),
    STAR(XVII, "The Star", "meditation"),
    MOON(XVIII, "The Moon", "deception"),
    SUN(XIX, "The Sun", "expansion"),
    JUDGEMENT(XX, "Judgement", "realization"),
    WORLD(XXI, "The World", "completion");

    private final MajorArcanaNumeral rank;
    private final String name;
    private String meaning;

    MajorArcana(MajorArcanaNumeral rank, String name, String meaning) {
        this.rank = rank;
        this.name = name;
        this.meaning = meaning;
    }

    public MajorArcanaNumeral getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public String getMeaning() {
        return meaning;
    }
}

