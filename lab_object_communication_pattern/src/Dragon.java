import interfaces.ObservableTarget;
import interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class Dragon implements ObservableTarget{

    private static final String THIS_DIED_EVENT = "%s dies";

    private String id;
    private int hp;
    private int reward;
    private boolean eventTriggered;
    private List<Observer> attackers;

    public Dragon(String id, int hp, int reward) {
        this.id = id;
        this.hp = hp;
        this.reward = reward;
        this.attackers=new ArrayList<>();
    }

    @Override
    public void receiveDamage(int dmg) {
        if (!this.isDead()) {
            this.hp -= dmg;
        }

        if (this.isDead() && !eventTriggered) {
            System.out.println(String.format(THIS_DIED_EVENT, this));
            this.notifyObservers();
            this.eventTriggered = true;
        }
    }

    @Override
    public boolean isDead() {
        return this.hp <= 0;
    }

    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public void register(Observer observer) {
        this.attackers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        this.attackers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer attacker : attackers) {
            attacker.update(this.reward);
            System.out.println(attacker);
        }
    }
}
