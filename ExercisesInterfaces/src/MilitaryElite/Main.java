package MilitaryElite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SoldierManager sm = new SoldierManager();
        String line;
        String[] input;
        String[] corps;
        StringBuilder result = new StringBuilder();

        while (!"End".equalsIgnoreCase((line = br.readLine()))){
            input = line.split("\\s+");

            switch (input[0]){
                case "Private":
                    result.append(sm.addPrivate(input[1], input[2], input[3], Double.valueOf(input[4])));break;
                case "Commando":
                    corps = Arrays.copyOfRange(input, 5, input.length);
                    result.append(sm.addCommando(input[1], input[2], input[3], Double.valueOf(input[4]), corps)); break;
                case "LeutenantGeneral":
                    String[] privates = Arrays.copyOfRange(input, 5, input.length);
                    result.append(sm.addLeutenantGeneral(input[1], input[2], input[3], Double.valueOf(input[4]), privates));break;
                case "Spy":
                    result.append(sm.addSpy(input[1], input[2], input[3], input[4]));break;
                case "Engineer":
                    corps = Arrays.copyOfRange(input, 5, input.length);
                    result.append(sm.addEngineer(input[1], input[2], input[3], Double.valueOf(input[4]), corps));
            }
        }

        System.out.println(result);
    }
}
