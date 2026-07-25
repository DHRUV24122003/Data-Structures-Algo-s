package BackTracking;
import java.util.*;

public class RatInMaze {
    public static void main(String[] args) {
        RatInMaze obj = new RatInMaze();

        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        ArrayList<String> result = obj.ratInMaze(maze);
        System.out.println(result);
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>(); // make a list will be storing final path
        int n =maze.length;//initialize maze row size with n
        //if start or end is blocked then return to the ans
        if(maze[0][0] ==0 || maze[n-1][n-1] ==0){
            return ans;
        }
        boolean[][] visited = new boolean [maze.length][maze[0].length]; // make a matrix which shows elements visited
         solve(0,0," ",maze,visited,ans,n);
         return ans;
    }

    public void solve(int r, int c, String path, int[][] maze,boolean[][]visited, ArrayList<String> ans , int n){
        //if destination is reached
        if(r==n-1 && c==n-1){
            ans.add(path);//add the path to the ans arraylist
            return;
        }
        visited[r][c]=true;//mark current cell as visit
        //directions in lexicographical order - D L R U
        // Down
        if(r+1<n && maze[r+1][c] ==1 && !visited[r+1][c]){
            solve(r+1,c,path+'D',maze,visited,ans ,n);
        }

        //left
        if(c-1>=0 && maze[r][c-1] ==1 && !visited[r][c-1]){
            solve(r,c-1,path+'L',maze,visited,ans ,n);
        }

        //Right
        if(c+1<n&& maze[r][c+1] ==1 && !visited[r][c+1]){
            solve(r,c+1,path+'R',maze,visited,ans ,n);
        }

        //Up
        if(r-1>=0 && maze[r-1][c] ==1 && !visited[r-1][c]){
            solve(r-1,c,path+'U',maze,visited,ans ,n);
        }
        visited[r][c]=false;

    }


}
