package GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> value;

    Box(){
        this.value = new ArrayList<>();
    }

    void add(T element){
        this.value.add(element);
    }

    long countGreater(T element){
       return this.value.stream().filter(t -> t.compareTo(element)>0).count();
    }


    @Override
    public String toString() {
        return String.format("%s: %s", this.value.getClass().getName(), this.value);
    }
}