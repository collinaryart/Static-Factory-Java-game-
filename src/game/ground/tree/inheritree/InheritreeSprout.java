package game.ground.tree.inheritree;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.ground.tree.Growable;

/**
 * Class representing the InheritreeSprout Ground that's Growable
 */
public class InheritreeSprout extends Ground implements Growable<Ground> {
    private int counter;
    private Ground nextStage;
    /**
     * Constructor.
     *
     */
    public InheritreeSprout() {
        super(',');
        this.counter = 0;
    }

    /**
     * After 3 ticks it grows into its next stage
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        counter++;
        if (counter == 3){
            location.setGround(this.nextStage);

        }
    }

    /**
     * Sets its next stage
     * @param nextStage the InheritreeSprout's next stage
     */
    @Override
    public void setNextStage(Ground nextStage) {
        this.nextStage = nextStage;
    }

    /**
     * Gets the current stage of the Inheritree, which is Sprout
     * @return the current stage of the Inheritree i.e. this InheritreeSprout Ground
     */
    @Override
    public Ground getCurrentStage(){
        return this;
    }
}
