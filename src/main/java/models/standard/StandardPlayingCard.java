package models.standard;

import models.PlayingCard;
import models.Rank;
import models.Suit;

public class StandardPlayingCard extends PlayingCard {

  public StandardPlayingCard(Rank rank, Suit suit) {
    super(rank, suit);
  }

  public enum StandardSuit implements Suit {
    DIAMONDS,
    CLUBS,
    HEARTS,
    SPADES
  }

  public enum StandardRank implements Rank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING
  }
}
