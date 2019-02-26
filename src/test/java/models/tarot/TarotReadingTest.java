package models.tarot;

import models.Deck;
import models.PlayingCard;
import org.junit.Test;

import static java.lang.String.format;
import static org.junit.Assert.*;

public class TarotReadingTest {

    @Test
    public void testTarotReadingHasATarotDeck() {
        Deck deck = new TarotReading().getDeck();
        assertNotNull(deck);
        assertTrue(deck instanceof TarotDeck);
    }

    @Test
    public void testTarotReadingHasASpreadOfTarotCards() {
        TarotPlayer tarotDealer = new TarotReading().getDealer();

        PlayingCard past = tarotDealer.getHand().getPast();
        assertNotNull(past);
        assertTrue(past instanceof TarotCard);

        PlayingCard present = tarotDealer.getHand().getPresent();
        assertNotNull(present);
        assertTrue(present instanceof TarotCard);

        PlayingCard future = tarotDealer.getHand().getFuture();
        assertNotNull(future);
        assertTrue(future instanceof TarotCard);

        TarotCard overArching = tarotDealer.getHand().getOverArching();
        assertNotNull(overArching);
        assertTrue(overArching instanceof TarotCard);
    }

    @Test
    public void testTarotReadingSpreadsAreUsuallyUnique() {
        TarotPlayer tarotDealer = new TarotReading().getDealer();
        TarotPlayer anotherTarotDealer;
        int timesDealtToSameState = 0;

        for (int i = 0; i < 10; i++) {
            anotherTarotDealer = new TarotReading().getDealer();
            if (spreadIsEqual(tarotDealer.getHand(), anotherTarotDealer.getHand()) && ++timesDealtToSameState > 1) {
                fail();
            }
        }
    }

    private static boolean spreadIsEqual(TarotSpread tarotDealer, TarotSpread anotherTarotDealer) {
        return tarotDealer.getPast().equals(anotherTarotDealer.getPast())
                && tarotDealer.getPresent().equals(anotherTarotDealer.getPresent())
                && tarotDealer.getFuture().equals(anotherTarotDealer.getFuture())
                && tarotDealer.getOverArching().equals(anotherTarotDealer.getOverArching());
    }

    @Test
    public void testTarotReadingGeneratesAReading() {
        TarotReading reading = new TarotReading();
        TarotSpread tarotReading = reading.getDealer().getHand();
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
                overArching, overArching.getMeaning()), reading.toString());
        System.out.println(reading.toString());
    }
}