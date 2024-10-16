package game.items.useables;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * A Pot of Gold item that players can use to increase balance
 *
 *  Created by:
 *  @author Jia Lin Wang
 */
public class GoldPot extends UsableItem {

    /**
     * Constructor.
     */
    public GoldPot() {
        super("Pot of Gold", '$', true, 10);
    }


    /**
     * Increases player balance and removes the item from inventory once used
     *
     * @param actor the player using the item
     * @param value the amount that the player balance is to increase by
     * @return A string that contains the effects that the using the item had on the player
     */
    @Override
    public String afterUse(Actor actor, int value) {
        actor.addBalance(value); //method of actor
        actor.removeItemFromInventory(this);
        return actor + " empties out " + this + " and gains "+ value + " credits. The rest " +
                "are withheld as tax by the factory.";
    }



}
