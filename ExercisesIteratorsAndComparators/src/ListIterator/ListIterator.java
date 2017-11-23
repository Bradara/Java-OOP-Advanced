package ListIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIterator {
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

    public String print(){
        if (this.collection.size() > 0) {
            return collection.get(index);
        } else {
            return "Invalid Operation!";
        }
    }
}
