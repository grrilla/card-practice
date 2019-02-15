package models;

import java.util.Objects;

public abstract class PlayingCard {

  private Rank rank;
  private Suit suit;

  protected PlayingCard(Rank rank, Suit suit) {
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
    PlayingCard playingCard = (PlayingCard) o;
    return rank == playingCard.rank && suit == playingCard.suit;
  }

  public int hashCode() {
    return Objects.hash(rank, suit);
  }

  public String toString() {
    return rank + " of " + suit;
  }
}
