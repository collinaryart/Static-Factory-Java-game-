package game;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;

import java.util.ArrayList;
import java.util.Random;

/**
 * Utility class that has methods with specific functionality.
 * Has the generateRandomInt method
 */
public class Utility {
    /**
     * generates a random integer based on bounds provided
     * @param lower the lower bound for the generator
     * @param upper the upper bound for the generator
     * @return the random integer chosen
     */
    public static int generateRandomInt(int lower, int upper) {
        //math.random() generates a random float from 0.0-1.0
        return (int) ((Math.random() * (upper - lower)) + lower);
    }

    /**
     * chooses a random location from a given GameMap object
     * @param map the game map to choose the location from
     * @return the chosen location
     */
    public static Location generateRandomLocation(GameMap map){
        ArrayList<Location> locations = new ArrayList<>();
        NumberRange xRange = map.getXRange();
        NumberRange yRange = map.getYRange();

        for (int x : xRange) {
            for (int y : yRange) {
                Location location = map.at(x, y);
                locations.add(location);
            }
        }
        return locations.get(new Random().nextInt(locations.size()));
    }

}
