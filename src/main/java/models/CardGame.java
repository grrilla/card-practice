package models;

import java.util.ArrayList;
import java.util.List;

public abstract class CardGame<T extends Deck, P extends Player> {

    protected T deck;
    protected P dealer;
    protected List<P> players;

    public CardGame(T deck, P dealer) {
        this.deck = deck;
        this.dealer = dealer;
        this.players = new ArrayList<>();
        deck.shuffle();
    }

    public T getDeck() {
        return deck;
    }

    public P getDealer() {
        return dealer;
    }

    public List<P> getPlayers() {
        return players;
    }

    protected abstract void deal();
}
