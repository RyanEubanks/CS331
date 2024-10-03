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

    public void updateMaze() {
        // arrSize - [5][5]
        // exit - [3][4] = 0
        // ent - [1][0]

        /*
            {
            7,e,5,4,5
            6,5,4,3,4
            5,4,3,2,3
            4,3,2,1,2
            3,2,1,x,1
            }
        */

        //! absoluteDifference : [3][4] - [2][4] = 1 | [3][4] - [1][0] = 6 | [3][4] - [4][0] = 5

        // [2][4] = 1
        // [1][4] = 2
        // [0][4] = 3
        // [1][3] = 3
    }

    public void floodFill() {
        // if options < posVal
            // if inStack - pop
            // else - push
        // else - increaseVals
    }
}
