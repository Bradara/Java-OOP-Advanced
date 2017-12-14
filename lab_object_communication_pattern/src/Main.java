
import interfaces.*;
import loggers.CombatLogger;
import loggers.EventLogger;
import loggers.Logger;

public class Main {
    public static void main(String[] args) {
        Logger combatLogger = new CombatLogger();
        Logger eventLogger = new EventLogger();
        combatLogger.setSuccessor(eventLogger);

        ObservableAttacker attacker1 = new Warrior("Pesho", 10, combatLogger);
        ObservableAttacker attacker2 = new Warrior("Gosho", 10, combatLogger);
        ObservableAttacker attacker3 = new Warrior("Misho", 10, combatLogger);
        ObservableAttacker attacker4 = new Warrior("Ivo", 20, combatLogger);
        ObservableAttacker attacker5 = new Warrior("Kiro", 10, combatLogger);
        ObservableAttacker attacker6 = new Warrior("Tqna", 10, combatLogger);
        ObservableAttacker attacker7 = new Warrior("Kolio", 10, combatLogger);
        ObservableTarget dragon = new Dragon("Drogo", 50, 5);

        Group group = new Group();

        group.addMember(attacker1);
        group.addMember(attacker2);
        group.addMember(attacker3);
        group.addMember(attacker4);
        group.addMember(attacker5);
        group.addMember(attacker6);
        group.addMember(attacker7);

        group.groupTarget(dragon);
        group.groupRegister();
        group.groupAttack();
    }
}