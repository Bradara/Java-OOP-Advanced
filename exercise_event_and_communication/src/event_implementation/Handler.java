package event_implementation;

public class Handler implements NameChangeListener{
    private Disparcher disparcher;

    public Handler(Disparcher disparcher) {
        this.disparcher = disparcher;
    }

    @Override
    public void nameChengeEvent(NameChenge event) {
        this.disparcher.setName(event.getChengedName());
        System.out.printf("Dispatcher's name changed to %s.%n", event.getChengedName());
    }
}
