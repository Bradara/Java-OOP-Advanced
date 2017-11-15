package CarShop.Cars;

import java.io.Serializable;

public class Seat implements Sellable, Serializable{
    private Double price;
    private String countryProduced = null;
    private String model = null;
    private String color = null;
    private Integer hp = null;

    public Seat(String model, String color, Integer hp, String countryProduced, Double price) {
        this.countryProduced = countryProduced;
        this.model = model;
        this.color = color;
        this.hp = hp;
        this.price = price;
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

    @Override
    public Double getPrice() {
        return this.price;
    }
}