package models;

public class MinorArcanaCard extends TarotCard {

  public MinorArcanaCard(MinorArcanaRank rank, Suit suit) {
    super(rank, suit);
  }

  public enum MinorArcanaSuit implements Suit {
    PENTACLES,
    WANDS,
    CUPS,
    SWORDS
  }

  public enum MinorArcanaRank implements Rank {
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
    PAIGE,
    KNIGHT,
    QUEEN,
    KING
  }
}
