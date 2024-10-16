package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Buyable;

/**
 * An Action that allows one Actor to buy a Buyable Game Entity
 */
public class BuyAction extends Action {
    private int cost;
    private Buyable buyable;

    /**
     * Constructor
     * @param cost how much the Buyable costs
     * @param buyable the Buyable to be bought
     */
    public BuyAction(int cost, Buyable buyable){
        this.cost = cost;
        this.buyable = buyable;
    }

    /**
     * Determines the cost of the Buyable and tries to let Actor buy it
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return String representing if transaction successful
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int finalCost = buyable.finalCost(cost);
        String res = "Insufficient funds, was not able to purchase " + buyable + " for " + cost + " credits.";
        if (actor.getBalance() >= finalCost){
            actor.deductBalance(finalCost);
            res = buyable.transaction(finalCost, actor);// overridden in each buyable file
        }
        return res;// result
    }

    /**
     * says the Action is for an Actor buying a Buyable
     * @param actor The actor performing the action.
     * @return String saying to buy the Buyable for some amount of credits
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + buyable + " for " + cost + " credits.";
    }
}
