package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.BuyAction;
import game.items.Buyable;

/**
 * An Item that's Buyable
 */
public class ToiletPaperRoll extends Item implements Buyable {
    /***
     *
     * Constructor.
     */
    public ToiletPaperRoll() {
        super("Toilet Paper Roll", 's', true);
    }

    /**
     * Creates a BuyAction for the Game Entity
     * @return BuyAction for the Game Entity
     */
    @Override
    public BuyAction buy() {
        return new BuyAction(5, this);
    } //buy isn't meant to interact w waller; it's meant to create buyaction

    /**
     * The final cost of this Item based on probability
     * @param cost initial cost
     * @return final cost
     */
    @Override
    public int finalCost (int cost) {
        float probability = 0.75f;
        int finalCost = cost;
        if (Math.random() <= probability){
            finalCost = 1;
        }
        return finalCost;
    }

    /**
     * Handles the adding of the Item to the Actor's inventory
     * @param cost final cost of the item
     * @param actor who is buying the item
     * @return string detailing transaction was successful or not
     */
    @Override
    public String transaction(int cost, Actor actor) {
        actor.addItemToInventory(this);
        return actor + " successfully purchases " + this + " for " + cost + " credits.";
    }
}
