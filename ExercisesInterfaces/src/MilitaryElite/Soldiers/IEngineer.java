package MilitaryElite.Soldiers;

import java.util.Map;

public interface IEngineer {
    Map<String, Integer> getRepairs();
    void addRepair(String name, int n);
}
