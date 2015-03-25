package models.player;

import models.card.Card;

/**
 * Created by brandt on 3/23/15.
 */
public class Move {
    private Card card;
    private int cardPlayerID;
    private int receivingPlayer;
    private int housePosition;

    Move (Card card, int cardPlayerID, int receivingPlayer, int housePosition) {
        this.card = card;
        this.cardPlayerID = cardPlayerID;
        this.receivingPlayer = receivingPlayer;
        this.housePosition = housePosition;
    }

    public Card getCard() {
        return card;
    }

    public int getCardPlayerID() {
        return cardPlayerID;
    }

    public int getReceivingPlayer() {
        return receivingPlayer;
    }

    public int getHousePosition() {
        return housePosition;
    }
}
