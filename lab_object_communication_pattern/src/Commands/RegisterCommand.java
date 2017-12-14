package Commands;

import interfaces.Command;
import interfaces.Observer;
import interfaces.Subject;

public class RegisterCommand implements Command{
    private Observer observer;
    private Subject subject;

    public RegisterCommand(Observer observer, Subject subject) {
        this.observer = observer;
        this.subject = subject;
    }

    @Override
    public void execute() {
        subject.register(observer);
    }
}
