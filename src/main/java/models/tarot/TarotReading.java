package models.tarot;

import models.CardGame;

import static java.lang.String.format;

public class TarotReading extends CardGame<TarotDeck, TarotPlayer> {

    public static final int DEFAULT_NUMBER_OF_PLAYERS = 1;

    public TarotReading() {
        this(DEFAULT_NUMBER_OF_PLAYERS);
    }

    public TarotReading(int numberOfPlayers) {
        super(new TarotDeck(), new TarotPlayer());
        for (int p = 0; p < numberOfPlayers; p++) {
                players.add(new TarotPlayer());
        }
        deal();
    }

    protected void deal() {
        for (int i = 0; i < TarotSpread.getNumberOfCardsInSpread(); i++) {
            dealer.draw(deck);
        }
    }

    public String toString() {
        TarotCard past = dealer.getHand().getPast();
        TarotCard present = dealer.getHand().getPresent();
        TarotCard future = dealer.getHand().getFuture();
        TarotCard overArching = dealer.getHand().getOverArching();
        return format("Your Reading:%n%nYour past is represented by the %s, which signifies %s.%n"
                        + "Your present is represented by the %s, which signifies %s.%n"
                        + "Your future is represented by the %s, which signifies %s.%n"
                        + "The over-arching thought here is in the %s, which signifies %s.",
                past, past.getMeaning(),
                present, present.getMeaning(),
                future, future.getMeaning(),
                overArching, overArching.getMeaning());
    }
}