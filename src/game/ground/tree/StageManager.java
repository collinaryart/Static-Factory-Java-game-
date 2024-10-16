package game.ground.tree;

import edu.monash.fit2099.engine.positions.Ground;

import java.util.List;

/**
 * Manages the stages of Growable Ground type, such as Inheritree
 */
public abstract class StageManager {
    private List<Growable<Ground>> stages;
    private Ground lastStage;
    private Growable<Ground> firstStage;

    /**
     * Constructor
     */
    public StageManager(){
        this.stages = this.createStages();
        this.lastStage = this.lastStage();
        this.firstStage = stages.get(0);

        this.initialiseStages(this.stages, this.lastStage);
    }

    /**
     * Iterate over the Growables, setting their next stages based on the order. The last stage might
     * not be Growable, thus should be passed as a separate parameter and not included in the Growables
     * list.
     * @param stages the list of Growables in order than they will grow
     * @param lastStage the last stage of growth
     */
    public void initialiseStages(List<Growable<Ground>> stages, Ground lastStage){
        //assume the list is provided in order of growth, we iterate over the ones that can grow
        int i;
        for (i = 0; i < stages.size()-1; i++)
        {
            Growable<Ground> currStage = stages.get(i);
            Ground nextStage = stages.get(i+1).getCurrentStage();
            currStage.setNextStage(nextStage);
        }
        //do the last one separately as the final stage might not be a Growable, thus can't appear in the list
        Growable<Ground> finalGrowth = stages.get(stages.size()-1);
        finalGrowth.setNextStage(lastStage);
    }

    /**
     * Gets the first stage of growth
     * @return Ground representing the first stage of growth
     */
    public Ground getFirstStage(){
        return this.firstStage.getCurrentStage();
    }

    /**
     * Creates the stages of growth for this Ground type
     * @return the stages of growth
     */
    public abstract List<Growable<Ground>> createStages();

    /**
     * Creates the last stage of growth for this Ground type
     * @return the last stage of growth
     */
    public abstract Ground lastStage();
}
