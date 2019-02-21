package models;

public abstract class CardGame<T extends Deck> {

  private T deck;

  public CardGame(T deck) {
    this.deck = deck;
    deck.shuffle();
    deal();
  }

  public T getDeck() {
    return deck;
  }

  protected abstract void deal();
}
