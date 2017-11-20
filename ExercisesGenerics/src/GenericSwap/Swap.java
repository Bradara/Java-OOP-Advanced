package GenericSwap;

import java.util.ArrayList;
import java.util.List;

public class Swap <T> {
    private List<T> list;

    Swap(){
        this.list = new ArrayList<>();
    }

    void add(T element){
        this.list.add(element);
    }

    void swap(int firstIndex, int secondIndex){
        T temp = this.list.set(firstIndex, this.list.get(secondIndex));
        this.list.set(secondIndex, temp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : this.list) {
            sb.append(String.format("%s: %s%n", t.getClass().getName(), t));
        }

        return sb.toString();
    }
}
