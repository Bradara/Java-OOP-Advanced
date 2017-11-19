package MilitaryElite.Soldiers;

import java.util.LinkedHashMap;
import java.util.Map;

public class Engineer extends SpecialisedSoldier implements IEngineer {
    private Map<String, Integer> repairs;

    public Engineer(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashMap<>();
    }


    @Override
    public Map<String, Integer> getRepairs() {
        return this.repairs;
    }

    @Override
    public void addRepair(String name, int n) {
        this.repairs.put(name, n);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format("Corps: %s%nRepairs:%n", this.getCorp()));

        for (Map.Entry<String, Integer> kv : repairs.entrySet()) {
            sb.append(String.format("\tPart Name: %s Hours Worked: %d%n", kv.getKey(), kv.getValue()));
        }
        
        return sb.toString();
    }
}
