package GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        String line;
        Box b = new Box();

        for(int i = 0; i <n; i++) {
            line =br.readLine();
            b.add(Double.valueOf(line));
        }

        double elem = Double.valueOf(br.readLine());
        System.out.println(b.countGreater(elem));
    }
}
