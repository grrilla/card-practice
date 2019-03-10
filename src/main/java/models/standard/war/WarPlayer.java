package models.standard.war;

import models.Deck;
import models.Player;
import models.standard.StandardPlayingCard;

import java.util.Stack;

import static models.Deck.shuffle;

public class WarPlayer extends Player<StandardPlayingCard, WarHand> {

  private static final int ACE_VALUE = 14;

  private Stack<StandardPlayingCard> cardsWon =  new Stack<>();
  private Stack<StandardPlayingCard> playedCards = new Stack<>();

  public WarPlayer() {
    super(new WarHand());
  }

  public void draw(Deck<StandardPlayingCard> deck) {
    hand.addCard(deck.draw());
  }

  public void play() throws Exception {
    if (hand.isEmpty()) {
      if (cardsWon.size() > 0) {
        replenishHandFromCardsWon();
      } else {
        throw new Exception("A player has no cards available and cannot continue.");
      }
    }
    playedCards.push(hand.getCards().pop());
  }

  public Stack<StandardPlayingCard> getCardsWon() {
    return cardsWon;
  }

  public void setCardsWon(Stack<StandardPlayingCard> cardsWon) {
    this.cardsWon = cardsWon;
  }

  public Stack<StandardPlayingCard> getPlayedCards() {
    return playedCards;
  }

  public void replenishHandFromCardsWon() {
    Stack<StandardPlayingCard> swap;
    swap = hand.getCards();
    hand.setCards(shuffle(cardsWon));
    cardsWon = swap;
  }
}
