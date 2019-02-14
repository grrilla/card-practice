package models;

import static models.MajorArcanaCard.MajorArcanaRank.*;

/**
 * We're going to get a little "fancier" with this class.
 *
 * If we think about it, a Major Arcana card has a rank and suit, but they're correlative;
 * you will never see The Magician not have a rank of 1, for example. Therefore, we should construct
 * them in such a way that this relationship is represented and enforced.
 *
 * Be sure to have a look at the test class as well. Compare it to the others - notice the similarities
 * but also improvements due to this class' exceptional nature. Also notice that while we know certain
 * things to be true about the Major Arcana, we are still acknowledging and leveraging the fact that it
 * is inherently a PlayingCard by nature and using inheritance to construct our ordered universe.
 */
public class MajorArcanaCard extends TarotCard {

  /**
   * This constructor is a break from the usual pattern of taking rank and suit and passing them
   * up to the parent. I only actually need to know one to infer the other. Therefore, I'm only asking
   * for the "suit", which I'm generalizing with the name "arcana".
   *
   * @param arcana The MajorArcana this object represents (the enum directly below)
   */
  public MajorArcanaCard(MajorArcana arcana) {
    super(arcana.getRank(), arcana);
  }

  /**
   * I'm using this Suit as the base for this object, but you could just as easily use
   * the Rank. The important thing is that one uses a constructor to forge the bond it's
   * members has with the other. While I'm at it, why not include a human readable version of
   * the name. Is there anywhere else we could be doing this? Can you guess at some other
   * things we'll be adding to this enum in order to write a main() that does readings?
   */
  public enum MajorArcana implements Suit {
    FOOL(O, "The Fool"),
    MAGICIAN(I, "The Magician"),
    HIGH_PRIESTESS(II, "High Priestess"),
    EMPRESS(III, "The Empress"),
    EMPEROR(IV, "The Emperor"),
    HIEROPHANT(V, "The Hierophant"),
    LOVERS(VI, "The Lovers"),
    CHARIOT(VII, "The Chariot"),
    STRENGTH(VIII, "Strength"),
    HERMIT(IX, "The Hermit"),
    WHEEL_OF_FORTUNE(X, "The Wheel of Fortune"),
    JUSTICE(XI, "Justice"),
    HANGED_MAN(XII, "The Hanged Man"),
    DEATH(XIII, "Death"),
    TEMPERANCE(XIV, "Temperance"),
    DEVIL(XV, "The Devil"),
    TOWER(XVI, "The Tower"),
    STAR(XVII, "The Star"),
    MOON(XVIII, "The Moon"),
    SUN(XIX, "The Sun"),
    JUDGEMENT(XX, "Judgement"),
    WORLD(XXI, "The World");

    private final MajorArcanaRank rank;
    private final String name;

    MajorArcana(MajorArcanaRank rank, String name) {
      this.rank = rank;
      this.name = name;
    }

    public MajorArcanaRank getRank() {
      return rank;
    }

    public String getName() {
      return name;
    }
  }

  /**
   * This Rank enum may seem less important since it just gets pulled in via the Suit enum
   * during construction, but we absolutely still need it. Recall that a PlayingCard has
   * to have a Suit property and Rank property,m and that we reference them constantly in
   * our tests. The class may do us favours in terms of constructing the object in a
   * consistent way, but we still want to have granular access to the card's properties.
   *
   * One example of this is suggested by the addition of a integer value property. What other
   * objects might find this useful? Why? Should all Ranks have a numeric value property? How
   * do we enforce that?
   */
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

  /**
   * I went to the trouble of making a prettified version of each MajorArcana's name, but
   * what good is that if we call PlayingCard::toString and it prints "I of The Magician"?
   * For all children up until now, PlayingCard::toString worked well, but it's time to write
   * another override, I think.
   *
   * PlayingCard::getSuit returns a Suit, which doesn't have getName() on it. I need to let
   * the compiler know the Suit I'm getting is a MajorArcana specifically, since the Suit for
   * this class will always be such. For this, we use a type cast.
   */
  public String toString() {
    return this.getRank().toString() + ": " + ((MajorArcana) this.getSuit()).getName();
  }
}
