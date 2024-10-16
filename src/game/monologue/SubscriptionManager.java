package game.monologue;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.List;
import java.util.Random;

/**
 * A class for entities that use subscriptions
 *
 * Created by:
 * @author Jia Lin Wang
 */
public class SubscriptionManager {
    private int subscription;
    private boolean continueSubscription=true;

    /**
     * Constructor
     */
    public SubscriptionManager(){
    }

    /**
     * Randomly chooses a monologue from a list of monologues
     *
     * @param monologueList list of monologues
     * @return a random monologue message
     */
    public String displayMonologue(List<Monologue> monologueList) {
        Random random = new Random();

        int index = random.nextInt(monologueList.size());
        return monologueList.get(index).getMessage();
    }

    /**
     * gets a boolean value for whether the subscription has been paid
     *
     * @return true if subscription has been paid, false otherwise
     */
    public boolean isContinueSubscription() {
        return continueSubscription;
    }

    /**
     * Handles the payment for subscriptions
     *
     * @param cost cost of subscription
     * @param subscriptionPeriod how long before another subscription payment is to be made
     * @param actor the actor paying for the subscription
     */
    public void payment(int cost, int subscriptionPeriod, Actor actor){
        if (continueSubscription) //subscription only continues when player has subscribed
        {
            subscription++;
            if (subscription%subscriptionPeriod==0)
            {
                if (actor.getBalance() >= cost)
                {
                    actor.deductBalance(cost);
                    System.out.println("Subscription payment received!");
                }
                else{
                    continueSubscription=false;
                    System.out.println("Subscription paused due to insufficient balance");
                }
            }

        }
        else{ //subscription only continues once paid
            if (actor.getBalance() >= cost)
            {
                actor.deductBalance(cost);
                continueSubscription = true;
                System.out.println("Subscription payment received!");
            }
        }

    }

}
