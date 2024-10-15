package ProjectStacksV2;
import java.awt.Point;
import java.util.Stack;


public class MazeSolver {
    private final Maze mazePanel;
    private final int[][] maze;
    private final int entranceRow, entranceCol;
    private final int exitRow, exitCol;

    // Directions for movement:          West,    East,   North,   South
    private final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    // Constants
    private static final int WALL = 1;
    private static final int PATH = 0;
    private static final int ENTRANCE = 2;
    private static final int EXIT = 3;
    private static final int FINAL_PATH = 5;

    /* Stack to store the path of the creature
     * Point is a type the stores (x,y) coordinates
     */ 
    private Stack<Point> stack;

    // constructor
    public MazeSolver(Maze mazePanel, int[][] maze, int entranceRow, int entranceCol, int exitRow, int exitCol) {
        this.mazePanel = mazePanel;
        this.maze = maze;
        this.entranceRow = entranceRow;
        this.entranceCol = entranceCol;
        this.exitRow = exitRow;
        this.exitCol = exitCol;
        this.stack = new Stack<>();
    }

    // Method to solve the maze
    public boolean solveMaze() {
        return findPath(entranceRow, entranceCol);
    }

    // Recursive method to find the path
    private boolean findPath(int row, int col) {
        System.out.println("At (" + row + ", " + col + ")"); 

        // Base case that checks for the exit
        if (row == exitRow && col == exitCol) {
            stack.push(new Point(row, col));  
            markFinalPath(); 
            return true;
        }

        // Check if the current position is inside the maze and not a wall
        if (!isValidMove(row, col)) {
            return false;
        }

        // Mark the current cell as part of the path
        // it says final path rn but it will get changed back to path if it is not the final path
        stack.push(new Point(row, col));
        maze[row][col] = FINAL_PATH;

        // Try to move in all directions
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            System.out.println("Trying to move to: (" + newRow + ", " + newCol + ")");

            // True if the exit is found
            if (findPath(newRow, newCol)) {
                return true;
            }
        }

        /*
         * If no path found, reset the current cell
         * Remove the current point from the stack
         * and mark it back as a clear path
         */
        stack.pop();
        maze[row][col] = PATH;
        return false;
    }


    private boolean isValidMove(int row, int col) {
        System.out.println("Checking move to: (" + row + ", " + col + ")");

        // Check if the new position is within the bounds of the maze
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length) {
            return false;
        }
    
        // Check if the cell is a wall
        if (maze[row][col] == WALL) {
            return false;
        }
    
        return maze[row][col] == PATH;
    }

    

    // Marks the final path in red after solving the maze
    private void markFinalPath() {
        
        for (Point p : stack) {
            maze[p.x][p.y] = FINAL_PATH;
        }
        mazePanel.updateMaze();
    }
}


