package game.items.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Status;
import game.actions.AttackAction;
import game.actions.BuyAction;
import game.items.Buyable;

/**
 * A Buyable Weapon with large amounts of damage
 */
public class DragonSlayerSword extends WeaponItem implements Buyable {
    /**
     * Constructor.
     */
    public DragonSlayerSword() {
        super("Dragon Slayer Sword", 'x', 50, "whacks", 75);
    }

    /**
     * Creates an AttackAction against the otherActor if they're an enemy
     * @param otherActor the other actor
     * @param location   the location of the other actor
     * @return list of Actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();
        if(!otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(otherActor,location.toString(),this));
        }
        return actions;
    }

    /**
     * Creates a BuyAction for this Item
     * @return BuyAction for this Item
     */
    @Override
    public BuyAction buy() {
        return new BuyAction(100, this);
    }

    /**
     * The final cost of this Item
     * @param cost initial cost
     * @return final cost
     */
    @Override
    public int finalCost (int cost) {
        return cost;
    }

    /**
     * Handles the adding of the Item to the Actor's inventory if successful
     * @param cost final cost of the item
     * @param actor who is buying the item
     * @return string detailing if transaction was successful or not
     */
    @Override
    public String transaction(int cost, Actor actor) {
        float probability = 0.5f;
        String res;
        if (Math.random() <= probability){
            res = actor + " fails to purchase " + this + " and has lost " + cost + " credits.";
        }
        else{
            actor.addItemToInventory(this);
            res = actor + " successfully purchases " + this + " for " + cost + " credits.";
        }
        return res;
    }
}
