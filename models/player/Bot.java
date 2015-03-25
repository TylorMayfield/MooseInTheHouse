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
    @Override
    public Move makeMove(Player[] players) {

        // Defensive
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i);
            int position = card.validate(getHouse());
            if (card.isDefensive() && position > -1) {
                hand.remove(i);
                return new Move(card, getID(), getID(), position);
            }
        }

        // Offensive

        // Index of players in order of priority
        int[] priorities = behavior.organizeThreats(players);

        for (int i = 0; i < players.length; i++) {
            Player target = players[ priorities[i] ];

            for (int j = 0; j < hand.size(); j++) {
                Card card = hand.get(j);
                int position = card.validate(target.getHouse());
                if ( ! card.isDefensive() && position > -1) {
                    hand.remove(j);
                    return new Move(card, getID(), target.getID(), position);
                }
            }
        }

        // No moves left. End turn.
        return null;
    }

    public int[] getPriorities(Player[] players) {
        return behavior.organizeThreats(players);
    }
}
