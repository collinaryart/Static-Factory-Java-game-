package game.ground.tree.inheritree;

import edu.monash.fit2099.engine.positions.Ground;
import game.ground.tree.Growable;
import game.ground.tree.StageManager;
import game.ground.tree.inheritree.InheritreeMature;
import game.ground.tree.inheritree.InheritreeSapling;
import game.ground.tree.inheritree.InheritreeSprout;
import game.ground.tree.inheritree.InheritreeYoung;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the order of Inheritree growing on Refactorio
 */
public class RefactorioStageManager extends StageManager {
    /**
     * Creates the stages of growth for this Inheritree on Refactorio
     * @return the stages of growth
     */
    @Override
    public List<Growable<Ground>> createStages() {
        List<Growable<Ground>> stages = new ArrayList<>();
        stages.add(new InheritreeSprout());
        stages.add(new InheritreeSapling());
        stages.add(new InheritreeYoung());
        return stages;
    }

    /**
     * Creates the last stage of growth for Inheritree on Refactorio
     * @return the last stage of growth
     */
    @Override
    public Ground lastStage() {
        return new InheritreeMature();
    }
}
