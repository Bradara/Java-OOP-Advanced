import enums.LogType;
import interfaces.Target;
import loggers.Logger;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";
    private int reward;

    public Warrior(String id, int dmg, Logger logger) {
        super(id, dmg, logger);
        this.reward = 0;
    }

    @Override
    protected void executeClassSpecificAttack(Target target, int dmg) {
        super.getLogger().handle(LogType.ATTACK, String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }

    @Override
    public void update(int n) {
        this.reward += n;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.reward;
    }
}
