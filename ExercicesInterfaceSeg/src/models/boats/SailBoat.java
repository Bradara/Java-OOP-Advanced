package models.boats;

import Utility.Validator;
import contracts.Race;

public class SailBoat extends BaseBoat {
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    public void setSailEfficiency(int sailEfficiency) {
        Validator.validateSailEffectiveness(sailEfficiency);
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public double calculateSpeed(Race race) {
        return  race.getWindSpeed() * (this.sailEfficiency/100.0) - this.getWeight() + (race.getOceanCurrentSpeed()/2.0);
    }
}
//(Race Wind Speed * (Boat Sail Efficiency / 100)) – Boat’s Weight + (Race Ocean Current Speed / 2)