package models.player;

import models.card.Card;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by brandt on 3/20/15.
 */
public abstract class Player {

    private int points = 0;
    private int id;

    protected ArrayList<Card> hand = new ArrayList<Card>();
    protected ArrayList<Card> house = new ArrayList<Card>();

    public Player(int id, ArrayList<Card> hand) {
        this.id = id;
        this.hand = hand;
    }

    public abstract Move makeMove(Player[] players);

    public void addCardsToHand(Card[] cards) {
        // TODO test
        hand.addAll(Arrays.asList(cards));
    }

    public void setCardInHouse(int index, Card card) {
        // TODO add to points if necessary
        house.set(index, card);
    }

    public int getID() {
        return id;
    }

    public int getPoints() {
        return points;
    }

    public Card[] getHand() {
        return (Card[]) hand.toArray();
    }

    public Card[] getHouse() {
        return (Card[]) house.toArray();
    }
}
