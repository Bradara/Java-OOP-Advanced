package models.boats;

import Utility.Validator;
import contracts.Race;

public class RowBoat extends BaseBoat {
    private int oars;
    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    public void setOars(int oars) {
        Validator.validatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public double calculateSpeed(Race race) {
        return (this.oars * 100) - this.getWeight() + race.getOceanCurrentSpeed();
    }
}
//(Oars * 100) - Boat Weight + Race Ocean Current Speed