package game.ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.actors.Ability;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Aleena Elizabeth
 *
 */
public class Floor extends Ground {
    /**
     * Constructor
     */
    public Floor() {
        super('_');
    }

    /**
     * Determines if Actor can enter. Actors with CANNOT_ENTER_SPACESHIP Ability cannot enter
     * @param actor the Actor to check
     * @return true if Actor can enter, false if they cannot
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor.hasCapability(Ability.CANNOT_ENTER_SPACESHIP)){
            return false;
        }
        else{
            return super.canActorEnter(actor);
        }
    }
}
