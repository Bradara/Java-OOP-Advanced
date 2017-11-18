package MilitaryElite.Soldiers;

public abstract class Soldier implements ISoldier{
    private String id;
    private String firstName;
    private String lastName;

    public Soldier(String firstName, String lastName, String id) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

}
