package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;
        Stack<Integer> stack = new Stack();

        while(true){
            line = br.readLine().split("[,\\s]+");
            if ("End".equalsIgnoreCase(line[0])){
                break;
            }

            switch (line[0]){
                case "Push":
                    Integer[] elements = Arrays.stream(Arrays.copyOfRange(line, 1, line.length)).map(Integer::parseInt).toArray(Integer[]::new);
                    stack.push(elements);
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (IllegalAccessException iae){
                        System.out.println(iae.getMessage());
                    }
                    break;
            }
        }

        for (Integer i : stack) {
            System.out.println(i);
        }
        for (Integer i : stack) {
            System.out.println(i);
        }
    }
}
