package models.tarot;

import models.Deck;
import models.Player;

public class TarotPlayer extends Player<TarotCard, TarotSpread> {

  public TarotPlayer() {
    this(new TarotSpread());
  }

  public TarotPlayer(TarotSpread hand) {
    super(hand);
  }

  public void draw(Deck<TarotCard> deck) {
    hand.addCard(deck.draw());
  }
}
