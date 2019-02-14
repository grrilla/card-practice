package models;

public class MajorArcanaCard extends TarotCard {

  public MajorArcanaCard(MajorArcanaRank rank, Suit suit) {
    super(rank, suit);
  }

  public enum MajorArcanaSuit implements Suit {
    FOOL,
    MAGICIAN,
    HIGH_PRIESTESS,
    EMPRESS,
    EMPEROR,
    HIEROPHANT,
    LOVERS,
    CHARIOT,
    STRENGTH,
    HERMIT,
    WHEEL_OF_FORTUNE,
    JUSTICE,
    THE_HANGED_MAN,
    DEATH,
    TEMPERANCE,
    DEVIL,
    THE_TOWER,
    THE_STAR,
    THE_MOON,
    THE_SUN,
    JUDGEMENT,
    THE_WORLD
  }

  public enum MajorArcanaRank implements Rank {
    O,
    I,
    II,
    III,
    IV,
    V,
    VI,
    VII,
    VIII,
    IX,
    X,
    XI,
    XII,
    XIII,
    XIV,
    XV,
    XVI,
    XVII,
    XVIII,
    XIX,
    XX,
    XXI
  }
}
