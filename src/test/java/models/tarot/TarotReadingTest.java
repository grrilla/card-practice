package models.tarot;

import models.Deck;
import models.PlayingCard;
import org.junit.Test;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TarotReadingTest {

  @Test
  public void testTarotReadingHasATarotDeck() {
    Deck deck = new TarotReading().getDeck();
    assertNotNull(deck);
    assertTrue(deck instanceof TarotDeck);
  }

  @Test
  public void testTarotReadingHasASpreadOfTarotCards() {
    TarotReading tarotReading = new TarotReading();

    PlayingCard past = tarotReading.getPast();
    assertNotNull(past);
    assertTrue(past instanceof TarotCard);

    PlayingCard present = tarotReading.getPresent();
    assertNotNull(present);
    assertTrue(present instanceof TarotCard);

    PlayingCard future = tarotReading.getFuture();
    assertNotNull(future);
    assertTrue(future instanceof TarotCard);

    TarotCard overArching = tarotReading.getOverArching();
    assertNotNull(overArching);
    assertTrue(overArching instanceof TarotCard);
  }

  @Test
  public void testTarotReadingsAreUsuallyUnique() {
    TarotReading tarotReading = new TarotReading();
    TarotReading anotherTarotReading;
    int timesDealtToSameState = 0;

    for (int i = 0; i < 10; i++) {
      anotherTarotReading = new TarotReading();
      if (spreadIsEqual(tarotReading, anotherTarotReading) && ++timesDealtToSameState > 1) {
        fail();
      }
    }
  }

  private static boolean spreadIsEqual(TarotReading tarotReading, TarotReading anotherTarotReading) {
    return tarotReading.getPast().equals(anotherTarotReading.getPast())
        && tarotReading.getPresent().equals(anotherTarotReading.getPresent())
        && tarotReading.getFuture().equals(anotherTarotReading.getFuture())
        && tarotReading.getOverArching().equals(anotherTarotReading.getOverArching());
  }

  @Test
  public void testTarotReadingGeneratesAReading() {
    TarotReading tarotReading = new TarotReading();
    TarotCard past = tarotReading.getPast();
    TarotCard present = tarotReading.getPresent();
    TarotCard future = tarotReading.getFuture();
    TarotCard overArching = tarotReading.getOverArching();
    assertEquals(format("Your Reading:%n%nYour past is represented by the %s, which signifies %s.%n"
                        + "Your present is represented by the %s, which signifies %s.%n"
                        + "Your future is represented by the %s, which signifies %s.%n"
                        + "The over-arching thought here is in the %s, which signifies %s.",
                        past, past.getMeaning(),
                        present, present.getMeaning(),
                        future, future.getMeaning(),
                        overArching, overArching.getMeaning()), tarotReading.toString());
    System.out.println(tarotReading.toString());
  }
}