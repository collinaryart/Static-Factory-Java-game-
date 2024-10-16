package game;

import edu.monash.fit2099.engine.positions.Location;
import game.actions.TeleportAction;

/**
 * Interface for objects that can teleport
 */
public interface TeleportCapable {
    /**
     * Add the destination whatever is teleporting can be sent. Takes a starting location, param location, and
     * uses it to determine the destination location
     * @param location the starting location
     * @param name the name of the destination
     */
    public void addDestinations(Location location, String name);

}
