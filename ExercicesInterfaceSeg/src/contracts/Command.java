package contracts;

import exeptions.*;

import java.util.List;

public interface Command {
    String executeCommand(String name, List<String> parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException;
}
