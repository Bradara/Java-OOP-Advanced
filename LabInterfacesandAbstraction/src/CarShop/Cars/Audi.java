package CarShop.Cars;

public class Audi implements Rentable {
    private Integer minRentDay;
    private Double pricePerDay;
    private String countryProduced;
    private String model;
    private String color;
    private Integer hp;

    public Audi(  String model, String color, Integer hp, String countryProduced, Integer minRentDay, Double pricePerDay) {
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
        this.countryProduced = countryProduced;
        this.model = model;
        this.color = color;
        this.hp = hp;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    public String getCountryProduced() {
        return this.countryProduced;
    }

    public Integer getHp() {
        return this.hp;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.hp;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", this.model, this.countryProduced, Car.tires);
    }
}
