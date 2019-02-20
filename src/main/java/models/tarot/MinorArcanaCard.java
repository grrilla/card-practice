package models.tarot;

import models.Rank;
import models.Suit;

public class MinorArcanaCard extends TarotCard {

  public MinorArcanaCard(MinorArcanaRank rank, Suit suit) {
    super(rank, suit);
  }

  public enum MinorArcanaSuit implements Suit {
    PENTACLES("something to do with fortune"),
    WANDS("something to do with imagination"),
    CUPS("something to do with emotion"),
    SWORDS("something to do with challenge");

    private String meaning;

    MinorArcanaSuit(String meaning) {
      this.meaning = meaning;
    }

    public String getMeaning() {
      return meaning;
    }
  }

  public enum MinorArcanaRank implements Rank {
    ACE("the start of"),
    TWO("the joining of"),
    THREE("a celebration of"),
    FOUR("a stagnation of"),
    FIVE("a betrayal of"),
    SIX("a success in"),
    SEVEN("a forced departure from"),
    EIGHT("a selective departue from"),
    NINE("a sudden rise in"),
    TEN("a sustained pattern of"),
    PAIGE("a naive perspective on"),
    KNIGHT("a person relating to"),
    QUEEN("a harmonious relationship with"),
    KING("a strong control over");

    private String meaning;

    MinorArcanaRank(String meaning) {
      this.meaning = meaning;
    }

    public String getMeaning() {
      return meaning;
    }
  }

  public String getMeaning() {
    return ((MinorArcanaRank) this.getRank()).getMeaning() + " " + ((MinorArcanaSuit) this.getSuit()).getMeaning();
  }
}
