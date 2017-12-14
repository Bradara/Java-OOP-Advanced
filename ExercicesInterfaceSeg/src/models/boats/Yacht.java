package models.boats;

import Utility.Validator;
import contracts.BoatEngine;
import contracts.Race;

public class Yacht extends BaseBoat{
    private BoatEngine engine;
    private int cargoWeight;
    public Yacht(String model, int weight, BoatEngine engine, int cargoWeight) {
        super(model, weight);
        this.engine = engine;
        this.setCargoWeight(cargoWeight);
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.validatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    public boolean hasEngine(){
        return true;
    }

    @Override
    public double calculateSpeed(Race race) {
        return this.engine.getOutput() - (this.getWeight() + this.cargoWeight) + (race.getOceanCurrentSpeed()/ 2.0);
    }
}
//Boat Engine Output - (Boat Weight + Cargo Weight) + (Race Ocean Current Speed / 2);