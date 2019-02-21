package models.standard;

import models.PlayingCard;
import models.standard.StandardPlayingCard.StandardRank;
import models.standard.StandardPlayingCard.StandardSuit;
import org.junit.Test;

import java.util.Stack;

import static models.standard.StandardPlayingCard.StandardRank.ACE;
import static models.standard.StandardPlayingCard.StandardRank.EIGHT;
import static models.standard.StandardPlayingCard.StandardRank.FIVE;
import static models.standard.StandardPlayingCard.StandardRank.FOUR;
import static models.standard.StandardPlayingCard.StandardRank.JACK;
import static models.standard.StandardPlayingCard.StandardRank.KING;
import static models.standard.StandardPlayingCard.StandardRank.NINE;
import static models.standard.StandardPlayingCard.StandardRank.QUEEN;
import static models.standard.StandardPlayingCard.StandardRank.SEVEN;
import static models.standard.StandardPlayingCard.StandardRank.SIX;
import static models.standard.StandardPlayingCard.StandardRank.TEN;
import static models.standard.StandardPlayingCard.StandardRank.THREE;
import static models.standard.StandardPlayingCard.StandardRank.TWO;
import static models.standard.StandardPlayingCard.StandardSuit.CLUBS;
import static models.standard.StandardPlayingCard.StandardSuit.DIAMONDS;
import static models.standard.StandardPlayingCard.StandardSuit.HEARTS;
import static models.standard.StandardPlayingCard.StandardSuit.SPADES;
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
    Stack<StandardPlayingCard> stackOfStandardPlayingPlayingCards = new Stack<>();

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

  static void assertAllRanksOfGivenSuitArePresent(Stack<StandardPlayingCard> stackOfStandardPlayingPlayingCards, StandardSuit suit) {
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