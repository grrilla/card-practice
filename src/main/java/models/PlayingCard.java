package models;

import java.util.Objects;

public abstract class PlayingCard<R extends Rank, S extends Suit> {

  private R rank;
  private S suit;

  protected PlayingCard(R rank, S suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public R getRank() {
    return rank;
  }

  public S getSuit() {
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
