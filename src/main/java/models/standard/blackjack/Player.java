package models.standard.blackjack;

import models.Deck;
import models.standard.StandardPlayingCard;

public class Player {

  private Hand hand = new Hand();

  public Hand getHand() {
    return hand;
  }

  public void draw(Deck<StandardPlayingCard> deck) {
    hand.addCard(deck.draw());
  }
}
