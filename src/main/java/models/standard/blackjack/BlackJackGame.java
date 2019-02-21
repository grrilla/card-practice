package models.standard.blackjack;

import models.CardGame;
import models.standard.StandardDeck;

import java.util.ArrayList;
import java.util.Collection;

public class BlackJackGame extends CardGame<StandardDeck> {

  private static final int STARTING_HAND_SIZE = 2;

  public BlackJackGame() {
    super(new StandardDeck());
  }

  public Player getDealer() {
    return new Player();
  }

  public Collection<Player> getPlayers() {
    ArrayList<Player> players = new ArrayList<>();
    players.add(new Player());
    return players;
  }

  protected void deal() {
    for (int i = 0; i < STARTING_HAND_SIZE; i++) {
      for (Player p : getPlayers()) {
        p.getHand().add(getDeck().getPlayingCards().pop());
      }
    }
  }
}
