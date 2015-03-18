package models.game;

/**
 * Created By Software Engineering Team 9
 * UVM
 * Last Updated March 13th, 2015
 * First Created March 13th, 2015
 */

import models.card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    List<Card> cards = new ArrayList<Card>();
    List<Card> discard = new ArrayList<Card>();

    Deck(){}//end Deck

    /*
     * Shuffles the deck for the game
     */
    private void shuffle(){
        Collections.shuffle(cards);
    }//end shuffle

    /*
     * deals the ammount of cards needed for a turn
     * @return cardsDelt
     */
    public Card[] deal(int count){
        Card[] cardsDelt = new Card[count];  //makes an array of size count

        for(int i = 0; i <= (count-1) ; i++){
            cardsDelt[i] = cards.get(0);    //adds the bottom card of the deck to the array
            cards.remove(0);                //deletes the card from the deck
        }//end for count

        return cardsDelt;

    }//end deal

    /*
     * returns the size of the deck
     * @return cards
     */
    public int size(){
        int deckSize = cards.size();

        return deckSize;
    }//end size

    /*
     *  returns the main dec
     *  @return cards
     */
    public List<Card> getCards(){
        return cards;
    }//end getCards

    /*
     * returns the discard pile
     * @return discard
     */
    public List<Card> getDiscard(){
        return discard;
    }//end getCards

}//end Deck Class