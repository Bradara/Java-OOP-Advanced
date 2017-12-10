package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public class ReportCommand extends Command {
    private Repository repository;

    public ReportCommand(String[] data, Repository repository) {
        super(data);
        this.repository = repository;
    }

    @Override
    public String execute() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String output = this.repository.getStatistics();
        return output;
    }
}
