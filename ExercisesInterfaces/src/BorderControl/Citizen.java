package BorderControl;

public class Citizen extends BaseResident implements Birthable {
    private String name;
    private String age;
    private String birthdate;

    public Citizen(String name, String age, String id, String birthdate) {
        super(id);
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
    }

    @Override
    public String getBirthDate() {
        return this.birthdate;
    }
}
