package models.standard.war;

import models.Deck;
import models.Player;
import models.standard.StandardPlayingCard;

public class WarPlayer extends Player<StandardPlayingCard, WarHand> {

    public WarPlayer() {
        super(new WarHand());
    }

    public void draw(Deck<StandardPlayingCard> deck) {
        hand.addCard(deck.draw());
    }
}
