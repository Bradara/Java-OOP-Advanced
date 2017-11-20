package GenericSwap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        Swap swap = new Swap();

        for (int i = 0; i < n; i++) {
            swap.add(Integer.valueOf(br.readLine()));
        }

        int[] indices = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        swap.swap(indices[0], indices[1]);

        System.out.println(swap);
    }
}
