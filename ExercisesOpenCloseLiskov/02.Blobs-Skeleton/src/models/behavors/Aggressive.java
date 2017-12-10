package models.behavors;

import interfaces.Behavior;
import models.Blob;

public class Aggressive extends AbstractBehavior implements Behavior {

    private static final int AGGRESSIVE_DAMAGE_MULTIPLY = 2;
    private static final int AGGRESSIVE_DAMAGE_DECREMENT = 5;

    private int sourceInitialDamage;

    public Aggressive() {
        super();
    }

    @Override
    public void trigger(Blob source) {
        this.sourceInitialDamage = source.getDamage();
        this.setIsTriggered(true);
        source.setDamage(sourceInitialDamage * AGGRESSIVE_DAMAGE_MULTIPLY);
    }

    public void applyRecurrentEffect(Blob source) {
        if (super.toDelayRecurrentEffect() && source.getDamage() > sourceInitialDamage) {
            source.setDamage(source.getDamage() - AGGRESSIVE_DAMAGE_DECREMENT);
        }

        if (source.getDamage() <= this.sourceInitialDamage) {
            source.setDamage(this.sourceInitialDamage);
            super.setToDelayRecurrentEffect(false);
        }
    }
}

//    public boolean toDelayRecurrentEffect() {
//        return super.toDelayRecurrentEffect();
//    }
//
//    public void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect){
//        super. = toDelayRecurrentEffect;
//    }

