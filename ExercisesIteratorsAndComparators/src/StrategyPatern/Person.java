package StrategyPatern;

public class Person{
    private  String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getNameLength() {
        return this.name.length();
    }

    public String getInitial() {
        return String.valueOf(this.name.charAt(0)).toLowerCase();
    }

    public Integer getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }

    @Override
    public int hashCode() {
        int prime = 37;
        String result = String.valueOf(3 * prime);
        result += this.name.chars().sum();
        result += this.age;

        return Integer.valueOf(result) ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Person))
            return false;
        Person other = (Person) obj;
        return this.hashCode() == other.hashCode();
    }
}
