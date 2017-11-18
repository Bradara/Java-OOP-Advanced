package MilitaryElite.Soldiers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {
    private Set<Private> privates;

    public LeutenantGeneral(String firstName, String lastName, String id, double salary) {
        super(firstName, lastName, id, salary);
        this.privates = new HashSet<>();
    }


    @Override
    public Set<Private> getPrivates() {
        return this.privates;
    }

    @Override
    public void addPrivate(Private p) {
        this.privates.add(p);
    }
}
