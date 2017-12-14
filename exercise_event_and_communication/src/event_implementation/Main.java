package event_implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Disparcher disparcher = new Disparcher();
        NameChenge nameChenge;
        Handler handler = new Handler(disparcher);

        while (!"end".equalsIgnoreCase(line = br.readLine())) {
            nameChenge = new NameChenge(line);
            handler.nameChengeEvent(nameChenge);
        }
    }
}
