package BorderControl;

public abstract class BaseLifeResident extends BaseResident implements Birthable{
    private String birthDate;

    protected BaseLifeResident(String id, String birthDate) {
        super(id);
        this.birthDate = birthDate;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }
}
