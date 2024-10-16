package game.ground.tree.inheritree;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.ground.tree.Growable;
import game.ground.tree.ProduceGround;
import game.items.useables.fruits.SmallFruit;

/**
 * Child of Sapling, has specific attributes for being an InheritreeSapling
 */
public class InheritreeSapling extends ProduceGround implements Growable <Ground> {
    private int counter;
    private Ground nextStage;
    /**
     * Constructor.
     */
    public InheritreeSapling() {
        super('t', 0.3f, new SmallFruit());
        this.counter = 0;

    }

    /**
     * After 5 ticks, grow the tree. Every other tick, produce the SmallFruit
     * @param location The location of the InheritreeSapling
     */
    @Override
    public void tick(Location location) {
        counter++;
        if (counter == 6){
            location.setGround(this.nextStage);
        }
        else {
            this.produce(location);
        }

    }

    /**
     * Sets its next stage
     * @param nextStage the InheritreeSapling's next stage
     */
    @Override
    public void setNextStage(Ground nextStage) {
        this.nextStage = nextStage;
    }

    /**
     * Gets the current stage of the Inheritree, which is Sapling
     * @return the current stage of the Inheritree i.e. this InheritreeSapling Ground
     */
    @Override
    public Ground getCurrentStage(){
        return this;
    }
}
