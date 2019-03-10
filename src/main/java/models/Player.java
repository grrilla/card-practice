package models;

public abstract class Player<C extends PlayingCard, H extends Hand> {

  protected H hand;
  protected int playerName;

  public Player(H hand) {
    this.hand = hand;
  }

  public H getHand() {
    return hand;
  }

  public int getPlayerName() {
    return playerName;
  }

  public void draw(Deck<C> deck) {
    hand.addCard(deck.draw());
  }
}