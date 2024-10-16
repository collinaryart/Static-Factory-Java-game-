package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.FancyMessage;

/**
 * Class representing the Player.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Aleena Elizabeth
 *
 */
public class Player extends Actor {
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
    }

    /**
     * Allows Player to choose a possible Action to perform in this turn
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action the Player wishes to do
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        //create player information string
        String informationString = String.format("%s \nHP: %d/%d \nBalance: %d", name, getAttribute(BaseActorAttributes.HEALTH), getAttributeMaximum(BaseActorAttributes.HEALTH), getBalance());
        System.out.println(informationString);

        // return/print the console menu
        Menu menu = new Menu(actions);
        return menu.showMenu(this, display);
    }

    /**
     * The IntrinsicWeapon of the player
     * @return The IntrinsicWeapon of the Player
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1,"punches",5);
    }

    /**
     * Message to be displayed when the Player dies
     * @param actor the perpetrator
     * @param map   where the actor fell unconscious
     * @return String saying the Player died and are fired
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        String result = "";
        result += super.unconscious(actor, map);
        result += "\n";
        result += FancyMessage.YOU_ARE_FIRED;
        return  result;
    }
}
