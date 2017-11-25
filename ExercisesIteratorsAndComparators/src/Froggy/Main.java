package Froggy;
;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Integer[] input;
        Lake lake = new Lake();

        while(!"END".equalsIgnoreCase(line = br.readLine())){
            input = Arrays.stream(line.split(",?\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
            lake.addFrog(input);
        }

        List<String> result = new ArrayList<>();

        for (Integer i : lake) {
            result.add(i.toString());
        }

        System.out.println(String.join(", ", result));
    }
}
