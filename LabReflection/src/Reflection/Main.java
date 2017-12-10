package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class cl = Reflection.class;
        int count = 0;
        Field[] fields = cl.getFields();
        List<String> publicFields = Arrays.stream(fields).map(Field::getName)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        System.out.println("Fields");
        for (String field : publicFields) {
            System.out.println("\t" + field + " must be private!");
        }

        String[] getters = Arrays.stream(cl.getDeclaredMethods())
                .filter(m -> m.getModifiers() == Modifier.PRIVATE)
                .map(Method::getName)
                .sorted(Comparator.naturalOrder())
                .toArray(String[]::new);

        System.out.println("Getters");
        for (String method : getters) {
            System.out.println("\t" + method + " have to be public!");
        }

        String[] setters = Arrays.stream(cl.getDeclaredMethods())
                .filter(m -> m.getModifiers() == Modifier.PUBLIC)
                .map(Method::getName)
                .sorted(Comparator.naturalOrder())
                .toArray(String[]::new);

        System.out.println("Setters");
        for (String method : setters) {
            System.out.println("\t" + method + " have to be public!");
        }
    }
}
