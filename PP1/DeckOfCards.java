import java.util.HashMap;
import java.util.Random;

import Constants.Suits;
import Constants.Values;

public class DeckOfCards {
    
    private Card deck[];
    private int deckNumber;
    private int drawnCards;

    // getting rid of these soon because I'm sigma
    //private String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    //private HashMap<String, Integer> faceCards = new HashMap<>();


    
    // deck constructor needs to invoke the populateDeck function to create the cards.
    public DeckOfCards(int deckNumber) {
       this.deckNumber = deckNumber;
       this.drawnCards = 0;
       populateDeck();
    }

    public void populateDeck() {
        this.deck = new Card[52];
        
        int counter = 0;
        
        

            for(Enum<Suits> suit : Suits.values()) {
                for(Values value : Values.values()) {
                    if(value.getDisplay().equals("A")) {
                        deck[counter] = new Card(value.getDisplay(), suit.toString(), value.getCardValue2());
                    } 
                    else {
                        deck[counter] = new Card(value.getDisplay(), suit.toString(), value.getCardValue());
                    }
                    counter++;
                    if(counter == 52) { return; }
                }
            }
            
        
    }

    public void shuffleDeck(int shuffles) {
        
        Random random = new Random();
        int splitNum = random.nextInt(1,52);
        // temp array
        Card splitDeck[] = new Card[52];

        //System.out.println("[" + splitNum + "]");

        for(int i = 0; i < 52; i++) {
            if(i < splitNum) {
                splitDeck[52-splitNum+i] = deck[i];
                //System.out.println(splitDeck[52-splitNum].getValue());
            } else {
                //System.out.println("This works");
                splitDeck[i-splitNum] = deck[i];
                //System.out.println(splitDeck[i-splitNum].getValue());
            }

        }

        /*
        for(int i = 0; i < 52; i++) {
            System.out.println("Test" + splitDeck[i].getValue());
        }
        */

        shuffles--;

        this.deck = splitDeck;

        /*
        for(int i = 0; i < 52; i++) {
            this.deck[i] = splitDeck[i];
            //System.out.println("Hi" + deck[i].getValue());
        }
        */
        if(shuffles > 0) {
            shuffleDeck(shuffles);
        } else {
            this.drawnCards = 0;
        }

    }

    // Fisher-Yates Algorithm (apparently it's good)
    public void shuffleDeck() {
        Random random = new Random();
        
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }

        this.drawnCards = 0;
    }
    
    public Card drawCard(int drawnCard) {
        drawnCard++;
        return this.deck[this.drawnCards-1];
    }

    public Card[] getDeck() {
        return this.deck;
    }
}
