package models;

import Utility.Constants;
import Utility.Validator;
import contracts.Boat;
import contracts.Race;
import exeptions.DuplicateModelException;

import java.util.*;

public class RaceImpl implements Race {
    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private Boolean allowsMotorBoats;
    private HashMap<String, Boat> registeredBoats;

    public RaceImpl(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.windSpeed = windSpeed;
        this.oceanCurrentSpeed = oceanCurrentSpeed;
        this.allowsMotorBoats = allowsMotorBoats;
        this.registeredBoats = new LinkedHashMap<>();
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    private void setDistance(int distance) {
        Validator.validatePropertyValue(distance, "Distance");
        this.distance = distance;
    }

    @Override
    public int getWindSpeed() {
        return windSpeed;
    }

    public int getOceanCurrentSpeed() {
        return this.oceanCurrentSpeed;
    }

    public Boolean getAllowsMotorboats() {
        return this.allowsMotorBoats;
    }

    public Map<String, Boat> getRegisteredBoats() {
        return Collections.unmodifiableMap(this.registeredBoats);
    }

    public void AddParticipant(Boat boat) throws DuplicateModelException {
        if (this.getRegisteredBoats().containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }
        this.registeredBoats.put(boat.getModel(), boat);
    }

    public List<Boat> getParticipants() {
        return new ArrayList<>(this.registeredBoats.values());
    }
}