package game.items.useables;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.UseAction;

/**
 * Abstract base class representing a physical object in the game world that can be used by the player.
 *
 * Created by:
 * Jia Lin Wang
 */
public abstract class UsableItem extends Item implements Usable {
    private int value;

    /**
     * Constructor.
     *
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     * @param value the amount that the item changes the user properties by
     */
    public UsableItem(String name, char displayChar, boolean portable, int value){
        super(name, displayChar,portable);
        this.value=value;
    }

    /**
     * Allows the item to be used by an Actor
     *
     * @return An UseAction
     */
    @Override
    public Action use(){
        return new UseAction(this, value);
    }

    /**
     * abstract method that handles the effects after the player chooses to use the item.
     *
     * @param actor the player using the item
     * @param value the amount that the item changes the user properties by
     * @return A string describing the effects of consuming the item
     */
    @Override
    public abstract String afterUse(Actor actor, int value);

    /**
     * List of allowable actions that the item can perform to the current actor
     *
     * @param owner the actor that owns the item
     * @return List of actions
     */
    @Override
    public ActionList allowableActions(Actor owner){
        ActionList actions = new ActionList();
        actions.add(use());
        return actions;
    }
}
