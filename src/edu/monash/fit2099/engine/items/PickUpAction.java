package edu.monash.fit2099.engine.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * An action for picking up an item from the ground.
 */
public class PickUpAction extends Action {
    private final Item item;

    public PickUpAction(Item item) {
        this.item = item;
    }

    /**
     * When an item is picked up, remove the item from the ground and add it to the actor's inventory.
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string describing who has picked up which item.
     */
    @Override
    public String execute(Actor actor, GameMap map) { //applies to Player and Bug, for now
        map.locationOf(actor).removeItem(item);     // Remove the item from the current location of the actor on the map
        actor.addItemToInventory(item);    // Add the item to the actor's inventory
        return menuDescription(actor);
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Player picks up the rock"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up the " + item;
    }
}