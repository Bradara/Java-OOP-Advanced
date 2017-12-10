package models.attacks;

import interfaces.Attack;
import models.Blob;

public class PutridFart implements Attack {

    @Override
    public void execute(Blob attacker, Blob target) {
        int attackerDamage = attacker.getDamage();
        int targetHealth = target.getHealth();
        target.setHealth(targetHealth - attackerDamage);
        target.update();
        attacker.update();
    }
}
