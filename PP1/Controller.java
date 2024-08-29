import javax.swing.*;

import Constants.*;

import java.awt.*;

public class Controller extends JFrame{

    //private Table table;

    public static void main(String[] args) {
        DeckOfCards deck1 = new DeckOfCards(1);

        Table table = new Table();
        table.drawBlackjackTable();
        /*
        for(Card card : deck1.getDeck()) {
            System.out.println(card.getSuit() + " " + card.getFace() + ": " + card.getValue());
        }

        System.out.println("===========================================");
        
        deck1.shuffleDeck(500);
        for(Card cards : deck1.getDeck()) {
            System.out.println(cards.getSuit() + " " + cards.getFace() + ": " + cards.getValue());
        }
        */

        

        

    }

    public void StartGame() {
        
    }

    public void drawTable() {
        setTitle("Blackjack Table");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Dealer's area
        JPanel dealerPanel = new JPanel();
        dealerPanel.setBorder(BorderFactory.createTitledBorder("Dealer's Hand"));
        dealerPanel.setPreferredSize(new Dimension(600, 100));
        dealerPanel.setBackground(new Color(34, 139, 34));  // Green background

        // Placeholder for dealer's cards
        JLabel dealerCards = new JLabel("Dealer's Cards will appear here", SwingConstants.CENTER);
        dealerPanel.add(dealerCards);

        // Player's area
        JPanel playerPanel = new JPanel();
        playerPanel.setBorder(BorderFactory.createTitledBorder("Player's Hand"));
        playerPanel.setPreferredSize(new Dimension(600, 100));
        playerPanel.setBackground(new Color(34, 139, 34));  // Green background

        // Placeholder for player's cards
        JLabel playerCards = new JLabel("Player's Cards will appear here", SwingConstants.CENTER);
        playerPanel.add(playerCards);

        // Action buttons (Hit, Stand, Double)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        JButton hitButton = new JButton("Hit");
        JButton standButton = new JButton("Stand");
        JButton doubleButton = new JButton("Double");

        buttonPanel.add(hitButton);
        buttonPanel.add(standButton);
        buttonPanel.add(doubleButton);

        // Add components to the main frame
        add(dealerPanel, BorderLayout.NORTH);
        add(playerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set frame to be visible
        setVisible(true);
    
    }
}