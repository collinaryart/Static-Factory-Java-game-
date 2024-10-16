package game.monologue;

/**
 * An enumeration class that contains all the monologue messages
 *
 * Created by:
 * @author Jia Lin Wang
 */
public enum Monologue {
    /**
     * never give up
     */
    MONOLOGUE1("The factory will never gonna give you up, valuable intern!"),
    /**
     * never let down
     */
    MONOLOGUE2("We promise we never gonna let you down with a range of staff benefits."),
    /**
     * never run around
     */
    MONOLOGUE3("We never gonna run around and desert you, dear intern!"),
    /**
     * never make you cry
     */
    MONOLOGUE4("We never gonna make you cry with unfair compensation."),
    /**
     * never say goodby
     */
    MONOLOGUE5("Trust is essential in this business. We promise we never gonna say goodbye to a valuable intern like you."),
    /**
     * never tell a lie
     */
    MONOLOGUE6("Don't worry, we never gonna tell a lie and hurt you, unlike those hostile creatures.");

    private final String message;

    /**
     * Constructor
     * @param message monologue message
     */
    Monologue(String message) {
        this.message = message;
    }

    /**
     * gets the monologue
     *
     * @return a string containing the monologue message
     */
    public String getMessage() {
        return message;
    }
}
