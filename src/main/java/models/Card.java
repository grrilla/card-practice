package models;

import java.util.Objects;

public class Card {

  public enum Rank {
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

  public enum Suit {
    DIAMONDS,
    CLUBS,
    HEARTS,
    SPADES
  }

  private Rank rank;
  private Suit suit;

  // should be used for testing purposes only
  public Card() {
    this.rank = Rank.ACE;
    this.suit = Suit.SPADES;
  }

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return rank == card.rank && suit == card.suit;
  }

  public int hashCode() {
    return Objects.hash(rank, suit);
  }

  @Override
  public String toString() {
    return rank + " of " + suit;
  }
}
