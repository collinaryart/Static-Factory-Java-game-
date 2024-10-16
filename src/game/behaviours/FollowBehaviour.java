package game.behaviours;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Behaviour;
import game.actors.Status;

/**
 * A class that figures out a MoveAction that will move the actor one step
 * closer to a target Actor.
 * @see edu.monash.fit2099.demo.mars.Application
 *
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Aleena Elizabeth
 *
 */
public class FollowBehaviour implements Behaviour {
    private Actor target = null;

    /**
     * Determines a target for the FollowingBehaviour and if the target exits, follows them
     * @param actor the Actor acting, who the FollowingBehaviour belongs to
     * @param map   the GameMap containing the Actor
     * @return the MoveActorAction that moves the Actor towards the Target
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        //if this NPC doesn't yet have a target, decide the target
        if (this.target == null) {
            for (Exit exit : map.locationOf(actor).getExits()) {
                Location destination = exit.getDestination();
                //if there's a hostile_to_enemy actor there, follow them
                if (destination.containsAnActor()) {
                    Actor otherActor = destination.getActor();
                    if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                        this.target = otherActor;
                    }
                }
            }
        }

        //when we have a target
        if (this.target != null) {
            Location here = map.locationOf(actor);
            Location there = map.locationOf(target);

            int currentDistance = distance(here, there);
            for (Exit exit : here.getExits()) { //actor's poss exits
                Location destination = exit.getDestination(); //if actor took exit
                if (destination.canActorEnter(actor)) {// check performed on exit
                    int newDistance = distance(destination, there);
                    if (newDistance < currentDistance) { //checks if closer
                        return new MoveActorAction(destination, exit.getName());
                    }
                }
            }
        }

        return null; //if exits don't bring actor closer to Player
    }

    /**
     * Compute the Manhattan distance between two locations.
     *
     * @param a the first location
     * @param b the first location
     * @return the number of steps between a and b if you only move in the four cardinal directions.
     */
    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}

