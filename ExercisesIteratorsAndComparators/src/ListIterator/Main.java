package ListIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ListIterator iterator = new ListIterator();
        String[] line;

        while (true) {
            line = br.readLine().split("\\s+");

            if ("End".equalsIgnoreCase(line[0])) {
                break;
            }

            switch (line[0]) {
                case "Create":
                    if (line.length > 1 ) {
                        iterator.setCollection(Arrays.copyOfRange(line, 1, line.length));
                    }
                    break;
                case "Move":
                    System.out.println(iterator.move());
                    break;
                case "Print":
                    System.out.println(iterator.print());
                    break;
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;
                default:
                    break;
            }
        }
    }
}