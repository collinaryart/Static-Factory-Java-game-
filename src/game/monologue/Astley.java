package game.monologue;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.BuyAction;
import game.actions.MonologueAction;
import game.items.Buyable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An AI device that has monologue capabilities
 *
 * Created by:
 * @author Jia Lin Wang
 */
public class Astley extends Item implements Buyable, MonologueCapable {
    private SubscriptionManager subscriptionManager;

    /***
     * Constructor.
     */
    public Astley() {
        super("Astley, an AI device", 'z', true);
        this.subscriptionManager = new SubscriptionManager();
    }

    /**
     * Creates a MonologueAction for the entity
     *
     * @param actor the player listening to the monologue
     * @return the monologue being played
     */
    @Override
    public MonologueAction listen(Actor actor) {
        return new MonologueAction(this, generateMonologue(actor));
    }

    /**
     * Creates a BuyAction for the Game Entity
     * @return BuyAction for the Game Entity
     */
    @Override
    public BuyAction buy() {
        return new BuyAction(50, this);
    }

    /**
     * The final cost of this Item
     * @param cost initial cost
     * @return final cost
     */
    @Override
    public int finalCost(int cost) {
        return cost;
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

    /**
     * gets the monologue message that the player will listen to
     *
     * @param monologueList list of all the monologue messages that the actor can listen to
     * @return the monologue message being heard
     */
    @Override
    public String getMonologue(List<Monologue> monologueList) {
        return subscriptionManager.displayMonologue(monologueList);
    }

    /**
     * generates a list of all monologue that the player can listen to based on the
     * current conditions of the player
     *
     * @param actor player that will listen to the monologue
     * @return list of all monologue that the player can listen to
     */
    @Override
    public List<Monologue> generateMonologue(Actor actor) {
        List<Monologue> monologue = new ArrayList<>(Arrays.asList(Monologue.MONOLOGUE1, Monologue.MONOLOGUE2,
                                                    Monologue.MONOLOGUE3));
        if (actor.getItemInventory().size() > 10) {
            monologue.add(Monologue.MONOLOGUE4);
        }
        if (actor.getBalance() > 50) {
            monologue.add(Monologue.MONOLOGUE5);
        }
        if (actor.getAttribute(BaseActorAttributes.HEALTH) < 2) {
            monologue.add(Monologue.MONOLOGUE6);
        }

        return monologue;
    }

    /**
     * List of allowable actions that the item can perform to the current actor
     *
     * @param owner the actor that owns the item
     * @return List of actions
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        if (subscriptionManager.isContinueSubscription()) {
            actions.add(listen(owner));
        }

        return actions;
    }

    /**
     * Inform a carried Item of the passage of time.
     *
     * This method is called once per turn, if the Item is being carried.
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor           The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        subscriptionManager.payment(1, 5, actor);

    }
}
