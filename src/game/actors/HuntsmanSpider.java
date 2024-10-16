package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;

/**
 * Class representing the HuntsmanSpider
 */
public class HuntsmanSpider extends HostileActor implements Spawnable {
    /**
     * Constructor
     */
    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1);
        this.addBehaviour(0, new AttackBehaviour());
        this.addCapability(Ability.CANNOT_ENTER_SPACESHIP);
    }

    /**
     * Gets the IntrinsicWeapon of HuntsmanSpider
     * @return IntrinsicWeapon of HuntsmanSpider
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "bites",25);
    }

    /**
     * Create a new HuntsmanSpider instance
     * @return new HuntsmanSpider instance
     */
    @Override
    public Actor spawnActor() {
        return new HuntsmanSpider();
    }
}
