package models.tarot;

public class MinorArcanaCard extends TarotCard<MinorArcanaRank, MinorArcanaSuit> {

  public MinorArcanaCard(MinorArcanaRank rank, MinorArcanaSuit suit) {
    super(rank, suit);
  }

  public String getMeaning() {
    return this.getRank().getMeaning() + " " + this.getSuit().getMeaning();
  }
}
