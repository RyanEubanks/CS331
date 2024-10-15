package ProjectStacksV2;

public class Creature {
    
    private int row;
    private int col;
    //private boolean visited;
    
    public Creature(int row, int col) {
        this.row = row;
        this.col = col;
        //this.visited = false;
    }
    
    public void moveUp() {
        row--;
    }
    
    public void moveDown() {
        row++;
    }
    
    public void moveLeft() {
        col--;
    }
    
    public void moveRight() {
        col++;
    }
    
    public int[] getCoordinates() {
        return new int[]{row, col};
    }

    public int getRow() {
        return row;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public int getCol() {
        return col;
    }
    
    public void setCol(int col) {
        this.col = col;
    }

    /* 
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    */

}
