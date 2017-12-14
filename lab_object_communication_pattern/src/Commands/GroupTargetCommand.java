package Commands;

import interfaces.AttackGroup;
import interfaces.Command;
import interfaces.ObservableTarget;
import interfaces.Target;

public class GroupTargetCommand implements Command{
    private AttackGroup group;
    private ObservableTarget target;

    public GroupTargetCommand(AttackGroup group, ObservableTarget target) {
        this.group = group;
        this.target = target;
    }

    @Override
    public void execute() {
        this.group.groupTarget(this.target);
    }
}
