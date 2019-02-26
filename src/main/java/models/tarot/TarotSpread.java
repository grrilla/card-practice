package models.tarot;

import models.Hand;

import java.util.ArrayList;

public class TarotSpread extends Hand<TarotCard, ArrayList<TarotCard>> {

    private static final int PAST_POSITION = 0;
    private static final int PRESENT_POSITION = 1;
    private static final int FUTURE_POSITION = 2;
    private static final int OVERARCHING_POSITION = 3;
    public static final int NUMBER_OF_CARDS_IN_SPREAD = 4;

    public TarotSpread() {
        super();
        hand = new ArrayList<>();
    }

    public static int getNumberOfCardsInSpread() {
        return NUMBER_OF_CARDS_IN_SPREAD;
    }

    public TarotCard getPast() {
        return hand.get(PAST_POSITION);
    }

    public TarotCard getPresent() {
        return hand.get(PRESENT_POSITION);
    }

    public TarotCard getFuture() {
        return hand.get(FUTURE_POSITION);
    }

    public TarotCard getOverArching() {
        return hand.get(OVERARCHING_POSITION);
    }

    public void addCard(TarotCard card) {
        hand.add(card);
    }
}
