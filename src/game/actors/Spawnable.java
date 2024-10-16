package game.actors;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * To be used with Actors that can spawn
 */
public interface Spawnable {
    /**
     * Get another instance of the said Actor
     * @return New instance of the said Actor
     */
    public Actor spawnActor();
}
