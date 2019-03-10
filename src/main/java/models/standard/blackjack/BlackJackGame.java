package models.standard.blackjack;

import models.CardGame;
import models.standard.StandardDeck;

public class BlackJackGame extends CardGame<StandardDeck, BlackJackPlayer> {

  private static final int STARTING_HAND_SIZE = 2;
  public static final int DEFAULT_NUMBER_OF_PLAYERS = 1;
  public static final int HIGHEST_VALID_VALUE = 21;

  public BlackJackGame() {
    // if "super()" refers to a direct parent class' constructor, "this()" refers to a constructor in this class
    this(DEFAULT_NUMBER_OF_PLAYERS);
  }

  public BlackJackGame(int numberOfPlayers) {
    super(new StandardDeck(), new BlackJackPlayer());
    for (int i = 0; i < numberOfPlayers; i++) {
      players.add(new BlackJackPlayer());
    }
    deal();
  }

  protected void deal() {
    for (int i = 0; i < STARTING_HAND_SIZE; i++) {
      for (BlackJackPlayer p : players) {
        p.draw(deck);
      }
      dealer.draw(deck);
    }
  }

  public void hit(BlackJackPlayer player) {
    player.draw(deck);
  }

  public static int evaluateHand(BlackJackHand hand) {
    int highValue = hand.getHighValue();
    return highValue <= HIGHEST_VALID_VALUE ? highValue : hand.getLowValue();
  }
}

