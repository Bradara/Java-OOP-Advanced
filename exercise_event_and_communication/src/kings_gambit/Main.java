package kings_gambit;

import kings_gambit.Post.Footman;
import kings_gambit.Post.King;
import kings_gambit.Post.RoyalGuard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        King king = new King(br.readLine());

        for (String s : br.readLine().split("\\s+")) {
            king.addToCourt(new RoyalGuard(s));
        }

        for (String s : br.readLine().split("\\s+")) {
            king.addToCourt(new Footman(s));
        }

        String[] input;

        while (!"end".equalsIgnoreCase(line = br.readLine())) {
            input = line.split("\\s+");

            if ("kill".equalsIgnoreCase(input[0]))
                king.kill(input[1]);

            if ("Attack King".equalsIgnoreCase(line))
                king.attack();
        }
    }
}
