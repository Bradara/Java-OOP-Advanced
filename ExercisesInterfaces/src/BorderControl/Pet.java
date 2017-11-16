package BorderControl;

public class Pet implements Birthable{
    private String name;
    private String birthdate;

    protected Pet(String name, String birthDate) {
        this.birthdate = birthDate;
        this.name = name;
    }

    @Override
    public String getBirthDate() {
        return this.birthdate;
    }
}
