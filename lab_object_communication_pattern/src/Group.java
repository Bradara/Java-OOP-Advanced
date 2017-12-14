import interfaces.*;
import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup{
    private List<ObservableAttacker> attackers;
    private ObservableTarget target;

    public Group() {
        attackers = new ArrayList<>();
    }

    @Override
    public void addMember(ObservableAttacker attacker) {
        this.attackers.add(attacker);
    }

    @Override
    public void groupTarget(ObservableTarget target) {
        this.target = target;
    }

    @Override
    public void groupAttack() {
        for (Attacker attacker : attackers) {
            attacker.setTarget(this.target);
            attacker.attack();
        }
    }

    @Override
    public void groupRegister(){
        for (Observer attacker : attackers) {
            this.target.register(attacker);
        }
    }
}
