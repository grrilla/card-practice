package app;

import models.standard.war.WarGame;
import models.standard.war.WarPlayer;

public class WarApplication {

  public static void main(String[] args) {
    System.out.println("Starting new game of War!\n");

    WarGame warGame = new WarGame();
    int round = 0;
    while (warGame.getPlayers().size() > 1) {
      System.out.println("Round " + ++round + "\n");
      try {
        warGame.playRound();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
      warGame.cleanup();
    }
    WarPlayer victor = warGame.getPlayers().get(0);
    System.out.println((victor.equals(warGame.getDealer()) ? "Player 2" : "Player 1") + " wins!");

    // TODO: STRETCH GOAL - print the round result <---- oops!
    // TODO: STRETCH GOAL - get vars (number of players) from either args or user input
    // TODO: STRETCH GOAL - have it wait for user input before proceeding so user can absorb whats going on
  }
}
