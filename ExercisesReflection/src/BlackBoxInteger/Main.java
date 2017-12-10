package BlackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        Class cl = BlackBoxInt.class;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Method[] methods = cl.getDeclaredMethods();
        String line;
        String[] command;
        Constructor<BlackBoxInt> constructor = cl.getDeclaredConstructor();
        constructor.setAccessible(true);

        BlackBoxInt box = (BlackBoxInt) constructor.newInstance();


        while (true){
            line = br.readLine();
            if ("END".equalsIgnoreCase(line)){
                break;
            }

            command = line.split("_");

            for (Method m : methods) {
                if (m.getName().equals(command[0])){
                    m.setAccessible(true);
                    m.invoke(box, Integer.valueOf(command[1]));
                }
            }

            Field privateField = box.getClass().
                    getDeclaredField("innerValue");
            privateField.setAccessible(true);
            System.out.println(privateField.get(box));
        }
    }
}
