package Constants;
import javax.swing.*;
import java.awt.*;

public class Table extends JFrame {
    
    // make this a player object variable
    private double playerMoney = 1000.00;

    public Table() {
        setTitle("Blackjack Table");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        createMenuBar();

        drawTable();
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Player's money
        JMenu moneyMenu = new JMenu("Money: $" + String.format("%.2f", playerMoney));

        menuBar.add(moneyMenu);
        setJMenuBar(menuBar);
    }

    public void drawTable() {
        // Dealer's area
        JPanel dealerPanel = new JPanel();
        dealerPanel.setBorder(BorderFactory.createTitledBorder("Dealer's Hand"));
        dealerPanel.setPreferredSize(new Dimension(600, 100));
        dealerPanel.setBackground(new Color(34, 139, 34));  // Green background

        JLabel dealerCards = new JLabel("Dealer's Cards will appear here", SwingConstants.CENTER);
        dealerPanel.add(dealerCards);

        // Player's area
        JPanel playerPanel = new JPanel();
        playerPanel.setBorder(BorderFactory.createTitledBorder("Player's Hand"));
        playerPanel.setPreferredSize(new Dimension(600, 100));
        playerPanel.setBackground(new Color(34, 139, 34));  // Green background

        JLabel playerCards = new JLabel("Player's Cards will appear here", SwingConstants.CENTER);
        playerPanel.add(playerCards);

        // Action buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        JButton hitButton = new JButton("Hit");
        JButton standButton = new JButton("Stand");
        JButton doubleButton = new JButton("Double");

        buttonPanel.add(hitButton);
        buttonPanel.add(standButton);
        buttonPanel.add(doubleButton);

        add(dealerPanel, BorderLayout.NORTH);
        add(playerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

}