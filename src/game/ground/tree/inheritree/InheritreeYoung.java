package game.ground.tree.inheritree;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.ground.tree.Growable;

/**
 * Class representing the InheritreeYoung Ground that's Growable
 */
public class InheritreeYoung extends Ground implements Growable<Ground> {
    private int counter;
    private Ground nextStage;

    /**
     * Constructor.
     */
    public InheritreeYoung() {
        super('y');
    }

    /**
     * After 5 ticks the InheritreeYoung grows to its next stage
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        counter++;
        if (counter == 5){
            location.setGround(this.nextStage);
        }
    }

    /**
     * Sets its next stage
     * @param nextStage the InheritreeYoung's next stage
     */
    @Override
    public void setNextStage(Ground nextStage) {
        this.nextStage = nextStage;
    }

    /**
     * Gets the current stage of the Inheritree, which is Young
     * @return the current stage of the Inheritree i.e. this InheritreeYoung Ground
     */
    @Override
    public Ground getCurrentStage(){
        return this;
    }


}
