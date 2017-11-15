package Ferrari.Cars;

public class Ferrari implements Car {
    private String driver;

    public Ferrari(String driver) {
        this.driver = driver;
    }

    @Override
    public String getDriver() {
        return this.driver;
    }
}
