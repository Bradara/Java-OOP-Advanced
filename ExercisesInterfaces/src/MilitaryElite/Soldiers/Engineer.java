package MilitaryElite.Soldiers;

import java.util.HashMap;
import java.util.Map;

public class Engineer extends SpecialisedSoldier implements IEngineer{
    private Map<String, Integer> repairs;
    public Engineer(String firstName, String lastName, String id, String corps) {
        super(firstName, lastName, id, corps);
        this.repairs = new HashMap<>();
    }

    @Override
    public Map<String, Integer> getRepairs() {
        return this.repairs;
    }
}
