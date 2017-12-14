package interfaces;

public interface AttackGroup {
    void addMember(ObservableAttacker attacker);
    void groupTarget(ObservableTarget target);
    void groupAttack();

    void groupRegister();
}
