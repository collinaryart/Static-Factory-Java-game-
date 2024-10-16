package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.*;
import game.behaviours.FollowBehaviour;
import game.behaviours.PickupBehaviour;


/**
 * Class representing an AlienBug, a type of HostileActor.
 * AlienBug can follow a target actor and has behaviours such as picking up items and wandering.
 *
 * @see HostileActor
 * @see Spawnable
 */

public class AlienBug extends HostileActor implements Spawnable {

    /**
     * Constructor
     */
    public AlienBug() {
        super("Alien Bug", 'a', 2); //includes no addCapability statement that would prevent Bug from entering spaceship
        this.addBehaviour(0, new PickupBehaviour());
        this.addBehaviour(1, new FollowBehaviour());
    }
    /**
     * Overrides the toString method for the AlienBug class.
     *
     * The returned string includes a randomly generated feature number between 100 and 999,
     * and the current and maximum health of the AlienBug.
     *
     * @return A string representation of the AlienBug, including its feature number and health status.
     */
    @Override
    public String toString() {
        return "Feature-"+ Utility.generateRandomInt(100, 999) + " (" + //specific range to ensure it's always 3 digits
                this.getAttribute(BaseActorAttributes.HEALTH) + "/" + // current health
                this.getAttributeMaximum(BaseActorAttributes.HEALTH) +
                ")";
    }

    /**
     * Creates a new instance of AlienBug.
     * @return A new instance of AlienBug.
     */
    @Override
    public Actor spawnActor() {
        return new AlienBug();
    }

    /**
     * Overrides the unconscious method from the Actor class.
     * When the AlienBug becomes unconscious, it drops all items in its inventory at its current location.
     * Then, it calls the unconscious method of its superclass (HostileActor).
     *
     * @param actor The actor that caused this AlienBug to become unconscious.
     * @param map The map the AlienBug is on.
     * @return A string describing the result of the AlienBug becoming unconscious, as defined in the superclass's unconscious method.
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        for(Item item: this.getItemInventory()){ //drop all items picked up by AlienBug
            map.locationOf(this).addItem(item);
        }
        return super.unconscious(actor, map); //super is HostileActor
    }
}
