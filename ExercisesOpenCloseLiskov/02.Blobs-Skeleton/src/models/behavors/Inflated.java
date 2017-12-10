package models.behavors;

import interfaces.Behavior;
import models.Blob;

public class Inflated extends AbstractBehavior implements Behavior {

    private static final int INFLATED_HEALTH_INCREMENT = 50;
    private static final int INFLATED_HEALTH_DECREMENT = 5;

    private int sourceInitialHealth;

    public Inflated() {
        super();
    }

    @Override
    public void trigger(Blob source) {
        this.sourceInitialHealth = source.getHealth();
        this.setIsTriggered(true);
        source.setHealth(sourceInitialHealth + INFLATED_HEALTH_INCREMENT);
    }

    public void applyRecurrentEffect(Blob source) {
        if (super.toDelayRecurrentEffect() && source.getHealth() > sourceInitialHealth) {
            source.setDamage(source.getHealth() - INFLATED_HEALTH_DECREMENT);
        }

        if (source.getHealth() <= 0) {
            source.setHealth(0);
            super.setToDelayRecurrentEffect(false);
        }
    }
}