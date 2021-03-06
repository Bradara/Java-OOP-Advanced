package StrategyPatern;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getAge().compareTo(o2.getAge()) > 0) {
            return 1;
        } else if (o1.getAge().compareTo(o2.getAge()) < 0) {
            return -1;
        }

        return 0;
    }
}
