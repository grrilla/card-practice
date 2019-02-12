package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.lang.Math.random;

public class Deck {

  private Stack<Card> cards;

  public Deck() {
    cards = new Stack<>();
    for (Card.Suit s : Card.Suit.values()) {
      for (Card.Rank r : Card.Rank.values()) {
        cards.push(new Card(r, s));
      }
    }
  }

  public Stack<Card> getCards() {
    return cards;
  }

  public void shuffle() {
    ArrayList<Card> cardsInOrder = new ArrayList<>();
    while (!cards.empty()) {
      cardsInOrder.add(cards.pop());
    }
    int shuffleRange = cardsInOrder.size();
    int randomIndex;
    while (shuffleRange > 0) {
      randomIndex = (int) (random() * 1000) % shuffleRange;
      cards.push(cardsInOrder.remove(randomIndex));
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
    Stack<Card> cards = this.getCards();
    Stack<Card> otherCards = ((Deck) o).getCards();

    // if they do not have the same number of cards, they are not equal
    if (cards.size() != otherCards.size()) {
      return false;
    }

    // if they do not have the same cards in the same order, they are not equal
    // use clones to preserve state of original decks
    List<Card> cardsClone = new ArrayList<>(cards);
    List<Card> otherCardsClone = new ArrayList<>(otherCards);
    for (int i = 0; i < cardsClone.size(); i++) {
      if (!cardsClone.get(i).equals(otherCardsClone.get(i))) {
        return false;
      }
    }

    // then they are equal
    return true;
  }
}
