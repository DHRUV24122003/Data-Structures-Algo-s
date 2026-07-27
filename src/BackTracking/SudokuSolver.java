package BackTracking;

public class SudokuSolver {
    static void main() {
        int[][] board = new int[][]{
                {0, 0, 6, 5, 0, 8, 4, 0, 0},
                {3, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if (solve(board)) {
            display(board);
        } else {
            System.out.println("Cannot solve");
        }

    }


    public static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) {
                return false;

            }
        }
        for (int[] nums : board) { //make an array name nums for the each element of board
            if (nums[col] == num) { //check if col elements are equal to number or not
                return false;
            }
        }
        int sqrt = (int) (Math.sqrt(board.length));
        int rowStart = row - (row % sqrt);
        int colStart = col - (col % sqrt);
        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }
        return true;//great
    }

    public static boolean solve(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false; //empty cell is marked as visited
                    break;

                }
            }
            if (emptyLeft == false) {
                break;
            }
        }
        if (emptyLeft == true) {
            return true;
        }

        //start backtracking
        for (int numbers = 1; numbers <= n; numbers++) {
            if (isSafe(board, row, col, numbers)) {
                board[row][col] = numbers;
                if (solve(board)) {
                    //answer is found
                    return true;
                } else {
                    //backtrack
                    board[row][col] = 0;
                }

            }
        }
        return false;
    }

    public static void display(int[][] board) {
        for (int[] row : board) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();

        }

    }
}

