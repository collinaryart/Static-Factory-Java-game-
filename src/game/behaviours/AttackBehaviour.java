package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.actions.AttackAction;

import java.util.ArrayList;
import java.util.Random;

/**
 * Behaviour for Atttacking to be used by NPCs
 */
public class AttackBehaviour implements Behaviour {
    private Random random = new Random();

    /**
     * If possible, randomly chooses an Actor to attack
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return Action for the NPC to perform
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        ArrayList<Action> actions = new ArrayList<>();     // Create an ArrayList to store potential attack actions

        for (Exit exit : map.locationOf(actor).getExits()) {    // Iterate over all exits from the actor's current location
            Location destination = exit.getDestination();
            //if there's a hostile_to_enemy actor there, attack action them
            if (destination.containsAnActor()){
                Actor otherActor = destination.getActor();             // retrieve the actor at the destination location
                if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                    actions.add(new AttackAction(otherActor,exit.getName()));
                }
            }
        }
        //if there's multiple possible actors to attack, randomly choose one
        if (!actions.isEmpty()) {
            return actions.get(random.nextInt(actions.size()));
        }
        else {
            return null;
        }
    }
}
