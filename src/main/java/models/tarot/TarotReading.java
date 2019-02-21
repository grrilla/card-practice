package models.tarot;

import models.CardGame;

import java.util.Stack;

import static java.lang.String.format;

public class TarotReading extends CardGame<TarotDeck> {

  private TarotCard past;
  private TarotCard present;
  private TarotCard future;
  private TarotCard overArching;

  public TarotReading() {
    super(new TarotDeck());
    deal();
  }

  protected void deal() {
    Stack<TarotCard> cards = this.getDeck().getPlayingCards();
    this.past = cards.pop();
    this.present = cards.pop();
    this.future = cards.pop();
    this.overArching = cards.pop();
  }

  public TarotCard getPast() {
    return past;
  }

  public TarotCard getPresent() {
    return present;
  }

  public TarotCard getFuture() {
    return future;
  }

  public TarotCard getOverArching() {
    return overArching;
  }

  public String toString() {
    TarotCard past = this.getPast();
    TarotCard present = this.getPresent();
    TarotCard future = this.getFuture();
    TarotCard overArching = this.getOverArching();
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
