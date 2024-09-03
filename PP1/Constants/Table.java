package Constants;
import javax.swing.*;
import java.awt.*;


public class Table extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Call the parent's paintComponent method

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the color of the table
        g2d.setColor(new Color(34, 139, 34));  // Green felt color

        // Get the size of the panel
        int width = getWidth();
        int height = getHeight();

        // Calculate the size and position of the semi-circle table
        int diameter = Math.min(width, height) - 20;  // Adjust the diameter to fit the panel with padding
        int x = (width - diameter) / 2;  // Center the semi-circle horizontally
        int y = height / 2 - diameter / 2;  // Position the semi-circle at the bottom half of the panel

        // Draw the semi-circle (arc)
        g2d.fillArc(x, y, diameter, diameter, 0, 180);  // Arc from 0 to 180 degrees (semi-circle)

        // Draw seats or betting positions (circles around the table)
        g2d.setColor(Color.BLACK);
        int seatRadius = 30;  // Radius of each seat
        int numberOfSeats = 7;  // Number of seats around the table
        double angleStep = 180.0 / (numberOfSeats + 1);  // Evenly distribute the seats

        for (int i = 1; i <= numberOfSeats; i++) {
            double angle = Math.toRadians(angleStep * i);  // Convert angle to radians
            int seatX = (int) (width / 2 + (diameter / 2 - seatRadius - 10) * Math.cos(angle)) - seatRadius;
            int seatY = (int) (height / 2 - (diameter / 2 - seatRadius - 10) * Math.sin(angle)) - seatRadius;
            g2d.fillOval(seatX, seatY, seatRadius * 2, seatRadius * 2);
        }
        
    }

    @Override
    public Dimension getPreferredSize() {
        // Set the preferred size of the panel
        return new Dimension(600, 400);
    }
/* 
    public Table() {
        setTitle("Blackjack Table");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    public void drawTable() {
        // Dealer's area
        JPanel dealerPanel = new JPanel();
        dealerPanel.setBorder(BorderFactory.createTitledBorder("Dealer's Hand"));
        dealerPanel.setPreferredSize(new Dimension(600, 100));
        // (34,139,34) is green
        dealerPanel.setBackground(new Color(34, 139, 34));

        JLabel dealerCards = new JLabel("Dealer's Cards will appear here", SwingConstants.CENTER);
        dealerPanel.add(dealerCards);

        // Player's area
        JPanel playerPanel = new JPanel();
        playerPanel.setBorder(BorderFactory.createTitledBorder("Player's Hand"));
        playerPanel.setPreferredSize(new Dimension(600, 100));
        playerPanel.setBackground(new Color(34, 139, 34));  // Green background

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

        // Add components
        add(dealerPanel, BorderLayout.NORTH);
        add(playerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
*/

}