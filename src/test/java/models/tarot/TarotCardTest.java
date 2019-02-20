package models.tarot;

import models.PlayingCard;
import models.tarot.MajorArcanaCard.MajorArcana;
import models.tarot.MinorArcanaCard.MinorArcanaRank;
import models.tarot.MinorArcanaCard.MinorArcanaSuit;
import org.junit.Test;

import java.util.Stack;

import static models.tarot.MajorArcanaCardTest.assertAllMajorArcanaCardsArePresent;
import static models.tarot.MinorArcanaCardTest.assertAllMinorArcanaCardsArePresent;

public class TarotCardTest {

  @Test
  public void testEveryTarotCardCanBeRepresented() {
    Stack<PlayingCard> cardStack = new Stack<>();

    for (MinorArcanaSuit s : MinorArcanaSuit.values()) {
      for (MinorArcanaRank r : MinorArcanaRank.values()) {
        cardStack.push(new MinorArcanaCard(r, s));
      }
    }

    for (MajorArcana a : MajorArcana.values()) {
      cardStack.push(new MajorArcanaCard(a));
    }

    assertAllMinorArcanaCardsArePresent(cardStack);
    assertAllMajorArcanaCardsArePresent(cardStack);
  }
}