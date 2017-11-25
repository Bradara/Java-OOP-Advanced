package ListIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListIterator implements Iterator<String> {
    private List<String> collection;
    private int index = 0;

    public ListIterator(String... elements) {
        this.setCollection(elements);
    }

    public void setCollection(String... collection) {
        if (collection.length == 0){
            this.collection = new ArrayList<>();
        }
        this.collection = Arrays.asList(collection);
    }

    public List<String> getCollection() {
        return this.collection;
    }

    public boolean move(){
        if (index + 1 >= collection.size()){
            return false;
        }

        index++;

        return true;
    }

    public boolean hasNext(){
        return index + 1 < collection.size();
    }

    @Override
    public String next() {
        if (this.hasNext()){
            return this.collection.get(++index);
        }
        return null;
    }

    public void printAll(){
        for (String s : this.collection) {
            System.out.print(s);
            System.out.print(" ");
        }
        System.out.println();
    }

    public String print(){
        if (this.collection.size() > 0) {
            return collection.get(index);
        } else {
            return "Invalid Operation!";
        }
    }
}
