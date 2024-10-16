package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.useables.Usable;

/**
 * An action of using an Item
 *
 * Created by:
 * @author Jia Lin Wang
 */
public class UseAction extends Action {
    private Usable consumable;
    private int value;

    /**
     * Cosntructor
     *
     * @param consumable the item being eaten
     * @param value amount using the Usable changes Actor by
     */
    public UseAction(Usable consumable, int value) {
        this.consumable=consumable;
        this.value=value;
    }

    /**
     * When an item is eaten, perform the effects on the actor attribute and
     * remove from actor inventory
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string describing the effects of consuming the item
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return consumable.afterUse(actor, value);
    }

    /***
     * The string that is displayed on the menu when the actor can use an object
     *
     * @param actor The actor performing the action.
     * @return String to be displayed on menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + consumable;
    }
}
