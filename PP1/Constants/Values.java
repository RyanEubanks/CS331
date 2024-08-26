package Constants;
/*
 * What is going on?:
 * The Values enum store objects that hold display and card values.
 * 
 * The Ace object uses it's own constructor to initialize two different,
 * values for the use to pick later on.
 * 
 * The enum greatly simplifies the code base but hopefully it does not break it in the long run
 * 
 * 
 */
public enum Values {
    
    Ace("A", 1, 11),
    Two("2", 2),
    Three("3", 3),
    Four("4", 4),
    Five("5", 5),
    Six("6", 6),
    Seven("7", 7),
    Eight("8", 8),
    Nine("9", 9),
    Ten("10", 10),
    Jack("J", 10),
    Queen("Q", 10),
    King("K", 10);

    // variables to feed to the constructor
    private final String display;
    private final int cardValue;
    private final int cardValue1;
    private final int cardValue2;

    // Constructor for the NON-face value cards
    Values(String display, int cardValue) {
        this.display = display;
        this.cardValue = cardValue;
        this.cardValue1 = 0;
        this.cardValue2 = 0;

    }
    // Constructor for Ace card
    Values(String display, int cardValue1, int cardValue2) {
        this.display = display;
        this.cardValue = 0;
        this.cardValue1 = cardValue1;
        this.cardValue2 = cardValue2;
    }

    // Getter methods
    public int getCardValue() {
        return this.cardValue;
    }

    public int getCardValue1() {
        return this.cardValue1;
    }

    public int getCardValue2() {
        return this.cardValue2;
    }

    public String getDisplay() {
        return this.display;
    }

    
}
