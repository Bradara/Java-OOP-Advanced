package MilitaryElite.Soldiers;

public class SpecialisedSoldier extends Private implements ISpecialisedSoldier {
    private String corps;

    public SpecialisedSoldier(String firstName, String lastName, String id, double salary, String corps) {
        super(firstName, lastName, id, salary);
        this.setCorps(corps);
    }


    public void setCorps(String corps) {
        if ("Airforces".equalsIgnoreCase(corps)||"Marines".equalsIgnoreCase(corps)) {
            this.corps = corps;
        } else{
            throw new IllegalArgumentException("Invalid");
        }
    }

    @Override
    public String getCorp() {
        return this.corps;
    }

}
