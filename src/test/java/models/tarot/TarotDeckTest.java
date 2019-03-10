package models.tarot;

import org.junit.Test;

import java.util.HashSet;
import java.util.Stack;

import static models.tarot.MajorArcanaCardTest.assertAllMajorArcanaCardsArePresent;
import static models.tarot.MinorArcanaCardTest.assertAllMinorArcanaCardsArePresent;
import static org.junit.Assert.*;

public class TarotDeckTest {

  public static final int DEFAULT_DECK_SIZE = 78;

  @Test
  public void testNewTarotDeckHasCorrectNumberOfCards() {
    assertEquals(DEFAULT_DECK_SIZE, new TarotDeck().getPlayingCards().size());
  }

  @Test
  public void testNewTarotDeckContainsAllTarotCards() {
    Stack<TarotCard> cardStack = new TarotDeck().getPlayingCards();
    assertAllMinorArcanaCardsArePresent(cardStack);
    assertAllMajorArcanaCardsArePresent(cardStack);
  }

  @Test
  public void testNewTarotDeckContainsNoDuplicates() {
    Stack<TarotCard> playingCards = new TarotDeck().getPlayingCards();
    assertEquals(playingCards.size(), new HashSet<>(playingCards).size());
  }

  @Test
  public void testTarotDeckTracksStateWhenCardIsRemoved() {
    TarotDeck TarotDeck = new TarotDeck();
    TarotDeck.getPlayingCards().pop();
    assertEquals(DEFAULT_DECK_SIZE - 1, TarotDeck.getPlayingCards().size());
  }

  @Test
  public void testTarotDeckEquality() {
    TarotDeck TarotDeck = new TarotDeck();
    TarotDeck anotherTarotDeck = new TarotDeck();
    assertEquals(TarotDeck, anotherTarotDeck);
  }

  @Test
  public void testTarotDeckShuffles() {
    int timesShuffledToSameState = 0;
    TarotDeck freshTarotDeck = new TarotDeck();
    TarotDeck TarotDeckToShuffle = new TarotDeck();

    for (int i = 0; i < 100000; i++) {
      TarotDeckToShuffle.shuffle();
      if (freshTarotDeck.equals(TarotDeckToShuffle) && ++timesShuffledToSameState > 1) {
        fail();
      }
    }
    assertNotEquals(freshTarotDeck, TarotDeckToShuffle);
  }
}