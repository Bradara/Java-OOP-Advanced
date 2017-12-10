package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;
import java.util.Map;

public class RetireCommand extends Command{
    private Repository repository;
    private UnitFactory unitFactory;

    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data);
    }

    @Override
    public String execute() throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
        String unitType = this.getData()[1];
        Map<String, Integer> amountOfUnit = this.getRepository().getAmountOfUnits();

        if (amountOfUnit.containsKey(unitType) && amountOfUnit.get(unitType) > 0){
            this.getRepository().removeUnit(unitType);
            return unitType + " retired!";
        }

        return "No such units in repository.";
    }
}
