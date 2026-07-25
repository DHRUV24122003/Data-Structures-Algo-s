package BackTracking;

import java.util.Arrays;

public class practice {
    public static void AllPaths(String p , boolean [][] maze, int r, int c){
        //first condition
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c])
            return;
        maze[r][c] = false;
        if(r < maze.length-1){
            AllPaths(p +'D' ,maze,r+1,c);
        }
        if(c < maze[0].length-1){
            AllPaths(p +'R' ,maze,r,c+1);
        }
        if(r>0){
            AllPaths(p +'U' ,maze,r-1,c);
        }
        if(c>0){
            AllPaths(p +'L' ,maze,r,c-1);
        }
        maze[r][c] = true;


    }


    public static void PrintMatrix(String p , boolean [][] maze, int r, int c,int [][]path, int step){
        if(r == maze.length-1 && c == maze[0].length-1){
            path[r][c] = step;
            for(int [] arr:path){//
                System.out.println(Arrays.toString(arr));//array values converted to string to print
                 }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[r][c])
            return;

        maze[r][c] = false;
        path[r][c] = step;



        if(r < maze.length-1){
            PrintMatrix(p +'D' ,maze,r+1,c,path,step+1);
        }
        if(c < maze[0].length-1){
            PrintMatrix(p +'R' ,maze,r,c+1,path,step+1);
        }
        if(r>0){
            PrintMatrix(p +'U' ,maze,r-1,c,path,step+1);
        }
        if(c>0){
            PrintMatrix(p +'L' ,maze,r,c-1,path,step+1);
        }
        maze[r][c] = true;//will be updated as true bec
        path[r][c] = 0;//will be updates as 0


    }


    static void main() {
        boolean [][] maze = {
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true},
        };

        int [][] path = new int[maze.length][maze[0].length];

        //AllPaths("",maze,0,0);
        PrintMatrix("",maze,0,0,path,1);




    }

}
