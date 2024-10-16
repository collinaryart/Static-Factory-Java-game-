package game.items.useables.fruits;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.items.useables.UsableItem;

/**
 * A class that represents the SmallFruit
 *
 * Created by:
 * @author Jia Lin Wang, Aleena Elizabeth
 */
public class SmallFruit extends UsableItem implements Fallable {

    /**
     * Constructor
     */
    public SmallFruit() {
        super("Small Fruit", 'o', true, 1);
    }

    /**
     * Increases player health and removes the item from inventory once used
     *
     * @param actor the player using the item
     * @param value the amount that the player health is to increase by
     * @return A string that contains the effects that the using the item had on the player
     */
    @Override
    public String afterUse(Actor actor, int value) {
        actor.heal(value);
        actor.removeItemFromInventory(this);
        return actor + " consumed " + this + " and " + this + " heals " + actor + " by " + value + " points.";
    }


    /**
     * produces a new small fruit item
     * @return small fruit item
     */
    @Override
    public Item fallItem() {
        return new SmallFruit();
    }
}
