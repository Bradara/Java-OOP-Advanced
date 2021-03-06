package MilitaryElite.Soldiers;

import java.util.Map;
import java.util.Set;

public class Private extends Soldier implements IPrivate{
    private double salary;

    public Private(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Salary: %.2f%n", this.salary);
    }

    @Override
    public Map<String, String> getMissions() {
        return null;
    }

    @Override
    public void addMission(String name, String status) {

    }

    @Override
    public Set<Private> getPrivates() {
        return null;
    }

    @Override
    public void addPrivate(Private p) {

    }

    @Override
    public Map<String, Integer> getRepairs() {
        return null;
    }

    @Override
    public void addRepair(String name, int n) {

    }
}
