package Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
    private List<Integer> froggs = new ArrayList<>();

    public void addFrog(Integer... frog){
        this.froggs.addAll(Arrays.asList(frog));
    }

    public List<Integer> getFroggs() {
        return this.froggs;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer>{
        private int index = -2;
        private int size = froggs.size();

        @Override
        public boolean hasNext() {
            if (size%2 == 0) {
                if (index + 2 == froggs.size()) {
                    index = -1;
                }
            } else{
                if (index + 1 == froggs.size()) {
                    index = -1;
                }
            }
            return index +2 <  froggs.size();
        }

        @Override
        public Integer next() {
            if (this.hasNext()) {
                index+=2;
                return froggs.get(index);
            }

            return null;
        }
    }
}
