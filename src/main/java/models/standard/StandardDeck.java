package models.standard;

import models.Deck;
import models.standard.StandardPlayingCard.StandardRank;
import models.standard.StandardPlayingCard.StandardSuit;

import java.util.Stack;

public class StandardDeck extends Deck<StandardPlayingCard> {

  protected void init() {
    Stack<StandardPlayingCard> playingCards = super.getPlayingCards();
    for (StandardSuit s : StandardSuit.values()) {
      for (StandardRank r : StandardRank.values()) {
        playingCards.push(new StandardPlayingCard(r, s));
      }
    }
  }
}