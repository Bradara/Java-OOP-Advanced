package CardSuit;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Enum[] ranks = CardRank.values();
        Enum[] suits = CardSuit.values();

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                System.out.printf("%s of %s%n",ranks[j].name(), suits[i].name());
            }
        }
    }
}