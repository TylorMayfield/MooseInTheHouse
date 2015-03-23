package models.card;


/**
 * Created by brandt on 3/13/15.
 */
public abstract class Card {

    public static enum CardClass {
        MOOSE, BATHROOM, LIVINGROOM, BEDROOM, KITCHEN
    }

    protected CardClass cardClass;
    private String imagePath;

    public Card(CardClass cardClass, String imagePath) {
        this.cardClass = cardClass;
        this.imagePath = imagePath;
    }

    public CardClass getCardClass() {
        return cardClass;
    }

    public String getImagePath() {
        return imagePath;
    }

    /**
     * Validates moving this card into the specified house.
     *
     * Returns a number greater than the length of house to be placed in an empty space.
     *
     * Returns -1 if no position available.
     *
     * @param house     Cards in house
     * @return          Position card should be placed.
     */
    public abstract int validate(Card[] house);

    public abstract boolean isBottomCard();
<<<<<<< HEAD

    public abstract boolean isDefensive();
=======
>>>>>>> f7c9a8198fab377ca7a980c0bba9734df5e9cef1
}
