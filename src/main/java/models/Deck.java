package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.lang.Math.random;

public abstract class Deck<T extends PlayingCard> {

  private Stack<T> playingCards = new Stack<>();

  protected Deck() {
    init();
  }

  protected abstract void init();

  public Stack<T> getPlayingCards() {
    return playingCards;
  }

  public void shuffle() {
    ArrayList<T> cardsInOrder = new ArrayList<>();
    while (!playingCards.empty()) {
      cardsInOrder.add(playingCards.pop());
    }
    int shuffleRange = cardsInOrder.size();
    int randomIndex;
    while (shuffleRange > 0) {
      randomIndex = (int) (random() * 1000) % shuffleRange;
      playingCards.push(cardsInOrder.remove(randomIndex));
      shuffleRange--;
    }
  }

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    // reference the cards from each Deck
    Stack<T> playingCards = this.getPlayingCards();
    Stack<T> otherPlayingCards = ((Deck) o).getPlayingCards();

    // if they do not have the same number of cards, they are not equal
    if (playingCards.size() != otherPlayingCards.size()) {
      return false;
    }

    // if they do not have the same cards in the same order, they are not equal
    // use clones to preserve state of original decks
    List<T> cardsClone = new ArrayList<>(playingCards);
    List<T> otherCardsClone = new ArrayList<>(otherPlayingCards);
    for (int i = 0; i < cardsClone.size(); i++) {
      if (!cardsClone.get(i).equals(otherCardsClone.get(i))) {
        return false;
      }
    }

    // then they are equal
    return true;
  }
}
