package BackTracking;



public class SudokuSolverOptimized {

    public static void main(String[] args) {
        int[][] board = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        // Bitmasks for rows, columns and boxes
        int[] rowMask = new int[9];
        int[] colMask = new int[9];
        int[] boxMask = new int[9];

        // Initial board se masks bana lo
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    int num = board[i][j];
                    int bit = 1 << num;          // num ke corresponding bit
                    rowMask[i] |= bit;
                    colMask[j] |= bit;
                    boxMask[(i / 3) * 3 + (j / 3)] |= bit;
                }
            }
        }

        if (solve(board, rowMask, colMask, boxMask)) {
            display(board);
        } else {
            System.out.println("Cannot solve");
        }
    }

    static boolean solve(int[][] board, int[] rowMask, int[] colMask, int[] boxMask) {
        // Empty cell dhoondho
        int row = -1, col = -1;
        boolean foundEmpty = false;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    foundEmpty = true;
                    break;
                }
            }
            if (foundEmpty) break;
        }

        // Agar koi empty cell nahi mili → solved
        if (!foundEmpty) {
            return true;
        }

        int boxIndex = (row / 3) * 3 + (col / 3);

        // 1 se 9 tak try karo
        for (int num = 1; num <= 9; num++) {
            int bit = 1 << num;

            // Check if number already used in row / col / box (O(1) check)
            if ((rowMask[row] & bit) == 0 &&
                    (colMask[col] & bit) == 0 &&
                    (boxMask[boxIndex] & bit) == 0) {

                // Number daalo
                board[row][col] = num;
                rowMask[row] |= bit;
                colMask[col] |= bit;
                boxMask[boxIndex] |= bit;

                // Recurse
                if (solve(board, rowMask, colMask, boxMask)) {
                    return true;
                }

                // Backtrack
                board[row][col] = 0;
                rowMask[row] ^= bit;      // bit hatao
                colMask[col] ^= bit;
                boxMask[boxIndex] ^= bit;
            }
        }

        return false;
    }

    private static void display(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}