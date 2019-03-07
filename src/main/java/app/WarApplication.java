package app;

import models.standard.war.WarGame;
import models.standard.war.WarPlayer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WarApplication {

  public static void main(String[] args) {

    WarGame warGame = new WarGame();
    System.out.println("Starting new WarGame!");

    warGame.playRound();
    System.out.println("Round 1");
    for (WarPlayer p : warGame.getPlayers()) {
      System.out.println(p.getPlayedCards());
    }
    System.out.println(warGame.getRoundWinner().getPlayerName() + "won!");
    // TODO: get vars (number of players) from either args or user input
    // TODO: construct a war game
    // TODO: play a round
    // TODO: print the result
    // TODO: cleanup
    // TODO: repeat until one player emerges victorious

    // TODO: STRETCH GOAL - have it wait for user input before proceeding so user can absorb whats going on
  }

//
//  private static void validateNumberOfPlayers() {
//
//    Scanner myObj = new Scanner(System.in);
//
//    System.out.println("Enter number of players");
//
//    try {
//      System.out.print("Please enter number of players: ");
//      String input = myObj.next();
//    } catch (InputMismatchException exception) {
//      System.out.printf("\"%s\" is not a valid number.\n", input);
//    }
//  }
}
