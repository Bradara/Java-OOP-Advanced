package MilitaryElite.Soldiers;

import java.util.LinkedHashMap;
import java.util.Map;

public class Commando extends SpecialisedSoldier implements ICommando {
    private Map<String, String> missions;

    public Commando(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashMap<>();
    }


    @Override
    public Map<String, String> getMissions() {
        return this.missions;
    }

    @Override
    public void addMission(String name, String status) {
        if (status.equals("inProgress")|| status.equals("Finished")){
            this.missions.put(name, status);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("Corps: %s%nMissions:%n", this.getCorp()));

        for (Map.Entry<String, String> kv : this.missions.entrySet()) {
            sb.append(String.format("\tCode Name: %s State: %s%n", kv.getKey(), kv.getValue()));
        }

        return sb.toString();
    }
}
