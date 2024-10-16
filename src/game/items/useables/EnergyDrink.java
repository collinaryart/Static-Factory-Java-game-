package game.items.useables;

import edu.monash.fit2099.engine.actors.Actor;
import game.actions.BuyAction;
import game.items.Buyable;

/**
 * A Usable Item that can be bought, healing the Actor who consumes it
 */
public class EnergyDrink extends UsableItem implements Buyable {
    /***
     * Constructor.
     */
    public EnergyDrink() {
        super("Energy Drink", '*', true, 1);
    }

    /**
     * Heals the Actor and removes from inventory
     * @param actor the player using the item
     * @param value the amount that the item changes the user properties by
     * @return String saying actor was healed
     */
    @Override
    public String afterUse(Actor actor, int value) {
        actor.heal(value);
        actor.removeItemFromInventory(this);
        return actor + " consumed " + this + " and " + this + " heals " + actor + " by " + value + " points.";
    }

    /**
     * Creates a BuyAction for this Item
     * @return BuyAction for this Item
     */
    @Override
    public BuyAction buy() {
        return new BuyAction(10, this);
    }

    /**
     * The final cost of this Item based on probability
     * @param cost initial cost
     * @return final cost
     */
    @Override
    public int finalCost (int cost) {
        float probability = 0.2f;
        int finalCost = cost;
        if (Math.random() <= probability){
            finalCost = cost *2;
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
