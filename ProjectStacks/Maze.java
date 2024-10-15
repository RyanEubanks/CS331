package ProjectStacks;
import java.util.Stack;

import java.util.Random;

/*
 * Implement the optimistic alg for solving maze
 * 
 */

public class Maze {

    public Maze(int[][] maze2, int entranceRow, int entranceCol, int exitRow, int exitCol) {
        //TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        int[] cell = {0, 0};
        System.out.println("x: " + cell[0]);
        System.out.println("y: " + cell[1]);
        int rows = 11;
        int cols = 11;

        //int[][] maze = generateMaze(rows, cols);
        //printMaze(maze);
        //floodFill(maze);
    }

    public static int[] getRandomEdge(int rows, int cols) {
        Random random = new Random();
        int edge = random.nextInt(4);
        int x = 0, y = 0;
        
        switch (edge) {
            case 0 -> { // Top edge
                x = 0;
                y = random.nextInt(cols);
            }
            case 1 -> { // Bottom edge
                x = rows - 1;
                y = random.nextInt(cols);
            }
            case 2 -> { // Left edge
                x = random.nextInt(rows);
                y = 0;
            }
            case 3 -> { // Right edge
                x = random.nextInt(rows);
                y = cols - 1;
            }
        }
        return new int[]{x, y};
    }

    /*
     * might consider creating varibles for these numbers so it is easier to read the code
     * Entrance: 0
     * Path:0
     * Wall: 1
     * Exit: 2
     */

     private static class Coordinates {
        int row;
        int col;
        Coordinates(int row, int col) {
            this.row = row;
            this.col = col;
        }
     }

     public static int[][] SolveMaze(Maze maze) {
        Stack<Coordinates> stack = new Stack<>();

     }

     /* 
    public static int[][] generateMaze(int rows, int cols) {
        int[][] maze = new int[rows][cols];
        int[] entrance = getRandomEdge(rows, cols);
        int[] exit = getRandomEdge(rows, cols);
        Stack<int[]> depth = new Stack<>();
    
        // Fill the maze with walls
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < cols; k++) {
                maze[i][k] = 1; // Fill with walls
            }
        }
    
        // Ensure entrance and exit are not at the same location
        while (entrance[0] == exit[0] && entrance[1] == exit[1]) {
            exit = getRandomEdge(rows, cols);
        }
    
        // Set entrance as 3 and exit as 2
        maze[entrance[0]][entrance[1]] = 3; // Entrance is now marked as 3
        maze[exit[0]][exit[1]] = 2; // Exit is still 2
    
        // Initialize stack with the entrance
        depth.push(entrance);
    
        while (!depth.isEmpty()) {
            int[] current = depth.pop();
            int x = current[0];
            int y = current[1];
    
            // Get random directions
            int[] directions = {0, 1, 2, 3}; // Up, Down, Left, Right
            shuffle(directions);
    
            boolean moved = false; // Track whether a move was made
    
            for (int direction : directions) {
                int nX = x, nY = y;
    
                switch (direction) {
                    case 0 -> nY -= 2; // Up
                    case 1 -> nY += 2; // Down
                    case 2 -> nX -= 2; // Left
                    case 3 -> nX += 2; // Right
                }
    
                // Check if we can move to the next cell
                if (isValidMove(nX, nY, rows, cols) && maze[nX][nY] == 1) {
                    // Create a path
                    maze[(x + nX) / 2][(y + nY) / 2] = 0; // Remove wall between current and next cell
                    maze[nX][nY] = 0; // Carve out the next cell
                    depth.push(new int[]{nX, nY});
                    moved = true;
                }
            }
    
            // If no valid move was made, backtrack
            if (!moved) {
                System.out.println("Backtracking from: " + x + ", " + y);
            }
        }
        return maze;
    }

    */
    public static int[] shuffle(int[] arr) {
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    public static boolean isValidMove(int x, int y, int rows, int cols) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }

    public static void printMaze(int[][] maze) {
        maze[0][0] = 4;
        for (int[] row : maze) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
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

    
    public static void floodFill(int[][] maze) {
        
        Stack<int[]> mazeRoute = new Stack<>();     // each element consists of 2 values, row coord and column coord
        int[] element = new int[2];
        int floodVal = maze[mazeRoute.peek()[0]][mazeRoute.peek()[1]];      // floodVal of current tile

        // if options < posVal
        element = checkOptions(mazeRoute.peek(), maze, floodVal);
        if(element != null) {
            // if inStack - pop
            if(element == mazeRoute.peek()) {
                mazeRoute.pop();
            // else - push
            } else {
                mazeRoute.push(element); 
            }
        // else - increaseVals
        } else {
            // This works by 
        }
    }

    public static int[] checkOptions(int[] options, int[][] maze, int floodVal) {

        int xCoord = options[0];
        int yCoord = options[1];

        // Checking if values bordering our current location are less than our current floodFill value
        if(floodVal > maze[xCoord+1][yCoord]) {
            int[] newCoord = {xCoord+1, yCoord, maze[xCoord+1][yCoord]};
            return newCoord;
        } else if(floodVal > maze[xCoord][yCoord+1]) {
            int[] newCoord = {xCoord, yCoord+1, maze[xCoord][yCoord+1]};
            return newCoord;
        } else if(floodVal > maze[xCoord-1][yCoord]) {
            int[] newCoord = {xCoord-1, yCoord, maze[xCoord-1][yCoord]};
            return newCoord;
        } else if(floodVal > maze[xCoord][yCoord-1]) {
            int[] newCoord = {xCoord, yCoord-1, maze[xCoord][yCoord-1]};
            return newCoord;
        } else {
            return null;
        }
    }
        

        
}