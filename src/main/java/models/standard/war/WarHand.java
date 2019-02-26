package models.standard.war;

import models.Hand;
import models.standard.StandardPlayingCard;

import java.util.Stack;

public class WarHand extends Hand<StandardPlayingCard, Stack<StandardPlayingCard>> {

    private Stack<StandardPlayingCard> cards = new Stack<>();

    public Stack<StandardPlayingCard> getCards() {
        return cards;
    }

    public void addCard(StandardPlayingCard card) {
        cards.add(card);
    }

    public int size() {
        return cards.size();
    }
}
