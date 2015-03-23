package models.card;

import models.card.bottom.*;
import models.card.top.*;

/**
 * Created by Brandt Newton on 3/17/2015.
 */
public class CardTester {

    // Tests all card conditions
    public static void main(String[] args) {
        Card[] someHouse = new Card[]{
                new EmptyBathroom(),
                new Moose(),
                new MooseInKitchen(),
                new MooseInBathroom()
        };

        // Tests valid-top-card condition
        Card myCard = new MooseInBathroom();
        testCard(someHouse, myCard, 0);

        // Tests no-bottom-card condition
        myCard = new MooseInBedroom();
        testCard(someHouse, myCard, -1);

        // Tests no-moose condition
        myCard = new MooseInBathroom();
        Card[] someOtherHouse = someHouse;
        someOtherHouse[1] = new EmptyLivingRoom();
        testCard(someOtherHouse, myCard, -1);

        // Tests valid-bottom-card condition
        myCard = new EmptyLivingRoom();
        testCard(someHouse, myCard, someHouse.length);

        // Tests valid-bottom-card condition
        myCard = new Door();
        testCard(someHouse, myCard, 0);
    }

    public static boolean testCard(Card[] house, Card card, int correctPosition) {

        int position = card.validate(house);

        if (position == correctPosition) {
            System.out.println("Card successfully played at " + position);
            return true;
        } else {
            System.out.println("Error! Validate returned: " + position);
            return false;
        }
    }
}
