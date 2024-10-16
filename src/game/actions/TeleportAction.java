package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;

import java.util.ArrayList;
import java.util.Random;

/**
 * Action that facilitates teleporting of an Actor
 */
public class TeleportAction extends Action {
    private Location destination;
    private String name;

    /**
     * Constructor
     * @param destination the teleporting destination
     * @param name the name of the destination
     */
    public TeleportAction(Location destination, String name){
        this.destination = destination;
        this.name = name;
    }

    /**
     * Moves the Actor to the teleport destination unless there's another Actor there
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return String saying if the Actor traveled to the destination or not
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        // Check if the destination location already contains an actor
        if (destination.containsAnActor()) {
            // If it does, return a message indicating that the actor cannot teleport there
            return actor + " cannot teleport because as there's someone else there";
        }

        // If the destination location does not contain an actor, move the actor to the destination location
        map.moveActor(actor, destination);
        return menuDescription(actor);
    }

    /**
     * Says which Actor travels to which destination map
     * @param actor The actor performing the action.
     * @return String saying which Actor travels to which destination map
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to " + name;
    }
}