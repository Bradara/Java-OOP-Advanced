package models.attacks;

import interfaces.Attack;
import models.Blob;

public class Blobplode implements Attack {

    @Override
    public void execute(Blob attacker, Blob target) {
        int attackerDamage = attacker.getDamage();
        int attackerHealth = attacker.getHealth();
        int targetHealth = target.getHealth();
        target.setHealth(targetHealth - attackerDamage * 2);
        attacker.setHealth(attackerHealth < 2 ? 1 : attackerHealth - attackerHealth / 2);
        target.update();
        attacker.update();
    }
}
