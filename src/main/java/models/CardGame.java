package models;

public class CardGame {

  private Deck deck;

  public CardGame(Deck deck) {
    this.deck = deck;
  }

  public Deck getDeck() {
    return deck;
  }
}
