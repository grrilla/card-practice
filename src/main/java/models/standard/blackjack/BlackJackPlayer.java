package models.standard.blackjack;

import models.Deck;
import models.Player;
import models.standard.StandardPlayingCard;

public class BlackJackPlayer extends Player<StandardPlayingCard, BlackJackHand> {

  public BlackJackPlayer() {
    super(new BlackJackHand());
  }

  public void draw(Deck<StandardPlayingCard> deck) {
    hand.addCard(deck.draw());
  }
}

