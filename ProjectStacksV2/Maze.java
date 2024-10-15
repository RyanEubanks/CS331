package ProjectStacksV2;
import javax.swing.*;
import java.awt.*;

public class Maze extends JPanel {
    private final int[][] maze;

    public Maze(int[][] maze) {
        this.maze = maze;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize = 20; 

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                switch (maze[row][col]) {
                    case 0 -> g.setColor(Color.WHITE);  // Path
                    case 1 -> g.setColor(Color.BLACK);  // Wall
                    case 2 -> g.setColor(Color.BLUE);   // Entrance
                    case 3 -> g.setColor(Color.GREEN);  // Exit
                    case 5 -> g.setColor(Color.RED);    // Final Path
                    
                }
                g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                //? paints the grid
                g.setColor(Color.BLACK);
                g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);
            }
        }
    }

    // repaints the maze
    public void updateMaze() {
        repaint();
    }
}
