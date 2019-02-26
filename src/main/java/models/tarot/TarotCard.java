package models.tarot;

import models.PlayingCard;
import models.Rank;
import models.Suit;

public abstract class TarotCard<R extends Rank, S extends Suit> extends PlayingCard<R, S> {

    public TarotCard(R rank, S suit) {
        super(rank, suit);
    }

    public abstract String getMeaning();
}
