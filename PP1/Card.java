public class Card {
    private String face;
    private String suit;
    private int value;
    
    // Card constructor
    public Card(String face, String suit, int value) {
        this.face = face;
        this.suit = suit;
        this.value = value;
    }
   
    // Getters and Setters
    public String getFace() {
        return face;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public int getValue() {
        return value;
    }
}
