package loggers;

import enums.LogType;

public class CombatLogger extends Logger {

    @Override
    public void handle(LogType type, String message) {
        if (type.equals(LogType.ATTACK )|| type.equals(LogType.MAGIC))
            System.out.println(type.name() + ": " + message);
        else if(this.getSuccessor() != null)
            this.getSuccessor().handle(type, message);
    }
}
