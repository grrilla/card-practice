package models;

import static models.StandardPlayingCard.StandardRank.ACE;
import static models.StandardPlayingCard.StandardSuit.SPADES;

public class StandardPlayingCard extends PlayingCard {

  public StandardPlayingCard() {
    super(ACE, SPADES);
  }

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
