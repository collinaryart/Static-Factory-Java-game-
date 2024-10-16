package game.items.useables;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;


/**
 * Interface for items that can be eaten
 *
 * Created by:
 * @author Jia Lin Wang
 */
public interface Usable {

    /**
     * Allows the item to be used by an Actor
     *
     * @return An UseAction
     */
    Action use();

    /**
     * abstract method that handles the effects after the player chooses to use the item.
     *
     * @param actor the player using the item
     * @param value the amount that the object changes the user properties by
     * @return A string describing the effects of consuming the item
     */
    String afterUse(Actor actor, int value);
}
