package loggers;

import interfaces.Handler;

public abstract class Logger implements Handler {
    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    protected Handler getSuccessor() {
        return this.successor;
    }
}
