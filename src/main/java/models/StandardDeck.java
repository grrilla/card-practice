package models;

import models.StandardPlayingCard.StandardRank;
import models.StandardPlayingCard.StandardSuit;

import java.util.Stack;

public class StandardDeck extends Deck {

  protected void init() {
    Stack<PlayingCard> playingCards = super.getPlayingCards();
    for (StandardSuit s : StandardSuit.values()) {
      for (StandardRank r : StandardRank.values()) {
        playingCards.push(new StandardPlayingCard(r, s));
      }
    }
  }
}
