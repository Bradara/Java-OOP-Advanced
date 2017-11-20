package CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> list = new CustomList<String>();
        String[] line;

        while (true) {
            line = br.readLine().split("\\s+");
            if ("end".equalsIgnoreCase(line[0])) {
                break;
            }

            switch (line[0]) {
                case "Add":
                    list.add(line[1]);
                    break;
                case "Remove":
                    list.remove(Integer.valueOf(line[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(line[1]));
                    break;
                case "Swap":
                    list.swap(Integer.valueOf(line[1]), Integer.valueOf(line[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(line[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    for (int i = 0; i < list.getLists().size(); i++) {
                        System.out.println(list.getLists().get(i));
                    }
                    break;

            }

        }

    }
}
