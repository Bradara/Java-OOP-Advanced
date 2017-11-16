package BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Identify> residents = new ArrayList<>();
    private static List<Birthable> creations = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!(line = br.readLine()).equalsIgnoreCase("End")) {
            String[] input = line.split("\\s+");

            switch (input[0]){
                case "Citizen": creations.add(new Citizen(input[1], input[2], input[3], input[4])); break;
                case "Pet": creations.add(new Pet(input[1], input[2])); break;
            }
        }

        String detainNum = br.readLine();

        creations.stream().filter(c-> c.getBirthDate().endsWith(detainNum)).forEach(c -> System.out.println(c.getBirthDate()));
    }
}
