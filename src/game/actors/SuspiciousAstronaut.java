package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;

/**
 * Class representing the SuspiciousAstronaut
 * kills Player instantly.
 *
 * @see game.actors.HostileActor
 * @see game.actors.Spawnable
 */
public class SuspiciousAstronaut extends HostileActor implements Spawnable {
    /**
     * Constructor for SuspiciousAstronaut
     */
    public SuspiciousAstronaut() {
        super("Among Us", '\u0D9E', 99);
        this.addBehaviour(0, new AttackBehaviour()); //AttackBehaviour checks exits for enemies, returns AttackAction if there are
        this.addCapability(Ability.CANNOT_ENTER_SPACESHIP); //checked by canActorEnter
    }

    /**
     * Gets the IntrinsicWeapon of SuspiciousAstronaut
     * @return IntrinsicWeapon with damage high enough to kill any target instantly
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(Integer.MAX_VALUE, "kills",100);
    }

    /**
     * Create a new instance of SuspiciousAstronaut
     * @return new instance of SuspiciousAstronaut
     */
    @Override
    public Actor spawnActor() {
        return new SuspiciousAstronaut();
    }



}
