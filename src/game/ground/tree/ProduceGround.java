package game.ground.tree;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.useables.fruits.Fallable;

import java.util.List;
import java.util.Random;

/**
 * Class representing Grounds which grow Fallable Items
 */
public abstract class ProduceGround extends Ground {
    private float fallProbability;
    private Fallable fallItemDefault;
    private Random random = new Random();

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     * @param fallProbability the probability that the fallItemDefault will fall
     * @param fallItemDefault the Fallable Item that the Tree produces
     */
    public ProduceGround(char displayChar, float fallProbability, Fallable fallItemDefault) {
        super(displayChar);
        this.fallProbability = fallProbability;
        this.fallItemDefault = fallItemDefault;
    }

    /**
     * Default functioning of a Tree is to produce its fallItemDefault in each tick
     * @param location The location of the Tree
     */
    @Override
    public void tick(Location location) {
        this.produce(location);
    }

    /**
     * If the right probability, drops a fallItemDefault in the surroundings of the Tree
     * @param location the location of the Tree
     */
    public void produce(Location location){
        if (Math.random() <= fallProbability){
            Item fallItem = fallItemDefault.fallItem();
            List<Exit> exits = location.getExits();
            Location destination = exits.get(random.nextInt(exits.size())).getDestination(); //choose a random exit and get the location of it
            destination.addItem(fallItem);
        }
    }
}
