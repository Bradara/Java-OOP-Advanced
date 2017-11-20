package ListUtils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils<T> {

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException("");
        }
        T result = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            T temp = list.get(i);
            if (temp.compareTo(result) < 0) {
                result = temp;
            }
        }

        return result;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        T result = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            T temp = list.get(i);
            if (temp.compareTo(result) > 0) {
                result = temp;
            }
        }

        return result;
    }

    public static <T> List<Integer> getNullIndices(List<T> list){
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            T temp = list.get(i);
            if (temp == null) {
                indices.add(i);
            }
        }

        return indices;
    }

    public static <T> void flatten(List<T> destination, List<List<T>> source){
        for (List<T> aSource : source) {
            destination.addAll(aSource);
        }
    }

    public static <T> void addAll(List<T> destination, List<T> source){
        destination.addAll(source);
    }
}
