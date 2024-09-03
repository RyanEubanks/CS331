package Constants;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class CirclePanel extends JPanel{
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g_2D = (Graphics2D)g;
        
        int thickness = 5;

        g_2D.setStroke(new BasicStroke(thickness));
        g_2D.setColor(Color.BLACK);

        g_2D.drawOval(0, 0, 50, 50);
       
    }
}
