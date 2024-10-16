package game.monologue;

import edu.monash.fit2099.engine.actors.Actor;
import game.actions.MonologueAction;
import game.monologue.Monologue;

import java.util.List;

/**
 * Interface foe entities that have monologues
 *
 * Created by:
 * @author Jia Lin Wang
 */
public interface MonologueCapable {

    /**
     * Creates a MonologueAction for the entity
     *
     * @param actor the player listening to the monologue
     * @return the monologue being played
     */
    MonologueAction listen(Actor actor);

    /**
     * generates a list of all monologue that the player can listen to based on the
     * current conditions of the player
     *
     * @param actor player that will listen to the monologue
     * @return list of all monologue that the player can listen to
     */
    List<Monologue> generateMonologue(Actor actor);

    /**
     * gets the monologue message that the player will listen to
     *
     * @param monologueList list of all the monologue messages that the actor can listen to
     * @return the monologue message being heard
     */
    String getMonologue(List<Monologue> monologueList);
}
