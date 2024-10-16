package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.actions.BuyAction;

/**
 * Interface for Buyable Game Entities
 */
public interface Buyable {
    /**
     * Creates a BuyAction for the Game Entity
     * @return BuyAction for the Game Entity
     */
    public BuyAction buy();

    /**
     * The final cost of this Item based on probability
     * @param cost initial cost
     * @return final cost
     */
    public int finalCost (int cost);
    /**
     * Handles the adding of the Item to the Actor's inventory if successful
     * @param cost final cost of the item
     * @param actor who is buying the item
     * @return string detailing if transaction was successful or not
     */
    public String transaction (int cost, Actor actor);
}
