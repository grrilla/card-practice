package models;

public abstract class Player<C extends PlayingCard, H extends Hand> {

  protected H hand;
  protected int playerName;

  public Player(H hand, int playerName) {
    this.hand = hand;
    this.playerName = playerName;
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