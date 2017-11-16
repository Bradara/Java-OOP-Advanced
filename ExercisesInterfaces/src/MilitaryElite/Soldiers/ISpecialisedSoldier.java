package MilitaryElite.Soldiers;

public interface ISpecialisedSoldier {
    enum Corps{
        Airforces, Marines
    }

    Corps getCorp();
}
