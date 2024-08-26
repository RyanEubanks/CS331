public class Controller {
    public static void main(String[] args) {
        DeckOfCards deck1 = new DeckOfCards(1);
        for(Card card : deck1.getDeck()) {
            System.out.print(card.getSuit());
            System.out.print(" " + card.getValue());
        }
    }
}
