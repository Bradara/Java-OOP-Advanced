package models.engine;

import Utility.Validator;
import contracts.BoatEngine;

public abstract class BaseEngine implements BoatEngine {
    private String model;
    protected int output;
    private int horsepower;
    private int displacement;

    protected BaseEngine(String model, int horsepower, int displacement) {
        this.setDisplacement(displacement);
        this.setModel(model);
        this.setHorsepower(horsepower);
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        Validator.validateEngineModelLength(model);
        this.model = model;
    }

    @Override
    public int getOutput() {
        return this.output;
    }

    protected abstract void setOutput();

    public int getHorsepower() {
        return this.horsepower;
    }

    private void setHorsepower(int horsepower) {
        Validator.validatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    public int getDisplacement(){
        return this.displacement;
    };

    private void setDisplacement(int displacement) {
        Validator.validatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }
}
