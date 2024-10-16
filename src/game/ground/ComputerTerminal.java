package game.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.TeleportCapable;
import game.actions.TeleportAction;
import game.items.Buyable;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Type of Ground Actors can use to buy Buyables and Teleport
 */
public class ComputerTerminal extends Ground implements TeleportCapable {
    private Map<Location, String> destinations = new HashMap<>();

    private List<Buyable> buyables;

    /**
     * Constructor.
     * @param buyables the buyables that can be bought from this terminal
     */
    public ComputerTerminal(List<Buyable> buyables) {
        super('=');
        this.buyables=buyables;
    }


    /**
     * Creates BuyActions for the Buyables listed in the Computer Terminal
     * @param actor     the Actor acting
     * @param location  the current Location
     * @param direction the direction of the Ground from the Actor
     * @return list of BuyActions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        for (Buyable buyable: buyables){
            actions.add(buyable.buy());
        }

        for (Location destination: destinations.keySet()){
            actions.add(new TeleportAction(destination, destinations.get(destination)));
        }

        return actions;
    }

    /**
     * Add the destination for where whatever is teleporting can be sent.
     * Takes a starting location, param location, which is the destination terminal and
     * uses it to determine the destination location by adding 1 to the y (so the teleported object appears right
     * in front of the destination terminal)
     * @param location the starting location
     * @param name the name of the destination
     */
    @Override
    public void addDestinations(Location location, String name) {
        int newX = location.x(); // Get the x-coordinate of the current location
        int newY = location.y()+1;     // Get the y-coordinate of the current location and increment it by 1
        Location destination = location.map().at(newX,newY); // Create a new location on the map using the new coordinates
        destinations.put(destination, name); // Add the new destination and its name to the destinations map
    }

}
