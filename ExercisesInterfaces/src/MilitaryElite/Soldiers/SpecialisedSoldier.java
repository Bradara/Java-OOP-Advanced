package MilitaryElite.Soldiers;

public class SpecialisedSoldier extends Private implements ISpecialisedSoldier {
    private String corps;

    public SpecialisedSoldier(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }


    public void setCorps(String corps) {
        this.corps = corps;
    }

    @Override
    public String getCorp() {
        return this.corps;
    }

}
