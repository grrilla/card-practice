package models.standard;

import models.PlayingCard;
import models.Suit;
import models.standard.StandardPlayingCard;
import models.standard.StandardPlayingCard.StandardRank;
import models.standard.StandardPlayingCard.StandardSuit;
import org.junit.Test;

import java.util.Stack;

import static models.standard.StandardPlayingCard.StandardRank.*;
import static models.standard.StandardPlayingCard.StandardSuit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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
    Stack<PlayingCard> stackOfStandardPlayingPlayingCards = new Stack<>();

    for (StandardSuit s : StandardSuit.values()) {
      for (StandardRank r : StandardRank.values()) {
        stackOfStandardPlayingPlayingCards.push(new StandardPlayingCard(r, s));
      }
    }

    assertEquals(52, stackOfStandardPlayingPlayingCards.size());

    assertAllRanksOfGivenSuitArePresent(stackOfStandardPlayingPlayingCards, SPADES);
    assertAllRanksOfGivenSuitArePresent(stackOfStandardPlayingPlayingCards, DIAMONDS);
    assertAllRanksOfGivenSuitArePresent(stackOfStandardPlayingPlayingCards, CLUBS);
    assertAllRanksOfGivenSuitArePresent(stackOfStandardPlayingPlayingCards, HEARTS);
  }

  static void assertAllRanksOfGivenSuitArePresent(Stack<PlayingCard> stackOfStandardPlayingPlayingCards, Suit suit) {
    assertTrue(stackOfStandardPlayingPlayingCards.search(new StandardPlayingCard(ACE, suit)) > -1);
    assertTrue(stackOfStandardPlayingPlayingCards.search(new StandardPlayingCard(TWO, suit)) > -1);
    assertTrue(stackOfStandardPlayingPlayingCards.search(new StandardPlayingCard(THREE, suit)) > -1);
    assertTrue(stackOfStandardPlayingPlayingCards.search(new StandardPlayingCard(FOUR, suit)) > -1);
    assertTrue(stackOfStandardPlayingPlayingCards.search(new StandardPlayingCard(FIVE, suit)) > -1);
    assertTrue(stackOfStandardPlayingPlayingCards.search(new StandardPlayingCard(SIX, suit)) > -1);
    assertTrue(stackOfStandardPlayingPlayingCards.search(new StandardPlayingCard(SEVEN, suit)) > -1);
    assertTrue(stackOfStandardPlayingPlayingCards.search(new StandardPlayingCard(EIGHT, suit)) > -1);
    assertTrue(stackOfStandardPlayingPlayingCards.search(new StandardPlayingCard(NINE, suit)) > -1);
    assertTrue(stackOfStandardPlayingPlayingCards.search(new StandardPlayingCard(TEN, suit)) > -1);
    assertTrue(stackOfStandardPlayingPlayingCards.search(new StandardPlayingCard(JACK, suit)) > -1);
    assertTrue(stackOfStandardPlayingPlayingCards.search(new StandardPlayingCard(QUEEN, suit)) > -1);
    assertTrue(stackOfStandardPlayingPlayingCards.search(new StandardPlayingCard(KING, suit)) > -1);
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