package ProjectStacks;
import java.util.Stack;
import java.util.Random;

/*
 * Implement the optimistic alg for solving maze
 * 
 */

public class Maze {

    public static void main(String[] args) {
        int rows = 11;
        int cols = 11;

        int [][] maze = generateMaze(rows, cols);
        printMaze(maze);
    }

    private static Cell getRandomEdge(int rows, int cols) {
        Random random = new Random();
        int edge = random.nextInt(4); 
        int x = 0, y = 0;
        // 0 = top, 1 = bottom, 2 = left, 3 = right
        
        switch (edge) {
            // Top edge
            case 0:
                x = 0;
                y = random.nextInt(cols);
                break;
            // Bottom edge
            case 1:
                x = rows - 1;
                y = random.nextInt(cols);
                break;
            // Left edge
            case 2:
                x = random.nextInt(rows);
                y = 0;
                break;
            // Right edge
            case 3:
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
    public static int[][] generateMaze(int rows, int cols) {
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

            // get to a nonvisited cells by randomly picking a direction when you backtrack
            int[] directions = {0, 1, 2, 3};
            shuffle(directions);

            // this loop carves through the walls making the paths and updating coords
            for(int direction: directions) {
                
                /*
                 * This loop is low-key kinda diabolical but idrc
                 * 0 -> up
                 * 1 -> down
                 * 2 -> left
                 * 3 -> right
                 * 
                 * the new switch statment syntax is cool, it gets rid of the ugly break statment
                 * while also limiting the scope of a var to a single block instead of the whole switch statement
                 */
                switch(direction) {
                    case 0 -> {
                        int nX = x;
                        int nY = y - 2; // subtracting 2 to go up hurt brain
                        if(isVaildMove(nX, nY, rows, cols)) {
                            // braking through walls if we in bounds
                            maze[x][y - 1] = 0; //! A path is = 0, I could probably turn it into a variable later
                            maze[nX][nY] = 0;
                            depth.push(new Cell(nX, nY));
                        }
                    }
                    case 1 -> {
                        int nX = x;
                        int nY = y + 2;
                        if(isVaildMove(nX, nY, rows, cols)) {
                            maze[x][y + 1] = 0;
                            maze[nX][nY] = 0;
                            depth.push(new Cell(nX, nY));
                        }
                    }
                    case 2 -> {
                        int nX = x - 2;
                        int nY = y;
                        if(isVaildMove(nX, nY, rows, cols)) {
                            maze[x - 1][y] = 0;
                            maze[nX][nY] = 0;
                            depth.push(new Cell(nX, nY));
                        }
                    }
                    case 3 -> {
                        int nX = x + 2;
                        int nY = y;
                        if(isVaildMove(nX, nY, rows, cols)) {
                            maze[x + 1][y] = 0;
                            maze[nX][nY] = 0;
                            depth.push(new Cell(nX, nY));
                        }
                    }
                }
            
            }
        }
        return maze;

    }

    // fisher-yates shuffle which was quite literaly stolen from our card game project lol
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

    // checks to see if the position is a wall
    public static boolean isVaildMove(int x, int y, int rows, int cols) {
        if(x < 0 || y < 0 || x >= rows || y >= cols) {
            return false;
        }
        return true;
    }

    public static void printMaze(int[][] maze) {
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

    public void floodFill(int[][] maze) {
        
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

    public int[] checkOptions(int[] options, int[][] maze, int floodVal) {

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