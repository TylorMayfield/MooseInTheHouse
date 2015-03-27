package models.game;

import models.player.Move;
import models.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brandt on 3/27/15.
 */
public class Game {

    public Player[] players;
    public List<Move> moveHistory = new ArrayList<Move>();
    public Deck deck;

        /*
         *  Gets the number of players and deals to all players.
         *  Assumes a minumum of two players
         */
        Game(Player[] p){
            players = p;
            deck = new Deck();

            for (int i = 0; i < players.length; i++) {
                players[i].addCardsToHand(deck.deal(4));
            }
        }//end constructor

        public void gameLoop(){

            do {
                // Main loop

            } while( ! allPlayersPassed());

        }//end gameLoop

    private boolean allPlayersPassed() {
        // TODO check deck size is not empty
        return false;
    }

}//end Game Class
