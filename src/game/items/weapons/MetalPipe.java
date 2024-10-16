package game.items.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Status;
import game.actions.AttackAction;

/**
 *
 */
public class MetalPipe extends WeaponItem {

    /**
     * Constructor.
     */
    public MetalPipe() {
        super("Metal Pipe", '!', 1, "whacks", 20);
    }

    /**
     * @param otherActor the other actor
     * @param location   the location of the other actor
     * @return unmodifiable list of Actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();
        if(!otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(otherActor,location.toString(),this));
        }
        return actions;
    }
}
