package models.standard.war;

import models.CardGame;
import models.standard.StandardDeck;

import java.util.ArrayList;
import java.util.Collections;

public class WarGame extends CardGame<StandardDeck, WarPlayer> {

  public static final int DEFAULT_NUMBER_OF_PLAYERS = 1;
  public ArrayList<Integer> round;

  public WarGame() {
    this(DEFAULT_NUMBER_OF_PLAYERS);
  }

  public WarGame(int numberOfPlayers) {
    super(new StandardDeck(), new WarPlayer());
    for (int i = 0; i < numberOfPlayers; i++) {
      players.add(new WarPlayer());
    }
    deal();
    this.round = new ArrayList<>();
  }

  protected void deal() {
    while (deck.size() > 1) {
      dealer.draw(deck);
      for (WarPlayer p : players) {
        p.draw(deck);
      }
    }
  }

  public static int evaluatePlay(WarPlayer player) {
    int playValue = player.getPlayValue();
    return playValue;
  }

  public int evaluateRound() {
    for (WarPlayer p : players) {
      round.add(p.getPlayValue());
    }
    round.add(dealer.getPlayValue());
    Collections.sort(round, Collections.reverseOrder());
    if (round.get(0) == round.get(1)) {
      System.out.println("WAR!!!");
    }
    return round.get(0);
  }
}
