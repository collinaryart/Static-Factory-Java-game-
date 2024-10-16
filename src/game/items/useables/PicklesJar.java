package game.items.useables;

import edu.monash.fit2099.engine.actors.Actor;
import game.items.useables.UsableItem;

import java.util.Random;

/**
 * A Jar of Pickles item that players can eat
 *
 *  Created by:
 *  @author Jia Lin Wang
 */
public class PicklesJar extends UsableItem {
    Random r = new Random();
    boolean expired;

    /**
     * Constructor.
     */
    public PicklesJar() {
        super("Jar of Pickles", 'n', true, 1);
        expired=r.nextBoolean();
    }

    /**
     * If expired, player loses 1 health, otherwise gains 1 health
     * removes the item from inventory once used
     *
     * @param actor the player using the item
     * @param value the amount that the player health is to be changed by
     * @return A string that contains the effects that the using the item had on the player
     */
    @Override
    public String afterUse(Actor actor, int value) {
        String result;
        if (!expired){
            actor.heal(value);
            result =actor + " consumed a delicious " + this +". "+ actor + " feels energised." ;
        }
        else{
            actor.hurt(value);
            result =actor + " consumed an expired " + this + ". "+ actor + " feels sick." ;
        }
        actor.removeItemFromInventory(this);
        return result;
    }
}
