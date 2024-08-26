package Constants;

public enum Values {
    
    Two("2", 2),
    Three("3", 3),
    Four("4", 4),
    Five("5", 5),
    Six("6", 6);

    // variables to feed to the constructor
    private final String display;
    private final int cardValue;

    Values(String display, int cardValue) {
        this.display = display;
        this.cardValue = cardValue;
    }
    

    
}
