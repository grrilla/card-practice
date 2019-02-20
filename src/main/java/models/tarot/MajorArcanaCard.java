package models.tarot;

import models.Rank;
import models.Suit;

import static models.tarot.MajorArcanaCard.MajorArcanaRank.I;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.II;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.III;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.IV;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.IX;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.O;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.V;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.VI;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.VII;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.VIII;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.X;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.XI;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.XII;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.XIII;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.XIV;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.XIX;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.XV;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.XVI;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.XVII;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.XVIII;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.XX;
import static models.tarot.MajorArcanaCard.MajorArcanaRank.XXI;

public class MajorArcanaCard extends TarotCard {

  public MajorArcanaCard(MajorArcana arcana) {
    super(arcana.getRank(), arcana);
  }

  public enum MajorArcana implements Suit {
    FOOL(O, "The Fool", "awareness"),
    MAGICIAN(I, "The Magician", "attention"),
    HIGH_PRIESTESS(II, "High Priestess", "memory"),
    EMPRESS(III, "The Empress", "imagination"),
    EMPEROR(IV, "The Emperor", "reason"),
    HIEROPHANT(V, "The Hierophant", "intuition"),
    LOVERS(VI, "The Lovers", "discrimination"),
    CHARIOT(VII, "The Chariot", "receptivity"),
    STRENGTH(VIII, "Strength", "courage"),
    HERMIT(IX, "The Hermit", "exemplification"),
    WHEEL_OF_FORTUNE(X, "The Wheel of Fortune", "cycles"),
    JUSTICE(XI, "Justice", "unfailing justice"),
    HANGED_MAN(XII, "The Hanged Man", "a change in thinking"),
    DEATH(XIII, "Death", "a change in behaviour"),
    TEMPERANCE(XIV, "Temperance", "verification"),
    DEVIL(XV, "The Devil", "materialism"),
    TOWER(XVI, "The Tower", "awakening"),
    STAR(XVII, "The Star", "meditation"),
    MOON(XVIII, "The Moon", "deception"),
    SUN(XIX, "The Sun", "expansion"),
    JUDGEMENT(XX, "Judgement", "realization"),
    WORLD(XXI, "The World", "completion");

    private final MajorArcanaRank rank;
    private final String name;
    private String meaning;

    MajorArcana(MajorArcanaRank rank, String name, String meaning) {
      this.rank = rank;
      this.name = name;
      this.meaning = meaning;
    }

    public MajorArcanaRank getRank() {
      return rank;
    }

    public String getName() {
      return name;
    }

    public String getMeaning() {
      return meaning;
    }
  }

  public enum MajorArcanaRank implements Rank {
    O(0),
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10),
    XI(11),
    XII(12),
    XIII(13),
    XIV(14),
    XV(15),
    XVI(16),
    XVII(17),
    XVIII(18),
    XIX(19),
    XX(20),
    XXI(21);

    private final int value;

    MajorArcanaRank(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  public String getMeaning() {
    return ((MajorArcana) this.getSuit()).getMeaning();
  }

  public String toString() {
    return this.getRank().toString() + ": " + ((MajorArcana) this.getSuit()).getName();
  }
}
