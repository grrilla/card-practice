package models.standard.war;

import models.Deck;
import models.Player;
import models.standard.StandardPlayingCard;

import java.util.Stack;

public class WarPlayer extends Player<StandardPlayingCard, WarHand> {

  private static final int ACE_VALUE = 14;

  private Stack<StandardPlayingCard> cardsWon =  new Stack<>();
  private Stack<StandardPlayingCard> playedCards = new Stack<>();

  public WarPlayer(int playerName) {
    super(new WarHand(), playerName);
  }

//  public StandardPlayingCard getCurrentCard() {
//    return playedCards.pop();
//  }

  public void draw(Deck<StandardPlayingCard> deck) {
    hand.addCard(deck.draw());
  }

  public void play() {
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


//  public void setPlayedCards(Stack<StandardPlayingCard> playedCards) {
//    this.playedCards = playedCards;
//  }

}
