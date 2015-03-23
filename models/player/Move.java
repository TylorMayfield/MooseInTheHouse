package models.player;

import models.card.Card;

/**
 * Created by brandt on 3/23/15.
 */
public class Move {
    private Card card;
    private int cardPlayerID;
    private int receivingPlayer;

    Move (Card card, int cardPlayerID, int receivingPlayer) {
        this.card = card;
        this.cardPlayerID = cardPlayerID;
        this.receivingPlayer = receivingPlayer;
    }

    public Card getCard() {
        return card;
    }

    public int getCardPlayerID() {
        return cardPlayerID;
    }

    public int getRecievingPlayer() {
        return receivingPlayer;
    }
}
