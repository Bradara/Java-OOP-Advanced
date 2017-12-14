package kings_gambit.Post;

import kings_gambit.contracts.Attackable;
import kings_gambit.contracts.Killable;
import kings_gambit.contracts.Observer;
import java.util.LinkedHashMap;
import java.util.Map;

public class King implements Attackable, Killable {
    private String name;
    private Map<String, Observer> court;

    public King(String name) {
        this.name = name;
        this.court = new LinkedHashMap<>();
    }

    public void addToCourt(Observer observer){
        this.court.put(observer.getName(), observer);
    }

    @Override
    public void attack() {
        System.out.printf("King %s is under attack!%n", this.name);
        for (Observer o : court.values()) {
            o.update();
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void kill(String observerName) {
        this.court.remove(observerName);
    }
}
