package models;

import java.util.Collection;

public abstract class Hand<C extends PlayingCard, T extends Collection<C>> {

  protected T cards;

  public T getCards() {
    return cards;
  }

  public abstract void addCard(C card);
}
