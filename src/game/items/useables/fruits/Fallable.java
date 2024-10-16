package game.items.useables.fruits;

import edu.monash.fit2099.engine.items.Item;

/**
 * Interface to be used with Items that can be produced (like falling from a Tree)
 */
public interface Fallable {
    /**
     * Creates a new instance of the Item to be produced/fallen
     * @return new instance of the Item to be produced/fallen
     */
    public Item fallItem();
}
