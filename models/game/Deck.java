/**
 * Created By Software Engineering Team 9
 * UVM
 * Last Updated March 22nd, 2015
 * First Created March 13th, 2015
 */

package models.game;

import models.card.Card;
import models.card.bottom.*;
import models.card.top.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    List<Card> cards = new ArrayList<Card>();
    List<Card> discard = new ArrayList<Card>();

    /*
     * Default constructor builds a deck containing,
     * 20 Empty Room cards (5 each of Kitchen, Bathroom, Living Room
	 * and Bedroom)
	 * 20 Moose in the Room cards (same as above, but with Moose)
	 * 10 There’s a Moose in the House cards
	 * 5 Door cards
	 * 3 Moose Trap cards
     */
    Deck(){
        for(int i = 1 ; i <= 5 ; i++){                                  //Creates all cards needed that loop are devisable by 5
            cards.add(new EmptyBathroom());

            EmptyLivingRoom emptyLivingRoom = new EmptyLivingRoom();
            cards.add(emptyLivingRoom);

            EmptyBedroom emptyBedRoom = new EmptyBedroom();
            cards.add(emptyBedRoom);

            EmptyKitchen emptyKitchen = new EmptyKitchen();
            cards.add(emptyKitchen);

            MooseInBathroom mooseinBathroom = new MooseInBathroom();           //Moose in the Room Cards
            cards.add(mooseinBathroom);

            MooseInLivingRoom mooseinLivingRoom = new MooseInLivingRoom();
            cards.add(mooseinLivingRoom);

            MooseInBedroom mooseinBedRoom = new MooseInBedroom();
            cards.add(mooseinBedRoom);

            MooseInKitchen mooseinKitchen = new MooseInKitchen();
            cards.add(mooseinKitchen);

            Moose moose = new Moose();                               //creates two moose cards per loop though
            cards.add(moose);
            cards.add(moose);

            Door door = new Door();                                 //Door cards
            cards.add(door);
        }//end for i <= 5

        for(int i = 1 ; i <= 3 ; i++){                                  //seperate loop for Moose Traps beacuse there is only 3
            MooseBait mooseBait = new MooseBait();
            cards.add(mooseBait);
        }//end for i <= 3

        shuffle();
    } //end for i <= 5}//end Deck

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
    public Card[] deal(int count) {
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