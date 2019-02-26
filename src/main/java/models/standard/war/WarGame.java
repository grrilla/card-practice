package models.standard.war;

import models.CardGame;
import models.standard.StandardDeck;

public class WarGame extends CardGame<StandardDeck, WarPlayer> {

    public static final int DEFAULT_NUMBER_OF_PLAYERS = 1;

    public WarGame() {
       this(DEFAULT_NUMBER_OF_PLAYERS);
    }

    public WarGame(int numberOfPlayers) {
        super(new StandardDeck(), new WarPlayer());
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new WarPlayer());
        }
        deal();
    }

    protected void deal() {
        while (deck.size() > 1) {
            dealer.draw(deck);
            for (WarPlayer p : players) {
                p.draw(deck);
            }
        }
    }
//
//    public void play(WarPlayer player) {
//        WarHand hand = player.getHand();
//        return hand.pop();
//    }
}
