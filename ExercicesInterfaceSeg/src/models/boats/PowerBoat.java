package models.boats;

import contracts.BoatEngine;
import contracts.Race;

public class PowerBoat extends BaseBoat{
    private BoatEngine firstEngine;
    private BoatEngine secondEngine;

    public PowerBoat(String model, int weight, BoatEngine firstEngine, BoatEngine secondEngine) {
        super(model, weight);
        this.firstEngine = firstEngine;
        this.secondEngine = secondEngine;
    }

    public boolean hasEngine(){
        return true;
    }

    @Override
    public double calculateSpeed(Race race) {
        return (firstEngine.getOutput() + secondEngine.getOutput()) - this.getWeight()
                + (race.getOceanCurrentSpeed() / 5.0);
    }

//    @Override
//    public double calculateTime(Race race) {
//        return race.getDistance() / this.calculateSpeed(race);
//    }

}
//(Engine 1 Output + Engine 2 Output) - Boat’s Weight + (Race Ocean Current Speed / 5);