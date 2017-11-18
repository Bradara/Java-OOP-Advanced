package MilitaryElite.Soldiers;

public class Private extends Soldier implements IPrivate{
    private double salary;

    public Private(String firstName, String lastName, String id, double salary) {
        super(firstName, lastName, id);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }
}
