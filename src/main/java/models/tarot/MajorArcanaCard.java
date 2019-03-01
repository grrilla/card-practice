package models.tarot;

public class MajorArcanaCard extends TarotCard<MajorArcanaNumeral, MajorArcana> {

  public MajorArcanaCard(MajorArcana arcana) {
    super(arcana.getRank(), arcana);
  }

  public String getMeaning() {
    return this.getSuit().getMeaning();
  }

  public String toString() {
    return this.getRank().toString() + ": " + this.getSuit().getName();
  }
}