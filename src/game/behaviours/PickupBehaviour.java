package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A class that determines the PickUpAction to pick up an Item
 */
public class PickupBehaviour implements Behaviour {
    /**
     * Determines a PickUpAction for the Items at the Actor's location
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return PickUpAction for the Item
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location location = map.locationOf(actor);
        for (Item item : location.getItems()) {
            return new PickUpAction(item);
        }
        return null;
    }
}