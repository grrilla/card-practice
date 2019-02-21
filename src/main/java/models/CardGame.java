package models;

import models.standard.blackjack.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class CardGame<T extends Deck> {

  protected T deck;
  protected Player dealer;
  protected List<Player> players;

  public CardGame(T deck) {
    this.deck = deck;
    this.dealer = new Player();
    this.players = new ArrayList<>();
    deck.shuffle();
  }

  public T getDeck() {
    return deck;
  }

  public Player getDealer() {
    return dealer;
  }

  public List<Player> getPlayers() {
    return players;
  }

  protected abstract void deal();
}
