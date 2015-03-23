package models.card.top;

import models.card.Card;

/**
 * Created by Brandt Newton on 3/17/2015.
 */
public abstract class TopCard extends Card {

    public TopCard(CardClass cardClass, String imagePath) {
        super(cardClass, imagePath);
    }

    /**
     * Returns position of first valid bottom card.
     *
     * Top cards must be placed on a bottom card of the same CardClass.
     * If there are no corresponding bottom cards the move is invalid and -1 is returned.
     *
     * @param house     Cards in house
     * @return          Position card should be placed
     */
    @Override
    public int validate(Card[] house) {
        int bottomCardPosition = -1;
        boolean mooseFound = false;

        for (int i = 0; i < house.length; i++) {

            if (house[i].getCardClass() == CardClass.MOOSE) {
                mooseFound = true;
            }

            if (house[i].getCardClass() == this.cardClass && house[i].isBottomCard()) {
                bottomCardPosition = i;
            }
        }

        if (mooseFound)
            return bottomCardPosition;
        else
            return -1;
    }

    @Override
    public boolean isBottomCard() {
        return false;
    }
}
