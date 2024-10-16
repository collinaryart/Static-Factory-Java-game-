package game.ground.tree;

import edu.monash.fit2099.engine.positions.Ground;

/**
 * Interface to represent if a Tree can grow into another Tree
 */
public interface Growable <T>{
    /**
     * Gets the next object that the current one will grow into
     * @param nextStage the next stage of the current object
     */
    public void setNextStage(T nextStage);

    /**
     * Gets the current stage of the object type
     * @return the current stage of the object type
     */
    public T getCurrentStage();
}
