package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;
    public Command(String[] data) {
        this.data = data;

    }

    public String[] getData() {
        return data;
    }
}
