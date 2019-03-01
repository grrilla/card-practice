package models.standard.war;

import models.Hand;
import models.standard.StandardPlayingCard;

import java.util.Stack;

public class WarHand extends Hand<StandardPlayingCard, Stack<StandardPlayingCard>> {

  public WarHand() {
    super();
    cards = new Stack<>();
  }

  public void addCard(StandardPlayingCard card) {
    cards.add(card);
  }

  public int size() {
    return cards.size();
  }
}
