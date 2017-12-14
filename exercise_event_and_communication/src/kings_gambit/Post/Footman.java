package kings_gambit.Post;

import kings_gambit.contracts.Observer;

public class Footman extends Observer {
    public Footman(String name) {
        super(name);
    }

    @Override
    public void update() {
        System.out.printf("Footman %s is panicking!%n", this.getName());
    }
}
