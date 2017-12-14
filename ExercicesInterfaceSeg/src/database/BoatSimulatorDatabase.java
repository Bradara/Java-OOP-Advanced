package database;

import contracts.Boat;
import contracts.BoatEngine;
import contracts.Modelable;
import contracts.Repository;

public class BoatSimulatorDatabase {
    Repository<Boat> boats;
    Repository<BoatEngine> engines;

    public BoatSimulatorDatabase() {
        this.boats = new RepositoryImpl();
        this.engines = new RepositoryImpl();
    }

    public Repository<Boat> getBoats() {
        return this.boats;
    }

    public Repository<BoatEngine> getEngines() {
        return this.engines;
    }
}
