package models.card.top;

/**
 * Created by Brandt Newton on 3/17/2015.
 */
public class MooseBait extends TopCard {
    public MooseBait() {
        super(CardClass.MOOSE, "asdf");
    }

    @Override
    public boolean isDefensive() {
        return true;
    }
}
