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

    private static Cell getRandomEdge(int rows, int cols) {
        Random random = new Random();
        int edge = random.nextInt(4); 
        int x = 0, y = 0;
        // 0 = top, 1 = bottom, 2 = left, 3 = right
        
        switch (edge) {
            case 0: // Top edge
                x = 0;
                y = random.nextInt(cols);
                break;
            case 1: // Bottom edge
                x = rows - 1;
                y = random.nextInt(cols);
                break;
            case 2: // Left edge
                x = random.nextInt(rows);
                y = 0;
                break;
            case 3: // Right edge
                x = random.nextInt(rows);
                y = cols - 1;
                break;
        }

        return new Cell(x, y);
    }

    /*
     * might consider creating varibles for these numbers so it is easier to read the code
     * Entrance: 0
     * Path:0
     * Wall: 1
     * Exit: 2
     */
    public int[][] generateMaze(int rows, int cols) {
        // important variables
        int [][] maze = new int[rows][cols];
        Cell entrance = getRandomEdge(rows, cols);
        Cell exit = getRandomEdge(rows, cols);
        Stack<Cell> depth = new Stack<>();

        // fill the maze with walls
        for(int i = 0; i < rows; i++) {
            for(int k = 0; k < cols; k++) {
                maze[i][k] = 1;
            }
        }

        // making sure that the entrance does not spawn ontop of the exit
        while(entrance.x == exit.x && entrance.y == exit.y) {
            exit = getRandomEdge(rows, cols);
        }

        // setting the enterance and exit
        maze[entrance.x][entrance.y] = 0;
        maze[exit.x][exit.y] = 2;

        // making the path for backtracking (with stack)
        depth.push(entrance);
        maze[entrance.x][entrance.y] = 0;

        while(!depth.isEmpty()) {
            Cell current = depth.pop();
            int x = current.x;
            int y = current.y;

            // get the nonvisited cells
            
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
