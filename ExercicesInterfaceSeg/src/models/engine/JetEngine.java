package models.engine;

public class JetEngine extends BaseEngine{
    private static final int MULTIPLIER = 5;

    public JetEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
        this.setOutput();
    }

    @Override
    protected void setOutput() {
        this.output = (this.getHorsepower() * MULTIPLIER) + this.getDisplacement();
    }

}
