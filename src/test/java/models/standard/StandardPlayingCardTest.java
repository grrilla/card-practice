package models.standard;

import org.junit.Test;

import java.util.Stack;

import static models.standard.StandardPlayingCard.StandardRank;
import static models.standard.StandardPlayingCard.StandardRank.*;
import static models.standard.StandardPlayingCard.StandardSuit;
import static models.standard.StandardPlayingCard.StandardSuit.*;
import static org.junit.Assert.*;

public class StandardPlayingCardTest {

  @Test
  public void testStandardPlayingCardHasSpecifiedSuitAndRank() {
    StandardPlayingCard StandardPlayingCard = new StandardPlayingCard(ACE, SPADES);
    assertEquals(ACE, StandardPlayingCard.getRank());
    assertEquals(SPADES, StandardPlayingCard.getSuit());

    StandardPlayingCard = new StandardPlayingCard(TWO, DIAMONDS);
    assertEquals(TWO, StandardPlayingCard.getRank());
    assertEquals(DIAMONDS, StandardPlayingCard.getSuit());
  }

  @Test
  public void testEveryStandardStandardPlayingCardCanBeRepresented() {
    Stack<StandardPlayingCard> stackOfStandardPlayingCards = new Stack<>();

    for (StandardSuit s : StandardSuit.values()) {
      for (StandardRank r : StandardRank.values()) {
        stackOfStandardPlayingCards.push(new StandardPlayingCard(r, s));
      }
    }

    assertEquals(52, stackOfStandardPlayingCards.size());

    assertAllRanksOfGivenSuitArePresent(stackOfStandardPlayingCards, SPADES);
    assertAllRanksOfGivenSuitArePresent(stackOfStandardPlayingCards, DIAMONDS);
    assertAllRanksOfGivenSuitArePresent(stackOfStandardPlayingCards, CLUBS);
    assertAllRanksOfGivenSuitArePresent(stackOfStandardPlayingCards, HEARTS);
  }

  static void assertAllRanksOfGivenSuitArePresent(Stack<StandardPlayingCard> stackOfStandardPlayingCards, StandardPlayingCard.StandardSuit suit) {
    assertTrue(stackOfStandardPlayingCards.search(new StandardPlayingCard(ACE, suit)) > -1);
    assertTrue(stackOfStandardPlayingCards.search(new StandardPlayingCard(TWO, suit)) > -1);
    assertTrue(stackOfStandardPlayingCards.search(new StandardPlayingCard(THREE, suit)) > -1);
    assertTrue(stackOfStandardPlayingCards.search(new StandardPlayingCard(FOUR, suit)) > -1);
    assertTrue(stackOfStandardPlayingCards.search(new StandardPlayingCard(FIVE, suit)) > -1);
    assertTrue(stackOfStandardPlayingCards.search(new StandardPlayingCard(SIX, suit)) > -1);
    assertTrue(stackOfStandardPlayingCards.search(new StandardPlayingCard(SEVEN, suit)) > -1);
    assertTrue(stackOfStandardPlayingCards.search(new StandardPlayingCard(EIGHT, suit)) > -1);
    assertTrue(stackOfStandardPlayingCards.search(new StandardPlayingCard(NINE, suit)) > -1);
    assertTrue(stackOfStandardPlayingCards.search(new StandardPlayingCard(TEN, suit)) > -1);
    assertTrue(stackOfStandardPlayingCards.search(new StandardPlayingCard(JACK, suit)) > -1);
    assertTrue(stackOfStandardPlayingCards.search(new StandardPlayingCard(QUEEN, suit)) > -1);
    assertTrue(stackOfStandardPlayingCards.search(new StandardPlayingCard(KING, suit)) > -1);
  }

  @Test
  public void testStandardPlayingCardPropertiesDetermineEquality() {
    assertEquals(new StandardPlayingCard(TWO, SPADES), new StandardPlayingCard(TWO, SPADES));
    assertNotEquals(new StandardPlayingCard(TWO, HEARTS), new StandardPlayingCard(TWO, SPADES));
  }

  @Test
  public void testStandardPlayingCardIsHumanReadable() {
    assertEquals("ACE of SPADES", new StandardPlayingCard(ACE, SPADES).toString());
  }

}