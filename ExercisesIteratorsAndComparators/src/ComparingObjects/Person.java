package ComparingObjects;

public class Person<T> implements Comparable<Person>{
    private String name;
    private Integer age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person o) {
        if (this.name.compareTo(o.name) > 0) {
            return 1;
        } else if(this.name.compareTo(o.name) < 0){
            return -1;
        } else if (this.age.compareTo(o.age) > 0) {
            return 1;
        } else if (this.age.compareTo(o.age) < 0) {
            return -1;
        } else if (this.town.compareTo(o.town) > 0) {
            return 1;
        } else if (this.town.compareTo(o.town) < 0) {
            return  -1;
        }

        return 0;
    }
}
