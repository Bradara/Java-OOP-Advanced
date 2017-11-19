package MilitaryElite.Soldiers;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {
    private Set<Private> privates;

    public LeutenantGeneral(String id, String firstName, String lastName, double salary, String... privateId) {
        super(id, firstName, lastName, salary);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Privates:\n");
        for (Private p : this.privates.stream().sorted(Comparator.comparing(Soldier::getId).reversed()).collect(Collectors.toList())) {
            sb.append("\t").append(p.toString());
        }
        return sb.toString();
    }
}
