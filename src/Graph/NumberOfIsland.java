package Graph;

public class NumberOfIsland {

    public static int numIslands(char[][] grid) {
        //base case
        if (grid == null || grid.length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);

                }
            }
        }
        return count;
    }

    //DFS function
    public static void dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        //boundary check + water check
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }

        //mark the current land as visited
        grid[i][j] = '0';

        //4 directions me dfs
        dfs(grid, i + 1, j);  //down
        dfs(grid, i - 1, j); //up
        dfs(grid, i, j + 1); //right
        dfs(grid, i, j - 1); // left

    }


    public static void main(String[] args) {
        NumberOfIsland obj = new NumberOfIsland();

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println("Number of Islands: " + obj.numIslands(grid));
    }
}
