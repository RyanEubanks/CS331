package ProjectStacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MazeGenerator {
    private final int width, height;
    private final char[][] grid;
    private final Cell[][] cells;
    private final Random random = new Random();

    public MazeGenerator(int size) {
        this(size, size);
    }

    public MazeGenerator(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new char[width * 2 + 1][height * 2 + 1];
        cells = new Cell[width][height];
        initCells();
        generateMaze();
        buildGrid();
    }

    private void initCells() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(x, y);
            }
        }
    }

    private void generateMaze() {
        ArrayList<Cell> stack = new ArrayList<>();
        Cell start = cells[0][0];
        start.open = false;
        stack.add(start);

        while (!stack.isEmpty()) {
            Cell current = stack.remove(stack.size() - 1);
            ArrayList<Cell> neighbors = getUnvisitedNeighbors(current);

            if (!neighbors.isEmpty()) {
                stack.add(current);
                Cell next = neighbors.get(random.nextInt(neighbors.size()));
                current.addNeighbor(next);
                next.open = false;
                stack.add(next);
            }
        }
    }

    private ArrayList<Cell> getUnvisitedNeighbors(Cell cell) {
        ArrayList<Cell> neighbors = new ArrayList<>();
        for (int[] dir : new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}) {
            Cell neighbor = getCell(cell.x + dir[0], cell.y + dir[1]);
            if (neighbor != null && neighbor.open) {
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }

    public Cell getCell(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height) ? cells[x][y] : null;
    }

    private void buildGrid() {
        // Fill grid with walls
        for (int x = 0; x < width * 2 + 1; x++) {
            for (int y = 0; y < height * 2 + 1; y++) {
                grid[x][y] = (x % 2 == 0 && y % 2 == 0) ? ' ' : 'X'; // Set walls
            }
        }

        // Create paths
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int gridX = x * 2 + 1;
                int gridY = y * 2 + 1;
                grid[gridX][gridY] = ' '; // Set cell path

                if (cells[x][y].hasNeighborBelow()) {
                    grid[gridX + 1][gridY] = ' '; // Path down
                }
                if (cells[x][y].hasNeighborRight()) {
                    grid[gridX][gridY + 1] = ' '; // Path right
                }
            }
        }
    }

    private class Cell {
        int x, y;
        ArrayList<Cell> neighbors = new ArrayList<>();
        boolean open = true;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void addNeighbor(Cell neighbor) {
            neighbors.add(neighbor);
            neighbor.neighbors.add(this);
        }

        boolean hasNeighborBelow() {
            return getCell(x, y + 1) != null && getCell(x, y + 1).open;
        }

        boolean hasNeighborRight() {
            return getCell(x + 1, y) != null && getCell(x + 1, y).open;
        }
    }

    public void draw() {
        for (char[] row : grid) {
            System.out.println(new String(row));
        }
    }

    public static void main(String[] args) {
        MazeGenerator maze = new MazeGenerator(10); // Adjust size as needed
        maze.draw();
    }
}
