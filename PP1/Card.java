public class Card {
    private String value;
    private String suit;
    
    // Card constructor
    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    // Getters and Setters
    public String getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
