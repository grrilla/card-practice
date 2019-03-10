package models.standard.war;

import models.CardGame;
import models.standard.StandardDeck;

import java.util.HashSet;
import java.util.Set;

public class WarGame extends CardGame<StandardDeck, WarPlayer> {

  public static final int DEFAULT_NUMBER_OF_PLAYERS = 2;

  public WarGame() {
    this(DEFAULT_NUMBER_OF_PLAYERS);
  }

  public WarGame(int numberOfPlayers) {
    super(new StandardDeck(), null);
    for (int i = 0; i < numberOfPlayers; i++) {
      players.add(new WarPlayer());
    }
    dealer = players.get(players.size() - 1);
    deal();
  }

  protected void deal() {
    int playerCount = players.size();
    int deckSize = deck.size();
    for (int i = 0; i < deckSize; i++) {
      players.get(i % playerCount).draw(deck);
    }
  }

  public void playRound() throws Exception {
    for (WarPlayer p : players) {
      p.play();
    }
    WarPlayer winner = resolveWars();
    resolveRound(winner);
  }

  private WarPlayer resolveWars() throws Exception {
    Set<WarPlayer> warriors = filterToWarCandidates(new HashSet<>(players)); // initially, take the full set of players and see if anyone's involved in a war
    while (warriors.size() > 1) {
      System.out.println("WAR!");
      for (WarPlayer w : warriors) {
        for (int i = 0; i < 4; i++) {
          w.play();
        }
      }
      warriors = filterToWarCandidates(warriors); // of those who were in a war, see if any have emerged as war candidates again
    }
    return warriors.iterator().next();
  }

  private Set<WarPlayer> filterToWarCandidates(Set<WarPlayer> warriors) {
    WarPlayer winner = getRoundWinner();
    Set<WarPlayer> newWarriors = new HashSet<>();
    newWarriors.add(winner);
    for (WarPlayer p : warriors) {
      if (p.getPlayedCards().peek().compareTo(winner.getPlayedCards().peek()) == 0) {
        newWarriors.add(p);
      }
    }
    return newWarriors;
  }

  public WarPlayer getRoundWinner() {
    WarPlayer roundWinner = dealer;
    for (WarPlayer p : players) {
      if (p.getPlayedCards().peek().compareTo(roundWinner.getPlayedCards().peek()) > 0) {
        roundWinner = p;
      }
    }
    return roundWinner;
  }

  private void resolveRound(WarPlayer winner) {
    for (WarPlayer p : players) {
      winner.getCardsWon().addAll(p.getPlayedCards());
      p.getPlayedCards().clear();
    }
  }

  public void cleanup() {
    Set<WarPlayer> losers = new HashSet<>();
    for (WarPlayer p : players) {
      if (p.getHand().isEmpty()) {
        if (p.getCardsWon().empty()) {
          losers.add(p);
        } else {
          p.replenishHandFromCardsWon();
        }
      }
    }
    for (int i = 1; i <= players.size(); i++) {
      System.out.println("Player " + i + " now has " + players.get(i - 1).getHand().size() + " cards in hand, " + players.get(i - 1).getPlayedCards().size() + " in play, and " + players.get(i - 1)
          .getCardsWon()
          .size() + " in reserve.");
    }
    System.out.println();
    players.removeAll(losers);
  }
}
