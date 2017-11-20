package CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> lists;

    CustomList(){
        this.lists = new ArrayList<>();
    }

    public List<T> getLists() {
        return lists;
    }

    void add(T element){
        this.lists.add(element);
    }
    T remove(int index){
        return this.lists.remove(index);
    }
    boolean contains(T element){
        return this.lists.contains(element);
    }
    void swap(int index1, int index2){
        T temp = this.lists.set(index1, this.lists.get(index2));
        this.lists.set(index2, temp);
    }
    int countGreaterThan(T element){
        return (int) this.lists.stream().filter(t -> t.compareTo(element)>0).count();
    }
    T getMax(){
        T result = this.lists.get(0);

        for (int i = 1; i < this.lists.size(); i++) {
            T current = this.lists.get(i);
            if (current.compareTo(result)>0) {
                result = current;
            }
        }

        return result;
    }
    T getMin(){
        T result = this.lists.get(0);

        for (int i = 1; i < this.lists.size(); i++) {
            T current = this.lists.get(i);
            if (current.compareTo(result)<0) {
                result = current;
            }
        }

        return result;
    }



}
