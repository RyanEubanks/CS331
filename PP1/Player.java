import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Constants.*;

public class Player extends JFrame{
    private String name;
    private Card[] hand;
    private int chipTotal;
    private int handTotal;


    public Player(Card[] hand, int chipTotal, int handTotal, String name) {
        this.hand = hand;
        this.chipTotal = chipTotal;
        this.handTotal = handTotal;
        this.name = name;
    }

    public void drawCard(DeckOfCards deck) {
        drawCard(deck);
    }

    public void drawPlayerIcon(String name) {
        CirclePanel c = new CirclePanel();
        JLabel playerName = new JLabel();

        playerName.setText(name);
        c.add(playerName);
        setVisible(true);
        
    }

    // getters and setters
    public String getName() {
        return this.name;
    }
    

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
