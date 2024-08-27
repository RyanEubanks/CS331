public class Controller {
    public static void main(String[] args) {
        DeckOfCards deck1 = new DeckOfCards(1);
        for(Card card : deck1.getDeck()) {
            System.out.println(card.getSuit() + " " + card.getFace() + ": " + card.getValue());
        }

        System.out.println("===========================================");
        
        deck1.shuffleDeck();
        for(Card cards : deck1.getDeck()) {
            System.out.println(cards.getSuit() + " " + cards.getFace() + ": " + cards.getValue());
        }
    }
}