package models.standard.war;

import models.Deck;
import models.Player;
import models.standard.StandardPlayingCard;

public class WarPlayer extends Player<StandardPlayingCard, WarHand> {

    public WarPlayer() {
        super(new WarHand());
    }

    private int playValue;
    private static final int ACE_VALUE = 14;

    public int getPlayValue() {
        return playValue;
    }

    public void draw(Deck<StandardPlayingCard> deck) {
        hand.addCard(deck.draw());
    }

    public StandardPlayingCard play() {
        StandardPlayingCard playedCard = hand.getCards().pop();
        updateHandValuation(playedCard.getRank());
        return playedCard;
    }

    private void updateHandValuation(StandardPlayingCard.StandardRank rank) {
        int value = rank.getValue();
        playValue += value;
    }
}
