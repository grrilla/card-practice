package models;

import java.util.Collection;

public abstract class Hand<C extends PlayingCard, T extends Collection<C>> {

  protected T cards;

  public T getCards() {
    return cards;
  }

  public void setCards(T cards) {
    this.cards = cards;
  }

  public void addCard(C card) {
    cards.add(card);
  }

  public int size() {
    return cards.size();
  }

  public boolean isEmpty() {
    return cards.isEmpty();
  }
}
