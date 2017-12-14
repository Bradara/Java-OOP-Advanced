package loggers;

import enums.LogType;

public class EventLogger extends Logger {

    @Override
    public void handle(LogType type, String message) {
        if (type.equals(LogType.EVENT))
            System.out.println(type.name() + ": " + message);
        else if(this.getSuccessor() != null)
            this.getSuccessor().handle(type, message);
    }
}
