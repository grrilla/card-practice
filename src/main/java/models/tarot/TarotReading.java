package models.tarot;

import models.CardGame;
import models.PlayingCard;

import java.util.Stack;

import static java.lang.String.format;

public class TarotReading extends CardGame {

  private TarotCard past;
  private TarotCard present;
  private TarotCard future;
  private TarotCard overArching;

  public TarotReading() {
    super(new TarotDeck());
  }

  protected void deal() {
    Stack<PlayingCard> cards = this.getDeck().getPlayingCards();
    this.past = (TarotCard) cards.pop();
    this.present = (TarotCard) cards.pop();
    this.future = (TarotCard) cards.pop();
    this.overArching = (TarotCard) cards.pop();
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
