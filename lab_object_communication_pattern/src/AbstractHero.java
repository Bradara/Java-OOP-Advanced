import enums.LogType;
import interfaces.Attacker;
import interfaces.ObservableAttacker;
import interfaces.Observer;
import interfaces.Target;
import loggers.Logger;

public abstract class AbstractHero implements ObservableAttacker {

    private static final String TARGET_NULL_MESSAGE = "interfaces.Target null";
    private static final String NO_TARGET_MESSAGE = "%s has no target";
    private static final String TARGET_DEAD_MESSAGE = "%s is dead";
    private static final String SET_TARGET_MESSAGE = "%s targets %s";

    private String id;
    private int dmg;
    private Target target;
    private Logger logger;

    public AbstractHero(String id, int dmg, Logger logger) {
        this.id = id;
        this.dmg = dmg;
        this.logger = logger;
    }

    public void setTarget(Target target) {
        if (target == null) {
            logger.handle(LogType.ERROR, TARGET_NULL_MESSAGE);
        } else {
            this.target = target;
            logger.handle(LogType.EVENT, String.format(SET_TARGET_MESSAGE, this, target));
        }
    }

    public final void attack() {
        if (this.target == null) {
            logger.handle(LogType.ERROR, String.format(NO_TARGET_MESSAGE, this));
        } else if (this.target.isDead()) {
            logger.handle(LogType.EVENT, String.format(TARGET_DEAD_MESSAGE, target));
        } else {
            this.executeClassSpecificAttack(this.target, this.dmg);
        }
    }

    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public String toString() {
        return this.id;
    }

    protected abstract void executeClassSpecificAttack(Target target, int dmg);
}
