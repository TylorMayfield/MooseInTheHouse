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
        if ( ! card.isBottomCard() && ! card.isDefensive()) {
            points++;
        }

        if (index >= house.size())
            house.add(card);
        else
            house.set(index, card);
    }

    /**
     *  FOR TESTING PURPOSES ONLY
     */
    public void setPoints(int points) {
        this.points = points;
    }

    public int getID() {
        return id;
    }

    public int getPoints() {
        return points;
    }

    public Card[] getHand() {
        return house.toArray(new Card[hand.size()]);
    }

    public Card[] getHouse() {
        return house.toArray(new Card[house.size()]);
    }
}
