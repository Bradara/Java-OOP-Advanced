package HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    private static Class cl = RichSoilLand.class;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();

        while (!"HARVEST".equalsIgnoreCase(line = br.readLine())) {
            switch (line) {
                case "private":
                    sb.append(printPrivateFields());
                    break;
                case "protected":
                    sb.append(printProtectedFields());
                    break;
                case "public":
                    sb.append(printPublicFields());
                    break;
                case "all":
                    sb.append(printAllFields());
                    break;

            }
        }

        System.out.println(sb);
    }

    private static String printAllFields() {
        StringBuilder sb = new StringBuilder();
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            sb.append(String.format("%s %s %s%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
        }

        return sb.toString();
    }

    private static String printPublicFields() {
        StringBuilder sb = new StringBuilder();
        Field[] fields = cl.getFields();
        for (Field field : fields) {
           sb.append(String.format("%s %s %s%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
        }

        return sb.toString();
    }

    private static String printProtectedFields() {
        StringBuilder sb = new StringBuilder();
        Field[] fields = Arrays.stream(cl.getDeclaredFields()).filter(f -> f.getModifiers() == Modifier.PROTECTED).toArray(Field[]::new);
        for (Field field : fields) {
            sb.append(String.format("%s %s %s%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
        }

        return sb.toString();
    }

    private static String printPrivateFields() {
        StringBuilder sb = new StringBuilder();
        Field[] fields = Arrays.stream(cl.getDeclaredFields()).filter(f -> f.getModifiers() == Modifier.PRIVATE).toArray(Field[]::new);
        for (Field field : fields) {
            sb.append(String.format("%s %s %s%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
        }

        return sb.toString();
    }
}
