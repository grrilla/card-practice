package models.standard;

import org.junit.Test;

import java.util.HashSet;
import java.util.Stack;

import static models.standard.StandardPlayingCard.StandardSuit.*;
import static models.standard.StandardPlayingCardTest.assertAllRanksOfGivenSuitArePresent;
import static org.junit.Assert.*;

public class StandardDeckTest {

  public static final int DEFAULT_DECK_SIZE = 52;

  @Test
  public void testCreateStandardDeck() {
    assertNotNull(new StandardDeck());
  }

  @Test
  public void testNewStandardDeckHasCorrectNumberOfCards() {
    assertEquals(DEFAULT_DECK_SIZE, new StandardDeck().getPlayingCards().size());
  }

  @Test
  public void testNewStandardDeckContainsAllStandardCards() {
    Stack<StandardPlayingCard> stackOfPlayingCards = new StandardDeck().getPlayingCards();
    assertAllRanksOfGivenSuitArePresent(stackOfPlayingCards, SPADES);
    assertAllRanksOfGivenSuitArePresent(stackOfPlayingCards, DIAMONDS);
    assertAllRanksOfGivenSuitArePresent(stackOfPlayingCards, CLUBS);
    assertAllRanksOfGivenSuitArePresent(stackOfPlayingCards, HEARTS);
  }

  @Test
  public void testNewStandardDeckContainsNoDuplicates() {
    Stack<StandardPlayingCard> playingCards = new StandardDeck().getPlayingCards();
    assertEquals(playingCards.size(), new HashSet<>(playingCards).size());
  }

  @Test
  public void testStandardDeckTracksStateWhenCardIsRemoved() {
    StandardDeck StandardDeck = new StandardDeck();
    StandardDeck.getPlayingCards().pop();
    assertEquals(DEFAULT_DECK_SIZE - 1, StandardDeck.getPlayingCards().size());
  }

  @Test
  public void testStandardDeckEquality() {
    StandardDeck StandardDeck = new StandardDeck();
    StandardDeck anotherStandardDeck = new StandardDeck();
    assertEquals(StandardDeck, anotherStandardDeck);
  }

  @Test
  public void testStandardDeckShuffles() {
    int timesShuffledToSameState = 0;
    StandardDeck freshStandardDeck = new StandardDeck();
    StandardDeck StandardDeckToShuffle = new StandardDeck();

    for (int i = 0; i < 100000; i++) {
      StandardDeckToShuffle.shuffle();
      if (freshStandardDeck.equals(StandardDeckToShuffle) && ++timesShuffledToSameState > 1) {
        fail();
      }
    }
    assertNotEquals(freshStandardDeck, StandardDeckToShuffle);
  }
}