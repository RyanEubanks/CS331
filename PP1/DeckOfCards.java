import java.util.HashMap;

public class DeckOfCards {
    
    private Card deck[];
    private int deckNumber;

    // getting rid of these soon because I'm sigma
    private String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private HashMap<String, Integer> faceCards = new HashMap<>();

    
    // deck constructor needs to invoke the populateDeck function to create the cards.
    public DeckOfCards() {
       
    }

    public void populateDeck() {
        this.deck = new Card[52];
        

        for(Card card : deck) {
            
        }
    }

    
}
