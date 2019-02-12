package models;

import org.junit.Test;

import java.util.HashSet;
import java.util.Stack;

import static models.Card.Suit.CLUBS;
import static models.Card.Suit.DIAMONDS;
import static models.Card.Suit.HEARTS;
import static models.Card.Suit.SPADES;
import static models.CardTest.assertAllRanksOfGivenSuitArePresent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class DeckTest {

  public static final int DEFAULT_DECK_SIZE = 52;

  @Test
  public void testCreateDeck() {
    assertNotNull(new Deck());
  }

  @Test
  public void testNewDeckHasCorrectNumberOfCards() {
    assertEquals(DEFAULT_DECK_SIZE, new Deck().getCards().size());
  }

  @Test
  public void testNewDeckContainsAllStandardCards() {
    Stack<Card> stackOfCards = new Deck().getCards();
    assertAllRanksOfGivenSuitArePresent(stackOfCards, SPADES);
    assertAllRanksOfGivenSuitArePresent(stackOfCards, DIAMONDS);
    assertAllRanksOfGivenSuitArePresent(stackOfCards, CLUBS);
    assertAllRanksOfGivenSuitArePresent(stackOfCards, HEARTS);
  }

  @Test
  public void testNewDeckContainsNoDuplicates() {
    Stack<Card> cards = new Deck().getCards();
    assertEquals(cards.size(), new HashSet<>(cards).size());
  }

  @Test
  public void testDeckTracksStateWhenCardIsRemoved() {
    Deck deck = new Deck();
    deck.getCards().pop();
    assertEquals(DEFAULT_DECK_SIZE - 1, deck.getCards().size());
  }

  @Test
  public void testDeckEquality() {
    Deck deck = new Deck();
    Deck anotherDeck = new Deck();
    assertEquals(deck, anotherDeck);
  }

  @Test
  public void testDeckShuffles() {
    int timesShuffledToSameState = 0;
    Deck freshDeck = new Deck();
    Deck deckToShuffle = new Deck();

    for (int i = 0; i < 100000; i++) {
      deckToShuffle.shuffle();
      if (freshDeck.equals(deckToShuffle) && ++timesShuffledToSameState > 1) {
        fail();
      }
    }
    assertNotEquals(freshDeck, deckToShuffle);
  }
}