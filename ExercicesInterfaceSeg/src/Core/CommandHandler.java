package Core;

import Utility.Constants;
import contracts.BoatSimulator;
import contracts.Command;
import controllers.BoatSimulatorCtrl;
import enumeration.EngineType;
import exeptions.*;

import java.util.List;

public class CommandHandler implements Command {
    private BoatSimulator controller;

    public CommandHandler() {
        this.controller = new BoatSimulatorCtrl();
    }

    public BoatSimulator getController() {
        return this.controller;
    }

    public String executeCommand(String name, List<String> parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
        switch (name) {
            case "CreateBoatEngine":
                if (parameters.get(3).equals("Jet")) {
                    return this.getController().createBoatEngine(
                            parameters.get(0),
                            Integer.parseInt(parameters.get(1)),
                            Integer.parseInt(parameters.get(2)),
                            EngineType.Jet);
                } else if (parameters.get(3).equals("Sterndrive")) {
                    return this.getController().createBoatEngine(
                            parameters.get(0),
                            Integer.parseInt(parameters.get(1)),
                            Integer.parseInt(parameters.get(2)),
                            EngineType.Sterndrive);
                }

                throw new IllegalArgumentException(Constants.INCORRECT_ENGINE_TYPE_MESSAGE);

            case "CreateRowBoat":
                return this.getController().createRowBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)));
            case "CreateSailBoat":
                return this.getController().createSailBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)));
            case "CreatePowerBoat":
                return this.getController().createPowerBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        parameters.get(2),
                        parameters.get(3));
            case "CreateYacht":
                return this.getController().createYacht(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        parameters.get(2),
                        Integer.parseInt(parameters.get(3)));
            case "OpenRace":
                return this.getController().openRace(
                        Integer.parseInt(parameters.get(0)),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)),
                        Boolean.parseBoolean(parameters.get(3)));
            case "SignUpBoat":
                return this.getController().signUpBoat(parameters.get(0));
            case "StartRace":
                return this.getController().startRace();
            case "GetStatistic":
                return this.getController().getStatistic();
            default:
                throw new IllegalArgumentException();
        }
    }
}
