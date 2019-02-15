package models.tarot;

import models.PlayingCard;
import models.Rank;
import models.Suit;

public abstract class TarotCard extends PlayingCard {

  public TarotCard(Rank rank, Suit suit) {
    super(rank, suit);
  }
}
