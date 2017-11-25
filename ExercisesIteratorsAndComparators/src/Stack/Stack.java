package Stack;

import java.util.*;

public class Stack<Integer> implements Iterable<Integer> {
    private List<Integer> elements;
    private int index;

    public Stack(){
        this.elements = new ArrayList<>();
        this.index = 0;
    }

    public void push(Integer... el){
        this.elements.addAll(Arrays.asList(el));
    }

    public Integer pop() throws IllegalAccessException {
        if (this.elements.size() > 0){
            int lastIndex = this.elements.size()-1;
            Integer last = this.elements.get(lastIndex);
            this.elements.remove(lastIndex);
            return last;
        }

        throw new IllegalAccessException("No elements");
    }



    @Override
    public IntIterator iterator() {
        return new IntIterator();
    }

    public class IntIterator implements Iterator<Integer>{
        private int index = elements.size();

        @Override
        public boolean hasNext() {
            return index - 1 >=0;
        }

        @Override
        public Integer next() {
            if(this.hasNext()){
                return elements.get(--index);
            }

            return null;
        }
    }
}