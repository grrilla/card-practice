package models;

import models.MinorArcanaCard.MinorArcanaRank;
import models.MinorArcanaCard.MinorArcanaSuit;
import org.junit.Test;

import java.util.Stack;

import static models.MinorArcanaCard.MinorArcanaSuit.CUPS;
import static models.MinorArcanaCard.MinorArcanaSuit.PENTACLES;
import static models.MinorArcanaCard.MinorArcanaSuit.SWORDS;
import static models.MinorArcanaCard.MinorArcanaSuit.WANDS;
import static models.MinorArcanaCardTest.assertAllRanksOfGivenSuitArePresent;
import static org.junit.Assert.assertEquals;

public class TarotCardTest {

  @Test
  public void testEveryTarotCardCanBeRepresented() {
    Stack<PlayingCard> stackOfTarotPlayingCards = new Stack<>();

    for (MinorArcanaSuit s : MinorArcanaSuit.values()) {
      for (MinorArcanaRank r : MinorArcanaRank.values()) {
        stackOfTarotPlayingCards.push(new MinorArcanaCard(r, s));
      }
    }

    for (MajorArcanaSuit s : MajorArcanaSuit.values()) {
      for (MajorArcanaRank r : MajorArcanaRank.values()) {
        stackOfTarotPlayingCards.push(new MajorArcanaCard(r, s));
      }
    }

    assertEquals(78, stackOfTarotPlayingCards.size());

    assertMinorArcanaIsPresent(stackOfTarotPlayingCards);
    assertMajorArcanaIsPresent(stackOfTarotPlayingCards);
  }

  private void assertMinorArcanaIsPresent(Stack<PlayingCard> stackOfTarotPlayingCards) {
    assertAllRanksOfGivenSuitArePresent(stackOfTarotPlayingCards, SWORDS);
    assertAllRanksOfGivenSuitArePresent(stackOfTarotPlayingCards, PENTACLES);
    assertAllRanksOfGivenSuitArePresent(stackOfTarotPlayingCards, WANDS);
    assertAllRanksOfGivenSuitArePresent(stackOfTarotPlayingCards, CUPS);
  }

  private void assertMajorArcanaIsPresent(Stack<PlayingCard> stackOfTarotPlayingCards) {
  }
}