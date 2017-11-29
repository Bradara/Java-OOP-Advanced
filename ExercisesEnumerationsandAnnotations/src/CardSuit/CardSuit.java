package CardSuit;

@CardAnnotation(category = "Suit", description = "Provides suit constants for a Card class.")
public enum CardSuit {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private int suit;

    CardSuit(int suit) {
        this.suit = suit;
    }
}
