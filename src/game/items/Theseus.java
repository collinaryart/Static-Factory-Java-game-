package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.TeleportCapable;
import game.Utility;
import game.actions.BuyAction;
import game.actions.TeleportAction;

/**
 * Class to represent the Thesus Item which can be bought and teleport another object
 */
public class Theseus extends Item implements Buyable, TeleportCapable {
    private Location destination;
    private String name;     // Name of the destination

    /**
     * Constructor
     */
    public Theseus() {
        super("THESEUS", '^', true);
    }

    /**
     * Creates a BuyAction for the Thesus so some object can buy it
     * @return a BuyAction for the Thesus
     */
    @Override
    public BuyAction buy() {
        return new BuyAction(100, this);
    }

    /**
     * Final cost of the Thesus
     * @param cost initial cost
     * @return final cost
     */
    @Override
    public int finalCost (int cost) {
        return cost;
    }

    /**
     * Possible actions an object can perform with the Thesus which is to teleport with it
     * @param location the location of the ground on which the item lies
     * @return the possible actions
     */
    @Override
    public ActionList allowableActions(Location location) {
        ActionList actions = super.allowableActions(location);
        this.addDestinations(location, "current map");
        actions.add(new TeleportAction(destination, name));
        return actions;
    }

    /**
     * Handles the adding of the Item to the Actor's inventory if successful which it will be
     * @param cost  final cost of the item
     * @param actor who is buying the item
     * @return string detailing  transaction was successful or not
     */
    @Override
    public String transaction(int cost, Actor actor) {
        actor.addItemToInventory(this);
        return actor + " successfully purchases " + this + " for " + cost + " credits.";
    }

    /**
     * Add the destination whatever is teleporting can be sent. Takes a starting location, param location, and
     * uses it to determine the random destination location
     * @param location the starting location
     * @param name the name of the destination
     */
    @Override
    public void addDestinations(Location location, String name) {
        Location destination = Utility.generateRandomLocation(location.map());
        this.destination = destination;
        this.name = name;
    }

}
