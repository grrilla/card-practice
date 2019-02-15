package models.tarot;

import models.Deck;
import models.PlayingCard;
import models.tarot.MajorArcanaCard.MajorArcana;
import models.tarot.MinorArcanaCard.MinorArcanaRank;
import models.tarot.MinorArcanaCard.MinorArcanaSuit;

import java.util.Stack;

public class TarotDeck extends Deck {

  protected void init() {
    Stack<PlayingCard> playingCards = super.getPlayingCards();
    for (MinorArcanaSuit s : MinorArcanaSuit.values()) {
      for (MinorArcanaRank r : MinorArcanaRank.values()) {
        playingCards.push(new MinorArcanaCard(r, s));
      }
    }
    for (MajorArcana a : MajorArcana.values()) {
      playingCards.push(new MajorArcanaCard(a));
    }
  }
}
