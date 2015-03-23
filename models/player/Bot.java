package models.player;

import models.card.Card;
import models.player.ai.Behavior;
import models.player.ai.StandardBehavior;

import java.util.ArrayList;

/**
 * Created by brandt on 3/23/15.
 */
public class Bot extends Player {

    Behavior behavior;

    public Bot(int id, ArrayList<Card> hand) {
        super(id, hand);
        this.behavior = new StandardBehavior();
    }

    public Bot(int id, ArrayList<Card> hand, Behavior behavior) {
        super(id, hand);
        this.behavior = behavior;
    }

    // TODO improve structure for modular defensive and offensive behavior
    // TODO test
    @Override
    public Move makeMove(Player[] players) {

        // Defensive
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i);
            if (card.isDefensive() && card.validate(getHouse()) > -1) {
                hand.remove(i);
                return new Move(card, getID(), getID());
            }
        }

        // Offensive

        // Index of players in order of priority
        int[] priorities = behavior.organizeThreats(players);

        for (int i = 0; i < players.length; i++) {
            Player target = players[ priorities[i] ];

            for (int j = 0; j < hand.size(); j++) {
                Card card = hand.get(j);
                if ( ! card.isDefensive() && card.validate(target.getHouse()) > -1) {
                    hand.remove(j);
                    return new Move(card, getID(), target.getID());
                }
            }
        }

        // No moves left. End turn.
        return null;
    }
}
