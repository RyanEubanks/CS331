package ProjectStacksV2;

import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {
        int[][] maze = {
            {1, 2, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 1, 0, 1},
            {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 3, 1}
        };

        Maze mazePanel = new Maze(1, 1, maze, 10, 10);
        JFrame frame = new JFrame("Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mazePanel);
        frame.setSize(1000, 1000);
        frame.setVisible(true);

        
    }
}
