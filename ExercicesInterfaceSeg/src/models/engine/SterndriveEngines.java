package models.engine;

public class SterndriveEngines extends BaseEngine {
    private static final int MULTIPLIER = 7;

    public SterndriveEngines(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
        this.setOutput();
    }

    @Override
    protected void setOutput() {
        this.output = (this.getHorsepower() * MULTIPLIER) + this.getDisplacement();
    }
}
