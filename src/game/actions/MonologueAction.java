package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.monologue.MonologueCapable;
import game.monologue.Monologue;

import java.util.List;

/**
 * An action that allows users listen to an entity's monologue
 *
 * Created by:
 * @author Jia Lin Wang
 */
public class MonologueAction extends Action {
    private MonologueCapable object;
    private List<Monologue> monologueList;

    /**
     * Constructor
     *
     * @param object the entity being listened to
     * @param monologueMessage all the monologue messages available to be heard
     */
    public MonologueAction(MonologueCapable object, List<Monologue> monologueMessage) {
        this.object=object;
        this.monologueList=monologueMessage;
    }

    /**
     * lets the actor listen to an entity's monologue
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string that the entity speaks
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return object.getMonologue(monologueList);
    }

    /**
     * The string that is displayed on the menu when the actor can listen to an object
     *
     * @param actor The actor performing the action.
     * @return String to be displayed on menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " listens to " + object;
    }



}
