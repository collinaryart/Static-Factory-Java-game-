package game.ground;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.useables.Usable;
import game.actions.UseAction;

/**
 * Class that represents puddle
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * Jia Lin Wang
 */
public class Puddle extends Ground implements Usable {

    /**
     * Constructor
     */
    public Puddle() {
        super('~');
    }

    /**
     * Allows the item to be used by an Actor
     *
     * @return An UseAction
     */
    @Override
    public Action use() {
        return new UseAction(this, 1);
    }

    /**
     * Increases maximum health of player
     *
     * @param actor the player driniking the puddle
     * @param value the amount that the maximum health is to increase by
     * @return A string that contains the effects that the using the item had on the player
     */
    @Override
    public String afterUse(Actor actor, int value) {
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH,ActorAttributeOperations.INCREASE, value);
        return actor + " drinks from " + this + ". "+ actor + " feels invigorated.";
    }

    /**
     * List of allowable actions that the actor can perform to the ground
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return List of actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = new ActionList();
        if (location.containsAnActor()){
            if (location.getActor()==actor){ //is the actor at location same as actor passed to method?
                actions.add(use());
            }
        }
        return actions; //empty list if conditions not met

    }

    /**
     * the name of the puddle object
     * @return name of the puddle object
     */
    public String toString(){
        return "a Random Puddle of Water";
    }
}
