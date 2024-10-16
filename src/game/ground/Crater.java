package game.ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Spawnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class representing Crater which spawns Actors
 */
public class Crater extends Ground {
    private Spawnable spawnDefault;
    private float spawnRate;
    private Random random = new Random();

    /**
     * Constructor
     * @param spawnDefault the Spawnable Actor that will be spawned from this Crater
     * @param spawnRate the probability of the Spawnable spawning in each tick
     */
    public Crater(Spawnable spawnDefault, float spawnRate) {
        super('u');
        this.spawnDefault = spawnDefault;
        this.spawnRate = spawnRate;
    }

    /**
     * If the probability is met, spawn the Spawnable in the available locations around the Crater
     * @param location The location of the Crater
     */
    @Override
    public void tick(Location location) {
        //spawn if possible
        if (Math.random() <= spawnRate){
            List<Exit> exits = location.getExits();
            List<Exit> useableExists = new ArrayList<>();
            //only choose from the exists where the Actor can spawn i.e. where there isn't already another Actor
            for (Exit exit: exits){
                if (!exit.getDestination().containsAnActor()){
                    useableExists.add(exit);
                }
            }

            if (!useableExists.isEmpty()){
                Location destination = useableExists.get(random.nextInt(useableExists.size())).getDestination(); //choose a random exit and get the location of it
                Actor spawn = spawnDefault.spawnActor();
                destination.addActor(spawn);
            }

        }
    }
}
