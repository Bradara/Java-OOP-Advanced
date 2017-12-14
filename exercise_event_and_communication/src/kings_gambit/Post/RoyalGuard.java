package kings_gambit.Post;

import kings_gambit.contracts.Observer;

public class RoyalGuard extends Observer {
    public RoyalGuard(String name) {
        super(name);
    }

    @Override
    public void update() {
        System.out.printf("Royal Guard %s is defending!%n", this.getName());
    }
}
