package pr0304Barracks.models.units;

public class Gunner extends AbstractUnit{
    private static final int GUNNER_HEALHT = 50;
    private static final int GUNNER_DAMAGE = 10;

    public Gunner() {
        super(GUNNER_HEALHT, GUNNER_DAMAGE);
    }
}
