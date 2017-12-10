package pr0304Barracks.core.commands;


import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.data.UnitRepository;

public class AddCommand extends Command{
    private Repository repository;
    private UnitFactory unitFactory;

    public AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data);
        this.repository= repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public String execute() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String unitType = super.getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
