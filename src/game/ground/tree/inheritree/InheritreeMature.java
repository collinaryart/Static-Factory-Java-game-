package game.ground.tree.inheritree;

import game.ground.tree.ProduceGround;
import game.items.useables.fruits.LargeFruit;

/**
 * InheritreeMature class of type ProduceGround
 */
public class InheritreeMature extends ProduceGround {
    /**
     * Constructor.
     */
    public InheritreeMature() {
        super('T', 0.2f, new LargeFruit());
    }
}
