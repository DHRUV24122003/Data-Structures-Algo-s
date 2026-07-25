package BackTracking;



import java.util.Arrays;

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[board.length][board[0].length];
        allPathPrint("", board, 0, 0, path, 1);//steps will be starting from 1
        //allPath("", board, 0, 0);
    }

    static void allPath(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);//print the path of the string
            return;
        }

        if (!maze[r][c]) {//if there is blocked or false element then return
            return;
        }

        // i am considering this block in my path
        maze[r][c] = false;//mark it as false once it is visited so that when we return wo don't visit the same element when it's already their in the same path



        if (r < maze.length - 1) { //start with current row lesser then length of the row in maze
            allPath(p + 'D', maze, r+1, c);
        }

        if (c < maze[0].length - 1) {
            allPath(p + 'R', maze, r, c+1);
        }

        if (r > 0) {
            allPath(p + 'U', maze, r-1, c);
        }

        if (c > 0) {
            allPath(p + 'L', maze, r, c-1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        maze[r][c] = true;//once one iteration is completed mark the elements as true so in the other path they can be used
    }



    static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;//initialize it as step which will be marking the visited elements in sequence
            for(int[] arr : path) {
                System.out.println(Arrays.toString(arr));//convert each elements of the path into string so that they can be printed
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        // i am considering this block in my path
        maze[r][c] = false; //mark false once visited in one path
        path[r][c] = step;//initialize
        if (r < maze.length - 1) {
            allPathPrint(p + 'D', maze, r+1, c, path, step+1);//update the step by one after each element of pth is visited
        }

        if (c < maze[0].length - 1) {
            allPathPrint(p + 'R', maze, r, c+1, path, step+1);
        }

        if (r > 0) {
            allPathPrint(p + 'U', maze, r-1, c, path, step+1);
        }

        if (c > 0) {
            allPathPrint(p + 'L', maze, r, c-1, path, step+1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        maze[r][c] = true;//remove the false tag you put before
        path[r][c] = 0;//step number removed for other paths
    }
}