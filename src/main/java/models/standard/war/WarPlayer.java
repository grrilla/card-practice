package models.standard.war;

import models.Deck;
import models.Player;
import models.standard.StandardPlayingCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WarPlayer extends Player<StandardPlayingCard, WarHand> {

  private static final int ACE_VALUE = 14;

  private List<StandardPlayingCard> cardsWon =  new ArrayList<>();
  private Stack<StandardPlayingCard> playedCards = new Stack<>();

  public WarPlayer() {
    super(new WarHand());
  }

  public StandardPlayingCard getCurrentCard() {
    return playedCards.pop();
  }

  public void draw(Deck<StandardPlayingCard> deck) {
    hand.addCard(deck.draw());
  }

  public void play() {
    playedCards.push(hand.getCards().pop());
  }

  public List<StandardPlayingCard> getCardsWon() {
    return cardsWon;
  }

  public void setCardsWon(List<StandardPlayingCard> cardsWon) {
    this.cardsWon = cardsWon;
  }

  public Stack<StandardPlayingCard> getPlayedCards() {
    return playedCards;
  }

  public void setPlayedCards(Stack<StandardPlayingCard> playedCards) {
    this.playedCards = playedCards;
  }
}
