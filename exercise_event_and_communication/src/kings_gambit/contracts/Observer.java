package kings_gambit.contracts;

import kings_gambit.Post.King;

public abstract class Observer implements CourtPost {
    private String name;

    public Observer(String name) {
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }

    public abstract void update();
}
