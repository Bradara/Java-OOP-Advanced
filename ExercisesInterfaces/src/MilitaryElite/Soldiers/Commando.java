package MilitaryElite.Soldiers;

import java.util.Map;

public class Commando extends SpecialisedSoldier implements ICommando {
    public Commando(String firstName, String lastName, String id, String corps) {
        super(firstName, lastName, id, corps);
    }

    @Override
    public Map<String, String> getMissions() {
        return null;
    }
}
