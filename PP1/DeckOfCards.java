import java.util.HashMap;
import java.util.Random;

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

public void shuffleDeck(int shuffles) {
        
        Random random = new Random();
        int splitNum = random.nextInt(1,52);
        Card[] splitDeck = new Card[52];

        for(int i = 0; i < 52; i++) {
            if(i < splitNum) {
                splitDeck[52-splitNum] = deck[i];
            } else {
                splitDeck[i-splitNum] = deck[i];
            }
        }

        shuffles--;
        this.deck = splitDeck;
        if(shuffles > 0) {
            shuffleDeck(shuffles);
        }

    }

}
