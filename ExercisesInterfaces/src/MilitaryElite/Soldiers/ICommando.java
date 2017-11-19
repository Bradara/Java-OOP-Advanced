package MilitaryElite.Soldiers;

import java.util.Map;

public interface ICommando {
    Map<String, String> getMissions();
    void addMission(String name, String status);
}
