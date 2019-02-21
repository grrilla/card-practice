package models.standard.blackjack;

import models.standard.StandardPlayingCard;

import java.util.ArrayList;
import java.util.Collection;

import static models.standard.StandardPlayingCard.StandardRank.ACE;
import static models.standard.StandardPlayingCard.StandardSuit.SPADES;

public class Player {

  public Collection<StandardPlayingCard> getHand() {
    ArrayList<StandardPlayingCard> hand = new ArrayList<>();
    hand.add(new StandardPlayingCard(ACE, SPADES));
    hand.add(new StandardPlayingCard(ACE, SPADES));
    return hand;
  }
}
