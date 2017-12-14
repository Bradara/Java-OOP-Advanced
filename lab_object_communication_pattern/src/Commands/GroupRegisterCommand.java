package Commands;

import interfaces.AttackGroup;
import interfaces.Command;
import interfaces.Subject;

public class GroupRegisterCommand implements Command{
    private AttackGroup group;
    private Subject subject;

    public GroupRegisterCommand(AttackGroup group, Subject subject) {
        this.group = group;
        this.subject = subject;
    }

    @Override
    public void execute() {
            this.group.groupRegister();
    }
}
