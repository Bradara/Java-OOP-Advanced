package models.boats;

import Utility.Validator;
import contracts.Boat;
import contracts.Race;

public abstract class BaseBoat implements Boat{
    private String model;
    private int weight;

    protected BaseBoat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
    }

    @Override
    public String getModel() {
        return this.model;
    }


    private void setModel(String model) {
        Validator.validateBoatModelLength(model);
        this.model = model;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    private void setWeight(int weight) {
        Validator.validatePropertyValue(weight, "Weight");
        this.weight = weight;
    }

    public boolean hasEngine(){
        return false;
    }

    @Override
    public double calculateTime(Race race) {
        return race.getDistance() / this.calculateSpeed(race);
    }
}
