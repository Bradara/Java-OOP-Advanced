package controllers;

import Utility.Constants;
import contracts.*;
import contracts.Race;
import database.BoatSimulatorDatabase;
import enumeration.EngineType;
import exeptions.*;
import models.RaceImpl;
import models.boats.PowerBoat;
import models.boats.RowBoat;
import models.boats.SailBoat;
import models.boats.Yacht;
import models.engine.JetEngine;
import models.engine.SterndriveEngines;

import java.util.*;

public class BoatSimulatorCtrl implements BoatSimulator {
    private List<Boat> map;
    private BoatSimulatorDatabase database;
    private Race currentRace;

    public BoatSimulatorCtrl() {
        this.database = new BoatSimulatorDatabase();
        this.map = new ArrayList<>();
    }

    @Override
    public BoatSimulatorDatabase getDatabase() {
        return this.database;
    }

    @Override
    public Race getCurrentRace() {
        return this.currentRace;
    }

    @Override
    public String createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException {
        BoatEngine engine = null;
        switch (engineType) {
            case Jet:
                engine = new JetEngine(model, horsepower, displacement);
                break;
            case Sterndrive:
                engine = new SterndriveEngines(model, horsepower, displacement);
                break;
        }

        this.database.getEngines().Add(engine);
        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                model,
                horsepower,
                displacement);
    }

    public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        Boat boat = new RowBoat(model, weight, oars);
        this.database.getBoats().Add(boat);
        return String.format(Constants.SUCCESSFULLY_ADDED_BOAT, "Row", model);
    }

    public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        Boat boat = new SailBoat(model, weight, sailEfficiency);
        this.database.getBoats().Add(boat);
        return String.format(Constants.SUCCESSFULLY_ADDED_BOAT, "Sail", model);
    }

    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException {
        BoatEngine firstEngine = this.database.getEngines().GetItem(firstEngineModel);
        BoatEngine secondEngine = this.database.getEngines().GetItem(secondEngineModel);
        Boat boat = new PowerBoat(model, weight, firstEngine, secondEngine);
        this.database.getBoats().Add(boat);
        return String.format(Constants.SUCCESSFULLY_ADDED_BOAT, "Power", model);
    }

    public String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException {
        BoatEngine engine = this.database.getEngines().GetItem(engineModel);
        Boat boat = new Yacht(model, weight, engine, cargoWeight);
        this.database.getBoats().Add(boat);
        return String.format("Yacht with model %s registered successfully.", model);
    }

    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
        Race race = new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.validateRaceIsEmpty();
        this.currentRace = race;
        return
                String.format(
                        "A new race with distance %s meters, wind speed %s m/s and ocean current speed %s m/s has been set.",
                        distance, windSpeed, oceanCurrentSpeed);
    }

    public String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        Boat boat = this.database.getBoats().GetItem(model);
        this.validateRaceIsSet();
        if (!this.currentRace.getAllowsMotorboats() && boat.hasEngine()) {
            throw new IllegalArgumentException(Constants.INCORRECT_BOAT_TYPE_MESSAGE);
        }
        this.currentRace.AddParticipant(boat);
        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        this.validateRaceIsSet();
        List<Boat> participants = this.currentRace.getParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.INSUFFICIENT_CONTESTANTS_MESSAGE);
        }

        for (int i = 0; i < 3; i++) {
            FindFastest(participants);
        }

        String[] numsLikeString = {"First", "Second", "Third"};
        int count = 0;

        StringBuilder result = new StringBuilder();
        for (Boat doubleMotorBoatEntry : map) {
            result.append(String.format("%s place: %s Model: %s Time: %s",
                    numsLikeString[count++],
                    doubleMotorBoatEntry.getClass().getSimpleName().toString(),
                    doubleMotorBoatEntry.getModel(),
                    isFinished(doubleMotorBoatEntry.calculateTime(this.currentRace)))).append(System.lineSeparator());
        }

        this.currentRace = null;

        return result.toString();
    }

    private String isFinished(Double key) {
        if (key <= 0) {
            return "Did not finish!";
        }
        return String.format("%.2f sec", key);
    }

    @Override
    public String getStatistic() {
        return null;
    }

//    public String getStatistic() {
//        //TODO Bonus Task Implement me
//        throw new NotImplementedException();
//    }

    private void FindFastest(List<Boat> participants) {
        Double bestTime = Double.MAX_VALUE;
        Boat winner = participants.get(0);
        for (Boat participant : participants) {
            Double speed = participant.calculateSpeed(this.currentRace);
            Double time = speed <= 0 ? Double.MAX_VALUE : this.currentRace.getDistance() / speed;
            if (time < bestTime) {
                bestTime = time;
                winner = participant;
            }
        }

        map.add(winner);
        participants.remove(winner);
    }

    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NO_SET_RACE_MESSAGE);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RACE_ALREADY_EXISTS_MESSAGE);
        }
    }
}
