package models.tarot;

import models.Hand;

import java.util.ArrayList;
import java.util.List;

public class TarotSpread extends Hand<TarotCard, List<TarotCard>> {

  private static final int PAST_POSITION = 0;
  private static final int PRESENT_POSITION = 1;
  private static final int FUTURE_POSITION = 2;
  private static final int OVERARCHING_POSITION = 3;
  public static final int NUMBER_OF_CARDS_IN_SPREAD = 4;

  public TarotSpread() {
    super();
    cards = new ArrayList<>();
  }

  public static int getNumberOfCardsInSpread() {
    return NUMBER_OF_CARDS_IN_SPREAD;
  }

  public TarotCard getPast() {
    return cards.get(PAST_POSITION);
  }

  public TarotCard getPresent() {
    return cards.get(PRESENT_POSITION);
  }

  public TarotCard getFuture() {
    return cards.get(FUTURE_POSITION);
  }

  public TarotCard getOverArching() {
    return cards.get(OVERARCHING_POSITION);
  }

  public void addCard(TarotCard card) {
    cards.add(card);
  }
}
