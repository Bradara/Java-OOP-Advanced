package MilitaryElite.Soldiers;

public interface ISpecialisedSoldier {
    enum Corps{
        Airforces, Marines
    }

    String getCorp();
}
