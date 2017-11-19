package MilitaryElite.Soldiers;

import java.util.Map;
import java.util.Set;

public class Spy extends Soldier implements ISpy {
    private String codeName;

    public Spy(String id, String firstName, String lastName, String codeName) {
        super(id, firstName, lastName);
        this.codeName = codeName;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%nCode Number: %s%n", this.codeName);
    }

    @Override
    public Map<String, String> getMissions() {
        return null;
    }

    @Override
    public void addMission(String name, String status) {

    }

    @Override
    public Set<Private> getPrivates() {
        return null;
    }

    @Override
    public void addPrivate(Private p) {

    }

    @Override
    public Map<String, Integer> getRepairs() {
        return null;
    }

    @Override
    public void addRepair(String name, int n) {

    }
}
