package models;

import models.MajorArcanaCard.MajorArcana;
import models.MinorArcanaCard.MinorArcanaRank;
import models.MinorArcanaCard.MinorArcanaSuit;
import org.junit.Test;

import java.util.Stack;

import static models.MajorArcanaCardTest.assertAllMajorArcanaCardsArePresent;
import static models.MinorArcanaCard.MinorArcanaSuit.CUPS;
import static models.MinorArcanaCard.MinorArcanaSuit.PENTACLES;
import static models.MinorArcanaCard.MinorArcanaSuit.SWORDS;
import static models.MinorArcanaCard.MinorArcanaSuit.WANDS;
import static models.MinorArcanaCardTest.assertAllRanksOfGivenSuitArePresent;
import static org.junit.Assert.assertEquals;

public class TarotCardTest {

  @Test
  public void testEveryTarotCardCanBeRepresented() {
    Stack<PlayingCard> cardStack = new Stack<>();

    // load up the minors
    for (MinorArcanaSuit s : MinorArcanaSuit.values()) {
      for (MinorArcanaRank r : MinorArcanaRank.values()) {
        cardStack.push(new MinorArcanaCard(r, s));
      }
    }

    // load up the majors
    for (MajorArcana a : MajorArcana.values()) {
      cardStack.push(new MajorArcanaCard(a));
    }

    assertEquals(78, cardStack.size());
    assertMinorArcanaIsPresent(cardStack);
    assertAllMajorArcanaCardsArePresent(cardStack);
  }

  private static void assertMinorArcanaIsPresent(Stack<PlayingCard> cardStack) {
    assertAllRanksOfGivenSuitArePresent(cardStack, SWORDS);
    assertAllRanksOfGivenSuitArePresent(cardStack, PENTACLES);
    assertAllRanksOfGivenSuitArePresent(cardStack, WANDS);
    assertAllRanksOfGivenSuitArePresent(cardStack, CUPS);
  }
}