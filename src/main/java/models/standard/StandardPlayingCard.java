package models.standard;

import models.PlayingCard;
import models.Rank;
import models.Suit;

import static java.lang.Integer.compare;

public class StandardPlayingCard extends PlayingCard<StandardPlayingCard.StandardRank, StandardPlayingCard.StandardSuit> implements Comparable<StandardPlayingCard> {

  public StandardPlayingCard(StandardRank rank, StandardSuit suit) {
    super(rank, suit);
  }

  public enum StandardSuit implements Suit {
    DIAMONDS,
    CLUBS,
    HEARTS,
    SPADES
  }

  public enum StandardRank implements Rank {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    private int value;

    StandardRank(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  public int compareTo(StandardPlayingCard card) {
    return compare(this.getRank().getValue(), card.getRank().getValue());
  }
}