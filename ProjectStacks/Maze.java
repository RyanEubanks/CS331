package ProjectStacks;
import java.util.Stack;
import java.util.Random;

/*
 * Implement the optimistic alg for solving maze
 * 
 * 
 */

public class Maze {

    public static void main(String[] args) {
        
    }

    public void createMaze(int width, int height) {
        String[][] maze = new String[width][height];

        // left side is 0, top is 1, right is 2, bottom is 3
        Random random = new Random();
        int n = random.nextInt(4);

        switch(n) {
            case 0 -> {
                int ny = random.nextInt(height);
                maze[0][ny] = "o";
            }
            case 1 -> {
                int nx = random.nextInt(width);
                maze[0][nx] = "o";
            }
            case 2 -> {
                int ny = random.nextInt(height);
                maze[0][ny] = "o";
            }
            case 3 -> {
                int nx = random.nextInt(width);
                maze[0][nx] = "o";
            }
        }

    }
}
