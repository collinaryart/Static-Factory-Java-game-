package game.ground.tree.inheritree;

import edu.monash.fit2099.engine.positions.Ground;
import game.ground.tree.Growable;
import game.ground.tree.StageManager;
import game.ground.tree.inheritree.InheritreeMature;
import game.ground.tree.inheritree.InheritreeSapling;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the order of Inheritree growing on Polymorphia
 */
public class PolymorphiaStageManager extends StageManager {
    /**
     * Creates the stages of growth for this Inheritree on Polymorphia
     * @return the stages of growth
     */
    @Override
    public List<Growable<Ground>> createStages() {
        List<Growable<Ground>> stages = new ArrayList<>();
        stages.add(new InheritreeSapling());
        return stages;
    }

    /**
     * Creates the last stage of growth for Inheritree on Polymorphia
     * @return the last stage of growth
     */
    @Override
    public Ground lastStage() {
        return new InheritreeMature();
    }
}
