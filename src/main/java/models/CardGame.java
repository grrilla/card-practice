package models;

public abstract class CardGame {

  private Deck deck;

  public CardGame(Deck deck) {
    this.deck = deck;
    deck.shuffle();
    deal();
  }

  public Deck getDeck() {
    return deck;
  }

  protected abstract void deal();
}
