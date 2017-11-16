package MilitaryElite.Soldiers;

public class Private implements IPrivate, ISoldier{
    private double salary;
    private String id;
    private String firstName;
    private String lastName;

    public Private(double salary, String id, String firstName, String lastName) {
        this.salary = salary;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public double getSalary() {
        return 0;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }
}
