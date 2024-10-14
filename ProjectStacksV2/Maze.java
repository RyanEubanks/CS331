package ProjectStacksV2;

import javax.swing.*;
import java.awt.*;

public class Maze extends JPanel {
    private int entranceRow, entranceCol;
    private int exitRow, exitCol;
    private int[][] maze;
    private int rows, cols;

    private static final int WALL = 1;
    private static final int PATH = 0;


    Maze(int entranceRow, int entranceCol, int[][] maze, int rows, int cols) {
        this.entranceRow = entranceRow;
        this.entranceCol = entranceCol;
        this.maze = maze;
        this.rows = maze.length;
        this.cols = maze[0].length;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int row = 0; row < this.rows; row++) {
            for(int col = 0; col < this.cols; col++) {
                if(maze[row][col] == WALL) {
                    g.setColor(Color.BLACK);
                    g.fillRect(col * 50, row * 50, 50, 50);
                } 
                else if(maze[row][col] == PATH) {
                    g.setColor(Color.WHITE);
                    g.fillRect(col * 50, row * 50, 50, 50);
                } 
            }
        }
    }

    // getters and setters
    public int getEntranceRow() {
        return entranceRow;
    }

    public void setEntranceRow(int entranceRow) {
        this.entranceRow = entranceRow;
    }

    public int getEntranceCol() {
        return entranceCol;
    }

    public void setEntranceCol(int entranceCol) {
        this.entranceCol = entranceCol;
    }

    public int getExitRow() {
        return exitRow;
    }

    public void setExitRow(int exitRow) {
        this.exitRow = exitRow;
    }

    public int getExitCol() {
        return exitCol;
    }

    public void setExitCol(int exitCol) {
        this.exitCol = exitCol;
    }

    public int[][] getMaze() {
        return maze;
    }

    public void setMaze(int[][] maze) {
        this.maze = maze;
    }

}
