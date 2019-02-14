package models;

import models.MinorArcanaCard.MinorArcanaSuit;
import org.junit.Test;

import java.util.Stack;

import static models.MinorArcanaCard.*;
import static models.MinorArcanaCard.MinorArcanaRank.ACE;
import static models.MinorArcanaCard.MinorArcanaRank.EIGHT;
import static models.MinorArcanaCard.MinorArcanaRank.FIVE;
import static models.MinorArcanaCard.MinorArcanaRank.FOUR;
import static models.MinorArcanaCard.MinorArcanaRank.KING;
import static models.MinorArcanaCard.MinorArcanaRank.KNIGHT;
import static models.MinorArcanaCard.MinorArcanaRank.NINE;
import static models.MinorArcanaCard.MinorArcanaRank.PAIGE;
import static models.MinorArcanaCard.MinorArcanaRank.QUEEN;
import static models.MinorArcanaCard.MinorArcanaRank.SEVEN;
import static models.MinorArcanaCard.MinorArcanaRank.SIX;
import static models.MinorArcanaCard.MinorArcanaRank.TEN;
import static models.MinorArcanaCard.MinorArcanaRank.THREE;
import static models.MinorArcanaCard.MinorArcanaRank.TWO;
import static models.MinorArcanaCard.MinorArcanaSuit.CUPS;
import static models.MinorArcanaCard.MinorArcanaSuit.PENTACLES;
import static models.MinorArcanaCard.MinorArcanaSuit.SWORDS;
import static models.MinorArcanaCard.MinorArcanaSuit.WANDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MinorArcanaCardTest {

  @Test
  public void testCreateMinorArcanaCard() {
    assertNotNull(new MinorArcanaCard());
  }

  @Test
  public void testMinorArcanaCardHasSuitAndRank() {
    MinorArcanaCard minorArcana = new MinorArcanaCard();
    assertEquals(ACE, minorArcana.getRank());
    assertEquals(SWORDS, minorArcana.getSuit());
  }

  @Test
  public void testMinorArcanaCardHasSpecifiedSuitAndRank() {
    MinorArcanaCard minorArcana = new MinorArcanaCard(ACE, SWORDS);
    assertEquals(ACE, minorArcana.getRank());
    assertEquals(SWORDS, minorArcana.getSuit());

    minorArcana = new MinorArcanaCard(TWO, PENTACLES);
    assertEquals(TWO, minorArcana.getRank());
    assertEquals(PENTACLES, minorArcana.getSuit());
  }

  @Test
  public void testEveryMinorArcanaCardCanBeRepresented() {
    Stack<PlayingCard> stackOfMinorArcanaCards = new Stack<>();

    for (MinorArcanaSuit s : MinorArcanaSuit.values()) {
      for (MinorArcanaRank r : MinorArcanaRank.values()) {
        stackOfMinorArcanaCards.push(new MinorArcanaCard(r, s));
      }
    }

    assertEquals(56, stackOfMinorArcanaCards.size());

    assertMinorArcanaIsPresent(stackOfMinorArcanaCards);
  }

  private void assertMinorArcanaIsPresent(Stack<PlayingCard> stackOfTarotPlayingCards) {
    assertAllRanksOfGivenSuitArePresent(stackOfTarotPlayingCards, SWORDS);
    assertAllRanksOfGivenSuitArePresent(stackOfTarotPlayingCards, PENTACLES);
    assertAllRanksOfGivenSuitArePresent(stackOfTarotPlayingCards, WANDS);
    assertAllRanksOfGivenSuitArePresent(stackOfTarotPlayingCards, CUPS);
  }
  
  static void assertAllRanksOfGivenSuitArePresent(Stack<PlayingCard> stackOfTarotPlayingCards, Suit suit) {
    assertTrue(stackOfTarotPlayingCards.search(new MinorArcanaCard(ACE, suit)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MinorArcanaCard(TWO, suit)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MinorArcanaCard(THREE, suit)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MinorArcanaCard(FOUR, suit)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MinorArcanaCard(FIVE, suit)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MinorArcanaCard(SIX, suit)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MinorArcanaCard(SEVEN, suit)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MinorArcanaCard(EIGHT, suit)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MinorArcanaCard(NINE, suit)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MinorArcanaCard(TEN, suit)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MinorArcanaCard(PAIGE, suit)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MinorArcanaCard(KNIGHT, suit)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MinorArcanaCard(QUEEN, suit)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MinorArcanaCard(KING, suit)) > -1);
  }

  @Test
  public void testMinorArcanaCardPropertiesDetermineEquality() {
    assertEquals(new MinorArcanaCard(), new MinorArcanaCard());
    assertEquals(new MinorArcanaCard(TWO, SWORDS), new MinorArcanaCard(TWO, SWORDS));
    assertNotEquals(new MinorArcanaCard(TWO, CUPS), new MinorArcanaCard(TWO, SWORDS));
  }

  @Test
  public void testMinorArcanaCardIsHumanReadable() {
    assertEquals("ACE of SWORDS", new MinorArcanaCard().toString());
  }
}