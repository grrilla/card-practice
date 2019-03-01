package models.standard.war;

import models.Deck;
import models.Player;
import models.standard.StandardPlayingCard;

import java.util.Stack;

public class WarPlayer extends Player<StandardPlayingCard, WarHand> {

    public WarPlayer() {
        super(new WarHand());
    }

    private int playValue;
    private StandardPlayingCard currentCard;
    private Stack<StandardPlayingCard> playedCards = new Stack<>();
    private static final int ACE_VALUE = 14;

    public int getPlayValue() {
        return playValue;
    }
    public StandardPlayingCard getCurrentCard() { return playedCards.pop(); }

    public void draw(Deck<StandardPlayingCard> deck) {
        hand.addCard(deck.draw());
    }

    public void play() {
        StandardPlayingCard playedCard = hand.getCards().pop();
        updatePlayValuation(playedCard.getRank());
        playedCards.add(playedCard);
    }

    private void updatePlayValuation(StandardPlayingCard.StandardRank rank) {
        int value = rank.getValue();
        playValue = value;
    }
}
