package models.standard.war;

import models.Deck;
import models.Player;
import models.standard.StandardPlayingCard;

public class WarPlayer extends Player<StandardPlayingCard, WarHand> {

    public WarPlayer() {
        super(new WarHand());
    }

    private int playValue;
    StandardPlayingCard currentCard;
    private static final int ACE_VALUE = 14;

    public int getPlayValue() {
        return playValue;
    }

    public void draw(Deck<StandardPlayingCard> deck) {
        hand.addCard(deck.draw());
    }

    public void play() {
        StandardPlayingCard playedCard = hand.getCards().pop();
        updatePlayValuation(playedCard.getRank());
        currentCard = playedCard;
    }

    private void updatePlayValuation(StandardPlayingCard.StandardRank rank) {
        int value = rank.getValue();
        playValue = value;
    }
}
