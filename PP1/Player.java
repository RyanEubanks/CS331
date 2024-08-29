import Constants.Values;

public class Player {
    private Card[] hand;
    private int chipTotal;
    private int handTotal;


    public Player(Card[] hand, int chipTotal, int handTotal) {
        this.hand = hand;
        this.chipTotal = chipTotal;
        this.handTotal = handTotal;
    }

    public void drawCard(DeckOfCards deck) {
        drawCard(deck);
    }

    // getters and setters
    /* 
    public String getName() {
        return this.name;
    }
    */

    public Card[] getHand() {
        return hand;
    }

    public int getHandTotal() {
        int total = 0;
        for(Card card : this.hand) {
            if(card.getFace().equals(Values.Ace.getDisplay()) && total > 21) {
                total += Values.Ace.getCardValue1();
            }
            else if(card.getFace().equals(Values.Ace.getDisplay()) && total <= 21) {
                total += Values.Ace.getCardValue2();
            }
            else {
                total += card.getValue();
            }
            
        }
        return total;
    }

    public int getChipTotal() {
        return chipTotal;
    }

    public void setChipTotal(int chipTotal) {
        this.chipTotal = chipTotal;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }

    public void setHandTotal(int handTotal) {
        this.handTotal = handTotal;
    }

}
