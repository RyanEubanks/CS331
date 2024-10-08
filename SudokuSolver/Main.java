package SudokuSolver;

public class Main {

    public static boolean isValid(int[][] board, int col, int row, int num) {
        // check row
        //! need to make this function check a certain row. not all rows
        for(int i = 0; i < board.length; i++) {
            for(int k = 0; k < board[0].length; k++) {
                if(board[i][k] == num) {
                    System.out.println("its in the row");
                    return false;
                }
            }
        }
        // check column
        for(int i = 0; i < board[0].length; i++) {
            for(int k = 0; k < board.length; k++) {
                if(board[0][i] == num) {
                    System.out.println("its in the col");
                    return false;
                }
            }
        }
        return true;
         
        // check 3x3 square
    }

    public static int[][] solve(int[][] board) {

        int counter = 1;
        for(int k = 0; k < board.length; k++) {
            for(int i = 0; i < board.length; i++) {
                if(board[i][k] != 0) {
                    i++;
                }
                else {
                    board[i][k] = counter;
                    counter++;
                }
            }
        }
        return board;
    }

    public static void printBoard() {

    }

    public static void main(String[] args) {
        int board[][] = { 
            { 0, 0, 6, 5, 0, 8, 4, 0, 0 },
            { 5, 2, 0, 0, 3, 0, 0, 0, 0 },
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
            };

            //System.out.println(isValid(board, 3));
    }
}
